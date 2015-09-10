<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
	<meta charset="utf-8">
    <title>约会管理</title>
    <meta name="keywords" content="">
    <meta name="description" content="">

	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">

	<link rel="stylesheet" href="css/info.css" media="screen">
    <link rel="stylesheet" href="css/info2.css" media="screen">
    <script  type="text/javascript">
    function submitForm1(){
    	var form1 = document.getElementById("info1");
    	form1.submit();
    }
    function submitForm2(){
    	var form2 = document.getElementById("info2");
    	form2.submit();
    }
    function submitForm3(){
    	var form3 = document.getElementById("info3");
    	form3.submit();
    }
    function submitForm4(){
    	var form4 = document.getElementById("info4");
    	form4.submit();
    }
    </script>
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
         
        </div>
        <div class="collapse navbar-collapse navbar-ex1-collapse">
          <ul class="nav navbar-nav">
          		<li><a href="home.jsp" title=首页">首页</a></li>
              <li><a href="release.do" title="发布约会">发布约会</a></li>
              <li><a href="appointmentList.do" title="约会管理">约会管理</a></li>
              <li><a href="searchList.do" title="搜索约会">搜索约会</a></li>
              <li><a href="messageShow.do" title="消息管理">消息管理</a></li>
              <li><a href="info.do" title="个人资料">个人资料</a></li>
              <li><a href="storeAdminList.do" title="前往 后台管理">后台管理</a></li>

            </ul>
          
          
          <ul class="nav navbar-nav navbar-right">
			<li style="margin-top: 10px;">
				<c:choose>
					<c:when test="${user.username != null}">${user.username}</c:when>
					<c:otherwise>${user.email}</c:otherwise>
				</c:choose>
			</li>
              <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                  <span class="avatar avatar40 pull-left"><img class="img-circle img-responsive" src="img/img.jpg"></span><b class="caret"></b></a>
                <ul class="dropdown-menu clearfix">
                  
                  <li><a href="logout.do" title="退出登录">注销</a></li>
                </ul>
              </li>
          </ul>
        </div>
      </nav>
    </div>
</div>

  <div class="settingbar">
    <div class="container">
      <h1 class="mb40">约会管理<small class="pull-right"></small></h1>
        <div class="panel-group settingbar-panel mb120" id="accordion">
        
        
        <c:forEach var="appointment" items="${appointments}">
          <div class="panel panel-default">
            <div class="panel-heading">
              <h4 class="panel-title clearfix">
                <a data-toggle="collapse" data-toggle="collapse" data-parent="#accordion" href="#collapse${appointment.id}" >
                 	 编号：${appointment.id}&nbsp;&nbsp;
                 	 时间：${appointment.time} &nbsp;&nbsp;
                 	内容： ${appointments.substance}                     
                   <span class="pull-right">展开<span class="glyphicon glyphicon-chevron-down"></span></span>
                </a>
                <div id="lab_name" class="panel-info"></div>
              </h4>
            </div>
            <div id="collapse${appointment.id}" class="panel-collapse collapse">
              <div class="panel-body form-horizontal">
                  <div class="form-group">
                    <label for="" class="col-sm-2 control-label">约会时间</label>
                    <div class="col-sm-4">
                      ${appointment.time}
                    </div>
                  </div>
                    <div class="form-group">
                    <label for="" class="col-sm-2 control-label">约会内容</label>
                    <div class="col-sm-4">
                      ${appointment.substance}
                    </div>
                  </div>
                  <div class="form-group">
                    <label for="" class="col-sm-2 control-label">类型</label>
                    <div class="col-sm-7">
                    	<c:choose>
                    		<c:when test="${appointment.gender == 1}">男女不限</c:when>
                    		<c:when test="${appointment.gender == 2}">只限男生</c:when>
                    		<c:otherwise>只限女生</c:otherwise>
                    	</c:choose>
                    </div>
                  </div>
                  <div class="form-group">
                    <label for="" class="col-sm-2 control-label">描述</label>
                    <div class="col-sm-4">
                     ${appointment.substance}
                    </div>
                  </div>
                  <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                      <button id="" type="button" class="btn btn-primary" onclick="window.location.href='appointmentCancel.do?id= ${appointment.id}'">取消约会</button>
                    </div>
                  </div>
              </div>
              <c:choose >
              	<c:when test="${appointment.responsers != null}">
              		<c:forEach var="respomser" items="${appointment.responsers}">
              			<div class="panel-body form-horizontal">
              				${responser.username}响应了您的约会申请
              				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
              				<button id="" type="button" class="btn" onclick="window.location.href='appointmentSubmit.do?id=${responser.id}'">确认与其约会</button>
              			</div>
              		</c:forEach>	
              	</c:when>
              </c:choose>
            </div>
          </div>

        </c:forEach>
          
        </div>
    </div>
  </div>
    <!-- 尾部导航 -->
    <footer class="container clearfix   visible-md visible-lg">
      <div class="row">
		<div class="col-sm-12 text-muted text-center">
           
        </div>
        <div class="col-sm-12 text-muted text-center">
            <a href="#" class="text-muted">关于我们</a>  ·  <a href="#" class="text-muted">联系我们</a>  ·  <a href="#" class="text-muted">加入我们</a>  ·  <a href="#" class="text-muted">服务协议</a>  ·  <a href="#" class="text-muted">帮助中心</a>  ·  <a href="#" class="text-muted">App</a>  ·  <a href="#"  class="text-muted">订阅</a>
        </div>
       
      </div>
    </footer>
    
	<script src="js/zhuye4.js"></script>
    <script src="js/zhuye3.js"></script>
    <script src="js/zhuye2.js"></script>
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
<script type="text/javascript" src="js/zhuye.js" charset="UTF-8"></script>
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