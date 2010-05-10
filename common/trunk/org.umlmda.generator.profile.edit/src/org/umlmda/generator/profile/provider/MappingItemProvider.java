/**
 * <copyright>
 * </copyright>
 *
 */
package org.umlmda.generator.profile.provider;


import java.util.Collection;
import java.util.List;

import java.util.Properties;

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
import org.umlmda.generator.profile.Mapping;
import org.umlmda.generator.profile.UmpFactory;
import org.umlmda.generator.profile.UmpPackage;
import org.umlmda.generator.set.provider.UmpEditPlugin;

/**
 * This is the item provider adpater for a {@link org.umlmda.generator.profile.Mapping} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class MappingItemProvider
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
   public MappingItemProvider(AdapterFactory adapterFactory) {
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

         addArtefactPropertyDescriptor(object);
      }
      return itemPropertyDescriptors;
   }

   /**
    * This adds a property descriptor for the Artefact feature.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   protected void addArtefactPropertyDescriptor(Object object) {
      itemPropertyDescriptors.add
         (new ItemPropertyDescriptor
            (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
             getResourceLocator(),
             getString("_UI_Mapping_artefact_feature"),
             getString("_UI_PropertyDescriptor_description", "_UI_Mapping_artefact_feature", "_UI_Mapping_type"),
             UmpPackage.eINSTANCE.getMapping_Artefact(),
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
         childrenFeatures.add(UmpPackage.eINSTANCE.getMapping_Properties());
         childrenFeatures.add(UmpPackage.eINSTANCE.getMapping_SubMappings());
         childrenFeatures.add(UmpPackage.eINSTANCE.getMapping_MappingProperties());
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
    * This returns Mapping.gif.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public Object getImage(Object object) {
      return getResourceLocator().getImage("full/obj16/Mapping");
   }

   /**
    * This returns the label text for the adapted class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated NOT
    */
   public String getText(Object object) {
      Mapping mapping = (Mapping) object;
      
      if ( mapping.getArtefact() != null ) {
         return getString("_UI_Mapping_type") + ": " + mapping.getArtefact().getName();
      }
      else {
         return getString("_UI_Mapping_type") + " not set";
      }
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

      switch (notification.getFeatureID(Mapping.class)) {
         case UmpPackage.MAPPING__SUB_MAPPINGS:
         case UmpPackage.MAPPING__MAPPING_PROPERTIES:
            fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
            return;
         case UmpPackage.MAPPING__PROPERTIES:
            fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, true));
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
            (UmpPackage.eINSTANCE.getMapping_SubMappings(),
             UmpFactory.eINSTANCE.createStereotype()));

      newChildDescriptors.add
         (createChildParameter
            (UmpPackage.eINSTANCE.getMapping_SubMappings(),
             UmpFactory.eINSTANCE.createMetaModelElement()));

      newChildDescriptors.add
         (createChildParameter
            (UmpPackage.eINSTANCE.getMapping_MappingProperties(),
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
