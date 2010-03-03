//jUMLMDA, UMLModel-API
//
//$Header: /cvsroot/umlmda/org.umlmda.generator.uml.psm/src/org/umlmda/uml/generator/webservices/WSModelAttributeAdapter.java,v 1.4 2007/01/15 21:21:12 moroff Exp $
//$Source: /cvsroot/umlmda/org.umlmda.generator.uml.psm/src/org/umlmda/uml/generator/webservices/WSModelAttributeAdapter.java,v $
//$Revision: 1.4 $
// $State: Exp $
//  $Name:  $
//  $Date: 2007/01/15 21:21:12 $
//$Locker:  $
//
//This library is free software; you can redistribute it and/or
//modify it under the terms of the GNU Library General Public
//License as published by the Free Software Foundation; either
//version 2 of the License, or (at your option) any later version.
//This library is distributed in the hope that it will be useful,
//but WITHOUT ANY WARRANTY; without even the implied warranty of
//MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
//Library General Public License for more details.
//
//You should have received a copy of the GNU Library General Public
//License along with this library; if not, write to the
//Free Software Foundation, Inc., 59 Temple Place - Suite 330,
//Boston, MA  02111-1307, USA. The text of license can be also found
//at http://www.gnu.org/copyleft/lgpl.html
//
//Created on Sep 23, 2005
package org.umlmda.uml.generator.webservices;

import java.util.Calendar;

import org.apache.commons.lang.StringUtils;
import org.umlmda.model.uml.Model;
import org.umlmda.model.uml.ModelAttributeBase;
import org.umlmda.model.uml.ModelDataType;
import org.umlmda.profile.ModelStereotype;
import org.umlmda.uml.generator.java.JavaArtefacts;
import org.umlmda.uml.generator.java.JavaModelAttributeAdapter;
import org.umlmda.uml.generator.java.JavaModelClass;
import org.umlmda.uml.generator.java.JavaModelDataType;

/**
 * WebService schema adapter for model attributes.
 * 
 * @author vpussel
 * @author Dieter Moroff
 */
public class WSModelAttributeAdapter extends JavaModelAttributeAdapter implements WSModelAttribute {
   static final String WEBSERVICEUTILS_CONVERTCALENDARTOXMLGREGORIANCALENDAR = "WebserviceUtils.convertCalendarToXMLGregorianCalendar";
   static final String WEBSERVICEUTILS_CONVERTDATETOXMLGREGORIANCALENDAR = "WebserviceUtils.convertDateToXMLGregorianCalendar";
   static final String WEBSERVICEUTILS_CONVERT_TO_WS = "WebserviceUtils.convertToWs";
   static final String WEBSERVICEUTILS_CONVERT_FROM_WS = "WebserviceUtils.convertFromWs";
   private final WSModelStructuralFeature delegate;

   public WSModelAttributeAdapter(ModelAttributeBase modelAttribute, Model model) {
      super(modelAttribute, model);
      delegate = new WSModelStructuralFeatureAdapter(modelAttribute, model)  {
         public String getNillableTag() {
            return WSModelAttributeAdapter.this.getNillableTag();
         }
         public String getMinOccursTag() {
            return WSModelAttributeAdapter.this.getMaxOccursTag();
         }
         public String getMaxOccursTag() {
            return WSModelAttributeAdapter.this.getMinOccursTag();
         }
      };
   }

   /* (non-Javadoc)
    * @see org.umlmda.uml.generator.webservices.WSModelStructuralFeature#matchDirection(java.lang.String)
    */
   public boolean matchDirection(String direction) {
      return delegate.matchDirection(direction);
   }

   /* (non-Javadoc)
    * @see org.umlmda.uml.generator.webservices.WSModelAttribute#getSchemaType()
    */
   public String getSchemaType() {
      if ( getDataType() != null ) {
         if ( getDataType().getName().equals("char"))
            return "xsd:string";
         else if ( getDataType().getName().equals(ModelDataType.BINARY))
            return "xsd:hexBinary";
         else
            return "xsd:"+getDataType().getName();
      }
      else if ( getModelClass() instanceof WSModelClass ) {
         WSModelClass modelClass = (WSModelClass) getModelClass();
         
         return modelClass.getSchemaType();
      }
      else 
         return null;
   }

