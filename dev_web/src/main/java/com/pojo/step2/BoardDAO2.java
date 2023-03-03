package com.pojo.step2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import dept.exam.MyBatisSessionFactory;
import lombok.extern.log4j.Log4j2;

@Log4j2( topic = "database" )
public class BoardDAO2 {
    
    // INSERT HERE - MyBatis연동에 필요한 공통 클래스 객체 주입 필요
    private SqlSessionFactory sqlSessionFactory;
    private SqlSession        sqlSession;
    
    public List<Map<String, Object>> boardList() {
        
        sqlSessionFactory = MyBatisSessionFactory.getInstance();
        sqlSession = sqlSessionFactory.openSession();
        
        List<Map<String, Object>> boardList = null;
        Map<String, Object>       boardMap  = new HashMap<>();
        
        boardList = sqlSession.selectList( "board.boardList", boardMap );
        
        log.trace( boardList );
        
        return boardList;
    }
    
}
