package cb.petal;
import java.util.Collection;

/**
 * Represents Process object
 *
 * @version $Id$
 * @author  <A HREF="mailto:markus.dahm@berlin.de">M. Dahm</A>
 */
public class Process extends QuidObject {
  public Process(PetalNode parent, Collection params) {
    super(parent, "Process", params);
  }

  public Process() {
    super("Process");
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

  public String getStereotype() {
    return getPropertyAsString("stereotype");
  }

  public void setStereotype(String o) {
    defineProperty("stereotype", o);
  }

  public String getPriority() {
    return getPropertyAsString("priority");
  }

  public void setPriority(String o) {
    defineProperty("priority", o);
  }

  public void accept(Visitor v) {
    v.visit(this);
  }
}
