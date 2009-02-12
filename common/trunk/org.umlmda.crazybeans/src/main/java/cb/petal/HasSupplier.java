package cb.petal;

/**
 * Denote that a petal object contains a reference to another object via
 * the property "supplier", i.e., a fully qualified name like
 * "Logical View::University::Professor".
 *
 * @version $Id$
 * @author  <A HREF="mailto:markus.dahm@berlin.de">M. Dahm</A>
 */
public interface HasSupplier {
  public String getSupplier();
  public void setSupplier(String o);
}
