package org.umlmda.runtime.sdo.sync.parameter;

import org.umlmda.runtime.sdo.sync.Player;

public class StringParameter extends AbstractParameter
{

   private static final long serialVersionUID = 1L;
   private String            parameter;

   public StringParameter() {
   }

   public StringParameter(String parameter) {
      this.parameter = parameter;
   }

   @Override
   public Object getTranslatedValue(Player player) {
      return parameter;
   }
}
