package cb.petal;

/**
 * Denote that a petal object has a SegLabel label
 *
 * @version $Id$
 * @author  <A HREF="mailto:markus.dahm@berlin.de">M. Dahm</A>
 */
public interface SegLabeled {
  public SegLabel getLabel();
  public void setLabel(SegLabel o);
}
