<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/views/common/layouts/links.jsp"%>
<%@ include file="/WEB-INF/views/common/layouts/meta.jsp"%>
<title>后台管理系统</title>
</head>

<script type="text/javascript">
</script>
<body id="indexLayout" class="easyui-layout" >
	<div data-options="region:'north',split:true,href:'layoutController.do?top'" style="height:52px;overflow: hidden; background: url(${imagesBasePath}/logo_repeat.gif) repeat-x;"></div>
	<!-- <div data-options="region:'south',split:true,href:'layoutController.do?bottom'" style="height:20px;overflow: hidden;"></div> -->
	<div data-options="region:'west',split:true,href:'layoutController.do?left'" title="功能菜单" style="width:262px"></div>
	<div data-options="region:'center',split:true,href:'layoutController.do?center'" style=""></div> 
</body>
</html>

