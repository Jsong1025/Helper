<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
	<head>
		<meta charset="utf-8">
		<title>发布约会</title>
		<meta name="keywords" content="">
		<meta name="description" content="">

		<link rel="stylesheet" href="css/info.css" media="screen">
		<link rel="stylesheet" href="css/info2.css" media="screen">

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

	</head>
	<body>

		<div class="nav-top">
			<div class="container">
				<nav id="navbar" class="navbar navbar-default" role="navigation">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse"
						data-target=".navbar-ex1-collapse">
						<span class="sr-only">导航菜单</span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
					</button>

				</div>
				<div class="collapse navbar-collapse navbar-ex1-collapse">
					<ul class="nav navbar-nav">
						<li>
							<a href="#" title="发布约会">发布约会</a>
						</li>
						<li>
							<a href="#" title="搜索约会">搜索约会</a>
						</li>
						<li>
							<a href="#" title="消息管理">消息管理</a>
						</li>
						<li>
							<a href="info.do" title="个人资料">个人资料</a>
						</li>
						<%
             	if(permision < 3){
             %>
						<li>
							<a href="#" title="前往 后台管理">后台管理</a>
						</li>
						<% }%>
					</ul>
					<ul class="nav navbar-nav navbar-right">
						<li style="margin-top: 10px;"><%= username %></li>
						<li class="dropdown">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown"> <span
								class="avatar avatar40 pull-left"><img
										class="img-circle img-responsive" src="img/img.jpg">
							</span><b class="caret"></b>
							</a>
							<ul class="dropdown-menu clearfix">

								<li>
									<a href="logout.do" title="退出登录">注销</a>
								</li>
							</ul>
						</li>
					</ul>
				</div>
				</nav>
			</div>
		</div>

		<div class="settingbar">
			<div class="container">
				<h1 class="mb40">
					发布约会
					<small class="pull-right"></small>
				</h1>
				<div class="panel-group settingbar-panel mb120" id="accordion">
					<div class="panel panel-default">
						<div class="panel-heading">
							<h4 class="panel-title clearfix">
								<a data-toggle="collapse" data-toggle="collapse"
									data-parent="#accordion" href="#"> 发布约会<span
									class="pull-right"></span> </a>
								<div id="lab_name" class="panel-info"></div>
							</h4>
						</div>
						<div id="collapseOne" class="panel-collapse">
							<div class="panel-body form-horizontal">
								<div class="form-group">
									<label for="" class="col-sm-2 control-label">
										约会内容
									</label>
									<div class="col-sm-4">
										<input type=checkbox name=substance value="吃饭">
										吃饭&nbsp
										<input type=checkbox name=substance value="看电影">
										看电影&nbsp
										<input type=checkbox name=substance value="唱歌">
										唱歌&nbsp
										<input type=checkbox name=substance value="运动">
										运动&nbsp
									</div>
								</div>
								<div class="form-group">
									<label for="" class="col-sm-2 control-label">
										性别要求
									</label>
									<div class="col-sm-7">
										<input type=radio name=gender value="只限男生">
										只限男生&nbsp
										<input type=radio name=gender value="只限女生">
										只限女生&nbsp
										<input type=radio name=gender value="男女不限">
										男女不限
									</div>
								</div>

								<div class="form-group">
									<label for="" class="col-sm-2 control-label">
										商家选择
									</label>
									<div class="col-sm-7">

										<select>
											<option value="套餐一">
												商家一
											</option>
											<option value="套餐二">
												商家二
											</option>
										</select>
										&nbsp;&nbsp;&nbsp;&nbsp;
										<select>
											<option value="套餐一">
												套餐一
											</option>
											<option value="套餐二">
												套餐二
											</option>
										</select>
									</div>
								</div>

								<div class="form-group">
									<label for="" class="col-sm-2 control-label">
										时间选择
									</label>
									<div class="col-sm-7">
										<input type="date" name="time" value="">
									</div>
								</div>

								<div class="form-group">
									<label for="" class="col-sm-2 control-label">
										详细说明
									</label>
									<div class="col-sm-7">
										<textarea class="form-control" rows="4" id="description"
											name="description"></textarea>
									</div>
								</div>

								<div class="form-group">
									<div class="col-sm-offset-2 col-sm-10">
										<button id="btn_uinfo" type="submit" class="btn btn-primary">
											发布
										</button>
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
							<a href="/post/5008/" class="text-muted">关于我们</a> ·
							<a href="/post/5021/" class="text-muted">联系我们</a> ·
							<a href="/post/5023/" class="text-muted">加入我们</a> ·
							<a href="/post/5011/" class="text-muted">服务协议</a> ·
							<a href="/topic/10024/" class="text-muted">帮助中心</a> ·
							<a href="/post/5024/" class="text-muted">App</a> ·
							<a
								href="http://list.qq.com/cgi-bin/qf_invite?id=c47b87624bbe1feaa4dcd4e7510e57809b22d9cc9eaaa8c4"
								target="_blank" class="text-muted">订阅</a>
						</div>

					</div>
					</footer>
					<!-- 尾部导航（移动端）-->
					<nav
						class="navbar navbar-default navbar-bottomnav  visible-xs visible-sm"
						role="navigation">
					<div class="navbar-header">
						<ul class="pager pull-left">
							<li>
								<a href="javascript:history.go(-1);"><span
									class="glyphicon glyphicon-chevron-left"></span> 后退</a>
							</li>
							<li>
								<a href="javascript:history.go(1);">前进 <span
									class="glyphicon glyphicon-chevron-right"></span>
								</a>
							</li>
						</ul>
						<ul class="pager pull-right">
							<li>
								<a href="/">首页</a>
							</li>

							<li>
								<a href="/u/1804037/">我的主页</a>
							</li>

						</ul>
					</div>
					</nav>
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
					<a id="scrollUp" href="#top" class="text-muted" title="回到顶部"
						style="position: fixed; z-index: 2147483647;">▲</a>
	</body>
</html>