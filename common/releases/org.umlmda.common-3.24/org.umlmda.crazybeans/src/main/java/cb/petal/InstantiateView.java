package cb.petal;
import java.util.Collection;

/**
 * Represents InstantiateView object
 *
 * @version $Id$
 * @author  <A HREF="mailto:markus.dahm@berlin.de">M. Dahm</A>
 */
public class InstantiateView extends QuiduView {
  public InstantiateView(PetalNode parent, Collection params, int tag) {
    super(parent, "InstantiateView", params, tag);
  }

  public InstantiateView() {
    super("InstantiateView");
  }

  public void accept(Visitor v) {
    v.visit(this);
  }
}
