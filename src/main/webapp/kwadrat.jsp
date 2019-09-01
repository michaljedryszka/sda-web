<% int rozmiar = 0; %>
<%
    if(request.getParameter("rozmiar") != null){
        rozmiar = Integer.valueOf(request.getParameter("rozmiar"));
    }
%>
<table>
<% for(int i = 0; i < rozmiar; i ++) { %>
    <tr>
    <% for(int j = 0; j < rozmiar; j ++) { %>
        <% if ((i+j) % 2 == 0) { %>
            <td>X</td>
        <% } else { %>
            <td>O</td>
        <% } %>
    <% } %>
    </tr>
<% } %>
</table>