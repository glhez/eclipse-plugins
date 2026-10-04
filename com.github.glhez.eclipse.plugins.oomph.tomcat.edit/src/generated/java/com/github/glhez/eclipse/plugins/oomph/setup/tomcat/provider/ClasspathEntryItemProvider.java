/**
 */
package com.github.glhez.eclipse.plugins.oomph.setup.tomcat.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IChildCreationExtender;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;

import com.github.glhez.eclipse.plugins.oomph.setup.tomcat.ClasspathEntry;
import com.github.glhez.eclipse.plugins.oomph.setup.tomcat.TomcatServerPackage;

/**
 * This is the item provider adapter for a {@link com.github.glhez.eclipse.plugins.oomph.setup.tomcat.ClasspathEntry} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class ClasspathEntryItemProvider
    extends ItemProviderAdapter
    implements
    IEditingDomainItemProvider,
    IStructuredItemContentProvider,
    ITreeItemContentProvider,
    IItemLabelProvider,
    IItemPropertySource {
  /**
   * This constructs an instance from a factory and a notifier.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  public ClasspathEntryItemProvider(final AdapterFactory adapterFactory) {
    super(adapterFactory);
  }

  /**
   * This returns the property descriptors for the adapted class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public List<IItemPropertyDescriptor> getPropertyDescriptors(final Object object) {
    if (itemPropertyDescriptors == null) {
      super.getPropertyDescriptors(object);

      addEntryPropertyDescriptor(object);
      addPatternPropertyDescriptor(object);
      addSortPropertyDescriptor(object);
    }
    return itemPropertyDescriptors;
  }

  /**
   * This adds a property descriptor for the Entry feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  protected void addEntryPropertyDescriptor(final Object object) {
    itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
                                                             getResourceLocator(),
                                                             getString("_UI_ClasspathEntry_entry_feature"),
                                                             getString("_UI_PropertyDescriptor_description", "_UI_ClasspathEntry_entry_feature",
                                                                       "_UI_ClasspathEntry_type"),
                                                             TomcatServerPackage.Literals.CLASSPATH_ENTRY__ENTRY,
                                                             true,
                                                             false,
                                                             false,
                                                             ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                                                             null,
                                                             null));
  }

  /**
   * This adds a property descriptor for the Pattern feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  protected void addPatternPropertyDescriptor(final Object object) {
    itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
                                                             getResourceLocator(),
                                                             getString("_UI_ClasspathEntry_pattern_feature"),
                                                             getString("_UI_PropertyDescriptor_description", "_UI_ClasspathEntry_pattern_feature",
                                                                       "_UI_ClasspathEntry_type"),
                                                             TomcatServerPackage.Literals.CLASSPATH_ENTRY__PATTERN,
                                                             true,
                                                             false,
                                                             false,
                                                             ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                                                             null,
                                                             null));
  }

  /**
   * This adds a property descriptor for the Sort feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  protected void addSortPropertyDescriptor(final Object object) {
    itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
                                                             getResourceLocator(),
                                                             getString("_UI_ClasspathEntry_sort_feature"),
                                                             getString("_UI_PropertyDescriptor_description", "_UI_ClasspathEntry_sort_feature",
                                                                       "_UI_ClasspathEntry_type"),
                                                             TomcatServerPackage.Literals.CLASSPATH_ENTRY__SORT,
                                                             true,
                                                             false,
                                                             false,
                                                             ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
                                                             null,
                                                             null));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public boolean hasChildren(final Object object) {
    return hasChildren(object, true);
  }

  /**
   * This returns ClasspathEntry.gif.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public Object getImage(final Object object) {
    return overlayImage(object, getResourceLocator().getImage("full/obj16/ClasspathEntry"));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  protected boolean shouldComposeCreationImage() {
    return true;
  }

  /**
   * This returns the label text for the adapted class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public String getText(final Object object) {
    var label = ((ClasspathEntry) object).getEntry();
    return label == null || label.length() == 0 ? getString("_UI_ClasspathEntry_type") : getString("_UI_ClasspathEntry_type") + " " + label;
  }

  /**
   * This handles model notifications by calling {@link #updateChildren} to update any cached
   * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public void notifyChanged(final Notification notification) {
    updateChildren(notification);

    switch (notification.getFeatureID(ClasspathEntry.class)) {
      case TomcatServerPackage.CLASSPATH_ENTRY__ENTRY:
      case TomcatServerPackage.CLASSPATH_ENTRY__PATTERN:
      case TomcatServerPackage.CLASSPATH_ENTRY__SORT:
        fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
        return;
    }
    super.notifyChanged(notification);
  }

  /**
   * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
   * that can be created under this object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  protected void collectNewChildDescriptors(final Collection<Object> newChildDescriptors, final Object object) {
    super.collectNewChildDescriptors(newChildDescriptors, object);
  }

  /**
   * Return the resource locator for this item provider's resources.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public ResourceLocator getResourceLocator() {
    return ((IChildCreationExtender) adapterFactory).getResourceLocator();
  }

}
