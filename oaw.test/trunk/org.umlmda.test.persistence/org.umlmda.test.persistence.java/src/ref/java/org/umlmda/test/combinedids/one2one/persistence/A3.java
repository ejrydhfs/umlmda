package org.umlmda.test.combinedids.one2one.persistence;

/**
 * 
 */
public interface A3 extends org.umlmda.runtime.model.ModeledElement, java.io.Serializable {
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
   public PKey getA3Pkey();

   /**
    * Setter for the primaryKey
    */
   public void setA3Pkey(PKey pkey);
   public static final String PROPERTY_GROUP_ID = "groupId";
   public static final String PROPERTY_A_ID     = "aId";
   public static final String PROPERTY_A_ATTR   = "aAttr";
   public static final String PROPERTY_B        = "b";       ;

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
   public B3 getB();

   /**
    * &lt;HTML&gt;&lt;HEAD&gt;
   &lt;META content="MSHTML 6.00.2900.3199" name=GENERATOR&gt;&lt;/HEAD&gt;
   &lt;BODY&gt;Simple One2One composition.&lt;/BODY&gt;&lt;/HTML&gt;
    *
    * @param b
    *		New value for assocation b 
    */
   public void setB(B3 b);
}
