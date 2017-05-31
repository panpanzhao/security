<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/views/common/layouts/links.jsp"%>
<%@ include file="/WEB-INF/views/common/layouts/meta.jsp"%>
<title>后台管理系统</title>
</head>

<script type="text/javascript">
String.prototype.replaceAll = function (FindText, RepText) {
    regExp = new RegExp(FindText, "g");
    return this.replace(regExp, RepText);
}
function submitForm(){
	$("#login-form").form("submit",{
		success:function(data){
			var data = JSON.parse(data);
			if(data.success){
				var loginMsg=data.loginMsg;
				if(loginMsg!=null&&loginMsg.requestURI!=null){
					if(loginMsg.method=="GET"){
						window.location.href=loginMsg.requestURI+(loginMsg.queryString==null||loginMsg.queryString==""?"":"?"+loginMsg.queryString.replaceAll("&amp;","&"));
					}else{
						$("#resForm").attr("action",loginMsg.requestURI+(loginMsg.queryString==null||loginMsg.queryString==""?"":"?"+loginMsg.queryString.replaceAll("&amp;","&"))).submit();
					}
				}else{
					window.location.href="${contextPath}";
				}
				
			}else{
				$("#message").html(data.message);
			}
	    }
	});
}
function clearForm(){
	$('#login-form').form('clear');
}
</script>
<body>
	<form id="resForm" action="" method="post" style="display:none"></form>
	<div  class="easyui-dialog" title="登陆后台" data-options="buttons:'#btn',resizable:true,modal:true" style="width:350px;height:200px;padding-left:6px">
	<form id="login-form"  action="login" method="post">
		<div>  
		    <p>管理员账号：<input class="easyui-textbox" type="text" name="username" data-options="required:true"/></p>  
		    <p>管理员密码：<input class="easyui-textbox" type="password" name="password" data-options="required:true" /></p>
		    <p style="color: red;" id="message"></p>  
		</div>  
		<div id="btn">
		    <a  href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-ok'" onclick="submitForm()">登陆</a>  
		    <a  href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-clear'" onclick="clearForm()">重置</a>  
		</div>
	</form>
	</div>
</body>
</html>

