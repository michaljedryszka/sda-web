<%@ page language="java" import="java.util.*"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<% int i = 100; %>
<%! int j = 100; %>
<% List listaStringow = new ArrayList(); %>
<% request.setAttribute("listaStringow", listaStringow); %>
<% listaStringow.add("s1");listaStringow.add("s2");listaStringow.add("s3"); %>
<% request.setAttribute("i", i); %>

<p>c:out</p>
<p>i: <c:out value="i"/></p>
<p>i: <c:out value="${i}"/></p>
<p>j: <c:out value="j"/></p>
<p>j: <c:out value="${j}"/></p>
<p>lista stringow: <c:out value="${listaStringow}"/></p>

<p>c:set</p>
<c:set var = "salary" scope = "session" value = "${2000*2}"/>
<p>salary <c:out value = "${salary}"/></p>
<p><c:out value = "${salary*3}"/></p>
<c:remove var = "salary"/>
<p><c:out value = "${salary}"/> po usunieciu</p>

<p>catch i if:</p>
<p>
      <c:catch var ="catchException">
         <% int x = 5/0;%>
      </c:catch>

      <c:if test = "${catchException != null}">
         <p>The exception is : ${catchException} <br />
         There is an exception: ${catchException.message}</p>
      </c:if>
</p>
<p>choose when otherwise</p>
<p>
      <c:set var = "salary" scope = "session" value = "${2000*2}"/>
      <p>Your salary is : <c:out value = "${salary}"/></p>
      <c:choose>
         <c:when test = "${salary <= 0}">
            Salary is below or equal zero.
         </c:when>
         <c:when test = "${salary > 1000}">
            Salary is above thousand.
         </c:when>
         <c:otherwise>
            Somwhere between 0 and 1000
         </c:otherwise>
      </c:choose>
</p>
<p>foreach</p>
<p>
      <c:forEach var = "i" begin = "1" end = "5">
         <p>Item <c:out value = "${i}"/></p>
      </c:forEach>

      <c:forEach items="${listaStringow}" var = "s" varStatus="loop">
         <p><c:out value = "${s} ${loop.index}"/></p>
      </c:forEach>

<p>param + url</p>
<c:url value = "/all.html" var = "url">
   <c:param name = "p1" value = "1234"/>
   <c:param name = "p2" value = "summary"/>
</c:url>
<p>${url}</p>