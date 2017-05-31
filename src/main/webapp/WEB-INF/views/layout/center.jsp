<%@ page language="java" pageEncoding="UTF-8"%>
<div id="centerTabs" class="easyui-tabs" data-options="fit:true,border:false"></div>
<div id="tab-tools" style="border:0;">
	<a onclick="more()" style="height:100%;display:block;cursor: pointer;" class="icon-more"  >&nbsp;&nbsp;&nbsp;</a>
</div>
<div id="menu" class="easyui-menu" style="width:120px;">
    <div onclick="closeother()"  data-options="iconCls:'icon-cancel'">关闭其它</div>
    <div onclick="closeall()"  data-options="iconCls:'icon-cancel'">关闭全部</div>
</div>
<script type="text/javascript" charset="UTF-8">
	var centerTabs=$("#centerTabs");
		centerTabs.tabs({
			tools:"#tab-tools"
		});
	function addTabFun(opts) {
		var name = "";
		var src_name = opts.src.split("/")[1];
		if(typeof(src_name) != 'undefined'){
			name = src_name;
		}
		var options = $.extend({
			title: '',
			content: '<iframe name="' + name + '" src="' + opts.src + '" frameborder="0" style="border:0;width:100%;height:99.5%;"></iframe>',
			closable: true,
			iconCls: ''
		}, opts);
		if (centerTabs.tabs('exists', options.title)) {
			centerTabs.tabs('close', options.title);
		}
		centerTabs.tabs('add', options);
	};
	
	function closeall() {
		$(".tabs li").each(function(i, n) {
			var title = $(n).text();
			$('#centerTabs').tabs('close', title);
		});
	};
	function closeother() {
		var currTab = $('#centerTabs').tabs('getSelected');
		if (currTab) {
			var currTitle = currTab.panel('options').title;
			$(".tabs li").each(function(i, n) {
				var title = $(n).text();
				if (currTitle != title) {
					$('#centerTabs').tabs('close', title);
				}
			});
		}
	};
	//菜单处理
	$('#menu').menu({
	    onClick:function(item){
	    }
	});
	function more(){
		$('#menu').menu('show', {
		    left: '100',
		    top: 52
		});
	}
</script>