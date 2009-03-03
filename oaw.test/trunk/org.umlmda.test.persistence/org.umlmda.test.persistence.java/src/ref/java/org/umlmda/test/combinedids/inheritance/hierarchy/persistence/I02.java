package org.umlmda.test.combinedids.inheritance.hierarchy.persistence;

/**
 * 
 */
public interface I02 extends I0 {
   public interface PKey extends java.io.Serializable {
      /**
       * Get key attribute groupId, 
       */
      public String getGroupId();

      /**
       * Set key attribute groupId, 
       */
      public void setGroupId(String groupId);

      /**
       * Get key attribute iId, 
       */
      public String getIId();

      /**
       * Set key attribute iId, 
       */
      public void setIId(String iId);
   }

   /**
    * Getter for the primaryKey
    */
   public PKey getI02Pkey();

   /**
    * Setter for the primaryKey
    */
   public void setI02Pkey(PKey pkey);
   public static final String PROPERTY_I3_ATTR = "i3Attr";

   /**
    * Get i3Attr, 
    */
   public String getI3Attr();

   /**
    * Set i3Attr, 
    */
   public void setI3Attr(String i3Attr);
}
