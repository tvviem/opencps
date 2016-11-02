<%@page import="org.opencps.util.WebKeys"%>
<%@page import="com.liferay.portal.service.LayoutLocalServiceUtil"%>
<%@page import="com.liferay.portal.model.Layout"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="org.opencps.util.PortletPropsValues"%>
<%@page import="org.opencps.util.PortletUtil"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%
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
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
%>

<%@page import="com.liferay.portal.kernel.dao.search.SearchEntry"%>
<%@page import="com.liferay.portal.kernel.log.Log"%>
<%@page import="com.liferay.portal.kernel.log.LogFactoryUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="org.opencps.datamgt.model.DictItem"%>
<%@page import="org.opencps.datamgt.service.DictItemLocalServiceUtil"%>
<%@page import="org.opencps.dossiermgt.bean.ServiceBean"%>
<%@page import="org.opencps.dossiermgt.model.ServiceConfig"%>
<%@page import="org.opencps.dossiermgt.search.ServiceSearch"%>
<%@page import="org.opencps.dossiermgt.search.ServiceSearchTerms"%>
<%@page import="org.opencps.dossiermgt.service.ServiceConfigLocalServiceUtil"%>
<%@page import="org.opencps.servicemgt.model.ServiceInfo"%>
<%@page import="org.opencps.servicemgt.service.ServiceInfoLocalServiceUtil"%>
<%@page import="org.opencps.servicemgt.util.ServiceUtil"%>
<%@page import="org.opencps.util.PortletConstants"%>

<%@ include file="../init.jsp"%>

<%

	List<Layout> pubLayouts = LayoutLocalServiceUtil.getLayouts(scopeGroupId, false);
	
	List<DictItem> dictItems = PortletUtil.getDictItemInUseByCode(themeDisplay.getScopeGroupId(), 
		PortletPropsValues.DATAMGT_MASTERDATA_SERVICE_DOMAIN, 
		PortletConstants.TREE_VIEW_DEFAULT_ITEM_CODE);
%>

	
<aui:input name="dkm" value="33333333" type="text" label="222"></aui:input>
	
	
<div class="table-responsive">
  <table class="table">
    <tr>
    	<th>#</th>
    	<th><%=LanguageUtil.get(pageContext, "order_cfg") %></th>
    	<th><%=LanguageUtil.get(pageContext, "code_cfg") %></th>
    	<th><%=LanguageUtil.get(pageContext, "name_cfg") %></th>
    	<th><%=LanguageUtil.get(pageContext, "url_cfg") %></th>
    </tr>
    
    <%
    	int i=0;
    	for(DictItem dictItem: dictItems){
    		i++;
    		
    		int layout_cfg = GetterUtil.getInteger(portletPreferences.getValue(dictItem.getItemCode()+"_plid", ""));
    		boolean isShow_cfg = GetterUtil.getBoolean(portletPreferences.getValue(dictItem.getItemCode()+"_isShow", "false"));
    		int isShowOrder_cfg = GetterUtil.getInteger(portletPreferences.getValue(dictItem.getItemCode()+"_isShowOrder", "0"));
    %>
    <tr>
    	<td>
			<aui:input name="<%=dictItem.getItemCode()+\"_isShow\" %>" value="<%=isShow_cfg %>" checked="<%=isShow_cfg%>" type="checkbox" label=""></aui:input>
		</td>
		<td>
			<aui:input name="<%=dictItem.getItemCode()+\"_isShowOrder\" %>" value="<%=isShowOrder_cfg %>" type="text" label=""></aui:input>
		</td>
    	<td><%=HtmlUtil.escape(dictItem.getItemCode()) %></td>
    	<td><%=HtmlUtil.escape(dictItem.getItemName(locale)) %></td>
    	<td>
			<aui:select name="<%=dictItem.getItemCode()+\"_plid\" %>" id="<%=dictItem.getItemCode()+\"_plid\" %>" label="">
				<%
					for (Layout lout : pubLayouts) {
				%>
					<aui:option selected="<%= lout.getPlid() == layout_cfg %>" value="<%= lout.getPlid() %>"><%= lout.getName(locale) %></aui:option>
				<%
					}
				%>
			</aui:select>
			
		</td>
    </tr>
    <%} %>
  </table>
</div>
