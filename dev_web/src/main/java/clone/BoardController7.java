package clone;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.net.httpserver.Authenticator.Result;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class BoardController7 implements Controller7 {
    
    BoardLogic7   boardLogic7 = new BoardLogic7();
    ModelAndView7 modelAndView7;
    String        path;
    
    @Override
    public ModelAndView7 boardList( HttpServletRequest req, HttpServletResponse res ) {
        Map<String, Object> pMap = new HashMap<>();
        
        HashMapBinder7 hashMapBinder7 = new HashMapBinder7( req );
        hashMapBinder7.bind( pMap );
        
        log.info( pMap );
        
        List<Map<String, Object>> boardList = boardLogic7.boardList( pMap );
        
        modelAndView7 = new ModelAndView7( req );
        modelAndView7.addObject( "boardList", boardList );
        modelAndView7.setViewName( "board7/boardList" );
        
        log.info( boardList );
        
        return modelAndView7;
    }
    
    @Override
    public Object jsonBoardList( HttpServletRequest req, HttpServletResponse res ) {
        
        Map<String, Object>       pMap      = new HashMap<>();
        List<Map<String, Object>> boardList = boardLogic7.boardList( pMap );
        log.info( pMap );
        
        modelAndView7 = new ModelAndView7( req );
        modelAndView7.addObject( "boardList", boardList );
        modelAndView7.setViewName( "board7/jsonBoardList" );
        
        log.info( boardList );
        
        return modelAndView7;
    }
    
    @Override
    public Object boardDetail( HttpServletRequest req, HttpServletResponse res ) {
        
        Map<String, Object> pMap = new HashMap<>();
        
        HashMapBinder7 hashMapBinder7 = new HashMapBinder7( req );
        hashMapBinder7.bind( pMap );
        
        log.info( pMap );
        List<Map<String, Object>> boardList = boardLogic7.boardList( pMap );
        
        log.info( boardList );
        
        modelAndView7 = new ModelAndView7( req );
        modelAndView7.addObject( "boardList", boardList );
        modelAndView7.setViewName( "board7/boardDetail" );
        
        return modelAndView7;
    }
    
    @Override
    public Object boardInsert( HttpServletRequest req, HttpServletResponse res ) throws ServletException, IOException {
        
        Map<String, Object> pMap           = new HashMap<>();
        HashMapBinder7      hashMapBinder7 = new HashMapBinder7( req );
        hashMapBinder7.bind( pMap );
        
        int result = boardLogic7.boardInsert( pMap );
        
        if ( result == 1 ) {
            path = "redirect:/board7/boardList.cl7";
        }
        else {
            path = "boardFail.jsp";
            res.sendRedirect( path );
        }
        
        return path;
    }
    
    @Override
    public Object boardUpdate( HttpServletRequest req, HttpServletResponse res ) throws ServletException, IOException {
        
        return null;
    }
    
    @Override
    public Object boardDelete( HttpServletRequest req, HttpServletResponse res ) throws ServletException, IOException {
        return null;
    }
    
}
