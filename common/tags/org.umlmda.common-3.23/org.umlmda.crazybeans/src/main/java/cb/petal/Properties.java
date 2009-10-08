package cb.petal;
import java.util.Collection;

/**
 * Represents Properties object
 *
 * @version $Id$
 * @author  <A HREF="mailto:markus.dahm@berlin.de">M. Dahm</A>
 */
public class Properties extends QuidObject {
  public Properties(PetalNode parent, Collection params) {
    super(parent, "Properties", params);
  }

  public Properties() {
    super("Properties");
  }

  public List getAttributes() {
    return (List)getProperty("attributes");
  }

  public void setAttributes(List o) {
    defineProperty("attributes", o);
  }

  public void accept(Visitor v) {
    v.visit(this);
  }
}
