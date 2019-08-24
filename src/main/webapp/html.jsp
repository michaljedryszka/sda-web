<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<c:set var="rozmiar" value="${param.rozmiar}"/>
<c:set var="znak" value="X"/>
<c:forEach var = "x" begin = "1" end = "${rozmiar}">
    <c:forEach var = "y" begin = "1" end = "${rozmiar}">
      <c:choose>
         <c:when test = "${(x + y) % 2 == 0}">
            <c:out value="O"/>
         </c:when>
         <c:otherwise>
            <c:out value="X"/>
         </c:otherwise>
      </c:choose>
    </c:forEach>
    <br/>
</c:forEach>