package cb.petal;
import java.util.Collection;

/**
 * Represents Event object
 *
 * @version $Id$
 * @author  <A HREF="mailto:markus.dahm@berlin.de">M. Dahm</A>
 */
public class Event extends PetalObject implements Named {
  public Event(PetalNode parent, Collection params) {
    super(parent, "Event", params);
  }

  public Event() {
    super("Event");
  }

  public void setNameParameter(String o) {
    params.set(0, o);
  }

  public String getNameParameter() {
    return (String)params.get(0);
  }

  public void accept(Visitor v) {
    v.visit(this);
  }
}
