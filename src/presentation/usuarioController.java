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

/**
 * Servlet implementation class principioativoController
 */
@WebServlet("/PrincipiosAtivos")
public class usuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
     * @see HttpServlet#HttpServlet()
     */
	//Declara��o do Reposit�rio
	UsuarioRepository repositorio;
    
	//Construtor do Servlet
    public usuarioController() {
        super();
        
      //Inicializa��o do Reposit�rio
        repositorio = new UsuarioRepository();
    }
    
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Verificar se o Par�metro edit foi passado
		String edit = request.getParameter("edit");
		
		//Codigo que executa quando o parametro edit � passado
		if(edit!= null){
			if(!edit.equalsIgnoreCase("new")){
				//Converter 
				try{
					//carrega o Usuario do BD
					Usuario usuario = repositorio.Open(Integer.parseInt(edit));
					
					//Passa o Usuario para a p�gina JSP
					request.setAttribute("usuario", usuario);
					
				}catch (Exception e){
					e.printStackTrace();
				}
				
			}
		
			//Chamar P�gina JSP
			RequestDispatcher editar = request.getRequestDispatcher("usuarioEditar.jsp");
			editar.forward(request, response);
			return;
			
		}
		//Verifica se o par�metro del foi passado
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
		
		//Chamar a p�gina JSP
		RequestDispatcher listagem = request.getRequestDispatcher("usuariosListagem.jsp");
		listagem.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			// Recebe os par�metros do formul�rio
			String cod = request.getParameter("id");
			String nome = request.getParameter("nome");
			String tipo = request.getParameter("tipo");
			
			Usuario usuario;
			
			// Carrega o objeto do banco de dados
			if(cod != null && cod.length() != 0)
				usuario = repositorio.Open(Integer.parseInt(cod));
			else
				usuario = new Usuario();
			
			usuario.setNome(nome);
			usuario.setTipo(tipo);
			repositorio.Save(usuario);
			
			// Gera uma listagem de TODOS os Usuarios
			List usuarios = repositorio.getAllByName();
			
			// Passa a listagem para a p�gina JSP
			request.setAttribute("usuarios", usuarios);
			
			// Chamar a p�gina JSP
			RequestDispatcher listagem = request.getRequestDispatcher("usuariosListagem.jsp");
			listagem.forward(request, response);
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
}
