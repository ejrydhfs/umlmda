package cb.petal;

import java.util.*;

/**
 * Super class for all quid objects that also have a quidu property
 * defined.
 *
 * @version $Id$
 * @author <A HREF="mailto:markus.dahm@berlin.de">M. Dahm</A>
 */
public abstract class QuiduObject extends QuidObject implements HasQuidu {
  protected QuiduObject(PetalNode parent, String name, Collection params) {
    super(parent, name, params);
  }

  protected QuiduObject(String name) {
    super(name);
  }

  static String getQuidu(HasQuidu obj) {
    return PetalObject.getPropertyAsString((PetalObject)obj, "quidu");
  }

  public void setQuidu(String quid) {
    defineProperty("quidu", quid);
  }

  public String getQuidu() {
    return getQuidu(this);
  }

  public long getQuiduAsLong() {
    return Long.parseLong(getQuidu(), 16);
  }

  public void setQuiduAsLong(long quid) {
    defineProperty("quidu", Long.toHexString(quid).toUpperCase());
  }

  public final QuidObject getReferencedObject() {
    return getRoot().getReferencedObject(this);
  }
}
