package cb.petal;

import java.util.*;

/**
 * Very simple object, basically just a record.
 *
 * @version $Id$
 * @author  <A HREF="mailto:markus.dahm@berlin.de">M. Dahm</A>
 */
public class SimpleViewObject extends QuiduView {
  public SimpleViewObject(PetalNode parent, String name, Collection params, int tag) {
    super(parent, name, params, tag);
  }
  
  public void accept(Visitor v) {
    v.visit(this);
  }
}
