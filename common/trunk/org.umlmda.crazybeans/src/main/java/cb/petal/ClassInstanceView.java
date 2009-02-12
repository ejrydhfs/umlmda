package cb.petal;
import java.util.Collection;

/**
 * Represents ClassInstanceView object
 *
 * @version $Id$
 * @author  <A HREF="mailto:markus.dahm@berlin.de">M. Dahm</A>
 */
public class ClassInstanceView extends QuiduView {
  public ClassInstanceView(PetalNode parent, Collection params, int tag) {
    super(parent, "ClassInstanceView", params, tag);
  }

  public ClassInstanceView() {
    super("ClassInstanceView");
  }

  public void accept(Visitor v) {
    v.visit(this);
  }
}
