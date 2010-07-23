/*
 * Created on 08.12.2005
 */
package org.umlmda.uml.generator.emf;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.umlmda.model.uml.Model;
import org.umlmda.model.uml.ModelDataType;
import org.umlmda.model.uml.ModelDataTypeBase;
import org.umlmda.uml.generator.java.JavaModelDataTypeAdapter;
import org.umlmda.uml.generator.webservices.WSModelDataTypeAdapter;

/**
 * @author MOROFF
 */
public class EMFModelDataTypeAdapter extends WSModelDataTypeAdapter
{

   private static Map                typeMapping         = new HashMap();
   private static Map                optionalTypeMapping = new HashMap();
   private final TypeMappingStrategy typeMappingStrategy = new TypeMappingStrategy() {

                                                            public String getPSMType(ModelDataType dataType, boolean optional,
                                                                  boolean multivalue) {
                                                               String type;
                                                               if ( !multivalue )
                                                                  type = EMFModelDataTypeAdapter.super.getPSMType(optional,
                                                                        multivalue);
                                                               else
                                                                  type = "org.eclipse.emf.common.util.EList";

                                                               return type;
                                                            }

                                                         };

   /**
    * @param modelDataType
    * @param model
    */
   public EMFModelDataTypeAdapter(ModelDataTypeBase modelDataType, Model model) {
      super(modelDataType, model);
   }

   /*
    * (non-Javadoc)
    * @see org.umlmda.generator.model.uml.GeneratorDataType#getPSMType(boolean, boolean)
    */
   public String getPSMType(boolean optional, boolean multivalue) {
      return typeMappingStrategy.getPSMType(this, optional, multivalue);
   }

}
