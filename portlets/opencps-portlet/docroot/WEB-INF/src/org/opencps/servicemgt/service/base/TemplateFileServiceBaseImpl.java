/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package org.opencps.servicemgt.service.base;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.BaseServiceImpl;
import com.liferay.portal.service.persistence.UserPersistence;

import org.opencps.servicemgt.model.TemplateFile;
import org.opencps.servicemgt.service.TemplateFileService;
import org.opencps.servicemgt.service.persistence.ServiceFileTemplatePersistence;
import org.opencps.servicemgt.service.persistence.ServiceInfoPersistence;
import org.opencps.servicemgt.service.persistence.TemplateFilePersistence;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the template file remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link org.opencps.servicemgt.service.impl.TemplateFileServiceImpl}.
 * </p>
 *
 * @author khoavd
 * @see org.opencps.servicemgt.service.impl.TemplateFileServiceImpl
 * @see org.opencps.servicemgt.service.TemplateFileServiceUtil
 * @generated
 */
public abstract class TemplateFileServiceBaseImpl extends BaseServiceImpl
	implements TemplateFileService, IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link org.opencps.servicemgt.service.TemplateFileServiceUtil} to access the template file remote service.
	 */

	/**
	 * Returns the service file template local service.
	 *
	 * @return the service file template local service
	 */
	public org.opencps.servicemgt.service.ServiceFileTemplateLocalService getServiceFileTemplateLocalService() {
		return serviceFileTemplateLocalService;
	}

	/**
	 * Sets the service file template local service.
	 *
	 * @param serviceFileTemplateLocalService the service file template local service
	 */
	public void setServiceFileTemplateLocalService(
		org.opencps.servicemgt.service.ServiceFileTemplateLocalService serviceFileTemplateLocalService) {
		this.serviceFileTemplateLocalService = serviceFileTemplateLocalService;
	}

	/**
	 * Returns the service file template remote service.
	 *
	 * @return the service file template remote service
	 */
	public org.opencps.servicemgt.service.ServiceFileTemplateService getServiceFileTemplateService() {
		return serviceFileTemplateService;
	}

	/**
	 * Sets the service file template remote service.
	 *
	 * @param serviceFileTemplateService the service file template remote service
	 */
	public void setServiceFileTemplateService(
		org.opencps.servicemgt.service.ServiceFileTemplateService serviceFileTemplateService) {
		this.serviceFileTemplateService = serviceFileTemplateService;
	}

	/**
	 * Returns the service file template persistence.
	 *
	 * @return the service file template persistence
	 */
	public ServiceFileTemplatePersistence getServiceFileTemplatePersistence() {
		return serviceFileTemplatePersistence;
	}

	/**
	 * Sets the service file template persistence.
	 *
	 * @param serviceFileTemplatePersistence the service file template persistence
	 */
	public void setServiceFileTemplatePersistence(
		ServiceFileTemplatePersistence serviceFileTemplatePersistence) {
		this.serviceFileTemplatePersistence = serviceFileTemplatePersistence;
	}

	/**
	 * Returns the service info local service.
	 *
	 * @return the service info local service
	 */
	public org.opencps.servicemgt.service.ServiceInfoLocalService getServiceInfoLocalService() {
		return serviceInfoLocalService;
	}

	/**
	 * Sets the service info local service.
	 *
	 * @param serviceInfoLocalService the service info local service
	 */
	public void setServiceInfoLocalService(
		org.opencps.servicemgt.service.ServiceInfoLocalService serviceInfoLocalService) {
		this.serviceInfoLocalService = serviceInfoLocalService;
	}

	/**
	 * Returns the service info remote service.
	 *
	 * @return the service info remote service
	 */
	public org.opencps.servicemgt.service.ServiceInfoService getServiceInfoService() {
		return serviceInfoService;
	}

	/**
	 * Sets the service info remote service.
	 *
	 * @param serviceInfoService the service info remote service
	 */
	public void setServiceInfoService(
		org.opencps.servicemgt.service.ServiceInfoService serviceInfoService) {
		this.serviceInfoService = serviceInfoService;
	}

	/**
	 * Returns the service info persistence.
	 *
	 * @return the service info persistence
	 */
	public ServiceInfoPersistence getServiceInfoPersistence() {
		return serviceInfoPersistence;
	}

	/**
	 * Sets the service info persistence.
	 *
	 * @param serviceInfoPersistence the service info persistence
	 */
	public void setServiceInfoPersistence(
		ServiceInfoPersistence serviceInfoPersistence) {
		this.serviceInfoPersistence = serviceInfoPersistence;
	}

	/**
	 * Returns the template file local service.
	 *
	 * @return the template file local service
	 */
	public org.opencps.servicemgt.service.TemplateFileLocalService getTemplateFileLocalService() {
		return templateFileLocalService;
	}

	/**
	 * Sets the template file local service.
	 *
	 * @param templateFileLocalService the template file local service
	 */
	public void setTemplateFileLocalService(
		org.opencps.servicemgt.service.TemplateFileLocalService templateFileLocalService) {
		this.templateFileLocalService = templateFileLocalService;
	}

	/**
	 * Returns the template file remote service.
	 *
	 * @return the template file remote service
	 */
	public org.opencps.servicemgt.service.TemplateFileService getTemplateFileService() {
		return templateFileService;
	}

	/**
	 * Sets the template file remote service.
	 *
	 * @param templateFileService the template file remote service
	 */
	public void setTemplateFileService(
		org.opencps.servicemgt.service.TemplateFileService templateFileService) {
		this.templateFileService = templateFileService;
	}

	/**
	 * Returns the template file persistence.
	 *
	 * @return the template file persistence
	 */
	public TemplateFilePersistence getTemplateFilePersistence() {
		return templateFilePersistence;
	}

	/**
	 * Sets the template file persistence.
	 *
	 * @param templateFilePersistence the template file persistence
	 */
	public void setTemplateFilePersistence(
		TemplateFilePersistence templateFilePersistence) {
		this.templateFilePersistence = templateFilePersistence;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public com.liferay.counter.service.CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(
		com.liferay.counter.service.CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public com.liferay.portal.service.ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		com.liferay.portal.service.ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public com.liferay.portal.service.UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(
		com.liferay.portal.service.UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user remote service.
	 *
	 * @return the user remote service
	 */
	public com.liferay.portal.service.UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(
		com.liferay.portal.service.UserService userService) {
		this.userService = userService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
		Class<?> clazz = getClass();

		_classLoader = clazz.getClassLoader();
	}

	public void destroy() {
	}

	/**
	 * Returns the Spring bean ID for this bean.
	 *
	 * @return the Spring bean ID for this bean
	 */
	@Override
	public String getBeanIdentifier() {
		return _beanIdentifier;
	}

	/**
	 * Sets the Spring bean ID for this bean.
	 *
	 * @param beanIdentifier the Spring bean ID for this bean
	 */
	@Override
	public void setBeanIdentifier(String beanIdentifier) {
		_beanIdentifier = beanIdentifier;
	}

	@Override
	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		if (contextClassLoader != _classLoader) {
			currentThread.setContextClassLoader(_classLoader);
		}

		try {
			return _clpInvoker.invokeMethod(name, parameterTypes, arguments);
		}
		finally {
			if (contextClassLoader != _classLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	protected Class<?> getModelClass() {
		return TemplateFile.class;
	}

	protected String getModelClassName() {
		return TemplateFile.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = templateFilePersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = org.opencps.servicemgt.service.ServiceFileTemplateLocalService.class)
	protected org.opencps.servicemgt.service.ServiceFileTemplateLocalService serviceFileTemplateLocalService;
	@BeanReference(type = org.opencps.servicemgt.service.ServiceFileTemplateService.class)
	protected org.opencps.servicemgt.service.ServiceFileTemplateService serviceFileTemplateService;
	@BeanReference(type = ServiceFileTemplatePersistence.class)
	protected ServiceFileTemplatePersistence serviceFileTemplatePersistence;
	@BeanReference(type = org.opencps.servicemgt.service.ServiceInfoLocalService.class)
	protected org.opencps.servicemgt.service.ServiceInfoLocalService serviceInfoLocalService;
	@BeanReference(type = org.opencps.servicemgt.service.ServiceInfoService.class)
	protected org.opencps.servicemgt.service.ServiceInfoService serviceInfoService;
	@BeanReference(type = ServiceInfoPersistence.class)
	protected ServiceInfoPersistence serviceInfoPersistence;
	@BeanReference(type = org.opencps.servicemgt.service.TemplateFileLocalService.class)
	protected org.opencps.servicemgt.service.TemplateFileLocalService templateFileLocalService;
	@BeanReference(type = org.opencps.servicemgt.service.TemplateFileService.class)
	protected org.opencps.servicemgt.service.TemplateFileService templateFileService;
	@BeanReference(type = TemplateFilePersistence.class)
	protected TemplateFilePersistence templateFilePersistence;
	@BeanReference(type = com.liferay.counter.service.CounterLocalService.class)
	protected com.liferay.counter.service.CounterLocalService counterLocalService;
	@BeanReference(type = com.liferay.portal.service.ResourceLocalService.class)
	protected com.liferay.portal.service.ResourceLocalService resourceLocalService;
	@BeanReference(type = com.liferay.portal.service.UserLocalService.class)
	protected com.liferay.portal.service.UserLocalService userLocalService;
	@BeanReference(type = com.liferay.portal.service.UserService.class)
	protected com.liferay.portal.service.UserService userService;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private String _beanIdentifier;
	private ClassLoader _classLoader;
	private TemplateFileServiceClpInvoker _clpInvoker = new TemplateFileServiceClpInvoker();
}