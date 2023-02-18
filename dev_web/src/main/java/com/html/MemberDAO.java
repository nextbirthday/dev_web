package com.html;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.google.gson.Gson;
import com.util.DBConnection;
import com.util.MyBatisCommonFactory;
import com.vo.MemberVO;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class MemberDAO {
    
    DBConnection         db  = new DBConnection();
    MyBatisCommonFactory mcf = new MyBatisCommonFactory();
    Connection           con;
    PreparedStatement    pstmt;
    ResultSet            rs;
    
    public List<Map<String, Object>> getMemberList() {
        
        List<Map<String, Object>> memList = null;
        StringBuilder             sql     = new StringBuilder();
        sql.append( " select mem_no, mem_id, mem_name from member " );
        
        try {
            con = db.getConnection();
            pstmt = con.prepareStatement( sql.toString() );
            rs = pstmt.executeQuery(); // 오라클 서버의 커서를 조작할 객체를 로딩
            
            memList = new ArrayList<>();
            Map<String, Object> rmap = null;
            
            while ( rs.next() ) {
                rmap = new HashMap<>();
                // JAVA Type과 ORACLE TYPE 일치해야한다.
                rmap.put( "mem_no", rs.getInt( "mem_no" ) );
                rmap.put( "mem_id", rs.getString( "mem_id" ) );
                rmap.put( "mem_name", rs.getString( "mem_name" ) );
                memList.add( rmap );
            }
            log.info( memList );
        }
        catch ( Exception e ) {
            log.error( "SQL error", e );
        }
        finally {
            db.freeConnection( con, pstmt, rs );
        }
        return memList;
    }
    
    public String jsonMemberList() {
        
        List<Map<String, Object>> memList = null;
        StringBuilder             sql     = new StringBuilder();
        sql.append( " select mem_no, mem_id, mem_name from member " );
        
        try {
            con = db.getConnection();
            pstmt = con.prepareStatement( sql.toString() );
            rs = pstmt.executeQuery();
            
            memList = new ArrayList<>();
            Map<String, Object> rmap = null;
            
            while ( rs.next() ) {
                rmap = new HashMap<>();
                rmap.put( "mem_no", rs.getInt( "mem_no" ) );
                rmap.put( "mem_id", rs.getString( "mem_id" ) );
                rmap.put( "mem_name", rs.getString( "mem_name" ) );
                memList.add( rmap );
            }
            
        }
        catch ( Exception e ) {
            log.error( "SQL error", e );
        }
        
        finally {
            db.freeConnection( con, pstmt, rs );
        }
        
        Gson   g    = new Gson();
        String temp = null;
        temp = g.toJson( memList );
        
        log.info( temp );
        return temp;
    }
    
    public List<Map<String, Object>> myBatisMemberList() {
        
        // MyBatisConfig.xml문서 정보 - 드라이버 ,오라클서버URL, 계정정보+쿼리문담은 xml등록
        SqlSessionFactory sqlSessionFactory = null;
        
        // SqlSession으로 commit과 rollback지원받음
        SqlSession sqlSession = null;
        
        List<Map<String, Object>> memList = null;
        Map<String, Object>       pmap    = new HashMap<>();
        pmap.put( "mem_no", 0 );
        
        try {
            sqlSessionFactory = mcf.getSqlSessionFactory();
            sqlSession = sqlSessionFactory.openSession();
            // member.xml에서 id가 getMemberList인것을 찾아서 실행요청함
            
            memList = sqlSession.selectList( "getMemberList", pmap ); // id값
            
            // sqlSession.commit(); - INSERT, UPDATE, DELETE시 COMMIT을 호출할 때 사용한다.
            log.info( memList );
        }
        catch ( Exception e ) {
            log.error( "SQL error", e );
        }
        return memList;
    }
    
    public List<MemberVO> myBatisMemberList2() {
        
        SqlSessionFactory sqlSessionFactory = null;
        SqlSession        sqlSession        = null;
        List<MemberVO>    memList           = null;
        
        Map<String, Object> pmap = new HashMap<>();
        pmap.put( "mem_no", 0 );
        
        try {
            sqlSessionFactory = mcf.getSqlSessionFactory();
            sqlSession = sqlSessionFactory.openSession();
            memList = sqlSession.selectList( "myBatisMemberList2", pmap );
            log.info( memList );
        }
        catch ( Exception e ) {
            log.error( "SQL error", e );
        }
        
        return memList;
    }
    
    public static void main( String[] args ) {
        MemberDAO dao = new MemberDAO();
        // dao.getMemberList();
        // dao.jsonMemberList();
        // dao.myBatisMemberList();
        dao.myBatisMemberList2();
    }
}
