<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page import="domainModel.PrincipioAtivo, java.util.*" %>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Sistema de Consulta de Interações Medicamentosas</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
</head>

<body>
<%
	PrincipioAtivo principioativo = (PrincipioAtivo) request.getAttribute("principioativo");
	%>
<div id="container_">
<form id="form_login" method="post" action="/InteracoesMedicamentosas/PrincipioAtivo">
	<div id="first_step">
		<br></br><br></br><br></br>
    	<h1>Cadastro de	<span>Princípios Ativos</span></h1>
        <div class="form">
			<table width="570" style=" height:50px; width:50px">
				<tr>
					<input type="hidden" name="cod" id="cod" value="<% if(principioativo != null){ out.print(principioativo.getId()); } %>" />
					<td>
						<h2>Principio Ativo</h2>
					</td>
					<td>
						<input id="nome" type="text" name="nome" value="<% if(principioativo != null){ out.print(principioativo.getNome()); } %>"/>
					</td>
				</tr>
				<tr>
					<td>&nbsp;</td>
				</tr>
			</table>
		</div>      
		<div class="clear">
			<input id="submit" class="submit" type="submit" value="" name="submit" />        
		</div>
	</div>
</form>
</div>
</body>
</html>
