package cb.petal;
import java.util.Collection;

/**
 * Represents ActivityStateView object
 *
 * @version $Id$
 * @author  <A HREF="mailto:markus.dahm@berlin.de">M. Dahm</A>
 */
public class ActivityStateView extends View {
  public ActivityStateView(PetalNode parent, Collection params, int tag) {
    super(parent, "ActivityStateView", params, tag);
  }

  public ActivityStateView() {
    super("ActivityStateView");
  }

  public void accept(Visitor v) {
    v.visit(this);
  }
}
