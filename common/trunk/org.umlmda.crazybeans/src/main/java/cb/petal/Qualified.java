package cb.petal;

/**
 * Denote that a petal object has a qualified name parameter, e.g.
 * "Logical View::University::Professor"
 *
 * @version $Id$
 * @author  <A HREF="mailto:markus.dahm@berlin.de">M. Dahm</A>
 */
public interface Qualified {
  public void setQualifiedNameParameter(String name);
  public String getQualifiedNameParameter();
}
