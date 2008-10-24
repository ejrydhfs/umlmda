package cb.petal;

/**
 * Super class for all petal nodes, e.g., objects, lists, value, literals, etc..
 *
 * @version $Id$
 * @author  <A HREF="mailto:markus.dahm@berlin.de">M. Dahm</A>
 */
public interface PetalNode extends java.io.Serializable, Cloneable {
  public abstract String getKind();
  public abstract int getChildCount();
  public abstract void accept(Visitor v);
}
