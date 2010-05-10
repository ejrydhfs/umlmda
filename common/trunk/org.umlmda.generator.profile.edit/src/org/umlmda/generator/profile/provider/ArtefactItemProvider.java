/**
 * <copyright>
 * </copyright>
 *
 */
package org.umlmda.generator.profile.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.umlmda.generator.profile.Artefact;
import org.umlmda.generator.profile.UmpFactory;
import org.umlmda.generator.profile.UmpPackage;
import org.umlmda.generator.set.provider.UmpEditPlugin;

/**
 * This is the item provider adpater for a {@link org.umlmda.generator.profile.Artefact} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ArtefactItemProvider
   extends ItemProviderAdapter
   implements
      IEditingDomainItemProvider,
      IStructuredItemContentProvider,
      ITreeItemContentProvider,
      IItemLabelProvider,
      IItemPropertySource {
   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public static final String copyright = "www.umlmda.org";

   /**
    * This constructs an instance from a factory and a notifier.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public ArtefactItemProvider(AdapterFactory adapterFactory) {
      super(adapterFactory);
   }

   /**
    * This returns the property descriptors for the adapted class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public List getPropertyDescriptors(Object object) {
      if (itemPropertyDescriptors == null) {
         super.getPropertyDescriptors(object);

         addNamePropertyDescriptor(object);
         addAliasPropertyDescriptor(object);
         addDescriptionPropertyDescriptor(object);
         addFilenamePropertyDescriptor(object);
         addFileExtensionPropertyDescriptor(object);
         addPrefixPropertyDescriptor(object);
         addPostfixPropertyDescriptor(object);
         addUseNamespacePropertyDescriptor(object);
         addNamespacePrefixPropertyDescriptor(object);
         addNamespacePostfixPropertyDescriptor(object);
         addReplacementPropertyDescriptor(object);
         addReplacementPatternPropertyDescriptor(object);
         addTypePropertyDescriptor(object);
         addWriterPropertyDescriptor(object);
         addPropertiesPropertyDescriptor(object);
         addGenerationStrategyPropertyDescriptor(object);
      }
      return itemPropertyDescriptors;
   }

   /**
    * This adds a property descriptor for the Name feature.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   protected void addNamePropertyDescriptor(Object object) {
      itemPropertyDescriptors.add
         (new ItemPropertyDescriptor
            (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
             getResourceLocator(),
             getString("_UI_Artefact_name_feature"),
             getString("_UI_PropertyDescriptor_description", "_UI_Artefact_name_feature", "_UI_Artefact_type"),
             UmpPackage.eINSTANCE.getArtefact_Name(),
             true,
             ItemPropertyDescriptor.GENERIC_VALUE_IMAGE));
   }

   /**
    * This adds a property descriptor for the Alias feature.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   protected void addAliasPropertyDescriptor(Object object) {
      itemPropertyDescriptors.add
         (new ItemPropertyDescriptor
            (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
             getResourceLocator(),
             getString("_UI_Artefact_alias_feature"),
             getString("_UI_PropertyDescriptor_description", "_UI_Artefact_alias_feature", "_UI_Artefact_type"),
             UmpPackage.eINSTANCE.getArtefact_Alias(),
             true,
             ItemPropertyDescriptor.GENERIC_VALUE_IMAGE));
   }

   /**
    * This adds a property descriptor for the Description feature.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   protected void addDescriptionPropertyDescriptor(Object object) {
      itemPropertyDescriptors.add
         (new ItemPropertyDescriptor
            (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
             getResourceLocator(),
             getString("_UI_Artefact_description_feature"),
             getString("_UI_PropertyDescriptor_description", "_UI_Artefact_description_feature", "_UI_Artefact_type"),
             UmpPackage.eINSTANCE.getArtefact_Description(),
             true,
             ItemPropertyDescriptor.GENERIC_VALUE_IMAGE));
   }

   /**
    * This adds a property descriptor for the Filename feature.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   protected void addFilenamePropertyDescriptor(Object object) {
      itemPropertyDescriptors.add
         (new ItemPropertyDescriptor
            (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
             getResourceLocator(),
             getString("_UI_Artefact_filename_feature"),
             getString("_UI_PropertyDescriptor_description", "_UI_Artefact_filename_feature", "_UI_Artefact_type"),
             UmpPackage.eINSTANCE.getArtefact_Filename(),
             true,
             ItemPropertyDescriptor.GENERIC_VALUE_IMAGE));
   }

   /**
    * This adds a property descriptor for the File Extension feature.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   protected void addFileExtensionPropertyDescriptor(Object object) {
      itemPropertyDescriptors.add
         (new ItemPropertyDescriptor
            (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
             getResourceLocator(),
             getString("_UI_Artefact_fileExtension_feature"),
             getString("_UI_PropertyDescriptor_description", "_UI_Artefact_fileExtension_feature", "_UI_Artefact_type"),
             UmpPackage.eINSTANCE.getArtefact_FileExtension(),
             true,
             ItemPropertyDescriptor.GENERIC_VALUE_IMAGE));
   }

   /**
    * This adds a property descriptor for the Prefix feature.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   protected void addPrefixPropertyDescriptor(Object object) {
      itemPropertyDescriptors.add
         (new ItemPropertyDescriptor
            (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
             getResourceLocator(),
             getString("_UI_Artefact_prefix_feature"),
             getString("_UI_PropertyDescriptor_description", "_UI_Artefact_prefix_feature", "_UI_Artefact_type"),
             UmpPackage.eINSTANCE.getArtefact_Prefix(),
             true,
             ItemPropertyDescriptor.GENERIC_VALUE_IMAGE));
   }

   /**
    * This adds a property descriptor for the Postfix feature.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   protected void addPostfixPropertyDescriptor(Object object) {
      itemPropertyDescriptors.add
         (new ItemPropertyDescriptor
            (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
             getResourceLocator(),
             getString("_UI_Artefact_postfix_feature"),
             getString("_UI_PropertyDescriptor_description", "_UI_Artefact_postfix_feature", "_UI_Artefact_type"),
             UmpPackage.eINSTANCE.getArtefact_Postfix(),
             true,
             ItemPropertyDescriptor.GENERIC_VALUE_IMAGE));
   }

   /**
    * This adds a property descriptor for the Use Namespace feature.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   protected void addUseNamespacePropertyDescriptor(Object object) {
      itemPropertyDescriptors.add
         (new ItemPropertyDescriptor
            (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
             getResourceLocator(),
             getString("_UI_Artefact_useNamespace_feature"),
             getString("_UI_PropertyDescriptor_description", "_UI_Artefact_useNamespace_feature", "_UI_Artefact_type"),
             UmpPackage.eINSTANCE.getArtefact_UseNamespace(),
             true,
             ItemPropertyDescriptor.GENERIC_VALUE_IMAGE));
   }

   /**
    * This adds a property descriptor for the Namespace Prefix feature.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   protected void addNamespacePrefixPropertyDescriptor(Object object) {
      itemPropertyDescriptors.add
         (new ItemPropertyDescriptor
            (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
             getResourceLocator(),
             getString("_UI_Artefact_namespacePrefix_feature"),
             getString("_UI_PropertyDescriptor_description", "_UI_Artefact_namespacePrefix_feature", "_UI_Artefact_type"),
             UmpPackage.eINSTANCE.getArtefact_NamespacePrefix(),
             true,
             ItemPropertyDescriptor.GENERIC_VALUE_IMAGE));
   }

   /**
    * This adds a property descriptor for the Namespace Postfix feature.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   protected void addNamespacePostfixPropertyDescriptor(Object object) {
      itemPropertyDescriptors.add
         (new ItemPropertyDescriptor
            (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
             getResourceLocator(),
             getString("_UI_Artefact_namespacePostfix_feature"),
             getString("_UI_PropertyDescriptor_description", "_UI_Artefact_namespacePostfix_feature", "_UI_Artefact_type"),
             UmpPackage.eINSTANCE.getArtefact_NamespacePostfix(),
             true,
             ItemPropertyDescriptor.GENERIC_VALUE_IMAGE));
   }

   /**
    * This adds a property descriptor for the Replacement feature.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   protected void addReplacementPropertyDescriptor(Object object) {
      itemPropertyDescriptors.add
         (new ItemPropertyDescriptor
            (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
             getResourceLocator(),
             getString("_UI_Artefact_replacement_feature"),
             getString("_UI_PropertyDescriptor_description", "_UI_Artefact_replacement_feature", "_UI_Artefact_type"),
             UmpPackage.eINSTANCE.getArtefact_Replacement(),
             true,
             ItemPropertyDescriptor.GENERIC_VALUE_IMAGE));
   }

   /**
    * This adds a property descriptor for the Replacement Pattern feature.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   protected void addReplacementPatternPropertyDescriptor(Object object) {
      itemPropertyDescriptors.add
         (new ItemPropertyDescriptor
            (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
             getResourceLocator(),
             getString("_UI_Artefact_replacementPattern_feature"),
             getString("_UI_PropertyDescriptor_description", "_UI_Artefact_replacementPattern_feature", "_UI_Artefact_type"),
             UmpPackage.eINSTANCE.getArtefact_ReplacementPattern(),
             true,
             ItemPropertyDescriptor.GENERIC_VALUE_IMAGE));
   }

   /**
    * This adds a property descriptor for the Type feature.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   protected void addTypePropertyDescriptor(Object object) {
      itemPropertyDescriptors.add
         (new ItemPropertyDescriptor
            (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
             getResourceLocator(),
             getString("_UI_Artefact_type_feature"),
             getString("_UI_PropertyDescriptor_description", "_UI_Artefact_type_feature", "_UI_Artefact_type"),
             UmpPackage.eINSTANCE.getArtefact_Type(),
             true,
             ItemPropertyDescriptor.GENERIC_VALUE_IMAGE));
   }

   /**
    * This adds a property descriptor for the Writer feature.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   protected void addWriterPropertyDescriptor(Object object) {
      itemPropertyDescriptors.add
         (new ItemPropertyDescriptor
            (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
             getResourceLocator(),
             getString("_UI_Artefact_writer_feature"),
             getString("_UI_PropertyDescriptor_description", "_UI_Artefact_writer_feature", "_UI_Artefact_type"),
             UmpPackage.eINSTANCE.getArtefact_Writer(),
             true,
             ItemPropertyDescriptor.GENERIC_VALUE_IMAGE));
   }

   /**
    * This adds a property descriptor for the Properties feature.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   protected void addPropertiesPropertyDescriptor(Object object) {
      itemPropertyDescriptors.add
         (new ItemPropertyDescriptor
            (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
             getResourceLocator(),
             getString("_UI_Artefact_properties_feature"),
             getString("_UI_PropertyDescriptor_description", "_UI_Artefact_properties_feature", "_UI_Artefact_type"),
             UmpPackage.eINSTANCE.getArtefact_Properties(),
             false,
             ItemPropertyDescriptor.GENERIC_VALUE_IMAGE));
   }

   /**
    * This adds a property descriptor for the Generation Strategy feature.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   protected void addGenerationStrategyPropertyDescriptor(Object object) {
      itemPropertyDescriptors.add
         (new ItemPropertyDescriptor
            (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
             getResourceLocator(),
             getString("_UI_Artefact_generationStrategy_feature"),
             getString("_UI_PropertyDescriptor_description", "_UI_Artefact_generationStrategy_feature", "_UI_Artefact_type"),
             UmpPackage.eINSTANCE.getArtefact_GenerationStrategy(),
             true,
             ItemPropertyDescriptor.GENERIC_VALUE_IMAGE));
   }

   /**
    * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
    * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
    * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public Collection getChildrenFeatures(Object object) {
      if (childrenFeatures == null) {
         super.getChildrenFeatures(object);
         childrenFeatures.add(UmpPackage.eINSTANCE.getArtefact_DefaultProperties());
      }
      return childrenFeatures;
   }

   /**
    * This returns Artefact.gif.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public Object getImage(Object object) {
      return getResourceLocator().getImage("full/obj16/Artefact");
   }

   /**
    * This returns the label text for the adapted class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public String getText(Object object) {
      String label = ((Artefact)object).getName();
      return label == null || label.length() == 0 ?
         getString("_UI_Artefact_type") :
         getString("_UI_Artefact_type") + " " + label;
   }

   /**
    * This handles model notifications by calling {@link #updateChildren} to update any cached
    * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public void notifyChanged(Notification notification) {
      updateChildren(notification);

      switch (notification.getFeatureID(Artefact.class)) {
         case UmpPackage.ARTEFACT__NAME:
         case UmpPackage.ARTEFACT__ALIAS:
         case UmpPackage.ARTEFACT__DESCRIPTION:
         case UmpPackage.ARTEFACT__FILENAME:
         case UmpPackage.ARTEFACT__FILE_EXTENSION:
         case UmpPackage.ARTEFACT__PREFIX:
         case UmpPackage.ARTEFACT__POSTFIX:
         case UmpPackage.ARTEFACT__USE_NAMESPACE:
         case UmpPackage.ARTEFACT__NAMESPACE_PREFIX:
         case UmpPackage.ARTEFACT__NAMESPACE_POSTFIX:
         case UmpPackage.ARTEFACT__REPLACEMENT:
         case UmpPackage.ARTEFACT__REPLACEMENT_PATTERN:
         case UmpPackage.ARTEFACT__TYPE:
         case UmpPackage.ARTEFACT__WRITER:
         case UmpPackage.ARTEFACT__PROPERTIES:
         case UmpPackage.ARTEFACT__GENERATION_STRATEGY:
            fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
            return;
         case UmpPackage.ARTEFACT__DEFAULT_PROPERTIES:
            fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
            return;
      }
      super.notifyChanged(notification);
   }

   /**
    * This adds to the collection of {@link org.eclipse.emf.edit.command.CommandParameter}s
    * describing all of the children that can be created under this object.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   protected void collectNewChildDescriptors(Collection newChildDescriptors, Object object) {
      super.collectNewChildDescriptors(newChildDescriptors, object);

      newChildDescriptors.add
         (createChildParameter
            (UmpPackage.eINSTANCE.getArtefact_DefaultProperties(),
             UmpFactory.eINSTANCE.createProperty()));
   }

   /**
    * Return the resource locator for this item provider's resources.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public ResourceLocator getResourceLocator() {
      return UmpEditPlugin.INSTANCE;
   }

}
