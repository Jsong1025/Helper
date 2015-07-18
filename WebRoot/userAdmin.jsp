<%@ page language="java" import="java.util.*,vo.User" pageEncoding="utf-8"%>
<!DOCTYPE HTML>
<html>
 <head>
  <title>用户页面</title>
   <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
       <link href="../assets/css/dpl-min.css" rel="stylesheet" type="text/css" />
    <link href="../assets/css/bui-min.css" rel="stylesheet" type="text/css" />
    <link href="../assets/css/page-min.css" rel="stylesheet" type="text/css" />   <!-- 下面的样式，仅是为了显示代码，而不应该在项目中使用-->
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
   <div class="header">
    <%
   		ArrayList<User> users = (ArrayList<User>)request.getAttribute("users");
    %>
      <div class="dl-title">
        <a href="http://sc.chinaz.com" title="文档库地址" target="_blank">
        </a>
      </div>

    <div class="dl-log">欢迎您，<span class="dl-log-user"></span><a href="F:/项目文档/项目代码/html/网页/homepage2.html" title="退出系统" class="dl-log-quit">[退出]</a>
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
          <div class="control-group span8">
            <label class="control-label"><s>*</s>用户名</label>
            <div class="controls">
              <input name="UserName" type="text" data-rules="{required:true}" class="input-normal control-text">
            </div>
          </div>
          <div class="control-group span8">
            <label class="control-label"><s>*</s>用户密码</label>
            <div class="controls">
             <input name="UserPassword" type="text" data-rules="{required:true}" class="input-normal control-text">
            </div>
          </div>
        </div>
        <div class="row">
          <div class="control-group span15 ">
            <label class="control-label">真实姓名</label>
            <div class="controls">
              <input name="Name" type="text" class="input-large">
            </div>
          </div>
        </div>
		   <div class="row">
          <div class="control-group span15 ">
            <label class="control-label">性别</label>
            <div id="range" class="controls bui-form-group" data-rules="{dateRange : true}">
              <input name="UserSex" type="text" class="input-large">
            </div>
          </div>
        </div>
		  <div class="row">
          <div class="control-group span15 ">
            <label class="control-label">年龄</label>
            <div id="range" class="controls bui-form-group" data-rules="{dateRange : true}">
              <input name="UserAge" type="text" class="input-large">
            </div>
          </div>
        </div>
		 <div class="row">
          <div class="control-group span15 ">
            <label class="control-label">联系方式</label>
            <div id="range" class="controls bui-form-group" data-rules="{dateRange : true}">
              <input name="UserTel" type="text" class="input-large">
            </div>
          </div>
        </div>
		 <div class="row">
          <div class="control-group span15 ">
            <label class="control-label">QQ</label>
            <div id="range" class="controls bui-form-group" data-rules="{dateRange : true}">
              <input name="UserQQ" type="text" class="input-large">
            </div>
          </div>
        </div>
        <div class="row">
          <div class="control-group span15">
            <label class="control-label">邮箱</label>
            <div class="controls control-row4">
            <input name="UserEmail" type="text" class="input-large">
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

    var columns = [{title : '用户名',dataIndex :'UserName'},
            {title : '用户密码',dataIndex :'UserPassword'},
            {title : '真实姓名',dataIndex :'Name'},
			 {title : '性别',dataIndex :'UserSex'},
            {title : '年龄',dataIndex :'UserAge'},
			{title : '联系方式',dataIndex :'UserTel'},
			 {title : 'QQ',dataIndex :'UserQQ'},
			  {title : '邮箱',dataIndex :'UserEmail'},
            {title : '操作',renderer : function(){
              return '<span class="grid-command btn-edit">编辑</span>';
				  
            }}
          ],
      //默认的数据
      data = [
		<%
			for (int i = 0; i < users.size(); i++) {
		%>
        {
            id:'<%= users.get(i).getId() %>',
            UserName:'<%= users.get(i).getUsername() %>',
            UserPassword:'<%= users.get(i).getPassword() %>',
            Name: '<%= users.get(i).getName() %>',
            UserSex:'<%= users.get(i).getSex() %>',
            UserAge:'<%= users.get(i).getAge() %>',
            UserTel:'<%= users.get(i).getTel() %>',
            UserQQ:'<%= users.get(i).getQQ() %>',
            UserEmail:'<%= users.get(i).getEmail() %>'
         },
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
      var newData = {BusinessName :''};
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