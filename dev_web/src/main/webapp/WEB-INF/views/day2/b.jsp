<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>b.jsp[WEB-INF]</title>
</head>
<body>
  <h1>b.jsp페이지입니다.</h1>
</body>
</html>
<!-- WEB-INF아래 있는 jsp페이지는 절대로 URL접근이 불가능하다.
반드시 서블릿을 경유하여 RequestDispatcher를 사용하여 요청하자.
그러면 WEB-INF 아래 있는 경로이더라도 페이지 호출이 가능할 것이다.
다만 scope는 request scope를 갖게 된다는 점만 주의한다.
 -->
