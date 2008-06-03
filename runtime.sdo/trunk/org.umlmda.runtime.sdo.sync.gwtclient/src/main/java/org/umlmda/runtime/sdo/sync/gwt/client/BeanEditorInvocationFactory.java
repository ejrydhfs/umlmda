package org.umlmda.runtime.sdo.sync.gwt.client;

import org.umlmda.runtime.bean.BeanInvocation;
import org.umlmda.runtime.bean.PropertyDescriptorProvider;
import org.umlmda.runtime.bean.BeanInvocation.Factory;

public class BeanEditorInvocationFactory implements Factory {

   public BeanInvocation create(final Object object) {
      
      return new BeanInvocation() {

         public Object getValue(String propertyName) {
            return PropertyDescriptorProvider.getInstance().getPropertyDescriptor(propertyName, object.getClass()).createPropertyEditor(object).getValue();
         }

         public Object invoke(String methodName, Object... params) {
            throw new UnsupportedOperationException();
         }

         public void setValue(String propertyName, Object value) {
            PropertyDescriptorProvider.getInstance().getPropertyDescriptor(propertyName, object.getClass()).createPropertyEditor(object).setValue(value);
         }
         
      };
   }

}
