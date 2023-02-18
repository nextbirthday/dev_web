package com.day1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dept.dto.Dept;
import dept.logic.DeptDAO;
import lombok.extern.log4j.Log4j2;

@SuppressWarnings( "serial" )
@Log4j2
@WebServlet( "/json.do" ) // 웹에서 접근 가능한 맵핑 주소 설정
public class MimeJsonServlet extends HttpServlet {
    
    // 서블릿은 java인데 브라우저에 출력할 수 있다. - 화면을 그리는데 서블릿을 사용한다.
    
    @Override
    protected void doGet( HttpServletRequest req, HttpServletResponse res ) throws ServletException, IOException {
        log.info( "doGet 호출" );
        
        res.setContentType( "application/json;charset=UTF-8" );
        List<Dept> deptList = new DeptDAO().selectDept();
        log.info( deptList );
        // method를 통해서 객체 생성하는 코드 -
        PrintWriter writer = res.getWriter();
        writer.print( toJson( deptList ) );
    }
    
    public String toJson( List<Dept> deptList ) {
        
        Gson   gson   = new Gson();
        String result = gson.toJson( deptList );
        log.info( result );
        return result;
    }
}
