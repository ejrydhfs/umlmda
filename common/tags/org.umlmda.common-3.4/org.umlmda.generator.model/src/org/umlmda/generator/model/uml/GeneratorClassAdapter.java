package org.umlmda.generator.model.uml;

public abstract class GeneratorClassAdapter implements GeneratorClass {
   private final GeneratorModel generatorModel;
   
	public GeneratorClassAdapter(GeneratorModel model) {
		this.generatorModel = (GeneratorModel) model;
	}

   /* (non-Javadoc)
    * @see org.umlmda.uml.generator.GeneratorModelElement#getGeneratorModel()
    */
   public GeneratorModel getGeneratorModel() {
      return generatorModel;
   }

}
