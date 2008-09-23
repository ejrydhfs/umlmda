package org.umlmda.eclipse.jdt.ui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.ui.JavaElementSorter;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.ListDialog;
import org.eclipse.ui.dialogs.ListSelectionDialog;
import org.eclipse.ui.model.WorkbenchLabelProvider;

public class JavaProjectSelection {

   private static final String SELECTION_TITLE = "Java Project Selection";

   /**
    * Select java project from the workspace in a selection dialog.
    * 
    * @return
    */
   public static  List selectWorkspaceProjects(Shell shell) {
      // Get the java projects from the workbench
      List selection = new ArrayList();
      IJavaProject[] javaProjects = getWorkspaceJavaProjects();

      if (javaProjects.length > 0) {
         new JavaElementSorter().sort(null, javaProjects);

         ListSelectionDialog dialog = new ListSelectionDialog(shell, Arrays
               .asList(javaProjects), new ArrayContentProvider(),
               new WorkbenchLabelProvider(), SELECTION_TITLE);
         dialog.setTitle(SELECTION_TITLE);
         if (dialog.open() == Window.OK) {
            Object[] result = dialog.getResult();
            for (int i = 0; i < result.length; i++) {
               selection.add(result[i]);
            }
         }

      }
      else {
         MessageDialog.openInformation(
               shell,
               SELECTION_TITLE,
               "No java projects in the workbench to select");
         
      }
      return selection;
      
   }

   /**
    * Select java project from the workspace in a selection dialog.
    * 
    * @return
    */
   public static IJavaProject selectWorkspaceProject(Shell shell) {
      // Get the java projects from the workbench
      final IJavaProject[] javaProjects = getWorkspaceJavaProjects();

      if (javaProjects.length > 0) {
          ListDialog listDialog = new ListDialog(shell);

         listDialog.setTitle(SELECTION_TITLE);
         listDialog.setMessage("Worksapce java projects");
         listDialog.setContentProvider(new IStructuredContentProvider() {

            public Object[] getElements(Object inputElement) {
               return javaProjects;
            }

            public void dispose() {
            }

            public void inputChanged(Viewer viewer, Object oldInput,
                  Object newInput) {
            }
         });
         listDialog.setLabelProvider(new WorkbenchLabelProvider());
         listDialog.setInput(javaProjects);
         if (listDialog.open() == ListDialog.OK) {
            Object selection[] = listDialog.getResult();

            if (selection.length > 0) {
               return (IJavaProject) selection[0];
            }
         }

      }
      else {
         MessageDialog.openInformation(
               shell,
               SELECTION_TITLE,
               "No java projects in the workbench to select");
         
      }
      
      return null;
      
   }

   /**
    * @return
    */
   public static IJavaProject[] getWorkspaceJavaProjects() {
      IWorkspace myWorkspace = ResourcesPlugin.getWorkspace();
      IWorkspaceRoot myWorkspaceRoot = myWorkspace.getRoot();
      IJavaProject[] javaProjects;

      try {
         javaProjects = JavaCore.create(myWorkspaceRoot).getJavaProjects();
      } catch (JavaModelException e) {
         throw new RuntimeException(e);
      }
      return javaProjects;
   }
   
   public static IJavaProject getWorkspaceJavaProject(String name) {
      IWorkspace myWorkspace = ResourcesPlugin.getWorkspace();
      IWorkspaceRoot myWorkspaceRoot = myWorkspace.getRoot();
      IProject project = myWorkspaceRoot.getProject(name);
      return JavaCore.create(project);
   }
}
