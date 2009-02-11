/*
 * Created on 10.02.2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package org.umlmda.model.uml.attributes;

import java.util.Observable;

/**
 * Multiplicity for structural features.
 * @author MOROFF (10.02.2006)
 * @see org.umlmda.model.uml.ModelStructuralFeature
 */
public class Multiplicity extends Observable {
   /** Definition for a unbound (upper) range */
   public static final int UNBOUND = -1;
   
   /** Lower range of the multiplicity **/
   private int lower;

   /** Upper range of the multiplicity **/
   private int upper;
   
   /**
    *  
    */
   public Multiplicity(int lower, int upper) {
      super();
      this.lower = lower;
      this.upper = upper;
   }

   /**
    * @return Returns the lower range of the multiplicity.
    */
   public int getLower() {
      return lower;
   }
   /**
    * @param lower The lower range of the multiplicity to set.
    */
   public void setLower(int lower) {
      this.lower = lower;
      notifyObservers("lower");
   }
   /**
    * @return Returns the upper range of the multiplicity.
    */
   public int getUpper() {
      return upper;
   }
   /**
    * @param upper The upper range of the multiplicity to set.
    */
   public void setUpper(int upper) {
      this.upper = upper;
      notifyObservers("upper");
   }
   
   /**
    * Returns if the upper range is unbounded
    */
   public boolean isUnbound() {
      return upper == UNBOUND;
   }

   /**
    * Returns if the upper range is multiple (>1) or unbounded
    * @return
    */
   public boolean isMultiple() {
      return upper > 1 || isUnbound();
   }
   
   public String toString() {
      if ( upper == 1 && lower == 1 ) {
         return "1";
      }
      else {
         return lower + ".." + (upper == UNBOUND ? "*" : Integer.toString(upper));
      }
   }
   
   /* (non-Javadoc)
    * @see java.lang.Object#equals(java.lang.Object)
    */
   public boolean equals(Object obj) {
      return toString().equals(obj.toString());
   }
   
   /* (non-Javadoc)
    * @see java.lang.Object#hashCode()
    */
   public int hashCode() {
      return toString().hashCode();
   }
      
}
