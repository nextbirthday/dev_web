<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
/* 스크립틀릿 선언 - 자바영역 */
/* <Input type = "text" name="mem_id"> */
String mem_id = request.getParameter( "mem_id" ); /* 여기에 사용되는 속성이 name이다.(중요) */
/* tomato 이것은 로컬이 아니라 브라우저에 출력된다. (여기의 자바는 서블릿이다.) */
out.print( "사용자가 입력한 아이디 ===> " + mem_id + "\n" );
String mem_pw = request.getParameter( "mem_pw" );
out.print( "사용자가 입력한 비밀번호 ===> " + mem_pw );
String mem_name = request.getParameter( "mem_name" );
out.print( "사용자가 입력한 이름 ===> " + mem_name );
%>