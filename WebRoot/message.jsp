<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
	<meta charset="utf-8">
    <title>消息管理</title>
    <meta name="keywords" content="">
    <meta name="description" content="">

	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">

	<link rel="stylesheet" href="css/info.css" media="screen">
    <link rel="stylesheet" href="css/message.css" media="screen">
  </head>
  <body>
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
              <li><a href="release.do" title="前往 发布约会">发布约会</a></li>
              <li><a href="appointmentList.do" title="前往 约会管理">约会管理</a></li>
              <li><a href="searchList.do" title="前往 搜索约会">搜索约会</a></li>
              <li><a href="messageShow.do" title="前往 消息管理">消息管理</a></li>
              <li><a class="visible-md visible-lg" href="info.do" title="前往 个人设置">个人设置</a></li>
              <li><a href="storeAdminList.do" title="前往 后台管理">后台管理</a></li>
			</ul>
			
  			<ul class="an" style="margin-top: 10px;"></ul>
			<ul class="nav navbar-nav navbar-right">
				<li style="margin-top: 10px;">
					<c:choose>
						<c:when test="${user.username != null}">${user.username}</c:when>
						<c:otherwise>${user.email}</c:otherwise>
					</c:choose>
				</li>
            	<li class="dropdown">
                	<a href="#" class="dropdown-toggle" data-toggle="dropdown">
                  		<span class="avatar avatar40 pull-left"><img class="img-circle img-responsive" src="${user.picture}"></span><b class="caret"></b></a>
                	<ul class="dropdown-menu clearfix">
                  		<li><a href="logout.do" title="退出登录">注销</a></li>
                	</ul>
              </li>
          </ul>
		</div>
    </div>
</div>

<div class="settingbar">
    <div class="container" style="margin-left: 250px">
      <h1 class="mb40"style="border-bottom-width: 0px;">消息管理<small class="pull-right"></small></h1><small class="pull-right"></small></h1>
    	<c:forEach var="message" items="messages">
	       <div class="panel panel-default panelbox" style="margin-right: 30%;margin-left: 10%;padding: 15px;">
              <div class="panel-body"  >
              		${message.message}
    	        	<button class="btn btn-primary" style="float: right;" onclick="window.location.href='messageDelete.do?id=${message.id}'">删除</button>
              </div>
	        </div>
    	</c:forEach>
      </div>
         
</div>  

    <footer class="container clearfix   visible-md visible-lg">
      <div class="row">
		<div class="col-sm-12 text-muted text-center">
           
        </div>
        <div class="col-sm-12 text-muted text-center">
            <a href="" class="text-muted">关于我们</a>  ·  <a href="" class="text-muted">联系我们</a>  ·  <a href="" class="text-muted">加入我们</a>  ·  <a href="" class="text-muted">服务协议</a>  ·  <a href="" class="text-muted">帮助中心</a>  ·  <a href="" class="text-muted">App</a>  ·  <a href=""   class="text-muted">订阅</a>
        </div>
   
      </div>
    </footer>
	<script src="js/zhuye4.js"></script>
    <script src="js/zhuye2.js"></script>
    <script src="js/zhuye3.js"></script>
   

<script type="text/javascript" src="js/zhuye.js" charset="UTF-8"></script>


    <!-- 回到顶部 -->
    <a id="scrollUp" href="#top" class="text-muted" title="回到顶部" style="position: fixed; z-index: 2147483647;">▲</a>
  </body>
</html>