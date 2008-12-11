package cb.petal;
import java.util.Collection;

/**
 * Represents Instantiation_Relationship object
 *
 * @version $Id$
 * @author  <A HREF="mailto:markus.dahm@berlin.de">M. Dahm</A>
 */
public class InstantiationRelationship extends Relationship {
  public InstantiationRelationship(PetalNode parent, Collection params) {
    super(parent, "Instantiation_Relationship", params);
  }

  public InstantiationRelationship() {
    super("Instantiation_Relationship");
  }

  public void accept(Visitor v) {
    v.visit(this);
  }
}
