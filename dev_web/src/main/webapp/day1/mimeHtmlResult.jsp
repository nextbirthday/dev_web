<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.Map, java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>mimeHtmlResult</title>
</head>
<body>
  <h1>그리운 연진에게..</h1>
  <%
  /* 스크립틀릿 안에서 선언한 변수는 지역변수이다. */
  /* 왜냐하면 a.jsp -> a_jsp.java -> service메서드 안에 들어간다. */
  String name = null;
  name = ( String ) session.getAttribute( "name" );

  Integer age;
  age = ( Integer ) session.getAttribute( "age" );

  Map<String, Object> rMap = ( Map<String, Object> ) session.getAttribute( "rMap" );

  if ( rMap != null ) { //NullPointerException 방어코드
      Object[] keys = rMap.keySet().toArray();
      
      for ( int i = 0; i < keys.length; i++ ) {
          /* out.print( rMap.get( keys[i] ) ); */
      }
  }

  /*   out.print( "<h1>" + name + "</h1>" );
    out.print( "<hr>" );
    out.print( "<h1>" + age + "</h1>" );
    out.print( "<hr>" );
    out.print( "<h1>" + rMap + "</h1>" );
    out.print( "<hr>" ); */

  List<Map<String, Object>> memberList = ( List<Map<String, Object>> ) session.getAttribute( "memberList" );

  if ( memberList != null ) {
      
      for ( int x = 0; x < memberList.size(); x++ ) {
          Map<String, Object> temp = memberList.get( x );
          
          out.print( "<h2>" + temp.get( "mem_id" ) + ", " + temp.get( "mem_pw" ) + ", " + temp.get( "mem_name" )
                  + "</h2>" );
          out.print( "<hr>" );
          
          out.print( "<h2>" + temp + "</h2>" );
          out.print( "<hr>" );
      }
  }
  %>
</body>
</html>