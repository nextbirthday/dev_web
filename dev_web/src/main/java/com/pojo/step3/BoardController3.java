package com.pojo.step3;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class BoardController3 implements Controller3 {
    
    BoardLogic3 boardLogic3 = new BoardLogic3();
    
    @Override
    public ModelAndView boardList( HttpServletRequest req, HttpServletResponse res ) {
        log.info( "boardList" );
        List<Map<String, Object>> boardList = null;
        boardList = boardLogic3.boardList();
        
        return null;
    }
    
    @Override
    public Object boardDetail( HttpServletRequest req, HttpServletResponse res ) {
        log.info( "boardDetail" );
        return null;
    }
    
    @Override
    public Object boardInsert( HttpServletRequest req, HttpServletResponse res ) {
        log.info( "boardInsert" );
        return null;
        
    }
    
    @Override
    public Object boardUpdate( HttpServletRequest req, HttpServletResponse res ) {
        log.info( "boardUpdate" );
        return null;
    }
    
    @Override
    public Object boardDelete( HttpServletRequest req, HttpServletResponse res ) {
        log.info( "boardDelete" );
        return null;
    }
    
}
