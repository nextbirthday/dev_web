package com.pojo.step2;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.extern.log4j.Log4j2;

@Log4j2
@WebServlet( "*.st2" )
public class ActionServlet extends HttpServlet {
    
    private static final long serialVersionUID = 1L;
    
    protected void doService( HttpServletRequest req, HttpServletResponse res ) throws Exception {
        log.info( "doService 호출" );
        
        String uri     = req.getRequestURI();
        String context = req.getContextPath();
        String command = uri.substring( context.length() + 1 );
        int    end     = command.lastIndexOf( "." );
        command = command.substring( 0, end );
        
        String[] task = command.split( "/" );
        
        req.setAttribute( "task", task );
        
        log.info( "task[0] = " + task[0] + ", task[1] = " + task[1] );
        
        BoardController2 boardController2 = new BoardController2();
        Object           object           = null;
        object = boardController2.execute( req, res );
        
        log.info( object.toString() );
        
        if ( object != null ) { // redirect:XXX.jsp or forward:XXX.jsp
            String[] pageMove = null;
            
            if ( object instanceof String ) {
                
                if ( ( ( String ) object ).contains( ":" ) ) {
                    log.info( ": 포함되어 있어요." );
                    pageMove = object.toString().split( ":" );
                }
                else {
                    log.info( ": 포함되어 있지 않아요." );
                    pageMove = object.toString().split( "/" );
                }
                log.info( pageMove[0] + ", " + pageMove[1] );
            }
            
            if ( pageMove != null ) {
                // pageMove[0] = redirect or forward & pageMove[1] = XXX.jsp
                String path = pageMove[1];
                
                if ( "redirect".equals( pageMove[0] ) ) {
                    res.sendRedirect( path );
                }
                else if ( "forward".equals( pageMove[0] ) ) {
                    RequestDispatcher view = req.getRequestDispatcher( "/" + path + ".jsp" );
                    view.forward( req, res );
                }
                else {
                    path = pageMove[0] + "/" + pageMove[1];
                    RequestDispatcher view = req.getRequestDispatcher( "/WEB-INF/view/" + path + ".jsp" );
                    view.forward( req, res );
                }
            }
        }
    }
    
    @Override
    protected void doGet( HttpServletRequest req, HttpServletResponse res ) throws ServletException, IOException {
        
        try {
            doService( req, res );
        }
        catch ( Exception e ) {
            log.error( "{}" + e );
        } // 브라우저의 주소창을 통해 요청하는 건 모두 GET방식이다. - doGet()호출
    }
    
    @Override
    protected void doPost( HttpServletRequest req, HttpServletResponse res ) throws ServletException, IOException {
        
        try {
            doService( req, res );
        }
        catch ( Exception e ) {
            log.error( "{}" + e );
        }
    }
    
}
