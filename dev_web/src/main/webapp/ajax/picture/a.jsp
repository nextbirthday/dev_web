<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ajax로 요청하기</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
<script type="text/javascript">
	function methodA() {
		alert("methodA 호출")
		let pic = 5;
		$.ajax({
			type : 'GET',

			url : 'b.jsp?id=' + pic + '&timestamp=' + new Date().getTime(),

			data : 'id=' + pic,

			dataType : 'html',

			success : function(result) {
				console.log(result);
				/* 	$('#photo').css('left', $(td).offset().left + 50 + "px");
					$('#photo').css('left', $(td).offset().top + "px"); */
				$('#photo').html(result);
			},
		});
	}
</script>
</head>
<body onLoad="methodA()">
	<div id="photo"></div>
</body>
</html>