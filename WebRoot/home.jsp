<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
	<meta charset="utf-8">
    <title>约会帮帮忙</title>
    <meta name="keywords" content="">
    <meta name="description" content="">
    <meta property="wb:webmaster" content="5f63032de006d23d" />


<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="author" content="约会帮帮忙">
<meta name="application-name" content="约会帮帮忙 | homepage.html">
<!--[if lt IE 9]>
<script type="text/javascript">var duration=2900;var endTime = new Date().getTime() + duration + 100;function interval(){var n=(endTime-new Date().getTime())/1000;if(n<0) return;document.getElementById("timeout").innerHTML = n.toFixed(3);setTimeout(interval, 10);}window.onload=function(){setTimeout("window.location.href='/goodbyie/'", duration);interval();}</script>
<![endif]-->

	<link rel="stylesheet" href="css/style.css" media="screen">
    <link rel="stylesheet" href="css/style1.css" media="screen">
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
    		
    		//需要显示的消息
            if(session.getAttribute("message") != null){
            	out.print((String)session.getAttribute("message"));
            	session.removeAttribute("message");
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
              <li><a href="release.do" title="前往 发布约会">发布约会</a></li>
              <li><a href="appointmentList.do" title="前往 约会管理">约会管理</a></li>
              <li><a href="#" title="前往 搜索约会">搜索约会</a></li>
              <li><a href="#" title="前往 消息管理">消息管理</a></li>
              <li><a class="visible-md visible-lg" href="info.do" title="前往 个人设置">个人设置</a></li>
             <%
             	if(permision < 3){
             %>
              <li><a href="default.html" title="前往 后台管理">后台管理</a></li>
              <% }%>
     
<li>

<form action="" method="get">
<span class="kuan"><input name="" type="text" style="
    margin-top: 10px;
    margin-bottom: 10px;
    margin-right: 10px;outline-color;black;
    outline-color: black;
    border-top-width: 1px;
    border-bottom-width: 1px;
    border-right-width: 1px;
    border-left-width: 1px;
    padding-bottom: 0px;
    width: 152px;
    height: 21px;
    margin-left: 40px;
">
</span><!--搜索框-->
<span class="an"><input name="搜索" type="button" value="搜索" style="width: 42px;height: 20px;"/>
</span>
</form>
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

    <div class="bannerbar bannerbar-carousel visible-md visible-lg" >
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
            <div style="background-image:url('img/6.jpg')">
              <a href="   " class="text-hide" title=" "></a>
            </div>
          </div>
          <div class="item">
            <div style="background-image:url('img/8.jpg')">
              <a href="/post/5027/" class="text-hide" title=""></a>
            </div>
          </div>
          <div class="item">
            <div style="background-image:url('img/1.jpg')">
              <a href="/topic/10025/" class="text-hide" title="不辜负每个周末的好时光">不辜负每个周末的好时光</a>
            </div>
          </div>
          <div class="item">
            <div style="background-image:url('img/2.jpg')">
              <a href="/post/5018/" class="text-hide" title=""></a>
            </div>
          </div>
          <div class="item">
            <div style="background-image:url('img/7.jpg')">
              <a href="/post/5019/" class="text-hide" title=""></a>
            </div>
          </div>
        </div>
        <a class="left carousel-control" href="#carouselbar" data-slide="prev" title="上一张">
          <span class="glyphicon glyphicon-chevron-left"></span>
        </a>
        <a class="right carousel-control" href="#carouselbar" data-slide="next" title="下一张">
           <span class="glyphicon glyphicon-chevron-right"></span>
        </a>
      </div>
    </div>
    <div class="container">
      <div class="row">
        <div class="col-md-8">
        <div class="page-header list-header visible-md visible-lg">
            <h3>
              <a href="http://www.yuelvxing.com/zine/weekly/" title="前往 热门景点" target="_blank">
                热门景点&nbsp;&nbsp;&nbsp;
                <small class="text-muted">景多图美，尽情观赏！</small>
                <small class="pull-right" >更多 <span class="mediumicon mediumicon-arrow-right"></span></small>
              </a>
            </h3>
          </div>
          <div class="row  mb20 visible-md visible-lg">
			<div class="col-xs-6 col-sm-3">
              <div class="thumbnail list-theme">
                <a href="  " title="" target="_blank">
                  <img  alt="" src="img/15.jpg" class="img-responsive cover"/>
                </a>
              </div>
            </div>
			<div class="col-xs-6 col-sm-3">
              <div class="thumbnail list-theme">
                <a href="http://www.yuelvxing.com/zine/vol073/" title="" target="_blank">
                  <img  alt="" src="img/21.jpg" class="img-responsive cover"/>
                </a>
              </div>
            </div>
            <div class="col-xs-6 col-sm-3">
              <div class="thumbnail list-theme">
                <a href="http://www.yuelvxing.com/zine/vol072/" title="" target="_blank">
                  <img alt="" src="img/22.jpg" class="img-responsive cover"/>
                </a>
              </div>
            </div>
            <div class="col-xs-6 col-sm-3">
              <div class="thumbnail list-theme">
                <a href="http://www.yuelvxing.com/zine/vol071/" title="" target="_blank">
                  <img alt="" src="img/23.jpg" class="img-responsive cover"/>
                </a>
              </div>
            </div>
          </div>
          <div class="page-header list-header">
            <h3>好吃好喝好玩！</h3>
          </div>
          <div id="ipost_list" class="row">
          
            <div class="col-sm-6">
              <div class="thumbnail list-theme list-theme-post">
                <a href="/post/5436/"><img  alt="" src="img/chi1.jpg" class="img-responsive cover2"/></a>
                <div class="caption">
                  <p><small><a href="/collection/10000/" title="商家信息" class="text-muted"></a></small></p>
                  <h3><a href="/post/5436/"></a></h3>      
                  <p class="text-right"><small class="text-muted"><a href="/u/100000/" class="text-muted"></a></small></p>
                </div>
              </div>
            </div>
		  
            <div class="col-sm-6">
              <div class="thumbnail list-theme list-theme-post">
                <a href="/post/5435/"><img  alt="" src="img/chi2.jpg"/></a>
                <div class="caption">
                  <p><small><a href="/collection/10000/" title="商家信息" class="text-muted"></a></small></p>
                  <h3><a href="/post/5435/"></a></h3>
                  
                  <p class="text-right"><small class="text-muted"><a href="/u/100000/" class="text-muted"></a></small></p>
                </div>
              </div>
            </div>
		  
            <div class="col-sm-6">
              <div class="thumbnail list-theme list-theme-post">
                <a href="/post/5434/"><img  alt="" src="img/chi3.jpg" class="img-responsive cover2"/></a>
                <div class="caption">
                  <p><small><a href="/collection/10000/" title="商家信息" class="text-muted"></a></small></p>
                  <h3><a href="/post/5434/"></a></h3>
                  <p class="text-right"><small class="text-muted"><a href="/u/100000/" class="text-muted"></a></small></p>
                </div>
              </div>
            </div>
		  
            <div class="col-sm-6">
              <div class="thumbnail list-theme list-theme-post">
                <a href="/post/5433/"><img  alt="" src="http://yuelxm.b0.upaiyun.com/zine/column/1430480114499p69f4508f34248d3f04e90d2e8afc222c.png!cover8" class="img-responsive cover2"/></a>
                <div class="caption">
                  <p><small><a href="/collection/10000/" title="商家信息" class="text-muted"></a></small></p>
                  <h3><a href="/post/5433/"></a></h3>
                 
                  <p class="text-right"><small class="text-muted"><a href="/u/100000/" class="text-muted"></a></small></p>
                </div>
              </div>
            </div>
		  
            <div class="col-sm-6">
              <div class="thumbnail list-theme list-theme-post">
                <a href="/post/5432/"><img  alt="" src="http://yuelxm.b0.upaiyun.com/zine/column/1429893291631pf0acf4fedfae41c4320cb1409ec2bb5e.png!cover8" class="img-responsive cover2"/></a>
                <div class="caption">
                  <p><small><a href="/collection/10000/" title="商家信息" class="text-muted"></a></small></p>
                  <h3><a href="/post/5432/"></a></h3>
                  
                  <p class="text-right"><small class="text-muted"><a href="/u/100000/" class="text-muted"></a></small></p>
                </div>
              </div>
            </div>
		  
            <div class="col-sm-6">
              <div class="thumbnail list-theme list-theme-post">
                <a href="/post/5431/"><img  alt="" src="http://yuelxm.b0.upaiyun.com/zine/column/1429892025132pf60feb182efc3bbee9c7a34b99fc852c.jpg!cover8" class="img-responsive cover2"/></a>
                <div class="caption">
                  <p><small><a href="/collection/10000/" title="商家信息" class="text-muted"></a></small></p>
                  <h3><a href="/post/5431/"></a></h3>
                 
                  <p class="text-right"><small class="text-muted"><a href="/u/100000/" class="text-muted"></a></small></p>
                </div>
              </div>
            </div>
		  
            <div class="col-sm-6">
              <div class="thumbnail list-theme list-theme-post">
                <a href="/post/5430/"><img  alt="" src="http://yuelxm.b0.upaiyun.com/zine/column/1427487208790p7516af4bfae4bedd84f8dcf10d150d93.png!cover8" class="img-responsive cover2"/></a>
                <div class="caption">
                  <p><small><a href="/collection/10000/" title="商家信息" class="text-muted"></a></small></p>
                  <h3><a href="/post/5430/"></a></h3>
                  
                  <p class="text-right"><small class="text-muted"><a href="/u/100000/" class="text-muted"></a></small></p>
                </div>
              </div>
            </div>
		  
            <div class="col-sm-6">
              <div class="thumbnail list-theme list-theme-post">
                <a href="/post/5429/"><img  alt="" src="http://yuelxm.b0.upaiyun.com/zine/column/1427486560868p0a29ec6eef4b49ab5c9db97fbcde9ad3.jpg!cover8" class="img-responsive cover2"/></a>
                <div class="caption">
                  <p><small><a href="/collection/10000/" title="商家信息" class="text-muted"></a></small></p>
                  <h3><a href="/post/5429/"></a></h3>
                 
                  <p class="text-right"><small class="text-muted"><a href="/u/100000/" class="text-muted"></a></small></p>
                </div>
              </div>
            </div>
		             <div class="col-sm-6">
              <div class="thumbnail list-theme list-theme-post">
                <a href="/post/5428/"><img  alt="" src="http://yuelxm.b0.upaiyun.com/zine/column/1426870458302pf1bbdde3a7382b7421e9a11ceb63ac80.jpg!cover8" class="img-responsive cover2"/></a>
                <div class="caption">
                  <p><small><a href="/collection/10000/" title="商家信息" class="text-muted"></a></small></p>
                  <h3><a href="/post/5428/"></a></h3>
                 
                  <p class="text-right"><small class="text-muted"><a href="/u/100000/" class="text-muted"></a></small></p>
                </div>
              </div>
            </div>
		  
            <div class="col-sm-6">
              <div class="thumbnail list-theme list-theme-post">
                <a href="/post/5427/"><img  alt="" src="http://yuelxm.b0.upaiyun.com/zine/column/1426869626808p2269449ed9d4585f245e61ff73f1bb8d.jpg!cover8" class="img-responsive cover2"/></a>
                <div class="caption">
                  <p><small><a href="/collection/10000/" title="商家信息" class="text-muted"></a></small></p>
                  <h3><a href="/post/5427/"></a></h3>
                 
                  <p class="text-right"><small class="text-muted"><a href="/u/100000/" class="text-muted"></a></small></p>
                </div>
              </div>
            </div>
		  
          </div> 

          <div class="container text-center mb40">
          
          <div class="text-center mb40">
            <button id="btn_load_ipost" type="button" class="btn btn-default btn-lg">继续加载</button>
          </div>
          
          





<ul class="pagination pull-right" style="display: none">


	
		
		
		
		
			
			
			
				<li class="active"><span>1</span></li>
			
			
		
			
			
				
				<li><a href='/post/?p=2'>2</a></li>
				
			
			
			
		
			
			
				
				<li><a href='/post/?p=3'>3</a></li>
				
			
			
			
		
		
			<li><a>...</a></li>
		
		
			
			<li><a href='/post/?p=87'>87</a></li>
			
		
		
			
			<li><a href='/post/?p=2'>下一页</a></li>
			
		
	
</ul>

          </div>
          <div class="page-header list-header">
            <h3><a href="/collection/">主题栏目<small></small><small class="pull-right" >更多 <span class="mediumicon mediumicon-arrow-right"></span></small></a></h3>
          </div>
          <div class="row mb20 ">
            
            <div class="col-xs-6 col-sm-3">
              <div class="thumbnail list-theme list-theme-column">
                <a href="/collection/10042/"  title="前往 &#x6bd5;&#x4e1a;&#x53bb;&#x65c5;&#x884c; &mdash;&mdash; &#x9752;&#x6625;&#x5c31;&#x662f;&#x6c38;&#x4e0d;&#x56de;&#x5934;"><img  alt="&#x6bd5;&#x4e1a;&#x53bb;&#x65c5;&#x884c; &mdash;&mdash; &#x9752;&#x6625;&#x5c31;&#x662f;&#x6c38;&#x4e0d;&#x56de;&#x5934;" src="img/24.jpg" class="img-responsive cover"/></a>
                <div class="caption">
                  <h3><a href="/collection/10042/">&#x6bd5;&#x4e1a;&#x53bb;&#x65c5;&#x884c; &mdash;&mdash; &#x9752;&#x6625;&#x5c31;&#x662f;&#x6c38;&#x4e0d;&#x56de;&#x5934;</a></h3>
                  <p class="text-muted"><a href="/u/100000/" class="text-muted">&#x60a6;&#x65c5;&#x884c;</a> 主编，共0篇</p>
                </div>
              </div>
            </div>
            
            <div class="col-xs-6 col-sm-3">
              <div class="thumbnail list-theme list-theme-column">
                <a href="/collection/10041/"  title="前往 &#x6bd5;&#x4e1a;&#x53bb;&#x65c5;&#x884c; &mdash;&mdash; &#x9752;&#x6625;&#x5c31;&#x662f;&#x6c38;&#x4e0d;&#x56de;&#x5934;"><img  alt="&#x6bd5;&#x4e1a;&#x53bb;&#x65c5;&#x884c; &mdash;&mdash; &#x9752;&#x6625;&#x5c31;&#x662f;&#x6c38;&#x4e0d;&#x56de;&#x5934;" src="img/25.jpg" class="img-responsive cover"/></a>
                <div class="caption">
                  <h3><a href="/collection/10041/">&#x6bd5;&#x4e1a;&#x53bb;&#x65c5;&#x884c; &mdash;&mdash; &#x9752;&#x6625;&#x5c31;&#x662f;&#x6c38;&#x4e0d;&#x56de;&#x5934;</a></h3>
                  <p class="text-muted"><a href="/u/100000/" class="text-muted">&#x60a6;&#x65c5;&#x884c;</a> 主编，共0篇</p>
                </div>
              </div>
            </div>
            
            <div class="col-xs-6 col-sm-3">
              <div class="thumbnail list-theme list-theme-column">
                <a href="/collection/10036/"  title="前往 &#x62fc;&#x9014;&#x53ec;&#x96c6;&#x4ee4;"><img  alt="&#x62fc;&#x9014;&#x53ec;&#x96c6;&#x4ee4;" src="img/26.jpg" class="img-responsive cover"/></a>
                <div class="caption">
                  <h3><a href="/collection/10036/">&#x62fc;&#x9014;&#x53ec;&#x96c6;&#x4ee4;</a></h3>
                  <p class="text-muted"><a href="/u/100000/" class="text-muted">&#x60a6;&#x65c5;&#x884c;</a> 主编，共0篇</p>
                </div>
              </div>
            </div>
            
            <div class="col-xs-6 col-sm-3">
              <div class="thumbnail list-theme list-theme-column">
                <a href="/collection/10013/"  title="前往 &#x60a6;&#x65c5;&#x884c;&#x4e4b;&#x5bb6;"><img  alt="&#x60a6;&#x65c5;&#x884c;&#x4e4b;&#x5bb6;" src="img/27.jpg" class="img-responsive cover"/></a>
                <div class="caption">
                  <h3><a href="/collection/10013/">&#x60a6;&#x65c5;&#x884c;&#x4e4b;&#x5bb6;</a></h3>
                  <p class="text-muted"><a href="/u/100000/" class="text-muted">&#x60a6;&#x65c5;&#x884c;</a> 主编，共12篇</p>
                </div>
              </div>
            </div>
            
          </div>
        </div>
        <div class="col-md-4">
          <div class="siderbar">
            <div class="panel panel-default panelbox">
              <div class="panel-body">
              	想去约会又没什么主意？ <br/> <br/>我们帮你想~  半天/一天？室内/户外？随你选择。  <br/> <br/>愿每个约会的美好时光都不会被辜负。
              </div>
            </div>
            <div class="thumbnail list-theme list-theme-topic visible-md visible-lg">
              <a href="http://www.pintour.com" target="_blank"><img src="/assets/img/test/ad.jpg" class="img-responsive cover"></a>
            </div>
            <div class="thumbnail list-theme list-theme-topic ">
            
            <a href="/topic/10046/"><img src="img/25.jpg!cover8" class="img-responsive cover" alt="..."></a>
              <div class="caption">
                <div class="caption-content">
                  <h3><a href="/topic/10046/">专题</a></h3>
                  <div class="divider"></div>
                  <h4><a href="/topic/10046/">&#x5bfb;&#x627e;&#x4e2d;&#x56fd;&#x6700;&#x7f8e;&#x51ac;&#x5b63;</a></h4>
                  <p><small><a href="/u/100000/" class="text-muted">&#x60a6;&#x65c5;&#x884c;</a> 主编，共5篇</small></p>
                  
                </div>
              </div>
            
            </div>
	    <div class="thumbnail list-theme list-theme-topic visible-md visible-lg">
              <a href="/post/5024/"><img src="img/24.jpg" class="img-responsive cover"></a>
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
            <a href="/post/5008/" class="text-muted">关于我们</a>  ·  <a href="/post/5021/" class="text-muted">联系我们</a>  ·  <a href="/post/5023/" class="text-muted">加入我们</a>  ·  <a href="/post/5011/" class="text-muted">服务协议</a>  ·  <a href="/topic/10024/" class="text-muted">帮助中心</a>  ·  <a href="/post/5024/" class="text-muted">App</a>  ·  <a href="http://list.qq.com/cgi-bin/qf_invite?id=c47b87624bbe1feaa4dcd4e7510e57809b22d9cc9eaaa8c4" target="_blank"  class="text-muted">订阅</a>
        </div>
        <div class="col-sm-12 text-center text-muted">
        	
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
    
    
    
        <script src="/assets/js/open-connect.js" type="text/javascript" charset="UTF-8"></script>
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
<a id="scrollUp" href="#top" class="text-muted" title="回到顶部" style="position: fixed; z-index: 2147483647;">▲</a>
  </body>
</html>
