package cb.petal;
import java.util.Collection;

/**
 * Represents DecisionView object
 *
 * @version $Id$
 * @author  <A HREF="mailto:markus.dahm@berlin.de">M. Dahm</A>
 */
public class DecisionView extends View {
  public DecisionView(PetalNode parent, Collection params, int tag) {
    super(parent, "DecisionView", params, tag);
  }

  public DecisionView() {
    super("DecisionView");
  }

  public void accept(Visitor v) {
    v.visit(this);
  }
}
