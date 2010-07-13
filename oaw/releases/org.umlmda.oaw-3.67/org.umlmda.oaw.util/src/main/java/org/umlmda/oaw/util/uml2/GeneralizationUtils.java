/*
 * Copyright: (C) 2009 COR AG Financial Technologies
 */
package org.umlmda.oaw.util.uml2;

import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Generalization;

public class GeneralizationUtils
{

   public static Generalization createGeneralization(Classifier specific, Classifier general) {
      Generalization generalization = specific.createGeneralization(general);

      return generalization;
   }
}
