package clone;

import java.util.Enumeration;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class HashMapBinder7 {
    
    HttpServletRequest req;
    
    public HashMapBinder7( HttpServletRequest req ) {
        this.req = req;
    }
    
    public void bind( Map<String, Object> pMap ) {
        pMap.clear();
        Enumeration<String> enumeration = req.getParameterNames();
        
        while ( enumeration.hasMoreElements() ) {
            String key = enumeration.nextElement();
            log.info( "value = {} ", req.getParameter( key ) );
            pMap.put( key, req.getParameter( key ) );
        }
    }
}
