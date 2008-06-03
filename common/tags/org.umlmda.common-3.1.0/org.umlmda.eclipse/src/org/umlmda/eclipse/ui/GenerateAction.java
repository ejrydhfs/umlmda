package org.umlmda.eclipse.ui;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.resource.ImageDescriptor;
import org.umlmda.generator.set.GenerationSet;

public class GenerateAction extends Action {
   private GenerationSet generationSet;
   
   public GenerateAction() {
      super();
   }

   public GenerateAction(String text) {
      super(text);
   }

   public GenerateAction(String text, ImageDescriptor image) {
      super(text, image);
   }

   public GenerateAction(String text, int style) {
      super(text, style);
   }

   public GenerationSet getGenerationSet() {
      return generationSet;
   }

   public void setGenerationSet(GenerationSet generationSet) {
      this.generationSet = generationSet;
   }

   public void run() {
      // TODO Auto-generated method stub
      super.run();
   }

}
