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

package com.atmc.bsl.db.service.impl;

import com.atmc.bsl.db.service.base.ContentEngineLocalServiceBaseImpl;
import com.liferay.journal.model.JournalArticle;
import com.liferay.journal.model.JournalArticleDisplay;
import com.liferay.journal.model.JournalFolder;
import com.liferay.journal.service.JournalArticleLocalServiceUtil;
import com.liferay.journal.service.JournalFolderLocalServiceUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.xml.Document;
import com.liferay.portal.kernel.xml.Node;
import com.liferay.portal.kernel.xml.SAXReaderUtil;
import org.osgi.service.component.annotations.Component;

import java.io.StringReader;
import java.util.*;

/**
 * The implementation of the content engine local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.atmc.bsl.db.service.ContentEngineLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ContentEngineLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.atmc.bsl.db.model.ContentEngine",
	service = AopService.class
)
public class ContentEngineLocalServiceImpl
	extends ContentEngineLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link
	 * com.ejada.atmc.bsl.db.service.ContentEngineLocalServiceUtil} to access
	 * the content engine local service.
	 */

	/**
	 * Get the latest 3 news in the news folder
	 * @param themeDisplay
	 * @return
	 */
	public List<String> getHomeNews(ThemeDisplay themeDisplay) {
		String content = StringPool.BLANK;
		Vector<Set<String>> returnLists = new Vector<Set<String>>();
		List<String> news = new ArrayList<String>();
		Set<String> ids = new HashSet<String>();
		// JournalArticle journalArticle;
		try {

			OrderByComparator<JournalArticle> comparator = new OrderByComparator<JournalArticle>() {

				@Override
				public int compare(JournalArticle arg0, JournalArticle arg1) {

					return arg1.getCreateDate().compareTo(arg0.getCreateDate());
				}
			};
			long folderId = getJournalFolderIdByName("News", themeDisplay.getScopeGroupId());
			// List<JournalArticle> articles =
			// JournalArticleLocalServiceUtil.getArticles(themeDisplay.getScopeGroupId(),
			// folderId, 1, 3, comparator);
			List<JournalArticle> articles = JournalArticleLocalServiceUtil.getArticles(themeDisplay.getScopeGroupId(),
					folderId);
			// the returned articles are unmodifiable
			ArrayList<JournalArticle> modArticles = new ArrayList<JournalArticle>(articles);
			modArticles.sort(comparator);

			int x=0;
			for (JournalArticle journalArticle : modArticles) {
				String articleId = journalArticle.getArticleId();
				// getting the templated (Display) Content
				try {
					JournalArticleDisplay articleDisplay = JournalArticleLocalServiceUtil.getArticleDisplay(
							themeDisplay.getScopeGroupId(), articleId, "", themeDisplay.getLanguageId(), themeDisplay);

					content = articleDisplay.getContent();

					if (ids.add(articleId)) {
						news.add(content);
						x++;
					}
					if (x==3 ) break;

				} catch (Exception e) {
					System.out.println("Skipping news " + articleId);
				}
			}

		} catch (

				ExceptionInInitializerError e) {

			e.printStackTrace();
		}

		return news;

	}

	/**
	 * Gets the vacancy title by articleID
	 *
	 * @return the vacancy title
	 */
	public String getVacanyTitleByArticleId(ThemeDisplay themeDisplay, String articleId) {
		String jobTitle = "";
		try {

			JournalArticle ja = JournalArticleLocalServiceUtil.getArticle(themeDisplay.getScopeGroupId(), articleId);

			jobTitle = getContentValueFomJA(ja, "Title", themeDisplay.getLanguageId());
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jobTitle;
	}

	/**
	 * Gets the templated content strings for the vacancies, they must be in the
	 * vacancies folder
	 *
	 * @param themeDisplay
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Vector<Set<String>> getVacancies(ThemeDisplay themeDisplay, String locationSearch, String departmentSearch) {

		String content = StringPool.BLANK;
		Vector<Set<String>> returnLists = new Vector<Set<String>>();
		Set<String> vacancies = new HashSet<String>();
		Set<String> ids = new HashSet<String>();
		Set<String> deps = new HashSet<String>();
		Set<String> locs = new HashSet<String>();

		if (locationSearch == null)
			locationSearch = "-1";
		if (departmentSearch == null)
			departmentSearch = "-1";
		// JournalArticle journalArticle;
		try {

			long folderId = getJournalFolderIdByName("vacancies", themeDisplay.getScopeGroupId());
			List<JournalArticle> articles = JournalArticleLocalServiceUtil.getArticles(themeDisplay.getScopeGroupId(),
					folderId);// (themeDisplay.getScopeGroupId(),articleName);

			System.out.println("search :" + locationSearch + departmentSearch);
			for (JournalArticle journalArticle : articles) {
				String articleId = journalArticle.getArticleId();

				// getting the templated (Display) Content
				try {
					JournalArticleDisplay articleDisplay = JournalArticleLocalServiceUtil.getArticleDisplay(
							themeDisplay.getScopeGroupId(), articleId, "", themeDisplay.getLanguageId(), themeDisplay);

					content = articleDisplay.getContent();
					if (ids.add(articleId)) {
						// getting the location and the departmnets
						String location = getContentValueFomJA(journalArticle, "Location",
								themeDisplay.getLanguageId());
						String department = getContentValueFomJA(journalArticle, "Department",
								themeDisplay.getLanguageId());

						locs.add(location);
						deps.add(department);

						if ((departmentSearch.equals("-1") || departmentSearch.equals(department))
								&& (locationSearch.equals("-1") || locationSearch.equals(location))) {
							vacancies.add(content);
							System.out.println("added");
						}

					}
				} catch (Exception e) {
					System.out.println("Skipping" + articleId);
				}
			}

		} catch (ExceptionInInitializerError e) {

			e.printStackTrace();
		}

		returnLists.add(vacancies);
		returnLists.add(locs);
		returnLists.add(deps);

		return returnLists;
	}

	/**
	 * Get the jounal folder ID from its name
	 *
	 * @param folderName
	 * @param groupId
	 * @return the folder Id
	 */
	private long getJournalFolderIdByName(String folderName, long groupId) {
		// JournalFolderLocalServiceUtil.getfoler
		List<JournalFolder> folders = JournalFolderLocalServiceUtil.getFolders(groupId);
		long folderId = 0;
		for (JournalFolder folder : folders) {
			if (folder.getName().equalsIgnoreCase(folderName))
				folderId = folder.getFolderId();
		}
		return folderId;
	}

	private String getContentValueFomJA(JournalArticle ja, String contentFieldName, String langId) {

		String contentXML = ja.getContentByLocale(langId);
		String contentFieldValue = null;
		// System.out.println("Content xml" + contentXML);

		Document document = null;
		try {
			document = SAXReaderUtil.read(new StringReader(contentXML));
			Node node = document
					.selectSingleNode("/root/dynamic-element[@name='" + contentFieldName + "']/dynamic-content");
			if (node.getText().length() > 0) {
				contentFieldValue = node.getText();
			}
		} catch (Exception e) {
			// e.printStackTrace();
			System.err.println("unable to get " + contentFieldName);
			return "";
		}
		return contentFieldValue;

	}
}