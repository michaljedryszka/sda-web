<%@ page language="java" %>

<h1>Prosty servlet z danymi w atrybutach</h1><br/>
${atrybutZadania}<br/>
${atrybutSesji}<br/>
${atrybutKontekstu}<br/>

Odczyt parametru zadania<br/>
<p>${param["parametr"] + 100}</p>
<p>${c}</p>
<p>${paramValues == '1'}</p>
<p>${paramValues['a']}</p>

