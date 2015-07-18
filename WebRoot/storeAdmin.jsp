<%@ page language="java" import="java.util.*,vo.Store" pageEncoding="utf-8"%>
<!DOCTYPE HTML>
<html>
 <head>
  <title>商家信息
 </title>
   <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
       <link href="../assets/css/dpl-min.css" rel="stylesheet" type="text/css" />
    <link href="../assets/css/bui-min.css" rel="stylesheet" type="text/css" />
    <link href="../assets/css/page-min.css" rel="stylesheet" type="text/css" /> 
   <link href="../assets/css/prettify.css" rel="stylesheet" type="text/css" />
    <link href="assets/css/dpl-min.css" rel="stylesheet" type="text/css" />
  <link href="assets/css/bui-min.css" rel="stylesheet" type="text/css" />
   <link href="assets/css/main-min.css" rel="stylesheet" type="text/css" />
   <style type="text/css">
    code {
      padding: 0px 4px;
      color: #d14;
      background-color: #f7f7f9;
      border: 1px solid #e1e1e8;
    }
   </style>
   
   <%
   		ArrayList<Store> stores = (ArrayList<Store>)request.getAttribute("stores");
   %>
 </head>
 <body>
 <div class="header">
    
      <div class="dl-title">
        <a href="http://sc.chinaz.com" title="文档库地址" target="_blank">
        </a>
      </div>

    <div class="dl-log">欢迎您，<span class="dl-log-user">**.**@alibaba-inc.com</span><a href="F:/项目文档/项目代码/html/网页/homepage2.html" title="退出系统" class="dl-log-quit">[退出]</a>
    </div>
  </div>
   <div class="content">
    <div class="dl-main-nav">
      <div class="dl-inform"><div class="dl-inform-title">贴心小秘书<s class="dl-inform-icon dl-up"></s></div></div>
      <ul id="J_Nav"  class="nav-list ks-clear">
       <li class="nav-item dl-selected"><div class="nav-item-inner nav-home"><a href="default.html">首页</a></div></li>
       <li class="nav-item"><div class="nav-item-inner nav-order"><a href="storeAdminList.do">商家</a></div></li>
    <li class="nav-item"><div class="nav-item-inner nav-inventory"><a href="mealAdminList.do">产品</a></div></li>
      <li class="nav-item"><div class="nav-item-inner nav-marketing"><a href="appointmentAdminList.do">约会</a></div></li>
         <li class="nav-item"><div class="nav-item-inner nav-supplier"><a href="userAdminList.do">用户</a></div></li>
		 <li class="nav-item"><div class="nav-item-inner nav-inventory"><a href="roleAdminList.do">角色</a></div></li>
	 <li class="nav-item"><div class="nav-item-inner nav-marketing"><a href="#">统计</a></div></li>
      </ul>
    </div>
    <ul id="J_NavContent" class="dl-tab-conten">

    </ul>
   </div>
  <script type="text/javascript" src="assets/js/jquery-1.8.1.min.js"></script>
  <script type="text/javascript" src="./assets/js/bui.js"></script>
  <script type="text/javascript" src="./assets/js/config.js"></script>
