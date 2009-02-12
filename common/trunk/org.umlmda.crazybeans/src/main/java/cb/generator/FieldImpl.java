package cb.generator;

import java.io.PrintWriter;
import java.util.*;
import cb.petal.ClassAttribute;

/**
 * Simple representation of a Java field.
 *
 * @version $Id$
 * @author <A HREF="mailto:markus.dahm@berlin.de">M. Dahm</A>
 */
public class FieldImpl extends NodeImpl implements Field {
  private   String init, type;
  protected ClassAttribute attribute;

  public FieldImpl() {  }

  public void           setAttribute(ClassAttribute a) { attribute = a; }
  public ClassAttribute getAttribute()                 { return attribute; }

  public void   setInitialValue(String s) { init = s; }
  public String getInitialValue() { return init; }
  public void   setType(String p) { type = p; }
  public String getType() { return type; }

  /** Default implementation prints Java code
   */
  public void dump(PrintWriter stream) {
    printDocumentation(stream, attribute);

    stream.print("  ");
    print(stream, "", getAccess(), " ");
    stream.print(getType() + " " + getName());
    print(stream, " = ", getInitialValue(), "");
    stream.println(";");
  }

  public boolean equals(Object o) {
    if(o instanceof Field) {
      Field f = (Field)o;

      return getType().equals(f.getType()) && getName().equals(f.getName());
    } else
      return false;
  }
}
