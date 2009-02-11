/*
 *   $Header: /cvsroot/umlmda/UMLModel/src/org/umlmda/model/uml/ModelVisitor.java,v 1.2 2007/01/03 21:12:44 moroff Exp $
 *   $Source: /cvsroot/umlmda/UMLModel/src/org/umlmda/model/uml/ModelVisitor.java,v $
 * $Revision: 1.2 $
 *     $Name:  $
 *     $Date: 2007/01/03 21:12:44 $
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
 * Created by Dieter Moroff (12.04.2006)
 */
package org.umlmda.model.uml;

/**
 * TODO Insert type javadoc
 * @author Dieter Moroff (12.04.2006), last change $Date: 2007/01/03 21:12:44 $ $Name:  $
 * @version $Revision: 1.2 $
 */
public interface ModelVisitor {

   /**
    * Visits a model
    * @param model
    * @return <b>true</b> visit the model childs (packages and classes)
    */
   public boolean visit(Model model);
   
   /**
    * Visits a model package
    * @param modelPackage
    * @return <b>true</b> visit the package childs (packages and classes)
    */
   public boolean visit(ModelPackage modelPackage);
   
   /**
    * Visits a model class
    * @param modelClass
    * @return <b>true</b> visit the models class childs (attributes, associations, ...)
    */
   public boolean visit(ModelClass modelClass);
   
   public boolean visit(ModelAttribute attribute);

   public boolean visit(ModelAssociation association);

   public boolean visit(ModelMethod method);

   public boolean visit(ModelParameter parameter);
   
   public boolean visit(ModelDataType dataType);
   
   public boolean visit(ModelDependency dependency);

}
