<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="domainModel.Reacao, domainModel.PrincipioAtivo, domainModel.IndiceRisco, domainModel.IndiceGravidade, domainModel.IndiceConfiabilidade, java.util.*, java.util.Iterator" %>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Sistema de Consulta de Interações Medicamentosas</title>
<link href="css/style_fabricante.css" rel="stylesheet" type="text/css" />
</head>

<body>

<%
	Reacao reacao = (Reacao) request.getAttribute("reacao");
	List<PrincipioAtivo> principioativo = (List<PrincipioAtivo>) request.getAttribute("principiosativos");
	List<IndiceRisco> indicerisco = (List<IndiceRisco>) request.getAttribute("indicesriscos");
	List<IndiceGravidade> indicegravidade = (List<IndiceGravidade>) request.getAttribute("indicesgravidades");
	List<IndiceConfiabilidade> indiceconfiabilidade = (List<IndiceConfiabilidade>) request.getAttribute("indicesconfiabilidades");
%>

<div id="container">
	<form id="form_fabricante" action="/InteracoesMedicamentosas/Reacao" method="post">
		<div id="first_step">
			<h1>Cadastro de <span>Interações Medicamentosas</span></h1>
			<div class="form1">
				<table width="100%" border="1" cellpadding="2" cellspacing="0" align="left">
					<tr>
					<input type="hidden" name="cod" id="cod" value="<% if(reacao != null){ out.print(reacao.getId()); } %>" />
						<tr>
						  <input type="hidden" name="cod" id="cod" value="" />
						  <td width="22%" align="right"><h3>* Principio Ativo:</h3></td>
						  <td width="78%">
						  	<select name="principioativo" id="principioativo">
									<option value="">Informe o Principio Ativo</option> <%
									 Iterator it = principioativo.iterator();
										while(it.hasNext()){
											PrincipioAtivo pa =(PrincipioAtivo)it.next(); %>
											<% 
												if(reacao != null && reacao.getIdprincipiosativos().getId() == pa.getId()){ %>
													<option value="<%=pa.getId() %>" selected=\"selected\"><%=pa.getNome()%></</option>
												<%}else{%>
													<option value="<%=pa.getId() %>"><%=pa.getNome()%></option>
												<% }%>
										<%} %>
									
							</select>
						  </td>
						</tr>
						<tr>
						  <td align="right"><h3>* Principio Ativo: </h3></td>
						  <td>
						  	<select name="principioativo2" id="principioativo2">
						  				<option value=\"\">Informe o Principio Ativo</option>
										<% Iterator itpa2 = principioativo.iterator();
										while(itpa2.hasNext()){
											PrincipioAtivo pa2 =(PrincipioAtivo)itpa2.next(); %>
											<% 
												if(reacao != null && reacao.getIdprincipiosativos2().getId() == pa2.getId()){ %>
													<option value="<%=pa2.getId() %>" selected=\"selected\"><%=pa2.getNome()%></</option>
												<%}else{%>
													<option value="<%=pa2.getId() %>"><%=pa2.getNome()%></option>
												<% }%>
										<%} %>
							</select>
						  </td>
						</tr>
						<tr>
						  <td align="right"><h3>Indice Risco: </h3></td>
						  <td>
							<select name="indicerisco" id="indicerisco">
									<option value=\"\">Informe o Indice de Risco</option>
									<% Iterator itir = indicerisco.iterator();
									while(itir.hasNext()){
										IndiceRisco ir =(IndiceRisco)itir.next(); %>
										<% 
												if(reacao != null && reacao.getIdindicesriscos().getId() == ir.getId()){ %>
													<option value="<%=ir.getId() %>" selected=\"selected\"><%=ir.getNome()%></</option>
												<%}else{%>
													<option value="<%=ir.getId() %>"><%=ir.getNome()%></option>
												<% }%>
									<%} %>
							</select>
						  </td>
						</tr>
						<tr>
						  <td align="right"><h3>* Sumário:</h3></td>
						  <td><input name="sumario" type="text" id="sumario" size="52" maxlength="45" value="<% if(reacao != null){ out.print(reacao.getSumario()); } %>" /></td>
						</tr>
						<tr>
						  <td align="right"><h3>* Indice Gravidade:</h3></td>
						  <td>
							<select name="indicegravidade" id="indicegravidade">
								<option value=\"\">Informe o Indice de Gravidade</option>
									<% Iterator itig = indicegravidade.iterator();
									while(itig.hasNext()){
										IndiceGravidade ig =(IndiceGravidade)itig.next(); %>
										<% 
												if(reacao != null && reacao.getIdindicesgravidades().getId() == ig.getId()){ %>
													<option value="<%=ig.getId() %>" selected=\"selected\"><%=ig.getNome()%></</option>
												<%}else{%>
													<option value="<%=ig.getId() %>"><%=ig.getNome()%></option>
												<% }%>
									<%} %>
							</select>
						  </td>
						</tr>
						<tr>
						  <td align="right"><h3>* Indice Confiabilidade:</h3></td>
						  <td>
						  	<select name="indiceconfiabilidade" id="indiceconficabilidade">
						  		<option value=\"\">Informe o Indice de Gravidade</option>
						  		<% Iterator itic = indiceconfiabilidade.iterator();
									while(itic.hasNext()){
										IndiceConfiabilidade ic =(IndiceConfiabilidade)itic.next(); %>
										<% 
												if(reacao != null && reacao.getIdindicesconfiabilidades().getId() == ic.getId()){ %>
													<option value="<%=ic.getId() %>" selected=\"selected\"><%=ic.getNome()%></</option>
												<%}else{%>
													<option value="<%=ic.getId() %>"><%=ic.getNome()%></option>
												<% }%>
									<%} %>
							</select>
						  </td>
						</tr>
						<tr>
						  <td align="right" style="margin-top:-20px;"><h3>* Conduta:</h3></td>
						  <td><textarea name="conduta" id="conduta" cols="54" rows="5" ><% if(reacao != null){ out.print(reacao.getConduta()); } %></textarea></td>
						</tr>
						<tr>
						  <td align="right" style="margin-top:-20px;"><h3>* Discussão:</h3></td>
						  <td><textarea name="discussao" id="discussao" cols="54" rows="5" ><% if(reacao != null){ out.print(reacao.getDiscussao()); } %></textarea></td>
						</tr>
					</tr>
				</table>  
			</div>
		</div>      
		<div class="clear">
			<input id="submit" class="submit" type="submit" value="" name="submit" />   
		</div>     
	</form>
</div>
</body>
</html>