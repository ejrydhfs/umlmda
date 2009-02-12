package cb.generator;

/**
 * Represents a formal parameter of a method,
 *
 * @version $Id$
 * @author <A HREF="mailto:markus.dahm@berlin.de">M. Dahm</A>
 */
public interface Parameter extends Node {
  public void   setType(String p);
  public String getType();
}
