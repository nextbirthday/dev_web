<%@ page language="java" contentType="application/json; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page import="java.util.*, com.google.gson.Gson"%>

<%
List<Map<String, Object>>             memberList = new ArrayList<>();
Map<String, Object>                   map        = new HashMap<>();

map.put( "mem_id", "tomato" );
memberList.add( map );

map = new HashMap<>();
map.put( "mem_id", "apple" );
memberList.add( map );

map = new HashMap<>();
map.put( "mem_id", "banana" );
memberList.add( map );

//구글에서는 Gson.jar 라이브러리를 지원하고있다.
Gson               g    = new Gson();
String             temp = g.toJson( memberList );
out.print( temp );
//아래와같이 자료구조를 출력하면 JSON 포맷이 아니다. - 자바스크립트에서 읽을수가없다. - 조회결과 없음
//out.print( memberList );

%>

