<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page import="domainModel.Usuario, java.util.*, java.text.*"  %>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Sistema de Consulta de Interações Medicamentosas</title>
<link href="css/style_usuario.css" rel="stylesheet" type="text/css" />
</head>

<body>

<script language="javascript">

function VerificaCPF () {
if (vercpf(document.frmcpf.cpf.value)) 
{document.frmcpf.submit();}else 
{errors="1";if (errors) alert('CPF NÃO VÁLIDO');
document.retorno = (errors == '');}}
function vercpf (cpf) 
{if (cpf.length != 11 || cpf == "00000000000" || cpf == "11111111111" || cpf == "22222222222" || cpf == "33333333333" || cpf == "44444444444" || cpf == "55555555555" || cpf == "66666666666" || cpf == "77777777777" || cpf == "88888888888" || cpf == "99999999999")
return false;
add = 0;
for (i=0; i < 9; i ++)
add += parseInt(cpf.charAt(i)) * (10 - i);
rev = 11 - (add % 11);
if (rev == 10 || rev == 11)
rev = 0;
if (rev != parseInt(cpf.charAt(9)))
return false;
add = 0;
for (i = 0; i < 10; i ++)
add += parseInt(cpf.charAt(i)) * (11 - i);
rev = 11 - (add % 11);
if (rev == 10 || rev == 11)
rev = 0;
if (rev != parseInt(cpf.charAt(10)))
return false;
alert('O CPF INFORMADO É VÁLIDO.');
return true;}

</script>

