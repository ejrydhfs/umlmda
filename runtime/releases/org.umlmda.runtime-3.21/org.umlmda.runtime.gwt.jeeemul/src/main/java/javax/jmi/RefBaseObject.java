package javax.jmi;

import java.util.Collection;

public interface RefBaseObject
{
   RefObject refMetaObject();

   RefPackage refImmediatePackage();

   RefPackage refOutermostPackage();

   String refMofId();

   Collection refVerifyConstraints(boolean deepVerify);

   boolean equals(Object other);

   int hashCode();
}
