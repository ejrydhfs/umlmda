/*******************************************************************************
 * Copyright (c) 2005, 2006, 2008 committers of openArchitectureWare and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Meinte Boersma - initial API and implementation
 *******************************************************************************/
package org.umlmda.oaw.generator.workflow;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.uml2.uml.Package;
import org.openarchitectureware.workflow.WorkflowContext;
import org.openarchitectureware.workflow.issues.Issues;
import org.openarchitectureware.workflow.lib.AbstractWorkflowComponent;
import org.openarchitectureware.workflow.monitor.ProgressMonitor;

/**
 * Special version of the EMXWriter (in fact, it is a bit of a hacked copy of the original) to reserialize .emx files correctly,
 * including:
 * <ol>
 * <li>diagram information
 * <li>the current xmi:id's
 * <li>the XML preamble required by RSM/RSA7.0 (via a hack)
 * </ol>
 * <p>
 * The properties of this workflow component are:
 * <ul>
 * <li><b>modelSlot</b>: name of slot which contains the UML2 model to save
 * <li><b>uri</b>: URI to save the slot contents to
 * </ul>
 * </p>
 * <p>
 * Prerequisites and known limitations:
 * <ul>
 * <li>You have to register two metamodels in the <tt>Setup</tt> bean using the <tt>registerGeneratedEPackage</tt> property. The
 * values (class names) are: <tt>org.eclipse.gmf.runtime.notation.NotationPackage</tt>,
 * <tt>com.ibm.xtools.umlnotation.UmlnotationPackage</tt>. (Maybe these could be added conditionally by the <tt>RSASetup</tt>
 * bean?)</li>
 * <li>You have to add JARs containing the metamodels mentioned above, to the class path. The following versions have been
 * verified as working:
 * <ul>
 * <li><tt>org.eclipse.gmf.runtime.notation_1.0.1.v20060919-0800.jar</tt><br/>
 * Note this is an older version from GMF-runtime version 1.0.3. Do not use a newer one as the version in the namespace URI is not
 * 1.0.1. RSM7.0 itself uses <tt>org.eclipse.gmf.runtime.notation_1.0.1.v20060919-0800.jar</tt>.</li>
 * <li><tt>com.ibm.xtools.umlnotation_7.0.0.v20061023.jar</tt><br/>
 * You'll have to leech this one from the <tt>plugins</tt> folder in the shared part of the installation of RSM/RSA7.0.</li>
 * </ul>
 * </li>
 * <li>Referencing is OK <em>provided</em> all relative paths are encoded using <tt>platform:/resource/...</tt>.</li>
 * </ul>
 * </p>
 * <p>
 * <em>Note</em> that this component is a bit of a hack, so it comes without guarantees. It might break as soon as an update of
 * RSM/RSA7.0 occurs (or sooner...). I've tested it OK with RSM7.0.0 (files), running oAW under Eclipse 3.3 (Europa) with EMF
 * v2.3.1 and UML2 v2.1.0 but nothing else. You'll probably have to change something in the <tt>ReplacingFileOutputStream</tt>
 * inner class if UML2 versions change either within RSM/RSA or the Eclipse instance running oAW. All in all, <em>Unless</em> you
 * really need to be able to re-open .emx within RSM/RSA7.0 (which you probably do, or you wouldn't be reading this...), you'd
 * better use the original <tt>EMXWriter</tt>.
 * </p>
 * 
 * @author Meinte Boersma
 */
public class AdvancedEMXWriter extends AbstractWorkflowComponent
{

   private String modelSlot;

   private String uriString;

   public String getModelSlot() {
      return modelSlot;
   }

   /**
    * Sets the name of the model slot which contains the UML2 model to save.
    * 
    * @param modelSlot
    *           - <tt>String</tt> model slot name
    */
   public void setModelSlot(String modelSlot) {
      this.modelSlot = modelSlot;
   }

   public String getUri() {
      return uriString;
   }

   /**
    * Sets the URI to write to.
    * 
    * @param modelSlot
    *           - <tt>String</tt> model slot name
    */
   public void setUri(String uri) {
      this.uriString = uri;
   }

   private static Log    log      = LogFactory.getLog(AdvancedEMXWriter.class);

   // preamble is loaded into this at first usage of the component:
   private static String preamble = null;

   public void checkConfiguration(Issues issues) {
      if ( (modelSlot == null) || (modelSlot.trim().length() == 0) ) {
         issues.addError("property 'modelSlot' is empty");
      }

      // skip if already loaded:
      if ( preamble != null ) {
         return;
      }

      // locate and read the .emx preamble:
      Class clazz = this.getClass();
      String preambleUri = clazz.getPackage().getName().replace(".", "/") + "/emxPreamble.txt";
      InputStream is = clazz.getClassLoader().getResourceAsStream(preambleUri);
      if ( is == null ) {
         throw new RuntimeException("Could not locate .emx preamble: resource with platform URI '" + preambleUri
               + "' does not exist");
      }
      BufferedReader br = new BufferedReader(new InputStreamReader(is));

      preamble = "";
      try {
         String line;
         while ( (line = br.readLine()) != null ) {
            preamble += (line + "\n");
         }
         br.close();
         is.close();
      }
      catch (IOException e) {
         throw new RuntimeException("Could not load .emx preamble (as a resource): ", e);
      }

      log.info("read .emx preamble");
   }

