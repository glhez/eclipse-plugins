/**
 */
package com.github.glhez.eclipse.plugins.oomph.setup.tomcat.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.eclipse.oomph.base.BaseFactory;
import org.eclipse.oomph.base.BasePackage;
import org.eclipse.oomph.setup.provider.SetupTaskItemProvider;

import com.github.glhez.eclipse.plugins.oomph.setup.tomcat.TomcatServerPackage;
import com.github.glhez.eclipse.plugins.oomph.setup.tomcat.TomcatServerTask;

/**
 * This is the item provider adapter for a {@link com.github.glhez.eclipse.plugins.oomph.setup.tomcat.TomcatServerTask} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class TomcatServerTaskItemProvider extends SetupTaskItemProvider {
  /**
   * This constructs an instance from a factory and a notifier.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  public TomcatServerTaskItemProvider(final AdapterFactory adapterFactory) {
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

      addServerNamePropertyDescriptor(object);
      addServerVersionPropertyDescriptor(object);
      addLocationPropertyDescriptor(object);
      addRuntimeNamePropertyDescriptor(object);
      addHostnamePropertyDescriptor(object);
      addJreVersionPropertyDescriptor(object);
      addHttpPortPropertyDescriptor(object);
      addHttpsPortPropertyDescriptor(object);
      addLaunchProgramArgsPropertyDescriptor(object);
      addLaunchVmArgsPropertyDescriptor(object);
      addCleanPreviousRuntimesPropertyDescriptor(object);
      addStartTimeoutPropertyDescriptor(object);
      addStopTimeoutPropertyDescriptor(object);
      addAutoPublishPropertyDescriptor(object);
    }
    return itemPropertyDescriptors;
  }

  /**
   * This adds a property descriptor for the Server Name feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  protected void addServerNamePropertyDescriptor(final Object object) {
    itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
                                                             getResourceLocator(),
                                                             getString("_UI_TomcatServerTask_serverName_feature"),
                                                             getString("_UI_PropertyDescriptor_description",
                                                                       "_UI_TomcatServerTask_serverName_feature", "_UI_TomcatServerTask_type"),
                                                             TomcatServerPackage.Literals.TOMCAT_SERVER_TASK__SERVER_NAME,
                                                             true,
                                                             false,
                                                             false,
                                                             ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                                                             null,
                                                             null));
  }

  /**
   * This adds a property descriptor for the Server Version feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  protected void addServerVersionPropertyDescriptor(final Object object) {
    itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
                                                             getResourceLocator(),
                                                             getString("_UI_TomcatServerTask_serverVersion_feature"),
                                                             getString("_UI_PropertyDescriptor_description",
                                                                       "_UI_TomcatServerTask_serverVersion_feature", "_UI_TomcatServerTask_type"),
                                                             TomcatServerPackage.Literals.TOMCAT_SERVER_TASK__SERVER_VERSION,
                                                             true,
                                                             false,
                                                             false,
                                                             ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                                                             null,
                                                             null));
  }

  /**
   * This adds a property descriptor for the Location feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  protected void addLocationPropertyDescriptor(final Object object) {
    itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
                                                             getResourceLocator(),
                                                             getString("_UI_TomcatServerTask_location_feature"),
                                                             getString("_UI_PropertyDescriptor_description", "_UI_TomcatServerTask_location_feature",
                                                                       "_UI_TomcatServerTask_type"),
                                                             TomcatServerPackage.Literals.TOMCAT_SERVER_TASK__LOCATION,
                                                             true,
                                                             false,
                                                             false,
                                                             ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                                                             null,
                                                             null));
  }

  /**
   * This adds a property descriptor for the Runtime Name feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  protected void addRuntimeNamePropertyDescriptor(final Object object) {
    itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
                                                             getResourceLocator(),
                                                             getString("_UI_TomcatServerTask_runtimeName_feature"),
                                                             getString("_UI_PropertyDescriptor_description",
                                                                       "_UI_TomcatServerTask_runtimeName_feature", "_UI_TomcatServerTask_type"),
                                                             TomcatServerPackage.Literals.TOMCAT_SERVER_TASK__RUNTIME_NAME,
                                                             true,
                                                             false,
                                                             false,
                                                             ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                                                             null,
                                                             null));
  }

  /**
   * This adds a property descriptor for the Hostname feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  protected void addHostnamePropertyDescriptor(final Object object) {
    itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
                                                             getResourceLocator(),
                                                             getString("_UI_TomcatServerTask_hostname_feature"),
                                                             getString("_UI_PropertyDescriptor_description", "_UI_TomcatServerTask_hostname_feature",
                                                                       "_UI_TomcatServerTask_type"),
                                                             TomcatServerPackage.Literals.TOMCAT_SERVER_TASK__HOSTNAME,
                                                             true,
                                                             false,
                                                             false,
                                                             ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                                                             null,
                                                             null));
  }

  /**
   * This adds a property descriptor for the Jre Version feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  protected void addJreVersionPropertyDescriptor(final Object object) {
    itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
                                                             getResourceLocator(),
                                                             getString("_UI_TomcatServerTask_jreVersion_feature"),
                                                             getString("_UI_PropertyDescriptor_description",
                                                                       "_UI_TomcatServerTask_jreVersion_feature", "_UI_TomcatServerTask_type"),
                                                             TomcatServerPackage.Literals.TOMCAT_SERVER_TASK__JRE_VERSION,
                                                             true,
                                                             false,
                                                             false,
                                                             ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                                                             null,
                                                             null));
  }

  /**
   * This adds a property descriptor for the Http Port feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  protected void addHttpPortPropertyDescriptor(final Object object) {
    itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
                                                             getResourceLocator(),
                                                             getString("_UI_TomcatServerTask_httpPort_feature"),
                                                             getString("_UI_PropertyDescriptor_description", "_UI_TomcatServerTask_httpPort_feature",
                                                                       "_UI_TomcatServerTask_type"),
                                                             TomcatServerPackage.Literals.TOMCAT_SERVER_TASK__HTTP_PORT,
                                                             true,
                                                             false,
                                                             false,
                                                             ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                                                             null,
                                                             null));
  }

  /**
   * This adds a property descriptor for the Https Port feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  protected void addHttpsPortPropertyDescriptor(final Object object) {
    itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
                                                             getResourceLocator(),
                                                             getString("_UI_TomcatServerTask_httpsPort_feature"),
                                                             getString("_UI_PropertyDescriptor_description", "_UI_TomcatServerTask_httpsPort_feature",
                                                                       "_UI_TomcatServerTask_type"),
                                                             TomcatServerPackage.Literals.TOMCAT_SERVER_TASK__HTTPS_PORT,
                                                             true,
                                                             false,
                                                             false,
                                                             ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                                                             null,
                                                             null));
  }

  /**
   * This adds a property descriptor for the Launch Program Args feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  protected void addLaunchProgramArgsPropertyDescriptor(final Object object) {
    itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
                                                             getResourceLocator(),
                                                             getString("_UI_TomcatServerTask_launchProgramArgs_feature"),
                                                             getString("_UI_PropertyDescriptor_description",
                                                                       "_UI_TomcatServerTask_launchProgramArgs_feature", "_UI_TomcatServerTask_type"),
                                                             TomcatServerPackage.Literals.TOMCAT_SERVER_TASK__LAUNCH_PROGRAM_ARGS,
                                                             true,
                                                             true,
                                                             false,
                                                             ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                                                             null,
                                                             null));
  }

  /**
   * This adds a property descriptor for the Launch Vm Args feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  protected void addLaunchVmArgsPropertyDescriptor(final Object object) {
    itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
                                                             getResourceLocator(),
                                                             getString("_UI_TomcatServerTask_launchVmArgs_feature"),
                                                             getString("_UI_PropertyDescriptor_description",
                                                                       "_UI_TomcatServerTask_launchVmArgs_feature", "_UI_TomcatServerTask_type"),
                                                             TomcatServerPackage.Literals.TOMCAT_SERVER_TASK__LAUNCH_VM_ARGS,
                                                             true,
                                                             true,
                                                             false,
                                                             ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                                                             null,
                                                             null));
  }

  /**
   * This adds a property descriptor for the Clean Previous Runtimes feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  protected void addCleanPreviousRuntimesPropertyDescriptor(final Object object) {
    itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
                                                             getResourceLocator(),
                                                             getString("_UI_TomcatServerTask_cleanPreviousRuntimes_feature"),
                                                             getString("_UI_PropertyDescriptor_description",
                                                                       "_UI_TomcatServerTask_cleanPreviousRuntimes_feature",
                                                                       "_UI_TomcatServerTask_type"),
                                                             TomcatServerPackage.Literals.TOMCAT_SERVER_TASK__CLEAN_PREVIOUS_RUNTIMES,
                                                             true,
                                                             false,
                                                             false,
                                                             ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
                                                             null,
                                                             null));
  }

  /**
   * This adds a property descriptor for the Start Timeout feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  protected void addStartTimeoutPropertyDescriptor(final Object object) {
    itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
                                                             getResourceLocator(),
                                                             getString("_UI_TomcatServerTask_startTimeout_feature"),
                                                             getString("_UI_PropertyDescriptor_description",
                                                                       "_UI_TomcatServerTask_startTimeout_feature", "_UI_TomcatServerTask_type"),
                                                             TomcatServerPackage.Literals.TOMCAT_SERVER_TASK__START_TIMEOUT,
                                                             true,
                                                             false,
                                                             false,
                                                             ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                                                             null,
                                                             null));
  }

  /**
   * This adds a property descriptor for the Stop Timeout feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  protected void addStopTimeoutPropertyDescriptor(final Object object) {
    itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
                                                             getResourceLocator(),
                                                             getString("_UI_TomcatServerTask_stopTimeout_feature"),
                                                             getString("_UI_PropertyDescriptor_description",
                                                                       "_UI_TomcatServerTask_stopTimeout_feature", "_UI_TomcatServerTask_type"),
                                                             TomcatServerPackage.Literals.TOMCAT_SERVER_TASK__STOP_TIMEOUT,
                                                             true,
                                                             false,
                                                             false,
                                                             ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                                                             null,
                                                             null));
  }

  /**
   * This adds a property descriptor for the Auto Publish feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  protected void addAutoPublishPropertyDescriptor(final Object object) {
    itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
                                                             getResourceLocator(),
                                                             getString("_UI_TomcatServerTask_autoPublish_feature"),
                                                             getString("_UI_PropertyDescriptor_description",
                                                                       "_UI_TomcatServerTask_autoPublish_feature", "_UI_TomcatServerTask_type"),
                                                             TomcatServerPackage.Literals.TOMCAT_SERVER_TASK__AUTO_PUBLISH,
                                                             true,
                                                             false,
                                                             false,
                                                             ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                                                             null,
                                                             null));
  }

  /**
   * This returns TomcatServerTask.gif.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated NOT
   */
  @Override
  public Object getImage(final Object object) {
    return overlayImage(object, getResourceLocator().getImage("full/obj16/TomcatServerTask16x16.ico"));
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
    var label = ((TomcatServerTask) object).getID();
    return label == null || label.length() == 0 ? getString("_UI_TomcatServerTask_type") : getString("_UI_TomcatServerTask_type") + " " + label;
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

    switch (notification.getFeatureID(TomcatServerTask.class)) {
      case TomcatServerPackage.TOMCAT_SERVER_TASK__SERVER_NAME:
      case TomcatServerPackage.TOMCAT_SERVER_TASK__SERVER_VERSION:
      case TomcatServerPackage.TOMCAT_SERVER_TASK__LOCATION:
      case TomcatServerPackage.TOMCAT_SERVER_TASK__RUNTIME_NAME:
      case TomcatServerPackage.TOMCAT_SERVER_TASK__HOSTNAME:
      case TomcatServerPackage.TOMCAT_SERVER_TASK__JRE_VERSION:
      case TomcatServerPackage.TOMCAT_SERVER_TASK__HTTP_PORT:
      case TomcatServerPackage.TOMCAT_SERVER_TASK__HTTPS_PORT:
      case TomcatServerPackage.TOMCAT_SERVER_TASK__LAUNCH_PROGRAM_ARGS:
      case TomcatServerPackage.TOMCAT_SERVER_TASK__LAUNCH_VM_ARGS:
      case TomcatServerPackage.TOMCAT_SERVER_TASK__CLEAN_PREVIOUS_RUNTIMES:
      case TomcatServerPackage.TOMCAT_SERVER_TASK__START_TIMEOUT:
      case TomcatServerPackage.TOMCAT_SERVER_TASK__STOP_TIMEOUT:
      case TomcatServerPackage.TOMCAT_SERVER_TASK__AUTO_PUBLISH:
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

    newChildDescriptors.add(createChildParameter(BasePackage.Literals.MODEL_ELEMENT__ANNOTATIONS,
                                                 BaseFactory.eINSTANCE.createAnnotation()));
  }

}
