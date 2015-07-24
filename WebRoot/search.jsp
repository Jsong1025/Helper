<%@ page language="java" import="java.util.*,vo.*" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
	<meta charset="utf-8">
    <title>搜索约会</title>
    <meta name="keywords" content="">
    <meta name="description" content="">

	<link rel="stylesheet" href="css/info.css" media="screen">
    <link rel="stylesheet" href="css/search.css" media="screen">
  </head>
  <body>

 <%
    	int permision = 5;
    	String username = "";
    	ArrayList<Appointment> appointments = (ArrayList<Appointment>)request.getAttribute("appointments");
    	if(session != null ){
    		// 获取用户名
    		if(session.getAttribute("username") != null){
        		username = (String)session.getAttribute("username");
        	} else if(session.getAttribute("email") != null){
        		username = (String)session.getAttribute("email");
        	} else {
        		response.sendRedirect("index.jsp");
        	}
    		
    		// 权限值
    		if(session.getAttribute("permision") != null){
    			permision = (Integer)session.getAttribute("permision");
        	}
    		
    	} else {
    		response.sendRedirect("index.jsp");
    	}
    %>

<div class="nav-top">
    <div class="container">
      <nav id="navbar" class="navbar navbar-default" role="navigation">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
            <span class="sr-only">导航菜单</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand text-hide" href="/" title="约会帮帮忙">约会帮帮忙</a>
        </div>
        <div class="collapse navbar-collapse navbar-ex1-collapse">
          <ul class="nav navbar-nav">
          		<li><a href="home.jsp" title=首页">首页</a></li>
              <li><a href="release.do" title="发布约会">发布约会</a></li>
              <li><a href="appointmentList.do" title="约会管理">约会管理</a></li>
              <li><a href="searchList.do" title="搜索约会">搜索约会</a></li>
              <li><a href="messageShow.do" title="消息管理">消息管理</a></li>
              <li><a href="info.do" title="个人资料">个人资料</a></li>
              <%
             	if(permision < 3){
             %>
              <li><a href="storeAdminList.do" title="前往 后台管理">后台管理</a></li>
              <% }%>
           
      
            </ul>
     
  <ul class="an" style="margin-top: 10px;">
</span>
</form>
</ul>
     
  <ul class="an"><!--搜索按钮--></li>
</form>


</ul>
<ul class="nav navbar-nav navbar-right">
			<li style="margin-top: 10px;"><%= username %></li>
              <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                  <span class="avatar avatar40 pull-left"><img class="img-circle img-responsive" src="img/img.jpg"></span><b class="caret"></b></a>
                <ul class="dropdown-menu clearfix">
                  
                  <li><a href="logout.do" title="退出登录">注销</a></li>
                </ul>
              </li>
          </ul>

          </div>

        </div>
      </nav>
    </div>
</div>

   <h2 float:left;="" margin-top:="" 0px;="" margin-left:400px;="" border-top-width:200px;="" border-left-width:20px;="" style="margin-left: 400px;margin-top: 40px;margin-bottom: 0px;">条件查找</h2>
 <div id="xuan" ;="" style="margin-left: 500px;">
 	<form action="searchList.do" method="get">
             性别：<select name="gender" style="border-top-width:1px; margin-top: 50px">
			  <option value="0">不限</option>
			  <option value="1">男</option>
			  <option value="2">女</option>
			  </select>
			  
              &nbsp;  &nbsp;  &nbsp; &nbsp;
             年龄：<select name="age" style="border-top-width:1px; margin-top: 50px">
			  <option value="0">不限</option>
			  <option value="1">19岁以下</option>
			  <option value="2">19-22岁</option>
              <option value="3">23-26岁</option>
			  <option value="4">27-35岁</option>
			  <option value="5">35岁以上</option>
			  </select>
		&nbsp;  &nbsp;  &nbsp; &nbsp;
			  约会内容:<select name="substance" style="border-top-width:1px; margin-top: 50px">
			  <option value="0">不限</option>
			  <option value="1">吃饭</option>
			  <option value="2">看电影</option>
              <option value="3">唱歌</option>
			  <option value="4">运动</option>
			  </select>
		&nbsp;  &nbsp;  &nbsp; &nbsp;
			   <button class="btn" onclick="window.location.href=''">搜索</button>
	</form>
</div>

  <div class="settingbar">
    <div class="container">
      <h1 class="mb40"><small class="pull-right"></small></h1>
        <div class="panel-group settingbar-panel mb120" id="accordion">
