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

package org.opencps.holidayconfig.service.base;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.PersistedModel;
import com.liferay.portal.service.BaseLocalServiceImpl;
import com.liferay.portal.service.PersistedModelLocalServiceRegistryUtil;
import com.liferay.portal.service.persistence.UserPersistence;

import org.opencps.holidayconfig.model.HolidayConfigExtend;
import org.opencps.holidayconfig.service.HolidayConfigExtendLocalService;
import org.opencps.holidayconfig.service.persistence.HolidayConfigExtendPersistence;
import org.opencps.holidayconfig.service.persistence.HolidayConfigFinder;
import org.opencps.holidayconfig.service.persistence.HolidayConfigPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the holiday config extend local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link org.opencps.holidayconfig.service.impl.HolidayConfigExtendLocalServiceImpl}.
 * </p>
 *
 * @author nhanhoang
 * @see org.opencps.holidayconfig.service.impl.HolidayConfigExtendLocalServiceImpl
 * @see org.opencps.holidayconfig.service.HolidayConfigExtendLocalServiceUtil
 * @generated
 */
public abstract class HolidayConfigExtendLocalServiceBaseImpl
	extends BaseLocalServiceImpl implements HolidayConfigExtendLocalService,
		IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link org.opencps.holidayconfig.service.HolidayConfigExtendLocalServiceUtil} to access the holiday config extend local service.
	 */

	/**
	 * Adds the holiday config extend to the database. Also notifies the appropriate model listeners.
	 *
	 * @param holidayConfigExtend the holiday config extend
	 * @return the holiday config extend that was added
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public HolidayConfigExtend addHolidayConfigExtend(
		HolidayConfigExtend holidayConfigExtend) throws SystemException {
		holidayConfigExtend.setNew(true);

		return holidayConfigExtendPersistence.update(holidayConfigExtend);
	}

	/**
	 * Creates a new holiday config extend with the primary key. Does not add the holiday config extend to the database.
	 *
	 * @param holidayExtendId the primary key for the new holiday config extend
	 * @return the new holiday config extend
	 */
	@Override
	public HolidayConfigExtend createHolidayConfigExtend(long holidayExtendId) {
		return holidayConfigExtendPersistence.create(holidayExtendId);
	}

	/**
	 * Deletes the holiday config extend with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param holidayExtendId the primary key of the holiday config extend
	 * @return the holiday config extend that was removed
	 * @throws PortalException if a holiday config extend with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public HolidayConfigExtend deleteHolidayConfigExtend(long holidayExtendId)
		throws PortalException, SystemException {
		return holidayConfigExtendPersistence.remove(holidayExtendId);
	}

	/**
	 * Deletes the holiday config extend from the database. Also notifies the appropriate model listeners.
	 *
	 * @param holidayConfigExtend the holiday config extend
	 * @return the holiday config extend that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public HolidayConfigExtend deleteHolidayConfigExtend(
		HolidayConfigExtend holidayConfigExtend) throws SystemException {
		return holidayConfigExtendPersistence.remove(holidayConfigExtend);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(HolidayConfigExtend.class,
			clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return holidayConfigExtendPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.holidayconfig.model.impl.HolidayConfigExtendModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return holidayConfigExtendPersistence.findWithDynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.holidayconfig.model.impl.HolidayConfigExtendModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return holidayConfigExtendPersistence.findWithDynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows that match the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows that match the dynamic query
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery)
		throws SystemException {
		return holidayConfigExtendPersistence.countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Returns the number of rows that match the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows that match the dynamic query
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery,
		Projection projection) throws SystemException {
		return holidayConfigExtendPersistence.countWithDynamicQuery(dynamicQuery,
			projection);
	}

	@Override
	public HolidayConfigExtend fetchHolidayConfigExtend(long holidayExtendId)
		throws SystemException {
		return holidayConfigExtendPersistence.fetchByPrimaryKey(holidayExtendId);
	}

	/**
	 * Returns the holiday config extend with the primary key.
	 *
	 * @param holidayExtendId the primary key of the holiday config extend
	 * @return the holiday config extend
	 * @throws PortalException if a holiday config extend with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public HolidayConfigExtend getHolidayConfigExtend(long holidayExtendId)
		throws PortalException, SystemException {
		return holidayConfigExtendPersistence.findByPrimaryKey(holidayExtendId);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException, SystemException {
		return holidayConfigExtendPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the holiday config extends.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.holidayconfig.model.impl.HolidayConfigExtendModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of holiday config extends
	 * @param end the upper bound of the range of holiday config extends (not inclusive)
	 * @return the range of holiday config extends
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<HolidayConfigExtend> getHolidayConfigExtends(int start, int end)
		throws SystemException {
		return holidayConfigExtendPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of holiday config extends.
	 *
	 * @return the number of holiday config extends
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int getHolidayConfigExtendsCount() throws SystemException {
		return holidayConfigExtendPersistence.countAll();
	}

	/**
	 * Updates the holiday config extend in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param holidayConfigExtend the holiday config extend
	 * @return the holiday config extend that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public HolidayConfigExtend updateHolidayConfigExtend(
		HolidayConfigExtend holidayConfigExtend) throws SystemException {
		return holidayConfigExtendPersistence.update(holidayConfigExtend);
	}

	/**
	 * Returns the holiday config local service.
	 *
	 * @return the holiday config local service
	 */
	public org.opencps.holidayconfig.service.HolidayConfigLocalService getHolidayConfigLocalService() {
		return holidayConfigLocalService;
	}

	/**
	 * Sets the holiday config local service.
	 *
	 * @param holidayConfigLocalService the holiday config local service
	 */
	public void setHolidayConfigLocalService(
		org.opencps.holidayconfig.service.HolidayConfigLocalService holidayConfigLocalService) {
		this.holidayConfigLocalService = holidayConfigLocalService;
	}

	/**
	 * Returns the holiday config persistence.
	 *
	 * @return the holiday config persistence
	 */
	public HolidayConfigPersistence getHolidayConfigPersistence() {
		return holidayConfigPersistence;
	}

	/**
	 * Sets the holiday config persistence.
	 *
	 * @param holidayConfigPersistence the holiday config persistence
	 */
	public void setHolidayConfigPersistence(
		HolidayConfigPersistence holidayConfigPersistence) {
		this.holidayConfigPersistence = holidayConfigPersistence;
	}

	/**
	 * Returns the holiday config finder.
	 *
	 * @return the holiday config finder
	 */
	public HolidayConfigFinder getHolidayConfigFinder() {
		return holidayConfigFinder;
	}

	/**
	 * Sets the holiday config finder.
	 *
	 * @param holidayConfigFinder the holiday config finder
	 */
	public void setHolidayConfigFinder(HolidayConfigFinder holidayConfigFinder) {
		this.holidayConfigFinder = holidayConfigFinder;
	}

	/**
	 * Returns the holiday config extend local service.
	 *
	 * @return the holiday config extend local service
	 */
	public org.opencps.holidayconfig.service.HolidayConfigExtendLocalService getHolidayConfigExtendLocalService() {
		return holidayConfigExtendLocalService;
	}

	/**
	 * Sets the holiday config extend local service.
	 *
	 * @param holidayConfigExtendLocalService the holiday config extend local service
	 */
	public void setHolidayConfigExtendLocalService(
		org.opencps.holidayconfig.service.HolidayConfigExtendLocalService holidayConfigExtendLocalService) {
		this.holidayConfigExtendLocalService = holidayConfigExtendLocalService;
	}

	/**
	 * Returns the holiday config extend persistence.
	 *
	 * @return the holiday config extend persistence
	 */
	public HolidayConfigExtendPersistence getHolidayConfigExtendPersistence() {
		return holidayConfigExtendPersistence;
	}

	/**
	 * Sets the holiday config extend persistence.
	 *
	 * @param holidayConfigExtendPersistence the holiday config extend persistence
	 */
	public void setHolidayConfigExtendPersistence(
		HolidayConfigExtendPersistence holidayConfigExtendPersistence) {
		this.holidayConfigExtendPersistence = holidayConfigExtendPersistence;
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

		PersistedModelLocalServiceRegistryUtil.register("org.opencps.holidayconfig.model.HolidayConfigExtend",
			holidayConfigExtendLocalService);
	}

	public void destroy() {
		PersistedModelLocalServiceRegistryUtil.unregister(
			"org.opencps.holidayconfig.model.HolidayConfigExtend");
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
		return HolidayConfigExtend.class;
	}

	protected String getModelClassName() {
		return HolidayConfigExtend.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = holidayConfigExtendPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = org.opencps.holidayconfig.service.HolidayConfigLocalService.class)
	protected org.opencps.holidayconfig.service.HolidayConfigLocalService holidayConfigLocalService;
	@BeanReference(type = HolidayConfigPersistence.class)
	protected HolidayConfigPersistence holidayConfigPersistence;
	@BeanReference(type = HolidayConfigFinder.class)
	protected HolidayConfigFinder holidayConfigFinder;
	@BeanReference(type = org.opencps.holidayconfig.service.HolidayConfigExtendLocalService.class)
	protected org.opencps.holidayconfig.service.HolidayConfigExtendLocalService holidayConfigExtendLocalService;
	@BeanReference(type = HolidayConfigExtendPersistence.class)
	protected HolidayConfigExtendPersistence holidayConfigExtendPersistence;
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
	private HolidayConfigExtendLocalServiceClpInvoker _clpInvoker = new HolidayConfigExtendLocalServiceClpInvoker();
}