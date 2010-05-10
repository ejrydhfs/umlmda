package javax.jmi;

import java.util.Collection;

public interface RefAssociation extends RefBaseObject
{
   Collection refAllLinks();

   boolean refLinkExists(RefObject firstEnd, RefObject secondEnd);

   Collection refQuery(RefObject queryEnd, RefObject queryObject);

   Collection refQuery(String endName, RefObject queryObject);

   boolean refAddLink(RefObject firstEnd, RefObject secondEnd);

   boolean refRemoveLink(RefObject firstEnd, RefObject secondEnd);
}
