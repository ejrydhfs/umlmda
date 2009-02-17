package org.umlmda.test.combinedids.one2many.persistence;

/**
 * 
 */
public interface D5 extends org.umlmda.runtime.model.ModeledElement, java.io.Serializable {
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
       * Get key attribute id, 
       */
      public String getId();

      /**
       * Set key attribute id, 
       */
      public void setId(String id);
   }

   /**
    * Getter for the primaryKey
    */
   public PKey getD5Pkey();

   /**
    * Setter for the primaryKey
    */
   public void setD5Pkey(PKey pkey);
   public static final String PROPERTY_GROUP_ID = "groupId";
   public static final String PROPERTY_ID       = "id";
   public static final String PROPERTY_B_ATTR   = "bAttr";
   public static final String PROPERTY_A        = "a";       ;

   /**
    * Get groupId, 
    */
   public String getGroupId();

   /**
    * Set groupId, 
    */
   public void setGroupId(String groupId);

   /**
    * Get id, 
    */
   public String getId();

   /**
    * Set id, 
    */
   public void setId(String id);

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
   &lt;BODY&gt;
   &lt;P&gt;Bidirectional&nbsp;One2Many composition, only groupId is shared key.&lt;/P&gt;
   &lt;P&gt;@@@ TODO handle sharedKey&lt;/P&gt;&lt;/BODY&gt;&lt;/HTML&gt;
    */
   public C5 getA();

   /**
    * &lt;HTML&gt;&lt;HEAD&gt;
   &lt;META content="MSHTML 6.00.2900.3199" name=GENERATOR&gt;&lt;/HEAD&gt;
   &lt;BODY&gt;
   &lt;P&gt;Bidirectional&nbsp;One2Many composition, only groupId is shared key.&lt;/P&gt;
   &lt;P&gt;@@@ TODO handle sharedKey&lt;/P&gt;&lt;/BODY&gt;&lt;/HTML&gt;
    *
    * @param a
    *		New value for assocation a 
    */
   public void setA(C5 a);
}
