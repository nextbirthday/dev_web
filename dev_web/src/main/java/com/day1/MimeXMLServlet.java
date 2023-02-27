package com.day1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.extern.log4j.Log4j2;

@SuppressWarnings( "serial" )
@Log4j2
@WebServlet( "/xml.do" ) // 웹에서 접근 가능한 맵핑 주소 설정
public class MimeXMLServlet extends HttpServlet {
    
    // 서블릿은 java인데 브라우저에 출력할 수 있다. - 화면을 그리는데 서블릿을 사용한다.
    
    @Override
    protected void doGet( HttpServletRequest req, HttpServletResponse res ) throws ServletException, IOException {
        log.info( "doGet 호출" );
        
        res.setContentType( "text/xml;charset=UTF-8" );
        // method를 통해서 객체 생성하는 코드 -
        PrintWriter writer = res.getWriter();
        
        StringBuilder stringBuilder = new StringBuilder();
        
        stringBuilder.append( "<records>" );
        stringBuilder.append( "<record>" );
        stringBuilder.append( "<mem_id>tomato</mem_id>" );
        stringBuilder.append( "<mem_pw>111</mem_pw>" );
        stringBuilder.append( "<mem_name>토마토</mem_name>" );
        stringBuilder.append( "</record>" );
        stringBuilder.append( "<record>" );
        stringBuilder.append( "<mem_id>banana</mem_id>" );
        stringBuilder.append( "<mem_pw>123</mem_pw>" );
        stringBuilder.append( "<mem_name>바나나</mem_name>" );
        stringBuilder.append( "</record>" );
        stringBuilder.append( "<record>" );
        stringBuilder.append( "<mem_id>kiwi</mem_id>" );
        stringBuilder.append( "<mem_pw>111157</mem_pw>" );
        stringBuilder.append( "<mem_name>키위</mem_name>" );
        stringBuilder.append( "</record>" );
        stringBuilder.append( "</records>" );
        
        writer.print( stringBuilder.toString() );
    }
    
}
