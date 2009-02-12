//Source file: D:\\devel\\umlmda\\UMLGenerator\\src\\org\\umlmda\\uml\\generator\\java\\JavaModelClass.java

package org.umlmda.uml.generator.java;

import java.util.List;

import org.umlmda.generator.model.uml.GeneratorClass;
import org.umlmda.model.uml.ModelClass;
import org.umlmda.model.uml.ModelMethod;

public interface JavaModelClass extends JavaModelClassifier, GeneratorClass, ModelClass, JavaImportHelper
{
   public void registerImport(String artefactName);
   
   /**
    * Checks if a method is declared asynchonous withthe stereotype <<AsyncCall>>
    */
   boolean hasAsyncMethods();
   
   /**
    * Returns the package containing the class and has the stereotype <code>BusinessComponent</code>
    */
   public JavaModelPackage getComponent();
   
   /**
    * Returns the package containing the class and has the stereotype <code>BusinessComponent</code>
    */
   public JavaModelPackage getJavaPackage();
   
   /**
    * Returns the model version, derived from the MajorVersion and MinorVersion attributes
    * defined on the <<BusinessCompontent>> containing the class.
    * @author moroff
    */
   String getModelVersion();
   
   /**
    * Returns the serialVersionUID for the java class. The generated UID should be recreated
    * using the standard java tools  
    * @author moroff
    */
   String getSerialVersionUID();
   
   /**
    * Returns the java model class which is extended by the class
    */
   JavaModelClass getExtendedClass();
   
   /**
    * Returns a list of all java model class which is extended directly or indirectly by the class
    */
   List getAllExtendedClasses();
   
   /**
    * Returns the list of <code>JavaModelClass</code> which are implemented is extended by the class
    */
   List getImplementedInterfaces();
   
   /**
    * Returns the attributes declared in this class, rather than implemented in the class
    * @see #getImplementedAttributes()
    */
   List getDeclaredAttributes();
   
   /**
    * Returns the attributes implemented in this class.
    * @see #getDeclaredAttributes()
    */
   List getImplementedAttributes();

   /**
    * Returns the associations declared in this class, rather than implemented in the class
    * @see #getImplementedAssociations()
    */
   List getDeclaredAssociations();
   
   /**
    * Returns the associations implemented in this class.
    * @see #getDeclaredAssociations()
    */
   List getImplementedAssociations();

   /**
    * Returns the methods declared in this class, rather than implemented in the class
    * @see #getImplementedMethods()
    */
   List getDeclaredMethods();
   
   /**
    * Returns the methods implemented in this class.
    * @see #getDeclaredMethods()
    */
   List getImplementedMethods();
   
   /**
    * Gets the java super class. Avoid oAW editor errors.
    * @see #getSuperClass()
    */
   JavaModelClass getJavaSuperClass();
   
   /**
    * Checks whether the given class has an own primary key. That happens if 
    * it has own pkey attributes or inherited pkey attributes from it's 
    * parent.
    */
   public boolean isOwningAPKey();
   
   /**
    * Checks if pkey attributes are inherited from the parent class
    */
   public boolean isPKeyInheritedFromParent();
   
   /**
    * Checks if a delegation interface is required for the class
    */
   public boolean isDelegationInterfaceNeeded();
   
   /**
    * Checks if a bound property exists
    */
   public boolean hasBoundProperties();
   
   /**
    * Checks if a superclass har bound properties
    */
   public boolean superClassHasBoundProperties();
   
   /**
    * Checks if a constrained properties exists
    */
   public boolean hasConstrainedProperties();
   
   /**
    * Checks if a initializer is defined for the class
    */
   public ModelMethod getInitializerMethod();
   
   /**
    * Returns a list of directly referenced types in the implementation
    */
   public List getImplementationReferencedTypes();
   
}
