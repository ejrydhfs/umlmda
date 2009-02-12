package cb.petal;
import java.util.Collection;

/**
 * Super class for all relationships between classes.
 *
 * @version $Id$
 * @author  <A HREF="mailto:markus.dahm@berlin.de">M. Dahm</A>
 */
public abstract class Relationship extends QuiduObject
  implements HasSupplier, StereoTyped, Labeled, Documented
{
  public Relationship(PetalNode parent, String name, Collection params) {
    super(parent, name, params);
  }

  public Relationship(String name) {
    super(name);
  }

  public String getSupplier() {
    return getPropertyAsString("supplier");
  }

  public void setSupplier(String o) {
    defineProperty("supplier", o);
  }

  public String getStereotype() {
    return getPropertyAsString("stereotype");
  }

  public void setStereotype(String c) {
    defineProperty("stereotype", c);
  }

  public void setLabel(String o) {
    defineProperty("label", o);
  }

  public String getLabel() {
    return getPropertyAsString("label");
  }

  public void setDocumentation(String o) {
    defineProperty("documentation", o);
  }

  public String getDocumentation() {
    return getPropertyAsString("documentation");
  }
}
