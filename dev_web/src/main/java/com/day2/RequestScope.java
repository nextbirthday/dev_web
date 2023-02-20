package com.day2;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.extern.log4j.Log4j2;

@WebServlet( "/day2/a" )
@Log4j2
public class RequestScope extends HttpServlet {
    
    // http://localhost:9000/day2/a로 요청을 하면 RequestScope 서블릿 클래스의 doGet메서드가 호출되고
    // doGet 메서드 안에서 sendRedirect대신에 forward 메서드가 호출되므로 주소는 그대로 http://localhost:9000/day2/a을
    // 가리키고 있는데 실제 출력 페이지는 http://localhost:9000/day2/b.jsp를 찾고 있다.
    // 이것이 sendRedirect("b.jsp")로 이동할 때와 forward로 이동할 때 차이점이 있다.
    // sendRedirect로 페이지 이동시에는 값을 유지하려면 쿠키나 세션을 사용해야 하지만 forward로 이동시에는
    // forward 메서드 호출시 첫번째 파라미터인 request객체에 담아서 넘길(유지시킬)수 있다.
    private static final long serialVersionUID = 1L;
    
    @Override
    protected void doGet( HttpServletRequest req, HttpServletResponse resp ) throws ServletException, IOException {
        log.info( "doGet 호출" );
        // HttpSession session = req.getSession();
        Map<String, Object> map = new HashMap<>();
        map.put( "id", 33344 );
        map.put( "category", "주류" );
        map.put( "name", "테라" );
        
        req.setAttribute( "map", map );
        // 페이지는 호출이되지만 주소창은 바뀌지 않는다.
        RequestDispatcher view = req.getRequestDispatcher( "b.jsp" );
        // day2/a로 요청한 경우 doGet메서드를 경유하게 되고 이 요청을 받았을 때 톰캣으로 부터 서블릿이 생성되고
        // 그 서블릿은 요청객체와 응답객체를 갖게 되는데 b.jsp페이지에서 응답이 나갈 때 파라미터에 요청객체 원본이 전달되니까
        // 화면에서도 그 값을 공유할 수 있다.
        view.forward( req, resp );
        log.info( view );
    }
    
    @Override
    protected void doPost( HttpServletRequest req, HttpServletResponse resp ) throws ServletException, IOException {
        
    }
    
}
