package org.umlmda.runtime.sdo.sync.parameter;

import java.math.BigDecimal;

import org.umlmda.runtime.sdo.sync.Player;

public class BigDecimalParameter extends AbstractParameter
{

   private static final long serialVersionUID = 2L;
   private BigDecimal        parameter;

   public BigDecimalParameter() {
   }

   public BigDecimalParameter(BigDecimal parameter) {
      this.parameter = parameter;
   }

   @Override
   public Object getTranslatedValue(Player player) {
      return parameter;
   }
}
