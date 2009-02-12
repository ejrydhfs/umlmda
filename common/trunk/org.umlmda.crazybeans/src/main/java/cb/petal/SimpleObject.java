package cb.petal;

import java.util.*;

/**
 * Very simple object, basically just a record.
 *
 * @version $Id$
 * @author  <A HREF="mailto:markus.dahm@berlin.de">M. Dahm</A>
 */
public class SimpleObject extends QuidObject {
  public SimpleObject(PetalNode parent, String name, Collection params) {
    super(parent, name, params);
  }
  
  public void accept(Visitor v) {
    v.visit(this);
  }
}
