package cb.petal;

/**
 * Denote that a petal object may have an attribute "exportControl", e.g. classes,
 * methods, ..., which refers to a qualifier like "public", "protected", ...
 *
 * @version $Id$
 * @author  <A HREF="mailto:markus.dahm@berlin.de">M. Dahm</A>
 */
public interface AccessQualified {
  public String getExportControl();
  public void setExportControl(String o);
}
