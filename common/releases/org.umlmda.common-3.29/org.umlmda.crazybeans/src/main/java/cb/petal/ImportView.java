package cb.petal;
import java.util.Collection;

/**
 * Represents ImportView object
 *
 * @version $Id$
 * @author  <A HREF="mailto:markus.dahm@berlin.de">M. Dahm</A>
 */
public class ImportView extends QuiduView {
  public ImportView(PetalNode parent, Collection params, int tag) {
    super(parent, "ImportView", params, tag);
  }

  public ImportView() {
    super("ImportView");
  }

  public void accept(Visitor v) {
    v.visit(this);
  }
}
