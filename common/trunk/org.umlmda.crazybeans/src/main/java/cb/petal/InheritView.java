package cb.petal;
import java.util.Collection;

/**
 * Represents InheritView object, i.e. view for InheritanceRelationship
 *
 * @version $Id$
 * @author  <A HREF="mailto:markus.dahm@berlin.de">M. Dahm</A>
 * @see InheritanceRelationship
 */
public class InheritView extends RelationshipView {
  public InheritView(PetalNode parent, Collection params, int tag) {
    super(parent, "InheritView", params, tag);
  }

  public InheritView() {
    super("InheritView");
  }

  public void accept(Visitor v) {
    v.visit(this);
  }
}