<%
	for(int i=0;i<appointments.size();i++){
%>
          <div class="panel panel-default" style="margin-left:15%;margin-right:15%;">
            <div class="panel-heading">
              <h4 class="panel-title clearfix">
                <a data-toggle="collapse" data-toggle="collapse" data-parent="#accordion" href="#collapse<%= i %>" >
                  <%= appointments.get(i).getTime() %>&nbsp;&nbsp;
                  <%= appointments.get(i).getGenderString() %>&nbsp;&nbsp;
                  <%= appointments.get(i).getSubstanceToString() %>&nbsp;&nbsp;
                  <%= appointments.get(i).getUser().getUsername() %>
				<span class="pull-right">展开<span class="glyphicon glyphicon-chevron-down"></span></span>
                </a>
                <div id="lab_name" class="panel-info"></div>
              </h4>
            </div>
            <div id="collapse<%= i %>" class="panel-collapse collapse">
              <div class="panel-body form-horizontal">
                  <div class="form-group">
                    <label for="" class="col-sm-2 control-label">约会时间</label>
                    <div class="col-sm-4">
                      <%= appointments.get(i).getTime() %>
                    </div>
                  </div>
                   <div class="form-group">
                    <label for="" class="col-sm-2 control-label">发起者</label>
                    <div class="col-sm-4">
                     <%= appointments.get(i).getUser().getUsername() %>
                    </div>
                  </div>
                    <div class="form-group">
                    <label for="" class="col-sm-2 control-label">约会内容</label>
                    <div class="col-sm-4">
                      <%= appointments.get(i).getSubstanceToString() %>
                    </div>
                  </div>
                  <div class="form-group">
                    <label for="" class="col-sm-2 control-label">类型</label>
                    <div class="col-sm-7">
                      <%= appointments.get(i).getGenderString() %>
                    </div>
                  </div>
                  <div class="form-group">
                    <label for="" class="col-sm-2 control-label">描述</label>
                    <div class="col-sm-4">
                     <%= appointments.get(i).getDescription() %>
                    </div>
                  </div>
                  
                   <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                      
                      	<button id="" type="button" class="btn btn-primary" onclick="window.location.href='appointmentResponse.do?id=<%= appointments.get(i).getId() %>'">确认约会</button>
                     
                    </div>
                  </div>
              </div>
            </div>
          </div>
          <%} %>
          
        </div>
    </div>
  </div>




    <!-- 尾部导航（PC端）-->
   <footer class="container clearfix   visible-md visible-lg" style="
    border-top-width: 200px;
    padding-top: 0px;
    margin-top: 0px;
">
      <div class="row">
		<div class="col-sm-12 text-muted text-center">
		</div>
        <div class="col-sm-12 text-muted text-center">
		<bottom>
            <a href="#" class="text-muted">关于我们</a>  ·  <a href="#" class="text-muted">联系我们</a>  ·  <a href="#" class="text-muted">加入我们</a>  ·  <a href="#" class="text-muted">服务协议</a>  ·  <a href="#" class="text-muted">帮助中心</a>  ·  <a href="#" class="text-muted">App</a>  ·  <a href="#" class="text-muted">订阅</a>
        </bottom>
		</div>
   
      </div>
    </footer>
 
	<script src="js/zhuye4.js"></script>
    <script src="js/zhuye2.js"></script>
    <script src="js/zhuye3.js"></script>
   
   
    
    
    
     
<script>
var _hmt = _hmt || [];
(function() {
  var hm = document.createElement("script");
  hm.src = "//hm.baidu.com/hm.js?fd99bd0a8c1c5b6fb9082a310736be80";
  var s = document.getElementsByTagName("script")[0]; 
  s.parentNode.insertBefore(hm, s);
})();
</script>
<script type="text/javascript">
mx_as_id =3003803;
mx_server_base_url ="mega.mlt01.com/";
</script>
<script type="text/javascript" src="js/zhuye1.js"></script>
    <script>
      $(function(){
        var btn =  $(".btn-load");
        btn.click(function(){
            btn.button('loading');
            setTimeout(function(){
                btn.button("reset");
            },1200);
        });
      });  
    </script>
    <!-- 回到顶部 -->
    <a id="scrollUp" href="#top" class="text-muted" title="回到顶部" style="position: fixed; z-index: 2147483647;">▲</a>
  </body>
</html>