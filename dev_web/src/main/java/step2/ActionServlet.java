package step2;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.extern.log4j.Log4j2;

@Log4j2
@WebServlet( "*.tj" )
public class ActionServlet extends HttpServlet {
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
        
        BoardController boardController = new BoardController();
        Object          object          = null;
        object = boardController.execute( req, res );
        
        log.info( object.toString() );
        
        if ( object != null ) {
            
            String[] pageMove = null;
            
            if ( object instanceof String ) {
                
                if ( ( ( String ) object ).contains( ":" ) ) {
                    log.info( ": 포함" );
                    pageMove = object.toString().split( ":" );
                }
                else if ( ( ( String ) object ).contains( "#" ) ) {
                    log.info( "# 포함" );
                    pageMove = object.toString().split( "#" );
                    log.info( "pageMove[0] = " + pageMove[0] + ", pageMove[1] = " + pageMove[1] );
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
        }
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
