<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html>
 <head>
  <title>商家信息
 </title>
   <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link href="css/dpl-min.css" rel="stylesheet" type="text/css" />
   <link href="css/main-min.css" rel="stylesheet" type="text/css" />


  <!-- Bootstrap -->
        <link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
        <link href="css/DT_bootstrap.css" rel="stylesheet" media="screen">
        
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




<div class="sysinfo">
			<div  class="row-fluid" style="margin-left:10%;width:80%;">
                    <!-- block -->
                    <div class="block">         
                        <div class="block-content collapse in">
							<table cellpadding="0" cellspacing="0" border="0" class="table table-hover table-striped table-bordered" id="example">
								<thead>
									<tr>
										<th>套餐名称</th>
										<th>开始时间</th>
										<th>结束时间</th>
										<th>数量</th>
										<th>价格</th>
										<th>优惠条件</th>
										<th>商家</th>
										<th>操作</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="meal" items="meals">
									<tr class="odd gradeX">
										<td>${meal.name}</td>
										<td>${meal.startTime}</td>
										<td>${meal.endTime}</td>
										<td>${meal.num}</td>
										<td>${meal.price}</td>
										<td>${meal.priferemential}</td>
										<td>${meal.store}</td>
										<td class="center">
											<button class="btn-min" type="button" onclick="window.location.href='mealUpdateShow.do?id=${meal.id}'">修改</button> 
											<button class="btn-min" type="button" onclick="window.location.href='mealDelete.do?id=${meal.id}'">删除</button>
										</td>
									</tr>   
									</c:forEach>
								</tbody>
							</table>
                        </div>
                    </div>
                    <!-- /block -->
                    <button class="btn-min" type="button" onclick="window.location.href='mealAddShow.do'">添加新的产品</button>
                </div>
			</div>


		<script src="js/jquery-1.9.1.js"></script>
        <script src="js/jquery.dataTables.min.js"></script>

        <script src="js/scripts.js"></script>
        <script src="js/DT_bootstrap.js"></script>
<body>
</html> 