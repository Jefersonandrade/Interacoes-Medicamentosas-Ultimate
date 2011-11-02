package presentation;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dataAccess.PrincipioAtivoRepository;
import domainModel.PrincipioAtivo;

/**
 * Servlet implementation class principioativoController
 */
@WebServlet("/PrincipiosAtivos")
public class principioativoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
     * @see HttpServlet#HttpServlet()
     */
	//Declaração do Repositório
	PrincipioAtivoRepository repositorio;
    
	//Construtor do Servlet
    public principioativoController() {
        super();
        
      //Inicialização do Repositório
        repositorio = new PrincipioAtivoRepository();
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
					//carrega o PrincipioAtivo do BD
					PrincipioAtivo principioativo = repositorio.Open(Integer.parseInt(edit));
					
					//Passa o PrincipioAtivo para a página JSP
					request.setAttribute("principioativo", principioativo);
					
				}catch (Exception e){
					e.printStackTrace();
				}
				
			}
		
			//Chamar Página JSP
			RequestDispatcher editar = request.getRequestDispatcher("principioativoEditar.jsp");
			editar.forward(request, response);
			return;
			
		}
		//Verifica se o parâmetro del foi passado
		String del = request.getParameter("del");
		if(del != null){
			try {
				//Carrega o PrincipioAtivo do BD 
				PrincipioAtivo principioativo = repositorio.Open(Integer.parseInt(del));
				
				//Apaga PrincipioAtivo carregado da base 
				repositorio.Delete(principioativo);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		//Gera uma listagem de TODOS os PrincipiosAtivos
		List principiosativos = repositorio.getAllByName();
		
		//Passa a listagem para a pagina JSP
		request.setAttribute("principiosativos", principiosativos);
		
		//Chamar a página JSP
		RequestDispatcher listagem = request.getRequestDispatcher("principiosativosListagem.jsp");
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
			
			PrincipioAtivo principioativo;
			
			// Carrega o objeto do banco de dados
			if(cod != null && cod.length() != 0)
				principioativo = repositorio.Open(Integer.parseInt(cod));
			else
				principioativo = new PrincipioAtivo();
			
			principioativo.setNome(nome);
			repositorio.Save(principioativo);
			
			// Gera uma listagem de TODOS os PrincipiosAtivos
			List principiosativos = repositorio.getAllByName();
			
			// Passa a listagem para a página JSP
			request.setAttribute("principiosativos", principiosativos);
			
			// Chamar a página JSP
			RequestDispatcher listagem = request.getRequestDispatcher("principiosativosListagem.jsp");
			listagem.forward(request, response);
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
}
