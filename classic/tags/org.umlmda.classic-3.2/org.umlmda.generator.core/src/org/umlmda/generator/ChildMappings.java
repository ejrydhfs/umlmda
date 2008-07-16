// jUMLMDA, GeneratorBase-API
//  
//   $Header: /cvsroot/umlmda/GeneratorBase/src/org/umlmda/generator/ChildMappings.java,v 1.1 2005/10/26 13:03:37 moroff Exp $
//   $Source: /cvsroot/umlmda/GeneratorBase/src/org/umlmda/generator/ChildMappings.java,v $
// $Revision: 1.1 $
//    $State: Exp $
//     $Name:  $
//     $Date: 2005/10/26 13:03:37 $
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
// Created on:      05.10.2004
package org.umlmda.generator;

import java.util.Properties;

/**
 * @author moroff
 */
public class ChildMappings {
   private final String writerName;
   private final Properties mappings = new Properties();
   
   /**
    * 
    */
   public ChildMappings(String writerName) {
      super();
      this.writerName = writerName;
   }

   public void addMapping(String stereotype, String writerName) {
      mappings.put(stereotype, writerName);
   }
   
   /**
    * @return
    */
   public String getWriterName() {
      return writerName;
   }

   /**
    * Returns writername for given stereotype
    */
   public String getMapping(String stereotype) {
      return mappings.getProperty(stereotype);
   }

   /* (non-Javadoc)
    * @see java.lang.Object#equals(java.lang.Object)
    */
   public boolean equals(Object obj) {
      if (obj instanceof ChildMappings) {
         ChildMappings mappings = (ChildMappings) obj;
         
         return writerName.equals(mappings.writerName);
      }
      else {
         return writerName.equals(obj);
      }
   }

   /* (non-Javadoc)
    * @see java.lang.Object#hashCode()
    */
   public int hashCode() {
      return writerName.hashCode();
   }

}


//-------------------------------------------------------------------------
//$Log: ChildMappings.java,v $
//Revision 1.1  2005/10/26 13:03:37  moroff
//* Refactoring package names to org.umlmda
//* Generator configuration based on profiles and sets
//
//Revision 1.1  2004/10/06 19:38:47  moroff
//* Supporting embedded writers
//
//-------------------------------------------------------------------------