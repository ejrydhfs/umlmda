/*
 *   $Header: /cvsroot/umlmda/GeneratorBase/src/org/umlmda/generator/FormatterProvider.java,v 1.1.2.2 2008/01/21 14:57:27 moroff Exp $
 *   $Source: /cvsroot/umlmda/GeneratorBase/src/org/umlmda/generator/FormatterProvider.java,v $
 * $Revision: 1.1.2.2 $
 *     $Name:  $
 *     $Date: 2008/01/21 14:57:27 $
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
 * Created on 12.04.2007 (Dieter Moroff)
 */
package org.umlmda.generator;

import java.net.URL;

import org.umlmda.generator.model.util.Feedback;

/**
 * Interface for providers of code formatters.
 * @author Dieter Moroff (12.04.2007)
 */
public interface FormatterProvider {
   
   /**
    * Returns the name of the formatter
    * @return
    */
   String getName();
   
   /**
    * Returns the file extension the formatter is applyable for.
    * @return
    */
   String[] getExtensionsApplyableFor();

   /**
    * @param extensionArray
    */
   void setExtensionsApplyableFor(String[] extensionArray);

   /**
    * Return a new formatter
    * @param feedback TODO
    * @return
    */
   Formatter createFormatter(Feedback feedback);

   /**
    * Returns the resource containing the configuration
    */
   URL getConfiguration();

   /**
    * @param configuration
    */
   void setConfiguration(URL configuration);

}
