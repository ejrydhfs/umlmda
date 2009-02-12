package cb.petal;
import java.util.Collection;

/**
 * Represents InheritTreeView object
 *
 * @version $Id$
 * @author  <A HREF="mailto:markus.dahm@berlin.de">M. Dahm</A>
 */
public class InheritTreeView extends QuiduView {
  public InheritTreeView(PetalNode parent, Collection params, int tag) {
    super(parent, "InheritTreeView", params, tag);
  }

  public InheritTreeView() {
    super("InheritTreeView");
  }

  public List getVertices() {
    return (List)getProperty("vertices");
  }

  public void setVertices(List o) {
    defineProperty("vertices", o);
  }

  public void accept(Visitor v) {
    v.visit(this);
  }
}
