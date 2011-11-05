<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>

<%@ page import="domainModel.Reacao" %>
<%@ page import="java.util.List, java.util.Iterator" %>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Sistema de Consulta de Interaes Medicamentosas</title>
<link href="css/style_lista.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div id="container" align="center">
	<div id="div_principal">
	<div style="width: 800px; margin: 0 auto; text-align: left;">
		<table>
			<tr>
				<td align="center">
					<label for="nome"> Adicionar novo </label><br>
					<a href="/InteracoesMedicamentosas/Reacao?edit=new">
						<img title="editar" alt="editar" src="images/adicionar.png"/>
					</a>
				</td>
				<td align="left">
					&nbsp;<label for="pesquisar">Pesquisar por Nome </label> <br/>
					&nbsp;<input type="text" size="60"  name="pesquisar" id="pesquisar"/>
				  	<input type="submit" id="submit_pesquisa" value=""/>
				</td>
			</tr>
		</table>
		
	</div>

<p></p>
<%
	List reacoes = (List) request.getAttribute("reacoes");
	if(reacoes != null){
%>
<table>
    <tr>
        <td class="table_top" >CODIGO</td>
        <td class="table_top" >SUMÁRIO</td>
        <td class="table_top">CONDUTA</td>
        <td class="table_top">DISCUSSÃO</td>
        <td class="table_top" >EDITAR/DASABILITAR</td>
    </tr>
    <tr>
        <%
		Iterator it = reacoes.iterator();
		while(it.hasNext()){
			Reacao r = (Reacao)it.next();
			%>
				<tr>
					<td><%=r.getId() %></td>
					<td><%=r.getSumario() %></td>	
					<td><%=r.getConduta() %></td>
					<td><%=r.getDiscussao() %></td>		
					<td align="center">
						<a href="/InteracoesMedicamentosas/Reacoes?edit=<%=r.getId() %>"><img title="editar" alt="editar" src="images/editar.png"/></a>
						<a href="/InteracoesMedicamentosas/Reacoes?del=<%=r.getId() %>"><img title="Desabilitar" alt="Desabilitar" src="images/bloquear.png" /></a>
					</td>
					
				</tr>
			<%
		}
		%>
</table>
<%
	}
%>
</div>
</div>
</body>
</html>