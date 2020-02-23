<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
Test na warunek
<% boolean zmienna = Boolean.valueOf(request.getParameter("zmienna")); %>
<% if(zmienna){ %>
<p>zmienna = true</p>
<% } else {%>
<p>zmienna = false</p>
<% } %>
<% for (int i = 0; i< 5; i++) { %>
<p><%=i%></p>
<% } %>

out constant value <c:out value="string"/><br/>
out variable <c:out value="${zmienna}"/><br/>
set variable <c:set var="testSet" value="${zmienna}"/><br/>
out variable testSet <c:out value="${testSet}"/><br/>
remove testSet <c:remove var="testSet" />
After remove testSet <c:out value="${testSet}"/><br/>

If: <c:if test="${zmienna}">warunek spelniony</c:if><br/>
Choose: <c:choose>
         <c:when test = "${zmienna}">
            warunek spelniony
         </c:when>
         <c:otherwise>
            warunek nie spelniony
         </c:otherwise>
</c:choose><br/>

Foreach:
<c:forEach items="${list}" var="item">
    <c:out value="${item}"/>
</c:forEach><br/>

Foreach z indexem
<c:forEach var = "i" begin = "1" end = "5">
    <c:out value = "${i}"/>
</c:forEach><br/>

parametr z requesta: ${param["parametr"]}
