<%@page import="com.util.DBConnection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*,java.util.*,com.util.DBConnection"%>
<%@ page import="com.google.gson.Gson"%>
<%
DBConnection                  oracle = new DBConnection();
Connection                    con    = null;
PreparedStatement             pstmt  = null;
ResultSet                     rs     = null;

List<Map<String, Object>> memberList = new ArrayList<>();

StringBuilder sql = new StringBuilder();

sql.append( "SELECT * FROM SCOTT.DEPT" );

try {
    con = oracle.getConnection();
    pstmt = con.prepareStatement( sql.toString() );
    rs = pstmt.executeQuery();
    Map<String, Object> memberMap = null;
    
    while ( rs.next() ) {
        memberMap = new HashMap<>();
        memberMap.put( "DEPTNO", rs.getInt( "DEPTNO" ) );
        memberMap.put( "DNAME", rs.getString( "DNAME" ) );
        memberMap.put( "LOC", rs.getString( "LOC" ) );
        
        memberList.add( memberMap );
        System.out.println( memberList );
    }
}
catch ( Exception error ) {
    
}
finally {
    oracle.freeConnection( con, pstmt, rs );
}

Gson               gson = new Gson();
String             temp = gson.toJson( memberList );
out.print( memberList );
%>