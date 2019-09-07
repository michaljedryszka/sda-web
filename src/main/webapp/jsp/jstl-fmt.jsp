<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<p>parseNumber</p>
<c:set var="Amount" value="786.9710" />
<fmt:parseNumber var="j" type="number" value="${Amount}" />
<p><i>Amount is:</i>  <c:out value="${j}" /></p>
<fmt:parseNumber var="j" integerOnly="true" type="number" value="${Amount}" />
<p><i>Amount is:</i>  <c:out value="${j}" /></p>

<p>formatNumber</p>
<fmt:formatNumber value="${Amount}" type="currency" /></p>
<p><fmt:formatNumber type="number" groupingUsed="true" value="${Amount}" /></p>
<p><fmt:formatNumber type="number" maxIntegerDigits="3" value="${Amount}" /></p>
<p><fmt:formatNumber type="number" maxFractionDigits="6" value="${Amount}" /></p>
<p><fmt:formatNumber type="percent" maxIntegerDigits="4" value="${Amount}" /></p>
<p><fmt:formatNumber type="number" pattern="###.###$" value="${Amount}" /></p>

<p>parseDate</p>
<c:set var="date" value="12-08-2016" />
<fmt:parseDate value="${date}"
    var="parsedDate"  pattern="dd-MM-yyyy" />
<p><c:out value="${parsedDate}" /></p>

<p>formatDate</p>
<c:set var="Date" value="<%=new java.util.Date()%>" />
<p><fmt:formatDate type="time" value="${Date}" /></p>
<p><fmt:formatDate type="date" value="${Date}" /></p>
<p><fmt:formatDate type="both" value="${Date}" /></p>