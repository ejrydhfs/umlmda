package org.umlmda.oaw.util.uml2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.eclipse.uml2.uml.Model;

/**
 * Utility and convenience methods for the UML2 class {@link Model}.
 */
public class ModelUtils
{
   private static HashMap<String, List<Model>> processMap = new HashMap<String, List<Model>>();

   /**
    * Marks a model as "to be processed later".
    * 
    * @param modelToProcess
    *           Model to be processed later on
    * @param context
    *           Context/Scope name for later access.
    */
   public static void processLater(Model modelToProcess, String context) {
      List<Model> processList = processMap.get(context);

      if ( processList == null ) {
         processList = new ArrayList<Model>();
         processMap.put(context, processList);
      }

      if ( modelToProcess != null )
         processList.add(modelToProcess);
   }

   /**
    * Removes the given model from the list of models to be process within the context<br />
    * NOTE: the extension is declared as cached and will call {@link ModelUtils} directly before calling this method. So the model
    * cannot be marked to be processed again for this context.
    */
   public static void markAsProcessed(Model modelToProcess, String context) {
      List<Model> processList = processMap.get(context);
      if ( processList != null )
         processList.remove(modelToProcess);
   }

   /**
    * Returns all models that were marked as "to be processed later" for the given scope.
    */
   public static List<Model> collectedModels(String context) {
      List<Model> processesToReturn = new ArrayList<Model>();
      List<Model> processList = processMap.get(context);
      if ( processList != null ) {
         processesToReturn.addAll(processList);
      }
      return processList;
   }

}
