package presentation;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dataAccess.IndiceGravidadeRepository;
import domainModel.IndiceGravidade;

/**
 * Servlet implementation class indicegravidadeController
 */
@WebServlet("/IndicesGravidades")
public class indicegravidadeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
     * @see HttpServlet#HttpServlet()
     */
	//Declaração do Repositório
	IndiceGravidadeRepository repositorio;
    
	//Construtor do Servlet
    public indicegravidadeController() {
        super();
        
      //Inicialização do Repositório
        repositorio = new IndiceGravidadeRepository();
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
					//carrega o IndiceGravidade do BD
					IndiceGravidade indicegravidade = repositorio.Open(Integer.parseInt(edit));
					
					//Passa o IndiceGravidade para a página JSP
					request.setAttribute("indicegravidade", indicegravidade);
				}catch (Exception e){
					e.printStackTrace();
				}
			}
		
			//Chamar Página JSP
			RequestDispatcher editar = request.getRequestDispatcher("indicegravidadeEditar.jsp");
			editar.forward(request, response);
			return;
			
		}
		//Verifica se o parâmetro del foi passado
		String del = request.getParameter("del");
		if(del != null){
			try {
				//Carrega o IndiceConfiabilidade do BD 
				IndiceGravidade indicegravidade = repositorio.Open(Integer.parseInt(del));
				
				//Apaga IndiceConfiabilidade carregado da base 
				repositorio.Delete(indicegravidade);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		//Gera uma listagem de TODOS os IndiceGravidade
		List indicesgravidades = repositorio.getAllByName();
		
		//Passa a listagem para a pagina JSP
		request.setAttribute("indicesgravidades", indicesgravidades);
		
		//Chamar a página JSP
		RequestDispatcher listagem = request.getRequestDispatcher("indicesgravidadesListagem.jsp");
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
			String descricao = request.getParameter("descricao");
			
			IndiceGravidade indicegravidade;
			
			// Carrega o objeto do banco de dados
			if(cod != null && cod.length() != 0)
				indicegravidade = repositorio.Open(Integer.parseInt(cod));
			else
				indicegravidade = new IndiceGravidade();
			
			indicegravidade.setNome(nome);
			indicegravidade.setDescricao(descricao);
			repositorio.Save(indicegravidade);
			
			// Gera uma listagem de TODOS os Indices de Confiabilidade
			List indicesgravidades = repositorio.getAllByName();
			
			// Passa a listagem para a página JSP
			request.setAttribute("indicesgravidades", indicegravidade);
			
			// Chamar a página JSP
			RequestDispatcher listagem = request.getRequestDispatcher("indicesgravidadesListagem.jsp");
			listagem.forward(request, response);
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
}
