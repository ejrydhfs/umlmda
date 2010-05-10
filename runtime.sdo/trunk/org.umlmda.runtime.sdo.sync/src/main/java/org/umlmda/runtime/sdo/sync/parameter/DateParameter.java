package org.umlmda.runtime.sdo.sync.parameter;

import java.util.Date;

import org.umlmda.runtime.sdo.sync.Player;

public class DateParameter extends AbstractParameter
{

   private static final long serialVersionUID = 1L;
   private Date              parameter;

   public DateParameter() {
   }

   public DateParameter(Date parameter) {
      this.parameter = parameter;
   }

   @Override
   public Object getTranslatedValue(Player player) {
      return parameter;
   }
}
