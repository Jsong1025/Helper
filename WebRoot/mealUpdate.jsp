<%@ page language="java" import="java.util.*,vo.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML>
<html>
 <head>
  <title>产品信息
 </title>
   <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link href="css/dpl-min.css" rel="stylesheet" type="text/css" />
   <link href="css/main-min.css" rel="stylesheet" type="text/css" />
    
    <link href="css/bootstrap.min.css" rel="stylesheet" />
    <link href="css/adminia.css" rel="stylesheet" /> 

<%
	ArrayList<Store> stores = (ArrayList<Store>)request.getAttribute("stores");
	Meal meal = (Meal)request.getAttribute("meal");
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
    
      <div class="dl-title">
        <a href="http://sc.chinaz.com" title="文档库地址" target="_blank">
        </a>
      </div>

    <div class="dl-log">欢迎您，<span class="dl-log-user">**.**@alibaba-inc.com</span><a href="###" title="退出系统" class="dl-log-quit">[退出]</a><a href="http://http://sc.chinaz.com/" title="文档库" class="dl-log-quit">文档库</a>
    </div>
  </div>
   <div class="content">
    <div class="dl-main-nav">
      <div class="dl-inform"><div class="dl-inform-title">贴心小秘书<s class="dl-inform-icon dl-up"></s></div></div>
      <ul id="J_Nav"  class="nav-list ks-clear">
       <li class="nav-item dl-selected"><div class="nav-item-inner nav-home"><a href="index.html">首页</a></div></li>
       <li class="nav-item"><div class="nav-item-inner nav-order"><a href="dialog-grid.html">商家</a></div></li>
    <li class="nav-item"><div class="nav-item-inner nav-inventory"><a href="dialog-grid2.html">产品</a></div></li>
      <li class="nav-item"><div class="nav-item-inner nav-marketing">约会</div></li>
         <li class="nav-item"><div class="nav-item-inner nav-supplier"><a href="dialog-grid3.html">用户</a></div></li>
		 <li class="nav-item"><div class="nav-item-inner nav-inventory"><a href="dialog-grid3.html">角色</a></div></li>
	 <li class="nav-item"><div class="nav-item-inner nav-marketing">统计</div></li>
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
								<h3>产品信息</h3>
							</div> <!-- /widget-header -->
									
							<div class="widget-content">
								
								
								
								<div class="tabbable">

							<div class="tab-content">
								<div class="tab-pane active" id="1">
								<form id="edit-profile" class="form-horizontal" action="mealUpdate.do?id=<%= meal.getId() %>" method="post">
									<fieldset>
										
										<div class="control-group">											
											<label class="control-label" for="name">产品名称</label>
											<div class="controls">
												<input type="text" class="input-medium" id="name" name="name" value="<%= meal.getName() %>"/>
											</div> <!-- /controls -->				
										</div> <!-- /control-group -->
										
										
										<div class="control-group">											
											<label class="control-label" for="startTime">开始时间</label>
											<div class="controls">
												<input type="date" class="input-medium" name="startTime" id="startTime" value="<%= meal.getStartTime() %>" />
											</div> <!-- /controls -->				
										</div> <!-- /control-group -->
										
										
										<div class="control-group">											
											<label class="control-label" for="endTime">结束时间</label>
											<div class="controls">
												<input type="date" class="input-medium" name="endTime" id="endTime" value="<%= meal.getEndTime() %>" />
											</div> <!-- /controls -->				
										</div> <!-- /control-group -->
										
										
										<div class="control-group">											
											<label class="control-label" for="num">数量</label>
											<div class="controls">
												<input type="text" class="input-medium" name="num" id="num" value="<%= meal.getNum() %>" />
											</div> <!-- /controls -->				
										</div> <!-- /control-group -->
										
										<div class="control-group">											
											<label class="control-label" for="price">价格</label>
											<div class="controls">
												<input type="text" class="input-medium" name="price" id="price" value="<%= meal.getPrice() %>" />
											</div> <!-- /controls -->				
										</div> <!-- /control-group -->

										<div class="control-group">											
											<label class="control-label" for="priferemential">基本介绍</label>
											<div class="controls">
												<input type="text" class="input-large" name="priferemential" id="priferemential" value="<%= meal.getPriferemential() %>" />
											</div> <!-- /controls -->				
										</div> <!-- /control-group -->

										<div class="control-group">											
											<label class="control-label" for="introduce">所属商家</label>
											<div class="controls">
												<select name="store">
												<% for(int i = 0; i<stores.size(); i++){ %>
													<option value=<%= stores.get(i).getId() %> <% if(meal.getStoreId() == stores.get(i).getId()){  %>selected<%} %> ><%= stores.get(i).getName() %></option>
												<%} %>
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