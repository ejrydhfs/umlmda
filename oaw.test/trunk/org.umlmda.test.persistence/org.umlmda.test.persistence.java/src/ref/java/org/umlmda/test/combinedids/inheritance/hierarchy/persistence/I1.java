package org.umlmda.test.combinedids.inheritance.hierarchy.persistence;

/**
 * <HTML><HEAD>
<META content="MSHTML 6.00.2900.3199" name=GENERATOR></HEAD>
<BODY>ClassHierarchy - All classes in one table</BODY></HTML>
 */
public interface I1 extends org.umlmda.runtime.model.ModeledElement, java.io.Serializable {
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
   public PKey getI1Pkey();

   /**
    * Setter for the primaryKey
    */
   public void setI1Pkey(PKey pkey);
   public static final String PROPERTY_GROUP_ID = "groupId";
   public static final String PROPERTY_I_ID     = "iId";
   public static final String PROPERTY_I1_ATTR  = "i1Attr";

   /**
    * Get groupId, 
    */
   public String getGroupId();

   /**
    * Set groupId, 
    */
   public void setGroupId(String groupId);

   /**
    * Get iId, 
    */
   public String getIId();

   /**
    * Set iId, 
    */
   public void setIId(String iId);

   /**
    * Get i1Attr, 
    */
   public String getI1Attr();

   /**
    * Set i1Attr, 
    */
   public void setI1Attr(String i1Attr);
}
