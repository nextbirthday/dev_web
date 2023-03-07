package com.pojo.step3;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * javaScript 기반의 UI API
 * 바닐라 스크립트
 * React = 바닐라 스크립트 + ES6(주요 이슈 - spread, module), ES7 + html 섞어쓰기
 * 
 * @author HOJAE
 *
 */
public interface Controller3 {
    public Object boardList( HttpServletRequest req, HttpServletResponse res );
    
    public Object jsonBoardList( HttpServletRequest req, HttpServletResponse res );
    
    public Object boardDetail( HttpServletRequest req, HttpServletResponse res );
    
    public Object boardInsert( HttpServletRequest req, HttpServletResponse res ) throws ServletException, IOException;
    
    public Object boardUpdate( HttpServletRequest req, HttpServletResponse res ) throws ServletException, IOException;
    
    public Object boardDelete( HttpServletRequest req, HttpServletResponse res ) throws ServletException, IOException;
}
