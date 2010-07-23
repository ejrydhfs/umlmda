package javax.jmi;

import java.util.Collection;
import java.util.List;

public interface RefPackage extends RefBaseObject
{
   RefClass refClass(RefObject type);

   RefClass refClass(String typeName);

   RefPackage refPackage(RefObject nestedPackage);

   RefPackage refPackage(String nestedPackageName);

   RefAssociation refAssociation(RefObject association);

   RefAssociation refAssociation(String associationName);

   Collection refAllPackages();

   Collection refAllClasses();

   Collection refAllAssociations();

   RefStruct refCreateStruct(RefObject struct, List params);

   RefStruct refCreateStruct(String structName, List params);

   RefEnum refGetEnum(RefObject enumObject, String name);

   RefEnum refGetEnum(String enumName, String name);

   void refDelete();
}
