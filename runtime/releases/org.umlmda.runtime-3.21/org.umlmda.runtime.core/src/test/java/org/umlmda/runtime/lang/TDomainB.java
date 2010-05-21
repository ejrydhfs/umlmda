/*
 * Copyright: (C) 2009 COR AG Financial Technologies
 */
package org.umlmda.runtime.lang;

public class TDomainB implements EqualityCheckable
{
   private final String aId;
   private String       b;

   public TDomainB(String id) {
      super();
      aId = id;
   }

   public TDomainB(String id, String b) {
      this(id);
      this.b = b;
   }

   public String getAId() {
      return aId;
   }

   public String getB() {
      return b;
   }

   public void setB(String b) {
      this.b = b;
   }

   @Override
   public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((aId == null) ? 0 : aId.hashCode());
      return result;
   }

   @Override
   public boolean equals(Object obj) {
      if ( this == obj )
         return true;
      if ( obj == null )
         return false;
      if ( getClass() != obj.getClass() )
         return false;
      TDomainB other = (TDomainB) obj;
      if ( aId == null ) {
         if ( other.aId != null )
            return false;
      }
      else if ( !aId.equals(other.aId) )
         return false;
      return true;
   }

   public boolean arePropertiesEqual(Object obj) {

      if ( equals(obj) && obj instanceof TDomainB ) {
         TDomainB other = (TDomainB) obj;

         return b == other.getB() || (b != null && b.equals(other.getB()));
      }
      else {
         return false;
      }
   }
}
