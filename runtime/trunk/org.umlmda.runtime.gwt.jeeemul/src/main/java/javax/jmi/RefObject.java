package javax.jmi;

public interface RefObject extends RefFeatured
{
   boolean refIsInstanceOf(RefObject objType, boolean considerSubtypes);

   RefClass refClass();

   RefFeatured refImmediateComposite();

   RefFeatured refOutermostComposite();

   void refDelete();
}
