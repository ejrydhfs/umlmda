//jUMLMDA, UMLModel-API
//
//$Header: /cvsroot/umlmda/UMLGenerator/src/org/umlmda/uml/generator/xml/XMLModelClassAdapter.java,v 1.3 2005/11/23 09:49:09 moroff Exp $
//$Source: /cvsroot/umlmda/UMLGenerator/src/org/umlmda/uml/generator/xml/XMLModelClassAdapter.java,v $
//$Revision: 1.3 $
// $State: Exp $
//  $Name:  $
//  $Date: 2005/11/23 09:49:09 $
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
//Created on Jun 15, 2005
package org.umlmda.uml.generator.xml;

import org.umlmda.model.uml.Model;
import org.umlmda.model.uml.ModelClass;
import org.umlmda.model.uml.ModelClassBase;
import org.umlmda.model.uml.ModelPackage;
import org.umlmda.model.uml.impl.ModelClassAdapter;

import org.umlmda.profile.ModelStereotype;
import org.umlmda.uml.generator.java.JavaModelClassAdapter;

/**
 * XML schema adapter for model classes.
 * 
 * @author vpussel
 */
public class XMLModelClassAdapter extends JavaModelClassAdapter implements
		ModelClass {

	public XMLModelClassAdapter(ModelClassBase modelClass, Model model) {
		super(modelClass, model);
	}

	/**
	 * return the class type name, qualified with the business component it belongs to  
    */
	public String getQualifiedName() {
		
		String qname = getName();
		ModelPackage pkg = null;
		for(pkg = getPackage(); pkg != null; pkg = pkg.getPackage())
			if (pkg.hasStereotype(ModelStereotype.BUSINESS_COMPONENT))
				break;

		// if model element belongs to package, qualify name
		if (pkg != null)
			qname = pkg.getName() + ":" + qname;

		return qname;
	}

}
