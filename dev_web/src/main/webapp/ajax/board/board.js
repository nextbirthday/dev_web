/* 비동기통신객체 생성해서 담을 변수 선언 */
let xhrObject = null;

/* 비동기 통신객체 생성하는 함수 구현 - 단 리턴 예약어가 없어서 반환받을 수 없음 */
function createRequest() {
	try {
		xhrObject = new XMLHttpRequest(); /* constructor */
	} catch (trymicrosoft) {
		try {
			/* MS의 IE사용자 위한 객체 생성 */
			xhrObject = new ActiveXObject('Msxml2.XMLHTTP');
		} catch (error) {
			xhrObject = null;
		}
	}
	if (xhrObject == null) {
		alert('비동기 통신 객체 생성 에러');
	}
} //end of createRequest

//span태그가 가지고 있는 텍스트 노드값을 읽어오기
/* <td>100</td>태그이름이없다. 속성을 정의 못함 -> 아이디나 클래스를 정의 못함 -> 접근불가함 -> 어떡하지 */
/* 해결방법 - 그래서 텍스트노드에 span으로 감싼다. */
function getText(el) {
	let text = ''; //ES6 -> ECMAScript2015 - 적용이 안되는 브라우저이면 babel이 필요하다. or parcel
	if (el != null) {
		if (el.childNodes) {
			console.log(el + ', ' + el.childNodes.length);
			for (let i = 0; i < el.childNodes.length; i++) {
				//costEL, priceEL
				let childNode = el.childNodes[i]; //el.childNodes[0],el.childNodes[1],
				//너 텍스트 노드니?
				if (childNode.nodeValue != null) {
					text = text + childNode.nodeValue;
				}
			}
		}
	}
	return text;
}

//기존 TextNode의 값을 다른 문자열로 바꾸기
/***********************************************
	param1 :document.getElementById("boardSold")
	param1 :document.querySelector("#boardSold")
	param2 :xhrObject. 
	************************************************/
function replaceText(el, value) { //el->boardSoldEL(보드판매량), cashEL(마진)
	if (el != null) {
		clearText(el); //기존에 있던 10을 지워주세요.
		//새로운 텍스트 노드를 생성하기
		var newNode = document.createTextNode(value); //value의 값
		//위에서 생성한 텍스트 노드 값을 el에 붙이는 함수 호출하기
		el.appendChild(newNode); //el boardSoldEL -> <span>10</span> -> <span id='boardSold or cash'></span> -> <span>20</span>
	}
}
//기존 태그안에 문자열 지우는 함수 구현
function clearText(el) {
	if (el != null) {
		if (el.childNodes) { //자바스크립트에서 0이 아닌건 모두 참이다.
			for (let i = 0; i < el.childNodes.length; i++) {
				let childNode = el.childNodes[i];
				el.removeChild(childNode); //해당 el 삭제하기 - DOM API -> 직관적이지 않다. -> 유지보수 어렵다. -> 쓰기싫다.
			}
		}
	}
}

function createRequest2() {
	try {
		xhrObject = new XMLHttpRequest(); //constructor
	} catch (trymicrosoft) {
		try {
			//MSdml IE사용자 위한 객체 생성
			xhrObject = new ActiveXObject('Msxml2.XMLHTTP');
		} catch (error) {
			xhrObject = null;
		}
	}
	if (xhrObject == null) {
		alert('비동기 통신 객체 생성 에러');
	}
	return xhrObject;
} //end of createRequest
