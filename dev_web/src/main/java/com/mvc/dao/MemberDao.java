package com.mvc.dao;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.util.MyBatisCommonFactory;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class MemberDao {
    
    MyBatisCommonFactory myBatisCommonFactory = new MyBatisCommonFactory();
    
    SqlSessionFactory sqlSessionFactory = null;
    SqlSession        sqlSession        = null;
    
    public Map<String, Object> signIn( Map<String, Object> map ) {
        
        log.info( map );
        Map<String, Object> rmap = null;
        
        try {
            sqlSessionFactory = myBatisCommonFactory.getSqlSessionFactory();
            sqlSession = sqlSessionFactory.openSession();
            
            rmap = sqlSession.selectOne( "signIn", map );
            log.info( rmap );
        }
        catch ( Exception e ) {
            log.error( "SQL error", e );
        }
        
        return rmap;
    }
    
    public static void main( String[] args ) {
        MemberDao           d    = new MemberDao();
        Map<String, Object> temp = new HashMap<>();
        
        temp.put( "mem_id", "tomato" );
        temp.put( "mem_pw", "123" );
        Map<String, Object> temp2 = d.signIn( temp );
        log.info( temp2 );
    }
}
