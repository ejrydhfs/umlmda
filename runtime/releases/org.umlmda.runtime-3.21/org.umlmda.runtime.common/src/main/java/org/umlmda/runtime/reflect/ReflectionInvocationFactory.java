/**
 * 
 */
package org.umlmda.runtime.reflect;

import org.umlmda.runtime.bean.BeanInvocation;
import org.umlmda.runtime.bean.BeanInvocation.Factory;

/**
 * @author moroff
 */
public class ReflectionInvocationFactory implements Factory
{

   /*
    * (non-Javadoc)
    * @see org.umlmda.runtime.bean.BeanInvocation.Factory#create(java.lang.Object)
    */
   public BeanInvocation create(Object object) {
      return new ReflectionInvocation(object);
   }

}
