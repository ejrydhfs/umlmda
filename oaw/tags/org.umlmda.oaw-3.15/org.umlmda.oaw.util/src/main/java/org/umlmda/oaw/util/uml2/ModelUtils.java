package org.umlmda.oaw.util.uml2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.uml2.uml.Model;

public class ModelUtils {
	private static Logger logger = Logger.getLogger(ModelUtils.class);
	private static HashMap<String,List<Model>> processMap = new HashMap<String,List<Model>>();
	
	public static void processLater(Model modelToProcess, String context) {
		List<Model> processList = processMap.get(context);
		
		if ( processList == null ) {
			processList = new ArrayList<Model>();
			processMap.put(context, processList);
		}
		
		if (modelToProcess != null)
		   processList.add(modelToProcess);
	}

	/**
	 * removes the given model from the list of models to be process within the context
	 * 
	 * NOTE: the extension is declared as cached and
	 *       will call processLater directly before calling this method
	 *       So the model cannot be marked to be processed again for this context
	 * 
	 * @param modelToProcess
	 * @param context
	 */
	public static void markAsProcessed(Model modelToProcess, String context) {
		List<Model> processList = processMap.get(context);
		if (processList != null)
		    processList.remove(modelToProcess);
	}

	public static List collectedModels(String context) {
		List<Model> processesToReturn = new ArrayList<Model>();
		List<Model> processList = processMap.get(context);

		if (processList != null){
			processesToReturn.addAll(processList);
		}
		return processList; 
	}

	

}
