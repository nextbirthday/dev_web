package com.pojo.step3;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import dept.exam.MyBatisSessionFactory;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class BoardDAO3 {
    
    private SqlSessionFactory sqlSessionFactory;
    private SqlSession        sqlSession;
    
    public List<Map<String, Object>> boardList( Map<String, Object> pMap ) {
        
        sqlSessionFactory = MyBatisSessionFactory.getInstance();
        sqlSession = sqlSessionFactory.openSession();
        
        List<Map<String, Object>> boardList = sqlSession.selectList( "board.boardList", pMap );
        
        log.debug( boardList );
        
        return boardList;
    }
    
    /**
     * insert 이지만 update로 하는 이유는 return type이 Object이기 때문이다.
     * 메서드 이름은 상관없이 해당 쿼리문을 ID로 찾기 때문이다.
     *
     * @param pMap
     * @return INSERT 성공 여부 (Integer)
     */
    public int boardInsert( Map<String, Object> pMap ) {
        
        sqlSessionFactory = MyBatisSessionFactory.getInstance();
        sqlSession = sqlSessionFactory.openSession();
        
        int result = sqlSession.update( "board.boardMInsert", pMap );
        
        if ( result == 1 )
            sqlSession.commit();
        
        log.info( result );
        
        return result;
    }
    
    public int getBGroup() {
        
        sqlSessionFactory = MyBatisSessionFactory.getInstance();
        sqlSession = sqlSessionFactory.openSession();
        
        int result = sqlSession.selectOne( "board.getBGroup", "" );
        
        log.info( "채번한 글 그룹 번호 = {} ", result ); // 채번한 글 그룹 번호
        
        return result;
    }
    
    public int getBNO() {
        
        sqlSessionFactory = MyBatisSessionFactory.getInstance();
        sqlSession = sqlSessionFactory.openSession();
        
        int result = sqlSession.selectOne( "board.getBNO", "" );
        
        return result;
    }
    
    public void bStepUpdate( Map<String, Object> pMap ) {
        
        sqlSessionFactory = MyBatisSessionFactory.getInstance();
        sqlSession = sqlSessionFactory.openSession();
        
        int result = sqlSession.update( "board.bStepUpdate", pMap );
        
        if ( result == 1 )
            sqlSession.commit();
        
        log.info( result );
    }
    
    public int boardMUpdate( Map<String, Object> pMap ) {
        
        sqlSessionFactory = MyBatisSessionFactory.getInstance();
        sqlSession = sqlSessionFactory.openSession();
        
        int result = sqlSession.update( "board.boardMUpdate", pMap );
        
        if ( result == 1 )
            sqlSession.commit();
        
        return result;
    }
    
    public int boardMDelete( Map<String, Object> pMap ) {
        
        sqlSessionFactory = MyBatisSessionFactory.getInstance();
        sqlSession = sqlSessionFactory.openSession();
        int bm_no = 0;
        
        if ( pMap.get( "bm_no" ) != null ) {
            bm_no = Integer.parseInt( pMap.get( "bm_no" ).toString() );
        }
        
        int result = sqlSession.update( "board.boardMDelete", bm_no );
        
        if ( result == 1 )
            sqlSession.commit();
        
        return result;
    }
    
}
