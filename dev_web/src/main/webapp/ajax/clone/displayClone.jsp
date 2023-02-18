<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>연합뉴스돌아가기.</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
<script type="text/javascript">
const autoReload = () =>{
	
	console.log('autoReload call');
	
	const url = 'newsListClone.jsp';
	
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
	window.addEventListener('load', function (event) {
		start = () => {
			setInterval(autoReload, 2000);
		}
		console.log('windowEvent');
		start();
		
    });
</script>
	<div id="d_news">연합뉴스</div>
</body>
</html>