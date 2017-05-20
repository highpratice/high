<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'index.jsp' starting page</title>
    <script type="text/javascript">
    	function createActivity(){
    		window.location.replace("${pageContext.request.contextPath}/views/activity/createActivity.do");
    	}
    </script>
  </head>
  
  <body>
    This is my JSP page. <br>
    <button onclick="" >活动</button>
    <button type="button" onclick="createActivity()" >创建活动</button>
  </body>
</html>
