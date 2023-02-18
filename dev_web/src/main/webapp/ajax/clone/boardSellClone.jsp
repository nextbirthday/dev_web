<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>BoardSellClone</title>
<link rel="stylesheet" href="./board.css" />
<script defer src="./boardLogic.js"></script>
<script type="text/javascript">
	function getBoardSold() {

		xhrObject = createRequest2();
		console.log(xhrObject);

		const url = '../board/boardSellAction.html';

		xhrObject.open('GET', url, true);
		xhrObject.onreadystatechange = soldProcess;
		xhrObject.send();
	}

	function soldProcess() {
		console.log('soldProcess call ===>' + xhrObject.readyState);
		if (xhrObject.readyState == 4) {
			if (xhrObject.status == 200) {
				const newTotal = xhrObject.responseText;

				const boardSoldElement = document.querySelector('#boardSold');
				replaceText(boardSoldElement, newTotal);

				const priceElement = document.querySelector('#price');
				let price = getText(priceElement);

				const costElement = document.querySelector('#cost');
				let cost = getText(costElement);

				let cashPerBoard = price - cost;
				let cash = cashPerBoard * newTotal;

				alert('마진금액은 ' + cash + '입니다.');

				const cashElement = document.querySelector('#cash');
				replaceText(cashElement, cash);
			}
		}
	}
</script>
</head>

<script type="module">

window.addEventListener('load', (event) => {
const $btnMargin = document.querySelector('#btnMargin');
$btnMargin.addEventListener('click',(event)=>{
event.preventDefault(); 
getBoardSold();
});
});
</script>

<body>
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