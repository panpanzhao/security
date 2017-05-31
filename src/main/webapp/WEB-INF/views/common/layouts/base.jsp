<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<c:set var="baseContextPath" value="${pageContext.request.scheme }://${pageContext.request.serverName }:${pageContext.request.serverPort }${pageContext.request.contextPath}" />
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<c:set var="cssBasePath" value="${baseContextPath }/styles" />
<c:set var="scriptBasePath" value="${baseContextPath }/scripts" />
<c:set var="imagesBasePath" value="${baseContextPath }/images" />
<c:set var="fileBasePath" value="${baseContextPath }/file" />
<c:set var="templateBasePath" value="${baseContextPath }/template" />

<c:set var="imagesServerPath" value="${pageContext.request.scheme }://${pageContext.request.serverName }" />
<c:set var="version" value="1.0" />
<%response.setHeader("Cache-Control","no-cache,no-strore");response.setHeader("Pragma","no-cache");response.setDateHeader("Expires",-1);%>