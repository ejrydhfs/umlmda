package javax.jmi;

import java.util.Collection;
import java.util.List;

public interface RefClass extends RefFeatured
{
   RefObject refCreateInstance(List args);

   Collection refAllOfType();

   Collection refAllOfClass();

   RefStruct refCreateStruct(RefObject struct, List params);

   RefStruct refCreateStruct(String structName, List params);

   RefEnum refGetEnum(RefObject enumObject, String name);

   RefEnum refGetEnum(String enumName, String name);
}