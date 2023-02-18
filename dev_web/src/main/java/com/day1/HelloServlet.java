package com.day1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.extern.log4j.Log4j2;

@SuppressWarnings( "serial" )
@Log4j2
public class HelloServlet extends HttpServlet {
    
    @Override
    public void doGet( HttpServletRequest req, HttpServletResponse resp ) throws ServletException, IOException {
        log.info( "doGet 호출 성공" );
        resp.setContentType( "text/html;charset=UTF-8" );
        // 인스턴스화에서 메서드를 사용하는 경우는 뭐가 다른걸까요 ?
        PrintWriter out     = resp.getWriter();
        String      message = "hello world";
        String      mem_id  = req.getParameter( "mem_id" );
        log.info( mem_id );
        // 브라우저에서 요청 [GET 방식]시 응답으로 나가는 문자열
        // 문자열
        // 1.텍스트파일: 숫자의 경우 문자로 변환 후 쓴다.
        // 2.바이너리 파일: 데이터를 있는 그대로 읽고 쓴다.
        // text 메인타입 html 서브타입 - 브라우저 번역 - 태그는 없고 내용만 출력
        out.print( "<font size=36px color=violet>" + message + "</font>" );
    }
    
    // 단위테스트가 불가능하다. - Postman 사용하면 가능하다.
    // post 방식은 브라우저를 통해서 테스트가 불가능하다.
    public void doPost( HttpServletRequest req, HttpServletResponse resp ) throws ServletException, IOException {
        log.info( "doPost 호출 성공" );
        
        resp.setContentType( "text/html;charset=UTF-8" );
        PrintWriter out     = resp.getWriter();
        String      message = "hello world";
        out.print( "<font size=36px color=violet>" + message + "</font><br/>" );
        out.print( "<font size=36px color=violet>doPOST</font>" );
    }
}
