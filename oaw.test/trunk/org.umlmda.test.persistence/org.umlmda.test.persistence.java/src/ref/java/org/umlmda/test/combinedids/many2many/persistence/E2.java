package org.umlmda.test.combinedids.many2many.persistence;

/**
 * 
 */
public interface E2 extends org.umlmda.runtime.model.ModeledElement, java.io.Serializable {
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
       * Get key attribute aId, 
       */
      public String getAId();

      /**
       * Set key attribute aId, 
       */
      public void setAId(String aId);
   }

   /**
    * Getter for the primaryKey
    */
   public PKey getE2Pkey();

   /**
    * Setter for the primaryKey
    */
   public void setE2Pkey(PKey pkey);
   public static final String PROPERTY_GROUP_ID = "groupId";
   public static final String PROPERTY_A_ID     = "aId";
   public static final String PROPERTY_A_ATTR   = "aAttr";
   public static final String PROPERTY_FS       = "fs";      ;

   /**
    * Get groupId, 
    */
   public String getGroupId();

   /**
    * Set groupId, 
    */
   public void setGroupId(String groupId);

   /**
    * Get aId, 
    */
   public String getAId();

   /**
    * Set aId, 
    */
   public void setAId(String aId);

   /**
    * Get aAttr, 
    */
   public String getAAttr();

   /**
    * Set aAttr, 
    */
   public void setAAttr(String aAttr);

   /**
    * &lt;HTML&gt;&lt;HEAD&gt;
   &lt;META content="MSHTML 6.00.2900.3199" name=GENERATOR&gt;&lt;/HEAD&gt;
   &lt;BODY&gt;Bidirectional&nbsp;One2One association.&lt;/BODY&gt;&lt;/HTML&gt;
    */
   public java.util.Set<F2> getFs();

   /**
    * &lt;HTML&gt;&lt;HEAD&gt;
   &lt;META content="MSHTML 6.00.2900.3199" name=GENERATOR&gt;&lt;/HEAD&gt;
   &lt;BODY&gt;Bidirectional&nbsp;One2One association.&lt;/BODY&gt;&lt;/HTML&gt;
    *
    * @param fs
    *		New value for assocation fs 
    */
   public void setFs(java.util.Set<F2> fs);
}
