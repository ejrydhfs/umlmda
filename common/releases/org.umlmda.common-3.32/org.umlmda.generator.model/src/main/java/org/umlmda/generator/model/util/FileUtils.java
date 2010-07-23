// UMLMDA, GeneratorBase-API
//  
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
package org.umlmda.generator.model.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.lang.StringUtils;

/**
 * Collection of utilites for file and directory access
 * 
 * @author moroff
 */
public class FileUtils
{
   static public final String newLine = System.getProperty("line.separator", "\n");

   /**
    * Copy a file, if the destination directory does not exist it will be created
    * 
    * @param sourceFile
    * @param destFile
    * @throws IOException
    * @author Dieter Moroff
    */
   static public void copyFile(File sourceFile, File destFile) throws IOException {
      copyFile(sourceFile, destFile, false);
   }

   static public void copyFile(File sourceFile, File destFile, boolean preserveLastModified) throws IOException {

      if ( destFile.exists() && destFile.isFile() ) {
         destFile.delete();
      }

      // ensure that parent dir of dest file exists!
      // not using getParentFile method to stay 1.1 compat
      File parent = destFile.getParentFile();
      if ( !parent.exists() ) {
         parent.mkdirs();
      }

      FileInputStream in = null;
      FileOutputStream out = null;
      try {
         in = new FileInputStream(sourceFile);
         out = new FileOutputStream(destFile);

         byte[] buffer = new byte[8 * 1024];
         int count = 0;
         do {
            out.write(buffer, 0, count);
            count = in.read(buffer, 0, buffer.length);
         } while ( count != -1 );
      }
      finally {
         if ( out != null ) {
            out.close();
         }
         if ( in != null ) {
            in.close();
         }
      }

      if ( preserveLastModified ) {
         destFile.setLastModified(sourceFile.lastModified());
      }
   }

   /**
    * @param file
    * @return
    */
   public static String getExtension(File file) {
      String fileName = file.getName();
      int extStartPos = fileName.lastIndexOf(".");

      if ( extStartPos >= 0 ) {
         return fileName.substring(extStartPos + 1);
      }
      else {
         return StringUtils.EMPTY;
      }
   }

}