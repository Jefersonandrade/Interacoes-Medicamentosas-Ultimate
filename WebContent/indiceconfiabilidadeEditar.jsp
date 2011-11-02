<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page import="domainModel.IndiceConfiabilidade, java.util.*" %>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Sistema de Consulta de Interações Medicamentosas</title>
<link href="css/style_indice.css" rel="stylesheet" type="text/css" />
</head>

<body>
<%
	IndiceConfiabilidade indiceconfiabilidade = (IndiceConfiabilidade) request.getAttribute("indiceconfiabilidade");
	%>
<div id="container_">
<form id="form_indiceconfiabilidade" action="/InteracoesMedicamentosas/IndiceConfiabilidade" method="post">
	<div id="first_step">
    	<h1> 
        Cadastro de <span>Indice de Confiabilidade</span>
      </h1>
        <div class="form">
          <table width="570" style=" height:50px; width:50px">
        <tr>
        	<input type="hidden" name="cod" id="cod" value="<% if(indiceconfiabilidade != null){ out.print(indiceconfiabilidade.getId()); } %>" />
        	<td>
           	<h2>Nome:</h2>
            </td>
            <td>
            <% if(indiceconfiabilidade != null){ %>
               <input type="hidden" name="id" value="<%=indiceconfiabilidade.getNome() %>"/>
            <%} %>
            	<input id="nome" type="text" name="nome" size="45" value="<% if(indiceconfiabilidade != null){ out.print(indiceconfiabilidade.getNome()); } %>"/> 
            </td>
        </tr>
        <tr align="center" valign="middle">
        	<td>
       		<h2>Descrição: </h2></td>
            <td>
            	  <textarea name="descricao" id="descricao" cols="45" rows="5" ><% if(indiceconfiabilidade != null){ out.print(indiceconfiabilidade.getDescricao()); } %></textarea>
       	    </td>
            
         </table>
      </div>      
		<div class="clear">
		        	<input id="submit_first" class="submit" type="submit" value="" name="submit_firt" />
		</div>       
    </div>
</form>
</div>
</body>
</html>

