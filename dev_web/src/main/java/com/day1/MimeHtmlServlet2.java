package com.day1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lombok.extern.log4j.Log4j2;

@SuppressWarnings( "serial" )
@Log4j2
@WebServlet( "/day1/html.do" ) // 웹에서 접근 가능한 맵핑 주소 설정
public class MimeHtmlServlet2 extends HttpServlet {
    
    // 서블릿은 java인데 브라우저에 출력할 수 있다. - 화면을 그리는데 서블릿을 사용한다.
    // 서블릿을 경유하여 응답페이지를 jsp로 가져가는 실습이다.
    // 최초 mimiHtmlResult.jsp를 직접 호출하는 것이 아니라
    // 즉 @WebServlet( "/day1/html.do" )로 요청 했을 때, URL로 요청 했을 때
    // res.sendRedirect( "./mimeHtmlResult.jsp" );를 만나서 mimeHtmlResult.jsp로 주소창이 변경되는 것을 관찰한 뒤
    // 서블릿에서 세션에 담은 정보를 mimeHtmlResult.jsp 페이지에서 유지되는지 확인하는 실습이다.
    @Override
    protected void doGet( HttpServletRequest req, HttpServletResponse res ) throws ServletException, IOException {
        log.info( "doGet 호출" );
        
        // 요청 객체로 세션 객체를 생성함
        // 시간을 연장할 수 있다.
        // 서블릿에서는 객체의 유지 정도가 다르다?
        // scope가 지원된다.
        // page scope - 그 페이지 안에서만 기억해준다. -쓰레기
        // request scope - 요청이 유지되는 동안에만 유지된다. - URL주소가 그대로이면 유지 바뀌면 잃어버림.
        // session scope - URL주소가 바뀌어도 유지된다. - 톰캣 기본 30분
        // application scope - phoenix - 사용하면 안된다.(서버가 다운됨.)
        HttpSession               session    = req.getSession();
        String                    name       = new String( "이순신" );
        int                       age        = 33;
        Map<String, Object>       rMap       = null;
        List<Map<String, Object>> memberList = new ArrayList<>();
        
        if ( rMap != null ) {
            rMap.clear();
        }
        rMap = new HashMap<>();
        rMap.put( "mem_id", "tomato" );
        rMap.put( "mem_pw", "111" );
        rMap.put( "mem_name", "토마토" );
        memberList.add( rMap );
        
        rMap = new HashMap<>();
        rMap.put( "mem_id", "banana" );
        rMap.put( "mem_pw", "123" );
        rMap.put( "mem_name", "바나나" );
        memberList.add( rMap );
        
        rMap = new HashMap<>();
        rMap.put( "mem_id", "kiwi" );
        rMap.put( "mem_pw", "12345" );
        rMap.put( "mem_name", "키위" );
        memberList.add( rMap );
        session.setAttribute( "name", name );
        session.setAttribute( "age", age );
        session.setAttribute( "rMap", rMap );
        session.setAttribute( "memberList", memberList );
        res.sendRedirect( "./mimeHtmlResult.jsp" );
    }
}
