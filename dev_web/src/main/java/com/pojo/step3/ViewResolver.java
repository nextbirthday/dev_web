package com.pojo.step3;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class ViewResolver {
    
    public ViewResolver() {}
    
    public ViewResolver( HttpServletRequest req, HttpServletResponse res, String[] pageMove )
                    throws ServletException, IOException {
        
        String path = pageMove[1];
        
        log.info( "path = {} ", path );
        
        if ( "redirect".equals( pageMove[0] ) ) {
            res.sendRedirect( path );
        }
        else if ( "forward".equals( pageMove[0] ) ) {
            RequestDispatcher view = req.getRequestDispatcher( "/" + path + ".jsp" );
            view.forward( req, res );
        }
        else {
            path = pageMove[0] + "/" + pageMove[1];
            RequestDispatcher view = req.getRequestDispatcher( "/WEB-INF/views/" + path + ".jsp" );
            view.forward( req, res );
        }
    } // end of VierResolver Constructor( req, res, pageMove)
}
