<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
String smem_id = (String) session.getAttribute("smem_id");
String smem_name = (String) session.getAttribute("smem_name");
out.print("From Session ===> " + smem_id + ", " + smem_name);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Web Application</title>
<%@ include file="../../common/easyUI_common.jsp"%>
<style type="text/css">
a {
	text-decoration: none;
}
</style>
<script type="text/javascript">

const signIn = () =>{
	/*select mem_name from scott.book_member
	where mem_id =:id
	and mem_pw=:pw*/
	const $user_id = $("#_easyui_textbox_input1").val();
	const $user_pw = $("#_easyui_textbox_input2").val();
	alert($user_id + ", "+ $user_pw);
}
</script>
</head>
<body>
  <h2>Web Application</h2>
  <div style="margin: 20px 0;"></div>
  <div class="easyui-layout" style="width: 1000px; height: 550px;">
    <!-- 메뉴 구성[로그인화면과 트리메뉴] -->
    <div id="p" data-options="region:'west'" title="KH정보교육원" style="width: 200px; padding: 10px">
      <!-- ==========[[[로그인 화면]]]========== -->
      <div id="div_login" align="center">
        <input id="textbox_id" type="text" style="width: 150px">
        <div style="margin: 3px 0;"></div>
        <input id="textbox_pw" type="text" style="width: 150px; margin-top: 20px">
        <div style="margin: 3px 0;"></div>
        <a id="signInButton" href="javascript:signIn()">로그인</a>
        <a id="signUpButton" href="javascript:signUp()">회원가입</a>
      </div>
      <script type="text/javascript">
							$('#textbox_id').textbox({
								iconCls : 'icon-man',
								iconAlign : 'right',
								prompt : 'ID',
							});
						</script>
      <script type="text/javascript">
							$(function() {
								$('#textbox_pw').passwordbox({
									prompt : 'PW',
									showEye : true,
								});
							});
						</script>
      <script type="text/javascript">
							$('#signInButton').linkbutton({
								iconCls : 'icon-man'
							});
						</script>
      <script type="text/javascript">
							$('#signUpButton').linkbutton({
								iconCls : 'icon-add'
							});
						</script>

      <div style="margin: 3px 0;"></div>
      <ul id="tree_gym" class="easyui-tree">
        <li data-options="state:'closed'">
          <span>회원관리</span>
          <ul>
            <li>
              <a href="#">회원목록</a>
            </li>
            <li>
              <a href="#">회원등록</a>
            </li>
            <li>
              <a href="#">회원삭제</a>
            </li>
        </li>
      </ul>
      </li>
      </ul>
    </div>

    <!-- ==========[[[로그아웃 화면]]]========== -->
    <div id="div_logout" align="center">
      <!-- ==========[[[로그아웃 화면]]]========== -->
    </div>
    <!-- ==========[[[로그아웃 화면]]]========== -->
    <!-- 메뉴 화면[게시판, 온라인시험, 회원관리(회원목록, 회원등록, 회원삭제), 우편번호검색기]-->
    <div data-options="region:'center'" title="Center"></div>
  </div>
</body>
</html>


</body>
</html>
<!-- 부트스트랩 
반응형지원, CSS라이브러리 사용
jEasyUI
이벤트처리(레거시시스템)
자바스크립트 - 표준이 아니다 -> jQuery 기반이다.
자바스크립트 기반의  UI솔루션을 사용하기 - 큰도움
개발자도구 활용 - 디버깅 -> 왜냐하면 html을 래핑하기 때문에
vue.js, reactjs
JSTL사용 - 1.1-> 1.2 -> 소개

로그인 테스트 흐름도 
1. intro아래 index.jsp 실행
2. 아이디와 비번을 입력받는다.
3. 로그인버튼을 누른다. -> 자바스크립트의 si gnIn() 호출
4. login.do 호출한다. -> 로그인 처리를 하는 서블릿 호출 - doGet(), doPost()
5. com.mvc.dao.MemberDao클래스의 인스턴스화
6. 메서드 호출 - 로그인처리
7. MemberDao의 login(Map[mem_id(사용자가 입력한 아이디)와 mem_pw(사용자가 입력한비번)]호출)
8. 리턴타입으로 Map을 받아온다(mem_id, mem_name)
9. 8번에서 돌려받은 Map에서 오라클서버에서 조회된 아이디와 이름을 세션에 담기
10. 페이지 이동은 sendRedirect나 forward 둘 다 가능하다. 
단 forward로 응답을 처리한 경우 인중 후에 다른 서비스르 forward로 처리하는 것이 불가능하다.
 -->
