package cb.petal;

/**
 * Denote that a petal object has a tag, i.e. @12
 *
 * @version $Id$
 * @author  <A HREF="mailto:markus.dahm@berlin.de">M. Dahm</A>
 */
public interface Tagged {
  public void setTag(int t);
  public int  getTag();
}
