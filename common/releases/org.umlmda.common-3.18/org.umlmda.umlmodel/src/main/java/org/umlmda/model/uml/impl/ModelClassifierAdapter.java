// jUMLMDA, UMLModel-API
// 
//   $Header: /cvsroot/umlmda/UMLModel/src/org/umlmda/model/uml/impl/ModelClassifierAdapter.java,v 1.1 2005/10/27 19:10:37 moroff Exp $
//   $Source: /cvsroot/umlmda/UMLModel/src/org/umlmda/model/uml/impl/ModelClassifierAdapter.java,v $
// $Revision: 1.1 $
//    $State: Exp $
//     $Name:  $
//     $Date: 2005/10/27 19:10:37 $
//   $Locker:  $
//
//  This library is free software; you can redistribute it and/or
//  modify it under the terms of the GNU Library General Public
//  License as published by the Free Software Foundation; either
//  version 2 of the License, or (at your option) any later version.
//  This library is distributed in the hope that it will be useful,
//  but WITHOUT ANY WARRANTY; without even the implied warranty of
//  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
//  Library General Public License for more details.
//
//  You should have received a copy of the GNU Library General Public
//  License along with this library; if not, write to the
//  Free Software Foundation, Inc., 59 Temple Place - Suite 330,
//  Boston, MA  02111-1307, USA. The text of license can be also found
//  at http://www.gnu.org/copyleft/lgpl.html
//
// Created on Jun 8, 2005
package org.umlmda.model.uml.impl;

import org.umlmda.model.uml.Model;
import org.umlmda.model.uml.ModelClassifier;
import org.umlmda.model.uml.ModelClassifierBase;

/**
 * platform independent adapter to MOF model classifier.
 * extend for specific platform to override the following properties:
 * qualified name
 *
 * @author vpussel
 *
 */
public abstract class ModelClassifierAdapter extends ModelElementAdapter implements
		ModelClassifier {

	private final ModelClassifierBase modelClassifier;

	/**
     * create adapter from model classifier
	 */
	public ModelClassifierAdapter(ModelClassifierBase modelClassifier, Model model) {
		super(modelClassifier, model);
		this.modelClassifier = modelClassifier;
	}

}
