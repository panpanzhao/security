<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/layouts/base.jsp"%>
<div style="height:100%;background: url(${imagesBasePath}/logo.jpg) no-repeat">
	<div style="line-height:52px;float: right;white-space: nowrap;">
	当前用户：${curentUserName}&nbsp;&nbsp;<a href="${contextPath}/logout">退出</a>&nbsp;&nbsp;
	</div>
</div>