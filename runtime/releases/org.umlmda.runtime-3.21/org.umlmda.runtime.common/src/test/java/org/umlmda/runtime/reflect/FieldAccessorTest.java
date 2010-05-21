package org.umlmda.runtime.reflect;

import org.testng.annotations.Test;

@Test
public class FieldAccessorTest
{
   private static final String PRIVATE_FINAL_VALUE = "privateFinalValue";
   private static final String PRIVATE_FINAL_FIELD = "privateFinalField";
   private static final String PRIVATE_FIELD = "privateField";
   private static final String PRIVATE_VALUE = "privateValue";
   SampleBean bean = new SampleBean();
   
   public void writeField() {
      FieldAccessor.set(bean, PRIVATE_FIELD, PRIVATE_VALUE);
      
      assert PRIVATE_VALUE.equals(bean.getPrivateField());
   }

   @Test(dependsOnMethods="writeField")
   public void readField() {
      Object value = FieldAccessor.get(bean, PRIVATE_FIELD);
      
      assert PRIVATE_VALUE.equals(value);
   }
   
   @Test(expectedExceptions={IllegalArgumentException.class})
   public void writeFinalField() {
      FieldAccessor.set(bean, PRIVATE_FINAL_FIELD, PRIVATE_FINAL_VALUE);
   }
}
