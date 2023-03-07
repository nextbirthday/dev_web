package com.pojo.step3;

import java.util.List;
import java.util.Map;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class BoardLogic3 {
    
    BoardDAO3 boardDAO3 = new BoardDAO3();
    
    public List<Map<String, Object>> boardList( Map<String, Object> pMap ) {
        
        List<Map<String, Object>> boardList = boardDAO3.boardList( pMap );
        
        return boardList;
    }
    
    public int boardInsert( Map<String, Object> pMap ) {
        
        int bm_no    = 0;
        int bm_group = 0;
        bm_no = boardDAO3.getBNO();
        
        log.info( "bm_no = {} ", bm_no );
        
        pMap.put( "bm_no", bm_no );
        
        /**
         * Map 안에서 꺼낸다는 건 화면에서 넘어온 값이라는 뜻
         */
        if ( pMap.get( "bm_group" ) != null ) {
            bm_group = Integer.parseInt( pMap.get( "bm_group" ).toString() );
        }
        
        // 댓글쓰기
        if ( bm_group > 0 ) {
            boardDAO3.bStepUpdate( pMap ); // bm_group =8, bm_step>1
            pMap.put( "bm_pos", Integer.parseInt( pMap.get( "bm_pos" ).toString() ) + 1 );
            pMap.put( "bm_step", Integer.parseInt( pMap.get( "bm_step" ).toString() ) + 1 );
        }
        // 새글쓰기 - 그룹번호 채번 포함
        else {
            log.info( "새 글 쓰기 로직 호출 = {}, bm_group = {} ", "", bm_group );
            bm_group = boardDAO3.getBGroup();
            pMap.put( "bm_group", bm_group );
            pMap.put( "bm_pos", 0 );
            pMap.put( "bm_step", 0 );
        }
        
        int result = boardDAO3.boardInsert( pMap );
        
        return result;
    }
    
    public int boardMUpdate( Map<String, Object> pMap ) {
        
        int result = boardDAO3.boardMUpdate( pMap );
        
        return result;
    }
    
    public int boardMDelete( Map<String, Object> pMap ) {
        
        int result = boardDAO3.boardMDelete( pMap );
        
        return result;
    }
    
}
