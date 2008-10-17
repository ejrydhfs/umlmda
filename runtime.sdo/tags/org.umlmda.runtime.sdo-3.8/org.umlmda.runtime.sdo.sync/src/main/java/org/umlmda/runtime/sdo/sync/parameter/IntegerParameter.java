package org.umlmda.runtime.sdo.sync.parameter;

import org.umlmda.runtime.sdo.sync.Player;

public class IntegerParameter extends AbstractParameter {

   private static final long serialVersionUID = 1L;
   private Integer parameter;

   public IntegerParameter() {
   }

   public IntegerParameter(Integer parameter) {
      this.parameter = parameter;
   }
   
   @Override
   public Object getTranslatedValue(Player player) {
      return parameter;
   }
}
