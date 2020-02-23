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