<%@ page language="java" contentType="application/json; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>

<%
/* jsp페이지이지만 page directive에 마임타입을 application/json으로 되어 있어서 
브라우저는 이 페이지를 json 포맷으로 인지한다. */
String jsonDeptList = ( String ) request.getAttribute( "jsonDeptList" );
out.print( jsonDeptList );
%>
