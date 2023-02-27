package dept.exam;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import lombok.extern.log4j.Log4j2;

@SuppressWarnings( "serial" )
@Log4j2( topic = "database" )
public class DeptController extends HttpServlet {
    @Override
    protected void doGet( HttpServletRequest req, HttpServletResponse resp ) throws ServletException, IOException {
        List<Dept> deptList = new DeptDAO().selectDept();
        resp.setContentType( "application/json" );
        log.info( deptList );
        PrintWriter writer = resp.getWriter();
        writer.print( toJson( deptList ) );
    }
    
    public String toJson( List<Dept> deptList ) {
        
        Gson   gson   = new Gson();
        String result = gson.toJson( deptList );
        log.info( result );
        return result;
    }
}
