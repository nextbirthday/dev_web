<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.Map"%>

<%
// 테스트 시나리오 서블릿을 경유하여 forward 메서드 호출의 결과 페이지로 b.jsp가 출력될 때 
// map이 null이 아니므로 주의할것 즉 b.jsp페이지를 직접 호출하면 출력값은 null이 될것이다.
Map<String, Object> map = ( Map<String, Object> ) request.getAttribute( "map" );

if ( map != null ) {
    
    Object[] keys = map.keySet().toArray();
    
    for ( int i = 0; i < keys.length; i++ ) {
        out.print( "<font size=36px color=violet>" + map.get( keys[i] ) + "</font>" );
    }
}
%>

<%=map.get( "id" )%>

<!-- 200번이면 성공
     300번이면 재요청
     400번 - 클라이언트측 실수 에러
     500번 - 서버에러

 -->
