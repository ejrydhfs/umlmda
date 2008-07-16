package org.umlmda.generator.anttask;

import org.apache.tools.ant.types.DataType;

/**
 * Specification of the path where to look for templates
 * @author Dieter Moroff
 */
public class TemplateDirectory extends DataType {
   private String dir = null;
   
   public TemplateDirectory() {
      super();
   }

   /**
    * @return Returns the dir.
    */
   public String getDir() {
      return dir;
   }

   /**
    * @param dir The dir to set.
    */
   public void setDir(String dir) {
      this.dir = dir;
   }


}
