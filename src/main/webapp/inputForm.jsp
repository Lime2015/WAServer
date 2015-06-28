<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>input form</title>
</head>

<body>
	<div style="width: 600px; height: 100%; background-color: pink; padding: 20px 30px 150px 30px">
		<form id="inputForm" action="/WAServer/saveAssemblyman.do" method="get">

				<h5>의원 파일경로 (assemblymen.xml)</h5> 
				<input id="xmlUrl" type="text" name="xmlUrl">
				<input type="submit" name="Submit" value="insert">
		</form>
		<br/>
		<form id="inputForm" action="/WAServer/selectAssemblyman.do" method="get">
				<h5>의원번호</h5>	
				<input id="manId" type="text" name="manId">
				<input type="submit" name="Submit" value="select">
		</form>
		<br/>
		<hr>
		
		<form id="inputForm" action="/WAServer/saveBill.do" method="get">
				<h5>bill (bill.xml)</h5>
				<input id="xmlUrl" type="text" name="xmlUrl">
				<input type="submit" name="Submit" value="insert">
		</form>
		
		<form id="inputForm" action="/WAServer/selectBill.do" method="get">
				<h5>법안번호</h5> 
				<input id="bill_id" type="text" name="bill_id">
				<input type="submit" name="Submit" value="select">
		</form>
		<br/>
		<hr>

		<form id="inputForm" action="/WAServer/saveGeneralMeeting.do" method="get">
				<h5>general (general_meeting_attend.xml)</h5>
				<input id="xmlUrl" type="text" name="xmlUrl">
				<input type="submit" name="Submit" value="insert">
		</form>
		
		<form id="inputForm" action="/WAServer/selectGeneralMeeting.do" method="get">
					<h5>회의번호 </h5>
					<input id="general_id" type="text" name="general_id">
					<input type="submit" name="Submit" value="select">
		</form>
		<br/>
		<hr>
		
		<form id="inputForm" action="/WAServer/saveCommitteeMeeting.do" method="get">
				<h5>committee (stand_committee_meeting_attend.xml)</h5>
				<input id="xmlUrl" type="text" name="xmlUrl">
				<input type="submit" name="Submit" value="insert">
		</form>
		
		<form id="inputForm" action="/WAServer/selectCommitteeMeeting.do" method="get">
				<h5>위원회번호</h5>
				<input id="committee_id" type="text" name="committee_id">
				<input type="submit" name="Submit" value="select">
		</form>
		
		<br/>
		<hr>

		<form id="inputForm" action="/WAServer/saveVote.do" method="get">
				<h5>vote (general_meeting_vote.xml)</h5> 
				<input id="xmlUrl" type="text" name="xmlUrl">
				<input type="submit" name="Submit" value="insert">
		</form>
		
		<form id="inputForm" action="/WAServer/selectVote.do" method="get">
				<h5>vote num</h5>
				<input id="vote_id" type="text" name="vote_id">
				<input type="submit" name="Submit" value="select">
		</form>
		<br/>
		<hr>


		<form id="inputForm" action="/WAServer/saveParty.do" method="get">
				<h5>party (party_histories.xml)</h5>
				<input id="xmlUrl" type="text" name="xmlUrl">
				<input type="submit" name="Submit" value="insert">
		</form>
		
		<form id="inputForm" action="/WAServer/selectVote.do" method="get">
				<h5>상태번호</h5>
				<input id="history_id" type="text" name="histoy_id">
				<input type="submit" name="Submit" value="select">
		</form>
		<br/>
		<hr>
		
	</div>
</body>
</html>



