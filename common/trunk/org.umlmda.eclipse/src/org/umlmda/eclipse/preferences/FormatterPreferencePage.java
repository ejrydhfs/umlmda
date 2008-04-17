package org.umlmda.eclipse.preferences;

import java.util.Iterator;
import java.util.List;

import org.eclipse.jface.preference.ComboFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.StringFieldEditor;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.umlmda.eclipse.UMLMDAPlugin;

public class FormatterPreferencePage extends FieldEditorPreferencePage implements IWorkbenchPreferencePage {

   public FormatterPreferencePage() {
      super(GRID);
      setPreferenceStore(UMLMDAPlugin.getDefault().getPreferenceStore());
      setDescription("Code formatter preferences");
      initializeDefaults();
   }

   /**
    * Sets the default values of the preferences.
    */
   private void initializeDefaults() {
      IPreferenceStore store = getPreferenceStore();
      store.setDefault(UMLMDAPlugin.P_JAVA_CODE_FORMATTER, "");
      store.setDefault(UMLMDAPlugin.P_JAVA_CODE_FORMATTER_PROPERTIES, "");
   }

   public void init(IWorkbench workbench) {
      // TODO Auto-generated method stub

   }

   protected void createFieldEditors() {
      addField(
            new ComboFieldEditor(
                  UMLMDAPlugin.P_JAVA_CODE_FORMATTER,
                  "Java Code Formatter",
                  getJavaFormatterEntries(),
                  getFieldEditorParent()
                  )
            );
      
      addField(
            new StringFieldEditor(
                  UMLMDAPlugin.P_JAVA_CODE_FORMATTER_PROPERTIES,
                  "Java Code Formatter Propertylocation",
                  getFieldEditorParent()
                  ));

   }

   private String[][] getJavaFormatterEntries() {
      List javaCodeFormatters = UMLMDAPlugin.getDefault().getJavaCodeFormatters();
      String formatterEntries[][] = new String[javaCodeFormatters.size()+1][2];

      formatterEntries[0][0] = "";
      formatterEntries[0][1] = "";
      
      int i=1;
      for (Iterator ijcf = javaCodeFormatters.iterator(); ijcf.hasNext();) {
         UMLMDAPlugin.CodeFormatterEntry javaCodeFormatter = (UMLMDAPlugin.CodeFormatterEntry) ijcf.next();
         
         formatterEntries[i][0] = javaCodeFormatter.formatterClassName;
         formatterEntries[i][1] = javaCodeFormatter.formatterClassName + "@" + javaCodeFormatter.bundle.getSymbolicName();
      }
      return formatterEntries;
   }
   
   
}
