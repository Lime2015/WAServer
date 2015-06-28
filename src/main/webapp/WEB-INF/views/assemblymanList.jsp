<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>AssemblymanList</title>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
</head>
<body>
<h2>의원 목록</h2>
<table style="border:1px solid #ccc">
    <colgroup>
     	<col width="10%"/>
        <col width="10%"/>
        <col style="30%" />
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
            <c:when test="${fn:length(list) > 0}">
                <c:forEach items="${list}" var="row">
                    <tr>
                        <td>${row.update_tag }</td>
                        <td>${row.assemblyman_name }</td>
                        <td><img src="${row.image_url }" width="100px"/></td>
                        <td>${row.party_name }</td>
                        <td>${row.local_constituency }</td>
                    </tr>
                </c:forEach>
            </c:when>
            <c:otherwise>
                <tr>
                    <td colspan="5">조회된 결과가 없습니다.</td>
                </tr>
            </c:otherwise>
        </c:choose>
         
    </tbody>
</table>
</body>
</html>