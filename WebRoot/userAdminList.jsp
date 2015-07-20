<%@ page language="java" import="java.util.*,vo.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML>
<html>
 <head>
  <title>用户信息</title>
   <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link href="css/dpl-min.css" rel="stylesheet" type="text/css" />
   <link href="css/main-min.css" rel="stylesheet" type="text/css" />


  <!-- Bootstrap -->
        <link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
        <link href="css/DT_bootstrap.css" rel="stylesheet" media="screen">


<%
	ArrayList<User> users = (ArrayList<User>)request.getAttribute("users");
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
       <li class="nav-item dl-selected"><div class="nav-item-inner nav-home"><a href="default.jsp">首页</a></div></li>
       <li class="nav-item"><div class="nav-item-inner nav-order"><a href="storeAdminList.do">商家</a></div></li>
    <li class="nav-item"><div class="nav-item-inner nav-inventory"><a href="mealAdminList.do">产品</a></div></li>
      <li class="nav-item"><div class="nav-item-inner nav-marketing"><a href="appointmentAdminList.do">约会</a></div></li>
         <li class="nav-item"><div class="nav-item-inner nav-supplier"><a href="userAdminList.do">用户</a></div></li>
		 <li class="nav-item"><div class="nav-item-inner nav-inventory"><a href="roleAdminList.do">角色</a></div></li>
	 <li class="nav-item"><div class="nav-item-inner nav-marketing"><a href="#">统计</a></div></li>
      </ul>
    </div>
    <ul id="J_NavContent" class="dl-tab-conten">

    </ul>
   </div>




<div class="sysinfo">
			<div  class="row-fluid" style="margin-left:10%;width:80%;">
                    <!-- block -->
                    <div class="block">         
                        <div class="block-content collapse in">
							<table cellpadding="0" cellspacing="0" border="0" class="table table-hover table-striped table-bordered" id="example">
								<thead>
									<tr>
										<th>用户名</th>
										<th>真实姓名</th>
										<th>性别</th>
										<th>年龄</th>
										<th>电话</th>
										<th>邮箱</th>
										<th>QQ</th>
										<th>居住地</th>
										<th>角色</th>
										<th>操作</th>
									</tr>
								</thead>
								<tbody>
									<%
										for(int i = 0 ; i < users.size() ; i++) {
									%>
									<tr class="odd gradeX">
										<td><%= users.get(i).getUsername() %></td>
										<td><%= users.get(i).getName() %></td>
										<td><%= users.get(i).getSex() %></td>
										<td><%= users.get(i).getAge() %></td>
										<td><%= users.get(i).getTel() %></td>
										<td><%= users.get(i).getEmail() %></td>
										<td><%= users.get(i).getQQ() %></td>
										<td><%= users.get(i).getLocation() %></td>
										<td><%= users.get(i).getRole() %></td>
										<td class="center">
											<button class="btn-min" type="button" onclick="window.location.href='userUpdateShow.do?id=<%= users.get(i).getId() %>'">修改</button> 
											<button class="btn-min" type="button" onclick="window.location.href='userDelete.do?id=<%= users.get(i).getId() %>'">删除</button>
										</td>
									</tr>   
									<%} %>
								</tbody>
							</table>
                        </div>
                    </div>
                    <button class="btn-min" type="button" onclick="window.location.href='userAddShow.do'">添加新的用户</button> 
                    <!-- /block -->
                </div>
			</div>


		<script src="js/jquery-1.9.1.js"></script>
        <script src="js/jquery.dataTables.min.js"></script>

        <script src="js/scripts.js"></script>
        <script src="js/DT_bootstrap.js"></script>
<body>
</html> 