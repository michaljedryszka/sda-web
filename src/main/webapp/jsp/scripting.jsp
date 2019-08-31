<%@ page language="java" %>
<%-- Komentarz--%>
Deklaruje zmienna i<br/>
<% int i = 0; %>
Inkrementuje i wypisuje <%= ++i %><br/>
Inkrementuje ponownie<br/>
<% i++; %>
Wypisuje z uzyciem out <% out.print(i); %><br/>
Wypisujemy w petli<br/>
<% for(int k = 0; k <= i; k++){ %>
Wartosc k=<%=k%><br/>
<% } %>
<%
    int parametr = 5;
    if(request.getParameter("parametr") != null){
        parametr = Integer.valueOf(request.getParameter("parametr"));
    }
%>
<% if (i < parametr) { %>
i jest mniejsze od <%=parametr%>
<% } else {%>
i jest wieksze od <%=parametr%>
<% } %>
<p>${param['parametr']}</p>