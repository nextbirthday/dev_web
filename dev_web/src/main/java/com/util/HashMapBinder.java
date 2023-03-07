package com.util;

import java.util.Enumeration;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import lombok.extern.log4j.Log4j2;

/**
 * Spring에서는 Model, ModelMap
 * Spring boot에서는 RequestParam이 대신 해준다.
 * 
 * @author HOJAE
 */
@Log4j2
public class HashMapBinder {
    
    HttpServletRequest req;
    
    private HashMapBinder() {}
    
    /**
     * 생성자 파라미터에 요청객체가 필요한 이유는 ?
     * Constructor의 제 1역할 - 전역변수의 초기화
     * 
     * @param req
     */
    public HashMapBinder( HttpServletRequest req ) {
        this.req = req;
    }
    
    /**
     * 어떤 페이지 어떤 상황에서 공통 코드를 재사용 가능하게 할 것인가?
     * 업무별 요청 클래스에서 주입받을 객체를 정해서 메서드의 파라미터로 전달 받음.
     * 전달받은 주소번지 원본에 값을 담아준다.
     * 사용자가 입력한 값을 Map에 담아준다. 담을 Map은 컨트롤 계층에서 bind 메서드 호출 시 파라미터를 이용해서 원본 주소번지를 받아온다.
     * 그리고 그 안에 담는다.
     * 
     * @param pMap
     */
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
