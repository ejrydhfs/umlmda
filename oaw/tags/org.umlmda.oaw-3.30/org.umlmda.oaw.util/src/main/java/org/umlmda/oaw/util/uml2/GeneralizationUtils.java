/*
 * Copyright: (C) 2009 COR AG Financial Technologies
 * Name:      $Id: GeneralizationUtils.java,v $Version 04.06.2009 11:23:19 {user} Exp $
 */
package org.umlmda.oaw.util.uml2;

import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Generalization;

public class GeneralizationUtils {
   
   public static Generalization createGeneralization(Classifier specific, Classifier general) {
      Generalization generalization = specific.createGeneralization(general);
      
      return generalization;
   }
}
