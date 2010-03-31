package org.umlmda.generator;

import java.net.URL;

import org.umlmda.generator.model.util.Feedback;

public class EclipseJavaFormatterProvider implements FormatterProvider {
   private URL configuration;
   private String[] extensions = new String[] { ".java" };
   
   public Formatter createFormatter(Feedback feedback) {
      // TODO Auto-generated method stub
      return null;
   }

   public URL getConfiguration() {
      return configuration;
   }

   public String[] getExtensionsApplyableFor() {
      return extensions;
   }

   public String getName() {
      // TODO Auto-generated method stub
      return null;
   }

   public void setConfiguration(URL configuration) {
      this.configuration = configuration;
   }

   public void setExtensionsApplyableFor(String[] extensionArray) {
      this.extensions = extensionArray;

   }

}
