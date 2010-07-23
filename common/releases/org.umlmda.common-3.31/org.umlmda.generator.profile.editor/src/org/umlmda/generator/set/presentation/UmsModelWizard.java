/**
 * <copyright>
 * </copyright>
 *
 */
package org.umlmda.generator.set.presentation;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.StringTokenizer;

import org.eclipse.emf.common.util.URI;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;

import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.xmi.XMLResource;

import org.eclipse.emf.edit.ui.provider.ExtendedImageRegistry;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;

import org.eclipse.core.runtime.IProgressMonitor;

import org.eclipse.jface.dialogs.MessageDialog;

import org.eclipse.jface.viewers.IStructuredSelection;

import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardPage;

import org.eclipse.swt.SWT;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;

import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;

import org.eclipse.ui.actions.WorkspaceModifyOperation;

import org.eclipse.ui.dialogs.WizardNewFileCreationPage;

import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.part.ISetSelectionTarget;

import org.umlmda.generator.set.UmsFactory;
import org.umlmda.generator.set.UmsPackage;
import org.umlmda.generator.set.provider.UmpEditPlugin;


import org.eclipse.core.runtime.Path;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;

import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;


/**
 * This is a simple wizard for creating a new model file.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class UmsModelWizard extends Wizard implements INewWizard {
   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public static final String copyright = "www.umlmda.org";

   /**
    * This caches an instance of the model package.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   protected UmsPackage umsPackage = UmsPackage.eINSTANCE;

   /**
    * This caches an instance of the model factory.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   protected UmsFactory umsFactory = umsPackage.getUmsFactory();

   /**
    * This is the file creation page.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   protected UmsModelWizardNewFileCreationPage newFileCreationPage;

   /**
    * This is the file creation page.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   protected UmsModelWizardInitialObjectCreationPage initialObjectCreationPage;

   /**
    * Remember the selection during initialization for populating the default container.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   protected IStructuredSelection selection;

   /**
    * Remember the workbench during initialization.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   protected IWorkbench workbench;

   /**
    * This just records the information.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public void init(IWorkbench workbench, IStructuredSelection selection) {
      this.workbench = workbench;
      this.selection = selection;
      setWindowTitle(UmpEditorPlugin.INSTANCE.getString("_UI_Wizard_label"));
      setDefaultPageImageDescriptor(ExtendedImageRegistry.INSTANCE.getImageDescriptor(UmpEditorPlugin.INSTANCE.getImage("full/wizban/NewUms")));
   }

   /**
    * Create a new model.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   EObject createInitialModel() {
      EClass eClass = (EClass)umsPackage.getEClassifier(initialObjectCreationPage.getInitialObjectName());
      EObject rootObject = umsFactory.create(eClass);
      return rootObject;
   }

   /**
    * Do the work after everything is specified.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public boolean performFinish() {
      try {
         // Remember the file.
         //
         final IFile modelFile = getModelFile();

         // Do the work within an operation.
         //
         WorkspaceModifyOperation operation =
            new WorkspaceModifyOperation() {
               protected void execute(IProgressMonitor progressMonitor) {
                  try {
                     // Create a resource set
                     //
                     ResourceSet resourceSet = new ResourceSetImpl();

                     // Get the URI of the model file.
                     //
                     URI fileURI = URI.createPlatformResourceURI(modelFile.getFullPath().toString());

                     // Create a resource for this file.
                     //
                     Resource resource = resourceSet.createResource(fileURI);

                     // Add the initial model object to the contents.
                     //
                     EObject rootObject = createInitialModel();
                     if (rootObject != null) {
                        resource.getContents().add(rootObject);
                     }

                     // Save the contents of the resource to the file system.
                     //
                     Map options = new HashMap();
                     options.put(XMLResource.OPTION_ENCODING, initialObjectCreationPage.getEncoding());
                     resource.save(options);
                  }
                  catch (Exception exception) {
                     UmpEditorPlugin.INSTANCE.log(exception);
                  }
                  finally {
                     progressMonitor.done();
                  }
               }
            };

         getContainer().run(false, false, operation);

         // Select the new file resource in the current view.
         //
         IWorkbenchWindow workbenchWindow = workbench.getActiveWorkbenchWindow();
         IWorkbenchPage page = workbenchWindow.getActivePage();
         final IWorkbenchPart activePart = page.getActivePart();
         if (activePart instanceof ISetSelectionTarget) {
            final ISelection targetSelection = new StructuredSelection(modelFile);
            getShell().getDisplay().asyncExec
               (new Runnable() {
                   public void run() {
                      ((ISetSelectionTarget)activePart).selectReveal(targetSelection);
                   }
                });
         }

         // Open an editor on the new file.
         //
         try {
            page.openEditor
               (new FileEditorInput(modelFile),
                workbench.getEditorRegistry().getDefaultEditor(modelFile.getFullPath().toString()).getId());
         }
         catch (PartInitException exception) {
            MessageDialog.openError(workbenchWindow.getShell(), UmpEditorPlugin.INSTANCE.getString("_UI_OpenEditorError_label"), exception.getMessage());
            return false;
         }

         return true;
      }
      catch (Exception exception) {
         UmpEditorPlugin.INSTANCE.log(exception);
         return false;
      }
   }

   /**
    * This is the one page of the wizard.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public class UmsModelWizardNewFileCreationPage extends WizardNewFileCreationPage {
      /**
       * Remember the model file.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      protected IFile modelFile;

      /**
       * Pass in the selection.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      public UmsModelWizardNewFileCreationPage(String pageId, IStructuredSelection selection) {
         super(pageId, selection);
      }

      /**
       * The framework calls this to see if the file is correct.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      protected boolean validatePage() {
         if (super.validatePage()) {
            // Make sure the file ends in ".ums".
            //
            String requiredExt = UmpEditorPlugin.INSTANCE.getString("_UI_UmsEditorFilenameExtension");
            String enteredExt = new Path(getFileName()).getFileExtension();
            if (enteredExt == null || !enteredExt.equals(requiredExt)) {
               setErrorMessage(UmpEditorPlugin.INSTANCE.getString("_WARN_FilenameExtension", new Object [] { requiredExt }));
               return false;
            }
            else {
               return true;
            }
         }
         else {
            return false;
         }
      }

      /**
       * Store the dialog field settings upon completion.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      public boolean performFinish() {
         modelFile = getModelFile();
         return true;
      }

      /**
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      public IFile getModelFile() {
         return
            modelFile == null ?
               ResourcesPlugin.getWorkspace().getRoot().getFile(getContainerFullPath().append(getFileName())) :
               modelFile;
      }
   }

   /**
    * This is the page where the type of object to create is selected.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public class UmsModelWizardInitialObjectCreationPage extends WizardPage {
      /**
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      protected String initialObjectName;

      /**
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      protected Combo initialObjectField;

      /**
       * @generated
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       */
      protected String encoding;

      /**
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      protected Combo encodingField;

      /**
       * Pass in the selection.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      public UmsModelWizardInitialObjectCreationPage(String pageId) {
         super(pageId);
      }

      /**
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated NOT
       */
      public void createControl(Composite parent) {
         Composite composite = new Composite(parent, SWT.NONE);
         {
            GridLayout layout = new GridLayout();
            layout.numColumns = 1;
            layout.verticalSpacing = 12;
            composite.setLayout(layout);

            GridData data = new GridData();
            data.verticalAlignment = GridData.FILL;
            data.grabExcessVerticalSpace = true;
            data.horizontalAlignment = GridData.FILL;
            composite.setLayoutData(data);
         }

//         Label containerLabel = new Label(composite, SWT.LEFT);
//         {
//            containerLabel.setText(UmpEditorPlugin.INSTANCE.getString("_UI_ModelObject"));
//
//            GridData data = new GridData();
//            data.horizontalAlignment = GridData.FILL;
//            containerLabel.setLayoutData(data);
//         }
//
//         initialObjectField = new Combo(composite, SWT.BORDER);
//         {
//            GridData data = new GridData();
//            data.horizontalAlignment = GridData.FILL;
//            data.grabExcessHorizontalSpace = true;
//            initialObjectField.setLayoutData(data);
//         }
//
//         List objectNames = new ArrayList();
//         for (Iterator classifier = umsPackage.getEClassifiers().iterator(); classifier.hasNext(); ) {
//            EClassifier eClassifier = (EClassifier)classifier.next();
//            if (eClassifier instanceof EClass) {
//               EClass eClass = (EClass)eClassifier;
//               if (!eClass.isAbstract()) {
//                  objectNames.add(getLabel(eClass));
//               }
//            }
//         }
//
//         Collections.sort(objectNames, java.text.Collator.getInstance());
//         for (Iterator i = objectNames.iterator(); i.hasNext(); ) {
//            String objectName = (String)i.next();
//            initialObjectField.add(objectName);
//         }
//
//         initialObjectField.addSelectionListener
//            (new SelectionAdapter() {
//                public void widgetSelected(SelectionEvent e) {
//                   setPageComplete(isPageComplete());
//                }
//             });
//
         Label encodingLabel = new Label(composite, SWT.LEFT);
         {
            encodingLabel.setText(UmpEditorPlugin.INSTANCE.getString("_UI_XMLEncoding"));

            GridData data = new GridData();
            data.horizontalAlignment = GridData.FILL;
            encodingLabel.setLayoutData(data);
         }
         encodingField = new Combo(composite, SWT.BORDER);
         {
            GridData data = new GridData();
            data.horizontalAlignment = GridData.FILL;
            data.grabExcessHorizontalSpace = true;
            encodingField.setLayoutData(data);
         }

         for (StringTokenizer stringTokenizer = new StringTokenizer(UmpEditorPlugin.INSTANCE.getString("_UI_XMLEncodingChoices")); stringTokenizer.hasMoreTokens(); ) {
            encodingField.add(stringTokenizer.nextToken());
         }
         encodingField.select(0);

         setControl(composite);
      }

      /**
       * The framework calls this to see if the file is correct.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated NOT
       */
      public boolean isPageComplete() {
         return super.isPageComplete();
//         if (super.isPageComplete()) {
//            return initialObjectField.getSelectionIndex() != -1;
//         }
//         else {
//            return false;
//         }
      }

      /**
       * Store the dialog field settings upon completion.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      public boolean performFinish() {
         initialObjectName = getInitialObjectName();
         encoding = getEncoding();
         return true;
      }

      /**
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated NOT
       */
      public String getInitialObjectName() {
         if (initialObjectName != null) {
            return initialObjectName;
         }
         else {
            return umsPackage.getGenerationSet().getName();
         }
      }

      /**
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      public String getEncoding() {
         return
            encoding == null ?
               encodingField.getText() :
               encoding;
      }
      /**
       * Returns the label of the specified element.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      protected String getLabel(EClass eClass) {
         String name = eClass.getName();
         try {
            return UmpEditPlugin.INSTANCE.getString("_UI_" + name + "_type");
         }
         catch(MissingResourceException mre) {
         }
         return name;
      }
   }

   /**
    * The framework calls this to create the contents of the wizard.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public void addPages() {
      // Create a page, set the title, and the initial model file name.
      //
      newFileCreationPage = new UmsModelWizardNewFileCreationPage("Whatever", selection);
      newFileCreationPage.setTitle(UmpEditorPlugin.INSTANCE.getString("_UI_UmsModelWizard_label"));
      newFileCreationPage.setDescription(UmpEditorPlugin.INSTANCE.getString("_UI_UmsModelWizard_description"));
      newFileCreationPage.setFileName(UmpEditorPlugin.INSTANCE.getString("_UI_UmsEditorFilenameDefaultBase") + "." + UmpEditorPlugin.INSTANCE.getString("_UI_UmsEditorFilenameExtension"));
      addPage(newFileCreationPage);

      // Try and get the resource selection to determine a current directory for the file dialog.
      //
      if (selection != null && !selection.isEmpty()) {
         // Get the resource...
         //
         Object selectedElement = selection.iterator().next();
         if (selectedElement instanceof IResource) {
            // Get the resource parent, if its a file.
            //
            IResource selectedResource = (IResource)selectedElement;
            if (selectedResource.getType() == IResource.FILE) {
               selectedResource = selectedResource.getParent();
            }

            // This gives us a directory...
            //
            if (selectedResource instanceof IFolder || selectedResource instanceof IProject) {
               // Set this for the container.
               //
               String currentDirectory = selectedResource.getLocation().toOSString();
               newFileCreationPage.setContainerFullPath(selectedResource.getFullPath());

               // Make up a unique new name here.
               //
               String defaultModelBaseFilename = UmpEditorPlugin.INSTANCE.getString("_UI_UmsEditorFilenameDefaultBase");
               String defaultModelFilenameExtension = UmpEditorPlugin.INSTANCE.getString("_UI_UmsEditorFilenameExtension");
               String modelFilename = defaultModelBaseFilename + "." + defaultModelFilenameExtension;
               for (int i = 1; ((IContainer)selectedResource).findMember(modelFilename) != null; ++i) {
                  modelFilename = defaultModelBaseFilename + i + "." + defaultModelFilenameExtension;
               }
               newFileCreationPage.setFileName(modelFilename);
            }
         }
      }
      initialObjectCreationPage = new UmsModelWizardInitialObjectCreationPage("Whatever2");
      initialObjectCreationPage.setTitle(UmpEditorPlugin.INSTANCE.getString("_UI_UmsModelWizard_label"));
      initialObjectCreationPage.setDescription(UmpEditorPlugin.INSTANCE.getString("_UI_Wizard_initial_object_description"));
      addPage(initialObjectCreationPage);
   }

   /**
    * Get the file from the page.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public IFile getModelFile() {
      return newFileCreationPage.getModelFile();
   }

}
