package com.pojo.step1;

/**
 * ActionForward 클래스를 왜 만드나 ?
 * 웹 서비스에서는 main메서드 대신에 URL로 요청을 보낸다.
 * 누가 ? 클라이언트가 누구에게 Tomcat 서버에게 요청한다.
 * 요청을 할 때 URL을 사용한다.
 * 
 * @author HOJAE
 */
public class ActionForward {
    /**
     * 페이지 이동 방법 2가지
     * res.sendRedirect("XXX.jsp") - 표준 서블릿 - MVC패턴이 아니다.(확정적으로 얘기 가능) 요청을 누가 받는다? jsp가
     * or res.sendRedirect("dept/getDeptList.kh") - 서블릿이 요청을 받음 - MVC패턴인가?
     * jsp가 요청을 받는것이 왜 문제인가 ?
     * WAS마다 명명규칙이 다르다. 그래서 인스턴스화를 할 수 없다.
     * 인스턴스화를 한다 하더라도 request와 response 객체를 주입받지 못하는 문제가 있다.
     *
     */
    private String path; // 응답페이지 이름 또는 서블릿의 이름
    // sendRedirect로 페이지를 이동할 것인지 아니면 forward로 페이지를 이동할 것인지에 대한 여부를 결정한다.
    
    // TRUE이면 redirect(INSERT|UPDATE|DELETE) FALSE이면 forward(SELECT일 때)
    private boolean isRedirect;
    
    public String getPath() { return path; }
    
    public void setPath( String path ) { this.path = path; }
    
    public boolean isRedirect() { return isRedirect; }
    
    public void setRedirect( boolean isRedirect ) { this.isRedirect = isRedirect; }
    
}
