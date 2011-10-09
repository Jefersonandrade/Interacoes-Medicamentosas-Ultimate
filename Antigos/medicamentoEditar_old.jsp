<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page import="domainModel.Medicamento, java.util.*, domainModel.Reacao" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Editar Medicamento</title>
</head>
<body>
	<%
	Medicamento medicamento = (Medicamento) request.getAttribute("medicamento");
	//Listagem de reacoes em Medicamentos
	List medicamentos = (List)request.getAttribute("reacoes");
	%>
	<form action="/InteracoesMedicamentosas/Medicamentos" method="post">
		<table>
			<tr>
				<td>
					Codigo:
				</td>
				<td>
					<input type="text" name="id" value="<% if(medicamento != null){ out.print(medicamento.getId()); } %>" />
				</td>
			</tr>
			
			<tr>
				<td>
					Nome:
				</td>
				<td>
					<input type="text" name="nome" value="<% if(medicamento != null){ out.print(medicamento.getNome()); } %>" />
				</td>
			</tr>
			
			<tr><td>Reacao</td></tr>
			<select name="codReacao">
				<%Iterator it = medicamentos.iterator();
				while(it.hasNext()){
					Reacao r=(Reacao)it.next(); %>
					<option value="<%=r.getId() %>"><%=r.getNome()%></option>
				
				<%} %>
			</select>
		</table>
		<input type="submit" value="Salvar" />
	</form>

</body>
</html>