package cb.petal;
import java.util.Collection;

/**
 * Represents UsesView object
 *
 * @version $Id$
 * @author  <A HREF="mailto:markus.dahm@berlin.de">M. Dahm</A>
 */
public class UsesView extends RelationshipView {
  public UsesView(PetalNode parent, Collection params, int tag) {
    super(parent, "UsesView", params, tag);
  }

  public UsesView() {
    super("UsesView");
  }

  public void accept(Visitor v) {
    v.visit(this);
  }
}
