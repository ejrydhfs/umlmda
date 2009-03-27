/*
 *   $Header: /cvsroot/umlmda/GeneratorBase/src/org/umlmda/generator/Formatter.java,v 1.1.2.2 2008/01/21 14:57:27 moroff Exp $
 *   $Source: /cvsroot/umlmda/GeneratorBase/src/org/umlmda/generator/Formatter.java,v $
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

import java.io.File;
import java.net.URL;

/**
 * Interface for code formatters.
 * @author Dieter Moroff (12.04.2007)
 */
public interface Formatter {

   /**
    * Configure the formatter
    * @param configuration
    */
   void configure(URL configuration);
   
   /**
    * Format to file
    * @param sourceToFormat
    * @return <code>true</code> if the formatting was sucessful, else <code>false</code>
    */
   boolean format(File sourceToFormat);
   
   /**
    * Formats to string
    * @param targetfilePath
    * @param unformattedInput
    * @return
    */
   public String format(String targetfilePath, String unformattedInput);
   
   public boolean isBufferFormattingSupported();
   
   public boolean isFileFormattingSupported();
}
