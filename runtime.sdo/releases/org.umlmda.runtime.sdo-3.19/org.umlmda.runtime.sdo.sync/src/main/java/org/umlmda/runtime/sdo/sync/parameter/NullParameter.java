package org.umlmda.runtime.sdo.sync.parameter;

import org.umlmda.runtime.sdo.sync.Player;

public class NullParameter extends AbstractParameter
{
   private static final long serialVersionUID = 1L;

   @Override
   public Object getTranslatedValue(Player player) {
      return null;
   }

}
