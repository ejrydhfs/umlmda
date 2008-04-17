package cb.petal;
import java.util.Collection;

/**
 * Represents ProcessorView object
 *
 * @version $Id$
 * @author  <A HREF="mailto:markus.dahm@berlin.de">M. Dahm</A>
 */
public class ProcessorView extends QuiduView {
  public ProcessorView(PetalNode parent, Collection params, int tag) {
    super(parent, "ProcessorView", params, tag);
  }

  public ProcessorView() {
    super("ProcessorView");
  }

  public ItemLabel getLabel() {
    return (ItemLabel)getProperty("label");
  }

  public void setLabel(ItemLabel o) {
    defineProperty("label", o);
  }

  public int getAnnotation() {
    return getPropertyAsInteger("annotation");
  }

  public void setAnnotation(int o) {
    defineProperty("annotation", o);
  }

  public void accept(Visitor v) {
    v.visit(this);
  }
}
