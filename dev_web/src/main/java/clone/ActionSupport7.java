package clone;

import java.io.IOException;
import java.io.Serializable;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.extern.log4j.Log4j2;

@Log4j2
@WebServlet( "*.cl7" )
public class ActionSupport7 extends HttpServlet implements Serializable {
    
    private static final long serialVersionUID = -678469824396796137L;
    
    protected void doService( HttpServletRequest req, HttpServletResponse res ) throws Exception {
        
        String uri     = req.getRequestURI();
        String context = req.getContextPath();
        String command = uri.substring( context.length() + 1 );
        int    end     = command.lastIndexOf( "." );
        command = command.substring( 0, end );
        
        String[] task = command.split( "/" );
        
        req.setAttribute( "task", task );
        
        Object object = null;
        
        try {
            object = HandlerMapping7.getController( task, req, res );
        }
        catch ( Exception e ) {
            log.error( "", e );
        }
        
        if ( object != null ) {
            String[]      pageMove      = null;
            ModelAndView7 modelAndView7 = null;
            
            if ( object instanceof String ) {
                
                if ( ( ( String ) object ).contains( ":" ) ) {
                    pageMove = object.toString().split( ":" );
                }
                else {
                    pageMove = object.toString().split( "/" );
                }
                log.info( pageMove[0] + ", " + pageMove[1] );
            }
            else if ( object instanceof ModelAndView7 ) {
                modelAndView7 = ( ModelAndView7 ) object;
                pageMove = new String[2];
                pageMove[0] = "forward";
                pageMove[1] = modelAndView7.getViewName();
                
                log.info( "pageMove[1] = {}", pageMove[1] );
            }
            
            if ( pageMove != null ) {
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
            log.error( "", e );
        }
    }
    
    @Override
    protected void doPost( HttpServletRequest req, HttpServletResponse res ) throws ServletException, IOException {
        
        try {
            doService( req, res );
        }
        catch ( Exception e ) {
            log.error( "", e );
        }
    }
}
