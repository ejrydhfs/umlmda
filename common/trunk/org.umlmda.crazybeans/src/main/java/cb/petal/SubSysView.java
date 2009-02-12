package cb.petal;
import java.util.Collection;

/**
 * Represents SubSysView object
 *
 * @version $Id$
 * @author  <A HREF="mailto:markus.dahm@berlin.de">M. Dahm</A>
 */
public class SubSysView extends QuiduView {
  public SubSysView(PetalNode parent, Collection params, int tag) {
    super(parent, "SubSysView", params, tag);
  }

  public SubSysView() {
    super("SubSysView");
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
