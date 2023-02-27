package clone;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import dept.exam.MyBatisSessionFactory;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class DeptLogic {
    
    SqlSessionFactory sqlSessionFactory;
    SqlSession        sqlSession;
    
    public List<DeptVO> getDeptList() {
        
        sqlSessionFactory = MyBatisSessionFactory.getInstance();
        sqlSession = sqlSessionFactory.openSession();
        List<DeptVO> deptList = sqlSession.selectList( "selectDept" );
        
        return deptList;
    }
    
    public int deptInsert() {
        sqlSessionFactory = MyBatisSessionFactory.getInstance();
        sqlSession = sqlSessionFactory.openSession();
        
        int result = sqlSession.insert( null );
        return result;
    };
    
    public static void main( String[] args ) {
        DeptLogic d = new DeptLogic();
    }
}
