package presentation;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dataAccess.IndiceConfiabilidadeRepository;
import domainModel.IndiceConfiabilidade;

/**
 * Servlet implementation class indiceconfiabilidadeController
 */
@WebServlet("/IndicesConfiabilidades")
public class indiceconfiabilidadeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
     * @see HttpServlet#HttpServlet()
     */
	//Declaração do Repositório
	IndiceConfiabilidadeRepository repositorio;
    
	//Construtor do Servlet
    public indiceconfiabilidadeController() {
        super();
        
      //Inicialização do Repositório
        repositorio = new IndiceConfiabilidadeRepository();
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
					//carrega o IndiceConfiabilidade do BD
					IndiceConfiabilidade indiceconfiabilidade = repositorio.Open(Integer.parseInt(edit));
					
					//Passa o IndiceConfiabilidade para a página JSP
					request.setAttribute("indiceconfiabilidade", indiceconfiabilidade);
				}catch (Exception e){
					e.printStackTrace();
				}
			}
		
			//Chamar Página JSP
			RequestDispatcher editar = request.getRequestDispatcher("indiceconfiabilidadeEditar.jsp");
			editar.forward(request, response);
			return;
			
		}
		//Verifica se o parâmetro del foi passado
		String del = request.getParameter("del");
		if(del != null){
			try {
				//Carrega o IndiceConfiabilidade do BD 
				IndiceConfiabilidade indiceconfiabilidade = repositorio.Open(Integer.parseInt(del));
				
				//Apaga IndiceConfiabilidade carregado da base 
				repositorio.Delete(indiceconfiabilidade);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		//Gera uma listagem de TODOS os IndiceConfiabilidade
		List indicesconfiabilidades = repositorio.getAllByName();
		
		//Passa a listagem para a pagina JSP
		request.setAttribute("indicesconfiabilidades", indicesconfiabilidades);
		
		//Chamar a página JSP
		RequestDispatcher listagem = request.getRequestDispatcher("indicesconfiabilidadesListagem.jsp");
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
			
			IndiceConfiabilidade indiceconfiabilidade;
			
			// Carrega o objeto do banco de dados
			if(cod != null && cod.length() != 0)
				indiceconfiabilidade = repositorio.Open(Integer.parseInt(cod));
			else
				indiceconfiabilidade = new IndiceConfiabilidade();
			
			indiceconfiabilidade.setNome(nome);
			indiceconfiabilidade.setDescricao(descricao);
			repositorio.Save(indiceconfiabilidade);
			
			
			// Gera uma listagem de TODOS os Indices de Confiabilidade
			List indicesconfiabilidades = repositorio.getAllByName();
			
			// Passa a listagem para a página JSP
			request.setAttribute("indicesconfiabilidades", indicesconfiabilidades);
			
			// Chamar a página JSP
			RequestDispatcher listagem = request.getRequestDispatcher("indicesconfiabilidadesListagem.jsp");
			listagem.forward(request, response);
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
}
