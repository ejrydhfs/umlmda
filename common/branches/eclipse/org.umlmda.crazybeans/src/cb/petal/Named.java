package cb.petal;

/**
 * Denote that a petal object has a name parameter, e.g.
 * (object Class "Person" ...)
 *
 * @version $Id$
 * @author  <A HREF="mailto:markus.dahm@berlin.de">M. Dahm</A>
 */
public interface Named {
  public void   setNameParameter(String o);
  public String getNameParameter();
}
