<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import="domainModel.Medicamento" %>
<%@page import="java.util.List, java.util.Iterator" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Listagem de Medicamentos</title>
</head>
<body>
<%
	List medicamentos = (List) request.getAttribute("medicamentos");
	if(medicamentos != null){
		%>
		<table>
		<tr>
		<td>
<a> Cadastrar Medicamento </a>
</td>
</tr>
		<tr><td>ID</td><td>Nome</td></tr>
		<%
		Iterator it = medicamentos.iterator();
		while(it.hasNext()){
			Medicamento m= (Medicamento)it.next();
			%>
				<tr>
					<td><%=m.getId() %></td>
					<td><%=m.getReacao().getNome() %></td>
					<td><%=m.getNome() %></td>			
					<td><a href="/InteracoesMedicamentosas/Medicamentos?edit=<%=m.getId() %>">Editar</a></td>
					<td><a href="/InteracoesMedicamentosas/Medicamentos?del=<%=m.getId() %>">Apagar</a></td>
					
				</tr>
			<%
		}
		%>
		</table>
		<%
	}
%>
<a href="/InteracoesMedicamentosas/Medicamentos?edit=new">Criar Novo Medicamento</a>
<tr>
		<td>
<a href="http://localhost:8080/InteracoesMedicamentosas/index.jsp"> Voltar </a>
</td>
</tr>
</body>
</html>