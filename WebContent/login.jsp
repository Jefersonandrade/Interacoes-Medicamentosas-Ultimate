<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="domainModel.Usuario" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Sistema de Consulta de Intera��es Medicamentosas</title>
<link href="../InteracoesMedicamentosas/css/style.css" rel="stylesheet" type="text/css" />
</head>

<body>
<% String erro = (String)request.getAttribute("erro"); 
 if(erro != null){
	 %><p>Atencao! Aconteceu um erro: <%=erro %></p><% 
 }
%>

<div id="container">
<form id="form_login" method="post" action="">
	<div id="first_step">
    	<h1> 
        Sistema de Consulta de <br>

		<span>Intera��es Medicamentosas</span>
        </h1>
        <div class="form">
          <table width="570" style=" height:50px; width:50px">
        <tr>
        	<td>
           	<h2>Usu�rio:</h2>
            </td>

            <td>
            	<input id="username" type="text" name="username"/>
            </td>
        </tr>
        <tr>
        	<td>
       		<h2>Senha: </h2></td>
            <td>
            	<input id="password" type="password" name="senha"/>
            </td>
            <tr>
           	  <td>
              </td>
                <td>
               		Ainda N�o Tem Cadastro?
                </td>
            </tr>

         </table>
      </div>      
	  <div class="clear">
        	<input id="submit_first" class="submit" type="submit" value="" name="submit_firt" />        
      </div>
        </table>
        <div class="clear">
        </div>        
    </div>
</form>
</div>

</body>
</html>
