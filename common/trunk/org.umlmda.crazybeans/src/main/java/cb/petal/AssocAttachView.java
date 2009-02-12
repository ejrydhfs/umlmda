package cb.petal;
import java.util.Collection;

/**
 * Represents AssocAttachView object which is means it is just the line drawn between
 * an association and an association class.
 *
 * @version $Id$
 * @author  <A HREF="mailto:markus.dahm@berlin.de">M. Dahm</A>
 * @see AssociationViewNew
 */
public class AssocAttachView extends View {
  public AssocAttachView(PetalNode parent, Collection params, int tag) {
    super(parent, "AssocAttachView", params, tag);
  }

  public AssocAttachView() {
    super("AssocAttachView");
  }

  public void accept(Visitor v) {
    v.visit(this);
  }
}
