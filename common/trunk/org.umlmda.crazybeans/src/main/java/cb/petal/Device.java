package cb.petal;
import java.util.Collection;

/**
 * Represents Device object
 *
 * @version $Id$
 * @author  <A HREF="mailto:markus.dahm@berlin.de">M. Dahm</A>
 */
public class Device extends QuidObject {
  public Device(PetalNode parent, Collection params) {
    super(parent, "Device", params);
  }

  public Device() {
    super("Device");
  }

  public void setNameParameter(String o) {
    params.set(0, o);
  }

  public String getNameParameter() {
    return (String)params.get(0);
  }

  public String getDocumentation() {
    return getPropertyAsString("documentation");
  }

  public void setDocumentation(String o) {
    defineProperty("documentation", o);
  }

  public String getCharacteristics() {
    return getPropertyAsString("characteristics");
  }

  public void setCharacteristics(String o) {
    defineProperty("characteristics", o);
  }

  public void accept(Visitor v) {
    v.visit(this);
  }
}
