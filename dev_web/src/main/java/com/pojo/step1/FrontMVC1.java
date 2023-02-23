package com.pojo.step1;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class FrontMVC1 extends HttpServlet {
    
    protected void doService( HttpServletRequest req, HttpServletResponse resp ) throws ServletException, IOException {
        log.info( "doService 호출" );
    }
    
    @Override
    protected void doGet( HttpServletRequest req, HttpServletResponse resp ) throws ServletException, IOException {
        doService( req, resp );
    }
    
    @Override
    protected void doPost( HttpServletRequest req, HttpServletResponse resp ) throws ServletException, IOException {
        doService( req, resp );
    }
}
