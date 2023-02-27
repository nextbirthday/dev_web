package com.pojo.step1;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EmpController implements Action {
    
    @Override
    public ActionForward execute( HttpServletRequest req, HttpServletResponse res )
                    throws ServletException, IOException {
        ActionForward actionForward = new ActionForward();
        return null;
    }
    
}
