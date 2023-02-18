<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
String             user_id      = request.getParameter( "user_id" );
String             user_pw      = request.getParameter( "user_pw" );
String             user_birth   = request.getParameter( "user_birth" );
String             user_address = request.getParameter( "user_address" );

out.print( user_id );
out.print( user_pw );
out.print( user_birth );
out.print( user_address );
%>
