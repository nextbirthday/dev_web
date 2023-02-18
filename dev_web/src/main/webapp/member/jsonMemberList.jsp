<%@ page language="java" contentType="application/json; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*,java.util.*,com.util.DBConnection"%>
<%@ page import="com.google.gson.Gson"%>

<%
DBConnection                  db    = new DBConnection();
Connection                    con   = null;
PreparedStatement             pstmt = null;
ResultSet                     rs    = null;

List<Map<String, Object>>             memList = null;
StringBuilder                         sql     = new StringBuilder();
sql.append( "SELECT * FROM SCOTT.DEPT" );

try {
    con = db.getConnection();
    pstmt = con.prepareStatement( sql.toString() );
    rs = pstmt.executeQuery();
    
    memList = new ArrayList<>();
    Map<String, Object> rmap = null;
    
    while ( rs.next() ) {
        rmap = new HashMap<>();
        rmap.put( "DEPTNO", rs.getInt( "DEPTNO" ) );
        rmap.put( "DNAME", rs.getString( "DNAME" ) );
        rmap.put( "LOC", rs.getString( "LOC" ) );
        memList.add( rmap );
    }
    System.out.println( memList );
}
catch ( Exception e ) {
    e.printStackTrace();
}
finally {
    db.freeConnection( con, pstmt, rs );
}

Gson               g    = new Gson();
String             temp = g.toJson( memList );
out.print( temp );
%>