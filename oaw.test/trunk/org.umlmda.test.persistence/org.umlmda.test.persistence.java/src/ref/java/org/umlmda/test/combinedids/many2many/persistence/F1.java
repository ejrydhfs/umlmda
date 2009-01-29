package org.umlmda.test.combinedids.many2many.persistence;

/**
 * 
 */
public interface F1 extends org.umlmda.runtime.model.ModeledElement, java.io.Serializable {
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
       * Get key attribute bId, 
       */
      public String getBId();

      /**
       * Set key attribute bId, 
       */
      public void setBId(String bId);
   }

   /**
    * Getter for the primaryKey
    */
   public PKey getF1Pkey();

   /**
    * Setter for the primaryKey
    */
   public void setF1Pkey(PKey pkey);
   public static final String PROPERTY_GROUP_ID = "groupId";
   public static final String PROPERTY_B_ID     = "bId";
   public static final String PROPERTY_B_ATTR   = "bAttr";

   /**
    * Get groupId, 
    */
   public String getGroupId();

   /**
    * Set groupId, 
    */
   public void setGroupId(String groupId);

   /**
    * Get bId, 
    */
   public String getBId();

   /**
    * Set bId, 
    */
   public void setBId(String bId);

   /**
    * Get bAttr, 
    */
   public String getBAttr();

   /**
    * Set bAttr, 
    */
   public void setBAttr(String bAttr);
}
