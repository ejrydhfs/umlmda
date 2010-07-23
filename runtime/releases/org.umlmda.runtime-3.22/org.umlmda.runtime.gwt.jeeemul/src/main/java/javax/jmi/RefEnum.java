package javax.jmi;

import java.io.Serializable;
import java.util.List;

public interface RefEnum extends Serializable
{
   String toString();

   List refTypeName();

   boolean equals(Object other);

   int hashCode();
}
