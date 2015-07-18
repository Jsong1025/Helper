<%@ page language="java" import="java.util.*,vo.Meal" pageEncoding="utf-8"%>
<!DOCTYPE HTML>
<html>
 <head>
  <title>产品页面</title>
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
 </head>
 <body>
 
 	<%
   		ArrayList<Meal> meals = (ArrayList<Meal>)request.getAttribute("meals");
    %>
 
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
	
      <button id="btnSave" class="button button-primary">提交</button>
    </p>     
      </div>
    </div>
    <div id="content" class="hide">
      <form id="J_Form" class="form-horizontal">
        <div class="row">
          <div class="control-group span15 ">
            <label class="control-label"><s>*</s>套餐名称</label>
            <div id="range" class="controls bui-form-group" data-rules="{dateRange : true}">
              <input name="PackageStartTime" type="text" data-rules="{required:true}" class="input-normal control-text">
            </div>
          </div>
        </div>
        <div class="row">
          <div class="control-group span15 ">
            <label class="control-label"><s>*</s>套餐开始时间</label>
            <div id="range" class="controls bui-form-group" data-rules="{dateRange : true}">
              <input name="PackageStartTime" type="text" data-rules="{required:true}" class="input-normal control-text">
            </div>
          </div>
        </div>
		   <div class="row">
          <div class="control-group span15 ">
            <label class="control-label"><s>*</s>套餐结束时间</label>
            <div id="range" class="controls bui-form-group" data-rules="{dateRange : true}">
              <input name="PackageEndTime" type="text" data-rules="{required:true}" class="input-normal control-text">
            </div>
          </div>
        </div>
        <div class="row">
          <div class="control-group span15">
            <label class="control-label"><s>*</s>套餐提供数量</label>
            <div class="controls control-row4">
            <input name="PackageNum" type="text" data-rules="{required:true}" class="input-normal control-text">
            </div>
          </div>
        </div>
		  <div class="row">
          <div class="control-group span15 ">
            <label class="control-label">优惠</label>
            <div id="range" class="controls bui-form-group" data-rules="{dateRange : true}">
              <input name="PackagePreferemential" type="text" data-rules="{required:true}" class="input-normal control-text">
            </div>
          </div>
        </div>
		  <div class="row">
          <div class="control-group span15 ">
            <label class="control-label"><s>*</s>价格</label>
            <div id="range" class="controls bui-form-group" data-rules="{dateRange : true}">
              <input name="PackagePrice" type="text" data-rules="{required:true}" class="input-normal control-text">
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
  <!-- 仅仅为了显示代码使用，不要在项目中引入使用-->
  <script type="text/javascript" src="../assets/js/prettify.js"></script>
  <script type="text/javascript">
    $(function () {
      prettyPrint();
    });
  </script> 
<script type="text/javascript">
  BUI.use(['bui/grid','bui/data'],function (Grid,Data) {

    var columns = [{title : '套餐名称',dataIndex :'PackageName'},
            {title : '套餐开始时间',dataIndex :'PackageStartTime'},
            {title : '套餐结束时间',dataIndex :'PackageEndTime'},
			 {title : '套餐提供数量',dataIndex :'PackageNum'},
            {title : '优惠',dataIndex :'PackagePreferemential'},
			{title : '价格',dataIndex :'PackagePrice'},
            {title : '操作',renderer : function(){
              return '<span class="grid-command btn-edit">编辑</span>';
			  
            }}
          ],
      //默认的数据
      data = [
		<%
			for (int i = 0; i < meals.size(); i++) {
		%>
        {
            id:'<%= meals.get(i).getId() %>',
            PackageName:'<%= meals.get(i).getName() %>',
            PackageStartTime:'<%= meals.get(i).getStartTime() %>',
            PackageEndTime: '<%= meals.get(i).getEndTime() %>',
            PackageNum:'<%= meals.get(i).getNum() %>',
            PackagePreferemential:'<%= meals.get(i).getPriferemential() %>',
            PackagePrice:'<%= meals.get(i).getPrice() %>'},
        <%
			}
        %>
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
      var newData = {BusinessName :'请输入套餐名称'};
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