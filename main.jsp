<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'main.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <table>
    <tr>
    <th>序号</th>
    <th>名称</th>
    </tr>
    <c:forEach var="food" items="${userList }" varStatus="status">
    <tr>
    <td><c:out value="${status.index+1 }"></c:out></td>
    <td><a href="user/user_showDetail?user.userid=${user.userid }">
    <c:out value="${user.username }"></c:out></a></td>
    <td><c:out value="${user.unitprice }"></c:out></td>
    <td><a href="user/user_showEdit?user.userid=${user.userid }">编辑</a></td>
    <td><a href="user/user_deleteUser?user.userid=${user.userid }">删除</a></td>
    </tr>
    </c:forEach>
    </table>
  </body>
</html>
