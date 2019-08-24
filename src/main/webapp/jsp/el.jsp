${"<p>Czesc</p>"}<br/>
${1 + 2}<br/>
${1 > 2}<br/>

<%
session.setAttribute("user","sonoo");
%>
W sesji ${ sessionScope.user }

<%
Cookie ck=new Cookie("name","abhishek");
response.addCookie(ck);
%>
W ciastku ${cookie.name.value}