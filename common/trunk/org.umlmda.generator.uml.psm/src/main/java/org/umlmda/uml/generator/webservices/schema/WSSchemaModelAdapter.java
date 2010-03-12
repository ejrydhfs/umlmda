package org.umlmda.uml.generator.webservices.schema;

import org.umlmda.model.uml.ModelAdapterFactory;
import org.umlmda.model.uml.ModelBase;
import org.umlmda.model.uml.utils.ModelVisitableIterator;
import org.umlmda.uml.generator.webservices.WSModelAdapter;
import org.umlmda.uml.generator.webservices.WSPSMClassCreatorVisitor;
import org.umlmda.uml.generator.webservices.WSPSMClassHierarchyCreatorVisitor;
import org.umlmda.uml.generator.webservices.WSPSMClassHierarchyFixVisitor;
import org.umlmda.uml.generator.webservices.WSPSMClassMultipleInheritanceVisitor;
import org.umlmda.uml.generator.webservices.WSPSMClassReferenceCreatorVisitor;
import org.umlmda.uml.generator.webservices.WSPSMRequestReponseCreateVisitor;

public class WSSchemaModelAdapter extends WSModelAdapter {

	private boolean init = false;
	
	public WSSchemaModelAdapter(ModelAdapterFactory factory, ModelBase srcModel) {
		super(factory, srcModel);
	}

	
	/**
	 * 
	 */
	protected void wsInit() {
	   if ( !init ) {
	      ModelVisitableIterator modelIterator;
	      
	      this.init = true;
	         
	      // Create web service classes
	      modelIterator = new ModelVisitableIterator(new WSSchemaPSMClassCreatorVisitor());
	      modelIterator.iterate(this);

         // Create reference classes for polymorphic types
         modelIterator = new ModelVisitableIterator(new WSPSMClassReferenceCreatorVisitor());
         modelIterator.iterate(this);

          // Create hierarchy classes for polymorphic types
	      modelIterator = new ModelVisitableIterator(new WSPSMClassHierarchyCreatorVisitor());
	      modelIterator.iterate(this);

          // Create hierarchy classes for polymorphic types
          modelIterator = new ModelVisitableIterator(new WSPSMClassHierarchyFixVisitor());
	      modelIterator.iterate(this);

	      // Handle multiple inheritance
	      modelIterator = new ModelVisitableIterator(new WSPSMClassMultipleInheritanceVisitor());
	      modelIterator.iterate(this);
	         
	      if ( isSoapWrapping() ) {
	         modelIterator = new ModelVisitableIterator(new WSPSMRequestReponseCreateVisitor());
	         modelIterator.iterate(this);
	      }
	   }
	}


}
