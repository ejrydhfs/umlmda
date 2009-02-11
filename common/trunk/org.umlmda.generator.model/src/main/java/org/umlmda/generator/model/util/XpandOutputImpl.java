package org.umlmda.generator.model.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openarchitectureware.expression.ast.SyntaxElement;
import org.openarchitectureware.xpand2.XpandExecutionContext;
import org.openarchitectureware.xpand2.output.Outlet;
import org.openarchitectureware.xpand2.output.Output;

public class XpandOutputImpl implements Output {
   List<SyntaxElement> stack = new ArrayList<SyntaxElement>();
   File file;
   FileWriter writer;
   String outputFolder;
   
   public XpandOutputImpl() {
      
   }

   public void closeFile() {
      try {
         if ( writer != null ) {
            writer.close();
         }
         writer = null;
      } catch (IOException e) {
         throw new RuntimeException(e);
      }
   }

   public void openFile(String path, String fileMode) {
      try {
         // Ignore given path
         String name = path.lastIndexOf("/") >= 0 ? path.substring(path.lastIndexOf("/")+1) : path;
         file = new File(outputFolder, name);
         writer = new FileWriter(file);
      } catch (IOException e) {
         throw new RuntimeException(e);
      }
   }

   public SyntaxElement popStatement() {
      return stack.get(0);
   }

   public void pushStatement(SyntaxElement stmt, XpandExecutionContext ctx) {
      stack.add(0, stmt);
   }

   public void write(String bytes) {
      try {
         if ( writer != null ) {
            writer.write(bytes);
         }
      } catch (IOException e) {
         throw new RuntimeException(e);
      }
   }

   public void setOutputFolder(String outputFolder) {
      this.outputFolder = outputFolder;
   }

   public void addOutlet(Outlet outlet) {
      // TODO Auto-generated method stub
      
   }
}
