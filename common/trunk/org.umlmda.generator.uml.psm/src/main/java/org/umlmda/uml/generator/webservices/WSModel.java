/*
 * Created on 08.11.2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package org.umlmda.uml.generator.webservices;

import org.umlmda.uml.generator.java.JavaModel;

/**
 * @author MOROFF
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public interface WSModel extends JavaModel {
   /**
    * Property to control the wrapping of parameters and return types
    * to a request/reponse structure. Default is <code>false</code>.
    */
   public static final String PROPERTY_SOAP_WRAPPING = "soapWrapping";
   public static final String PROPERTY_SOAP_WRAPPING_DEFAULT = "false";

   /**
    * Flag if using a soap wrapping wsdl
    */
   boolean isSoapWrapping();

   /**
    * Returns the datatype the pim datatype <code>date</code> should be mapped to.
    * @return
    */
   String getDateMapping();
}
