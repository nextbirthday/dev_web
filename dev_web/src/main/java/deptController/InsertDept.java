package deptController;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dept.dto.Dept;
import dept.logic.DeptDAO;
import lombok.extern.log4j.Log4j2;

@SuppressWarnings( "serial" )
@Log4j2
public class InsertDept extends HttpServlet {
    
    @Override
    protected void doPost( HttpServletRequest req, HttpServletResponse resp ) throws ServletException, IOException {
        
        req.setCharacterEncoding( "UTF-8" );
        PrintWriter writer = resp.getWriter();
        
        Dept dept = new Dept();
        
        dept.setDeptno( Integer.parseInt( req.getParameter( "deptno" ) ) );
        dept.setDname( req.getParameter( "dname" ) );
        dept.setLoc( req.getParameter( "loc" ) );
        
        int result = new DeptDAO().insertDept( dept );
        log.info( result );
        
    }
}
