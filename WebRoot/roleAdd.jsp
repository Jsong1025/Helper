<%@ page language="java" import="java.util.*,vo.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML>
<html>
 <head>
  <title>角色信息</title>
   <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link href="css/dpl-min.css" rel="stylesheet" type="text/css" />
   <link href="css/main-min.css" rel="stylesheet" type="text/css" />
    
    <link href="css/bootstrap.min.css" rel="stylesheet" />
    <link href="css/adminia.css" rel="stylesheet" /> 



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

	<div class="container">
		
		<div class="row">
			
			<div class="span3">


			<div class="span9">
					
				<div class="row">
					
					<div class="span9">
				
						<div class="widget">
							
							<div class="widget-header">
								<h3>添加角色</h3>
							</div> <!-- /widget-header -->
									
							<div class="widget-content">
								
								
								
								<div class="tabbable">

							<div class="tab-content">
								<div class="tab-pane active" id="1">
								<form id="edit-profile" class="form-horizontal" action="roleAdd.do" method="post">
									<fieldset>

										<div class="control-group">											
											<label class="control-label" for="name">角色名称</label>
											<div class="controls">
												<input type="text" class="input-medium" id="name" name="name" value=""/>
											</div> <!-- /controls -->				
										</div> <!-- /control-group -->
										
										
										<div class="control-group">											
											<label class="control-label" for="permision">权限码</label>
											<div class="controls">
												<select name="permision">
													<option value=1>1</option>
													<option value=2>2</option>
													<option value=3>3</option>
													<option value=4>4</option>
													<option value=5>5</option>
													<option value=6>6</option>
												</select>
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