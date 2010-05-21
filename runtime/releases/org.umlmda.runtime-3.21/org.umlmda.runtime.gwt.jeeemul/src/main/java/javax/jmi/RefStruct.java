package javax.jmi;

import java.io.Serializable;
import java.util.List;

public interface RefStruct extends Serializable
{
   List refFieldNames();

   Object refGetValue(String fieldName);

   List refTypeName();

   boolean equals(Object other);

   int hashCode();
}
