package org.umlmda.runtime.sdo.sync.parameter;

import org.umlmda.runtime.sdo.sync.Player;

public class LongParameter extends AbstractParameter
{

   private static final long serialVersionUID = 2L;
   private Long              parameter;

   public LongParameter() {
   }

   public LongParameter(Long parameter) {
      this.parameter = parameter;
   }

   @Override
   public Object getTranslatedValue(Player player) {
      return parameter;
   }
}
