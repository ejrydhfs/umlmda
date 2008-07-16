//jUMLMDA, GeneratorBase-API
//
//$Header: /cvsroot/umlmda/UMLGenerator/src/org/umlmda/uml/generator/java/JavaWriterHelper.java,v 1.3 2006/07/10 15:37:12 moroff Exp $
//$Source: /cvsroot/umlmda/UMLGenerator/src/org/umlmda/uml/generator/java/JavaWriterHelper.java,v $
//$Revision: 1.3 $
//$State: Exp $
// $Name:  $
// $Date: 2006/07/10 15:37:12 $
//$Locker:  $
//
//This library is free software; you can redistribute it and/or
//modify it under the terms of the GNU Library General Public
//License as published by the Free Software Foundation; either
//version 2 of the License, or (at your option) any later version.
//This library is distributed in the hope that it will be useful,
//but WITHOUT ANY WARRANTY; without even the implied warranty of
//MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
//Library General Public License for more details.
//
//You should have received a copy of the GNU Library General Public
//License along with this library; if not, write to the
//Free Software Foundation, Inc., 59 Temple Place - Suite 330,
//Boston, MA  02111-1307, USA. The text of license can be also found
//at http://www.gnu.org/copyleft/lgpl.html
//
//Original author: Volker Pussel
//Created on:      12.10.2005
package org.umlmda.uml.generator.java;

import java.util.Iterator;
import java.util.List;

import org.umlmda.generator.model.util.IClassHelper;

import org.umlmda.model.uml.ModelClass;
import org.umlmda.model.uml.ModelPackage;

/**
 * @author pussel
 *
 * Helper class for common pieces of java statements
 */
public class JavaWriterHelper {

	static private String _writeImports( IClassHelper classHelper, List referencedTypes, String packageName) {
		StringBuffer buffer = new StringBuffer();
		for ( Iterator iter = referencedTypes.iterator(); iter.hasNext(); ) {
	      ModelClass modelClass = (ModelClass)iter.next();
	      if ( !packageName.equals(modelClass.getPackage().getQualifiedName())) {
	      	buffer.append( "import ");
	      	buffer.append( classHelper.getType(modelClass));
	      	buffer.append( ";\n");
	      }
		} // for
		return buffer.toString();
	}

	/**
	 * write the list of import statements for referenced types
	 * if they do not belong to the same package like the given class 
	 * @param modelClass the class to be declared
	 * @return
	 */
	static public String writeImports( ModelClass mClass, IClassHelper classHelper) {
		return _writeImports( classHelper, mClass.getReferencedTypes(), mClass.getPackage().getQualifiedName());
	}

	/**
	 * write the list of import statements for referenced types
	 * if they do not belong to the same package like the given class 
	 * @param modelPackage the package for which a helper class is to be declared
	 * @return
	 */
	static public String writeImports( ModelPackage mPackage, IClassHelper classHelper) {
		return _writeImports( classHelper, mPackage.getReferencedClasses(), mPackage.getQualifiedName());
	}

}
