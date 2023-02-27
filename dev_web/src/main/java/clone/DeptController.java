package clone;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeptController implements Action {
    
    @Override
    public ActionForward execute( HttpServletRequest req, HttpServletResponse res ) {
        ActionForward actionForward = new ActionForward();
        String[]      task          = ( String[] ) req.getAttribute( "task" );
        DeptLogic     deptLogic     = new DeptLogic();
        
        String path = null;
        boolean isRedirect = true;
        
        if("getDeptList".equals( task[1] )) {
            
            
        }
        
        return actionForward;
    }
    
}
