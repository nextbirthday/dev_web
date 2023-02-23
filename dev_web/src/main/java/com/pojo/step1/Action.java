package com.pojo.step1;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 클래스 설계에 인터페이스가 필요하다. 인터페이스 중심의 코딩을 전개한느 것이 결합도를 낮춰준다.
 * 결합도를 낮춘다? - 의존성이 낮다. 의존성이 낮아진다라는 것은 단위테스트가 가능하다.
 * 단위테스트가 가능하다? - 신뢰도를 높이는 코드
 * 그래서 아래와같이 바꾸었지만 파라미터 자리의 req와 res는 개발자가 인스턴스화 하는 것이 아니고
 * 톰캣이 주입해주는 객체이다.
 *
 * HttpServlet에서 강제(Override:doGet, doPost)하는 void를 다른 타입으로 바꾸어보자.
 * 이 문제를 어떻게 해결하는지를 관전 포인트로 삼는다.
 * 
 * @author HOJAE
 */
public interface Action {
    public ActionForward execute( HttpServletRequest req, HttpServletResponse res )
                    throws ServletException, IOException;
    
}
