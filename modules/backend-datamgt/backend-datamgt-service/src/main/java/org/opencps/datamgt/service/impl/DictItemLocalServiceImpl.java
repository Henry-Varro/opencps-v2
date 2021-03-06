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

package org.opencps.datamgt.service.impl;

import java.util.Date;
import java.util.LinkedHashMap;

import org.opencps.datamgt.constants.DictItemTerm;
import org.opencps.datamgt.exception.NoSuchDictItemException;
import org.opencps.datamgt.model.DictItem;
import org.opencps.datamgt.service.DictCollectionLocalServiceUtil;
import org.opencps.datamgt.service.base.DictItemLocalServiceBaseImpl;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.search.BooleanClauseOccur;
import com.liferay.portal.kernel.search.BooleanQuery;
import com.liferay.portal.kernel.search.BooleanQueryFactoryUtil;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.search.IndexSearcherHelperUtil;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.search.ParseException;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.TermQuery;
import com.liferay.portal.kernel.search.generic.MatchQuery.Operator;
import com.liferay.portal.kernel.search.generic.MultiMatchQuery;
import com.liferay.portal.kernel.search.generic.TermQueryImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;

import aQute.bnd.annotation.ProviderType;

/**
 * The implementation of the dict item local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link org.opencps.datamgt.service.DictItemLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Binhth
 * @see DictItemLocalServiceBaseImpl
 * @see org.opencps.datamgt.service.DictItemLocalServiceUtil
 */
