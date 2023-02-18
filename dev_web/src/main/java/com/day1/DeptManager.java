package com.day1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dept.dto.Dept;
import dept.logic.DeptDAO;
import lombok.extern.log4j.Log4j2;

/*
 * 자바로는 웹 서비스가 불가능하다. why? request와 response가 없어서 안된다.
 * 왜냐하면 - http(s:security + 인증서) 프로토콜을 지원하는 API가 없으니까
 * 또 하나는 자바에는 URL(프로토콜://도메인:포트/경로/페이지 이름)을 등록할 수 없다.
 * 
 * Server + Applet (JFrame - html 태그에서 호출이 가능한 유일한 자바 클래스)
 * JSP container / Servlet container
 * 웹 페이지 출력이란?? 쓰기이다.
 * 
 * <request>
 * 
 * 요청 - 쿼리스트링 - GET방식 -> RESTful API [ GET, POST, PUT, DELETE ]
 * 
 * <response>
 * 
 * document.write("<b>asdsad</b>");
 * PrinWriter out = resq.getWriter();
 * out.print("<b>asdsad</b>");
 * 
 */
@SuppressWarnings( "serial" )
@Log4j2( topic = "dept" )
public class DeptManager extends HttpServlet {
    
    @Override
    public void doGet( HttpServletRequest req, HttpServletResponse resp ) throws ServletException, IOException {
        log.info( "[[[ doGet 호출 성공 ]]]" );
        
        String deptno = req.getParameter( "deptno" );
        String dname  = req.getParameter( "dname" );
        String loc    = req.getParameter( "loc" );
        log.info( deptno + ", " + dname + ", " + loc );
        resp.setContentType( "text/plain;charset=UTF-8" );
        PrintWriter out = resp.getWriter();
        out.print( deptno + ", " + dname + ", " + loc );
        
    }
    
    @Override
    public void doPost( HttpServletRequest req, HttpServletResponse resp ) throws ServletException, IOException {
        Dept dept = new Dept();
        dept.setDeptno( Integer.parseInt( req.getParameter( "deptno" ) ) );
        dept.setDname( req.getParameter( "dname" ) );
        dept.setLoc( req.getParameter( "loc" ) );
        
        int result = new DeptDAO().insertDept( dept );
        log.info( result );
        
        log.info( dept.toString() );
        
        log.info( "[[[ doPost 호출 성공 ]]]" );
    }
}
