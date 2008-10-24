package cb.petal;
import java.util.Collection;

/**
 * Represents RealizeView object
 *
 * @version $Id$
 * @author  <A HREF="mailto:markus.dahm@berlin.de">M. Dahm</A>
 * @see RealizeRelationship
 */
public class RealizeView extends RelationshipView {
  public RealizeView(PetalNode parent, Collection params, int tag) {
    super(parent, "RealizeView", params, tag);
  }

  public RealizeView() {
    super("RealizeView");
  }

  public void accept(Visitor v) {
    v.visit(this);
  }
}
