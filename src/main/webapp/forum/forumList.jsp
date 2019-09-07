<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<c:set var = "title" scope = "page" value = "Lista forum"/>
<%@include file="header.jsp" %>

<div class="table100 ver5 m-b-110">
<div class="table100-head">
<table>
<thead>
<tr class="row100 head">
<th class="cell100 column1">Nazwa forum</th>
<th class="cell100 column2">Ilosc tematow</th>
<th class="cell100 column3">Ilosc uzytkownikow</th>
<th class="cell100 column4">Ostatni temat</th>
</tr>
</thead>
</table>
</div>
<div class="table100-body js-pscroll ps ps--active-y">
<table>
<tbody>
<c:forEach items="${forums}" var = "forum">
    <tr class="row100 body">
    <td class="cell100 column1"><a href="./subjectList?forumId=${forum.id}">${forum.name}</a></td>
    <td class="cell100 column2">${forum.subjectCount}</td>
    <td class="cell100 column3">${forum.userCount}</td>
    <td class="cell100 column4">${forum.lastSubject}</td>
    </tr>
</c:forEach>
</tbody>
</table>
<%@include file="footer.jsp" %>