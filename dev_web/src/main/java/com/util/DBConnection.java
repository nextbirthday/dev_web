package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class DBConnection {
    public static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
    public static final String URL    = "jdbc:oracle:thin:@192.168.0.2:1521/orcl11";
    public static String       USER   = "scott";
    public static String       PW     = "tiger";
    
    private static Connection con;
    
    public Connection getConnection() {
        
        try {
            
            if ( con == null || con.isClosed() ) {
                Class.forName( DRIVER );
                con = DriverManager.getConnection( URL, USER, PW );
            }
        }
        catch ( Exception e ) {
            log.error( "connection error", e );
        }
        return con;
    }
    
    public void freeConnection( Connection con, Statement stmt ) {
        
        if ( stmt != null ) {
            
            try {
                stmt.close();
            }
            catch ( SQLException e ) {
                log.error( "error", e );
            }
        }
        
        if ( con != null ) {
            
            try {
                con.close();
            }
            catch ( SQLException e ) {
                log.error( "error", e );
            }
        }
    } // end of freeConnection
    
    public void freeConnection( Connection con, PreparedStatement pstmt ) {
        
        if ( pstmt != null ) {
            
            try {
                pstmt.close();
            }
            catch ( SQLException e ) {
                log.error( "error", e );
            }
        }
        
        if ( con != null ) {
            
            try {
                con.close();
            }
            catch ( SQLException e ) {
                log.error( "error", e );
            }
        }
    } // end of freeConnection
    
    // 사용한 자원 반납하기 - SELECT - 커서 조작이 필요하다.
    
    public void freeConnection( Connection con, PreparedStatement pstmt, ResultSet rs ) {
        
        if ( rs != null ) {
            
            try {
                rs.close();
            }
            catch ( SQLException e ) {
                log.error( "error", e );
            }
        }
        
        if ( pstmt != null ) {
            
            try {
                pstmt.close();
            }
            catch ( SQLException e ) {
                log.error( "error", e );
            }
        }
        
        if ( con != null ) {
            
            try {
                con.close();
            }
            catch ( SQLException e ) {
                log.error( "error", e );
            }
        }
    } // end of freeConnection
    
    public void freeConnection( Connection con, Statement stmt, ResultSet rs ) {
        
        if ( rs != null ) {
            
            try {
                rs.close();
            }
            catch ( SQLException e ) {
                log.error( "error", e );
            }
        }
        
        if ( stmt != null ) {
            
            try {
                stmt.close();
            }
            catch ( SQLException e ) {
                log.error( "error", e );
            }
        }
        
        if ( con != null ) {
            
            try {
                con.close();
            }
            catch ( SQLException e ) {
                log.error( "error", e );
            }
        }
    } // end of freeConnection
}
