<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List, java.util.ArrayList"%>

<%!int index = 1;
    
    private String newsItem( String[] newsList ) {
        
        StringBuilder sb = new StringBuilder();
        
        for ( int i = 0; i < newsList.length; i++ ) {
            
            if ( i == ( index - 1 ) ) {
                sb.append( "<table width='500px' border='1'>" );
                sb.append( "<tr><td>" + newsList[index - 1] + "</td></tr>" );
                sb.append( "</table>" );
            }
        }
        
        String choice = sb.toString();
        return choice;
    }%>



<%
String[] news = { " '도이치모터스 주가조작' 권오수 집유·벌금 3억원", "與 김기현·안철수 '내가 대세'…천하람·황교안 '이제 시작'", "[튀르키예 강진] 끝모를 사망자수…야외 주차장이 시신 안치소로",
        "K팝 시장 '메가톤급 폭풍'…하이브·SM 시너지 기대 속 우려", "野, '곽상도 무죄' 맹공…대장동·김건희 특검 '쌍끌이 공세'" };

String data = "";

switch ( index ) {
    
    case 1:
        data = newsItem( news );
        index++;
        break;
    
    case 2:
        data = newsItem( news );
        index++;
        break;
    
    case 3:
        data = newsItem( news );
        index++;
        break;
    
    case 4:
        data = newsItem( news );
        index++;
        break;
    
    case 5:
        data = newsItem( news );
        index++;
        break;
}

// 기존에 읽어온 기사 정보 지우기
out.clear();
out.print( data );
%>