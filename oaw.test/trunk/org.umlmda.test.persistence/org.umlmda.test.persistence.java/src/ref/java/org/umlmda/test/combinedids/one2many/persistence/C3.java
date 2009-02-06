package org.umlmda.test.combinedids.one2many.persistence;

/**
 * 
 */
public interface C3 extends org.umlmda.runtime.model.ModeledElement, java.io.Serializable {
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
   public PKey getC3Pkey();

   /**
    * Setter for the primaryKey
    */
   public void setC3Pkey(PKey pkey);
   public static final String PROPERTY_GROUP_ID = "groupId";
   public static final String PROPERTY_A_ID     = "aId";
   public static final String PROPERTY_A_ATTR   = "aAttr";
   public static final String PROPERTY_DS       = "ds";      ;

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
   &lt;BODY&gt;Simple One2One composition.&lt;/BODY&gt;&lt;/HTML&gt;
    */
   public java.util.Set<D3> getDs();

   /**
    * &lt;HTML&gt;&lt;HEAD&gt;
   &lt;META content="MSHTML 6.00.2900.3199" name=GENERATOR&gt;&lt;/HEAD&gt;
   &lt;BODY&gt;Simple One2One composition.&lt;/BODY&gt;&lt;/HTML&gt;
    *
    * @param ds
    *		New value for assocation ds 
    */
   public void setDs(java.util.Set<D3> ds);
}
