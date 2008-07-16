// jUMLMDA, GeneratorBase-API
//  
//   $Header: /cvsroot/umlmda/UMLGenerator/src/org/umlmda/uml/generator/idl/AbstractIDLWriter.java,v 1.4 2006/07/10 15:37:11 moroff Exp $
//   $Source: /cvsroot/umlmda/UMLGenerator/src/org/umlmda/uml/generator/idl/AbstractIDLWriter.java,v $
// $Revision: 1.4 $
//    $State: Exp $
//     $Name:  $
//     $Date: 2006/07/10 15:37:11 $
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
package org.umlmda.uml.generator.idl;


import org.umlmda.generator.AbstractPackageWriter;
import org.umlmda.generator.model.util.IClassHelper;
import org.umlmda.generator.model.util.IMethodHelper;
import org.umlmda.profile.ModelTaggedValues;


/**
 * Baseclass for all writers which generate CORBA IDL-Files
 * @author moroff
 */
public abstract class AbstractIDLWriter extends AbstractPackageWriter {

   /**
    * @param classHelper
    * @param methodHelper
    */
   public AbstractIDLWriter() {
      super(new IDLClassHelper(), new IDLMethodHelper());
   }

   public String getModuleName() {
      return getModelPackage().getTaggedValues().getProperty(ModelTaggedValues.CORBA_MODULE, getModelPackage().getName());
   }
   
}


//-------------------------------------------------------------------------
//$Log: AbstractIDLWriter.java,v $
//Revision 1.4  2006/07/10 15:37:11  moroff
//Refactoring base functionality to org.umlmda.generator.model
//
//Revision 1.3  2005/10/28 16:29:48  moroff
//Finished 2.0 refactorings
//
//Revision 1.2  2005/10/27 19:01:19  moroff
//net.sourceforge.umlmda renamed to org.umlmda
//
//Revision 1.1  2005/10/20 21:20:29  moroff
//More refactoring, make java templates more flexible.
//
//Revision 1.7  2005/09/29 14:55:16  vpussel
//use tagged values from umlmda profile
//
//Revision 1.6  2005/09/29 09:29:40  vpussel
//use accessor for modelPackage
//
//Revision 1.5  2005/06/09 13:31:49  moroff
//Bugfix #1187205: idl name from package
//
//Revision 1.4  2005/06/09 13:00:51  moroff
//getName() in ModelPackage returns unqualified name, getBaseName() removed.
//
//Revision 1.3  2004/12/08 22:08:56  moroff
//Remove unused imports
//
//Revision 1.2  2004/10/09 20:32:29  moroff
//write IDLs to root Folder
//
//Revision 1.1  2004/10/06 19:41:05  moroff
//* Supporting CORBA (IDL) writers
//
//-------------------------------------------------------------------------