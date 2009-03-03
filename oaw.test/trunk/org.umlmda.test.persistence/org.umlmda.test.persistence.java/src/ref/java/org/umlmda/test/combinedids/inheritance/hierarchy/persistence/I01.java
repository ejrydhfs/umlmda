package org.umlmda.test.combinedids.inheritance.hierarchy.persistence;

/**
 * 
 */
public interface I01 extends I0 {
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
   public PKey getI01Pkey();

   /**
    * Setter for the primaryKey
    */
   public void setI01Pkey(PKey pkey);
   public static final String PROPERTY_I2_ATTR = "i2Attr";

   /**
    * Get i2Attr, 
    */
   public String getI2Attr();

   /**
    * Set i2Attr, 
    */
   public void setI2Attr(String i2Attr);
}
