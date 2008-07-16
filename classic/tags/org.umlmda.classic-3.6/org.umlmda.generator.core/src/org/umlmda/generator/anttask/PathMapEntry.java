// jUMLMDA, GeneratorBase-API
//  
//   $Header: /cvsroot/umlmda/GeneratorBase/src/org/umlmda/generator/anttask/PathMapEntry.java,v 1.1 2005/10/26 12:57:57 moroff Exp $
//   $Source: /cvsroot/umlmda/GeneratorBase/src/org/umlmda/generator/anttask/PathMapEntry.java,v $
// $Revision: 1.1 $
//    $State: Exp $
//     $Name:  $
//     $Date: 2005/10/26 12:57:57 $
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
// Created on:      03.11.2003
package org.umlmda.generator.anttask;

import org.apache.tools.ant.types.DataType;

/**
 * @author moroff
 *
 * To change the template for this generated type comment go to
 * Window>Preferences>Java>Code Generation>Code and Comments
 */
public class PathMapEntry extends DataType {
   private String entry;
   private String path;
   
   public PathMapEntry() {
      super();
   }


   /**
    * @return
    */
   public String getEntry() {
      return entry;
   }

   /**
    * @return
    */
   public String getPath() {
      return path;
   }

   /**
    * @param string
    */
   public void setEntry(String entry) {
      this.entry = entry;
   }

   /**
    * @param string
    */
   public void setPath(String path) {
      this.path = path;
   }

}
