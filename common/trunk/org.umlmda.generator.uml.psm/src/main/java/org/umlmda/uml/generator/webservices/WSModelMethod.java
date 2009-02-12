/*
 * Created on 10.11.2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package org.umlmda.uml.generator.webservices;

import org.umlmda.uml.generator.java.JavaModelMethod;

/**
 * @author moroff
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public interface WSModelMethod extends JavaModelMethod {

   /**
    * Returns the request class used in wrapped calls
    * @return
    */
   public String getRequestClass();

   /**
    * Returns the request signature filled with the methods parameters values
    * @return
    */
   public String getRequestSignature();
   
   /**
    * Returns the response class used in wrapped calls
    * @return
    */
   public String getReponseClass();

   /**
    * Returns the signature of the conversion call to map the interface return type
    * to a webservice return type.
    */
   public String getConvertToWs();
   
   /**
    * Returns the signature of the conversion call to map a webservice return type
    * to the interface return type.
    */
   public String getConvertFromWs();
   
   /**
    * Returns the webservice signature of the method, depending on the
    * used WSDL type (i.e. wrapping)
    */
   public String getWebServiceSignature();

   /**
    * Returns the webservice return type of the method, depending on the
    * used WSDL type (i.e. wrapping)
    */
   public String getWebServiceType();

   /**
    * Returns the plattform independent method
    * @return
    */
   public JavaModelMethod getPIMMethod();

   /**
    * Is soap wrapping is used, returns the wrapped return type
    * @return
    */
   public WSModelClassifier getWrappedReturnType();

   /**
    * @return
    */
   public String getWrappedReturnValueGetter();
   
}
