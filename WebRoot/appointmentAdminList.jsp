<%@ page language="java" import="java.util.*,vo.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML>
<html>
 <head>
  <title>约会信息
 </title>
   <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link href="css/dpl-min.css" rel="stylesheet" type="text/css" />
   <link href="css/main-min.css" rel="stylesheet" type="text/css" />


  <!-- Bootstrap -->
        <link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
        <link href="css/DT_bootstrap.css" rel="stylesheet" media="screen">

<%
	ArrayList<Appointment> appointments = (ArrayList<Appointment>)request.getAttribute("appointments");
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
										<th>发起时间</th>
										<th>约会时间</th>
										<th>发起用户</th>
										<th>接受用户</th>
										<th>性别要求</th>
										<th>约会内容</th>
										<th>套餐名称</th>
										<th>详细说明</th>
										<th>操作</th>
									</tr>
								</thead>
								<tbody>
									<%
										for(int i = 0 ; i < appointments.size() ; i++) {
									%>
									<tr class="odd gradeX">
										<td><%= appointments.get(i).getStartTime() %></td>
										<td><%= appointments.get(i).getTime() %></td>
										<td><%= appointments.get(i).getUser().getUsername() %></td>
										<td><%if(appointments.get(i).getOtherUser() != null){ %><%= appointments.get(i).getOtherUser().getUsername() %><%} %></td>
										<td><%= appointments.get(i).getGender() %></td>
										<td><%= appointments.get(i).getSubstanceToString() %></td>
										<td><%= appointments.get(i).getMeal() %></td>
										<td><%= appointments.get(i).getDescription() %></td>
										<td class="center">
											<button class="btn-min" type="button" onclick="window.location.href='appointmentUpdateShow.do?id=<%= appointments.get(i).getId() %>'">修改</button> 
											<button class="btn-min" type="button" onclick="window.location.href='appointmentdelete.do?id=<%= appointments.get(i).getId() %>'">删除</button>
											<button class="btn-min" type="button" onclick="">审核</button>
										</td>
									</tr>   
									<% } %>
								</tbody>
							</table>
                        </div>
                    </div>
                    <!-- /block -->
                    <button class="btn-min" type="button" onclick="window.location.href='appointmentAddShow.do'">添加新的约会</button>
                </div>
			</div>


		<script src="js/jquery-1.9.1.js"></script>
        <script src="js/jquery.dataTables.min.js"></script>

        <script src="js/scripts.js"></script>
        <script src="js/DT_bootstrap.js"></script>
<body>
</html> 