package clone;

import java.util.List;
import java.util.Map;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class BoardLogic7 {
    
    BoardDAO7 boardDAO7 = new BoardDAO7();
    
    public List<Map<String, Object>> boardList( Map<String, Object> pMap ) {
        
        List<Map<String, Object>> boardList = boardDAO7.boardList( pMap );
        
        return boardList;
    }
    
    public int boardInsert( Map<String, Object> pMap ) {
        
        log.info( "pMap = {} ", pMap );
        
        int bm_no    = 0;
        int bm_group = 0;
        
        bm_no = boardDAO7.getBNO();
        
        log.info( "from get BNO = {} ", bm_no );
        
        pMap.put( "bm_no", bm_no );
        
        if ( pMap.get( "bm_group" ) != null ) {
            bm_group = Integer.parseInt( pMap.get( "bm_group" ).toString() );
        }
        
        if ( bm_group > 0 ) {
            boardDAO7.bStepUpdate( pMap );
            pMap.put( "bm_pos", Integer.parseInt( pMap.get( "bm_pos" ).toString() ) );
            pMap.put( "bm_step", Integer.parseInt( pMap.get( "bm_step" ).toString() ) );
        }
        else {
            log.info( "새 글 쓰기 로직 호출 = {}, bm_group = {} ", "", bm_group );
            bm_group = boardDAO7.getBGroup();
            pMap.put( "bm_group", bm_group );
            pMap.put( "bm_pos", 0 );
            pMap.put( "bm_step", 0 );
        }
        
        int result = boardDAO7.boardInsert( pMap );
        
        return result;
    }
    
}
