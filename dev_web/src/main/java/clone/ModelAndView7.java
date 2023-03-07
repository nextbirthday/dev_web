package clone;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Getter
@Setter
public class ModelAndView7 {
    
    HttpServletRequest        req;
    List<Map<String, Object>> requestList = new ArrayList<>();
    
    private String viewName;
    
    public ModelAndView7( HttpServletRequest req ) {
        this.req = req;
    }
    
    public void addObject( String name, Object object ) {
        
        log.info( "name = {}\n, object = {}", name, object );
        
        req.setAttribute( name, object );
        
        Map<String, Object> parameterMap = new HashMap<>();
        parameterMap.put( name, object );
        requestList.add( parameterMap );
    }
}
