// jUMLMDA, UMLModel-API
// 
//   $Header: /cvsroot/umlmda/UMLModelUML2/src/org/umlmda/model/uml/uml2/ModelFactoryImpl.java,v 1.1.2.3.2.1 2008/03/11 15:51:10 moroff Exp $
//   $Source: /cvsroot/umlmda/UMLModelUML2/src/org/umlmda/model/uml/uml2/ModelFactoryImpl.java,v $
// $Revision: 1.1.2.3.2.1 $
//    $State: Exp $
//     $Name:  $
//     $Date: 2008/03/11 15:51:10 $
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
package org.umlmda.model.uml.uml2;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.internal.impl.UMLPackageImpl;
import org.eclipse.uml2.uml.internal.resource.UMLResourceFactoryImpl;
import org.umlmda.model.uml.ModelBase;
import org.umlmda.model.uml.ModelFactory;

/**
 * @author moroff
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class ModelFactoryImpl implements ModelFactory {
   private Map pathMap = Collections.EMPTY_MAP;
   private static Logger logger = Logger.getLogger(ModelFactoryImpl.class);
   
   /* (non-Javadoc)
    * @see org.umlmda.model.uml.ModelFactory#loadModel(java.io.InputStream)
    */
   public ModelBase loadModel(InputStream modelStream) throws IOException {
      //TODO ModelFactoryImpl.loadModel(modelStream)
//      try {
//         UML2ResourceFactoryImpl resourceFactory = new UML2ResourceFactoryImpl();
//         
//         resourceFactory.c
//         XMIReader xmiReader = new XMIReader();
//         return new ModelImpl(xmiReader.parse(new InputSource(modelStream))); 
//      } catch (SAXException e) {
//         throw new RuntimeException(e);
//      } catch (ParserConfigurationException e) {
//         throw new RuntimeException(e);
//      } finally {
//         modelStream.close();     
//      }
      return null;
   }

   /* (non-Javadoc)
    * @see org.umlmda.model.uml.ModelFactory#loadModel(java.io.File)
    */
   public ModelBase loadModel(File modelFile) throws IOException {
//      Resource.Factory factory = new com.ibm.xtools.emf.core.resource.RMPResourceFactory();
//      Resource.Factory factory = new GMFResourceFactory();
//      Resource.Factory factory = new com.ibm.xtools.emf.msl.internal.resources.MSLResourceFactory();
//      Resource.Factory rsmFactory = new RSMResourceFactory();
      Resource.Factory factory = new UMLResourceFactoryImpl();

      UMLPackageImpl.init();
      Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("emx", factory);
      Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("epx", factory);
      Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("uml2", factory);
      
      URI uri = URI.createFileURI(modelFile.getAbsolutePath());
      
      ResourceSet resourceSet = new ResourceSetImpl();
      resourceSet.getLoadOptions().put(XMLResource.OPTION_RECORD_UNKNOWN_FEATURE, Boolean.TRUE);
      resourceSet.getLoadOptions().put(XMLResource.OPTION_PROCESS_DANGLING_HREF_RECORD, Boolean.TRUE);
      resourceSet.setURIConverter(new PathMapURIConverter(resourceSet.getURIConverter(), pathMap));
      Resource resource = resourceSet.getResource(uri,true);
      
      try {
         resource.load(null);
      } catch (IOException e) {
         e.printStackTrace();
      }

      EList errors = resource.getErrors();
      for (Iterator ie = errors.iterator(); ie.hasNext();) {
         Object error = (Object) ie.next();

         logger.error(error.toString());
      }

      for (Iterator iw = resource.getWarnings().iterator(); iw.hasNext();) {
         Object warning = (Object) iw.next();
         
         logger.warn(warning);
      }
      EList list = resource.getContents();
      Iterator contentIterator = list.iterator();
      if ( contentIterator.hasNext() ) {
         Model model = (Model)contentIterator.next();
         
         // Stereotypes hinzufügen
         while ( contentIterator.hasNext() ) {
            Object element = (Object) contentIterator.next();
            
            if ( logger.isDebugEnabled() )
               logger.debug(element);
         }
         
         
         return new ModelImpl(model);
      }
      else {
         return null;
      }
   }

   /* (non-Javadoc)
    * @see org.umlmda.model.uml.ModelFactory#setPathMap(java.util.Map)
    */
   public void setPathMap(Map pathMap) {
      this.pathMap = pathMap;
   }


}
