/*
 * Created on 06.02.2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package org.umlmda.eclipse.jdt.preferences;

import java.io.File;
import java.util.StringTokenizer;

import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jface.preference.ListEditor;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.umlmda.eclipse.jdt.ui.JavaProjectSelection;

/**
 * @author MOROFF
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class ProjectEditor extends ListEditor {
   private final Shell shell;
//   private IJavaProject javaProjects[] = null;
   
   /**
    * @param name
    * @param labelText
    * @param parent
    */
   public ProjectEditor(String name, String labelText, Composite parent) {
      super(name, labelText, parent);
      shell = parent.getShell();
   }

   /* (non-Javadoc)
    * @see org.eclipse.jface.preference.ListEditor#createList(java.lang.String[])
    */
   protected String createList(String[] items) {
      StringBuffer buffer = new StringBuffer();
      
      for (int i = 0; i < items.length; i++) {
         buffer.append(items[i]);
         if ( i < items.length )
            buffer.append(File.pathSeparatorChar);
      }
      return buffer.toString();
   }

   /* (non-Javadoc)
    * @see org.eclipse.jface.preference.ListEditor#getNewInputObject()
    */
   protected String getNewInputObject() {
      IJavaProject javaProject = JavaProjectSelection.selectWorkspaceProject(shell);
      
      if ( javaProject != null ) {
         return javaProject.getElementName();
      }
      else {
         return null;
      }
   }

   /* (non-Javadoc)
    * @see org.eclipse.jface.preference.ListEditor#parseString(java.lang.String)
    */
   protected String[] parseString(String stringList) {
      StringTokenizer parseString = new StringTokenizer(stringList, File.pathSeparator);
      String strings[] = new String[parseString.countTokens()];
      
      for (int i = 0; i < strings.length; i++) {
         strings[i] = parseString.nextToken();
      }

      return strings;
   }

}
