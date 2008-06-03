package org.umlmda.runtime.sdo.sync.parameter;

import java.io.Serializable;

import org.umlmda.runtime.sdo.sync.Player;

public abstract class AbstractParameter implements Serializable {

   public abstract Object getTranslatedValue(Player player);
}
