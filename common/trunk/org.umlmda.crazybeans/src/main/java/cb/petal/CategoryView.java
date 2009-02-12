package cb.petal;
import java.util.Collection;

/**
 * This view corresponds to a ClassCategory object.
 *
 * @version $Id$
 * @author  <A HREF="mailto:markus.dahm@berlin.de">M. Dahm</A>
 */
public class CategoryView extends QuiduView {
  public CategoryView(PetalNode parent, Collection params) {
    super(parent, "CategoryView", params, -1);
  }

  public CategoryView() {
    super("CategoryView");
  }

  public ItemLabel getLabel() {
    return (ItemLabel)getProperty("label");
  }

  public void setLabel(ItemLabel o) {
    defineProperty("label", o);
  }

  public void accept(Visitor v) {
    v.visit(this);
  }
}
