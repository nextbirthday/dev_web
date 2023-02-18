<%@ page language="java" contentType="application/json; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.util.*, java.util.List, java.util.Map,java.util.HashMap"%>
<%@ page import="com.google.gson.Gson"%>
<%@ page import="org.apache.ibatis.session.*,lombok.extern.log4j.Log4j2"%>

<%
MyBatisCommonFactory                  mcf     = new MyBatisCommonFactory();
List<Map<String, Object>>             memList = null;

SqlSessionFactory             sqlSessionFactory = null;
SqlSession                    sqlSession        = null;

Map<String, Object> pmap = new HashMap<>();
/* pmap.put( "mem_no", 0 ); */

try {
    sqlSessionFactory = mcf.getSqlSessionFactory();
    sqlSession = sqlSessionFactory.openSession();
    
    memList = sqlSession.selectList( "getMemberList", pmap );
    
}
catch ( Exception e ) {}

Gson               g    = new Gson();
String             temp = null;
temp = g.toJson( memList );
out.print( temp );
%>
