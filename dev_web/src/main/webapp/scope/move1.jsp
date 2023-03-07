<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.book.scope.Sonata"%>
<%
Sonata             myCar   = ( Sonata ) request.getAttribute( "myCar" );
Sonata             herCar  = ( Sonata ) request.getAttribute( "herCar" );
Sonata             yourCar = ( Sonata ) session.getAttribute( "yourCar" );

String             pMyCar   = request.getParameter( "oMyCar" );
String             pHerCar  = request.getParameter( "oHerCar" );
String             pYourCar = request.getParameter( "oYourCar" );
out.print( "scope1.jsp에서 생성된 객체가 유지 되나요?" );
out.print( "<hr/>" );
out.print( "myCar = " + myCar + ", pMyCar = " + pMyCar );
out.print( "<hr/>" );
out.print( "herCar = " + herCar + ", pHerCar = " + pHerCar );
out.print( "<hr/>" );
out.print( "yourCar = " + yourCar + ", pYourCar = " + pYourCar );
%>

