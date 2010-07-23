// UMLMDA, UMLModel-API
//
//
// This library is free software; you can redistribute it and/or
// modify it under the terms of the GNU Library General Public
// License as published by the Free Software Foundation; either
// version 2 of the License, or (at your option) any later version.
// This library is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
// Library General Public License for more details.
//
// You should have received a copy of the GNU Library General Public
// License along with this library; if not, write to the
// Free Software Foundation, Inc., 59 Temple Place - Suite 330,
// Boston, MA  02111-1307, USA. The text of license can be also found
// at http://www.gnu.org/copyleft/lgpl.html
//
// Created on 13.07.2005, moroff@users.sourceforge.net

package org.umlmda.model.uml.uml2;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.URIConverter;

/**
 * URIConverter to load UML2 model stored by IBM RSM/RSA
 */
public class PathMapURIConverter implements URIConverter
{
   private final URIConverter converter;
   private final Map          pathMap;
   private final Logger       logger = Logger.getLogger(getClass());

   public PathMapURIConverter(URIConverter converter, Map pathMap) {
      super();
      this.converter = converter;
      this.pathMap = pathMap;
   }

   /*
    * (non-Javadoc)
    * @see org.eclipse.emf.ecore.resource.URIConverter#normalize(org.eclipse.emf.common.util.URI)
    */
   public URI normalize(URI uri) {
      URI normalizedURI = null;

      if ( uri.scheme() != null && uri.scheme().equals("pathmap") ) {
         normalizedURI = createPathMapURI(uri);
      }
      else {
         normalizedURI = converter.normalize(uri);
      }

      return normalizedURI;
   }

   private URI createPathMapURI(URI uri) {
      URI normalizedURI;
      String host = uri.host();
      String mappedPath = (String) pathMap.get(host);

      if ( mappedPath != null ) {
         if ( mappedPath.startsWith("jar:") ) {
            normalizedURI = URI.createURI(mappedPath + uri.path());
         }
         else {
            String path = uri.path();
            normalizedURI = URI.createFileURI(mappedPath + path);
         }
      }
      else {
         normalizedURI = converter.normalize(uri);
      }
      return normalizedURI;
   }

   /*
    * (non-Javadoc)
    * @see org.eclipse.emf.ecore.resource.URIConverter#getURIMap()
    */
   public Map<URI, URI> getURIMap() {
      return converter.getURIMap();
   }

   /*
    * (non-Javadoc)
    * @see org.eclipse.emf.ecore.resource.URIConverter#createInputStream(org.eclipse.emf.common.util.URI)
    */
   public InputStream createInputStream(URI uri) throws IOException {
      InputStream inputStream = null;

      if ( uri.scheme() != null && uri.scheme().equals("pathmap") ) {
         String host = uri.host();
         String mappedPath = (String) pathMap.get(host);

         if ( mappedPath != null ) {
            URI normalizedURI = createPathMapURI(uri);

            inputStream = createInputStream(normalizedURI);
            logger.info("loaded " + normalizedURI.toString());
         }
         else {
            logger.warn(uri.toString() + " ignored");
            inputStream = converter.createInputStream(uri);
         }
      }
      else {
         inputStream = converter.createInputStream(uri);
      }

      return inputStream;
   }

   /*
    * (non-Javadoc)
    * @see org.eclipse.emf.ecore.resource.URIConverter#createOutputStream(org.eclipse.emf.common.util.URI)
    */
   public OutputStream createOutputStream(URI uri) throws IOException {
      return converter.createOutputStream(uri);
   }

}
