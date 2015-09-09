<%@ page language="java" import="java.util.*,com.helper.entity.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML>
<html>
 <head>
  <title>约会信息</title>
   <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link href="css/dpl-min.css" rel="stylesheet" type="text/css" />
   <link href="css/main-min.css" rel="stylesheet" type="text/css" />
    
    <link href="css/bootstrap.min.css" rel="stylesheet" />
    <link href="css/adminia.css" rel="stylesheet" /> 

<%
	ArrayList<User> users = (ArrayList<User>)request.getAttribute("users");
	ArrayList<Meal> meals = (ArrayList<Meal>)request.getAttribute("meals");
%>

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

    <div class="dl-log">欢迎您，<span class="dl-log-user"><%= session.getAttribute("email") %></span><a href="logout.do" title="退出系统" class="dl-log-quit">[退出]</a>
    </div>
  </div>
   <div class="content">
    <div class="dl-main-nav">
      <div class="dl-inform"><div class="dl-inform-title">贴心小秘书<s class="dl-inform-icon dl-up"></s></div></div>
      <ul id="J_Nav"  class="nav-list ks-clear">
       <li class="nav-item dl-selected"><div class="nav-item-inner nav-home"><a href="home.jsp">首页</a></div></li>
       <li class="nav-item"><div class="nav-item-inner nav-order"><a href="storeAdminList.do">商家</a></div></li>
    <li class="nav-item"><div class="nav-item-inner nav-inventory"><a href="mealAdminList.do">产品</a></div></li>
      <li class="nav-item"><div class="nav-item-inner nav-marketing"><a href="appointmentAdminList.do">约会</a></div></li>
         <li class="nav-item"><div class="nav-item-inner nav-supplier"><a href="userAdminList.do">用户</a></div></li>
		 <li class="nav-item"><div class="nav-item-inner nav-inventory"><a href="roleAdminList.do">角色</a></div></li>
      </ul>
    </div>
    <ul id="J_NavContent" class="dl-tab-conten">

    </ul>
   </div>

	<div class="container">
		
		<div class="row">
			
			<div class="span3">

			<div class="span9">
					
				<div class="row">
					
					<div class="span9">
				
						<div class="widget">
							
							<div class="widget-header">
								<h3>添加约会</h3>
							</div> <!-- /widget-header -->
									
							<div class="widget-content">
								
								
								
								<div class="tabbable">

							<div class="tab-content">
								<div class="tab-pane active" id="1">
								<form id="edit-profile" class="form-horizontal" action="appointmentAdd.do" method="post">
									<fieldset>
										
										<div class="control-group">											
											<label class="control-label" for="startTime">开始时间</label>
											<div class="controls">
												<input type="date" class="input-medium" id="startTime" name="startTime" value="" />
											</div> <!-- /controls -->				
										</div> <!-- /control-group -->

										<div class="control-group">											
											<label class="control-label" for="time">约会时间</label>
											<div class="controls">
												<input type="date" class="input-medium" id="time" name="time" value=""/>
											</div> <!-- /controls -->				
										</div> <!-- /control-group -->
										
										
										<div class="control-group">											
											<label class="control-label" for="user">发起用户</label>
											<div class="controls">
												<select name="user">
												<% for(int i=0; i<users.size();i++){ %>
													<option value="<%= users.get(i).getId() %>"><%= users.get(i).getName() %></option>
												<%} %>
												</select>
											</div> <!-- /controls -->				
										</div> <!-- /control-group -->
										
										<div class="control-group">											
											<label class="control-label" for="otherUser">接受用户</label>
											<div class="controls">
												<select name="otherUser">
													<% for(int i=0; i<users.size();i++){ %>
													<option value="<%= users.get(i).getId() %>"><%= users.get(i).getName() %></option>
												<%} %>
												</select>
											</div> <!-- /controls -->				
										</div> <!-- /control-group -->
										
										<div class="control-group">											
											<label class="control-label" for="gender">性别要求</label>
											<div class="controls">
												<input type="radio" class="input-medium" id="sex" name="gender" value=1 />男女不限&nbsp;&nbsp;&nbsp;&nbsp;
												<input type="radio" class="input-medium" id="sex" name="gender" value=2 />只限男生&nbsp;&nbsp;&nbsp;&nbsp;
												<input type="radio" class="input-medium" id="sex" name="gender" value=3 />只限女生
											</div> <!-- /controls -->				
										</div> <!-- /control-group -->
										
										
										<div class="control-group">											
											<label class="control-label" for="substance">约会内容</label>
											<div class="controls">
												<input type="checkbox" class="input-medium" id="substance" name="substance" value="吃饭" />吃饭&nbsp;&nbsp;&nbsp;&nbsp;
												<input type="checkbox" class="input-medium" id="substance" name="substance" value="唱歌" />唱歌&nbsp;&nbsp;&nbsp;&nbsp;
												<input type="checkbox" class="input-medium" id="substance" name="substance" value="看电影" />看电影&nbsp;&nbsp;&nbsp;&nbsp;
												<input type="checkbox" class="input-medium" id="substance" name="substance" value="运动" />运动
											</div> <!-- /controls -->				
										</div> <!-- /control-group -->
										
										<div class="control-group">											
											<label class="control-label" for="meal">套餐</label>
											<div class="controls">
												<select name="meal">
													<% for(int i=0; i<meals.size();i++){ %>
													<option value="<%= meals.get(i).getId() %>"><%= meals.get(i).getName() %></option>
												<%} %>
												</select>
											</div> <!-- /controls -->				
										</div> <!-- /control-group -->

										<div class="control-group">											
											<label class="control-label" for="description">详细说明</label>
											<div class="controls">
												<input type="text" class="input-large"  id="description" value="" />
											</div> <!-- /controls -->				
										</div> <!-- /control-group -->
											

											<br />

										<div class="form-actions">
											<button type="submit" class="btn btn-primary">保存</button> 
											<button class="btn">取消</button>
										</div> <!-- /form-actions -->
									</fieldset>
								</form>
								</div>
								</div></div></div>
							</div> <!-- /widget-content -->
							
						</div> <!-- /widget -->
						
					</div> <!-- /span9 -->
					
				</div> <!-- /row -->
			
				
			</div> <!-- /span9 -->
			
			
		</div> <!-- /row -->
		
	</div> <!-- /container -->

<body>
</html> 