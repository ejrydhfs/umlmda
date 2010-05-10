package org.umlmda.runtime.sdo.sync.parameter;

import org.umlmda.runtime.sdo.sync.Player;

public class DoubleParameter extends AbstractParameter
{

   private static final long serialVersionUID = 1L;
   private Double            parameter;

   public DoubleParameter() {
   }

   public DoubleParameter(Double parameter) {
      this.parameter = parameter;
   }

   @Override
   public Object getTranslatedValue(Player player) {
      return parameter;
   }
}