</div>
  
  <div class="container">
    <div id="grid"></div>
	 <p>
	<a href="">上一页</a><a href="">下一页</a></br>
	</p>
	<p>
	
    <p>
      <button id="btnSave" class="button button-primary">提交</button>
    </p>
  
   
 
      
      </div>
    </div>
    <div id="content" class="hide">
      <form id="J_Form" class="form-horizontal">
        <div class="row">
          <div class="control-group span8">
            <label class="control-label"><s>*</s>商家名称</label>
            <div class="controls">
              <input name="BusinessName" type="text" data-rules="{required:true}" class="input-normal control-text">
            </div>
          </div>
          <div class="control-group span8">
            <label class="control-label"><s>*</s>商家地址</label>
            <div class="controls">
             <input name="BusinessAdress" type="text" data-rules="{required:true}" class="input-normal control-text">
            </div>
          </div>
        </div>
        <div class="row">
          <div class="control-group span15 ">
            <label class="control-label"><s>*</s>商家联系方式</label>
            <div id="range" class="controls bui-form-group" data-rules="{dateRange : true}">
              <input name="BusinessNumber" type="text" data-rules="{required:true}" class="input-normal control-text">
            </div>
          </div>
        </div>
		   <div class="row">
          <div class="control-group span15 ">
            <label class="control-label"><s>*</s>商家类型</label>
            <div id="range" class="controls bui-form-group" data-rules="{dateRange : true}">
              <input name="BusinessType" type="text" data-rules="{required:true}" class="input-normal control-text">
            </div>
          </div>
        </div>
        <div class="row">
          <div class="control-group span15">
            <label class="control-label">商家介绍</label>
            <div class="controls control-row4">
              <textarea name="BusinessIntorduce" class="input-large" type="text"></textarea>
            </div>
          </div>
        </div>
      </form>
    </div>
  </div>
  <script type="text/javascript" src="../assets/js/jquery-1.8.1.min.js"></script>
  <script type="text/javascript" src="../assets/js/bui-min.js"></script>

  <script type="text/javascript" src="../assets/js/config-min.js"></script>
  <script type="text/javascript">
    BUI.use('common/page');
  </script>

  <script type="text/javascript" src="../assets/js/prettify.js"></script>
  <script type="text/javascript">
    $(function () {
      prettyPrint();
    });
  </script> 
<script type="text/javascript">
  BUI.use(['bui/grid','bui/data'],function (Grid,Data) {

    var columns = [{title : '商家名称',dataIndex :'BusinessName'},
            {title : '商家地址',dataIndex :'BusinessAdress'},
            {title : '商家联系方式',dataIndex :'BusinessNumber'},
			 {title : '商家类型',dataIndex :'BusinessType'},
            {title : '商家介绍',dataIndex :'BusinessIntorduce',width:200},
            {title : '操作',renderer : function(){
              return '<span class="grid-command btn-edit">编辑</span>';
			  return '<span class="grid-command btn-edit">删除</span>';			  
            }}
          ],
      //默认的数据
      data = [
        <%
        	for (int i = 0; i < stores.size(); i++) {
        %>
        {id:'<%= stores.get(i).getId() %>',
         BusinessName:'<%= stores.get(i).getName() %>',
         BusinessAdress:'<%= stores.get(i).getAddress() %>',
         BusinessNumber: '<%= stores.get(i).getTel() %>',
         BusinessType:'<%= stores.get(i).getType() %>',
         BusinessIntorduce:'<%= stores.get(i).getIntroduce() %>'},
        <% } %>
      ],
      store = new Data.Store({
        data:data
      }),
      editing = new Grid.Plugins.DialogEditing({
        contentId : 'content',
        triggerCls : 'btn-edit'
      }),
      grid = new Grid.Grid({
        render : '#grid',
        columns : columns,
        width : 700,
        forceFit : true,
        store : store,
        plugins : [Grid.Plugins.CheckSelection,editing],
        tbar:{
          items : [{
            btnCls : 'button button-small',
            text : '<i class="icon-plus"></i>添加',
            listeners : {
              'click' : addFunction
            }
          },
          {
            btnCls : 'button button-small',
            text : '<i class="icon-remove"></i>删除',
            listeners : {
              'click' : delFunction
            }
          }]
        }

      });
    grid.render();

    function addFunction(){
      var newData = {BusinessName :'请输入商家名称'};
      editing.add(newData); //添加记录后，直接编辑
    }

    function delFunction(){
      var selections = grid.getSelection();
      store.remove(selections);
    }
    var logEl = $('#log');
    $('#btnSave').on('click',function(){

      var records = store.getResult();
      logEl.text(BUI.JSON.stringify(records));
    });
  });
</script>
<body>
</html> 