// jUMLMDA, GeneratorBase-API
//  
//   $Header: /cvsroot/umlmda/GeneratorBase/src/org/umlmda/generator/GeneratorRuntimeConfig.java,v 1.3 2005/11/10 11:37:34 moroff Exp $
//   $Source: /cvsroot/umlmda/GeneratorBase/src/org/umlmda/generator/GeneratorRuntimeConfig.java,v $
// $Revision: 1.3 $
//    $State: Exp $
//     $Name: oAW $
//     $Date: 2005/11/10 11:37:34 $
//   $Locker:  $
//
// This library is free software; you can redistribute it and/or
// modify it under the terms of the GNU Library General Public
// License as published by the Free Software Foundation; either
// version 2 of the License, or (at your option) any later version.
// This library is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
// Library General Public License for more details.
//
// You should have received a copy of the GNU Library General Public
// License along with this library; if not, write to the
// Free Software Foundation, Inc., 59 Temple Place - Suite 330,
// Boston, MA  02111-1307, USA. The text of license can be also found
// at http://www.gnu.org/copyleft/lgpl.html
// 
// Original author: Dieter Moroff (moroff@users.sourceforge.net)
// Created on:      23.07.2003
package org.umlmda.generator;

/**
 * Holds the configuration setting for the generator tools
 * @author Dieter Moroff
 */
public class GeneratorRuntimeConfig {

   public static final String GENERATED_EYECATCHER = "Generated file";

   public static final String BEGIN_EYECATCHER = "UserSection-Begin";

   public static final String END_EYECATCHER = "UserSection-End";

   public static final String OBSOLETE_EYECATCHER = "Obsolete-UserSections";

   public static final String EYECATCHER_PREFIX = "@@";
   
   /**
       * Default name of the subfolder for the merged file before 
       * copied to the source folder if different after merge or
       * deleted.
       */
   public static final String MERGED_FOLDER = "./merged";

   /**
       * Default name of the subfolder for the new generated files
       */
   public static final String GENERATED_FOLDER = "./generated";

   private String generatedEyecatcher = GENERATED_EYECATCHER;
   private String beginEyecatcher = BEGIN_EYECATCHER;
   private String endEyecatcher = END_EYECATCHER;
   private String obsoleteEyecatcher = OBSOLETE_EYECATCHER;
   private String eyecatcherPrefix = EYECATCHER_PREFIX;
   
   /**
    * 
    */
   public GeneratorRuntimeConfig() {
      setDefaults();
   }
   
   /**
    * Set the configs default values
    */
   public void setDefaults() {
      generatedEyecatcher = GENERATED_EYECATCHER;
      beginEyecatcher = BEGIN_EYECATCHER;
      endEyecatcher = END_EYECATCHER;
      obsoleteEyecatcher = OBSOLETE_EYECATCHER;
      eyecatcherPrefix = EYECATCHER_PREFIX;
   }

   /**
       * Name of the source folder, which contains the original files with
       * the modified usersections
       */
   protected String sourceFolder;

   /**
       * Name of the merged folder, @see #MERGED_FOLDER
       */
   protected String mergedFolder = MERGED_FOLDER;

   /**
       * Name of the generated files, @see #GENERATED_FOLDER
       */
   protected String generatedFolder = GENERATED_FOLDER;

   /**
       * @return
       */
   public String getGeneratedEyecatcher() {
      return generatedEyecatcher;
   }

   /**
       * @return
       */
   public String getMergedFolder() {
      return mergedFolder;
   }

   /**
       * @return
       */
   public String getObsoleteEyecatcher() {
      return obsoleteEyecatcher;
   }

   /**
       * @return
       */
   public String getSourceFolder() {
      return sourceFolder;
   }

   /**
       * @param string
       */
   public void setGeneratedEyecatcher(String string) {
      generatedEyecatcher = string;
   }

   /**
       * @param string
       */
   public void setMergedFolder(String string) {
      mergedFolder = string;
   }

   /**
       * @param string
       */
   public void setObsoleteEyecatcher(String string) {
      obsoleteEyecatcher = string;
   }

   /**
       * @param string
       */
   public void setSourceFolder(String string) {
      sourceFolder = string;
   }

   /**
    * @return
    */
   public String getBeginEyecatcher() {
      return beginEyecatcher;
   }

   /**
    * @return
    */
   public String getEndEyecatcher() {
      return endEyecatcher;
   }

   /**
    * @return
    */
   public String getGeneratedFolder() {
      return generatedFolder;
   }

   /**
    * @param string
    */
   public void setBeginEyecatcher(String string) {
      beginEyecatcher = string;
   }

   /**
    * @param string
    */
   public void setEndEyecatcher(String string) {
      endEyecatcher = string;
   }

   /**
    * @param string
    */
   public void setGeneratedFolder(String string) {
      generatedFolder = string;
   }

   /**
    * @return Returns the eyecatcherPrefix.
    */
   public String getEyecatcherPrefix() {
      return eyecatcherPrefix;
   }
   /**
    * @param eyecatcherPrefix The eyecatcherPrefix to set.
    */
   public void setEyecatcherPrefix(String eyecatcherPrefix) {
      this.eyecatcherPrefix = eyecatcherPrefix;
   }
}
