/**
 * 
 */
let xhrObject = null;

function createRequest() {
	try {
		xhrObject = new XMLHttpRequest(); //constructor
	} catch (trymicrosoft) {
		try {
			xhrObject = new ActiveXObject('Msxml2.XMLHTTP');
		} catch (error) {
			xhrObject = null;
		}
	}
	if (xhrObject == null) {
		alert('비동기 통신 객체 생성 에러');
	}
};

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
};

function getText(element) {

	let text = '';

	if (element != null) {
		if (element.childNodes) {
			console.log(element + ', ' + element.childNodes.length);
			for (let i = 0; i < element.childNodes.length; i++) {
				
				let childNode = element.childNodes[i]; 
				
				if (childNode.nodeValue != null) {
					text = text + childNode.nodeValue;
				}
			}
		}
	}
	return text;
}

function replaceText(element, value) { 
	if (element != null) {
		clearText(element); 

		const newNode = document.createTextNode(value);

		element.appendChild(newNode); //el boardSoldEL -> <span>10</span> -> <span id='boardSold or cash'></span> -> <span>20</span>
	}
}

function clearText(element) {
	if (element != null) {
		if (element.childNodes) { 
			for (let i = 0; i < element.childNodes.length; i++) {
				let childNode = element.childNodes[i];
				element.removeChild(childNode);  
			}
		}
	}
}

