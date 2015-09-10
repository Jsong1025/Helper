<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
	<meta charset="utf-8">
    <title>个人设置</title>
    <meta name="keywords" content="">
    <meta name="description" content="">


<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
 
<!--[if lt IE 9]>
<script type="text/javascript">var duration=2900;var endTime = new Date().getTime() + duration + 100;function interval(){var n=(endTime-new Date().getTime())/1000;if(n<0) return;document.getElementById("timeout").innerHTML = n.toFixed(3);setTimeout(interval, 10);}window.onload=function(){setTimeout("window.location.href='/goodbyie/'", duration);interval();}</script>
<![endif]-->

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
              <li><a href="release.do" title="前往 发布约会">发布约会</a></li>
              <li><a href="appointmentList.do" title="前往 约会管理">约会管理</a></li>
              <li><a href="searchList.do" title="前往 搜索约会">搜索约会</a></li>
              <li><a href="messageShow.do" title="前往 消息管理">消息管理</a></li>
              <li><a class="visible-md visible-lg" href="info.do" title="前往 个人设置">个人设置</a></li>
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
                  <span class="avatar avatar40 pull-left"><img class="img-circle img-responsive" src="${user.picture}"></span><b class="caret"></b></a>
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
      <h1 class="mb40">个人设置<small class="pull-right"></small></h1>
        <div class="panel-group settingbar-panel mb120" id="accordion">
          <div class="panel panel-default">
            <div class="panel-heading">
              <h4 class="panel-title clearfix">
                <a data-toggle="collapse" data-toggle="collapse" data-parent="#accordion" href="#collapseOne" >
                                        个人资料<span class="pull-right">展开<span class="glyphicon glyphicon-chevron-down"></span></span>
                </a>
                <div id="lab_name" class="panel-info"></div>
              </h4>
            </div>
            <form id="info1" action="infoUpdate.do?type=1" method = "post">
            <div id="collapseOne" class="panel-collapse collapse">
              <div class="panel-body form-horizontal">
                  <div class="form-group">
                    <label for="" class="col-sm-2 control-label">真实姓名</label>
                    <div class="col-sm-4">
                      <input type="text" class="form-control" id="name" name="name" value="${user.name}">
                    </div>
                  </div>
                    <div class="form-group">
                    <label for="" class="col-sm-2 control-label">性别</label>
                    <div class="col-sm-4">
                    <c:choose>
                    	<c:when test="${user.sex == 'M'}">
                    		<input type=radio name=sex value='F' >女&nbsp &nbsp <input type=radio name=sex value='M' checked >男
                    	</c:when>
                    	<c:otherwise>
		                     <input type=radio name=sex value='F' checked >女&nbsp &nbsp <input type=radio name=sex value='M' >男
                    	</c:otherwise>
                    </c:choose>
                    </div>
                  </div>
                  <div class="form-group">
                    <label for="" class="col-sm-2 control-label">个人介绍</label>
                    <div class="col-sm-7">
                      <textarea class="form-control" rows="4" id="description" name="description">${user.description}</textarea>
                    </div>
                  </div>
                  <div class="form-group">
                    <label for="" class="col-sm-2 control-label">居住地</label>
                    <div class="col-sm-4">
                      <input type="text" class="form-control" placeholder="填写城市名称，多个以”,“隔开 "id="location"  name="location" value="${user.Location}">
                    </div>
                  </div>
                  <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                      <button id="btn_uinfo" type="submit" class="btn btn-primary" onclick="submitForm1()">保存</button>
                    </div>
                  </div>
              </div>
            </div>
            </form>
          </div>
          <div class="panel panel-default">
            <div class="panel-heading">
              <h4 class="panel-title">
                <a data-toggle="collapse" data-toggle="collapse" data-parent="#accordion" href="#collapseTwo">
                                        头像<span class="pull-right">展开<span class="glyphicon glyphicon-chevron-down"></span></span>
                </a>
              </h4>
              <div class="panel-info"><span class="avatar"><img id="head_s" src="${user.picture}" /></span></div>
            </div>
            <form id="info2" action="infoUpdate.do?type=2" method = "post">
            <div id="collapseTwo" class="panel-collapse collapse">
              <div class="panel-body form-horizontal">
                  <fieldset>
                    <div class="form-group">
                      <div class="col-sm-4 text-right">
                        <span class="avatar avatar150">
                          <img id="head_b" src="${user.picture}" class="img-circle img-responsive">
                        </span>
                      </div>
                      <div class="col-sm-8">
                        <button id="btn_head" class="btn btn-default btn-lg">选择头像</button>
                        <input id="f_head" type="file" style="display:none;" name="head"/>
                        <p class="help-block">支持 JPG、PNG、GIF 格式，不要超过 2M 。</p>
                      </div>
                    </div>
                    <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                      <button id="btn_mail" type="button" class="btn btn-primary"  onclick="submitForm2()">保存</button>
                    </div>
                  </div>
                  </fieldset>
              </div>
            </div>
            </form>
          </div>
          <div class="panel panel-default">
            <div class="panel-heading">
              <h4 class="panel-title">
                <a data-toggle="collapse" data-toggle="collapse" data-parent="#accordion" href="#collapseThree">
                                        用户名<span class="pull-right">展开<span class="glyphicon glyphicon-chevron-down"></span></span>
                </a>
              </h4>
              <div id="lab_mail" class="panel-info"></div>
            </div>
            <form id="info3" action="infoUpdate.do?type=3" method = "post">
            <div id="collapseThree" class="panel-collapse collapse">
              <div class="panel-body form-horizontal">
                  <div class="form-group">
                    <label for="" class="col-sm-2 control-label">当前用户名</label>
                    <div class="col-sm-4">
                      <p id="p_mail" class="form-control-static">${user.username}</p>
                    </div>
                  </div>
                  <div class="form-group">
                    <label for="" class="col-sm-2 control-label">新用户名</label>
                    <div class="col-sm-4">
                      <input type="text" class="form-control" id="mailNew" name="usernameNew">
                    </div>
                  </div>
                  <div class="form-group">
                  
                    <div class="col-sm-4">
                    
                    </div>
                  </div>
                  <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                      <button id="btn_mail" type="button" class="btn btn-primary"  onclick="submitForm3()">保存</button>
                    </div>
                  </div>
              </div>
            </div>
            </form>
          </div>
          <div class="panel panel-default">
            <div class="panel-heading">
              <h4 class="panel-title">
                <a data-toggle="collapse" data-toggle="collapse" data-parent="#accordion" href="#collapseFour">
                                        密码<span class="pull-right">展开<span class="glyphicon glyphicon-chevron-down"></span></span>
                </a>
              </h4>
              <div class="panel-info">******</div>
            </div>
            <form id="info4" action="infoUpdate.do?type=4" method = "post">
            <div id="collapseFour" class="panel-collapse collapse">
              <div class="panel-body form-horizontal">
                  <div class="form-group">
                    <label for="" class="col-sm-2 control-label">当前密码</label>
                    <div class="col-sm-4">
                      <input type="password" class="form-control" id="passwdOld">
                    </div>
                  </div>
                  <div class="form-group">
                    <label class="col-sm-2 control-label">新密码</label>
                    <div class="col-sm-4">
                      <input type="password" class="form-control" id="passwordNew">
                    </div>
                  </div>
                  <div class="form-group">
                    <label class="col-sm-2 control-label">确认新密码</label>
                    <div class="col-sm-4">
                      <input type="password" class="form-control" id="repasswdNew">
                    </div>
                  </div>
                  <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                      <button id="btn_passwd" type="button" class="btn btn-primary" onclick="submitForm4()">保存</button>
                    </div>
                  </div>
              </div>
            </div>
            </form>
          </div>
         
          
        </div>
    </div>
  </div>


 
    <!-- 尾部导航（PC端）-->
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
    
   

    <!-- 回到顶部 -->
    <a id="scrollUp" href="#top" class="text-muted" title="回到顶部" style="position: fixed; z-index: 2147483647;">▲</a>
  </body>
</html>