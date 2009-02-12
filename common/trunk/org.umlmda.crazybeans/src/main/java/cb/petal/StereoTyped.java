package cb.petal;

/**
 * Denote that a petal object may have an attribute "stereotype", e.g. classes,
 * methods, ...
 *
 * @version $Id$
 * @author  <A HREF="mailto:markus.dahm@berlin.de">M. Dahm</A>
 */
public interface StereoTyped {
  public String getStereotype();

  public void setStereotype(String c);
}
