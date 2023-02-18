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
@WebServlet( "/day1/html.do?gubun=2" ) // 웹에서 접근 가능한 맵핑 주소 설정
public class MimeHtmlServlet extends HttpServlet {
    
    // 서블릿은 java인데 브라우저에 출력할 수 있다. - 화면을 그리는데 서블릿을 사용한다.
    
    @Override
    protected void doGet( HttpServletRequest req, HttpServletResponse res ) throws ServletException, IOException {
        log.info( "doGet 호출" );
        String gubun = req.getParameter( "gubun" );
        
        if ( gubun == null ) {
            res.setContentType( "text/html;charset=UTF-8" );
            // method를 통해서 객체 생성하는 코드 -
            PrintWriter writer = res.getWriter();
            writer.print( "<h2>안녕</h2>" );
        }
        else {
            log.info( "doGet 호출" );
            res.sendRedirect( "./mimeHtmlResult.jsp" );
        }
        
    }
    
    @Override
    protected void doPost( HttpServletRequest req, HttpServletResponse res ) throws ServletException, IOException {
        log.info( "doPost 호출" );
    }
}
