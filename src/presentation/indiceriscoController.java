package presentation;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dataAccess.IndiceRiscoRepository;
import domainModel.IndiceRisco;

/**
 * Servlet implementation class principioativoController
 */
@WebServlet("/IndicesRiscos")
public class indiceriscoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
     * @see HttpServlet#HttpServlet()
     */
	//Declara��o do Reposit�rio
	IndiceRiscoRepository repositorio;
    
	//Construtor do Servlet
    public indiceriscoController() {
        super();
        
      //Inicializa��o do Reposit�rio
        repositorio = new IndiceRiscoRepository();
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
					//carrega o IndiceRisco do BD
					IndiceRisco indicerisco = repositorio.Open(Integer.parseInt(edit));
					
					//Passa o IndiceRisco para a p�gina JSP
					request.setAttribute("indicerisco", indicerisco);
				}catch (Exception e){
					e.printStackTrace();
				}
			}
		
			//Chamar P�gina JSP
			RequestDispatcher editar = request.getRequestDispatcher("indiceriscoEditar.jsp");
			editar.forward(request, response);
			return;
			
		}
		//Verifica se o par�metro del foi passado
		String del = request.getParameter("del");
		if(del != null){
			try {
				//Carrega o PrincipioAtivo do BD 
				IndiceRisco indicerisco = repositorio.Open(Integer.parseInt(del));
				
				//Apaga PrincipioAtivo carregado da base 
				repositorio.Delete(indicerisco);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		//Gera uma listagem de TODOS os IndicesRiscos
		List indicesriscos = repositorio.getAllByName();
		
		//Passa a listagem para a pagina JSP
		request.setAttribute("indicesriscos", indicesriscos);
		
		//Chamar a p�gina JSP
		RequestDispatcher listagem = request.getRequestDispatcher("indicesriscosListagem.jsp");
		listagem.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			// Recebe os par�metros do formul�rio
			String cod = request.getParameter("cod");
			String nome = request.getParameter("nome");
			String descricao = request.getParameter("descricao");
			
			IndiceRisco indicerisco;
			
			// Carrega o objeto do banco de dados
			if(cod != null && cod.length() != 0)
				indicerisco = repositorio.Open(Integer.parseInt(cod));
			else
				indicerisco = new IndiceRisco();
			
			indicerisco.setNome(nome);
			indicerisco.setDescricao(descricao);
			repositorio.Save(indicerisco);
			
			// Gera uma listagem de TODOS os Usuarios
			List indicesriscos = repositorio.getAllByName();
			
			// Passa a listagem para a p�gina JSP
			request.setAttribute("indicesriscos", indicesriscos);
			
			// Chamar a p�gina JSP
			RequestDispatcher listagem = request.getRequestDispatcher("indicesriscosListagem.jsp");
			listagem.forward(request, response);
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
}
