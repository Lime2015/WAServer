<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Detail Assemblyman</title>
</head>
<body>
결과 : <%= request.getAttribute("result") %>

 <table class="board_view">
      
        <h2>게시글 상세</h2>
            <tr>
                <th >이미지</th>
                <td><img src="${result.image_url}"/></td>
                <th >이름</th>
                <td>${result.assemblyman_name}</td>
            </tr>
            <tr>
                <th scope="row">정당</th>
                <td>${result.party_name}</td>
                <th scope="row">지역구</th>
                <td>${result.local_constituency}</td>
            </tr>
            <tr>
                <th scope="row">버전</th>
                <td colspan="3">${result.update_tag}</td>
            </tr>
            <tr>
<%--                 <td colspan="4">${#}</td> --%>
            </tr>
    </table>
     
    <a href="#this" class="btn" id="list">목록으로</a>
    <a href="#this" class="btn" id="update">수정하기</a>
     
    <script type="text/javascript">
        $(document).ready(function(){
            $("#list").on("click", function(e){ //목록으로 버튼
                e.preventDefault();
                fn_openBoardList();
            });
             
            $("#update").on("click", function(e){
                e.preventDefault();
                fn_openBoardUpdate();
            });
        });
         
        function fn_openBoardList(){
            var comSubmit = new ComSubmit();
            comSubmit.setUrl("<c:url value='/sample/openBoardList.do' />");
            comSubmit.submit();
        }
         
        function fn_openBoardUpdate(){
            var idx = "${map.IDX}";
            var comSubmit = new ComSubmit();
            comSubmit.setUrl("<c:url value='/sample/openBoardUpdate.do' />");
            comSubmit.addParam("IDX", idx);
            comSubmit.submit();
        }
    </script>
</body>
</html>