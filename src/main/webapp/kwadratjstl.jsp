<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<c:set var = "rozmiar" scope = "session" value = "1"/>
<c:if test = "${param['rozmiar'] ge 1}">
<c:set var = "rozmiar" scope = "session" value = "${param['rozmiar']}"/>
</c:if>
<table>
<c:forEach var = "i" begin = "0" end = "${rozmiar -1}">
    <tr>
    <c:forEach var = "j" begin = "0" end = "${rozmiar -1}">
      <c:choose>
         <c:when test = "${(i+j)%2 == 0}">
            <td>X</td>
         </c:when>
         <c:otherwise>
            <td>O</td>
         </c:otherwise>
      </c:choose>
    </c:forEach>
    </tr>
</c:forEach>
</table>
<script>
alert(123)
</script>