/*
 * Created on 03.11.2005
 */
package org.umlmda.uml.generator.j2ee;

import org.umlmda.model.uml.ModelClassifier;
import org.umlmda.uml.generator.java.JavaModelMethod;

/**
 * @author MOROFF
 */
public interface J2EEModelMethod extends JavaModelMethod
{

   /**
    * Returns the remote signature of this method
    * 
    * @return
    */
   String getRemoteSignature();

}
