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
      <div class="dl-inform"><div class="dl-inform-title"><s class="dl-inform-icon dl-up"></s></div></div>
      <ul id="J_Nav"  class="nav-list ks-clear">
       <li class="nav-item dl-selected"><div class="nav-item-inner nav-home"><a href="index.html">首页</a></div></li>
       <li class="nav-item"><div class="nav-item-inner nav-order"><a href="dialog-grid.html">商家</a></div></li>
    <li class="nav-item"><div class="nav-item-inner nav-inventory"><a href="dialog-grid2.html">产品</a></div></li>
      <li class="nav-item"><div class="nav-item-inner nav-marketing"><a href="dialog-grid3.html">约会</a></div></li>
         <li class="nav-item"><div class="nav-item-inner nav-supplier"><a href="dialog-grid4.html">用户</a></div></li>
		 <li class="nav-item"><div class="nav-item-inner nav-inventory"><a href="dialog-grid5.html">角色</a></div></li>
	 <li class="nav-item"><div class="nav-item-inner nav-marketing"><a href="dialog-grid6.html">统计</a></div></li>
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
            <label class="control-label">开始时间</label>
            <div class="controls">
              <input name="StartTime" type="text" data-rules="{required:true}" class="input-normal control-text">
            </div>
          </div>
          <div class="control-group span8">
            <label class="control-label">结束时间</label>
            <div class="controls">
             <input name="EndTime" type="text" data-rules="{required:true}" class="input-normal control-text">
            </div>
          </div>
        </div>
		  <div class="row">
          <div class="control-group span8">
            <label class="control-label">取消标志</label>
            <div class="controls">
              <input name="CancelMark" type="text" data-rules="{required:true}" class="input-normal control-text">
            </div>
          </div>
          <div class="control-group span8">
            <label class="control-label">违约标志</label>
            <div class="controls">
             <input name="DefaultSign" type="text" data-rules="{required:true}" class="input-normal control-text">
            </div>
          </div>
        </div>
		 <div class="row">
          <div class="control-group span8">
            <label class="control-label">用户ID</label>
            <div class="controls">
              <input name="UserID" type="text" data-rules="{required:true}" class="input-normal control-text">
            </div>
          </div>
          <div class="control-group span8">
            <label class="control-label">目标用户ID</label>
            <div class="controls">
             <input name="TargetUserID" type="text" data-rules="{required:true}" class="input-normal control-text">
            </div>
          </div>
        </div>
          <div class="row">
          <div class="control-group span8">
            <label class="control-label">约会码</label>
            <div class="controls">
              <input name="DatingCode" type="text" data-rules="{required:true}" class="input-normal control-text">
            </div>
          </div>
          <div class="control-group span8">
            <label class="control-label">约会时间</label>
            <div class="controls">
             <input name="DatingTime" type="text" data-rules="{required:true}" class="input-normal control-text">
            </div>
          </div>
        </div>
		 <div class="row">
          <div class="control-group span8">
            <label class="control-label">约会类型</label>
            <div class="controls">
              <input name="DatingType" type="text" data-rules="{required:true}" class="input-normal control-text">
            </div>
          </div>
          <div class="control-group span8">
            <label class="control-label">约会内容</label>
            <div class="controls">
             <input name="DatingContent" type="text" data-rules="{required:true}" class="input-normal control-text">
            </div>
          </div>
        </div>

          <div class="row">
          <div class="control-group span8">
            <label class="control-label">约会描述</label>
            <div class="controls">
              <input name="DatingDescription" type="text" data-rules="{required:true}" class="input-normal control-text">
            </div>
          </div>
          <div class="control-group span8">
            <label class="control-label">套餐ID</label>
            <div class="controls">
             <input name="SetMeatID" type="text" data-rules="{required:true}" class="input-normal control-text">
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

    var columns = [{title : '开始时间',dataIndex :'StartTime',width:100},
            {title : '结束时间',dataIndex :'EndTime'},
            {title : '取消标志',dataIndex :'CancelMark'},
			 {title : '违约标志',dataIndex :'DefaultSign'},
            {title : '用户ID',dataIndex :'UserID'},
			{title : '目标用户ID',dataIndex :'TargetUserID'},
			{title : '约会码',dataIndex :'DatingCode'},
			{title : '约会时间',dataIndex :'DatingTime'},
			{title : '约会类型',dataIndex :'DatingType'},
			{title : '约会内容',dataIndex :'DatingContent'},
			{title : '约会描述',dataIndex :'DatingDescription'},
			{title : '套餐ID',dataIndex :'SetMeatID'},
            {title : '操作',renderer : function(){
              return '<span class="grid-command btn-edit">审核</span>';
					  
            }}
          ],

	  
	  
	  
	  //默认的数据
      data = [
        {id:'1',StartTime:'星巴克',EndTime:'河北大街',CancelMark: '123456789',DefaultSign:'咖啡',UserID:'小资生活',TargetUserID:'星巴克',DatingCode:'河北大街',DatingTime:'河北大街',DatingType: '123456789',DatingContent:'咖啡',DatingDescription:'小资生活',SetMeatID:'小资生活'},
        {id:'2',StartTime:'星巴克',EndTime:'河北大街',CancelMark: '123456789',DefaultSign:'咖啡',UserID:'小资生活',TargetUserID:'星巴克',DatingCode:'河北大街',DatingTime:'河北大街',DatingType: '123456789',DatingContent:'咖啡',DatingDescription:'小资生活',SetMeatID:'小资生活'}
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