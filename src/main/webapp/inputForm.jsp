<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>input form</title>
</head>

<body>
	<div style="width: 600px; height: 650px; background-color: pink; padding: 20px 0px 0px 10px">
	
		<form id="inputForm" action="/WAServer/saveAssemblyman.do" method="get">

			<table align="left">
				<tr>
					<td>의원 파일경로:</td>
					<td><input id="xmlUrl" type="text" name="xmlUrl"></td>
				</tr>
				<tr>
				<tr>
					<td><input type="submit" name="Submit" value="insert"></td>
				</tr>
			</table>
		</form>
		
		<form id="inputForm" action="/WAServer/selectAssemblyman.do" method="get">

			<table align="left">
				<tr>
					<td>의원번호:</td>
					<td><input id="manId" type="text" name="manId"></td>
				</tr>
				<tr>
				<tr>
					<td><input type="submit" name="Submit" value="select"></td>
				</tr>
			</table>
		</form>

		 ==========================================================================


		<form id="inputForm" action="/WAServer/saveGeneralMeeting.do" method="get">

			<table align="left">
				<tr>
					<td>general :</td>
					<td><input id="xmlUrl" type="text" name="xmlUrl"></td>
				</tr>
				<tr>
				<tr>
					<td><input type="submit" name="Submit" value="insert"></td>
				</tr>
			</table>
		</form>
		
		<form id="inputForm" action="/WAServer/selectGeneralMeeting.do" method="get">

			<table align="left">
				<tr>
					<td>회의번호 :</td>
					<td><input id="general_id" type="text" name="general_id"></td>
				</tr>
				<tr>
				<tr>
					<td><input type="submit" name="Submit" value="select"></td>
				</tr>
			</table>
		</form>


		==========================================================================


		<form id="inputForm" action="/WAServer/saveBill.do" method="get">

			<table align="left">
				<tr>
					<td>bill :</td>
					<td><input id="xmlUrl" type="text" name="xmlUrl"></td>
				</tr>
				<tr>
				<tr>
					<td><input type="submit" name="Submit" value="insert"></td>
				</tr>
			</table>
		</form>
		
		<form id="inputForm" action="/WAServer/selectBill.do" method="get">

			<table align="left">
				<tr>
					<td>법안번호 :</td>
					<td><input id="bill_id" type="text" name="bill_id"></td>
				</tr>
				<tr>
				<tr>
					<td><input type="submit" name="Submit" value="select"></td>
				</tr>
			</table>
		</form>

		==========================================================================


		<form id="inputForm" action="/WAServer/saveCommitteeMeeting.do" method="get">

			<table align="left">
				<tr>
					<td>committee :</td>
					<td><input id="xmlUrl" type="text" name="xmlUrl"></td>
				</tr>
				<tr>
				<tr>
					<td><input type="submit" name="Submit" value="insert"></td>
				</tr>
			</table>
		</form>
		
		<form id="inputForm" action="/WAServer/selectCommitteeMeeting.do" method="get">

			<table align="left">
				<tr>
					<td>위원회번호 :</td>
					<td><input id="committee_id" type="text" name="committee_id"></td>
				</tr>
				<tr>
				<tr>
					<td><input type="submit" name="Submit" value="select"></td>
				</tr>
			</table>
		</form>
		

		==========================================================================

		<form id="inputForm" action="/WAServer/saveVote.do" method="get">

			<table align="left">
				<tr>
					<td>vote :</td>
					<td><input id="xmlUrl" type="text" name="xmlUrl"></td>
				</tr>
				<tr>
				<tr>
					<td><input type="submit" name="Submit" value="insert"></td>
				</tr>
			</table>
		</form>
		
		<form id="inputForm" action="/WAServer/selectVote.do" method="get">

			<table align="left">
				<tr>
					<td>투표번호 :</td>
					<td><input id="vote_id" type="text" name="vote_id"></td>
				</tr>
				<tr>
				<tr>
					<td><input type="submit" name="Submit" value="select"></td>
				</tr>
			</table>
		</form>
		
		==========================================================================

		<form id="inputForm" action="/WAServer/saveParty.do" method="get">

			<table align="left">
				<tr>
					<td>party :</td>
					<td><input id="xmlUrl" type="text" name="xmlUrl"></td>
				</tr>
				<tr>
				<tr>
					<td><input type="submit" name="Submit" value="insert"></td>
				</tr>
			</table>
		</form>
		
	</div>

</body>
</html>



