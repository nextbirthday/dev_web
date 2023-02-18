package com.mvc.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.dao.TestDao;

import lombok.extern.log4j.Log4j2;

@Log4j2( topic = "test" )
public class TestServlet extends HttpServlet {
    
    private static final long serialVersionUID = 1L;
    
    /**
     * 사용자 정의 메서드
     * 
     * @param req
     * @param res
     * @throws ServletException
     * @throws IOException
     */
    public void doService( HttpServletRequest req, HttpServletResponse res ) throws ServletException, IOException {
        log.info( "TestServlet doService 호출" );
        // log.debug( "TestServlet doService 호출" );
        // log.error( "TestServlet doService 호출" );
        TestDao testDao = new TestDao();
        // String currentTime = testDao.testDate();
        // log.info( "TestServlet doService : " + currentTime );
        
        List<Map<String, Object>> tempList = testDao.getBookMember();
        // 페이지 이동, 페이지 이름 getMemberList.jsp
        // 페이지의 물리적인 경로는 어디를 바라보고 있는가? -> web.xml -> servlet-mapping -> url-pattern
        // 경로명 / 요청을 처리하는이름.do
        // [뒤에 온 확장자는 의미없다 - why? 해당 요청을 인터셉트해서 해당 업무를 담당하는 클래스에 연결을 해야한다.]
        // 클래스에 연결 (FrontController.java 설계 - 각 업무별 XXXController 필요함)을 해야함
        // 페이지 처리는 JSP에게 맡김
        // 서블릿은 요청을 받아서 업무 담당자한테 연결(매핑, 매칭)
        // 이것을 어떻게 나눌것인가?
        // 요청은 업무담당자나 사용자 선택에 따라 결정
        // 결정에 대응하는 클래스를 FrontController 연결
        // FrontController에서 실제 업무를 담당하는 XXXController에 전달할 때
        // 요청객체와 응답객체 또한 전달이 되어야 한다.
        // 요청 객체 무엇을 누릴 수 있나?
        // 사용자가 입력한 값을 듣기 위해 필요하다.
        // getParameter("") return String, getAttribute("") return Object
        // request.getParameter("XXX"); ex)id, pw, name, address ...
        // HttpSession session = request.getSession(); -> 세션 객체 생성
        // http 프로토콜이 비상태 프로토콜이므로 상태값을 관리하는 별도의 메커니즘이 필요하다.
        // 쿠키와 세션(시간을 지배한다.) <- List, Map <- 객체배열[{}] <- 배열 <- 원시형 타입(변수)
        
        // response
        // response.setContentType(): 마임타입을 결정한다.
        // 서블릿인데 json, 서블릿인데 html, 서블릿인데 xml
        // response.setContentType("application/json")
        // response.setContentType("text/html")
        // response.setContentType("text/xml")
        // response.setContentType("text/css")
        // response.sendRedirect("페이지 이름") -> 페이지 이동이 일어난다.
        // 주소창이 바뀐다. -> 기존의 요청이 끊어지고 새로운 요청이 발생함
        // 그런데 마치 계속 유지하고 있는것처럼 보여져야 한다. -> 그러니까 쿠키나 세션에 담아둔다. why? 비상태 프로토콜이니까
        // 쿠키 - 문자열 - 객체는 못받음
        // 세션 - 캐시메모리 - 객체 - very good
        // 아래코드를 만나기 전까지는 http://locaclhost:9000/test/test.do를 보여주다가
        // 아래 코드를 만나면 http://locaclhost:9000/test/getMemberList.jsp를 요청함
        
        // 테스트 시나리오
        // 방법: TestServlet.java 소스에서 오른쪽 버튼 눌러서 Run on server 
        // 방법: http://locaclhost:9000/test/test.do
        res.sendRedirect( "./getMemberList.jsp" );
    }
    
    @Override
    public void doGet( HttpServletRequest req, HttpServletResponse res ) throws ServletException, IOException {
        log.info( "TestServlet doGet 호출" );
        doService( req, res );
    }
    
    @Override
    public void doPost( HttpServletRequest req, HttpServletResponse res ) throws ServletException, IOException {
        log.info( "TestServlet doPost 호출" );
    }
    
}
