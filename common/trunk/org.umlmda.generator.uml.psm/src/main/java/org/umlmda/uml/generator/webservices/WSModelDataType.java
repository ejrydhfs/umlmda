/*
 * Created on 09.02.2006
 */
package org.umlmda.uml.generator.webservices;

import org.umlmda.uml.generator.java.JavaModelDataType;

/**
 * @author MOROFF
 */
public interface WSModelDataType extends JavaModelDataType, WSModelClassifier
{

   /**
    * Returns the java web service datatype
    * 
    * @return
    */
   String getWSJavaType();

   /**
    * Returns the java web service datatype for optional values
    * 
    * @return
    */
   String getOptionalWSJavaType();

   /**
    * Returns the type mapping strategy for java web services
    */
   TypeMappingStrategy getWSTypeMappingStrategy();

   /**
    * Returns if a convertion between java and web service datatype is required.
    * 
    * @return
    */
   boolean isConvertionRequired();

   /**
    * @return
    */
   String getConvertToWs();
}
