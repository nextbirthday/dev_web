package com.pojo.step3;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.util.HashMapBinder;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class BoardController3 implements Controller3 {
    
    BoardLogic3 boardLogic3 = new BoardLogic3();
    String      path;
    
    /**
     * 사용자가 조건 검색을 원하는 경우 - 조건 값을 전달할 객체(Object)를 생성한다.
     * MyBatis에서는 동적 쿼리를 지원하므로 하나로 2가지 경우 사용 가능하다.
     */
    @Override
    public ModelAndView boardList( HttpServletRequest req, HttpServletResponse res ) {
        
        Map<String, Object> pMap          = new HashMap<>();
        HashMapBinder       hashMapBinder = new HashMapBinder( req );
        hashMapBinder.bind( pMap );
        log.info( "pMap = {} ", pMap );
        
        List<Map<String, Object>> boardList = boardLogic3.boardList( pMap );
        log.info( "boardList = {} ", boardList );
        
        ModelAndView modelAndView = new ModelAndView( req );
        modelAndView.addObject( "boardList", boardList );
        modelAndView.setViewName( "board3/boardList" );
        
        return modelAndView;
    }
    
    @Override
    public Object jsonBoardList( HttpServletRequest req, HttpServletResponse res ) {
        
        Map<String, Object>       pMap      = new HashMap<>();
        List<Map<String, Object>> boardList = boardLogic3.boardList( pMap );
        
        req.setAttribute( "boardList", boardList );
        return "forward:board3/jsonBoardList";
    }
    
    @Override
    public Object boardDetail( HttpServletRequest req, HttpServletResponse res ) {
        
        Map<String, Object> pMap          = new HashMap<>();
        HashMapBinder       hashMapBinder = new HashMapBinder( req );
        hashMapBinder.bind( pMap );
        log.info( "pMap = {} ", pMap );
        
        List<Map<String, Object>> boardList = boardLogic3.boardList( pMap );
        
        req.setAttribute( "boardList", boardList );
        
        return "forward:board3/boardDetail";
    }
    
    /**
     * INSERT INTO BOARD_MASTER_T(BM_NO, BM_TITLE, BM_WRITER, BM_CONTENT, BM_REG, BM_HIT, BM_PW,
     * BM_GROUP, BM_POS, BM_STEP )
     * VALUES(#{bm_no}, #{bm_title}, #{bm_writer}, #{bm_content}, to_char(sysdate, 'YYYY-MM-DD'), 0, #{bm_pw}
     * , #{bm_group}, #{bm_pos}, #{bm_step})
     * 
     * 화면에서 받아올 값 - BM_TITLE , BM_WRITER, BM_CONTENT, BM_PW
     * 그렇지 않은 경우 - BM_GROUP, BM_POS, BM_STEP, BM_REG
     */
    @Override
    public Object boardInsert( HttpServletRequest req, HttpServletResponse res ) throws ServletException, IOException {
        log.info( "boardInsert" );
        
        HashMapBinder       hashMapBinder = new HashMapBinder( req );
        Map<String, Object> pMap          = new HashMap<>();
        hashMapBinder.bind( pMap );
        log.info( "pMap = {} ", pMap );
        
        int result = boardLogic3.boardInsert( pMap );
        log.info( "result = {} ", result );
        
        if ( result == 1 ) {
            path = "redirect:/board3/boardList.st3";
        }
        else {
            path = "redirect:/board3/boardFail.jsp";
            res.sendRedirect( path );
        }
        
        return path;
    }
    
    @Override
    public Object boardUpdate( HttpServletRequest req, HttpServletResponse res ) throws ServletException, IOException {
        
        HashMapBinder       hashMapBinder = new HashMapBinder( req );
        Map<String, Object> pMap          = new HashMap<>();
        hashMapBinder.bind( pMap );
        log.info( "pMap = {} ", pMap );
        
        int result = boardLogic3.boardMUpdate( pMap );
        log.info( "result = {} ", result );
        
        if ( result == 1 ) {
            path = "redirect:/board3/boardList.st3";
        }
        else {
            path = "redirect:/board3/boardFail.jsp";
            res.sendRedirect( path );
        }
        
        return path;
    }
    
    @Override
    public Object boardDelete( HttpServletRequest req, HttpServletResponse res ) throws ServletException, IOException {
        
        HashMapBinder       hashMapBinder = new HashMapBinder( req );
        Map<String, Object> pMap          = new HashMap<>();
        hashMapBinder.bind( pMap );
        log.info( "pMap = {} ", pMap );
        
        int result = boardLogic3.boardMDelete( pMap );
        log.info( "result = {} ", result );
        
        if ( result == 1 ) {
            path = "redirect:/board3/boardList.st3";
        }
        else {
            path = "redirect:/board3/boardFail.jsp";
            res.sendRedirect( path );
        }
        
        return path;
    }
    
}
