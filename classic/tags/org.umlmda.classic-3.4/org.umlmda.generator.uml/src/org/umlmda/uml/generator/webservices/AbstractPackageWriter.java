/*
 * Created on Apr 14, 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package org.umlmda.uml.generator.webservices;

import java.io.File;


import org.umlmda.generator.model.util.DefaultClassHelper;
import org.umlmda.generator.model.util.DefaultMethodHelper;
import org.umlmda.generator.model.util.IClassHelper;
import org.umlmda.generator.model.util.IMethodHelper;
import org.umlmda.profile.ModelStereotype;

/**
 * @author moroff
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
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
    * @see net.sourceforge.umlmda.generator.AbstractWriter#generateOutput()
    */
   public boolean generateOutput() {
   	boolean generateOutput = super.generateOutput(getModelPackage().getClasses(), ModelStereotype.BUSINESS_SERVICE);
      return generateOutput;
   }
}
