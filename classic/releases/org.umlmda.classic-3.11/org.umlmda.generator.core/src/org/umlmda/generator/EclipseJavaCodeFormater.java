package org.umlmda.generator;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.jdt.core.ToolFactory;
import org.eclipse.jdt.core.formatter.CodeFormatter;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.IDocument;
import org.eclipse.text.edits.MalformedTreeException;
import org.eclipse.text.edits.TextEdit;
import org.umlmda.generator.model.util.Feedback;

public class EclipseJavaCodeFormater implements Formatter {
   private CodeFormatter codeFormatter;

   private Properties formatterProperties;

   private final Feedback logger;

   public EclipseJavaCodeFormater(Feedback feedback) {
      this.logger = feedback;
   }
   
   public boolean isBufferFormattingSupported() {
      return true;
   }

   public boolean isFileFormattingSupported() {
      // TODO Change to true if format(File) is implemented
      return false;
   }
   
   private CodeFormatter getCodeFormatter() {
      if ( codeFormatter == null ) {
         
         // Create default properties if required
         if ( formatterProperties == null ) {
            configure(null);
         }
      }
      
      codeFormatter = ToolFactory.createCodeFormatter(formatterProperties);
      return codeFormatter;
   }
   
   public void configure(URL configuration) {
      formatterProperties = new Properties();
      if ( configuration != null ) {
         InputStream is = null;
         try {
            is = configuration.openStream();
            if (configuration.toExternalForm().endsWith(".xml")) {
               Pattern pattern = Pattern.compile("<setting id=\"([^\"]*)\" value=\"([^\"]*)\"\\/>");
               BufferedReader reader = new BufferedReader(new InputStreamReader(is));
               for (String line = reader.readLine(); line != null; line = reader.readLine()) {
                  Matcher matcher = pattern.matcher(line);
                  if (matcher.matches()) {
                     formatterProperties.put(matcher.group(1), matcher.group(2));
                  }
               }
            }
            else {
               BufferedInputStream stream = new BufferedInputStream(is);
               formatterProperties.load(stream);
            }
            
            logger.message(Feedback.INFO, "load configuration from "+configuration.toExternalForm());
         } catch (IOException e) {
            String msg = "Error loading configuration " + configuration.toExternalForm();
            logger.message(Feedback.ERROR, e.getMessage()+msg);
            throw new RuntimeException(msg, e);
         } finally {
            if (is != null) {
               try {
                  is.close();
               } catch (IOException e) {
                  logger.message(Feedback.ERROR, e.getMessage());
               }
            }
         }
      }
      
      // add some settings for the compiler options
      // which are not included in the Eclipse code style settings
      // to make the code formatter working
      // see https://bugs.eclipse.org/bugs/show_bug.cgi?id=222736
      if (formatterProperties.get("org.eclipse.jdt.core.compiler.compliance") == null) {
         formatterProperties.put("org.eclipse.jdt.core.compiler.compliance", "1.5");
      }
      if (formatterProperties.get("org.eclipse.jdt.core.compiler.codegen.targetPlatform") == null) {
         formatterProperties.put("org.eclipse.jdt.core.compiler.codegen.targetPlatform", "1.5");
      }
      if (formatterProperties.get("org.eclipse.jdt.core.compiler.source") == null) {
         formatterProperties.put("org.eclipse.jdt.core.compiler.source", "1.5");
      }
   }

   public boolean format(File sourceToFormat) {
      BufferedReader sourceReader = null;
      boolean formattingDone = false;
      
      try {
         // Read the file
         StringBuffer inputBuffer = new StringBuffer();
         String line;
         
         sourceReader = new BufferedReader(new FileReader(sourceToFormat));
         do {
            line = sourceReader.readLine();
            if ( line != null ) {
               inputBuffer.append(line);
               inputBuffer.append("\n");
            }
         } while ( line != null );
         sourceReader.close();

         // Format
         String formattedOutput = format(sourceToFormat.getAbsolutePath(), inputBuffer.toString());
         
         // On sucessful formatting, write back again
         if ( formattedOutput != null ) {
            sourceToFormat.delete();
            FileWriter targetWriter = new FileWriter(sourceToFormat);
            targetWriter.append(formattedOutput);
            targetWriter.close();
            formattingDone = true;
         }
      } catch (FileNotFoundException e) {
         logger.message(Feedback.ERROR, sourceToFormat.getAbsolutePath()+": "+e.getMessage());
         throw new RuntimeException(e);
      } catch (IOException e) {
         logger.message(Feedback.ERROR, sourceToFormat.getAbsolutePath()+": "+e.getMessage());
         throw new RuntimeException(e);
      } finally {
         if ( sourceReader != null ) {
            try {
               sourceReader.close();
            } catch (IOException e) {
               logger.message(Feedback.ERROR, e.getMessage());
            }
         }
      }
      
      return formattingDone;
   }

   public String format(String targetfilePath, String unformattedInput) {
      String formattedOutput = null;
      IDocument doc = new Document(unformattedInput);
      TextEdit edit = getCodeFormatter().format(CodeFormatter.K_COMPILATION_UNIT, doc.get(), 0, doc.get().length(), 0, null);
      
      // check if text formatted successfully
      if (edit != null) {
          try {
              edit.apply(doc);
              formattedOutput = doc.get();
          } catch (MalformedTreeException e) {
              logger.message(Feedback.WARNING, "Error during code formatting. Illegal code edit tree (" + e.getMessage() + ").");
          } catch (BadLocationException e) {
              logger.message(Feedback.WARNING, "Error during code formatting. Bad location (" + e.getMessage() + ").");
          }
      } else {
          logger.message(Feedback.WARNING, "File " + targetfilePath + " could not be formatted. Make sure your template produces legal Java code!");
      }

      return formattedOutput;
   }
}
