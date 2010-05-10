/**
 * <copyright>
 * </copyright>
 *
 */
package org.umlmda.generator.set.provider;


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

import org.umlmda.generator.set.GenerationSet;
import org.umlmda.generator.set.UmsFactory;
import org.umlmda.generator.set.UmsPackage;

/**
 * This is the item provider adpater for a {@link org.umlmda.generator.set.GenerationSet} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class GenerationSetItemProvider
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
   public GenerationSetItemProvider(AdapterFactory adapterFactory) {
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
         addDescriptionPropertyDescriptor(object);
         addExclusivePropertyDescriptor(object);
         addTargetPropertyDescriptor(object);
         addModelPropertyDescriptor(object);
         addReferencedSetsPropertyDescriptor(object);
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
             getString("_UI_GenerationSet_name_feature"),
             getString("_UI_PropertyDescriptor_description", "_UI_GenerationSet_name_feature", "_UI_GenerationSet_type"),
             UmsPackage.eINSTANCE.getGenerationSet_Name(),
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
             getString("_UI_GenerationSet_description_feature"),
             getString("_UI_PropertyDescriptor_description", "_UI_GenerationSet_description_feature", "_UI_GenerationSet_type"),
             UmsPackage.eINSTANCE.getGenerationSet_Description(),
             true,
             ItemPropertyDescriptor.GENERIC_VALUE_IMAGE));
   }

   /**
    * This adds a property descriptor for the Exclusive feature.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   protected void addExclusivePropertyDescriptor(Object object) {
      itemPropertyDescriptors.add
         (new ItemPropertyDescriptor
            (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
             getResourceLocator(),
             getString("_UI_GenerationSet_exclusive_feature"),
             getString("_UI_PropertyDescriptor_description", "_UI_GenerationSet_exclusive_feature", "_UI_GenerationSet_type"),
             UmsPackage.eINSTANCE.getGenerationSet_Exclusive(),
             true,
             ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE));
   }

   /**
    * This adds a property descriptor for the Target feature.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   protected void addTargetPropertyDescriptor(Object object) {
      itemPropertyDescriptors.add
         (new ItemPropertyDescriptor
            (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
             getResourceLocator(),
             getString("_UI_GenerationSet_target_feature"),
             getString("_UI_PropertyDescriptor_description", "_UI_GenerationSet_target_feature", "_UI_GenerationSet_type"),
             UmsPackage.eINSTANCE.getGenerationSet_Target(),
             true,
             ItemPropertyDescriptor.GENERIC_VALUE_IMAGE));
   }

   /**
    * This adds a property descriptor for the Model feature.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   protected void addModelPropertyDescriptor(Object object) {
      itemPropertyDescriptors.add
         (new ItemPropertyDescriptor
            (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
             getResourceLocator(),
             getString("_UI_GenerationSet_model_feature"),
             getString("_UI_PropertyDescriptor_description", "_UI_GenerationSet_model_feature", "_UI_GenerationSet_type"),
             UmsPackage.eINSTANCE.getGenerationSet_Model(),
             true,
             ItemPropertyDescriptor.GENERIC_VALUE_IMAGE));
   }

   /**
    * This adds a property descriptor for the Referenced Sets feature.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   protected void addReferencedSetsPropertyDescriptor(Object object) {
      itemPropertyDescriptors.add
         (new ItemPropertyDescriptor
            (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
             getResourceLocator(),
             getString("_UI_GenerationSet_referencedSets_feature"),
             getString("_UI_PropertyDescriptor_description", "_UI_GenerationSet_referencedSets_feature", "_UI_GenerationSet_type"),
             UmsPackage.eINSTANCE.getGenerationSet_ReferencedSets(),
             true));
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
         childrenFeatures.add(UmsPackage.eINSTANCE.getGenerationSet_GenerationProfile());
      }
      return childrenFeatures;
   }

   /**
    * This returns GenerationSet.gif.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public Object getImage(Object object) {
      return getResourceLocator().getImage("full/obj16/GenerationSet");
   }

   /**
    * This returns the label text for the adapted class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public String getText(Object object) {
      String label = ((GenerationSet)object).getName();
      return label == null || label.length() == 0 ?
         getString("_UI_GenerationSet_type") :
         getString("_UI_GenerationSet_type") + " " + label;
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

      switch (notification.getFeatureID(GenerationSet.class)) {
         case UmsPackage.GENERATION_SET__NAME:
         case UmsPackage.GENERATION_SET__DESCRIPTION:
         case UmsPackage.GENERATION_SET__EXCLUSIVE:
         case UmsPackage.GENERATION_SET__TARGET:
         case UmsPackage.GENERATION_SET__MODEL:
            fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
            return;
         case UmsPackage.GENERATION_SET__GENERATION_PROFILE:
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
            (UmsPackage.eINSTANCE.getGenerationSet_GenerationProfile(),
             UmsFactory.eINSTANCE.createGenerationProfile()));
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
