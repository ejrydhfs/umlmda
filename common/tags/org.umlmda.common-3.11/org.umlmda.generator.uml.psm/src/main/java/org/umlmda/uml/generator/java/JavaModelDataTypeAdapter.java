/*
 * Created on 08.12.2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package org.umlmda.uml.generator.java;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.umlmda.generator.model.uml.GeneratorModel;
import org.umlmda.generator.model.util.StringUtil;
import org.umlmda.model.uml.Model;
import org.umlmda.model.uml.ModelDataType;
import org.umlmda.model.uml.ModelDataTypeBase;
import org.umlmda.model.uml.impl.ModelDataTypeAdapter;

/**
 * @author MOROFF
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class JavaModelDataTypeAdapter extends ModelDataTypeAdapter implements JavaModelDataType {
   private static Map javaTypeMapping = new HashMap();
   private static Map optionalJavaTypeMapping = new HashMap();
   private static Map javaTZIndepentendTypeMapping = new HashMap();
   private static Map optionalJavaTZIndependentTypeMapping = new HashMap();
   final TypeMappingStrategy typeMappingStrategy = new TypeMappingStrategy() {

      public String getPSMType(ModelDataType dataType, boolean optional, boolean multivalue) {
         String type;
         if ( getGeneratorModel().getProperties().getProperty("timezoneIndependent", "false").equals("true")) {
	         if ( optional && !multivalue) 
	            type = (String) optionalJavaTZIndependentTypeMapping.get(dataType.getName());
	         else
	            type = (String) javaTZIndepentendTypeMapping.get(dataType.getName());
         }
         else {
	         if ( optional && !multivalue) 
	            type = (String) optionalJavaTypeMapping.get(dataType.getName());
	         else
	            type = (String) javaTypeMapping.get(dataType.getName());
	         }
         if (multivalue) {
            type = type + "[]";
         }

         return type;
      }
      
   };
   
   static {
      javaTypeMapping.put(ModelDataType.BINARY, "byte[]");
      javaTypeMapping.put(ModelDataType.BOOLEAN, "boolean");
      javaTypeMapping.put(ModelDataType.CHAR, "char");
      javaTypeMapping.put(ModelDataType.DATE, Date.class.getName());
      javaTypeMapping.put(ModelDataType.DATE_TIME, Date.class.getName());
      javaTypeMapping.put(ModelDataType.DECIMAL, BigDecimal.class.getName());
      javaTypeMapping.put(ModelDataType.DOUBLE, "double");
      javaTypeMapping.put(ModelDataType.FLOAT, "float");
      javaTypeMapping.put(ModelDataType.INT, "int");
      javaTypeMapping.put(ModelDataType.LONG, "long");
      javaTypeMapping.put(ModelDataType.SHORT, "short");
      javaTypeMapping.put(ModelDataType.STRING, "String");
      javaTypeMapping.put(ModelDataType.TIMESTAMP, Date.class.getName());
      javaTypeMapping.put(ModelDataType.VOID, "void");
      
      javaTZIndepentendTypeMapping.put(ModelDataType.BINARY, "byte[]");
      javaTZIndepentendTypeMapping.put(ModelDataType.BOOLEAN, "boolean");
      javaTZIndepentendTypeMapping.put(ModelDataType.CHAR, "char");
      javaTZIndepentendTypeMapping.put(ModelDataType.DATE, "javax.xml.datatype.XMLGregorianCalendar");
      javaTZIndepentendTypeMapping.put(ModelDataType.DATE_TIME, "javax.xml.datatype.XMLGregorianCalendar");
      javaTZIndepentendTypeMapping.put(ModelDataType.DECIMAL, BigDecimal.class.getName());
      javaTZIndepentendTypeMapping.put(ModelDataType.DOUBLE, "double");
      javaTZIndepentendTypeMapping.put(ModelDataType.FLOAT, "float");
      javaTZIndepentendTypeMapping.put(ModelDataType.INT, "int");
      javaTZIndepentendTypeMapping.put(ModelDataType.LONG, "long");
      javaTZIndepentendTypeMapping.put(ModelDataType.SHORT, "short");
      javaTZIndepentendTypeMapping.put(ModelDataType.STRING, "String");
      javaTZIndepentendTypeMapping.put(ModelDataType.TIMESTAMP, Date.class.getName());
      javaTZIndepentendTypeMapping.put(ModelDataType.VOID, "void");
      
      optionalJavaTypeMapping.put(ModelDataType.BINARY, "byte[]");
      optionalJavaTypeMapping.put(ModelDataType.BOOLEAN, Boolean.class.getName());
      optionalJavaTypeMapping.put(ModelDataType.CHAR, Character.class.getName());
      optionalJavaTypeMapping.put(ModelDataType.DATE, Date.class.getName());
      optionalJavaTypeMapping.put(ModelDataType.DATE_TIME, Date.class.getName());
      optionalJavaTypeMapping.put(ModelDataType.DECIMAL, BigDecimal.class.getName());
      optionalJavaTypeMapping.put(ModelDataType.DOUBLE, Double.class.getName());
      optionalJavaTypeMapping.put(ModelDataType.FLOAT, Float.class.getName());
      optionalJavaTypeMapping.put(ModelDataType.INT, Integer.class.getName());
      optionalJavaTypeMapping.put(ModelDataType.LONG, Long.class.getName());
      optionalJavaTypeMapping.put(ModelDataType.SHORT, Short.class.getName());
      optionalJavaTypeMapping.put(ModelDataType.STRING, "String");
      optionalJavaTypeMapping.put(ModelDataType.TIMESTAMP, Date.class.getName());
      optionalJavaTypeMapping.put(ModelDataType.VOID, "void");
      
      optionalJavaTZIndependentTypeMapping.put(ModelDataType.BINARY, "byte[]");
      optionalJavaTZIndependentTypeMapping.put(ModelDataType.BOOLEAN, Boolean.class.getName());
      optionalJavaTZIndependentTypeMapping.put(ModelDataType.CHAR, Character.class.getName());
      optionalJavaTZIndependentTypeMapping.put(ModelDataType.DATE, "javax.xml.datatype.XMLGregorianCalendar");
      optionalJavaTZIndependentTypeMapping.put(ModelDataType.DATE_TIME, "javax.xml.datatype.XMLGregorianCalendar");
      optionalJavaTZIndependentTypeMapping.put(ModelDataType.DECIMAL, BigDecimal.class.getName());
      optionalJavaTZIndependentTypeMapping.put(ModelDataType.DOUBLE, Double.class.getName());
      optionalJavaTZIndependentTypeMapping.put(ModelDataType.FLOAT, Float.class.getName());
      optionalJavaTZIndependentTypeMapping.put(ModelDataType.INT, Integer.class.getName());
      optionalJavaTZIndependentTypeMapping.put(ModelDataType.LONG, Long.class.getName());
      optionalJavaTZIndependentTypeMapping.put(ModelDataType.SHORT, Short.class.getName());
      optionalJavaTZIndependentTypeMapping.put(ModelDataType.STRING, "String");
      optionalJavaTZIndependentTypeMapping.put(ModelDataType.TIMESTAMP, Date.class.getName());
      optionalJavaTZIndependentTypeMapping.put(ModelDataType.VOID, "void");
   }

   /**
    * @param modelDataType
    * @param model
    */
   public JavaModelDataTypeAdapter(ModelDataTypeBase modelDataType, Model model) {
      super(modelDataType, model);
   }

   /* (non-Javadoc)
    * @see org.umlmda.generator.model.uml.GeneratorModelElement#getGeneratedName()
    */
   public String getGeneratedName() {
      return getJavaType();
   }

   /* (non-Javadoc)
    * @see org.umlmda.generator.model.uml.GeneratorModelElement#getGeneratorModel()
    */
   public GeneratorModel getGeneratorModel() {
      return (GeneratorModel) getModel();
   }

   /* (non-Javadoc)
    * @see org.umlmda.generator.model.uml.GeneratorModelElement#getReplacementName()
    */
   public String getReplacementName() {
      return getName();
   }

   /* (non-Javadoc)
    * @see org.umlmda.generator.model.uml.GeneratorModelElement#getDocumentation(java.lang.String)
    */
   public String getDocumentation(String context) {
      return getDocumentation();
   }

   /* (non-Javadoc)
    * @see org.umlmda.uml.generator.java.JavaModelClassifier#getType(java.lang.String)
    */
   public String getType(String artefact) {
      return getJavaType();
   }

   /* (non-Javadoc)
    * @see org.umlmda.uml.generator.java.JavaModelDataType#getJavaType()
    */
   public final String getJavaType() {
      return typeMappingStrategy.getPSMType(this, false, false);
   }

   public final String getOptionalJavaType() {
      return typeMappingStrategy.getPSMType(this, true, false);
   }

   /* (non-Javadoc)
    * @see org.umlmda.model.uml.ModelAttributeBase#isPrimitiveType()
    */
   public boolean isJavaPrimitiveType() {
      if ( ModelDataType.STRING.equals(getName()) ) { 
         return false;
      }
      else if ( ModelDataType.DATE.equals(getName()) ) { 
         return false;
      }
      else if ( ModelDataType.DATE_TIME.equals(getName()) ) { 
         return false;
      }
      else if ( ModelDataType.DECIMAL.equals(getName()) ) { 
         return false;
      }
      else {
         return true;
      }
   }

   public void setAsCurrentArtefact(String artefact) {
      getGeneratorModel().getContext().setCurrentModelElement(this);
      getGeneratorModel().getContext().setCurrentArtefact(getGeneratorModel().getArtefact(artefact, this));
   }

   public final TypeMappingStrategy getJavaTypeMappingStrategy() {
      return typeMappingStrategy;
   }
   
   public TypeMappingStrategy getPSMTypeMappingStrategy() {
      return typeMappingStrategy;
   }
   
   /* (non-Javadoc)
    * @see org.umlmda.generator.model.uml.GeneratorDataType#getPSMType(boolean, boolean)
    */
   public String getPSMType(boolean optional, boolean multivalue) {
      return getPSMTypeMappingStrategy().getPSMType(this, optional, multivalue);
   }
   
   public String getUpperCaseIdentifier() {
      return StringUtil.toUpperCaseIdentifier(getName());
   }
   
}
