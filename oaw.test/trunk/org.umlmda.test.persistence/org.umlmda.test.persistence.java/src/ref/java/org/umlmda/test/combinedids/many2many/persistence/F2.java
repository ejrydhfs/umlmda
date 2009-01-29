package org.umlmda.test.combinedids.many2many.persistence;

/**
 * 
 */
public interface F2 extends org.umlmda.runtime.model.ModeledElement, java.io.Serializable {
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
   public PKey getF2Pkey();

   /**
    * Setter for the primaryKey
    */
   public void setF2Pkey(PKey pkey);
   public static final String PROPERTY_GROUP_ID = "groupId";
   public static final String PROPERTY_B_ID     = "bId";
   public static final String PROPERTY_B_ATTR   = "bAttr";
   public static final String PROPERTY_ES       = "es";      ;

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

   /**
    * &lt;HTML&gt;&lt;HEAD&gt;
   &lt;META content="MSHTML 6.00.2900.3199" name=GENERATOR&gt;&lt;/HEAD&gt;
   &lt;BODY&gt;Bidirectional&nbsp;One2One association.&lt;/BODY&gt;&lt;/HTML&gt;
    */
   public java.util.Set<E2> getEs();

   /**
    * &lt;HTML&gt;&lt;HEAD&gt;
   &lt;META content="MSHTML 6.00.2900.3199" name=GENERATOR&gt;&lt;/HEAD&gt;
   &lt;BODY&gt;Bidirectional&nbsp;One2One association.&lt;/BODY&gt;&lt;/HTML&gt;
    *
    * @param es
    *		New value for assocation es 
    */
   public void setEs(java.util.Set<E2> es);
}
