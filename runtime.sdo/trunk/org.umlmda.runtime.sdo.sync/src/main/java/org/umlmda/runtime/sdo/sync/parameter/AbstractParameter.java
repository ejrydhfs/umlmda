package org.umlmda.runtime.sdo.sync.parameter;

import java.io.Serializable;

import org.umlmda.runtime.sdo.sync.Player;

public abstract class AbstractParameter implements Serializable
{

   private static final long serialVersionUID = 7932145032068182320L;

   public abstract Object getTranslatedValue(Player player);
}
