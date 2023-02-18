<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>보드판매량</title>
<link rel="stylesheet" href="./board.css" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
<script type="text/javascript">
 
 const url = '../board/boardSellAction.html';
 
 function getBoardSold(){
	 $.ajax({
	TYPE: 'GET',
	url : url,
	success: function(result){
		console.log('success: function(result) ===> '+result);
		soldProcess(result);
	}
	});
 }
 
 function soldProcess(result){
	 console.log('soldProcess call ===> ' + result);
	 $('#boardSold').html(result);
	 
	 const price = $('#price').text();
	 console.log('price ===> ' + price);
	 
	 const cost = $('#cost').text();
	 console.log('cost ===> ' + cost);

	 let margin = price - cost ;
	 console.log('margin ===> ' + margin);
	 
	 let marginTotal = margin*result;
	 console.log('marginTotal ===> ' + marginTotal);
	 
	 $('#cash').html(marginTotal);
 }
 
 
 </script>

</head>
<body>
	<script>
window.addEventListener('load', (event)=>{
	const $btnMargin = document.querySelector('#btnMargin');
	
	$btnMargin.addEventListener('click',(event)=>{
		event.preventDefault();
		getBoardSold();
	});
});

</script>
	<h2>보드 판매량</h2>
	<table width="300px" height="80px">
		<tr>
			<th width="120px">보드 판매량</th>
			<td width="180px"><span id="boardSold">10</span></td>
		</tr>
		<!-- 
	소비자가-구매가=보드 한개당 마진 금액
	한개당 마진 금액*판매량=마진금액계산
	 -->
		<tr>
			<th>구매가</th>
			<td><span id="cost">100</span>원</td>
		</tr>
		<tr>
			<th>소비자가</th>
			<td><span id="price">120</span>원</td>
			<!-- span태그는 인라인요소 -->
		</tr>
	</table>
	<h2>
		마진금액 : <span id="cash">0</span>원
	</h2>
	<button type="submit" id="btnMargin">마진은?</button>
</body>
</html>