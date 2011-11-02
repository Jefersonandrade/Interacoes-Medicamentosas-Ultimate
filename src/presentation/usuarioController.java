package presentation;

import java.io.IOException;


import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dataAccess.UsuarioRepository;
import domainModel.Usuario;



//importações para criptografia
import java.security.MessageDigest;  
import java.security.NoSuchAlgorithmException;
import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;




import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



/**
 * Servlet implementation class principioativoController
 */
@WebServlet("/Usuarios")
public class usuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
     * @see HttpServlet#HttpServlet()
     */
	//Declaração do Repositório
	UsuarioRepository repositorio;
    
	//Construtor do Servlet
    public usuarioController() {
        super();
        
      //Inicialização do Repositório
        repositorio = new UsuarioRepository();
    }
    
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Verificar se o Parâmetro edit foi passado
		String edit = request.getParameter("edit");
		
		//Codigo que executa quando o parametro edit é passado
		if(edit!= null){
			if(!edit.equalsIgnoreCase("new")){
				//Converter 
				try{
					//carrega o Usuario do BD
					Usuario usuario = repositorio.Open(Integer.parseInt(edit));
					
					//Passa o Usuario para a página JSP
					request.setAttribute("usuario", usuario);
					
				}catch (Exception e){
					e.printStackTrace();
				}
				
			}
		
			//Chamar Página JSP
			RequestDispatcher editar = request.getRequestDispatcher("usuarioEditar.jsp");
			editar.forward(request, response);
			return;
			
		}
		//Verifica se o parâmetro del foi passado
		String del = request.getParameter("del");
		if(del != null){
			try {
				//Carrega o Usuario do BD 
				Usuario usuario = repositorio.Open(Integer.parseInt(del));
				
				//Apaga Usuario carregado da base 
				repositorio.Delete(usuario);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		//Gera uma listagem de TODOS os Usuarios
		List usuarios = repositorio.getAllByName();
		
		//Passa a listagem para a pagina JSP
		request.setAttribute("usuarios", usuarios);
		
		//Chamar a página JSP
		RequestDispatcher listagem = request.getRequestDispatcher("usuariosListagem.jsp");
		listagem.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			// Recebe os parâmetros do formulário
			String cod = request.getParameter("cod");
			String nome = request.getParameter("nome");
			String identidade = request.getParameter("identidade");
			String cpf = request.getParameter("cpf");
			String estadocivil = request.getParameter("estadocivil");
			String profissao = request.getParameter("profissao");
			String datanascimento = request.getParameter("datanascimento");			
			String sexo = request.getParameter("sexo");
			String naturalidade = request.getParameter("naturalidade");
			String estadonaturalidade = request.getParameter("estadonaturalidade");
			String endereco = request.getParameter("endereco");
			String bairro = request.getParameter("bairro");
			String complemento = request.getParameter("complemento");
			String numero = request.getParameter("numero");
			String cidade = request.getParameter("cidade");
			String estado = request.getParameter("estado");
			String cep = request.getParameter("cep");
			String telefone = request.getParameter("telefone");
			String email = request.getParameter("email");
			String user = request.getParameter("user");
			String senha = request.getParameter("senha");
			String tipo = request.getParameter("tipo");

			Usuario usuario;
			
			// Carrega o objeto do banco de dados
			if(cod != null && cod.length() != 0)
				usuario = repositorio.Open(Integer.parseInt(cod));
			else
				usuario = new Usuario();
			
			usuario.setNome(nome);
			usuario.setIdentidade(identidade);
			usuario.setCpf(cpf);
			usuario.setEstadocivil(estadocivil);
			usuario.setProfissao(profissao);
			usuario.setDatanascimento(datanascimento);
			usuario.setSexo(sexo);
			usuario.setNaturalidade(naturalidade);
			usuario.setEstadonaturalidade(estadonaturalidade);
			usuario.setEndereco(endereco);
			usuario.setBairro(bairro);
			usuario.setComplemento(complemento);
			usuario.setNumero(Integer.parseInt(numero));
			usuario.setCidade(cidade);
			usuario.setEstado(estado);
			usuario.setCep(cep);
			usuario.setTelefone(telefone);
			usuario.setEmail(email);
			usuario.setUser(user);
			usuario.setSenha(senha);
			usuario.setTipo(tipo);
			
			repositorio.Save(usuario);
			
			
			// Gera uma listagem de TODOS os Usuarios
			List usuarios = repositorio.getAllByName();
			
			// Passa a listagem para a página JSP
			request.setAttribute("usuarios", usuarios);
			
			// Chamar a página JSP
			RequestDispatcher listagem = request.getRequestDispatcher("usuariosListagem.jsp");
			listagem.forward(request, response);
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
}
