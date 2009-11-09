package cb.petal;
import java.util.Collection;

/**
 * Represents action object
 *
 * @version $Id$
 * @author  <A HREF="mailto:markus.dahm@berlin.de">M. Dahm</A>
 */
public class Action extends QuidObject implements Named {
  public Action(PetalNode parent, Collection params) {
    super(parent, "action", params);
  }

  public Action() {
    super("action");
  }

  public void setNameParameter(String o) {
    params.set(0, o);
  }

  public String getNameParameter() {
    return (String)params.get(0);
  }

  public ActionTime getActionTime() {
    return (ActionTime)getProperty("ActionTime");
  }

  public void setActionTime(ActionTime o) {
    defineProperty("ActionTime", o);
  }

  public void accept(Visitor v) {
    v.visit(this);
  }
}
