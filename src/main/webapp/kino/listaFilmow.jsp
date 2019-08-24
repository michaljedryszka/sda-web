<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<script>
function ustawMiasto(miasto){
    var url = document.location + "";
    if(url.includes("?")){
        url = url.split("?")[0];
    }
    document.location = url + "?miasto=" + miasto;
    return true;
}
</script>
</head>
<body>
<table>
    <tr>
        <td>
            Wybierz miasto: <select id="miasto" name="miasto" onchange="ustawMiasto(this.value)">
                <option>Warszawa</option>
                <option>Wroclaw</option>
                <option>Gdansk</option>
            </select>
        </td>
        <td>
            Wybierz date: <input/>
        </td>
    </tr>
    <c:forEach items="${filmy}" var = "film">
    <tr>
        <td><a href="stronaFilmu?idFilmu=${film.id}">${film.tytul}</a></td>
    </tr>
    </c:forEach>

</table>
</body>
</html>