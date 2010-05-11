package org.umlmda.runtime.sdo.sync.parameter;

import org.umlmda.runtime.sdo.sync.Player;

public class BooleanParameter extends AbstractParameter
{

   private static final long serialVersionUID = 1L;
   private Boolean           parameter;

   public BooleanParameter() {
   }

   public BooleanParameter(Boolean parameter) {
      this.parameter = parameter;
   }

   @Override
   public Object getTranslatedValue(Player player) {
      return parameter;
   }
}
