package clone;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.extern.log4j.Log4j2;

@Log4j2
@SuppressWarnings( "serial" )
@WebServlet( "*.kh7" )
public class FrontController extends HttpServlet {
    
    private void doService( HttpServletRequest req, HttpServletResponse res ) throws ServletException, IOException {
        log.info( "doService 호출" );
        
        String uri = req.getRequestURI();
        log.info( uri );
        String context = req.getContextPath();
        log.info( context );
        
        String command = uri.substring( 1 );
        log.info( command );
        
        int end = command.lastIndexOf( "." );
        log.info( end );
        
        command = command.substring( 0, end );
        log.info( command );
        
        String[] task = command.split( "/" );
        
        for ( String temp : task ) {
            log.info( temp );
        }
        ActionForward  actionForward = null;
        DeptController deptController;
        EmpController  empController;
        
        req.setAttribute( "task", task );
        
        if ( "dept".equals( task[0] ) ) {
            deptController = new DeptController();
            actionForward = deptController.execute( req, res );
        }
        else if ( "emp".equals( task[0] ) ) {
            empController = new EmpController();
            actionForward = empController.execute( req, res );
        }
        
        if ( actionForward != null ) {
            
            if ( actionForward.isRedirect() ) {
                res.sendRedirect( actionForward.getPath() );
            }
            else {
                RequestDispatcher view = req.getRequestDispatcher( actionForward.getPath() );
                view.forward( req, res );
            }
        }
    }
    
    @Override
    protected void doGet( HttpServletRequest req, HttpServletResponse res ) throws ServletException, IOException {
        doService( req, res );
    }
    
    @Override
    protected void doPost( HttpServletRequest req, HttpServletResponse res ) throws ServletException, IOException {
        doService( req, res );
    }
}
