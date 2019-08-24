<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<p>${film.tytul}<p>
<table>
    <c:forEach items="${listaKin}" var = "kino">
    <tr>
        <td>${kino.nazwa}</td><td>
        <c:forEach items="${kino.seanse}" var = "seans">
            <a href="">${seans.godzina}</a>
        </c:forEach>
        </td>
    </tr>
    </c:forEach>
<table>