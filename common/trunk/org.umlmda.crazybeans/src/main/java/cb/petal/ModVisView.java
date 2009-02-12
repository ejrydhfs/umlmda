package cb.petal;
import java.util.Collection;

/**
 * Represents ModVisView object
 *
 * @version $Id$
 * @author  <A HREF="mailto:markus.dahm@berlin.de">M. Dahm</A>
 */
public class ModVisView extends QuiduView {
  public ModVisView(PetalNode parent, Collection params, int tag) {
    super(parent, "ModVisView", params, tag);
  }

  public ModVisView() {
    super("ModVisView");
  }

  public void accept(Visitor v) {
    v.visit(this);
  }
}
