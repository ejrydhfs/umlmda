/*
 *   $Header: /cvsroot/umlmda/GeneratorBase/src/org/umlmda/generator/anttask/FormatterProvider.java,v 1.1.2.2 2008/01/21 14:57:29 moroff Exp $
 *   $Source: /cvsroot/umlmda/GeneratorBase/src/org/umlmda/generator/anttask/FormatterProvider.java,v $
 * $Revision: 1.1.2.2 $
 *     $Name:  $
 *     $Date: 2008/01/21 14:57:29 $
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
 * Created on 16.04.2007 (Dieter Moroff)
 */
package org.umlmda.generator.oaw;

import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.umlmda.generator.FormatterProvider;

/**
 * @author MOROFF
 */
public class Formatter {
   private String className;
   private String configuration;
   private List<String> extensions = new ArrayList<String>();
   private Logger logger = Logger.getLogger(Formatter.class.getName());

   /**
    * 
    */
   public Formatter() {
      super();
   }

   /**
    * @return Returns the className.
    */
   public String getClassName() {
      return className;
   }

   /**
    * @param className
    *           The className to set.
    */
   public void setClassName(String className) {
      this.className = className;
   }

   /**
    * @return Returns the configuration.
    */
   public String getConfiguration() {
      return configuration;
   }

   /**
    * @param configuration
    *           The configuration to set.
    */
   public void setConfiguration(String configuration) {
      this.configuration = configuration;
   }

   public void addConfiguredExtension(String extension) {
      extensions.add(extension);
   }

   /**
    * @return Returns the extensions.
    */
   public List<String> getExtensions() {
      return extensions;
   }

   public FormatterProvider getFormatterProvider() {
      if (className == null) {
         return null;
      } else {
         try {
            Class<?> formatterProviderClass = Class.forName(className);
            FormatterProvider formatterProvider = (FormatterProvider) formatterProviderClass.newInstance();

            if (configuration != null) {
               URL configurationResource = getClass().getResource(configuration);

               if (configurationResource == null) {
                  // TODO Logging
               } else {
                  formatterProvider.setConfiguration(configurationResource);
               }
            }

            if (extensions.size() > 0) {
               String extensionArray[] = new String[extensions.size()];

               int i = 0;
               for (Iterator<String> ie = extensions.iterator(); ie.hasNext();) {
                  String extension = ie.next();

                  extensionArray[i] = extension;
               }

               formatterProvider.setExtensionsApplyableFor(extensionArray);
            }

            return formatterProvider;
         } catch (ClassNotFoundException e) {
            logger.log(Level.WARNING, className + " not found ", e);
            throw new RuntimeException(e);
         } catch (InstantiationException e) {
            logger.log(Level.WARNING, className + " not created ", e);
            throw new RuntimeException(e);
         } catch (IllegalAccessException e) {
            logger.log(Level.WARNING, className + " not created ", e);
            throw new RuntimeException(e);
         }
      }
   }
}
