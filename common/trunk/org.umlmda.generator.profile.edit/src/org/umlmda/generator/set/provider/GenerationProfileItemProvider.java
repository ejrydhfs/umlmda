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

import org.umlmda.generator.profile.UmpFactory;

import org.umlmda.generator.set.GenerationProfile;
import org.umlmda.generator.set.UmsPackage;

/**
 * This is the item provider adpater for a {@link org.umlmda.generator.set.GenerationProfile} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class GenerationProfileItemProvider
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
   public GenerationProfileItemProvider(AdapterFactory adapterFactory) {
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

         addDestinationPropertyDescriptor(object);
         addPackagePrefixPropertyDescriptor(object);
         addActivePropertyDescriptor(object);
         addProfilePropertyDescriptor(object);
      }
      return itemPropertyDescriptors;
   }

   /**
    * This adds a property descriptor for the Destination feature.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   protected void addDestinationPropertyDescriptor(Object object) {
      itemPropertyDescriptors.add
         (new ItemPropertyDescriptor
            (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
             getResourceLocator(),
             getString("_UI_GenerationProfile_destination_feature"),
             getString("_UI_PropertyDescriptor_description", "_UI_GenerationProfile_destination_feature", "_UI_GenerationProfile_type"),
             UmsPackage.eINSTANCE.getGenerationProfile_Destination(),
             true,
             ItemPropertyDescriptor.GENERIC_VALUE_IMAGE));
   }

   /**
    * This adds a property descriptor for the Package Prefix feature.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   protected void addPackagePrefixPropertyDescriptor(Object object) {
      itemPropertyDescriptors.add
         (new ItemPropertyDescriptor
            (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
             getResourceLocator(),
             getString("_UI_GenerationProfile_packagePrefix_feature"),
             getString("_UI_PropertyDescriptor_description", "_UI_GenerationProfile_packagePrefix_feature", "_UI_GenerationProfile_type"),
             UmsPackage.eINSTANCE.getGenerationProfile_PackagePrefix(),
             true,
             ItemPropertyDescriptor.GENERIC_VALUE_IMAGE));
   }

   /**
    * This adds a property descriptor for the Active feature.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   protected void addActivePropertyDescriptor(Object object) {
      itemPropertyDescriptors.add
         (new ItemPropertyDescriptor
            (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
             getResourceLocator(),
             getString("_UI_GenerationProfile_active_feature"),
             getString("_UI_PropertyDescriptor_description", "_UI_GenerationProfile_active_feature", "_UI_GenerationProfile_type"),
             UmsPackage.eINSTANCE.getGenerationProfile_Active(),
             true,
             ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE));
   }

   /**
    * This adds a property descriptor for the Profile feature.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   protected void addProfilePropertyDescriptor(Object object) {
      itemPropertyDescriptors.add
         (new ItemPropertyDescriptor
            (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
             getResourceLocator(),
             getString("_UI_GenerationProfile_profile_feature"),
             getString("_UI_PropertyDescriptor_description", "_UI_GenerationProfile_profile_feature", "_UI_GenerationProfile_type"),
             UmsPackage.eINSTANCE.getGenerationProfile_Profile(),
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
         childrenFeatures.add(UmsPackage.eINSTANCE.getGenerationProfile_Properties());
      }
      return childrenFeatures;
   }

   /**
    * This returns GenerationProfile.gif.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public Object getImage(Object object) {
      return getResourceLocator().getImage("full/obj16/GenerationProfile");
   }

   /**
    * This returns the label text for the adapted class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated NOT
    */
   public String getText(Object object) {
      GenerationProfile profile = (GenerationProfile) object;
      
      if ( profile.getProfile() != null )
         return getString("_UI_GenerationProfile_type") + ": " + profile.getProfile().getName() + " -> " + profile.getDestination();
      else
         return getString("_UI_GenerationProfile_type") + " not set";
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

      switch (notification.getFeatureID(GenerationProfile.class)) {
         case UmsPackage.GENERATION_PROFILE__DESTINATION:
         case UmsPackage.GENERATION_PROFILE__PACKAGE_PREFIX:
         case UmsPackage.GENERATION_PROFILE__ACTIVE:
         case UmsPackage.GENERATION_PROFILE__PROFILE:
            fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
            return;
         case UmsPackage.GENERATION_PROFILE__PROPERTIES:
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
            (UmsPackage.eINSTANCE.getGenerationProfile_Properties(),
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
