<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <div id="root"></div>
  <script type="text/javascript">
			const rootElement = document.querySelector('#root');
			const h1Element = document.createElement("h1");
			h1Element.textContent = "DOM Make";
			rootElement.appendChild(h1Element);
		</script>
</body>
</html>