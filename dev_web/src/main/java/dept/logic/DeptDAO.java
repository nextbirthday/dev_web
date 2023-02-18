package dept.logic;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import dept.dto.Dept;
import dept.util.MyBatisSessionFactory;
import lombok.extern.log4j.Log4j2;

@Log4j2( topic = "dept" )
public class DeptDAO {
    
    SqlSessionFactory sqlSessionFactory;
    SqlSession        sqlSession;
    
    public int insertDept( Dept dept ) {
        
        sqlSessionFactory = MyBatisSessionFactory.getInstance();
        sqlSession = sqlSessionFactory.openSession();
        
        int result = sqlSession.insert( "insertDept", dept );
        
        if ( result > 0 )
            sqlSession.commit();
        
        return result;
    }
    
    public List<Dept> selectDept() {
        
        List<Dept> deptList = new ArrayList<>();
        
        sqlSessionFactory = MyBatisSessionFactory.getInstance();
        sqlSession = sqlSessionFactory.openSession();
        deptList = sqlSession.selectList( "selectDept" );
        log.info( deptList );
        return deptList;
    }
    
    public static void main( String[] args ) {}
}
