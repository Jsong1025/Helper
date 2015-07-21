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
              <li><a href="#" title="搜索约会">搜索约会</a></li>
              <li><a href="#" title="消息管理">消息管理</a></li>
              <li><a href="info.do" title="个人资料">个人资料</a></li>
              <%
             	if(permision < 3){
             %>
              <li><a href="default.jsp" title="前往 后台管理">后台管理</a></li>
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
 <div id="xuan" ;="" style="
    margin-left: 500px;
">
             性别：<select style="border-top-width:1px; margin-top: 50px">
			  <option value="不限">不限</option>
			  <option value="男">男</option>
			  <option value="女">女</option>
			  </select>
			  
              &nbsp;  &nbsp;  &nbsp; &nbsp;
             年龄：<select style="border-top-width:1px; margin-top: 50px">
			  <option value="不限">不限</option>
			  <option value="19岁以下">19岁以下</option>
			  <option value="19-22岁">19-22岁</option>
              <option value="23-26岁">23-26岁</option>
			  <option value="27-35岁">27-35岁</option>
			  <option value="35岁以上">35岁以上</option>
			  </select>
		&nbsp;  &nbsp;  &nbsp; &nbsp;
			  约会内容:<select style="border-top-width:1px; margin-top: 50px">
			  <option value="不限">不限</option>
			  <option value="吃饭">吃饭</option>
			  <option value="看电影">看电影</option>
              <option value="唱歌">唱歌</option>
			  <option value="运动">运动</option>
			  </select></div>


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
                  <%= appointments.get(i).getTime() %>&nbsp;&nbsp;<%= appointments.get(i).getGenderString() %>&nbsp;&nbsp;<%= appointments.get(i).getSubstanceToString() %>
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
                      <% if(appointments.get(i).getType() == 2){ %>
                      	<button id="" type="button" class="btn btn-primary" onclick="#" disabled >您已确认</button>
                      <% } else {%>
                      	<button id="" type="button" class="btn btn-primary" onclick="window.location.href='appointmentResponse.do?id=<%= appointments.get(i).getId() %>'">确认约会</button>
                      <%} %>
                    </div>
                  </div>
              </div>
            </div>
          </div>
          <%} %>
          
        </div>
    </div>
  </div>



 <div class="ab" style=" width: 1100px;   height: 350px; border-top-width: 0px; border-left-width: 0px; margin-left: 150px;"></div>
<span class="q" style="margin-left: 500px;">
<span class="fs" ><a herf="#" style=" margin-left: 160px;">上一页</a>
<span class="fs" style="  border-top-width: 500px; margin-bottom: 20px; padding-top: 20px;  margin-left: 80px;"><a herf="#">下一页</a></span>
</span>
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
            <a href="/post/5008/" class="text-muted">关于我们</a>  ·  <a href="/post/5021/" class="text-muted">联系我们</a>  ·  <a href="/post/5023/" class="text-muted">加入我们</a>  ·  <a href="/post/5011/" class="text-muted">服务协议</a>  ·  <a href="/topic/10024/" class="text-muted">帮助中心</a>  ·  <a href="/post/5024/" class="text-muted">App</a>  ·  <a href="http://list.qq.com/cgi-bin/qf_invite?id=c47b87624bbe1feaa4dcd4e7510e57809b22d9cc9eaaa8c4" target="_blank" class="text-muted">订阅</a>
        </bottom>
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