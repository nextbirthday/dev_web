package clone;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class HandlerMapping7 {
    
    public static Object getController( String[] task, HttpServletRequest req, HttpServletResponse res )
                    throws ServletException, IOException {
        
        log.info( "task[0] = {} , task[1] = {} ", task[0], task[1] );
        
        Controller7 controller7 = null;
        Object      obj         = null;
        
        if ( "board7".equals( task[0] ) ) {
            
            controller7 = new BoardController7();
            
            switch ( task[1] ) {
                case "boardList":
                    obj = controller7.boardList( req, res );
                    break;
                
                case "jsonBoardList":
                    obj = controller7.jsonBoardList( req, res );
                    break;
                
                case "boardDetail":
                    obj = controller7.boardDetail( req, res );
                    break;
                
                case "boardInsert":
                    obj = controller7.boardInsert( req, res );
                    break;
                
                case "boardUpdate":
                    obj = controller7.boardUpdate( req, res );
                    break;
                
                case "boardDelete":
                    obj = controller7.boardDelete( req, res );
                    break;
                
                default:
                    obj = "";
                    break;
            }
        }
        
        log.debug( obj );
        return obj;
    }
}
