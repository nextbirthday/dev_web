<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>insertDialog</title>
<%@ include file="../../common/easyUI_common.jsp"%>
</head>
<body>
  <div style="margin: 20px 0;"></div>
  <div style="margin: 30px 0;">
    <form id="f_dept" method="get">
      <div style="margin-bottom: 20px">
        <input class="easyui-textbox" name="deptno" label="부서번호" labelPosition="top" data-options="prompt:'Enter an deptno'" style="width: 60%;">
      </div>
      <div style="margin-bottom: 20px">
        <input class="easyui-textbox" name="dname" label="부서명" labelPosition="top" data-options="prompt:'Enter an dname'" style="width: 60%;">
      </div>
      <div style="margin-bottom: 20px">
        <input class="easyui-textbox" name="loc" label="지역" labelPosition="top" data-options="prompt:'Enter an loc'" style="width: 60%;">
      </div>
      <div style="text-align: center">
        <a href="javascript:insertAction()" class="easyui-linkbutton" iconCls="icon-ok" style="width: 30%; height: 32px;">등록</a>
      </div>
    </form>
  </div>
  <script type="text/javascript">

const insertAction = ()=>{
  console.log('insertAction call');
  console.log($("#_easyui_textbox_input1").val()+", "+ $("#_easyui_textbox_input2").val()+", "+$("#_easyui_textbox_input3").val());

  const u_deptno = $("#_easyui_textbox_input1").val();
  const u_dname = $("#_easyui_textbox_input2").val();
  const u_loc = $("#_easyui_textbox_input3").val();
  $.ajax({
  method:"get",
  url:"/jEasyUI/dept/insertAction.do?deptno="+u_deptno+"&dname="+u_dname+"&loc="+u_loc,
      success:function(data){
        console.log("톰캣 서버에서 응답으로 보낸 값 ===> " + data);
  },
  error:function(xhrObject){
	  console.log(xhrObject.responseText);
  }
})
}
</script>
</body>
</html>