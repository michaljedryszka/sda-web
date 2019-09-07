<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var = "title" scope = "page" value = "Lista tematow"/>
<%@include file="header.jsp" %>
<div class="table100 ver5 m-b-110">
<div class="table100-head">
<table>
<thead>
<tr class="row100 head">
<th class="cell100 column1">Tytuł</th>
<th class="cell100 column2">Autor</th>
<th class="cell100 column3">Data publikacji</th>
<th class="cell100 column4">
    <a href="?forumId=${param['forumId']}&sort=asc">Data ostatniej odpowiedzi</a>
</th>
</tr>
</thead>
</table>
</div>
<div class="table100-body ">
<table>
<tbody>
<c:forEach items="${subjects}" var = "subject">
    <tr class="row100 body">
    <td class="cell100 column1"><a href="">${subject.title}</a></td>
    <td class="cell100 column2">${subject.author}</td>
    <td class="cell100 column3">
        <fmt:formatDate type="both" value="${subject.convertedDate}" />
    </td>
    <td class="cell100 column4">
        <fmt:formatDate type="both" value="${subject.lastAnswerDate}" />
    </td>
    </tr>
</c:forEach>
</tbody>
</table>
<%@include file="footer.jsp" %>