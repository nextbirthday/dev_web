package com.pojo.step3;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class HandlerMapping {
    /**
     * @param task[]   (task[0] - 업무명(폴더명), task[1]-메서드명, 기능명, 페이지이름, 분기)
     * @param request  - Step1, Step2 와는 다르게 Interface를 implements하지 않는다.
     * @param response
     *                 Question) 요청객체와 응답객체를 어디서 받아오지?
     * @return void - ActionForward - String -> ModelAndView ->
     * @return Object
     */
    
    public static Object getController( String[] task, HttpServletRequest req, HttpServletResponse res )
                    throws ServletException, IOException {
        
        log.info( "task[0] = {} , task[1] = {} ", task[0], task[1] );
        
        Controller3 controller3 = null;
        
        Object object = null;
        
        if ( "board3".equals( task[0] ) ) {
            
            controller3 = new BoardController3();
            
            // 게시글 전체 목록
            if ( "boardList".equals( task[1] ) ) { // html화면 출력이 나감 - text/html
                object = controller3.boardList( req, res );
            }
            else if ( "jsonBoardList".equals( task[1] ) ) { // json 포맷으로 나감 - application/json
                object = controller3.jsonBoardList( req, res );
            }
            else if ( "boardDetail".equals( task[1] ) ) {
                object = controller3.boardDetail( req, res );
            }
            else if ( "boardInsert".equals( task[1] ) ) { // 글 입력- 새 글 쓰기와 댓글 쓰기
                object = controller3.boardInsert( req, res );
            }
            else if ( "boardUpdate".equals( task[1] ) ) { // 글 수정 - 첨부파일 수정 유무 고려하기
                object = controller3.boardUpdate( req, res );
            }
            else if ( "boardDelete".equals( task[1] ) ) { // 글 입력 - 첨부파일 삭제 유무 고려하기
                object = controller3.boardDelete( req, res );
            } // end of board
              // 인증관리
            else if ( "auth".equals( task[0] ) ) {}
            // 회원관리
            else if ( "member".equals( task[0] ) ) {}
            // 주문관리
            else if ( "order".equals( task[0] ) ) {}
            
        }
        return object;
    }
}