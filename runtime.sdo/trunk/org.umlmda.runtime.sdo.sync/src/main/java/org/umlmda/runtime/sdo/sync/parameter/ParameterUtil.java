package org.umlmda.runtime.sdo.sync.parameter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.umlmda.runtime.lang.Enumeration;
import org.umlmda.runtime.sdo.sync.Player;
import org.umlmda.runtime.sdo.sync.SynchronizedObject;

public class ParameterUtil {

   static public List<AbstractParameter> toList(Object [] parameters) {
      List<AbstractParameter> parameterList = new ArrayList<AbstractParameter>(parameters.length);

      for (int i = 0; i < parameters.length; i++) {
         Object parameter = parameters[i];

         if ( parameter instanceof String ) {
            parameterList.add(new StringParameter((String) parameter));
         }
         else if ( parameter instanceof SynchronizedObject ) {
            parameterList.add(new ObjectParameter((SynchronizedObject) parameter));
         }
         else if ( parameter instanceof Boolean ) {
            parameterList.add(new BooleanParameter((Boolean) parameter));
         }
         else if ( parameter instanceof Date ) {
            parameterList.add(new DateParameter((Date) parameter));
         }
         else if ( parameter instanceof Double ) {
            parameterList.add(new DoubleParameter((Double) parameter));
         }
         else if ( parameter instanceof Integer ) {
            parameterList.add(new IntegerParameter((Integer) parameter));
         }
         else if ( parameter instanceof Enumeration ) {
            parameterList.add(new EnumerationParameter((Enumeration) parameter));
         }

         else {
            throw new IllegalArgumentException(parameter.getClass()+ " not supported");
         }
      }

      return parameterList;
   }

   static public Object[] toArray(List<AbstractParameter> parameterList, Player player) {
      Object[] parameters = new Object[parameterList.size()];

      int i = 0;
      for (AbstractParameter parameter : parameterList) {
          parameters[i++] = parameter.getTranslatedValue(player);
      }

      return parameters;
   }


}
