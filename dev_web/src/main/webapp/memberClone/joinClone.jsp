<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 클론</title>
<script type="text/javascript">

signUp = () => {
	const $signUp = document.querySelector("#signUp");
	$signUp.submit();
};

</script>
</head>
<body>
  <form id="signUp" action="./joinActionClone.jsp" method="get">
    <div>
      <label>아이디</label>
      <input type="text" id="user_id" name="user_id" placeholder="아이디" required>
    </div>
    <div>
      <label>비밀번호</label>
      <input type="password" id="user_pw" name="user_pw1" required>
    </div>
    <div>
      <label>생년월일</label>
      <input type="date" id="user_birth" name="user_birth" required>
    </div>
    <div>
      <label>프로필사진</label>
      <input type="file" id="user_image" name="user_image">
    </div>
    <div>
      <label>주소</label>
      <input type="text" id="user_address" name="user_address" size="60" placeholder="주소">
      <button id="addressSearch">주소검색</button>
    </div>
    <div>
      <input type="reset" value="초기화">
      <input type="button" class="singUp" onclick="signUp()" value="회원가입">
    </div>
  </form>
</body>
</html>