/*
 *   $Header: /cvsroot/umlmda/GeneratorBase/src/org/umlmda/generator/anttask/FileExtension.java,v 1.1.2.2 2008/01/21 14:57:29 moroff Exp $
 *   $Source: /cvsroot/umlmda/GeneratorBase/src/org/umlmda/generator/anttask/FileExtension.java,v $
 * $Revision: 1.1.2.2 $
 *     $Name:  $
 *     $Date: 2008/01/21 14:57:29 $
 * 
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Library General Public
 * License as published by the Free Software Foundation; either
 * version 2 of the License, or (at your option) any later version.
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Library General Public License for more details.
 * 
 * You should have received a copy of the GNU Library General Public
 * License along with this library; if not, write to the
 * Free Software Foundation, Inc., 59 Temple Place - Suite 330,
 * Boston, MA  02111-1307, USA. The text of license can be also found
 * at http://www.gnu.org/copyleft/lgpl.html
 * 
 * Created on 16.04.2007 (Dieter Moroff)
 */
package org.umlmda.generator.anttask;

import org.apache.commons.lang.StringUtils;
import org.apache.tools.ant.types.DataType;

/**
 * @author MOROFF
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class FileExtension extends DataType {
   String extension = StringUtils.EMPTY;
   
   /**
    * 
    */
   public FileExtension() {
      super();
   }

   
   /**
    * @return
    */
   public String getExtension() {
      return extension;
   }

   /**
    * @param extension The extension to set.
    */
   public void setExtension(String extension) {
      this.extension = extension;
   }
   
   public void addText(String text) {
      extension = extension + text;
   }
}
