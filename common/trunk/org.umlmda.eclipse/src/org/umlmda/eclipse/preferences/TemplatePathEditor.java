/*
 * Created on 30.01.2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package org.umlmda.eclipse.preferences;

import org.eclipse.jface.preference.PathEditor;
import org.eclipse.swt.widgets.Composite;

/**
 * Special path editor to enable/disable remove button on plugin
 * paths
 * @author Dieter Moroff (30.1.2006)
 */
public class TemplatePathEditor extends PathEditor {

   /**
    * 
    */
   public TemplatePathEditor() {
      super();
   }

   /**
    * @param name
    * @param labelText
    * @param dirChooserLabelText
    * @param parent
    */
   public TemplatePathEditor(String name, String labelText, String dirChooserLabelText, Composite parent) {
      super(name, labelText, dirChooserLabelText, parent);
   }

   
   public Composite getButtonBoxControl(Composite parent) {
      Composite buttonBox = super.getButtonBoxControl(parent); 
      return buttonBox;
   }
}
