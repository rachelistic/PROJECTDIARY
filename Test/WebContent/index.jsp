<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index.jsp</title>
</head>
<body>

	<div align="center">
		<br> <br> <br> &ensp;
		<h1>&ensp;&ensp;로 그 인</h1>
		<form id="frm" name="frm" style="width: 250px; height: 200px;"
			action="/Test/InsertUser.do">
			<table style="width: 260px; height: 60px;'">
				<tr>
					<th>아이디</th>
					<td><input type="text" id="id" name="id"></td>
				</tr>
				<tr>
					<th>패스워드</th>
					<td><input type="text" id="pw" name="pw"></td>
					<td><input type="hidden" id="crypted" name="crypted" value=""></td>
				</tr>
			</table>
			<div align="right">
				<br> <input type="button" onClick="Check()" value="등록">
			</div>
		</form>

	</div>


</body>

<script type="text/javascript">

function Check(){
	if(document.frm.id.value == ''){
		alert("숫자로 된 아이디를 입력하세욤");
		return false;

	}else if(document.frm.pw.value == ''){
		alert("비번을 입력하세욤");
		return false;
		
	}else{
		alert("등록 완료, 컨트롤러로 연결합니다.");
		document.frm.submit();
	} 	
	
}

</script>

</html>
