package cb.petal;
import java.util.Collection;

/**
 * Represents Class Utility object, i.e., helper class
 *
 * @version $Id$
 * @author  <A HREF="mailto:markus.dahm@berlin.de">M. Dahm</A>
 */
public class ClassUtility extends Class {
  public ClassUtility(PetalNode parent, Collection params) {
    super(parent, "Class_Utility", params);
  }

  public ClassUtility() {
    setName("Class_Utility");
  }
}
