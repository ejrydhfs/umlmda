package java.lang.reflect;

public interface Member {

   int PUBLIC = 1;

   /**
    * Returns the Class object representing the class or interface that declares the member or 
    * constructor represented by this Member.
    */
   Class<?> getDeclaringClass();

   /**
    * Returns the Java language modifiers for the member or constructor represented by this Member, 
    * as an integer.
    */
   int getModifiers();
   
   /**
    * Returns the name of the member.
    */
   String getName();    

}
