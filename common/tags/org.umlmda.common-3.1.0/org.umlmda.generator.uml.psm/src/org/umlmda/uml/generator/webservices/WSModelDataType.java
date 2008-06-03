/*
 * Created on 09.02.2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package org.umlmda.uml.generator.webservices;

import org.umlmda.uml.generator.java.JavaModelDataType;

/**
 * @author MOROFF
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public interface WSModelDataType extends JavaModelDataType, WSModelClassifier {

   /**
    * Returns the java web service datatype
    * @return
    */
   public String getWSJavaType();
   
   /**
    * Returns the java web service datatype for optional values
    * @return
    */
   public String getOptionalWSJavaType();

   /**
    * Returns the type mapping strategy for java web services
    */
   public TypeMappingStrategy getWSTypeMappingStrategy();
   
   /**
    * Returns if a convertion between java and web service datatype
    * is required.
    * @return
    */
   public boolean isConvertionRequired();

   /**
    * @return
    */
   public String getConvertToWs();
}
