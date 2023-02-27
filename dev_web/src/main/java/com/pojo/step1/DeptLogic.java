package com.pojo.step1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class DeptLogic {
    
    public List<Map<String, Object>> getDeptList() {
        log.info( "getDeptList 호출" );
        List<Map<String, Object>> deptList = new ArrayList<>();
        Map<String, Object>       tempMap  = new HashMap<>();
        tempMap.put( "deptno", 10 );
        tempMap.put( "dname", "데이터분석팀" );
        tempMap.put( "loc", "역삼역" );
        
        deptList.add( tempMap );
        
        return deptList;
    }
    
    public String jsonDeptList() {
        log.info( "jsonDeptList 호출" );
        List<Map<String, Object>> deptList = new ArrayList<>();
        Map<String, Object>       tempMap  = new HashMap<>();
        tempMap.put( "deptno", 10 );
        tempMap.put( "dname", "데이터분석팀" );
        tempMap.put( "loc", "역삼역" );
        deptList.add( tempMap );
        
        tempMap = new HashMap<>();
        tempMap.put( "deptno", 20 );
        tempMap.put( "dname", "토스랩잔디" );
        tempMap.put( "loc", "삼성역" );
        deptList.add( tempMap );
        
        tempMap = new HashMap<>();
        tempMap.put( "deptno", 30 );
        tempMap.put( "dname", "올고다" );
        tempMap.put( "loc", "판교" );
        deptList.add( tempMap );
        
        String temp = toJson( deptList );
        return temp;
    }
    
    public String toJson( List<Map<String, Object>> deptList ) {
        Gson   gson = new Gson();
        String temp = gson.toJson( deptList );
        log.info( temp );
        return temp;
    }
    
    public int deptInsert() {
        log.info( "deptInsert 호출" );
        int result = -1;
        return 0;
    }
    
    public int deptUpdate() {
        log.info( "deptUpdate 호출" );
        return 0;
    }
    
    public int deptDelete() {
        log.info( "deptDelete 호출" );
        return 0;
    }
    
}