   /* (non-Javadoc)
    * @see org.umlmda.uml.generator.webservices.WSModelAttribute#getConvertToWs(java.lang.String)
    */
   public String getConvertToWs() {
      if ( getModelClassifier().hasStereotype(WSStereotypes.WEB_SERVICE_ENUMERATION)) {
         JavaModelClass genClass = (JavaModelClass) getGeneratorModel().getContext().getCurrentModelElement();
         WSModelClass enumClass = (WSModelClass) getModelClassifier();
         JavaModelClass pimEnumClass = enumClass.getPIMClass();
         String wsEnum = genClass.getScopedName(WSArtefacts.WS_STUB, enumClass); 
       
         // FIXME Parameter for JaxWS handling
         if ( isOptional() ) {
               return "from."+getGetter()+"() != null ? "+wsEnum+".fromValue(from."+getGetter()+"().getValue()) : null";
         }
         else {
               return wsEnum+".fromValue(\"C\"+from."+getGetter()+"().getValue())";            
         }
      }
      else {
         return getConvert(getConvertToWsMethod((WSModelClassifier)getModelClassifier()), "from", getGetter(), getDataType());
      }
   }

   /**
    * @param classifier TODO
    * @return
    */
   String getConvertToWsMethod(WSModelClassifier classifier) {
      if ( getJavaType().equals("javax.xml.datatype.XMLGregorianCalendar")) {
         if ( getWSJavaType().equals(Calendar.class.getName())) 
            return "WebserviceUtils.convertXMLGregorianCalendarToCalendar";
         else
            return "WebserviceUtils.convertXMLGregorianCalendarToDate";
      }
      else
         return WEBSERVICEUTILS_CONVERT_TO_WS;
   }

   /**
    * @param classifier TODO
    * @return
    */
   static String getConvertFromWsMethod(WSModelClassifier classifier) {
      if ( classifier instanceof JavaModelDataType && classifier.getJavaType().equals("javax.xml.datatype.XMLGregorianCalendar")) {
         if ( classifier.getWSJavaType().equals(Calendar.class.getName())) 
            return WEBSERVICEUTILS_CONVERTCALENDARTOXMLGREGORIANCALENDAR;
         else
            return WEBSERVICEUTILS_CONVERTDATETOXMLGREGORIANCALENDAR;
      }
      else  
         return WEBSERVICEUTILS_CONVERT_FROM_WS;
   }
   
   /* (non-Javadoc)
    * @see org.umlmda.uml.generator.webservices.WSModelAttribute#getConvertToWs(java.lang.String)
         // FIXME Parameter for JaxWS handling
    */
   public String getConvertFromWs(String srcInstance) {
      if ( getModelClassifier().hasStereotype(WSStereotypes.WEB_SERVICE_ENUMERATION)) {
         WSModelClass enumClass = (WSModelClass) getModelClassifier();
         String javaEnum = enumClass.getPIMClass().getQualifiedName(JavaArtefacts.ENUMERATION); 
         
         if ( isOptional() ) {
            return srcInstance+"."+getGetter()+"() != null ? "+javaEnum+".fromValue("+srcInstance+"."+getGetter()+"().value()) : null";
         }
         else {
            return javaEnum+".fromValue(StringUtils.substring("+srcInstance+"."+getGetter()+"().value(),1))";
         }
      }
      else {
         if ( getDataType() != null && getDataType().getName().equals(ModelDataType.BOOLEAN)) {
            return getConvert(getConvertFromWsMethod((WSModelClassifier) getModelClassifier()), srcInstance, "is"+StringUtils.capitalize(getName()), getDataType());
         }
         else {
            return getConvert(getConvertFromWsMethod((WSModelClassifier) getModelClassifier()), srcInstance, getGetter(), getDataType());
         }
      }
   }


   private String getConvert(String convertFunction, String srcInstance, String getterName, ModelDataType dataType) {
      String getter = srcInstance + "." + getterName;
      
      if (isConvertionNeeded()) {
         return getConvertSignature(convertFunction, dataType, getter);
      }
      else
         return "" + getter + "()";
   }
   

