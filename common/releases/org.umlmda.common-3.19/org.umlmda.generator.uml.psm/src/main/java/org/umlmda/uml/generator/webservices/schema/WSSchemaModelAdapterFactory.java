package org.umlmda.uml.generator.webservices.schema;

import org.umlmda.model.uml.Model;
import org.umlmda.model.uml.ModelPackage;
import org.umlmda.model.uml.ModelPackageBase;
import org.umlmda.uml.generator.webservices.WSModelAdapter;
import org.umlmda.uml.generator.webservices.WSModelAdapterFactory;
import org.umlmda.uml.generator.webservices.WSModelPackageAdapter;

public class WSSchemaModelAdapterFactory extends WSModelAdapterFactory {
	
	@Override
	public ModelPackage createModelPackage(ModelPackageBase modelPackage,
			Model model) {
	      if (modelPackage instanceof WSModelPackageAdapter)
	          return (ModelPackage) modelPackage;
	       else
	          return new WSSchemaModelPackageAdapter(modelPackage, model);
	}

	@Override
	protected Model createPsmModel(Model model) {
	      return new WSSchemaModelAdapter(this, model);
	}
	   
}
