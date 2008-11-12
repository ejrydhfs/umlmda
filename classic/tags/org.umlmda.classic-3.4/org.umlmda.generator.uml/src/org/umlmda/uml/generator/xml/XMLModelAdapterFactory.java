//jUMLMDA, UMLModel-API
//
//$Header: /cvsroot/umlmda/UMLGenerator/src/org/umlmda/uml/generator/xml/XMLModelAdapterFactory.java,v 1.4 2006/05/04 15:22:09 moroff Exp $
//$Source: /cvsroot/umlmda/UMLGenerator/src/org/umlmda/uml/generator/xml/XMLModelAdapterFactory.java,v $
//$Revision: 1.4 $
// $State: Exp $
//  $Name:  $
//  $Date: 2006/05/04 15:22:09 $
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
//Created on 14 Jun, 2005
package org.umlmda.uml.generator.xml;

import org.umlmda.model.uml.Model;
import org.umlmda.model.uml.ModelAdapterFactory;
import org.umlmda.model.uml.ModelAttribute;
import org.umlmda.model.uml.ModelAttributeBase;
import org.umlmda.model.uml.ModelBase;
import org.umlmda.uml.generator.java.JavaModelAdapterFactory;

/**
 * factory for XML schema adapters
 *  
 * @author vpussel
 */
public class XMLModelAdapterFactory extends JavaModelAdapterFactory implements
		ModelAdapterFactory {

	/* (non-Javadoc)
	 * @see net.sourceforge.umlmda.xmi.uml.impl.ModelAdapterFactoryImpl#createModel(net.sourceforge.umlmda.xmi.uml.Model)
	 */
	protected Model createPsmModel(Model model) {
		return new XMLModelAdapter(this, model);
	}

	/* (non-Javadoc)
	 * @see net.sourceforge.umlmda.xmi.uml.impl.ModelAdapterFactoryImpl#createModelAttribute(net.sourceforge.umlmda.xmi.uml.ModelAttribute, net.sourceforge.umlmda.xmi.uml.AdaptedModel)
	 */
	public ModelAttribute createModelAttribute(ModelAttributeBase modelAttribute, Model model) {
		return new XMLModelAttributeAdapter(modelAttribute, model);
	}

	/* (non-Javadoc)
	 * @see net.sourceforge.umlmda.xmi.uml.impl.ModelAdapterFactoryImpl#createModelClass(net.sourceforge.umlmda.xmi.uml.ModelClass, net.sourceforge.umlmda.xmi.uml.AdaptedModel)
	 */
//	public ModelClass createModelClass(ModelClassBase modelClass, Model model) {
//		return new XSDModelClassAdapter(modelClass, model);
//	}	
}
