/**
 * OpenCPS is the open source Core Public Services software
 * Copyright (C) 2016-present OpenCPS community
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Affero General Public License for more details.
 * You should have received a copy of the GNU Affero General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>
 */

package org.opencps.dashboard.portlet;

import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.opencps.datamgt.model.DictItem;
import org.opencps.util.PortletConstants;
import org.opencps.util.PortletPropsValues;
import org.opencps.util.PortletUtil;
import org.opencps.util.WebKeys;

import com.liferay.portal.kernel.portlet.ConfigurationAction;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.PortletPreferencesFactoryUtil;
import com.liferay.portlet.PortletURLFactoryUtil;


/**
 * @author khoavd
 *
 */
public class ConfigurationImpl implements ConfigurationAction{

	/* (non-Javadoc)
     * @see com.liferay.portal.kernel.portlet.ConfigurationAction#processAction(javax.portlet.PortletConfig, javax.portlet.ActionRequest, javax.portlet.ActionResponse)
     */
	@Override
	public void processAction(
	    PortletConfig portletConfig, ActionRequest actionRequest,
	    ActionResponse actionResponse)
	    throws Exception {

		String portletResource =
		    ParamUtil.getString(actionRequest, "portletResource");

		PortletPreferences preferences =
		    PortletPreferencesFactoryUtil.getPortletSetup(
		        actionRequest, portletResource);

		ThemeDisplay themeDisplay =
				(ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

		List<DictItem> dictItems = PortletUtil.getDictItemInUseByCode(themeDisplay.getScopeGroupId(), 
				PortletPropsValues.DATAMGT_MASTERDATA_SERVICE_DOMAIN, 
				PortletConstants.TREE_VIEW_DEFAULT_ITEM_CODE);
		String dkm = ParamUtil.getString(actionRequest, "dkm");
		String dkm2 = ParamUtil.getString(actionRequest, "dkm2");
		System.out.println("ConfigurationImpl.processAction()"+dkm);
		for (DictItem dictItem : dictItems) {
			long plid_cfg = ParamUtil.getLong(actionRequest, dictItem.getItemCode()+"_plid");
			boolean isShow_cfg = ParamUtil.getBoolean(actionRequest, dictItem.getItemCode()+"_isShow");
			long isShowOrder_cfg = ParamUtil.getLong(actionRequest, dictItem.getItemCode()+"_isShowOrder");
		
			preferences.setValue(dictItem.getItemCode()+"_plid", String.valueOf(plid_cfg));
			preferences.setValue(dictItem.getItemCode()+"_isShow", String.valueOf(isShow_cfg));
			preferences.setValue(dictItem.getItemCode()+"_isShowOrder", String.valueOf(isShowOrder_cfg));
		}
		
		preferences.store();

		SessionMessages.add(actionRequest, "potlet-config-saved");

	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.liferay.portal.kernel.portlet.ConfigurationAction#render(javax.portlet
	 * .PortletConfig, javax.portlet.RenderRequest,
	 * javax.portlet.RenderResponse)
	 */
	@Override
	public String render(
	    PortletConfig portletConfig, RenderRequest renderRequest,
	    RenderResponse renderResponse)
	    throws Exception {

		return "/html/portlets/dashboard/configuration.jsp";
	}

}
