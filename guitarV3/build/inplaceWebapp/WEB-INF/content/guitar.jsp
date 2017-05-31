<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%><!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>guitar</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/icon.css">
	<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery.easyui.min.js"></script>
<script>
//全局变量
var builder=null;
var model=null;
var type=null;
var backWood=null;
var topWood=null;
var numStrings=0;
$(document).ready(function () {
	//添加保存
	save = function (){
		$.messager.confirm('对话框', '确定添加', function(r){
			if(r){
				$('#frmEdit').form('submit',{
					url:'${pageContext.request.contextPath}/add',
					onSubmit: function(){
						return $(this).form('validate');
					},
					success: function(){
						$('#a').window('close');		// close the dialog  关闭小窗口
						$('#dg').datagrid('reload');	// reload the user data  刷新数据显示	
					}
				})
			}	
		})
	}
	$('#dg').datagrid({       
		pageNumber: 1,
	    url: "${pageContext.request.contextPath}/guitarSearch",
	    rownumbers:true,
	    fitColumns:true,
	    singleSelect:true,
	    height:650,
	    toolbar:[
		 			{
	      				id:'delete',
	      				iconCls:'icon-remove',
	      				text:'删除',
	      				handler:function(){
	      					var row=$("#dg").datagrid("getSelected");
	      					if(row){						
		      					$.messager.confirm('对话框', '确定删除', function(r){
		      						if (r){
		      							$.ajax({
		      								url:'${pageContext.request.contextPath}/del',
		      								method:'POST',
		      								dataType:'json',
		      								data:{'serialNumber':row.serialNumber},
		      								success:function(data){
		    									if(data.status=="ok"){
		    										$.messager.alert('提示','删除成功','info');
		    										$("#dg").datagrid("reload");						
		    									}else{
		    										$.messager.alert('提示','删除失败','error');
		    									}
		    								}
		      							})
		      						}
		      					})
	      					}
	      				} 
					},{
						text:'添加',
						id:'add', 
						iconCls: 'icon-add',
						handler:function(){
							$("#a").window('open');
						},
					}, {
						text:'builder:<input id="builderInput" name="builderhidden">'	
			 		},	
					{
						text:'type：<input id="typeInput" name="typehidden">'
					},
					{
						text:'backwood：<input id="backWoodInput" name="backWoodhidden">'
					},
					{
						text:'topwood：<input id="topWoodInput" name="topWoodhidden">'
					}
	 			],
	    columns:[[  
	              {field:'serialNumber',title:'编号',width:100} ,
	              {field:'price',title:'价格',width:100}, 
	              {field:'builder',title:'制作者',width:100},
	              {field:'model',title:'模型',width:100},
	              {field:'type',title:'类型',width:100},
	              {field:'backWood',title:'材料',width:100},
	              {field:'topWood',title:'材料',width:100}
	           
	    ]]
	});
	
	$('#a').window({
		height:300,
		width:400,
		modal:true,
		minimizable:true,
		maximizable	:true,
		closable:true,
		closed:true,
		modal:false,
		draggable:true,
		title:'编辑'	
	}); 


    $('#builderInput').combobox({    
        url:'${pageContext.request.contextPath}/json/builder.json',    
        valueField:'id',    
        textField:'text',
        onSelect: function(){
        	builder=$('#builderInput').combobox('getValue');
        	query();
		}
    });
    $('#typeInput').combobox({    
        url:'${pageContext.request.contextPath}/json/type.json',    
        valueField:'id',    
        textField:'text',
        onSelect: function(){
        	type=$('#typeInput').combobox('getValue');
        	query();
		}
    });
    $('#backWoodInput').combobox({    
        url:'${pageContext.request.contextPath}/json/wood.json',    
        valueField:'id',    
        textField:'text',
        onSelect: function(){
        	backWood=$('#backWoodInput').combobox('getValue');
        	query();
		}
    });
    $('#topWoodInput').combobox({    
        url:'${pageContext.request.contextPath}/json/wood.json',    
        valueField:'id',    
        textField:'text',
        onSelect: function(){
        	topWood=$('#topWoodInput').combobox('getValue');
        	query();
		}
    });
   
	//查询函数
	function query(){
		$('#dg').datagrid('options').url='${pageContext.request.contextPath}/guitarSearch';
		$('#dg').datagrid('load',{
			builder:builder,
			type:type,
			backWood:backWood,
			model:"model1",
			topWood:topWood
		});
	}
	
})
</script>
</head>
<body>
	<input id="builderhidden" type="hidden" />
	<input id="typehidden" type="hidden" />
	<input id="backWoodhidden" type="hidden" />
	<input id="topWoodhidden" type="hidden" />
	<input id="numStringshidden" type="hidden" />
	<table id="dg"></table>
	
	<div id="a" display="none">
		<form method="post" id="frmEdit">
			<label style="bargin-top:20px;bargin-left:20px;bargin-right:20px;">serialNumber：</label>
			<input type="text" name="serialNumber" id="serialNumber"/>
			<br/>
			<label style="bargin-top:20px;bargin-left:20px;bargin-right:20px;">price：</label>
			<input type="text" name="price" id=="price"/>
			<br/>
			<label style="bargin-top:20px;bargin-left:20px;bargin-right:20px;">builder：</label>
			<input type="text" name="builder" id=="builder"/>
			<br/>
			<label style="bargin-top:20px;bargin-left:20px;bargin-right:20px;">model：</label>
			<input type="text" name="model" id=="builder"/>
			<br/>
			<label style="bargin-top:20px;bargin-left:20px;bargin-right:20px;">type：</label>
			<input type="text" name="type" id=="type"/>
			<br/>
			<label style="bargin-top:20px;bargin-left:20px;bargin-right:20px;">backwood：</label>
			<input type="text" name="backWood" id="backWood"/>
			<br/>
			<label style="bargin-top:20px;bargin-left:20px;bargin-right:20px;">topwood：</label>
			<input type="text" name="topWood" id="topWood"/>
			<br/>
			<label style="bargin-top:20px;bargin-left:20px;bargin-right:20px;">numStrings：</label>
			<input type="text" name="numStrings" id="numStrings"/>
			<br/>
		</form>
		<form method="post" >
			<a href="javascript:void(0)" icon="icon-ok" class="easyui-linkbutton" onclick="save();">保存</a>
    		<a id="btnCancel" icon="icon-cancel" class="easyui-linkbutton" href="javascript:void(0)">取消</a> 
    	</form>
	</div>
</body>
</html>