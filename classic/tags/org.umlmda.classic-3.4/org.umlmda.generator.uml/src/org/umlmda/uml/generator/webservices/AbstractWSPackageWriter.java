/*
 *   $Header: /cvsroot/umlmda/UMLGenerator/src/org/umlmda/uml/generator/webservices/AbstractWSPackageWriter.java,v 1.1 2006/04/27 11:13:40 moroff Exp $
 *   $Source: /cvsroot/umlmda/UMLGenerator/src/org/umlmda/uml/generator/webservices/AbstractWSPackageWriter.java,v $
 * $Revision: 1.1 $
 *     $Name:  $
 *     $Date: 2006/04/27 11:13:40 $
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
 * Created by Dieter Moroff (24.04.2006)
 */
package org.umlmda.uml.generator.webservices;


/**
 * TODO Insert type javadoc
 * 
 * @author Dieter Moroff (24.04.2006), last change $Date: 2006/04/27 11:13:40 $ $Name:  $
 * @version $Revision: 1.1 $
 */
public abstract class AbstractWSPackageWriter extends AbstractPackageWriter {

   /**
    *  
    */
   public AbstractWSPackageWriter() {
      super();
   }

   public boolean generateOutput() {
      boolean generateOutput = super.generateOutput(getModelPackage().getClasses(), WSStereotypes.WEB_SERVICE);

      return generateOutput;
   }
}
