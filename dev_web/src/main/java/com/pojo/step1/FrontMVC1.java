package com.pojo.step1;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.extern.log4j.Log4j2;

@Log4j2
/**
 * 개발자가 정의한 서블릿 - 표준 서블릿이 아니다.
 * doService 메서드는 요청처리에 대한 창구를 일원화 하기 위해 개발자가 정의한 메서드이다.
 * 따라서 request 객체와 response 객체를 톰캣 서버로부터 주입 받을 수 없다.
 * 이 문제 해결을 위해서 메서드 파라미터 자리에 이용하여 doGet이나 doPost메서드에서 주입받은
 * request 객체와 response객체를 넘겨 받아서 사용한다.
 * 
 * @author HOJAE
 *
 */
public class FrontMVC1 extends HttpServlet {
    
    /**
     * 이 메서드는 톰캣 서버로부터 직접 요청객체와 응답 객체를 주입받을 수 없다.
     * 따라서 doGet메서드와 doPost메서드 안에서 doService메서드를 호출할 때 파라미터로 넘겨받는다.
     * 
     * @param req
     * @param res
     * @throws ServletException
     * @throws IOException
     */
    protected void doService( HttpServletRequest req, HttpServletResponse res ) throws ServletException, IOException {
        log.info( "doService 호출" );
        
        String uri = req.getRequestURI();
        log.info( uri ); // /dept/getDeptList.st1
        String context = req.getContextPath(); // "/" -> server.xml
        log.info( context );
        // http://localhost:9000/dept/getDeptList.st1
        // http://localhost:9000/업무명폴더명/getDeptList.st1
        // http://localhost:9000/member/getMemberList.st1
        // http://localhost:9000/board/getBoardList.st1
        // http://localhost:9000/board/boardInsert.st1
        // http://localhost:9000/board/boardUpdate.st1
        // http://localhost:9000/board/boardDelete.st1
        
        String command = uri.substring( context.length() + 1 );
        log.info( command );
        
        int end = command.lastIndexOf( "." ); // st1을 잘라내기 위해서
        log.info( end );
        
        command = command.substring( 0, end );
        log.info( command );
        
        String[] task = null; // task[0] = 업무명|폴더명, task[1]=요청기능이름
        task = command.split( "/" );
        
        for ( String temp : task ) {
            log.info( temp );
        }
        
        // 게으른 인스턴스화 why? 아직 결정되지 않았다. - 업무명이 Controller class에 접두어이다.
        ActionForward  actionForward  = null;
        DeptController deptController = null;
        EmpController  empController  = null;
        
        // request객체는 저장소이다. - setAttribute, getAttribute
        req.setAttribute( "task", task );
        
        if ( "dept".equals( task[0] ) ) {
            // 인스턴스화 -> execute()호출하려구 -> 안하면 NullPointerException이니까 -> 500번
            deptController = new DeptController();
            /*
             * deptController는 서블릿이 아니어서 요청객체 req와 res를 톰캣 서버(WAS)로부터 주입받을 수 없다.
             *  why? HttpServlet을 상속받지 않았으니까
             *  이렇게 넘기지 않으면 DeptController에서는 req와 res를 누릴 수 없다.
             *  이런 이유로 메서드를 하나만 가질 수 있다. (장애)
             *  다른 메서드를 정의하는 것은 자유이지만 req와 res는 주입받을 수 없다.
             *  입력, 수정, 삭제, 조회 4가지 메서드가 필요하다.
             *  DeptLogic 메서드4가지를 호출해야 하는데 task[1]방에 정보가 필요하다.
             */
            actionForward = deptController.execute( req, res );
        }
        else if ( "emp".equals( task[0] ) ) {
            empController = new EmpController();
            actionForward = empController.execute( req, res );
        }
        
        // 페이지 이동 처리 공통코드 432만들기
        // 1. resp.sendRedirect("/dept/getDeptList.jsp"); jsp -> 서블릿 -> jsp
        // or resp.sendRedirect("/dept/getDeptList.st1"); jsp -> 서블릿 -> 서블릿 -> jsp
        if ( actionForward != null ) {
            
            if ( actionForward.isRedirect() ) {
                res.sendRedirect( actionForward.getPath() );
            }
            else {
                RequestDispatcher view = req.getRequestDispatcher( actionForward.getPath() );
                view.forward( req, res );
            }
        } // end of page 이동처리에 대한 공통 코드 부분
    }
    
    @Override
    protected void doGet( HttpServletRequest req, HttpServletResponse res ) throws ServletException, IOException {
        log.info( "doGet 호출" );
        doService( req, res );
    }
    
    @Override
    protected void doPost( HttpServletRequest req, HttpServletResponse res ) throws ServletException, IOException {
        log.info( "doPosts 호출" );
        doService( req, res );
    }
}