<script src="js/jquery.js" type="text/javascript"></script>
<script src="js/jquery.validate.js" type="text/javascript"></script>
<script src="js/jquery.maskedinput.js" type="text/javascript"></script>
<script type="text/javascript">

  $(document).ready( function() {
	$("#datanascimento").mask("99/99/9999");
	$("#cep").mask("99.999-999");
	$("#telefone").mask("(99)9999-9999");
	$("#form_usuario").validate({
		// Define as regras
		rules:{
			nome:{
				// campoNome será obrigatório (required) e terá tamanho mínimo (minLength)
				required: true, minlength: 2
			},
			identidade:{
				// campoNome será obrigatório (required) e terá tamanho mínimo (minLength)
				required: true, minlength: 2
			},
			cpf:{
				// campoNome será obrigatório (required) e terá tamanho mínimo (minLength)
				required: true, minlength: 2
			},
			estadocivil:{
				// campoNome será obrigatório (required) e terá tamanho mínimo (minLength)
				required: true, minlength: 1
			},
			profissao:{
				// campoNome será obrigatório (required) e terá tamanho mínimo (minLength)
				required: true, minlength: 2
			},
			data_nascimento:{
				// campoMensagem será obrigatório (required) e terá tamanho mínimo (minLength)
				required: true
			},
			naturalidade:{
				// campoNome será obrigatório (required) e terá tamanho mínimo (minLength)
				required: true, minlength: 2
			},
			estadonaturalidade:{
				// campoNome será obrigatório (required) e terá tamanho mínimo (minLength)
				required: true, minlength: 1
			},

			endereco:{
				// campoNome será obrigatório (required) e terá tamanho mínimo (minLength)
				required: true, minlength: 2
			},
			bairro:{
				// campoNome será obrigatório (required) e terá tamanho mínimo (minLength)
				required: true, minlength: 2
			},
			numero:{
				// campoNome será obrigatório (required) e terá tamanho mínimo (minLength)
				required: true, minlength: 2
			},
			cidade:{
				// campoNome será obrigatório (required) e terá tamanho mínimo (minLength)
				required: true, minlength: 2
			},
			estado:{
				// campoNome será obrigatório (required) e terá tamanho mínimo (minLength)
				required: true, minlength: 1
			},
			cep:{
				// campoNome será obrigatório (required) e terá tamanho mínimo (minLength)
				required: true, minlength: 2
			},
			telefone:{
				// campoNome será obrigatório (required) e terá tamanho mínimo (minLength)
				required: true, minlength: 2
			},
			
			email:{
				// campoEmail será obrigatório (required) e precisará ser um e-mail válido (email)
				required: true, email: true
			},
			user:{
				// campoNome será obrigatório (required) e terá tamanho mínimo (minLength)
				required: true, minlength: 2
			},
			senha:{
				// campoNome será obrigatório (required) e terá tamanho mínimo (minLength)
				required: true, minlength: 6
			},
			tipo:{
				// campoNome será obrigatório (required) e terá tamanho mínimo (minLength)
				required: true, minlength: 2
			}
		},
		// Define as mensagens de erro para cada regra
		messages:{
			nome:{
				required: "Digite o seu nome",
				minlength: "O seu nome deve conter, no mínimo, 2 caracteres"
			},
			identidade:{
				required: "Digite a sua Identidade",
				minlength: "O seu Identidade deve conter, no mínimo, 5 caracteres"
			},
			cpf:{
				required: "Digite o seu CPF",
				minlength: "O seu CPF deve conter, no mínimo, 12 caracteres"
			},
			estadocivil:{
				required: "Selecione o seu Estado Civil"
			},
			profissao:{
				required: "Digite a sua Profissão",
				minlength: "O seu nome deve conter, no mínimo, 2 caracteres"
			},
			data_nascimento:{
				required: "Digite a sua data de nascimento"
			},
			naturalidade:{
				required: "Digite a sua Naturalidade",
				minlength: "O seu nome deve conter, no mínimo, 2 caracteres"
			},
			estadonaturalidade:{
				required: "Selecione a sua Naturalidade",
			},
			
			endereco:{
				required: "Digite o seu Endereço",
				minlength: "O seu endereço deve conter, no mínimo, 2 caracteres"
			},
			bairro:{
				required: "Digite o seu Bairro",
				minlength: "O seu bairro deve conter, no mínimo, 2 caracteres"
			},
			numero:{
				required: "Digite o numero de sua residencia",
				minlength: "O numero deve conter, no mínimo, 1 caracteres"
			},
			cidade:{
				required: "Digite o nome da cidade onde mora",
				minlength: "O seu nome deve conter, no mínimo, 2 caracteres"
			},
			estado:{
				required: "Selecione o estado onde mora"
			},
			cep:{
				required: "Digite o seu cep",
				minlength: "O seu cep deve conter, 8 caracteres"
			},
			telefone:{
				required: "Digite o seu telefone",
				minlength: "O seu telefone deve conter, 10 caracteres"
			},
			
			email:{
				required: "Digite o seu e-mail",
				email: "Digite um e-mail válido"
			},
			user:{
				required: "Digite o seu Usuário",
				minlength: "O seu usuario deve conter, no mínimo, 2 caracteres"
			},
			senha:{
				required: "Digite a sua senha",
				minlength: "A senha deve conter, no mínimo, 6 caracteres"
			},
			tipo:{
				required: "Selecione o tipo de seu usuario"
			}
		}
	});
});
  </script>

<%
	Usuario usuario = (Usuario) request.getAttribute("usuario");
    
	%>
