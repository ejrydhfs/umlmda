/* UMLMDA, UMLModel-API
 *
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
 * at http: * www.gnu.org/copyleft/lgpl.html
 * 
 * Created on Sep 22, 2005
 */
package org.umlmda.uml.generator.webservices;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

import org.apache.commons.lang.StringUtils;
import org.umlmda.model.uml.Model;
import org.umlmda.model.uml.ModelAdapterFactory;
import org.umlmda.model.uml.ModelDependency;
import org.umlmda.model.uml.ModelPackage;
import org.umlmda.model.uml.ModelPackageBase;
import org.umlmda.model.uml.impl.ModelDependencyImpl;
import org.umlmda.model.uml.impl.ModelPackageImpl;
import org.umlmda.profile.ModelTaggedValues;
import org.umlmda.uml.generator.java.JavaModelPackage;
import org.umlmda.uml.generator.java.JavaModelPackageAdapter;

/**
 * Web service schema adapter for model packages.
 * 
 * @author Dieter Moroff
 */
public class WSModelPackageAdapter extends JavaModelPackageAdapter implements WSModelPackage
{

   private boolean               isWsPackage     = false;

   private String                packagePrefix   = null;

   private String                namespacePrefix = null;

   private List                  classes         = null;

   private WSModelPackageAdapter wsPackage       = null;

   public WSModelPackageAdapter(ModelPackageBase modelPackage, Model model) {
      super(modelPackage, model);
   }