   static String getConvertSignature(String convertFunction, ModelDataType dataType, String getter) {
      if (dataType != null
            && ModelDataType.DATE.equals(dataType.getName())
            && (convertFunction.equals(WEBSERVICEUTILS_CONVERTDATETOXMLGREGORIANCALENDAR) || convertFunction
                  .equals(WEBSERVICEUTILS_CONVERTCALENDARTOXMLGREGORIANCALENDAR))) {
         return convertFunction + "(" + getter + "(), false, false)";
      }
      else if (dataType != null
            && ModelDataType.DATE_TIME.equals(dataType.getName())
            && (convertFunction.equals(WEBSERVICEUTILS_CONVERTDATETOXMLGREGORIANCALENDAR) || convertFunction
                  .equals(WEBSERVICEUTILS_CONVERTCALENDARTOXMLGREGORIANCALENDAR))) {
         return convertFunction + "(" + getter + "(), true, false)";
      }
      else {
         return convertFunction + "(" + getter + "())";
      }
   }

   /**
    * @see org.umlmda.uml.generator.webservices.WSModelAttribute#getJavaType()
    * Special handling for date and dateTime, mapped to <code>java.util.Calendar</code>,
    * default for other types.
    */
   public String getWSJavaType() {
      return getType(JavaArtefacts.BUSINESS_OBJECT_INTERFACE, WSModelDataTypeAdapter.typeMappingStrategy);
   }
   
   public boolean isConvertionNeeded() {
      String javaType = getJavaType();
      String wsType = getWSJavaType();
      return getModelClassifier().hasStereotype(ModelStereotype.ENUMERATION) 
          || wsType.equals(javaType) == false;
   }
   
   /* (non-Javadoc)
    * @see org.umlmda.uml.generator.webservices.WSModelAttribute#getNillableTag()
    */
   public String getNillableTag() {
      String nillableTag = StringUtils.EMPTY;
      
      if ( isMultivalue() == false ) {
         nillableTag = "nillable=\"" + (isOptional() ? "true" : "false") + "\" ";
      }
      return nillableTag;
   }

   /* (non-Javadoc)
    * @see org.umlmda.uml.generator.webservices.WSModelAttribute#getMinOccursTag()
    */
   public String getMinOccursTag() {
      String minOccursTag = StringUtils.EMPTY;
      
      if ( isMultivalue() == true ) {
         minOccursTag = "minOccurs=\"" + (isOptional() ? "0" : "1") + "\" ";
      }
      return minOccursTag;
   }

   /* (non-Javadoc)
    * @see org.umlmda.uml.generator.webservices.WSModelAttribute#getMaxOccursTag()
    */
   public String getMaxOccursTag() {
      String maxOccursTag = StringUtils.EMPTY;
      
      if ( isMultivalue() == true ) {
         maxOccursTag = "maxOccurs=\"unbounded\" ";
      }
      return maxOccursTag;
   }
 
   /* (non-Javadoc)
    * @see org.umlmda.model.uml.ModelAttributeBase#getInitialValue()
    */
   public String getInitialValue() {
      String initialValue = super.getInitialValue();
      
      if ( initialValue != null && initialValue.startsWith("\"")) {
         return initialValue.substring(1, initialValue.length()-1);
      }
      else {
         return initialValue;
      }
   }

   
   public String getConvertParameterToWs() {
      StringBuffer buffer = new StringBuffer();
      
      if ( getModelClassifier() instanceof ModelDataType ) {
         WSModelDataType wsDataType = (WSModelDataType) getModelClassifier();
         
         if ( wsDataType.isConvertionRequired() ) {
            buffer.append(getConvertToWsMethod((WSModelClassifier)getModelClassifier()));
            buffer.append("(");
         }
         buffer.append(getName());
         if ( wsDataType.isConvertionRequired() ) 
            buffer.append(")");
      }
      else {
         WSModelClass wsParamClass = (WSModelClass) getModelClassifier();
         JavaModelClass pimParamClass = wsParamClass.getPIMClass();
         
         buffer.append("utils.create");
         buffer.append(wsParamClass.getName());
         buffer.append("(");
         buffer.append(getName());
         buffer.append(")");
      }
      
      return buffer.toString();
   }
}
