<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import="domainModel.PrincipioAtivo" %>
<%@page import="java.util.List, java.util.Iterator" %>
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
					<a href="/InteracoesMedicamentosas/PrincipioAtivo?edit=new">
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
	List principiosativos = (List) request.getAttribute("principiosativos");
	if(principiosativos != null){
%>
<table>
    <tr>
        <td class="table_top" >CODIGO</td>
        <td class="table_top" >NOME</td>
        <td class="table_top" >EDITAR/DASABILITAR</td>
    </tr>
    <tr>
        <%
		Iterator it = principiosativos.iterator();
		while(it.hasNext()){
			PrincipioAtivo pa= (PrincipioAtivo)it.next();
			%>
				<tr>
					<td><%=pa.getId() %></td>
					<td><%=pa.getNome() %></td>			
					<td align="center">
						<a href="/InteracoesMedicamentosas/PrincipiosAtivos?edit=<%=pa.getId() %>"><img title="editar" alt="editar" src="images/editar.png"/></a>
						<a href="/InteracoesMedicamentosas/PrincipiosAtivos?del=<%=pa.getId() %>"><img title="Desabilitar" alt="Desabilitar" src="images/bloquear.png" /></a>
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
