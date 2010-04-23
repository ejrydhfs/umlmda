/*
 * Created on 03.11.2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package org.umlmda.uml.generator.java;

import org.umlmda.generator.AbstractMethodWriter;
import org.umlmda.generator.model.util.IClassHelper;
import org.umlmda.generator.model.util.IMethodHelper;

/**
 * @author MOROFF
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public abstract class AbstractJavaMethodWriter extends AbstractMethodWriter {

   /**
    * @param classHelper
    * @param methodHelper
    */
   public AbstractJavaMethodWriter() {
      super(new JavaClassHelper(), new JavaMethodHelper());
   }

}
