/*
 * Created on 13.12.2005
 */
package org.umlmda.uml.generator.webservices;

import org.umlmda.uml.generator.java.JavaModelAttribute;

/**
 * @author MOROFF
 */
public interface WSModelAttribute extends JavaModelAttribute, WSModelStructuralFeature
{

   /**
    * Returns the xml datatype in the wsdl
    */
   String getSchemaType();

   /**
    * Returns the java datatype in the WSDL2Java generated sources
    */
   String getWSJavaType();

   /**
    * Returns the signature of the conversion call to map the interface datatype to a webservice datatype.
    */
   String getConvertToWs();

   /**
    * Returns the signature of the conversion call to map a webservice datatype to the interface datatype.
    */
   String getConvertFromWs(String srcInstance);

   /**
    * Converts a parameter to a webservice value
    */
   String getConvertParameterToWs();
}
