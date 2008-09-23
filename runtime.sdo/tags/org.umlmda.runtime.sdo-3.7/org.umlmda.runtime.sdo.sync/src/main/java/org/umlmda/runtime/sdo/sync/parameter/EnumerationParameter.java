package org.umlmda.runtime.sdo.sync.parameter;

import org.umlmda.runtime.lang.Enumeration;
import org.umlmda.runtime.sdo.sync.Player;

public class EnumerationParameter extends AbstractParameter {

   private static final long serialVersionUID = 1L;
   private Enumeration parameter;

   public EnumerationParameter() {
   }

   public EnumerationParameter(Enumeration parameter) {
      this.parameter = parameter;
   }
   
   @Override
   public Object getTranslatedValue(Player player) {
      return parameter;
   }
}
