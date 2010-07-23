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
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.umlmda.generator.profile.Profile;
import org.umlmda.generator.profile.UmpFactory;
import org.umlmda.generator.profile.UmpPackage;
import org.umlmda.generator.set.provider.UmpEditPlugin;

/**
 * This is the item provider adpater for a {@link org.umlmda.generator.profile.Profile} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ProfileItemProvider
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
   public ProfileItemProvider(AdapterFactory adapterFactory) {
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
         addAdapterFactoryPropertyDescriptor(object);
         addValidatorFactoryPropertyDescriptor(object);
         addBasedOnPropertyDescriptor(object);
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
             getString("_UI_Profile_name_feature"),
             getString("_UI_PropertyDescriptor_description", "_UI_Profile_name_feature", "_UI_Profile_type"),
             UmpPackage.eINSTANCE.getProfile_Name(),
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
             getString("_UI_Profile_description_feature"),
             getString("_UI_PropertyDescriptor_description", "_UI_Profile_description_feature", "_UI_Profile_type"),
             UmpPackage.eINSTANCE.getProfile_Description(),
             true,
             ItemPropertyDescriptor.GENERIC_VALUE_IMAGE));
   }

   /**
    * This adds a property descriptor for the Adapter Factory feature.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   protected void addAdapterFactoryPropertyDescriptor(Object object) {
      itemPropertyDescriptors.add
         (new ItemPropertyDescriptor
            (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
             getResourceLocator(),
             getString("_UI_Profile_adapterFactory_feature"),
             getString("_UI_PropertyDescriptor_description", "_UI_Profile_adapterFactory_feature", "_UI_Profile_type"),
             UmpPackage.eINSTANCE.getProfile_AdapterFactory(),
             true,
             ItemPropertyDescriptor.GENERIC_VALUE_IMAGE));
   }

   /**
    * This adds a property descriptor for the Validator Factory feature.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   protected void addValidatorFactoryPropertyDescriptor(Object object) {
      itemPropertyDescriptors.add
         (new ItemPropertyDescriptor
            (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
             getResourceLocator(),
             getString("_UI_Profile_validatorFactory_feature"),
             getString("_UI_PropertyDescriptor_description", "_UI_Profile_validatorFactory_feature", "_UI_Profile_type"),
             UmpPackage.eINSTANCE.getProfile_ValidatorFactory(),
             true,
             ItemPropertyDescriptor.GENERIC_VALUE_IMAGE));
   }

   /**
    * This adds a property descriptor for the Based On feature.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   protected void addBasedOnPropertyDescriptor(Object object) {
      itemPropertyDescriptors.add
         (new ItemPropertyDescriptor
            (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
             getResourceLocator(),
             getString("_UI_Profile_basedOn_feature"),
             getString("_UI_PropertyDescriptor_description", "_UI_Profile_basedOn_feature", "_UI_Profile_type"),
             UmpPackage.eINSTANCE.getProfile_BasedOn(),
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
         childrenFeatures.add(UmpPackage.eINSTANCE.getProfile_Stereotypes());
         childrenFeatures.add(UmpPackage.eINSTANCE.getProfile_Artefacts());
         childrenFeatures.add(UmpPackage.eINSTANCE.getProfile_DefaultProperties());
         childrenFeatures.add(UmpPackage.eINSTANCE.getProfile_MetaModelElements());
      }
      return childrenFeatures;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   protected EStructuralFeature getChildFeature(Object object, Object child) {
      // Check the type of the specified child object and return the proper feature to use for
      // adding (see {@link AddCommand}) it as a child.

      return super.getChildFeature(object, child);
   }

   /**
    * This returns Profile.gif.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public Object getImage(Object object) {
      return getResourceLocator().getImage("full/obj16/Profile");
   }

   /**
    * This returns the label text for the adapted class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public String getText(Object object) {
      String label = ((Profile)object).getName();
      return label == null || label.length() == 0 ?
         getString("_UI_Profile_type") :
         getString("_UI_Profile_type") + " " + label;
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

      switch (notification.getFeatureID(Profile.class)) {
         case UmpPackage.PROFILE__NAME:
         case UmpPackage.PROFILE__DESCRIPTION:
         case UmpPackage.PROFILE__ADAPTER_FACTORY:
         case UmpPackage.PROFILE__VALIDATOR_FACTORY:
            fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
            return;
         case UmpPackage.PROFILE__STEREOTYPES:
         case UmpPackage.PROFILE__ARTEFACTS:
         case UmpPackage.PROFILE__DEFAULT_PROPERTIES:
         case UmpPackage.PROFILE__META_MODEL_ELEMENTS:
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
            (UmpPackage.eINSTANCE.getProfile_Stereotypes(),
             UmpFactory.eINSTANCE.createStereotype()));

      newChildDescriptors.add
         (createChildParameter
            (UmpPackage.eINSTANCE.getProfile_Artefacts(),
             UmpFactory.eINSTANCE.createArtefact()));

      newChildDescriptors.add
         (createChildParameter
            (UmpPackage.eINSTANCE.getProfile_DefaultProperties(),
             UmpFactory.eINSTANCE.createProperty()));

      newChildDescriptors.add
         (createChildParameter
            (UmpPackage.eINSTANCE.getProfile_MetaModelElements(),
             UmpFactory.eINSTANCE.createMetaModelElement()));
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
