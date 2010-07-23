package cb.generator;

import java.util.List;

/**
 * Represents a Method containing code.
 *
 * @version $Id$
 * @author <A HREF="mailto:markus.dahm@berlin.de">M. Dahm</A>
 */
public interface Method extends Node {
  public void setParameters(List p);
  public List getParameters();

  public void   setCode(List c);
  public List   getCode();
  public void   setReturnType(String p);
  public String getReturnType();
}
