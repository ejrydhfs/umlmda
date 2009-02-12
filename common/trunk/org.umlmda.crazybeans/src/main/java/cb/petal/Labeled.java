package cb.petal;

/**
 * Denote that a petal object may have a label.
 *
 * @version $Id$
 * @author  <A HREF="mailto:markus.dahm@berlin.de">M. Dahm</A>
 */
public interface Labeled {
  public void   setLabel(String o);
  public String getLabel();
}
