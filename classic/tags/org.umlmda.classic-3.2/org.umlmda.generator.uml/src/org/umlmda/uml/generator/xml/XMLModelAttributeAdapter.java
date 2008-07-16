//jUMLMDA, UMLModel-API
//
//$Header: /cvsroot/umlmda/UMLGenerator/src/org/umlmda/uml/generator/xml/XMLModelAttributeAdapter.java,v 1.2 2005/10/27 19:01:18 moroff Exp $
//$Source: /cvsroot/umlmda/UMLGenerator/src/org/umlmda/uml/generator/xml/XMLModelAttributeAdapter.java,v $
//$Revision: 1.2 $
// $State: Exp $
//  $Name:  $
//  $Date: 2005/10/27 19:01:18 $
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
//Created on Jun 14, 2005
package org.umlmda.uml.generator.xml;

import org.umlmda.model.uml.Model;
import org.umlmda.model.uml.ModelAttribute;
import org.umlmda.model.uml.ModelAttributeBase;
import org.umlmda.model.uml.ModelDataType;
import org.umlmda.model.uml.impl.ModelAttributeAdapter;

/**
 * XML schema adapter for model attributes.
 * 
 * @author vpussel
 */
public class XMLModelAttributeAdapter extends ModelAttributeAdapter implements
		ModelAttribute {

	public XMLModelAttributeAdapter(ModelAttributeBase modelAttribute, Model model) {
		super(modelAttribute, model);
	}

	/** (non-Javadoc)
	 * @see net.sourceforge.umlmda.xmi.uml.impl.ModelAttributeAdapter#isPrimitiveType()
	 */
	public boolean isPrimitiveType() {
		boolean result = false;
		if (super.isPrimitiveType()) {
			result = true;
		} else {
			String type = super.getType();
			if (type.equals(ModelDataType.STRING) || 
					type.equals(ModelDataType.DATE)) {
				result = true;
			}
		}
		return result;
	}

	/**
	 * determine the XML qualified type name of a model attribute for primitive types and 
	 * for class types
	 * @return the XML qualified type name of the model attribute
	 * @see net.sourceforge.umlmda.xmi.uml.impl.ModelAttributeAdapter#getType()
	 */
	public String getType() {
		String type = super.getType();
		if (isPrimitiveType()) {
			type = "xs:" + type;
		}
		else if (isClassInstance()) {
			type = getModelClass().getQualifiedName() + "Type";
		}
		return type;
	}
	
	
}
