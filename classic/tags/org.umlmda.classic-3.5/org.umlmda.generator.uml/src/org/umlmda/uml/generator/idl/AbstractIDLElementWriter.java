// jUMLMDA, GeneratorBase-API
//  
//   $Header: /cvsroot/umlmda/UMLGenerator/src/org/umlmda/uml/generator/idl/AbstractIDLElementWriter.java,v 1.2 2005/10/27 19:01:19 moroff Exp $
//   $Source: /cvsroot/umlmda/UMLGenerator/src/org/umlmda/uml/generator/idl/AbstractIDLElementWriter.java,v $
// $Revision: 1.2 $
//    $State: Exp $
//     $Name:  $
//     $Date: 2005/10/27 19:01:19 $
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
// Created on:      06.10.2004
package org.umlmda.uml.generator.idl;

import org.umlmda.generator.AbstractEmbeddedClassWriter;

import org.umlmda.model.uml.ModelClassifier;

/**
 * @author moroff
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public abstract class AbstractIDLElementWriter extends AbstractEmbeddedClassWriter {
   
   public AbstractIDLElementWriter() {
      super();
      setClassHelper(new IDLClassHelper());
      setMethodHelper(new IDLMethodHelper(getClassHelper()));
   }

   /* (non-Javadoc)
    * @see net.sourceforge.umlmda.generator.IClassWriter#getClassName(net.sourceforge.umlmda.xmi.uml.ModelClassifier)
    */
   public String getClassName(ModelClassifier modelClassifier) {
      return modelClassifier.getName();
   }

}


//-------------------------------------------------------------------------
//$Log: AbstractIDLElementWriter.java,v $
//Revision 1.2  2005/10/27 19:01:19  moroff
//net.sourceforge.umlmda renamed to org.umlmda
//
//Revision 1.1  2005/10/20 21:20:29  moroff
//More refactoring, make java templates more flexible.
//
//Revision 1.4  2005/03/13 17:10:52  moroff
//Avoid dependency c++ from idl writers
//
//Revision 1.3  2005/03/10 21:21:56  moroff
//Bugfix #1146208: mapping IDL types
//
//Revision 1.2  2004/12/08 22:10:07  moroff
//Handle model attributes without types (from analysis models)
//
//Revision 1.1  2004/10/06 19:41:05  moroff
//* Supporting CORBA (IDL) writers
//
//-------------------------------------------------------------------------