<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var = "title" scope = "page" value = "Lista odpowiedzi"/>
<%@include file="header.jsp" %>
<p>><a href="./forumList">Lista for</a> > <a href="./subjectList?forumId=${param['forumId']}">Lista tematow</a></p>
<div class="table100 ver5 m-b-110">
<div class="table100-head">
<table>
<thead>
<tr class="row100 head">
<th class="cell100 column1">Autor</th>
<th class="cell100 column2">Tresc</th>
<th class="cell100 column3">Data</th>
</tr>
</thead>
</table>
</div>
<div class="table100-body ">
<table>
<tbody>
<c:forEach items="${answers}" var = "answer">
    <tr class="row100 body">
    <td class="cell100 column1">
        ${answer.author}
    </td>
    <td class="cell100 column2">
        ${answer.content}
    </td>
    <td class="cell100 column3">
        <fmt:formatDate type="both" value="${answer.convertedDate}" />
    </td>
    </tr>
</c:forEach>
</tbody>
</table>
  <form method="post">
    <label for="author">Autor</label>
    <input type="text" id="author" name="author" placeholder="Your name..">
    <label for="content">Odpowiedź</label>
    <textarea cols="10" id="content" name="content" placeholder="Comment.."></textarea>
    <input type="submit" value="Submit">
    <input type="hidden" name="forumId" value="${param['forumId']}">
    <input type="hidden" name="subjectId" value="${param['subjectId']}">
  </form>
<%@include file="footer.jsp" %>