package cb.petal;
import java.util.Collection;

/**
 * Represents SelfMessView object = message to self in sequence diagram
 *
 * @version $Id$
 * @author  <A HREF="mailto:markus.dahm@berlin.de">M. Dahm</A>
 */
public class SelfMessView extends QuiduView {
  public SelfMessView(PetalNode parent, Collection params, int tag) {
    super(parent, "SelfMessView", params, tag);
  }

  public SelfMessView() {
    super("SelfMessView");
  }

  public SegLabel getLabel() {
    return (SegLabel)getProperty("label");
  }

  public void setLabel(SegLabel o) {
    defineProperty("label", o);
  }

  public Tag getFocusSrc() {
    return (Tag)getProperty("Focus_Src");
  }

  public void setFocusSrc(Tag o) {
    defineProperty("Focus_Src", o);
  }

  public Location getOrigin() {
    return (Location)getProperty("origin");
  }

  public void setOrigin(Location o) {
    defineProperty("origin", o);
  }

  public Location getTerminus() {
    return (Location)getProperty("terminus");
  }

  public void setTerminus(Location o) {
    defineProperty("terminus", o);
  }

  public int getOrdinal() {
    return getPropertyAsInteger("ordinal");
  }

  public void setOrdinal(int o) {
    defineProperty("ordinal", o);
  }

  public void accept(Visitor v) {
    v.visit(this);
  }
}
