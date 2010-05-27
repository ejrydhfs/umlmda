package org.umlmda.runtime.sdo.sync.parameter;

import org.umlmda.runtime.sdo.sync.Player;

public class ShortParameter extends AbstractParameter
{

   private static final long serialVersionUID = 2L;
   private Short             parameter;

   public ShortParameter() {
   }

   public ShortParameter(Short parameter) {
      this.parameter = parameter;
   }

   @Override
   public Object getTranslatedValue(Player player) {
      return parameter;
   }
}
