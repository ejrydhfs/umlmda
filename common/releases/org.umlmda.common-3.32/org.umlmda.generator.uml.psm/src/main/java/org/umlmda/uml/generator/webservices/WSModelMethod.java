/*
 * Created on 10.11.2005
 */
package org.umlmda.uml.generator.webservices;

import org.umlmda.uml.generator.java.JavaModelMethod;

/**
 * @author moroff
 */
public interface WSModelMethod extends JavaModelMethod
{

   /**
    * Returns the request class used in wrapped calls
    * 
    * @return
    */
   String getRequestClass();

   /**
    * Returns the request signature filled with the methods parameters values
    * 
    * @return
    */
   String getRequestSignature();

   /**
    * Returns the response class used in wrapped calls
    * 
    * @return
    */
   String getReponseClass();

   /**
    * Returns the signature of the conversion call to map the interface return type to a webservice return type.
    */
   String getConvertToWs();

   /**
    * Returns the signature of the conversion call to map a webservice return type to the interface return type.
    */
   String getConvertFromWs();

   /**
    * Returns the webservice signature of the method, depending on the used WSDL type (i.e. wrapping)
    */
   String getWebServiceSignature();

   /**
    * Returns the webservice return type of the method, depending on the used WSDL type (i.e. wrapping)
    */
   String getWebServiceType();

   /**
    * Returns the plattform independent method
    * 
    * @return
    */
   JavaModelMethod getPIMMethod();

   /**
    * Is soap wrapping is used, returns the wrapped return type
    * 
    * @return
    */
   WSModelClassifier getWrappedReturnType();

   /**
    * @return
    */
   String getWrappedReturnValueGetter();

}
