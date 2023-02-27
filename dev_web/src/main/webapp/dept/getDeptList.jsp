<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.Map, java.util.List"%>
<!DOCTYPE html>
<%
List<Map<String, Object>> deptList = ( List<Map<String, Object>> ) request.getAttribute( "deptList" );
out.print(deptList);
%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <h1>getDeptList.jsp</h1>
</body>
</html>