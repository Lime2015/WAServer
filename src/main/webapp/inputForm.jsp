<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>input form</title>
</head>

<body>
	<div style="width: 600px; height: 100%; background-color: pink;">
		<form id="inputForm" action="/WAServer/saveAssemblyman.do"
			method="get">

			<table align="left">
				<tr>
					<td>�ǿ� ���ϰ��:</td>
					<td><input id="xmlUrl" type="text" name="xmlUrl"></td>
				</tr>
				<tr>
				<tr>
					<td><input type="submit" name="Submit" value="insert"></td>
				</tr>
			</table>
		</form>
		<!-- 
	<form id="inputForm" action="/WAServer/updateAssemblyman.do" method="get">

		<table align="left">
			<tr>
				<td>���ϰ��:</td>
				<td><input id="xmlUrl" type="text" name="xmlUrl"></td>
			</tr>
			<tr>
			<tr>
				<td><input type="submit" name="Submit" value="update"></td>
			</tr>
		</table>
	</form>
	 -->
		<form id="inputForm" action="/WAServer/selectAssemblyman.do"
			method="get">

			<table align="left">
				<tr>
					<td>�ǿ���ȣ:</td>
					<td><input id="manId" type="text" name="manId"></td>
				</tr>
				<tr>
				<tr>
					<td><input type="submit" name="Submit" value="select"></td>
				</tr>
			</table>
		</form>

		<hr> ============================================================


		<form id="inputForm" action="/WAServer/saveGeneralMeeting.do"
			method="get">

			<table align="left">
				<tr>
					<td>general :</td>
					<td><input id="xmlUrl" type="text" name="xmlUrl"></td>
				</tr>
				<tr>
				<tr>
					<td><input type="submit" name="Submit" value="select"></td>
				</tr>
			</table>
		</form>


		<br> ============================================================


		<form id="inputForm" action="/WAServer/saveBill.do" method="get">

			<table align="left">
				<tr>
					<td>bill :</td>
					<td><input id="xmlUrl" type="text" name="xmlUrl"></td>
				</tr>
				<tr>
				<tr>
					<td><input type="submit" name="Submit" value="select"></td>
				</tr>
			</table>
		</form>

		<br> ============================================================


		<form id="inputForm" action="/WAServer/saveCommitteeMeeting.do"
			method="get">

			<table align="left">
				<tr>
					<td>committee :</td>
					<td><input id="xmlUrl" type="text" name="xmlUrl"></td>
				</tr>
				<tr>
				<tr>
					<td><input type="submit" name="Submit" value="select"></td>
				</tr>
			</table>
		</form>

		<br> ============================================================

		<form id="inputForm" action="/WAServer/saveVote.do" method="get">

			<table align="left">
				<tr>
					<td>vote :</td>
					<td><input id="xmlUrl" type="text" name="xmlUrl"></td>
				</tr>
				<tr>
				<tr>
					<td><input type="submit" name="Submit" value="select"></td>
				</tr>
			</table>
		</form>
		
		<br> ============================================================

		<form id="inputForm" action="/WAServer/saveParty.do" method="get">

			<table align="left">
				<tr>
					<td>party :</td>
					<td><input id="xmlUrl" type="text" name="xmlUrl"></td>
				</tr>
				<tr>
				<tr>
					<td><input type="submit" name="Submit" value="select"></td>
				</tr>
			</table>
		</form>
	</div>

</body>
</html>



