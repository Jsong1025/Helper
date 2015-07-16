<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
  </head>
  <body>

 <%
    	int permision = 5;
    	String username = "";
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
         
        </div>
        <div class="collapse navbar-collapse navbar-ex1-collapse">
          <ul class="nav navbar-nav">
              <li><a href="/collection/10000/" title="发布约会">发布约会</a></li>
              <li><a href="/collection/10001/" title="搜索约会">搜索约会</a></li>
              <li><a href="/collection/10002/" title="消息管理">消息管理</a></li>
              <li><a href="/collection/10002/" title="个人资料">个人资料</a></li>
              <%
             	if(permision < 3){
             %>
              <li><a href="#" title="前往 后台管理">后台管理</a></li>
              <% }%>
           
      
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
            <div id="collapseOne" class="panel-collapse collapse">
              <div class="panel-body form-horizontal">
                  <div class="form-group">
                    <label for="" class="col-sm-2 control-label">真实姓名</label>
                    <div class="col-sm-4">
                      <input type="text" class="form-control" id="name" name="name" value=" ">
                    </div>
                  </div>
                    <div class="form-group">
                    <label for="" class="col-sm-2 control-label">性别</label>
                    <div class="col-sm-4">
                      <input type=radio name=sex value=female >女&nbsp &nbsp <input type=radio name=sex value=male >男
                    </div>
                  </div>
                  <div class="form-group">
                    <label for="" class="col-sm-2 control-label">个人介绍</label>
                    <div class="col-sm-7">
                      <textarea class="form-control" rows="4" id="description" name="description"></textarea>
                    </div>
                  </div>
                  <div class="form-group">
                    <label for="" class="col-sm-2 control-label">居住地</label>
                    <div class="col-sm-4">
                      <input type="text" class="form-control" placeholder="填写城市名称，多个以”,“隔开 "id="location"  name="location" value="">
                    </div>
                  </div>
                  <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                      <button id="btn_uinfo" type="submit" class="btn btn-primary">保存</button>
                    </div>
                  </div>
              </div>
            </div>
          </div>
          <div class="panel panel-default">
            <div class="panel-heading">
              <h4 class="panel-title">
                <a data-toggle="collapse" data-toggle="collapse" data-parent="#accordion" href="#collapseTwo">
                                        头像<span class="pull-right">展开<span class="glyphicon glyphicon-chevron-down"></span></span>
                </a>
              </h4>
              <div class="panel-info"><span class="avatar"><img id="head_s" src="img/头像.jpg" /></span></div>
            </div>
            <div id="collapseTwo" class="panel-collapse collapse">
              <div class="panel-body form-horizontal">
                  <fieldset>
                    <div class="form-group">
                      <div class="col-sm-4 text-right">
                        <span class="avatar avatar150">
                          <img id="head_b" src="img/头像.jpg" class="img-circle img-responsive">
                        </span>
                      </div>
                      <div class="col-sm-8">
                        <button id="btn_head" class="btn btn-default btn-lg">选择头像</button>
                        <input id="f_head" type="file" style="display:none;" name="head"/>
                        <p class="help-block">支持 JPG、PNG、GIF 格式，不要超过 2M 。</p>
                      </div>
                    </div>
                  </fieldset>
              </div>
            </div>
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
            <div id="collapseThree" class="panel-collapse collapse">
              <div class="panel-body form-horizontal">
                  <div class="form-group">
                    <label for="" class="col-sm-2 control-label">当前用户名</label>
                    <div class="col-sm-4">
                      <p id="p_mail" class="form-control-static"></p>
                    </div>
                  </div>
                  <div class="form-group">
                    <label for="" class="col-sm-2 control-label">新用户名</label>
                    <div class="col-sm-4">
                      <input type="text" class="form-control" id="mailNew" name="mailNew">
                    </div>
                  </div>
                  <div class="form-group">
                  
                    <div class="col-sm-4">
                    
                    </div>
                  </div>
                  <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                      <button id="btn_mail" type="button" class="btn btn-primary">保存</button>
                    </div>
                  </div>
              </div>
            </div>
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
                      <input type="password" class="form-control" id="passwdNew">
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
                      <button id="btn_passwd" type="button" class="btn btn-primary">保存</button>
                    </div>
                  </div>
              </div>
            </div>
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
            <a href="/post/5008/" class="text-muted">关于我们</a>  ·  <a href="/post/5021/" class="text-muted">联系我们</a>  ·  <a href="/post/5023/" class="text-muted">加入我们</a>  ·  <a href="/post/5011/" class="text-muted">服务协议</a>  ·  <a href="/topic/10024/" class="text-muted">帮助中心</a>  ·  <a href="/post/5024/" class="text-muted">App</a>  ·  <a href="http://list.qq.com/cgi-bin/qf_invite?id=c47b87624bbe1feaa4dcd4e7510e57809b22d9cc9eaaa8c4" target="_blank"  class="text-muted">订阅</a>
        </div>
       
      </div>
    </footer>
    <!-- 尾部导航（移动端）-->
    <nav class="navbar navbar-default navbar-bottomnav  visible-xs visible-sm" role="navigation">
      <div class="navbar-header">
        <ul class="pager pull-left">
          <li><a href="javascript:history.go(-1);"><span class="glyphicon glyphicon-chevron-left"></span> 后退</a></li>
          <li><a href="javascript:history.go(1);">前进 <span class="glyphicon glyphicon-chevron-right"></span></a></li>
        </ul>
        <ul class="pager pull-right">
          <li><a href="/">首页</a></li>
          
          <li><a href="/u/1804037/">我的主页</a></li>
          
        </ul>
      </div>
    </nav>
	<script src="js/zhuye4.js"></script>
    <script src="js/zhuye3.js"></script>
    <script src="js/zhuye2.js"></script>
    
   
   
<script type="text/javascript">
$('#btn_fd').click(function(){
	var fd = $('#fd').val();
	var fdlink = $('#fdlink').val();
	fd = $.trim(fd);
	fdlink = $.trim(fdlink);
	if(fd == '' || fdlink == ''){
		alert('请填写你的意见和联系方式！');
		return false;
	}
	var d={};
	d['fd']=fd;
	d['fdlink']=fdlink;
	$(this).html('提交中...');
	$(this).attr("disabled", true);
	$.ajax({
		url : '/feedback/',
		type : 'POST',
		data : d,
		cache: false,
		dataType : 'json',
		error : function() {
			alert('系统故障，稍微重试！');
			$('#btn_fd').attr("disabled", false);
		},
		success : function(data) {
			if(data.error){
				alert(data.desc);
			}else{
				alert('提交成功');
			}
			$('#btn_fd').html('提交');
			$('#btn_fd').attr("disabled", false);
			$('#btn_fd_cancel').trigger('click');
		}
	});
});
</script>
    
    
    
    
     
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