<div id="container">
<form id="form_usuario" action="/InteracoesMedicamentosas/Usuario" method="post">
	<div id="first_step">
    	<h1> 
			Cadastro de <span>Usuarios</span>
        </h1>
        <div class="form1">
			<table width="100%" border="1" cellpadding="2" cellspacing="0" align="left">
				<tr>
				  <td>
						<table width="100%" border="1" cellpadding="2" cellspacing="0">
							<tr>
							  <input type="hidden" name="cod" id="cod" value="<% if(usuario != null){ out.print(usuario.getId()); } %>" />
							  <td width="22%" align="right">* Nome:</td>
							  <td width="78%"><input name="nome" type="text" id="nome" size="52" maxlength="45" value="<% if(usuario != null){ out.print(usuario.getNome()); } %>"/></td>
							</tr>
							<tr>
							  <td align="right">* Identitade: </td>
							  <td><input name="identidade" type="text" id="identidade" size="20" maxlength="20" value="<% if(usuario != null){ out.print(usuario.getIdentidade()); } %>" />
							 CPF:
								<input name="cpf" type="text" id="cpf" onFocus="VerificaCPF()" size="22" maxlength="15" value="<% if(usuario != null){ out.print(usuario.getCpf()); } %>" /></td>
							</tr>
							<tr>
							  <td align="right">* Estado Civil: </td>
							  <td>
							  	<select name="estadocivil" id="estadocivil">
									  <%
										if(usuario == null){
											out.print("<option value=\"\">Estado Civil</option>");
										}
									  	if(usuario != null && usuario.getEstadocivil().equals("")){
									  		out.print("<option value=\"\">Estado Civil</option>");
									  	}
										if(usuario != null && usuario.getEstadocivil().equals("S")){
											out.print("<option value=\"S\" selected=\"selected\">Solteiro</option>");
										}else{
											out.print("<option value=\"S\">Solteiro</option>");
										}
										if(usuario != null && usuario.getEstadocivil().equals("C")){
											out.print("<option value=\"C\" selected=\"selected\">Casado</option>");
										}else{
											out.print("<option value=\"C\">Casado</option>");
										}
										if(usuario != null && usuario.getEstadocivil().equals("V")){
											out.print("<option value=\"V\" selected=\"selected\">Viúvo</option>");
										}else{
											out.print("<option value=\"V\">Viúvo</option>");
										}
										if(usuario != null && usuario.getEstadocivil().equals("D")){
											out.print("<option value=\"D\" selected=\"selected\">Divorciado</option>");
										}else{
											out.print("<option value=\"D\">Divorciado</option>");
										}
									  %>	  
								</select>
							 * Profissão:
                             <input name="profissao" type="text" id="profissao" size="20" maxlength="20" value="<% if(usuario != null){ out.print(usuario.getProfissao()); } %>"/>
								</td>
							</tr>
							<tr>
								<td align="right">* Data Nascimento: </td>
								<td>
									<input name="datanascimento" type="text" id="datanascimento" size="11" maxlength="10" value="<% if(usuario != null){ SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy"); out.print(df.format(usuario.getDatanascimento())); } %>" />
									* Sexo:
										<select name="sexo" id="sexo">
											<%
												if(usuario == null){
													out.print("<option value=\"\">Informe o Sexo</option>");
												}
												if(usuario != null && usuario.getSexo().equals("")){
													out.print("<option value=\"\">Informe o Sexo</option>");
												}
												if(usuario != null && usuario.getSexo().equals("M")){
													out.print("<option value=\"M\" selected=\"selected\">Masculino</option>");
												}else{
													out.print("<option value=\"M\">Masculino</option>");
												}
												if(usuario != null && usuario.getSexo().equals("F")){
													out.print("<option value=\"F\" selected=\"selected\">Feminino</option>");
												}else{
													out.print("<option value=\"F\">Feminino</option>");
												}
											%>
										</select>
								</td>
							</tr>
							<tr>
							  <td width="22%" align="right">* Naturalidade:</td>
							  <td width="78%"><input name="naturalidade" type="text" id="naturalidade" size="25" maxlength="25" value="<% if(usuario != null){ out.print(usuario.getNaturalidade()); } %>" />
							  * Estado:
								<select name="estadonaturalidade" id="estadonaturalidade">
								<%
									if(usuario == null){
										out.print("<option value=\"\">Estado</option>");
									}
									if(usuario != null && usuario.getEstadonaturalidade().equals("")){
										out.print("<option value=\"\">Estado</option>");
									}
									if(usuario != null && usuario.getEstadonaturalidade().equals("MG")){
										out.print("<option value=\"MG\" selected=\"selected\">MG</option>");
									}else{
										out.print("<option value=\"MG\">MG</option>");
									}
									if(usuario != null && usuario.getEstadonaturalidade().equals("AC")){
										out.print("<option value=\"AC\" selected=\"selected\">AC</option>");
									}else{
										out.print("<option value=\"AC\">AC</option>");
									}if(usuario != null && usuario.getEstadonaturalidade().equals("AL")){
										out.print("<option value=\"AL\" selected=\"selected\">AL</option>");
									}else{
										out.print("<option value=\"AL\">AL</option>");
									}
									if(usuario != null && usuario.getEstadonaturalidade().equals("AM")){
										out.print("<option value=\"AM\" selected=\"selected\">AM</option>");
									}else{
										out.print("<option value=\"AM\">AM</option>");
									}
									if(usuario != null && usuario.getEstadonaturalidade().equals("AP")){
										out.print("<option value=\"AP\" selected=\"selected\">AP</option>");
									}else{
										out.print("<option value=\"AP\">AP</option>");
									}
									if(usuario != null && usuario.getEstadonaturalidade().equals("BA")){
										out.print("<option value=\"BA\" selected=\"selected\">BA</option>");
									}else{
										out.print("<option value=\"BA\">BA</option>");
									}if(usuario != null && usuario.getEstadonaturalidade().equals("CE")){
										out.print("<option value=\"CE\" selected=\"selected\">CE</option>");
									}else{
										out.print("<option value=\"CE\">CE</option>");
									}
									if(usuario != null && usuario.getEstadonaturalidade().equals("DF")){
										out.print("<option value=\"DF\" selected=\"selected\">DF</option>");
									}else{
										out.print("<option value=\"DF\">DF</option>");
									}
									if(usuario != null && usuario.getEstadonaturalidade().equals("ES")){
										out.print("<option value=\"ES\" selected=\"selected\">ES</option>");
									}else{
										out.print("<option value=\"ES\">ES</option>");
									}
									if(usuario != null && usuario.getEstadonaturalidade().equals("GO")){
										out.print("<option value=\"GO\" selected=\"selected\">GO</option>");
									}else{
										out.print("<option value=\"GO\">GO</option>");
									}if(usuario != null && usuario.getEstadonaturalidade().equals("MA")){
										out.print("<option value=\"MA\" selected=\"selected\">MA</option>");
									}else{
										out.print("<option value=\"MA\">MA</option>");
									}
									if(usuario != null && usuario.getEstadonaturalidade().equals("MS")){
										out.print("<option value=\"MS\" selected=\"selected\">MS</option>");
									}else{
										out.print("<option value=\"MS\">MS</option>");
									}
									if(usuario != null && usuario.getEstadonaturalidade().equals("MT")){
										out.print("<option value=\"MT\" selected=\"selected\">MT</option>");
									}else{
										out.print("<option value=\"MT\">MT</option>");
									}
									if(usuario != null && usuario.getEstadonaturalidade().equals("PA")){
										out.print("<option value=\"PA\" selected=\"selected\">PA</option>");
									}else{
										out.print("<option value=\"PA\">PA</option>");
									}if(usuario != null && usuario.getEstadonaturalidade().equals("PB")){
										out.print("<option value=\"PB\" selected=\"selected\">PB</option>");
									}else{
										out.print("<option value=\"PB\">PB</option>");
									}
									if(usuario != null && usuario.getEstadonaturalidade().equals("PE")){
										out.print("<option value=\"PE\" selected=\"selected\">PE</option>");
									}else{
										out.print("<option value=\"PE\">PE</option>");
									}
									if(usuario != null && usuario.getEstadonaturalidade().equals("PI")){
										out.print("<option value=\"PI\" selected=\"selected\">PI</option>");
									}else{
										out.print("<option value=\"PI\">PI</option>");
									}
									if(usuario != null && usuario.getEstadonaturalidade().equals("PR")){
										out.print("<option value=\"PR\" selected=\"selected\">PR</option>");
									}else{
										out.print("<option value=\"PR\">PR</option>");
									}if(usuario != null && usuario.getEstadonaturalidade().equals("RJ")){
										out.print("<option value=\"RJ\" selected=\"selected\">RJ</option>");
									}else{
										out.print("<option value=\"RJ\">RJ</option>");
									}
									if(usuario != null && usuario.getEstadonaturalidade().equals("RN")){
										out.print("<option value=\"RN\" selected=\"selected\">RN</option>");
									}else{
										out.print("<option value=\"RN\">RN</option>");
									}
									if(usuario != null && usuario.getEstadonaturalidade().equals("RO")){
										out.print("<option value=\"RO\" selected=\"selected\">RO</option>");
									}else{
										out.print("<option value=\"RO\">RO</option>");
									}
									if(usuario != null && usuario.getEstadonaturalidade().equals("RR")){
										out.print("<option value=\"RR\" selected=\"selected\">RR</option>");
									}else{
										out.print("<option value=\"RR\">RR</option>");
									}if(usuario != null && usuario.getEstadonaturalidade().equals("RS")){
										out.print("<option value=\"RS\" selected=\"selected\">RS</option>");
									}else{
										out.print("<option value=\"RS\">RS</option>");
									}
									if(usuario != null && usuario.getEstadonaturalidade().equals("SC")){
										out.print("<option value=\"SC\" selected=\"selected\">SC</option>");
									}else{
										out.print("<option value=\"SC\">SC</option>");
									}
									if(usuario != null && usuario.getEstadonaturalidade().equals("SE")){
										out.print("<option value=\"SE\" selected=\"selected\">SE</option>");
									}else{
										out.print("<option value=\"SE\">SE</option>");
									}
									if(usuario != null && usuario.getEstadonaturalidade().equals("SP")){
										out.print("<option value=\"SP\" selected=\"selected\">SP</option>");
									}else{
										out.print("<option value=\"SP\">SP</option>");
									}if(usuario != null && usuario.getEstadonaturalidade().equals("TO")){
										out.print("<option value=\"TO\" selected=\"selected\">TO</option>");
									}else{
										out.print("<option value=\"TO\">TO</option>");
									}
								%>
							  </select>
							  </td>
							</tr>
							<tr>
							  <th style="color:#C33">Endereço</th>
							</tr>
							<tr>
							  <td align="right">* Endere&ccedil;o:<br /></td>
							  <td>
								<input name="endereco" type="text" id="endereco" size="52" maxlength="255" value="<% if(usuario != null){ out.print(usuario.getEndereco()); } %>" />
							  </td>
							</tr>
							<tr>
							  <td align="right">* Bairro: </td>
							  <td><input name="bairro" type="text" id="bairro" maxlength="45" value="<% if(usuario != null){ out.print(usuario.getBairro()); } %>" />
								Compl.:
								<input name="complemento" type="text" id="complemento" size="6" value="<% if(usuario != null){ out.print(usuario.getComplemento()); } %>" /> 
								*N&ordm;:
								<input name="numero" type="text" id="numero" size="3" value="<% if(usuario != null){ out.print(usuario.getNumero()); } %>" /></td>
							</tr>
							<tr>
							  <td align="right">* Cidade:</td>
							  <td>
								<input name="cidade" type="text" id="cidade" maxlength="45" size="26" value="<% if(usuario != null){ out.print(usuario.getCidade()); } %>" />
								* Estado:	
								<select name="estado" id="estado">
									<%
										if(usuario == null){
											out.print("<option value=\"\">Estado</option>");
										}
										if(usuario !=null && usuario.getEstado().equals("")){
											out.print("<option value=\"\">Estado</option>");
										}
										if(usuario != null && usuario.getEstado().equals("MG")){
											out.print("<option value=\"MG\" selected=\"selected\">MG</option>");
										}else{
											out.print("<option value=\"MG\">MG</option>");
										}
										if(usuario != null && usuario.getEstado().equals("AC")){
											out.print("<option value=\"AC\" selected=\"selected\">AC</option>");
										}else{
											out.print("<option value=\"AC\">AC</option>");
										}if(usuario != null && usuario.getEstado().equals("AL")){
											out.print("<option value=\"AL\" selected=\"selected\">AL</option>");
										}else{
											out.print("<option value=\"AL\">AL</option>");
										}
										if(usuario != null && usuario.getEstado().equals("AM")){
											out.print("<option value=\"AM\" selected=\"selected\">AM</option>");
										}else{
											out.print("<option value=\"AM\">AM</option>");
										}
										if(usuario != null && usuario.getEstado().equals("AP")){
											out.print("<option value=\"AP\" selected=\"selected\">AP</option>");
										}else{
											out.print("<option value=\"AP\">AP</option>");
										}
										if(usuario != null && usuario.getEstado().equals("BA")){
											out.print("<option value=\"BA\" selected=\"selected\">BA</option>");
										}else{
											out.print("<option value=\"BA\">BA</option>");
										}if(usuario != null && usuario.getEstado().equals("CE")){
											out.print("<option value=\"CE\" selected=\"selected\">CE</option>");
										}else{
											out.print("<option value=\"CE\">CE</option>");
										}
										if(usuario != null && usuario.getEstado().equals("DF")){
											out.print("<option value=\"DF\" selected=\"selected\">DF</option>");
										}else{
											out.print("<option value=\"DF\">DF</option>");
										}
										if(usuario != null && usuario.getEstado().equals("ES")){
											out.print("<option value=\"ES\" selected=\"selected\">ES</option>");
										}else{
											out.print("<option value=\"ES\">ES</option>");
										}
										if(usuario != null && usuario.getEstado().equals("GO")){
											out.print("<option value=\"GO\" selected=\"selected\">GO</option>");
										}else{
											out.print("<option value=\"GO\">GO</option>");
										}if(usuario != null && usuario.getEstado().equals("MA")){
											out.print("<option value=\"MA\" selected=\"selected\">MA</option>");
										}else{
											out.print("<option value=\"MA\">MA</option>");
										}
										if(usuario != null && usuario.getEstado().equals("MS")){
											out.print("<option value=\"MS\" selected=\"selected\">MS</option>");
										}else{
											out.print("<option value=\"MS\">MS</option>");
										}
										if(usuario != null && usuario.getEstado().equals("MT")){
											out.print("<option value=\"MT\" selected=\"selected\">MT</option>");
										}else{
											out.print("<option value=\"MT\">MT</option>");
										}
										if(usuario != null && usuario.getEstado().equals("PA")){
											out.print("<option value=\"PA\" selected=\"selected\">PA</option>");
										}else{
											out.print("<option value=\"PA\">PA</option>");
										}if(usuario != null && usuario.getEstado().equals("PB")){
											out.print("<option value=\"PB\" selected=\"selected\">PB</option>");
										}else{
											out.print("<option value=\"PB\">PB</option>");
										}
										if(usuario != null && usuario.getEstado().equals("PE")){
											out.print("<option value=\"PE\" selected=\"selected\">PE</option>");
										}else{
											out.print("<option value=\"PE\">PE</option>");
										}
										if(usuario != null && usuario.getEstado().equals("PI")){
											out.print("<option value=\"PI\" selected=\"selected\">PI</option>");
										}else{
											out.print("<option value=\"PI\">PI</option>");
										}
										if(usuario != null && usuario.getEstado().equals("PR")){
											out.print("<option value=\"PR\" selected=\"selected\">PR</option>");
										}else{
											out.print("<option value=\"PR\">PR</option>");
										}if(usuario != null && usuario.getEstado().equals("RJ")){
											out.print("<option value=\"RJ\" selected=\"selected\">RJ</option>");
										}else{
											out.print("<option value=\"RJ\">RJ</option>");
										}
										if(usuario != null && usuario.getEstado().equals("RN")){
											out.print("<option value=\"RN\" selected=\"selected\">RN</option>");
										}else{
											out.print("<option value=\"RN\">RN</option>");
										}
										if(usuario != null && usuario.getEstado().equals("RO")){
											out.print("<option value=\"RO\" selected=\"selected\">RO</option>");
										}else{
											out.print("<option value=\"RO\">RO</option>");
										}
										if(usuario != null && usuario.getEstado().equals("RR")){
											out.print("<option value=\"RR\" selected=\"selected\">RR</option>");
										}else{
											out.print("<option value=\"RR\">RR</option>");
										}if(usuario != null && usuario.getEstado().equals("RS")){
											out.print("<option value=\"RS\" selected=\"selected\">RS</option>");
										}else{
											out.print("<option value=\"RS\">RS</option>");
										}
										if(usuario != null && usuario.getEstado().equals("SC")){
											out.print("<option value=\"SC\" selected=\"selected\">SC</option>");
										}else{
											out.print("<option value=\"SC\">SC</option>");
										}
										if(usuario != null && usuario.getEstado().equals("SE")){
											out.print("<option value=\"SE\" selected=\"selected\">SE</option>");
										}else{
											out.print("<option value=\"SE\">SE</option>");
										}
										if(usuario != null && usuario.getEstado().equals("SP")){
											out.print("<option value=\"SP\" selected=\"selected\">SP</option>");
										}else{
											out.print("<option value=\"SP\">SP</option>");
										}if(usuario != null && usuario.getEstado().equals("TO")){
											out.print("<option value=\"TO\" selected=\"selected\">TO</option>");
										}else{
											out.print("<option value=\"TO\">TO</option>");
										}
									%>
							  </select></td>
							</tr>
							<tr>
							  <td align="right">* CEP:<br /></td>
							  <td><input name="cep" type="text" id="cep" size="12" maxlength="10" value="<% if(usuario != null){ out.print(usuario.getCep()); } %>" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<strong>* Telefone:</strong>
								<input name="telefone" type="text" id="telefone" size="15" maxlength="13" value="<% if(usuario != null){ out.print(usuario.getTelefone()); } %>" /> 
								
							</tr>
							<tr>
							  <td align="right">E-Mail:</td>
							  <td><input name="email" type="text" id="email" size="52" value="<% if(usuario != null){ out.print(usuario.getEmail()); } %>" /></td>
							<tr>
							<th style="color:#C33">Acesso ao Sistema</th>
							</tr>
							 <tr>
							  <td align="right">Usuário:</td>
							  <td>
							  	<input name="user" type="text" id="user" size="20" value="<% if(usuario != null){ out.print(usuario.getUser()); } %>" />	
							  	Senha:
							  	<input id="senha" type="password" name="senha" size="20" value="<% if(usuario != null){ out.print(usuario.getSenha()); } %>"/>
							  </td>
							</tr>
							<tr>
							  <td align="right">Tipo Permissão:</td>
							  	<td>
								  	<select name="tipo" id="tipo">
								  		<%
												if(usuario == null){
													out.print("<option value=\"\">Permissão</option>");
												}
								  				if(usuario!= null && usuario.getTipo().equals("")){
								  					out.print("<option value=\"\">Permissão</option>");
								  				}
												if(usuario != null && usuario.getTipo().equals("user")){
													out.print("<option value=\"user\" selected=\"selected\">Usuário</option>");
												}else{
													out.print("<option value=\"user\">Usuário</option>");
												}
												if(usuario != null && usuario.getTipo().equals("admin")){
													out.print("<option value=\"admin\" selected=\"selected\">Administrador</option>");
												}else{
													out.print("<option value=\"admin\">Administrador</option>");
												}
											%>
									</select>
								</td>
							</tr>
						</table>
					</td>
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
