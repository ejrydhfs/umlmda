package org.umlmda.runtime.sdo.sync.parameter;

import org.umlmda.runtime.sdo.sync.Player;

public class CharacterParameter extends AbstractParameter
{

   private static final long serialVersionUID = 2L;
   private Character         parameter;

   public CharacterParameter() {
   }

   public CharacterParameter(Character parameter) {
      this.parameter = parameter;
   }

   @Override
   public Object getTranslatedValue(Player player) {
      return parameter;
   }
}
