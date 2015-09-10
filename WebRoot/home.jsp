<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="zh-CN">
	<head>
		<meta charset="utf-8">
		<title>约会帮帮忙</title>
		<meta name="keywords" content="">
		<meta name="description" content="">
		<meta property="wb:webmaster" content="5f63032de006d23d" />

		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<meta name="viewport"
			content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="author" content="约会帮帮忙">
		<meta name="application-name" content="约会帮帮忙 | homepage.html">

		<!--[if lt IE 9]>
		<script type="text/javascript">var duration=2900;var endTime = new Date().getTime() + duration + 100;function interval(){var n=(endTime-new Date().getTime())/1000;if(n<0) return;document.getElementById("timeout").innerHTML = n.toFixed(3);setTimeout(interval, 10);}window.onload=function(){setTimeout("window.location.href='/goodbyie/'", duration);interval();}</script>
		<![endif]-->

		<link rel="stylesheet" href="css/style.css" media="screen">
		<link rel="stylesheet" href="css/style1.css" media="screen">
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
					<ul class="an"></ul>
					<ul class="nav navbar-nav navbar-right">
						<li style="margin-top: 10px;">
							<c:choose>
								<c:when test="${user.username != null}">${user.username}</c:when>
								<c:otherwise>${user.email}</c:otherwise>
							</c:choose>
						</li>
						<li class="dropdown">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown">
								<span class="avatar avatar40 pull-left">
									<img class="img-circle img-responsive" src="${user.picture}">
								</span>
								<b class="caret"></b>
							</a>
							<ul class="dropdown-menu clearfix">
								<li><a href="logout.do" title="退出登录">注销</a></li>
							</ul>
						</li>
					</ul>

				</div>

			</div>
		</div>

		<div class="bannerbar bannerbar-carousel visible-md visible-lg">
			<div id="carouselbar" class="carousel slide">
				<ol class="carousel-indicators">
					<li data-target="#carouselbar" data-slide-to="0" class="active"></li>
					<li data-target="#carouselbar" data-slide-to="1"></li>
					<li data-target="#carouselbar" data-slide-to="2"></li>
					<li data-target="#carouselbar" data-slide-to="3"></li>
					<li data-target="#carouselbar" data-slide-to="4"></li>
				</ol>
				<div class="carousel-inner">
					<div class="item active">
						<div style="background-image: url('img/6.jpg')">
							<a href="" class="text-hide"></a>
						</div>
					</div>
					<div class="item">
						<div style="background-image: url('img/8.jpg')">
							<a href="" class="text-hide"></a>
						</div>
					</div>
					<div class="item">
						<div style="background-image: url('img/1.jpg')">
							<a href="" class="text-hide"></a>
						</div>
					</div>
					<div class="item">
						<div style="background-image: url('img/2.jpg')">
							<a href="" class="text-hide"></a>
						</div>
					</div>
					<div class="item">
						<div style="background-image: url('img/7.jpg')">
							<a href="" class="text-hide"></a>
						</div>
					</div>
				</div>
				<a class="left carousel-control" href="#carouselbar"
					data-slide="prev" title="上一张"> 
					<span class="glyphicon glyphicon-chevron-left"></span>
				</a>
				<a class="right carousel-control" href="#carouselbar"
					data-slide="next" title="下一张"> 
					<span class="glyphicon glyphicon-chevron-right"></span>
				</a>
			</div>
		</div>
		<div class="container">
			<div class="row">
				<div class="col-md-8">
					<div class="page-header list-header visible-md visible-lg">
						<h3>
							<a href="" title="前往 热门景点" target="_blank">
								热门景点&nbsp;&nbsp;&nbsp; <small class="text-muted">景多图美，尽情观赏！</small>
								<small class="pull-right">更多 <span
									class="mediumicon mediumicon-arrow-right"></span> </small> </a>
						</h3>
					</div>
					<div class="row  mb20 visible-md visible-lg">
						<div class="col-xs-6 col-sm-3">
							<div class="thumbnail list-theme">
								<a href="business.html"> <img src="img/15.jpg"
										class="img-responsive cover" /> </a>
							</div>
						</div>
						<div class="col-xs-6 col-sm-3">
							<div class="thumbnail list-theme">
								<a href="business.html"> <img src="img/21.jpg"
										class="img-responsive cover" /> </a>
							</div>
						</div>
						<div class="col-xs-6 col-sm-3">
							<div class="thumbnail list-theme">
								<a href="business.html"> <img src="img/22.jpg"
										class="img-responsive cover" /> </a>
							</div>
						</div>
						<div class="col-xs-6 col-sm-3">
							<div class="thumbnail list-theme">
								<a href="business.html"> <img src="img/23.jpg"
										class="img-responsive cover" /> </a>
							</div>
						</div>
					</div>
					<div class="page-header list-header">
						<h3>
							好吃好喝好玩！
						</h3>
					</div>
					<div id="ipost_list" class="row">

						<div class="col-sm-6">
							<div class="thumbnail list-theme list-theme-post">
								<a href="business.html"><img src="img/chi1.jpg"
										class="img-responsive cover2" /> </a>
								<div class="caption">
									<p>
										<small><a href="business.html" title="商家信息"
											class="text-muted"></a> </small>
									</p>
									<h3>
										<a href="business.html">商家名称</a>
									</h3>
									<p class="text-right">
										<small class="text-muted"><a href="business.html"
											class="text-muted">商家描述</a> </small>
									</p>
								</div>
							</div>
						</div>

						<div class="col-sm-6">
							<div class="thumbnail list-theme list-theme-post">
								<a href="business.html"><img src="img/chi2.jpg" /> </a>
								<div class="caption">
									<p>
										<small><a href="business.html" title="商家信息"
											class="text-muted"></a> </small>
									</p>
									<h3>
										<a href="business.html">商家名称</a>
									</h3>

									<p class="text-right">
										<small class="text-muted"><a href="business.html"
											class="text-muted">商家描述</a> </small>
									</p>
								</div>
							</div>
						</div>

						<div class="col-sm-6">
							<div class="thumbnail list-theme list-theme-post">
								<a href="business.html"><img src="img/chi3.jpg"
										class="img-responsive cover2" /> </a>
								<div class="caption">
									<p>
										<small><a href="business.html" title="商家信息"
											class="text-muted"></a> </small>
									</p>
									<h3>
										<a href="business.html">商家名称</a>
									</h3>
									<p class="text-right">
										<small class="text-muted"><a href="business.html"
											class="text-muted">商家描述</a> </small>
									</p>
								</div>
							</div>
						</div>

						<div class="col-sm-6">
							<div class="thumbnail list-theme list-theme-post">
								<a href="business.html"><img src="img/chi1.jpg"
										class="img-responsive cover2" /> </a>
								<div class="caption">
									<p>
										<small><a href="business.html" title="商家信息"
											class="text-muted"></a> </small>
									</p>
									<h3>
										<a href="business.html">商家名称</a>
									</h3>

									<p class="text-right">
										<small class="text-muted"><a href="business.html"
											class="text-muted">商家描述</a> </small>
									</p>
								</div>
							</div>
						</div>

						<div class="col-sm-6">
							<div class="thumbnail list-theme list-theme-post">
								<a href="business.html"><img src="img/chi2.jpg"
										class="img-responsive cover2" /> </a>
								<div class="caption">
									<p>
										<small><a href="business.html" title="商家信息"
											class="text-muted"></a> </small>
									</p>
									<h3>
										<a href="">商家名称</a>
									</h3>

									<p class="text-right">
										<small class="text-muted"><a href="business.html"
											class="text-muted">商家描述</a> </small>
									</p>
								</div>
							</div>
						</div>

						<div class="col-sm-6">
							<div class="thumbnail list-theme list-theme-post">
								<a href="business.html"><img src="img/chi3.jpg"
										class="img-responsive cover2" /> </a>
								<div class="caption">
									<p>
										<small><a href="business.html" title="商家信息"
											class="text-muted"></a> </small>
									</p>
									<h3>
										<a href="business.html">商家名称</a>
									</h3>

									<p class="text-right">
										<small class="text-muted"><a href="business.html"
											class="text-muted">商家描述</a> </small>
									</p>
								</div>
							</div>
						</div>

						<div class="col-sm-6">
							<div class="thumbnail list-theme list-theme-post">
								<a href="business.html"><img src="img/chi1.jpg"
										class="img-responsive cover2" /> </a>
								<div class="caption">
									<p>
										<small><a href="business.html" title="商家信息"
											class="text-muted"></a> </small>
									</p>
									<h3>
										<a href="">商家名称</a>
									</h3>

									<p class="text-right">
										<small class="text-muted"><a href="business.html"
											class="text-muted">商家描述</a> </small>
									</p>
								</div>
							</div>
						</div>

						<div class="col-sm-6">
							<div class="thumbnail list-theme list-theme-post">
								<a href="business.html"><img src="img/chi1.jpg"
										class="img-responsive cover2" /> </a>
								<div class="caption">
									<p>
										<small><a href="business.html" title="商家信息"
											class="text-muted"></a> </small>
									</p>
									<h3>
										<a href="business.html">商家名称</a>
									</h3>

									<p class="text-right">
										<small class="text-muted"><a href="business.html"
											class="text-muted">商家描述</a> </small>
									</p>
								</div>
							</div>
						</div>
						<div class="col-sm-6">
							<div class="thumbnail list-theme list-theme-post">
								<a href="business.html"><img src="img/chi2.jpg"
										class="img-responsive cover2" /> </a>
								<div class="caption">
									<p>
										<small><a href="business.html" title="商家信息"
											class="text-muted"></a> </small>
									</p>
									<h3>
										<a href="business.html">商家名称</a>
									</h3>

									<p class="text-right">
										<small class="text-muted"><a href="business.html"
											class="text-muted">商家描述</a> </small>
									</p>
								</div>
							</div>
						</div>

						<div class="col-sm-6">
							<div class="thumbnail list-theme list-theme-post">
								<a href="business.html"><img src="img/chi3.jpg"
										class="img-responsive cover2" /> </a>
								<div class="caption">
									<p>
										<small><a href="business.html" title="商家信息"
											class="text-muted"></a> </small>
									</p>
									<h3>
										<a href="business.html">商家名称</a>
									</h3>

									<p class="text-right">
										<small class="text-muted"><a href="business.html"
											class="text-muted">商家描述</a> </small>
									</p>
								</div>
							</div>
						</div>

					</div>

					<div class="container text-center mb40">

						<div class="text-center mb40">
							<button id="btn_load_ipost" type="button"
								class="btn btn-default btn-lg">
								继续加载
							</button>
						</div>







						<ul class="pagination pull-right" style="display: none">
							<li class="active">
								<span>1</span>
							</li>
							<li>
								<a href='/post/?p=2'>2</a>
							</li>
							<li>
								<a href='/post/?p=3'>3</a>
							</li>
							<li>
								<a>...</a>
							</li>
							<li>
								<a href='/post/?p=87'>87</a>
							</li>
							<li>
								<a href='/post/?p=2'>下一页</a>
							</li>
						</ul>
					</div>
					<div class="page-header list-header">
						<h3>
							<a href="">套餐信息<small></small><small class="pull-right">更多
									<span class="mediumicon mediumicon-arrow-right"></span> </small> </a>
						</h3>
					</div>
					<div class="row mb20 ">

						<div class="col-xs-6 col-sm-3">
							<div class="thumbnail list-theme list-theme-column">
								<a href="business.html"><img src="img/24.jpg"
										class="img-responsive cover" /> </a>
								<div class="caption">
									<h3>
										<a href="business.html">套餐描述</a>
									</h3>
									<p class="text-muted">
										<a href="business.html" class="text-muted"></a>
									</p>
								</div>
							</div>
						</div>

						<div class="col-xs-6 col-sm-3">
							<div class="thumbnail list-theme list-theme-column">
								<a href="business.html"><img src="img/25.jpg"
										class="img-responsive cover" /> </a>
								<div class="caption">
									<h3>
										<a href="business.html">套餐描述</a>
									</h3>
									<p class="text-muted">
										<a href="business.html" class="text-muted"></a>
									</p>
								</div>
							</div>
						</div>

						<div class="col-xs-6 col-sm-3">
							<div class="thumbnail list-theme list-theme-column">
								<a href="business.html"><img src="img/26.jpg"
										class="img-responsive cover" /> </a>
								<div class="caption">
									<h3>
										<a href="business.html">套餐描述</a>
									</h3>
									<p class="text-muted">
										<a href="business.html" class="text-muted"></a>
									</p>
								</div>
							</div>
						</div>

						<div class="col-xs-6 col-sm-3">
							<div class="thumbnail list-theme list-theme-column">
								<a href="business.html"><img src="img/27.jpg"
										class="img-responsive cover" /> </a>
								<div class="caption">
									<h3>
										<a href="business.html">套餐描述</a>
									</h3>
									<p class="text-muted">
										<a href="business.html" class="text-muted"></a>
									</p>
								</div>
							</div>
						</div>

					</div>
				</div>
				<div class="col-md-4">
					<div class="siderbar">
						<div class="panel panel-default panelbox">
							<div class="panel-body">
								想去约会又没什么主意？
								<br />
								<br />
								我们帮你想~ 半天/一天？室内/户外？随你选择。
								<br />
								<br />
								愿每个约会的美好时光都不会被辜负。
							</div>
						</div>
						<div
							class="thumbnail list-theme list-theme-topic visible-md visible-lg">
							<a href="business.html"><img src="img/24.jpg"
									class="img-responsive cover"> </a>
							<div class="caption">
								<div class="caption-content">
									<h3>
										<a href="business.html">专题</a>
									</h3>
									<div class="divider"></div>
									<h4>
										<a href="business.html"></a>
									</h4>
									<p>
										<small><a href="business.html" class="text-muted"></a>
										</small>
									</p>

								</div>
							</div>
						</div>
						<div class="thumbnail list-theme list-theme-topic ">

							<a href="business.html"><img src="img/25.jpg"
									class="img-responsive cover"> </a>
							<div class="caption">
								<div class="caption-content">
									<h3>
										<a href="business.html">专题</a>
									</h3>
									<div class="divider"></div>
									<h4>
										<a href="business.html"></a>
									</h4>
									<p>
										<small><a href="business.html" class="text-muted"></a>
										</small>
									</p>

								</div>
							</div>

						</div>
						<div
							class="thumbnail list-theme list-theme-topic visible-md visible-lg">
							<a href="business.html"><img src="img/24.jpg"
									class="img-responsive cover"> </a>
							<div class="caption">
								<div class="caption-content">
									<h3>
										<a href="business.html">专题</a>
									</h3>
									<div class="divider"></div>
									<h4>
										<a href="business.html"></a>
									</h4>
									<p>
										<small><a href="business.html" class="text-muted"></a>
										</small>
									</p>

								</div>
							</div>
						</div>
						<div class="list-group mb40">
						</div>
						<div class="list-group mb40">
						</div>
						<div class="list-group mb40">
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
				<a href="" class="text-muted">关于我们</a> ·
				<a href="" class="text-muted">联系我们</a> ·
				<a href="" class="text-muted">加入我们</a> ·
				<a href="" class="text-muted">服务协议</a> ·
				<a href="" class="text-muted">帮助中心</a> ·
				<a href="" class="text-muted">App</a> ·
				<a href="" target="_blank" class="text-muted">订阅</a>
			</div>
			<div class="col-sm-12 text-center text-muted">

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
						class="glyphicon glyphicon-chevron-right"></span> </a>
				</li>
			</ul>
			<ul class="pager pull-right">
				<li>
					<a href="/">首页</a>
				</li>

			</ul>
		</div>
		</nav>
		<script src="js/zhuye4.js"></script>
		<script src="js/zhuye3.js"></script>
		<script src="js/zhuye2.js"></script>





		<script src="/assets/js/open-connect.js" type="text/javascript"
			charset="UTF-8"></script>
		<script type="text/javascript">
        	$(function(){
        		$('#btn_register').click(function(){
        			window.location.href='/account/register/';
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

		<script type="text/javascript" src="js/huandengpian.js"></script>
		<!-- 幻灯片 -->
		<script>
$('#carouselbar').carousel({interval: 5000});
</script>
		<script type="text/javascript" src="js/zhuye.js" charset="UTF-8"></script>
		<a id="scrollUp" href="#top" class="text-muted" title="回到顶部"
			style="position: fixed; z-index: 2147483647;">▲</a>
	</body>
</html>
