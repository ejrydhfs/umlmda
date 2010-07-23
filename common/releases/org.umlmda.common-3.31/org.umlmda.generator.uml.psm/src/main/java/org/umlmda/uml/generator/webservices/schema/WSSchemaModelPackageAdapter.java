package org.umlmda.uml.generator.webservices.schema;

import org.apache.log4j.Logger;
import org.umlmda.model.uml.Model;
import org.umlmda.model.uml.ModelPackageBase;
import org.umlmda.uml.generator.webservices.WSModelPackage;
import org.umlmda.uml.generator.webservices.WSModelPackageAdapter;

public class WSSchemaModelPackageAdapter extends WSModelPackageAdapter
{

   public WSSchemaModelPackageAdapter(ModelPackageBase modelPackage, Model model) {
      super(modelPackage, model);
      // TODO Auto-generated constructor stub
   }

   @Override
   protected String getReplacedName() {
      return getName();
   }

   @Override
   public WSModelPackage getWsPackage() {
      WSModelPackage package2Return = super.getWsPackage();

      if ( package2Return != this ) {
         // fix the namespace prefix
         if ( package2Return.getNamespacePrefix() == null ) {
            package2Return.setNamespacePrefix(getNamespacePrefix(this));
         }

      }

      return package2Return;

   }

}
