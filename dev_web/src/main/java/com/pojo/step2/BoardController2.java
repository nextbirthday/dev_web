package com.pojo.step2;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class BoardController2 implements Controller {
    
    BoardLogic2 boardLogic2 = new BoardLogic2();
    
    @Override
    public String execute( HttpServletRequest req, HttpServletResponse res ) throws Exception {
        
        log.info( "execute 호출" );
        
        String[] task = ( String[] ) req.getAttribute( "task" );
        String   page = null;
        
        if ( "boardList".equals( task[1] ) ) {
            log.info( "게시글 목록 보기" );
            List<Map<String, Object>> boardList = boardLogic2.boardList();
            req.setAttribute( "boardList", boardList );
            page = "forward:board2/boardList"; // => /board2/boardList.jsp
        }
        else if ( "boardInsert".equals( task[1] ) ) {
            
            page = "redirect/boardInsert.jsp";
        }
        
        return page;
    }
    
}
