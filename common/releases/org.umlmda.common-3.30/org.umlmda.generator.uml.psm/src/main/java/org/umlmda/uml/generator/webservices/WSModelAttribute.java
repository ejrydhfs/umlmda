/*
 * Created on 13.12.2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package org.umlmda.uml.generator.webservices;

import org.umlmda.uml.generator.java.JavaModelAttribute;

/**
 * @author MOROFF
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public interface WSModelAttribute extends JavaModelAttribute, WSModelStructuralFeature {
   
   /**
    * Returns the xml datatype in the wsdl
    */
   public String getSchemaType();

   /**
    * Returns the java datatype in the WSDL2Java generated sources 
    */
   public String getWSJavaType();
   
   /**
    * Returns the signature of the conversion call to map the interface datatype
    * to a webservice datatype.
    */
   public String getConvertToWs();
   
   /**
    * Returns the signature of the conversion call to map a webservice datatype
    * to the interface datatype.
    */
   public String getConvertFromWs(String srcInstance);
   
   /**
    * Converts a parameter to a webservice value
    */
   public String getConvertParameterToWs();
}
