<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/layouts/base.jsp"%>
<script type="text/javascript">
function clickMenu(src, title ,obj) {
	addTabFun({
		src: jsBaseContextPath+src,
		title: title
	});
}
</script>
<ul id="menuTree" class="easyui-tree" data-options="url:'${contextPath}/left/menu/tree',onClick: function(node){if(node.attributes!=null){clickMenu(node.attributes.url,node.text);}}"></ul>