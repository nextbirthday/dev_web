<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>부서관리2</title>
<%@ include file="../../common/easyUI_common.jsp"%>
<script type="text/javascript">
const insertForm = () => {
	console.log('insertForm call');
	  $('#dg_dept').dialog({
	        title: '부서정보등록',
	        width: 600,
	        height: 400,
	        closed: false,
	        cache: false,
	        href: 'insertDialog.jsp',
	        modal: true
	    });
  }
</script>
</head>
<body>

  <table id="dg">
    <div id="toolbar">
      <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-search" plain="true" onclick="selectDept()">조회</a>
      <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="insertForm()">입력</a>
      <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="updateDept()">수정</a>
      <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="deleteDept()">삭제</a>
    </div>
    <div id="dg_dept"></div>
  </table>

  <script>
  window.addEventListener("load", (event) => {
      $('#dg').datagrid({
        title: "부서관리2",
        url: '../dept.json',
        toolbar:"#toolbar",
        columns: [[
          { field: 'deptno', title: '부서번호', width: 100 },
          { field: 'dname', title: '부서명', width: 100 },
          { field: 'loc', title: '지역', width: 100, align: 'right' }
        ]]
      });
  });
</script>
</body>
</html>