   /**
    * @return the reverse java package qualifier for the web service namespace
    */
   public String getWSPackagePrefix() {
      if ( packagePrefix == null ) {
         String namespace = getTaggedValues().getProperty(ModelTaggedValues.WSNAMESPACE, null);

         // transform a namespace URI into a java package
         try {
            URI uri = new URI(namespace);
            String host[] = uri.getHost().split("\\.");
            StringBuffer buffer = new StringBuffer();
            for ( int ii = host.length - 1; ii >= 0; --ii ) {
               buffer.append(host[ii]);
               buffer.append(".");
            }

            String path[] = uri.getPath().split("/");
            for ( int ii = 1; ii < path.length - 1; ++ii ) {
               buffer.append(path[ii]);
               buffer.append(".");
            }
            buffer.append(path[path.length - 1]);
            packagePrefix = buffer.toString();
         }
         catch (URISyntaxException ex) {
            throw new RuntimeException(ex.getMessage());
         }
      }
      return packagePrefix;
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.uml.generator.webservices.WSModelPackage#getNamespace()
    */
   public String getNamespace() {
      String nameSpace = getTaggedValues().getProperty(ModelTaggedValues.WSNAMESPACE);

      if ( nameSpace != null )
         return nameSpace;
      else {
         StringBuffer buffer = new StringBuffer("http://");
         ModelPackage modelPackage2 = this;
         while ( modelPackage2 != null ) {
            buffer.append(modelPackage2.getQualifiedName());
            modelPackage2 = modelPackage2.getPackage();
            if ( modelPackage2 != null )
               buffer.append(".");
         }
         return buffer.toString();
      }
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.uml.generator.webservices.WSModelPackage#getNamespacePrefix()
    */
   public String getNamespacePrefix(WSModelPackage basePackage) {
      boolean useNamespace = Boolean.valueOf(getGeneratorModel().getProperties().getProperty("UseNamespace", "true"))
            .booleanValue();

      if ( useNamespace ) {
         String prefix = getTaggedValues().getProperty(ModelTaggedValues.WSNAMESPACE_PREFIX, null);

         if ( prefix != null ) {
            this.namespacePrefix = prefix;
         }
         else {
            List namespacePackages = new ArrayList(basePackage.getReferencedPackages());

            namespacePackages.add(basePackage);
            Collections.sort(namespacePackages);

            int index = namespacePackages.indexOf(this);
            this.namespacePrefix = "tns" + index;
         }
      }
      else {
         this.namespacePrefix = "tns0";
      }

      return this.namespacePrefix;
   }

   /**
    * @return Returns the namespacePrefix.
    */
   public String getNamespacePrefix() {
      return namespacePrefix;
   }

   /**
    * @param namespacePrefix
    *           The namespacePrefix to set.
    */
   public void setNamespacePrefix(String namespacePrefix) {
      this.namespacePrefix = namespacePrefix;
   }

   public WSModelPackage getWsPackage() {
      if ( isWsPackage ) {
         return this;
      }
      else {
         if ( wsPackage == null ) {
            String name = getReplacedName();
            String qualifiedName = getReplacedQualifiedName();
            ModelPackageBase parent = (ModelPackageBase) getOrCreateParent(qualifiedName).getBase();

            wsPackage = (WSModelPackageAdapter) getModel().find(qualifiedName);
            if ( wsPackage == null ) {
               ModelPackageImpl wsPackageImpl = new ModelPackageImpl(getModelBase(), parent);

               wsPackageImpl.setName(name);
               wsPackageImpl.getStereotypes().add(WSStereotypes.WEB_SERVICE_COMPONENT);
               wsPackage = (WSModelPackageAdapter) getModel().getModelPackage(wsPackageImpl);
               wsPackage.isWsPackage = true;
               wsPackageImpl.getTaggedValues().putAll(getTaggedValues());

               // Dependency to the PIM package
               ModelDependencyImpl dependency = new ModelDependencyImpl(getModel(), wsPackageImpl);
               dependency.getStereotypes().add("PIMPackage");
               dependency.getSuppliers().add(wsPackageImpl);
               dependency.getClients().add(getBase());
               wsPackageImpl.getDependencies().add(dependency);

               getModel().getPackages().add(wsPackage);
            }
            else {
               if ( wsPackage.hasStereotype(WSStereotypes.WEB_SERVICE_COMPONENT) == false ) {
                  wsPackage.getStereotypes().add(WSStereotypes.WEB_SERVICE_COMPONENT);
               }
            }
         }
         return wsPackage;
      }
   }

   /**
    * @param qualifiedName
    * @return
    */
   private ModelPackage getOrCreateParent(String qualifiedName) {
      ModelPackageImpl parentImpl = null;
      ModelPackageBase parentBase = null;
      ModelPackage parent = null;
      String qualifiedParentName = "";
      StringTokenizer parseQualifiedName = new StringTokenizer(qualifiedName, ".");
      int count = parseQualifiedName.countTokens();

      for ( int i = 0; i < count - 1; ++i ) {
         String name = parseQualifiedName.nextToken();

         if ( StringUtils.isNotEmpty(qualifiedParentName) ) {
            qualifiedParentName = qualifiedParentName + "." + name;
         }
         else {
            qualifiedParentName = name;
         }

         parent = (ModelPackage) getModel().find(qualifiedParentName);
         if ( parent == null ) {
            parentBase = parentImpl = new ModelPackageImpl(getModelBase(), parentBase);

            parentImpl.setName(name);
            parent = getModel().getModelPackage(parentImpl);
            getModel().getPackages().add(parent);
         }
         else {
            if ( parent.getBase() instanceof ModelPackageBase ) {
               parentBase = (ModelPackageBase) parent.getBase();
            }
            else
               parentBase = null;
         }
      }
      return parent;
   }

   /**
    * @param name
    * @return
    */
   protected String getReplacedQualifiedName() {
      String qualifiedName = getQualifiedName() + "." + getReplacedName();
      return qualifiedName;
   }

   /**
    * @return
    */
   protected String getReplacedName() {
      String name = "ws"; // TODO use property or artefact
      return name;
   }

   public JavaModelPackage getPIMPackage() {
      if ( isWsPackage ) {
         JavaModelPackage pimPackage = null;

         for ( Iterator id = getDependencies().iterator(); id.hasNext(); ) {
            ModelDependency dependency = (ModelDependency) id.next();

            if ( dependency.hasStereotype("PIMPackage") ) {
               pimPackage = (JavaModelPackage) dependency.getClients().iterator().next();
            }
         }

         if ( pimPackage == null ) {
            throw new RuntimeException("Model is not constistence");
         }
         else {
            return pimPackage;
         }
      }
      else {
         return this;
      }
   }
}
