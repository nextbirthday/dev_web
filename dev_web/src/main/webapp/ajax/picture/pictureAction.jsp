<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
// 스크립틀릿 - 자바 코드를 사용할 수 있다.
//http://localhost:9000/ajax/picture/b.jsp?id=3 or 4 
String id = request.getParameter( "id" );
out.print( id ); // 3 or 4

String[]             pics     = { "회의.jpg", "회의-1.jpg", "회의-2.jpg", "회의-3.jpg" };
String               newImage = null;

for ( int i = 0; i < pics.length; i++ ) {
    
    if ( Integer.parseInt( id ) == i ) {
        newImage = pics[i];
        
        //$('#imgDetail').attr('src', '../../images/sample/' + image); - 사용불가
    }
    
}
%>

<!-- HTML Area -->
<img id="imgDetail" src="../../images/sample/<%out.print(newImage);%>" width="400px" height="400px" alt="그림" />