package com.util;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class MyBatisCommonFactory {
    // MyBatis는 자바와 오라클 서버 사이 위치하면서 db연계를 지원하는 매칭서비스이다.
    public SqlSessionFactory sqlSessionFactory = null;
    
    // SqlSessionFactory객체를 생성해 주는 메소드 입니다.
    public void init() {
        
        try {
            String resource = "com\\util\\MyBatisConfig.xml";
            Reader reader   = Resources.getResourceAsReader( resource );
            log.info( "before sqlSessionFactory : " + sqlSessionFactory );
            
            if ( sqlSessionFactory == null ) {
                sqlSessionFactory = new SqlSessionFactoryBuilder().build( reader, "development" );
            }
            log.info( "after sqlSessionFactory : " + sqlSessionFactory );
        }
        catch ( Exception e ) {
            log.info( "[[ Exception ]] " + e.toString() );
        }
    }// end of init
    
    public SqlSessionFactory getSqlSessionFactory() {
        init();
        return sqlSessionFactory;
    }
}