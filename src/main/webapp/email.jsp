<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<form method="post">
<input name = "email" value="${param['email']}"/>
<input type="submit" value="wyslij"/>
</form>
<c:if test="${komunikat != null}">
    <h1 style="color:red;">${komunikat}</h1>
    <script>alert("${komunikat}")</script>
</c:if>
