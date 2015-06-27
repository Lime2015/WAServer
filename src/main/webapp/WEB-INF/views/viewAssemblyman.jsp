<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Assemblyman</title>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
</head>

<body>
	<h2>의원 검색</h2>
 <table style="border:1px solid #ccc">
    <colgroup>
     	<col width="10%"/>
        <col width="10%"/>
        <col width="30%" />
        <col width="15%"/>
        <col width="*"/>
    </colgroup>
    <thead>
        <tr>
        	<th scope="col">버전</th>
            <th scope="col">이름</th>
            <th scope="col">이미지</th>
            <th scope="col">정당</th>
            <th scope="col">지역구</th>
        </tr>
    </thead>
    <tbody>
        <c:choose>
            <c:when test="${not empty result}">
                    <tr>
                        <td>${result.update_tag }</td>
                        <td>${result.assemblyman_name }</td>
                        <td><img src="${result.image_url }" width="100px"/></td>
                        <td>${result.party_name }</td>
                        <td>${result.local_constituency }</td>
                    </tr>
            </c:when>
            <c:otherwise>
                <tr>
                    <td colspan="5">조회된 결과가 없습니다.</td>
                </tr>
            </c:otherwise>
        </c:choose>
        <tr>
        	<td colspan="5"> <%= request.getAttribute("result") %> </td>
        </tr>
    </tbody>
    
</table>
<!--      
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
     -->
    
</body>
</html>