package cb.petal;
import java.util.Collection;

/**
 * Represents ActionTime object
 *
 * @version $Id$
 * @author  <A HREF="mailto:markus.dahm@berlin.de">M. Dahm</A>
 */
public class ActionTime extends PetalObject {
  public ActionTime(PetalNode parent, Collection params) {
    super(parent, "ActionTime", params);
  }

  public ActionTime() {
    super("ActionTime");
  }

  public String getWhen() {
    return getPropertyAsString("when");
  }

  public void setWhen(String o) {
    defineProperty("when", o);
  }

  public void accept(Visitor v) {
    v.visit(this);
  }
}
