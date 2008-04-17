/*
 * Created on 09.02.2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package org.umlmda.uml.generator.webservices;

import org.apache.commons.lang.StringUtils;
import org.umlmda.model.uml.Model;
import org.umlmda.model.uml.ModelDataType;
import org.umlmda.model.uml.ModelDataTypeBase;
import org.umlmda.uml.generator.java.JavaModelDataTypeAdapter;

/**
 * @author MOROFF
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class WSModelDataTypeAdapter extends JavaModelDataTypeAdapter implements WSModelDataType {
   static final TypeMappingStrategy typeMappingStrategy = new TypeMappingStrategy() {

      public String getPSMType(ModelDataType dataType, boolean optional, boolean multivalue) {
         String type;
         if ( optional ) 
            type = ((WSModelDataType)dataType).getOptionalWSJavaType();
         else   
            type = ((WSModelDataType)dataType).getWSJavaType();
         
         if ( multivalue ) {
            type = type + "[]";
         }
         
         return type;
      }
      
   };
   /**
    * @param modelDataType
    * @param model
    */
   public WSModelDataTypeAdapter(ModelDataTypeBase modelDataType, Model model) {
      super(modelDataType, model);
   }

   /**
    * Depending on the webservice toolkit different date mapping can be choosen with
    * the generator profile property <code>DateMapping</code>, default is 
    * <code>java.util.Date</code>.
    */
   public final String getWSJavaType() {
      return getWSJavaType(this, super.getJavaType());
   }

   /**
    * @see #getWSJavaType()
    */
   public final String getOptionalWSJavaType() {
      return getWSJavaType(this, super.getOptionalJavaType());
   }

   public final TypeMappingStrategy getWSTypeMappingStrategy() {
      return typeMappingStrategy;
   }
   
   public TypeMappingStrategy getPSMTypeMappingStrategy() {
      return typeMappingStrategy;
   }
      
   /* (non-Javadoc)
    */
   private static String getWSJavaType(WSModelDataType dataType, String defaultJavaType) {
      String dateMapping = ((WSModel)dataType.getGeneratorModel()).getDateMapping();
      
      if ( ModelDataType.DATE.equals(dataType.getName())) {
         return dateMapping;
      }
      else if ( ModelDataType.DATE_TIME.equals(dataType.getName())) {
         return dateMapping;
      }
      else if ( ModelDataType.TIMESTAMP.equals(dataType.getName())) {
         return dateMapping;
      }
      else
         return defaultJavaType ;
   }

   
   /* (non-Javadoc)
    * @see org.umlmda.uml.generator.webservices.WSModelClassifier#getSchemaType()
    */
   public String getSchemaType() {
      if ( getName().equals(ModelDataType.CHAR))
         return "xsd:string";
      else
         return "xsd:"+getName();
   }

   /* (non-Javadoc)
    * @see org.umlmda.uml.generator.webservices.WSModelDataType#isConvertionRequired()
    */
   public boolean isConvertionRequired() {
      return getJavaType().equals(getWSJavaType()) == false;
   }

   /* (non-Javadoc)
    * @see org.umlmda.uml.generator.webservices.WSModelDataType#getConvertToWs()
    */
   public String getConvertToWs() {
      if ( isConvertionRequired() ) {
         return "WebserviceUtils.convertToWs";
      }
      else {
         return StringUtils.EMPTY;
      }
   }
   
}