   public void invoke(WorkflowContext ctx, ProgressMonitor monitor, Issues issues) {
      log.info("running " + AdvancedEMXWriter.class.getSimpleName());
      if ( !(ctx.get(modelSlot) instanceof Package) ) {
         issues.addError("model slot contents should be a uml::Package (subtypes: uml::Model or uml::Profile)");
      }

      /*
       * xmi:id's are (intrinsically) bound to their containing resource, so it is essential to "hijack" the current resource.
       * Otherwise, the xmi:id's change and e.g. the RSM/RSA Model Compare & Merge engine doesn't work anymore (i.e., it thinks
       * everything's changed).
       */

      // hijack the Resource and re-set the URI:
      Resource resource = ((EObject) ctx.get(modelSlot)).eResource();
      URI uri = URI.createURI(uriString);
      resource.setURI(uri);

      // create an options map to suppress the XML declaration (it is provided by the preamble):
      Map<String, Object> optionsMap = new HashMap<String, Object>();
      optionsMap.put(XMLResource.OPTION_DECLARE_XML, Boolean.FALSE);

      try {
         // use a special replacing FileOutputStream to replace XMI and UML version and name space declarations:
         OutputStream os = new ReplacingFileOutputStream(uri.toString()); // uri renormalized?
         os.write(preamble.getBytes());
         resource.save(os, optionsMap);
         os.close();
      }
      catch (IOException e) {
         issues.addError("problems saving the model: " + e.getMessage());
      }
   }

   /**
    * Special implementation of FileOutputStream to selectively replace special content on the fly.
    */
   private class ReplacingFileOutputStream extends FileOutputStream
   {

      private static final String ROOT_NODE         = "<xmi:XMI ";

      private static final String XMI_VERSION_2_0   = "xmi:version=\"2.0\"";
      private static final String XMI_VERSION_2_1   = "xmi:version=\"2.1\"";

      private static final String UML_VERSION_2_0_0 = "xmlns:uml=\"http://www.eclipse.org/uml2/2.0.0/UML\"";
      private static final String UML_VERSION_2_1_0 = "xmlns:uml=\"http://www.eclipse.org/uml2/2.1.0/UML\"";

      private static final String XMI_NS_URI_2_1    = "xmlns:xmi=\"http://schema.omg.org/spec/XMI/2.1\"";
      private static final String XMI_NS_URI_2_0    = "xmlns:xmi=\"http://www.omg.org/XMI\"";

      private boolean             done              = false;

      private StringBuilder       lineBuffer        = new StringBuilder();

      public ReplacingFileOutputStream(String fileUri) throws FileNotFoundException {
         super(fileUri);
      }

      @Override
      public void write(int b) throws IOException {
         if ( done ) {
            super.write(b);
         }
         else {
            lineBuffer.append((char) b);
            if ( b == '\n' ) {
               // it's a newLine!, check whether it's anything worth replacing:...
               if ( lineBuffer.substring(0, ROOT_NODE.length()).equals(ROOT_NODE) ) {
                  replace(lineBuffer, XMI_VERSION_2_1, XMI_VERSION_2_0, "no XMI version declaration found in XMI root node line");
                  replace(lineBuffer, XMI_NS_URI_2_1, XMI_NS_URI_2_0, "no XMI namespace declaration found in XMI root node line");
                  replace(lineBuffer, UML_VERSION_2_1_0, UML_VERSION_2_0_0,
                        "no UML version declaration found in XMI root node line");
                  done = true;
               }
               for ( int i = 0; i < lineBuffer.length(); i++ ) {
                  super.write(lineBuffer.charAt(i));
               }
               lineBuffer = new StringBuilder();
            }
         }
      }

      @Override
      public void write(byte[] moreBytes) throws IOException {
         for ( int i = 0; i < moreBytes.length; i++ ) {
            write(moreBytes[i]);
         }
      }

      @Override
      public void write(byte[] moreBytes, int off, int len) throws IOException {
         for ( int i = 0; i < len; i++ ) {
            if ( off + i < moreBytes.length ) {
               write(moreBytes[off + i]);
            }
         }
      }

      private void replace(StringBuilder sBuild, String patternStr, String replaceStr, String warnMessage) {
         int idx = sBuild.indexOf(patternStr);
         if ( idx == -1 ) {
            log.warn(warnMessage);
         }
         else {
            sBuild.replace(idx, idx + patternStr.length(), replaceStr);
         }
      }

   }

}
