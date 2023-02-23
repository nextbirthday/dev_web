package com.pojo.step1;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class Pattern {
    public static void main( String[] args ) {
        // String url = "/dev_web/업무이름/페이지이름 또는 요청이름";
        String url     = "/dev_web/dept/getDeptList.kh";
        String context = "dev_web/";
        // 톰캣서버에 요청할 때 사용되는 주소값을 가지고 업무명과 업무에 필요한 이름으로 
        // 분리시켜 사용자 요청에 따라 처리를 담당할 XXXController 객체를 주입하는데 사용한다.
        String command = url.substring( context.length() + 1 );
        log.info( command );
        
        int end = command.lastIndexOf( "." );
        log.info( end );
        
        command = command.substring( 0, end );
        log.info( command );
        
        String[] task = null;
        task = command.split( "/" );
        
        for ( String temp : task ) {
            log.info( temp );
        }
    }
}
