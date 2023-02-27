
package com.pojo.step1;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class DeptController implements Action {
    // SELECT deptno, dname, loc FROM dept
    @Override
    public ActionForward execute( HttpServletRequest req, HttpServletResponse res )
                    throws ServletException, IOException {
        ActionForward actionForward = new ActionForward();
        // FrontMVC1 클래스 request 객체에 저장된 배열 꺼내기 .
        String[]  task       = ( String[] ) req.getAttribute( "task" );
        DeptLogic deptLogic  = new DeptLogic();
        String    path       = null;
        boolean   isRedirect = true;
        
        // 너 부서목록 조회할거니 ?
        if ( "getDeptList".equals( task[1] ) ) {
            List<Map<String, Object>> deptList = deptLogic.getDeptList();
            req.setAttribute( "deptList", deptList );
            path = "getDeptList.jsp";
            isRedirect = false; // false이면 forward이다 - 요청이 유지된다. - 주소창은 그대로인데 페이지는 바뀜
        }
        // 너 부서등록 하려구?
        else if ( "jsonDeptList".equals( task[1] ) ) {
            String jsonDeptList = deptLogic.jsonDeptList();
            req.setAttribute( "jsonDeptList", jsonDeptList );
            path = "jsonDeptList.jsp";
            isRedirect = false; // false이면 forward이다 - 요청이 유지된다. - 주소창은 그대로인데 페이지는 바뀜
        }
        else if ( "deptInsert".equals( task[1] ) ) {
            // INSERT INTO SCOTT.DEPT (DEPTNO,DNAME,LOC) VALUES(?,?,?)
            int result = deptLogic.deptInsert();
        }
        // 너 부서정보 수정해야돼 ?
        else if ( "deptUpdate".equals( task[1] ) ) {
            int result = deptLogic.deptUpdate();
        }
        // 너희 부서 없어졌다.
        else if ( "deptDelete".equals( task[1] ) ) {
            int result = deptLogic.deptDelete();
        }
        actionForward.setPath( path );
        actionForward.setRedirect( isRedirect );
        log.info( "path = " + path + ", isRedirect = " + isRedirect );
        return actionForward;
    }
    
    public ActionForward getDeptList( HttpServletRequest req, HttpServletResponse res ) {
        // res가 없으면 res.sendRedirect(); 불가능
        
        return null;
    }
    
}
