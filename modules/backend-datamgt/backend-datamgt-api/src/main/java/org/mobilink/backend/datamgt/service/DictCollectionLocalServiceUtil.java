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

package org.mobilink.backend.datamgt.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.osgi.util.ServiceTrackerFactory;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for DictCollection. This utility wraps
 * {@link org.mobilink.backend.datamgt.service.impl.DictCollectionLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Binhth
 * @see DictCollectionLocalService
 * @see org.mobilink.backend.datamgt.service.base.DictCollectionLocalServiceBaseImpl
 * @see org.mobilink.backend.datamgt.service.impl.DictCollectionLocalServiceImpl
 * @generated
 */
@ProviderType
public class DictCollectionLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link org.mobilink.backend.datamgt.service.impl.DictCollectionLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return getService().getActionableDynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery getExportActionableDynamicQuery(
		com.liferay.exportimport.kernel.lar.PortletDataContext portletDataContext) {
		return getService().getExportActionableDynamicQuery(portletDataContext);
	}

	public static com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	public static com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deletePersistedModel(persistedModel);
	}

	public static com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* @param params

	<pre>
	<ol>
	<li> keywords </li>
	<li> groupId </li>
	<li> userId </li>
	<li> collectionCode </li>
	</ol>
	</pre>
	* @param sorts
	* @param start
	* @param end
	* @param searchContext
	* @throws ParseException,
	SearchException
	*/
	public static com.liferay.portal.kernel.search.Hits luceneSearchEngine(
		java.util.LinkedHashMap<java.lang.String, java.lang.Object> params,
		com.liferay.portal.kernel.search.Sort[] sorts, int start, int end,
		com.liferay.portal.kernel.search.SearchContext searchContext)
		throws com.liferay.portal.kernel.search.ParseException,
			com.liferay.portal.kernel.search.SearchException {
		return getService()
				   .luceneSearchEngine(params, sorts, start, end, searchContext);
	}

	/**
	* Returns the number of dict collections.
	*
	* @return the number of dict collections
	*/
	public static int getDictCollectionsCount() {
		return getService().getDictCollectionsCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static java.lang.String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.mobilink.backend.datamgt.model.impl.DictCollectionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.mobilink.backend.datamgt.model.impl.DictCollectionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns a range of all the dict collections.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.mobilink.backend.datamgt.model.impl.DictCollectionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of dict collections
	* @param end the upper bound of the range of dict collections (not inclusive)
	* @return the range of dict collections
	*/
	public static java.util.List<org.mobilink.backend.datamgt.model.DictCollection> getDictCollections(
		int start, int end) {
		return getService().getDictCollections(start, end);
	}

	/**
	* Returns all the dict collections matching the UUID and company.
	*
	* @param uuid the UUID of the dict collections
	* @param companyId the primary key of the company
	* @return the matching dict collections, or an empty list if no matches were found
	*/
	public static java.util.List<org.mobilink.backend.datamgt.model.DictCollection> getDictCollectionsByUuidAndCompanyId(
		java.lang.String uuid, long companyId) {
		return getService().getDictCollectionsByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns a range of dict collections matching the UUID and company.
	*
	* @param uuid the UUID of the dict collections
	* @param companyId the primary key of the company
	* @param start the lower bound of the range of dict collections
	* @param end the upper bound of the range of dict collections (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the range of matching dict collections, or an empty list if no matches were found
	*/
	public static java.util.List<org.mobilink.backend.datamgt.model.DictCollection> getDictCollectionsByUuidAndCompanyId(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<org.mobilink.backend.datamgt.model.DictCollection> orderByComparator) {
		return getService()
				   .getDictCollectionsByUuidAndCompanyId(uuid, companyId,
			start, end, orderByComparator);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	/**
	* @param userId
	* @param groupId
	* @param collectionCode
	* @param collectionName
	* @param description
	* @param serviceContext
	* @return
	* @throws Exception
	*/
	public static org.mobilink.backend.datamgt.model.DictCollection addDictCollection(
		long userId, long groupId, java.lang.String collectionCode,
		java.lang.String collectionName, java.lang.String description,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws java.lang.Exception {
		return getService()
				   .addDictCollection(userId, groupId, collectionCode,
			collectionName, description, serviceContext);
	}

	/**
	* Adds the dict collection to the database. Also notifies the appropriate model listeners.
	*
	* @param dictCollection the dict collection
	* @return the dict collection that was added
	*/
	public static org.mobilink.backend.datamgt.model.DictCollection addDictCollection(
		org.mobilink.backend.datamgt.model.DictCollection dictCollection) {
		return getService().addDictCollection(dictCollection);
	}

	/**
	* Creates a new dict collection with the primary key. Does not add the dict collection to the database.
	*
	* @param dictCollectionId the primary key for the new dict collection
	* @return the new dict collection
	*/
	public static org.mobilink.backend.datamgt.model.DictCollection createDictCollection(
		long dictCollectionId) {
		return getService().createDictCollection(dictCollectionId);
	}

	/**
	* Deletes the dict collection with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param dictCollectionId the primary key of the dict collection
	* @return the dict collection that was removed
	* @throws PortalException if a dict collection with the primary key could not be found
	*/
	public static org.mobilink.backend.datamgt.model.DictCollection deleteDictCollection(
		long dictCollectionId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteDictCollection(dictCollectionId);
	}

	/**
	* @param dictCollectionId
	* @param serviceContext
	* @return
	* @throws Exception
	*/
	public static org.mobilink.backend.datamgt.model.DictCollection deleteDictCollection(
		long dictCollectionId,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws java.lang.Exception {
		return getService()
				   .deleteDictCollection(dictCollectionId, serviceContext);
	}

	/**
	* Deletes the dict collection from the database. Also notifies the appropriate model listeners.
	*
	* @param dictCollection the dict collection
	* @return the dict collection that was removed
	*/
	public static org.mobilink.backend.datamgt.model.DictCollection deleteDictCollection(
		org.mobilink.backend.datamgt.model.DictCollection dictCollection) {
		return getService().deleteDictCollection(dictCollection);
	}

	public static org.mobilink.backend.datamgt.model.DictCollection fetchByF_dictCollectionCode(
		java.lang.String collectionCode, long groupId) {
		return getService().fetchByF_dictCollectionCode(collectionCode, groupId);
	}

	public static org.mobilink.backend.datamgt.model.DictCollection fetchDictCollection(
		long dictCollectionId) {
		return getService().fetchDictCollection(dictCollectionId);
	}

	/**
	* Returns the dict collection matching the UUID and group.
	*
	* @param uuid the dict collection's UUID
	* @param groupId the primary key of the group
	* @return the matching dict collection, or <code>null</code> if a matching dict collection could not be found
	*/
	public static org.mobilink.backend.datamgt.model.DictCollection fetchDictCollectionByUuidAndGroupId(
		java.lang.String uuid, long groupId) {
		return getService().fetchDictCollectionByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns the dict collection with the primary key.
	*
	* @param dictCollectionId the primary key of the dict collection
	* @return the dict collection
	* @throws PortalException if a dict collection with the primary key could not be found
	*/
	public static org.mobilink.backend.datamgt.model.DictCollection getDictCollection(
		long dictCollectionId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getDictCollection(dictCollectionId);
	}

	/**
	* Returns the dict collection matching the UUID and group.
	*
	* @param uuid the dict collection's UUID
	* @param groupId the primary key of the group
	* @return the matching dict collection
	* @throws PortalException if a matching dict collection could not be found
	*/
	public static org.mobilink.backend.datamgt.model.DictCollection getDictCollectionByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getDictCollectionByUuidAndGroupId(uuid, groupId);
	}

	/**
	* @param userId
	* @param dictCollectionId
	* @param collectionCode
	* @param collectionName
	* @param description
	* @param serviceContext
	* @return
	* @throws Exception
	*/
	public static org.mobilink.backend.datamgt.model.DictCollection updateDictCollection(
		long userId, long dictCollectionId, java.lang.String collectionCode,
		java.lang.String collectionName, java.lang.String description,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws java.lang.Exception {
		return getService()
				   .updateDictCollection(userId, dictCollectionId,
			collectionCode, collectionName, description, serviceContext);
	}

	/**
	* Updates the dict collection in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param dictCollection the dict collection
	* @return the dict collection that was updated
	*/
	public static org.mobilink.backend.datamgt.model.DictCollection updateDictCollection(
		org.mobilink.backend.datamgt.model.DictCollection dictCollection) {
		return getService().updateDictCollection(dictCollection);
	}

	public static DictCollectionLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<DictCollectionLocalService, DictCollectionLocalService> _serviceTracker =
		ServiceTrackerFactory.open(DictCollectionLocalService.class);
}