package org.umlmda.eclipse.preferences;

import java.util.Iterator;
import java.util.List;

import org.eclipse.jface.preference.ComboFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.umlmda.eclipse.UMLMDAPlugin;

/**
 * This class represents a preference page that
 * is contributed to the Preferences dialog. By 
 * subclassing <samp>FieldEditorPreferencePage</samp>, we
 * can use the field support built into JFace that allows
 * us to create a page that is small and knows how to 
 * save, restore and apply itself.
 * <p>
 * This page is used to modify preferences only. They
 * are stored in the preference store that belongs to
 * the main plug-in class. That way, preferences can
 * be accessed directly via the preference store.
 */


public class UMLMDAPreferencePage
	extends FieldEditorPreferencePage
	implements IWorkbenchPreferencePage {

	public UMLMDAPreferencePage() {
		super(GRID);
		setPreferenceStore(UMLMDAPlugin.getDefault().getPreferenceStore());
		setDescription("UMLMDA preferences");
		initializeDefaults();
	}
/**
 * Sets the default values of the preferences.
 */
	private void initializeDefaults() {
         IPreferenceStore store = getPreferenceStore();
         store.setDefault(UMLMDAPlugin.P_LOG, true);

         StringBuffer buffer = new StringBuffer();
         store.setDefault(UMLMDAPlugin.P_TEMPLATE_PATHS, buffer.toString());
         
	}
	
/**
 * Creates the field editors. Field editors are abstractions of
 * the common GUI blocks needed to manipulate various types
 * of preferences. Each field editor knows how to save and
 * restore itself.
 */

	public void createFieldEditors() {
//      addField(
//            new BooleanFieldEditor(
//               GeneratorPlugin.P_LOG,
//               "Write diagnostics to &log file",
//               getFieldEditorParent()));
         addField(
               new TemplatePathEditor(
                     UMLMDAPlugin.P_TEMPLATE_PATHS,
                     "External template paths",
                     "Choose path ...",
                     getFieldEditorParent()
                     )
               );

   }
	
   public void init(IWorkbench workbench) {
	}
}