package org.umlmda.runtime.sdo.sync.parameter;

import org.umlmda.runtime.sdo.sync.Player;
import org.umlmda.runtime.sdo.sync.SynchronizedObject;
import org.umlmda.runtime.sdo.sync.SynchronizedObjectProxy;

public class ObjectParameter extends AbstractParameter {

   private static final long serialVersionUID = 1L;
   private SynchronizedObjectProxy objectProxy;

   public ObjectParameter() {
   }

   public ObjectParameter(SynchronizedObject object) {
      objectProxy = new SynchronizedObjectProxy(object.getRecordObjectId());
   }
   
   @Override
   public Object getTranslatedValue(Player player) {
      return player.getObject(objectProxy);
   }

}
