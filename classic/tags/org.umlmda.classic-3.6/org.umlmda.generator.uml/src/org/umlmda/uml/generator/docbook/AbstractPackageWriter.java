/*
 * Created on Nov 25, 2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package org.umlmda.uml.generator.docbook;

import org.umlmda.generator.model.util.DefaultClassHelper;
import org.umlmda.generator.model.util.DefaultMethodHelper;

import org.umlmda.model.uml.ModelClass;
import org.umlmda.model.uml.ModelElement;

/**
 * @author moroff
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public abstract class AbstractPackageWriter extends org.umlmda.generator.AbstractPackageWriter {

   /**
    * @param classHelper
    * @param methodHelper
    */
   public AbstractPackageWriter() {
      super(new DefaultClassHelper(), new DefaultMethodHelper());
   }

   /* (non-Javadoc)
    * @see net.sourceforge.umlmda.generator.AbstractParentWriter#getBaseName()
    */
   public String getBaseName() {
      return getModelPackage().getQualifiedName();
   }

   /* (non-Javadoc)
    * @see net.sourceforge.umlmda.generator.AbstractParentWriter#getWriterName(net.sourceforge.umlmda.xmi.uml.ModelElement)
    */
   protected String getWriterName(Object modelElement) {
      if ( modelElement instanceof ModelClass ) {
         return "docbook.Class";
      }
      else {
         return null;
      }
   }

   public String getDocumentation(ModelElement element) {
      return Utils.getDocParagraphs(element);
   }

}
