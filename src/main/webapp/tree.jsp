<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="n" value="7"/>
<c:set var="zmienna" value="O"/>
<c:forEach var="i" begin="0" end="${n}">
    <c:forEach var="j" begin="0" end="${i}">
        <c:out value="${zmienna}"/>
        <c:choose>
         <c:when test="${zmienna == 'O'}">
            <c:set var="zmienna" value="X"/>
         </c:when>
         <c:otherwise>
            <c:set var="zmienna" value="O"/>
         </c:otherwise>
        </c:choose>
    </c:forEach>
    <br/>
</c:forEach>