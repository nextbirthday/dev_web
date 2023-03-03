package com.pojo.step3;

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
/**
 * spring4에서 제공되던 ModelAndView 흉내내보기
 * 1) scope가 request이다.
 * 2) 화면 이름을 정해준다.
 * 
 * @author HOJAE
 *
 */
public class ModelAndView {
    
    HttpServletRequest        req         = null;
    List<Map<String, Object>> requestList = new ArrayList<>();
    
    private String viewName;
    
    public void addObject( String name, Object object ) {
        req.setAttribute( name, object );
        Map<String, Object> pMap = new HashMap<>();
        pMap.put( name, object );
        requestList.add( pMap );
    }
    
    public ModelAndView() {}
    
    public ModelAndView( HttpServletRequest req ) {
        this.req = req;
    }
    
}
