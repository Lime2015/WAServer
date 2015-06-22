<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>input form</title>
</head>
<body>
	<form id="inputForm" action="/was/saveAssemblyman.do" method="get">

		<table align="left">
			<tr>
				<td>파일경로:</td>
				<td><input id="xmlUrl" type="text" name="xmlUrl"></td>
			</tr>
			<tr>
			<tr>
				<td><input type="submit" name="Submit" value="전송"></td>
			</tr>
		</table>
	</form>
</body>
</html>