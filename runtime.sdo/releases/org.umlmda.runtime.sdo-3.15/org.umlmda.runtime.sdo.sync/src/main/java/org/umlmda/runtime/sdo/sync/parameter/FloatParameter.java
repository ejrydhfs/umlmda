package org.umlmda.runtime.sdo.sync.parameter;

import org.umlmda.runtime.sdo.sync.Player;

public class FloatParameter extends AbstractParameter
{

   private static final long serialVersionUID = 2L;
   private Float             parameter;

   public FloatParameter() {
   }

   public FloatParameter(Float parameter) {
      this.parameter = parameter;
   }

   @Override
   public Object getTranslatedValue(Player player) {
      return parameter;
   }
}
