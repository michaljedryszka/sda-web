<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var = "title" scope = "page" value = "Lista tematow"/>
<%@include file="header.jsp" %>
<p>><a href="./forumList">Lista for</a></p>
<div class="table100 ver5 m-b-110">
<div class="table100-head">
<table>
<thead>
<tr class="row100 head">
<th class="cell100 column1">Tytuł</th>
<th class="cell100 column2">Autor</th>
<th class="cell100 column3">Data publikacji</th>
<th class="cell100 column4">
    <c:set var = "sortDirection" scope = "page" value = "${param['sort'] eq 'asc' ? 'desc' : 'asc'}"/>
    <c:set var = "arrow" scope = "page" value = "${param['sort'] eq 'asc' ? '&darr;' : '&uarr;'}"/>
    <a href="?forumId=${param['forumId']}&sort=${sortDirection}"> ${arrow} Data ostatniej odpowiedzi</a>
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
    <td class="cell100 column1">
    <a href="?forumId=${param['forumId']}&subjectToEdit=${subject.id}">E</a>
    <a href="./answerList?forumId=${param['forumId']}&subjectId=${subject.id}">${subject.title}</a></td>
    <td class="cell100 column2">${subject.author}</td>
    <td class="cell100 column3">
        <fmt:formatDate type="both" value="${subject.convertedDate}" />
    </td>
    <td class="cell100 column4">
        <fmt:formatDate type="both" value="${subject.lastAnswerDate}" />
        <a href="?forumId=${param['forumId']}&subjectToDelete=${subject.id}">X</a>
    </td>
    </tr>
</c:forEach>
</tbody>
</table>
  <form method="post">
    <label for="author">Autor</label>
    <input type="text" id="author" name="author" placeholder="Your name..">
    <label for="title">Tytuł</label>
    <input type="text" id="title" name="title" placeholder="Tytuł.." value="${subjectToEdit.title}"/>
    <label for="content">Tresc</label>
    <textarea cols="10" id="content" name="content" placeholder="Treść..">${subjectToEdit.content}</textarea>
    <input type="submit" value="Submit">
    <input type="hidden" name="forumId" value="${param['forumId']}">
    <input type="hidden" name="subjectToEdit" value="${param['subjectToEdit']}">
  </form>

<%@include file="footer.jsp" %>