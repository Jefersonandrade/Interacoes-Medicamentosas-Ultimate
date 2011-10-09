<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page import="domainModel.Medicamento,domainModel.Fabricante, java.util.*" %>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Sistema de Consulta de Intera��es Medicamentosas</title>
<link href="css/style_medicamento.css" rel="stylesheet" type="text/css" />
</head>

<body>
<%
	Medicamento medicamento = (Medicamento) request.getAttribute("medicamento");
	List<Fabricante> fabricantes = (List<Fabricante>) request.getAttribute("fabricantes");
	
	%>
<div id="container">
<form id="form_fabricantes" method="post" action="">
	<div id="first_step">
    	<h1> 
        Cadastro de <span>Medicamentos</span>
</h1>
        <div class="form1">
        <table width="100%" border="1" cellpadding="2" cellspacing="0" align="left">
        <tr>
          <td><table width="100%" border="1" cellpadding="2" cellspacing="0">
            <tr>
              <td width="22%" align="right">* Nome:</td>
              <td width="78%"><input name="nome" type="text" id="nome" size="52" maxlength="45" value="<% if(medicamento != null){ out.print(medicamento.getNomecomercial()); } %>" /></td>
            </tr>
             <tr>
              <th><br /></th>
            </tr>
            <tr>
              <td align="right">* Fabricante: </td>
              <td><select name="fabricante" id="fabricante">
              <%for(Fabricante f : fabricantes){ %>
                <option value="<%=f.getId() %>"><%=f.getNomeempresa() %></option>
              <%} %>
              </select></td>
            </tr>
             <tr>
              <th><br /></th>
            </tr>
            <tr>
              <td align="right">Forma Farmaceutica: </td>
              <td><input name="a" type="text" id="formafarmaceutica" size="25" maxlength="45" value="<% if(medicamento != null){ out.print(medicamento.getFormafarmaceutica()); } %>" /></td>
            </tr>
             <tr>
              <th><br /></th>
            </tr>
            <tr>
              <td align="right">* N�mero Registro:</td>
              <td><input name="num_registro" type="text" id="num_registro" size="25" maxlength="45" value="" />
              * Validade: 
                <input name="validade" type="text" id="validade" size="11" maxlength="10" value="" />
              </td>
            </tr>
            <tr>
              <th><br /></th>
            </tr>
            <tr>
          </table></td>
        </tr>
        </table>          
      </form>
      </div>      
<div class="clear">
        	<input id="submit" class="submit" type="submit" value="" name="submit" />   
        </div>
        </table>
        <div class="clear">
        </div>        
</form>
</div>
</body>
</html>