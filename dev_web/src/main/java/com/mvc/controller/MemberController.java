package com.mvc.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mvc.dao.MemberDao;

import lombok.extern.log4j.Log4j2;

@Log4j2
@WebServlet( "/intro/login" )
public class MemberController extends HttpServlet {
    
    private static final long serialVersionUID = 1L;
    
    @Override
    protected void doGet( HttpServletRequest req, HttpServletResponse resp ) throws ServletException, IOException {
        
        log.info( "doGet" );
        
        HttpSession session   = req.getSession();
        MemberDao   memberDao = new MemberDao();
        String      mem_id    = req.getParameter( "mem_id" );
        String      mem_pw    = req.getParameter( "mem_pw" );
        
        Map<String, Object> pmap = new HashMap<>();
        pmap.put( "mem_id", mem_id );
        pmap.put( "mem_pw", mem_pw );
        Map<String, Object> rmap = memberDao.signIn( pmap );
        log.info( rmap );
        session.setAttribute( "smem_id", rmap.get( "MEM_ID" ) );
        session.setAttribute( "smem_name", rmap.get( "MEM_NAME" ) );
        resp.sendRedirect( "./index.jsp" );
    }
    
    @Override
    protected void doPost( HttpServletRequest req, HttpServletResponse resp ) throws ServletException, IOException {
        
        log.info( "doPost" );
        
        HttpSession session   = req.getSession();
        MemberDao   memberDao = new MemberDao();
        String      mem_id    = req.getParameter( "mem_id" );
        String      mem_pw    = req.getParameter( "mem_pw" );
        
        Map<String, Object> pmap = new HashMap<>();
        pmap.put( "mem_id", mem_id );
        pmap.put( "mem_pw", mem_pw );
        Map<String, Object> rmap = memberDao.signIn( pmap );
        log.info( rmap );
        session.setAttribute( "smem_id", rmap.get( "MEM_ID" ) );
        session.setAttribute( "smem_name", rmap.get( "MEM_NAME" ) );
        resp.sendRedirect( "./index.jsp" );
    }
    
}
