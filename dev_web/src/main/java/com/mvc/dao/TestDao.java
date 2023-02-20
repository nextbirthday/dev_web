package com.mvc.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.util.MyBatisCommonFactory;

import lombok.extern.log4j.Log4j2;

@Log4j2( topic = "database" )
public class TestDao {
    
    MyBatisCommonFactory myBatisCommonFactory = new MyBatisCommonFactory();
    
    SqlSessionFactory sqlSessionFactory = null;
    SqlSession        sqlSession        = null;
    
    public List<Map<String, Object>> getBookMember() {
        
        List<Map<String, Object>> bookMemberList = null;
        
        try {
            sqlSessionFactory = myBatisCommonFactory.getSqlSessionFactory();
            sqlSession = sqlSessionFactory.openSession();
            
            Map<String, Object> pMap = new HashMap<>();
            pMap.put( "mem_id", "tomato" );
            pMap.put( "mem_pw", "123" );
            
            bookMemberList = sqlSession.selectList( "getBookMember", pMap );
            log.info( bookMemberList );
            // test.xml 쿼리문이 mem_id = #{mem_id} OR mem_pw = #{mem_pw} 때문에 3건이 나온다 (OR 때문에)
        }
        catch ( Exception e ) {
            log.error( "SQL error", e );
        }
        
        return bookMemberList;
    }
    
    public String testDate() {
        
        String currentTime = null;
        
        try {
            sqlSessionFactory = myBatisCommonFactory.getSqlSessionFactory();
            sqlSession = sqlSessionFactory.openSession();
            
            currentTime = sqlSession.selectOne( "testDate" );
            log.info( currentTime );
        }
        catch ( Exception e ) {
            log.error( "SQL error", e );
        }
        
        return currentTime;
    }
}
