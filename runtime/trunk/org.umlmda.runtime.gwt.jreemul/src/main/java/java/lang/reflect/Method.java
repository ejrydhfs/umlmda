package java.lang.reflect;

public class Method implements Member {
   
   private final Class<?> declaringClass;
   private final int modifiers;
   private final String name;

   protected Method(Class<?> declaringClass, int modifiers, String name) {
      this.declaringClass = declaringClass;
      this.modifiers = modifiers;
      this.name = name;
   }

   public Class<?> getDeclaringClass() {
      return declaringClass;
   }

   public int getModifiers() {
      return modifiers;
   }

   public String getName() {
      return name;
   }

   public Class<?> getReturnType() {
      throw new UnsupportedOperationException("Must  be overwritten in GWT implementation");
   }

   public Class<?>[] getParameterTypes() {
      throw new UnsupportedOperationException("Must  be overwritten in GWT implementation");
   }

   public Object invoke(Object obj, Object[] args) {
      throw new UnsupportedOperationException("Must  be overwritten in GWT implementation");
   }

}
