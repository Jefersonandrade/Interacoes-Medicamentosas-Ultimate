<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page import="domainModel.Fabricante, java.util.*" %>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Sistema de Consulta de Interações Medicamentosas</title>
<link href="css/style_fabricante.css" rel="stylesheet" type="text/css" />
</head>

<body>
<%
	Fabricante fabricante = (Fabricante) request.getAttribute("fabricante");
	%>
<div id="container">
	<form id="form_fabricante" action="/InteracoesMedicamentosas/Fabricante" method="post">
		<div id="first_step">
			<h1>Cadastro de <span>Fabricantes</span></h1>
			<div class="form1">
				<table width="100%" border="1" cellpadding="2" cellspacing="0" align="left">
					<tr>
						<tr>
						  <input type="hidden" name="cod" id="cod" value="<% if(fabricante != null){ out.print(fabricante.getId()); } %>" />
						  <td width="22%" align="right">* Nome Fantasia:</td>
						  <td width="78%"><input name="nomefantasia" type="text" id="nomefantasia" size="52" maxlength="45" value="<% if(fabricante != null){ out.print(fabricante.getNomefantasia()); } %>" /></td>
						</tr>
						<tr>
						  <td align="right">* Raz&atilde;o Social: </td>
						  <td><input name="razaosocial" type="text" id="razaosocial" maxlength="45" size="52" value="<% if(fabricante != null){ out.print(fabricante.getRazaosocial() ); } %>" /></td>
						</tr>
						<tr>
						  <td align="right">CNPJ: </td>
						  <td><input name="cnpj" type="text" id="cnpj" size="25" maxlength="45" value="<% if(fabricante != null){ out.print(fabricante.getCnpj()); } %>" /></td>
						</tr>
						<tr>
						  <td align="right">* Respons&aacute;vel T&eacute;cnico:</td>
						  <td><input name="responsaveltecnico" type="text" id="responsaveltecnico" size="52" maxlength="45" value="<% if(fabricante != null){ out.print(fabricante.getResponsaveltecnico()); } %>" /></td>
						</tr>
						<tr>
						  <td align="right">* CRF:</td>
						  <td><input name="crfresponsavel" type="text" id="crfresponsavel" size="52" maxlength="20" value="<% if(fabricante != null){ out.print(fabricante.getCrfresponsavel()); } %>"/></td>
						</tr>
						<tr>
						  <th><br /></th>
						</tr>
						<tr>
						  <td align="right">* Endere&ccedil;o:<br /></td>
						  <td>
							<input name="endereco" type="text" id="endereco" size="52" maxlength="255" value="<% if(fabricante != null){ out.print(fabricante.getEndereco()); } %>" />
						  </td>
						</tr>
						<tr>
						  <td align="right">* Bairro: </td>
						  <td><input name="bairro" type="text" id="bairro" maxlength="45" value="<% if(fabricante != null){ out.print(fabricante.getBairro()); } %>" />
							<strong>Compl.:</strong>
							<input name="complemento" type="text" id="complemento" size="6" value="<% if(fabricante != null){ out.print(fabricante.getComplemento()); } %>" /> <strong>*N&ordm;:</strong>
							<input name="numero" type="text" id="numero" size="3" value="<% if(fabricante != null){ out.print(fabricante.getNumero()); } %>" /></td>
						</tr>
						<tr>
						  <td align="right">* Cidade:</td>
						  <td>
							<input name="cidade" type="text" id="cidade" maxlength="45" size="26" value="<% if(fabricante != null){ out.print(fabricante.getCidade()); } %>" />
							* Estado:
							<select name="uf" id="uf">
								<%
										if(fabricante == null){
											out.print("<option value=\"\">Estado</option>");
										}
										if(fabricante != null && fabricante.getUf().equals("")){
											out.print("<option value=\"\">Estado</option>");
										}
										if(fabricante != null && fabricante.getUf().equals("MG")){
											out.print("<option value=\"MG\" selected=\"selected\">MG</option>");
										}else{
											out.print("<option value=\"MG\">MG</option>");
										}
										if(fabricante != null && fabricante.getUf().equals("AC")){
											out.print("<option value=\"AC\" selected=\"selected\">AC</option>");
										}else{
											out.print("<option value=\"AC\">AC</option>");
										}if(fabricante != null && fabricante.getUf().equals("AL")){
											out.print("<option value=\"AL\" selected=\"selected\">AL</option>");
										}else{
											out.print("<option value=\"AL\">AL</option>");
										}
										if(fabricante != null && fabricante.getUf().equals("AM")){
											out.print("<option value=\"AM\" selected=\"selected\">AM</option>");
										}else{
											out.print("<option value=\"AM\">AM</option>");
										}
										if(fabricante != null && fabricante.getUf().equals("AP")){
											out.print("<option value=\"AP\" selected=\"selected\">AP</option>");
										}else{
											out.print("<option value=\"AP\">AP</option>");
										}
										if(fabricante != null && fabricante.getUf().equals("BA")){
											out.print("<option value=\"BA\" selected=\"selected\">BA</option>");
										}else{
											out.print("<option value=\"BA\">BA</option>");
										}if(fabricante != null && fabricante.getUf().equals("CE")){
											out.print("<option value=\"CE\" selected=\"selected\">CE</option>");
										}else{
											out.print("<option value=\"CE\">CE</option>");
										}
										if(fabricante != null && fabricante.getUf().equals("DF")){
											out.print("<option value=\"DF\" selected=\"selected\">DF</option>");
										}else{
											out.print("<option value=\"DF\">DF</option>");
										}
										if(fabricante != null && fabricante.getUf().equals("ES")){
											out.print("<option value=\"ES\" selected=\"selected\">ES</option>");
										}else{
											out.print("<option value=\"ES\">ES</option>");
										}
										if(fabricante != null && fabricante.getUf().equals("GO")){
											out.print("<option value=\"GO\" selected=\"selected\">GO</option>");
										}else{
											out.print("<option value=\"GO\">GO</option>");
										}if(fabricante != null && fabricante.getUf().equals("MA")){
											out.print("<option value=\"MA\" selected=\"selected\">MA</option>");
										}else{
											out.print("<option value=\"MA\">MA</option>");
										}
										if(fabricante != null && fabricante.getUf().equals("MS")){
											out.print("<option value=\"MS\" selected=\"selected\">MS</option>");
										}else{
											out.print("<option value=\"MS\">MS</option>");
										}
										if(fabricante != null && fabricante.getUf().equals("MT")){
											out.print("<option value=\"MT\" selected=\"selected\">MT</option>");
										}else{
											out.print("<option value=\"MT\">MT</option>");
										}
										if(fabricante != null && fabricante.getUf().equals("PA")){
											out.print("<option value=\"PA\" selected=\"selected\">PA</option>");
										}else{
											out.print("<option value=\"PA\">PA</option>");
										}if(fabricante != null && fabricante.getUf().equals("PB")){
											out.print("<option value=\"PB\" selected=\"selected\">PB</option>");
										}else{
											out.print("<option value=\"PB\">PB</option>");
										}
										if(fabricante != null && fabricante.getUf().equals("PE")){
											out.print("<option value=\"PE\" selected=\"selected\">PE</option>");
										}else{
											out.print("<option value=\"PE\">PE</option>");
										}
										if(fabricante != null && fabricante.getUf().equals("PI")){
											out.print("<option value=\"PI\" selected=\"selected\">PI</option>");
										}else{
											out.print("<option value=\"PI\">PI</option>");
										}
										if(fabricante != null && fabricante.getUf().equals("PR")){
											out.print("<option value=\"PR\" selected=\"selected\">PR</option>");
										}else{
											out.print("<option value=\"PR\">PR</option>");
										}if(fabricante != null && fabricante.getUf().equals("RJ")){
											out.print("<option value=\"RJ\" selected=\"selected\">RJ</option>");
										}else{
											out.print("<option value=\"RJ\">RJ</option>");
										}
										if(fabricante != null && fabricante.getUf().equals("RN")){
											out.print("<option value=\"RN\" selected=\"selected\">RN</option>");
										}else{
											out.print("<option value=\"RN\">RN</option>");
										}
										if(fabricante != null && fabricante.getUf().equals("RO")){
											out.print("<option value=\"RO\" selected=\"selected\">RO</option>");
										}else{
											out.print("<option value=\"RO\">RO</option>");
										}
										if(fabricante != null && fabricante.getUf().equals("RR")){
											out.print("<option value=\"RR\" selected=\"selected\">RR</option>");
										}else{
											out.print("<option value=\"RR\">RR</option>");
										}if(fabricante != null && fabricante.getUf().equals("RS")){
											out.print("<option value=\"RS\" selected=\"selected\">RS</option>");
										}else{
											out.print("<option value=\"RS\">RS</option>");
										}
										if(fabricante != null && fabricante.getUf().equals("SC")){
											out.print("<option value=\"SC\" selected=\"selected\">SC</option>");
										}else{
											out.print("<option value=\"SC\">SC</option>");
										}
										if(fabricante != null && fabricante.getUf().equals("SE")){
											out.print("<option value=\"SE\" selected=\"selected\">SE</option>");
										}else{
											out.print("<option value=\"SE\">SE</option>");
										}
										if(fabricante != null && fabricante.getUf().equals("SP")){
											out.print("<option value=\"SP\" selected=\"selected\">SP</option>");
										}else{
											out.print("<option value=\"SP\">SP</option>");
										}if(fabricante != null && fabricante.getUf().equals("TO")){
											out.print("<option value=\"TO\" selected=\"selected\">TO</option>");
										}else{
											out.print("<option value=\"TO\">TO</option>");
										}
								%>
						  </select>
						 </td>
						</tr>
						<tr>
						  <td align="right">* CEP:<br /></td>
						  <td><input name="cep" type="text" id="cep" size="10" maxlength="10" value="<% if(fabricante != null){ out.print(fabricante.getCep()); } %>" />
							Telefone:
							<input name="telefone" type="text" id="telefone" size="13" maxlength="13" value="<% if(fabricante != null){ out.print(fabricante.getTelefone()); } %>" /> 
							Ramal: 
							<input name="ramal" type="text" id="ramal" size="2" maxlength="3" value="<% if(fabricante != null){ out.print(fabricante.getRamal()); } %>" /> </td>
						</tr>
						<tr>
						  <td align="right">E-Mail:</td>
						  <td><input name="email" type="text" id="email" size="52" value="<% if(fabricante != null){ out.print(fabricante.getEmail()); } %>" /></td>
						</tr>
						<tr>
						  <td align="right">Site:</td>
						  <td><input name="site" type="text" id="site" size="52" value="<% if(fabricante != null){ out.print(fabricante.getSite()); } %>" /></td>
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
