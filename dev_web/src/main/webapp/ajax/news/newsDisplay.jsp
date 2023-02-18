<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
<script type="text/javascript">
	const autoReload = () =>{
		
		console.log('autoReload call');
		
		const url = 'newsList.jsp';
		// ajax 함수는 jquery.min.js가 제공하는 api이다.
		// ajax함수는 결국 XMLHttpRequest를 대신한다.
		// const ajax = new XMLHttpRequest();
		// ajax.open("GET", url, true); fasle면 동기 true면 비동기
		// ajax.send
		$.ajax({
	          type: 'GET',
	          url: url,
	          success: function (data) {
	        	  console.log(data);
	        	  $('#d_news').html(data);
	          },
	          error:function(){
	        	  console.log('error');
	        	  console.log('error'+request.status);
	        	  console.log('error'+request.responseText);
	          }
	        });
		
	}
	</script>
</head>
<body>
	<script type="text/javascript">
	//호출하지 않아도 자동 실행
	//jquery(document)
	//window <- document <- ready(function(){실행문:변수선언, if문, switch})
	$(document).ready( () =>{
		start = () => {
			setInterval(autoReload, 2000);
	}
		//function start(){}
	start();
});

</script>
	<div id="d_news">뉴스 준비중.....</div>
	<%
	out.print( "<font color='red' size=18>안녕</font>" );
	%>
</body>
</html>
<!-- 
HTML(단방향, 변수선언이나 제어문 지원안됨)은 순차적으로 실행
자바스크립트 코드의 위치에 따라서 document.querySelector(id or class or element) 
:선언이 먼저
-->
<!-- 자바스크립트 위치 
1) head안에 - 전역변수 선언, 함수 선언할 때(호출을해야 실행된다.)
만일 이것을 지연하고 싶을 때 - defer -미룬다. - HTMl, DOM TREE(브라우저가 하는 역할)

2) body안에 - 호출하지 않아도 실행된다. - 단 함수로 선언된 부분 제외

자바스크립트로 화면을 그릴 수 있다.

write는 어이다 쓰는 건가요 ? - 브라우저
java는 브라우저에 쓸 수 있다 | 없다.

jsp라고 쓰고 html이라고 읽기
jsp라고 쓰고 json이라고 읽기
image/png
image/jpg
image/gif
메인타입/서브타입
text/html
text/css
text/javascript
text/module

-->


