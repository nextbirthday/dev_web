package clone;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import dept.exam.MyBatisSessionFactory;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class BoardDAO7 {
    private SqlSessionFactory sqlSessionFactory;
    private SqlSession        sqlSession;
    
    public List<Map<String, Object>> boardList( Map<String, Object> pMap ) {
        
        sqlSessionFactory = MyBatisSessionFactory.getInstance();
        sqlSession = sqlSessionFactory.openSession();
        
        List<Map<String, Object>> boardList = sqlSession.selectList( "board.boardList", pMap );
        
        log.debug( boardList );
        
        return boardList;
    }
    
    public int boardInsert( Map<String, Object> pMap ) {
        
        sqlSessionFactory = MyBatisSessionFactory.getInstance();
        sqlSession = sqlSessionFactory.openSession();
        
        int result = sqlSession.insert( "board.boardMInsert", pMap );
        
        if ( result == 1 )
            sqlSession.commit();
        
        log.info( "result = {} ", result );
        
        return result;
    }
    
    public int getBGroup() {
        sqlSessionFactory = MyBatisSessionFactory.getInstance();
        sqlSession = sqlSessionFactory.openSession();
        
        int result = sqlSession.selectOne( "board.getBGroup", "" );
        
        log.info( "getBGroup = {} ", result ); // 채번한 글 그룹 번호
        
        return result;
    }
    
    public int getBNO() {
        
        sqlSessionFactory = MyBatisSessionFactory.getInstance();
        sqlSession = sqlSessionFactory.openSession();
        
        int result = sqlSession.selectOne( "board.getBNO", "" );
        
        log.info( "board.getBNO = {} ", result );
        
        return result;
    }
    
    public void bStepUpdate( Map<String, Object> pMap ) {
        
        sqlSessionFactory = MyBatisSessionFactory.getInstance();
        sqlSession = sqlSessionFactory.openSession();
        
        int result = sqlSession.update( "board.bStepUpdate", pMap );
        
        if ( result == 1 )
            sqlSession.commit();
        
        log.info( "board.bStepUpdate = {} ", result );
        
        log.info( result );
    }
}
