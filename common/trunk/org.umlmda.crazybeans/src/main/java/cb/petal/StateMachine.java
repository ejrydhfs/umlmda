package cb.petal;
import java.util.Collection;

/**
 * Represents State_Machine object
 *
 * @version $Id$
 * @author  <A HREF="mailto:markus.dahm@berlin.de">M. Dahm</A>
 */
public class StateMachine extends QuidObject {
  public StateMachine(PetalNode parent, Collection params) {
    super(parent, "State_Machine", params);
  }

  public StateMachine() {
    super("State_Machine");
  }

  public List getStates() {
    return (List)getProperty("states");
  }

  public void setStates(List o) {
    defineProperty("states", o);
  }

  public void accept(Visitor v) {
    v.visit(this);
  }
}
