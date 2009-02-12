// jUMLMDA, UMLModel-API
// 
//   $Header: /cvsroot/umlmda/UMLModelNSUML/src/org/umlmda/model/uml/nsuml/ModelFactoryImpl.java,v 1.1 2005/10/27 19:34:14 moroff Exp $
//   $Source: /cvsroot/umlmda/UMLModelNSUML/src/org/umlmda/model/uml/nsuml/ModelFactoryImpl.java,v $
// $Revision: 1.1 $
//    $State: Exp $
//     $Name:  $
//     $Date: 2005/10/27 19:34:14 $
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
//  Created on Nov 17, 2004
package org.umlmda.model.uml.nsuml;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import javax.xml.parsers.ParserConfigurationException;


import org.umlmda.model.uml.ModelBase;
import org.umlmda.model.uml.ModelFactory;
import org.umlmda.model.uml.nsuml.xmi.XMIReader;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import cb.parser.PetalParser;
import cb.petal.PetalFile;
import cb.xmi.XMIFactory;
import cb.xmi.XMIGenerator;

/**
 * @author moroff
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class ModelFactoryImpl implements ModelFactory {
   private Map pathMap = null;
   
   /* (non-Javadoc)
    * @see net.sourceforge.umlmda.xmi.uml.ModelFactory#loadModel(java.io.InputStream)
    */
   public ModelBase loadModel(InputStream modelStream) throws IOException {
      try {
         XMIReader xmiReader = new XMIReader();
         return new ModelImpl(xmiReader.parse(new InputSource(modelStream))); 
      } catch (SAXException e) {
         throw new RuntimeException(e);
      } catch (ParserConfigurationException e) {
         throw new RuntimeException(e);
      } finally {
         modelStream.close();     
      }
   }

   /* (non-Javadoc)
    * @see net.sourceforge.umlmda.xmi.uml.ModelFactory#loadModel(java.io.File)
    */
   public ModelBase loadModel(File modelFile) throws IOException {
      InputStream modelStream = null;
      
      if ( modelFile.getAbsolutePath().endsWith(".zargo")) {
         ZipFile zipFile = new ZipFile(modelFile, ZipFile.OPEN_READ);
         for (Enumeration ez = zipFile.entries(); ez.hasMoreElements();) {
            ZipEntry zipEntry = (ZipEntry) ez.nextElement();
                     
            if ( zipEntry.getName().endsWith(".xmi")) {
               modelStream = zipFile.getInputStream(zipEntry);
               break;
            }
         }
         if ( modelStream == null )
            throw new RuntimeException("No xmi entry in " + modelFile.getAbsolutePath());
      }
      else if ( modelFile.getAbsolutePath().endsWith(".mdl")) {
         PetalParser parser = PetalParser.createParser(modelFile.getAbsolutePath(), null);

         // Abandon all diagrams since they're not used by the generator anyway
         // This saves us a lot of memory
         parser.setIgnoredNodes(new Class[] { cb.petal.Diagram.class,
           cb.petal.View.class });

         parser.setPathMap(pathMap);
         PetalFile    tree = parser.parse();
         XMIGenerator gen  = new XMIGenerator(tree, null) {
            protected XMIFactory getFactory() {
               return new UMLMDAXMIFactory(getTree(), this);
            }
         };
         
    
         gen.start();
         return new ModelImpl(gen.getModel());
      }
      else
         modelStream = new FileInputStream(modelFile);
         
      return loadModel(modelStream);
   }

   /**
    * @return
    */
   public Map getPathMap() {
      return pathMap;
   }

   /**
    * @param map
    */
   public void setPathMap(Map map) {
      pathMap = map;
   }

}
