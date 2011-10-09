<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page import="domainModel.Reacao" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Editar Reacao</title>
</head>
<body>
	<%
	Reacao reacao = (Reacao) request.getAttribute("reacao");
	%>
	<form action="/InteracoesMedicamentosas/Reacoes" method="post">
		<table>
			<tr>
				<td>
					Codigo:
				</td>
				<td>
					<input type="text" name="id" value="<% if(reacao != null){ out.print(reacao.getId()); } %>" />
				</td>
			</tr>
			
			<tr>
				<td>
					Nome:
				</td>
				<td>
					<input type="text" name="nome" value="<% if(reacao != null){ out.print(reacao.getNome()); } %>" />
				</td>
			</tr>
		</table>
		<input type="submit" value="Salvar" />
	</form>

</body>
</html>