@ProviderType
public class DictItemLocalServiceImpl extends DictItemLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link
	 * org.mobilink.backend.datamgt.service.DictItemLocalServiceUtil} to access
	 * the dict item local service.
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public DictItem addDictItem(long userId, long groupId, long dictCollectionId, String itemCode, String itemName,
			String itemNameEN, String itemDescription, long parentItemId, String sibling, int level, String dataForm,
			ServiceContext serviceContext) throws Exception {

		// TODO

		Date now = new Date();

		User user = userPersistence.findByPrimaryKey(userId);

		long dictItemId = counterLocalService.increment(DictItem.class.getName());

		DictItem dictItem = dictItemPersistence.create(dictItemId);

		String treeIndex = getTreeIndex(dictItemId, parentItemId, sibling);

		// Group instance
		dictItem.setGroupId(groupId);

		// Audit fields
		dictItem.setUuid(serviceContext.getUuid());
		dictItem.setCompanyId(user.getCompanyId());
		dictItem.setUserId(user.getUserId());
		dictItem.setUserName(user.getFullName());
		dictItem.setCreateDate(serviceContext.getCreateDate(now));
		dictItem.setModifiedDate(serviceContext.getCreateDate(now));

		// Other fields
		dictItem.setDictCollectionId(dictCollectionId);
		itemCode = itemCode.toUpperCase();
		dictItem.setItemCode(itemCode);
		dictItem.setItemName(itemName);
		dictItem.setItemNameEN(itemNameEN);
		dictItem.setItemDescription(itemDescription);
		dictItem.setParentItemId(parentItemId);
		dictItem.setSibling(sibling);
		dictItem.setTreeIndex(treeIndex);
		dictItem.setLevel(level);
		dictItem.setDataForm(dataForm);

		// referent dictcollection
		BaseModel<?> baseModel = DictCollectionLocalServiceUtil.fetchDictCollection(dictCollectionId);

		dictItem.setExpandoBridgeAttributes(baseModel);

		dictItemPersistence.update(dictItem);

		return dictItem;
	}

	/**
	 * @param dictCollectionId
	 * @param serviceContext
	 * @return
	 * @throws Exception
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public DictItem deleteDictItem(long dictItemId, ServiceContext serviceContext) throws Exception {

		// TODO
		DictItem dictItem = dictItemPersistence.remove(dictItemId);

		return dictItem;
	}

	/**
	 * @param userId
	 * @param dictCollectionId
	 * @param fullName
	 * @param companyName
	 * @param telNo
	 * @param email
	 * @param mobilinkId
	 * @param userMappingId
	 * @param outSide
	 * @param isOrg
	 * @param serviceContext
	 * @return
	 * @throws Exception
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public DictItem updateDictItem(long userId, long dictItemId, long dictCollectionId, String itemCode,
			String itemName, String itemNameEN, String itemDescription, long parentItemId, String sibling, int level,
			String dataForm, ServiceContext serviceContext) throws Exception {

		// TODO

		Date now = new Date();

		User user = userPersistence.findByPrimaryKey(userId);

		DictItem dictItem = dictItemPersistence.fetchByPrimaryKey(dictItemId);

		// Audit fields
		dictItem.setUserId(user.getUserId());
		dictItem.setUserName(user.getFullName());
		dictItem.setModifiedDate(serviceContext.getCreateDate(now));

		// Other fields
		dictItem.setDictCollectionId(dictCollectionId);
		dictItem.setItemCode(itemCode);
		dictItem.setItemName(itemName);
		dictItem.setItemNameEN(itemNameEN);
		dictItem.setItemDescription(itemDescription);
		dictItem.setParentItemId(parentItemId);
		dictItem.setSibling(sibling);
		dictItem.setLevel(level);
		dictItem.setDataForm(dataForm);

		String treeIndex = getTreeIndex(dictItemId, parentItemId, sibling);

		dictItem.setTreeIndex(treeIndex);

		// referent dictcollection
		BaseModel<?> baseModel = DictCollectionLocalServiceUtil.fetchDictCollection(dictCollectionId);

		dictItem.setExpandoBridgeAttributes(baseModel);
		// dictItem.setExpandoBridgeAttributes(serviceContext);

		dictItemPersistence.update(dictItem);

		return dictItem;
	}

	protected String getTreeIndex(long dictItemId, long dictParentItemId, String sibling)
			throws NoSuchDictItemException, SystemException {

		if (dictParentItemId == 0) {
			return sibling;
		} else if (dictParentItemId > 0) {
			DictItem parentItem = dictItemPersistence.findByPrimaryKey(dictParentItemId);

			String ext = "";

			for (int i = 1; i < sibling.length(); i++) {
				ext += "_";
			}

			return parentItem.getSibling() + StringPool.PERIOD + ext + sibling;
		} else {
			throw new NoSuchDictItemException();
		}
	}

	public Hits luceneSearchEngine(LinkedHashMap<String, Object> params, Sort[] sorts, int start, int end,
			SearchContext searchContext) throws ParseException, SearchException {
		// TODO Auto-generated method stub

		Indexer<DictItem> indexer = IndexerRegistryUtil.nullSafeGetIndexer(DictItem.class);

		searchContext.addFullQueryEntryClassName(DictItem.class.getName());
		searchContext.setEntryClassNames(new String[] { DictItem.class.getName() });
		searchContext.setAttribute("paginationType", "regular");
		searchContext.setLike(true);
		searchContext.setStart(start);
		searchContext.setEnd(end);
		searchContext.setAndSearch(true);
		searchContext.setSorts(sorts);

		// params.put(DictCollectionTerm.COLLECTION_CODE, keywords);
		// params.put("expandoAttributes", keywords);

		searchContext.setAttribute("params", params);

		// LAY CAC THAM SO TRONG PARAMS.
		String dictCollectionId = (String) params.get(DictItemTerm.DICT_COLLECTION_ID);
		String dictItemParentId = (String) params.get(DictItemTerm.PARENT_ITEM_ID);
		String dictItemCode = (String) params.get(DictItemTerm.ITEM_CODE);
		String keywords = (String) params.get("keywords");
		String groupId = (String) params.get("groupId");
		String userId = (String) params.get("userId");
		String itemLv = (String) params.get("itemLv");
		String dictCollectionCode = (String) params.get(DictItemTerm.DICT_COLLECTION_CODE);

		BooleanQuery booleanQuery = null;

		if (Validator.isNotNull(keywords)) {
			booleanQuery = BooleanQueryFactoryUtil.create(searchContext);
		} else {
			booleanQuery = indexer.getFullQuery(searchContext);
		}

		if (Validator.isNotNull(keywords)) {
			String[] keyword = keywords.split(StringPool.SPACE);
			for (String string : keyword) {

				MultiMatchQuery query = new MultiMatchQuery(string);

				query.addFields(DictItemTerm.ITEM_NAME, DictItemTerm.ITEM_NAME_EN, DictItemTerm.ITEM_CODE);

				Operator operator = Operator.OR;

				query.setOperator(operator);

				booleanQuery.add(query, BooleanClauseOccur.MUST);

			}
		}

		// DUNG BO SUNG.
		if (Validator.isNotNull(dictCollectionId)) {
			MultiMatchQuery query = new MultiMatchQuery(dictCollectionId);

			query.addFields(DictItemTerm.DICT_COLLECTION_ID);

			booleanQuery.add(query, BooleanClauseOccur.MUST);
		}
		
		if (Validator.isNotNull(dictItemParentId)) {
			MultiMatchQuery query = new MultiMatchQuery(dictItemParentId);

			query.addFields(DictItemTerm.PARENT_ITEM_ID);

			booleanQuery.add(query, BooleanClauseOccur.MUST);
		}

		if (Validator.isNotNull(itemLv)) {
			MultiMatchQuery query = new MultiMatchQuery(String.valueOf(0));

			query.addFields(DictItemTerm.PARENT_ITEM_ID);

			booleanQuery.add(query, BooleanClauseOccur.MUST_NOT);

		}

		if (Validator.isNotNull(dictItemCode)) {
			MultiMatchQuery query = new MultiMatchQuery(dictItemCode);

			query.addFields(DictItemTerm.ITEM_CODE);

			booleanQuery.add(query, BooleanClauseOccur.MUST);
		}

		if (Validator.isNotNull(groupId)) {
			BooleanQuery categoryQuery = Validator.isNotNull((String) keywords)
					? BooleanQueryFactoryUtil.create((SearchContext) searchContext)
					: indexer.getFullQuery(searchContext);
			TermQuery catQuery1 = new TermQueryImpl(DictItemTerm.GROUP_ID, groupId);
			TermQuery catQuery2 = new TermQueryImpl(DictItemTerm.GROUP_ID, String.valueOf(0));

			categoryQuery.add(catQuery1, BooleanClauseOccur.SHOULD);
			categoryQuery.add(catQuery2, BooleanClauseOccur.SHOULD);
			booleanQuery.add(categoryQuery, BooleanClauseOccur.MUST);
		}

		if (Validator.isNotNull(userId)) {
			MultiMatchQuery query = new MultiMatchQuery(userId);

			query.addFields(DictItemTerm.USER_ID);

			booleanQuery.add(query, BooleanClauseOccur.MUST);
		}

		if (Validator.isNotNull(dictCollectionCode)) {
			MultiMatchQuery query = new MultiMatchQuery(dictCollectionCode);

			query.addFields(DictItemTerm.DICT_COLLECTION_CODE);

			booleanQuery.add(query, BooleanClauseOccur.MUST);
		}

		booleanQuery.addRequiredTerm(Field.ENTRY_CLASS_NAME, DictItem.class.getName());

		return IndexSearcherHelperUtil.search(searchContext, booleanQuery);

	}

	private static final Log _log = LogFactoryUtil.getLog(DictItemLocalServiceImpl.class);
}