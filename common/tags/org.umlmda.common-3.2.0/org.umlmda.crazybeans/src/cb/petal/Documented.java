package cb.petal;

/**
 * Denote that a petal object may have documentation associated with it.
 *
 * @version $Id$
 * @author  <A HREF="mailto:markus.dahm@berlin.de">M. Dahm</A>
 */
public interface Documented {
  public String getDocumentation();
  public void setDocumentation(String o);
}
