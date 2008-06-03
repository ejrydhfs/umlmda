package cb.petal;
import java.util.Collection;

/**
 * Represents LinkView object
 *
 * @version $Id$
 * @author  <A HREF="mailto:markus.dahm@berlin.de">M. Dahm</A>
 */
public class LinkView extends QuiduView {
  public LinkView(PetalNode parent, Collection params, int tag) {
    super(parent, "LinkView", params, tag);
  }

  public LinkView() {
    super("LinkView");
  }

  public void accept(Visitor v) {
    v.visit(this);
  }
}
