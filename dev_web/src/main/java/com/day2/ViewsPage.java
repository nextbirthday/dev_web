package com.day2;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet( "/day2/b" )
public class ViewsPage extends HttpServlet {
    
    private static final long serialVersionUID = 1L;
    
    @Override
    protected void doGet( HttpServletRequest req, HttpServletResponse resp ) throws ServletException, IOException {
        String path = "b";
        
        RequestDispatcher view = req.getRequestDispatcher( "/WEB-INF/views/day2/" + path + ".jsp" );
        view.forward( req, resp );
    }
    
    @Override
    protected void doPost( HttpServletRequest req, HttpServletResponse resp ) throws ServletException, IOException {
        
    }
}
