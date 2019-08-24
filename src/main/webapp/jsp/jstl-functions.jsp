<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<p>Split:</p>
<c:set var="str1" value="Welcome-to-JSP-Programming."/>
<c:set var="str2" value="${fn:split(str1, '-')}" />
<c:set var="str3" value="${fn:join(str2, ' ')}" />

<p>String-3 : ${str3}</p>
<c:set var="str4" value="${fn:split(str3, ' ')}" />
<c:set var="str5" value="${fn:join(str4, '-')}" />

<p>String-5 : ${str5}</p>

<c:set var="String" value="Welcome to jsp"/>

<p>Contains</p>
<c:if test="${fn:contains(String, 'jsp')}">
   <p>Found jsp string<p>
</c:if>

<c:if test="${fn:contains(String, 'JSP')}">
   <p>Found JSP string<p>
</c:if>

<p>Length</p>
Length of the String-1 is: ${fn:length(str1)}<br>
Length of the String-2 is: ${fn:length(str2)}

<p>Replace</p>
<c:set var="author" value="Ramesh Kumar"/>
<c:set var="string" value="pqr xyz abc PQR"/>
${fn:replace(author, "Ramesh", "Suresh")}
${fn:replace(string, "pqr", "hello")}
