package com.pojo.step3;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class HandlerMapping {
    /**
     * @param task[]   (task[0] - 업무명(폴더명), task[1]-메서드명, 기능명, 페이지이름, 분기)
     * @param request  - Step1, Step2 와는 다르게 Interface를 implements하지 않는다.
     * @param response
     *                 Question) 요청객체와 응답객체를 어디서 받아오지?
     * @return void - ActionForward - String -> ModelAndView ->
     * @return Object
     */
    
    public static Object getController( String[] task, HttpServletRequest req, HttpServletResponse res )
                    throws ServletException, IOException {
        
        log.info( "task[0] = " + task[0] + ", task[1] = " + task[1] );
        
        Controller3  controller3  = null;
        String       path         = null;
        ModelAndView modelAndView = null;
        
        return null;
    }
}