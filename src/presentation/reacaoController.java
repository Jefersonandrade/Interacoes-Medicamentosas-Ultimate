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
import dataAccess.PrincipioAtivoRepository;
import dataAccess.ReacaoRepository;
import dataAccess.IndiceConfiabilidadeRepository;
import dataAccess.IndiceGravidadeRepository;

import domainModel.IndiceRisco;
import domainModel.IndiceConfiabilidade;
import domainModel.IndiceGravidade;
import domainModel.PrincipioAtivo;
import domainModel.Reacao;

/**
 * Servlet implementation class reacaoController
 */
@WebServlet("/Reacoes")
public class reacaoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
     * @see HttpServlet#HttpServlet()
     */
	//Declaração do Repositório
	ReacaoRepository repositorio;
	
	//Declaração do Repositorio Principio Ativo
	PrincipioAtivoRepository parepositorio;
	
	//Declaração do Repositorio Indice de Risco
	IndiceRiscoRepository irrepositorio;
	
	//Declaração do Repositorio Indice de Confiabilidade
	IndiceConfiabilidadeRepository icrepositorio;
	
	//Declaração do Repositorio Indice de Gravidade
	IndiceGravidadeRepository igrepositorio;
    
	//Construtor do Servlet
    public reacaoController() {
        super();
        
      //Inicialização do Repositório
        repositorio = new ReacaoRepository();
        
        //Inicialização do Repositorio de Principio Ativo
        parepositorio = new PrincipioAtivoRepository();
        
        //Inicialização do Repositório de Indice de Risco
        irrepositorio = new IndiceRiscoRepository();
        
      //Inicialização do Repositório de Indice de Confiabilidade
        icrepositorio = new IndiceConfiabilidadeRepository();
        
      //Inicialização do Repositório de Indice de Gravidade
        igrepositorio = new IndiceGravidadeRepository();
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
					//carrega o Reacao do BD
					Reacao reacao = repositorio.Open(Integer.parseInt(edit));
					
					//Passa o Reacao para a página JSP
					request.setAttribute("reacao", reacao);
					
				}catch (Exception e){
					e.printStackTrace();
				}
				
			}
			
			//Puxando (Listando) dados de Principios Ativos
			PrincipioAtivoRepository parepositorio = new PrincipioAtivoRepository();
			request.setAttribute("principiosativos", parepositorio.getAllByName());
			
			//Puxando (Listando) dados de Indice de Risco
			IndiceRiscoRepository irrepositorio = new IndiceRiscoRepository();
			request.setAttribute("indicesriscos", irrepositorio.getAllByName());
			
			//Puxando (Listando) dados de Indice Gravidade
			IndiceGravidadeRepository igrepositorio = new IndiceGravidadeRepository();
			request.setAttribute("indicesgravidades", igrepositorio.getAllByName());
			
			//Puxando (Listando) dados de Indice Confiabilidade
			IndiceConfiabilidadeRepository icrepositorio = new IndiceConfiabilidadeRepository();
			request.setAttribute("indicesconfiabilidades", icrepositorio.getAllByName());
			
			//Chamar Página JSP
			RequestDispatcher editar = request.getRequestDispatcher("reacaoEditar.jsp");
			editar.forward(request, response);
			return;	
		}
		//Verifica se o parâmetro del foi passado
		String del = request.getParameter("del");
		if(del != null){
			try {
				//Carrega o Reacao do BD 
				Reacao reacao = repositorio.Open(Integer.parseInt(del));
				
				//Apaga reacao carregado da base 
				repositorio.Delete(reacao);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		//Gera uma listagem de TODOS as reacoes
		List reacoes = repositorio.getAllByName();
		
		//Passa a listagem para a pagina JSP
		request.setAttribute("reacoes", reacoes);
		
		//Chamar a página JSP
		RequestDispatcher listagem = request.getRequestDispatcher("reacoesListagem.jsp");
		listagem.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try {
			// Recebe os parâmetros do formulário
			String cod = request.getParameter("cod");
			String conduta = request.getParameter("conduta");
			String discussao = request.getParameter("discussao");
			String sumario = request.getParameter("sumario");
			PrincipioAtivo principioativo = parepositorio.Open(Integer.parseInt(request.getParameter("principioativo").toString()));
			PrincipioAtivo principioativo2 = parepositorio.Open(Integer.parseInt(request.getParameter("principioativo2").toString()));
			IndiceRisco indicerisco = irrepositorio.Open(Integer.parseInt(request.getParameter("indicerisco").toString()));
			IndiceGravidade indicegravidade = igrepositorio.Open(Integer.parseInt(request.getParameter("indicegravidade").toString()));
			IndiceConfiabilidade indiceconfiabilidade = icrepositorio.Open(Integer.parseInt(request.getParameter("indiceconfiabilidade").toString()));
			
			Reacao reacao;
			
			// Carrega o objeto do banco de dados
			if(cod != null && cod.length() != 0)
				reacao = repositorio.Open(Integer.parseInt(cod));
			else
				reacao = new Reacao();
	
				reacao.setConduta(conduta);
				reacao.setDiscussao(discussao);
				reacao.setSumario(sumario);
				reacao.setIdindicesriscos(indicerisco);
				reacao.setIdindicesgravidades(indicegravidade);
				reacao.setIdindicesconfiabilidades(indiceconfiabilidade);
				reacao.setIdprincipiosativos(principioativo);
				reacao.setIdprincipiosativos2(principioativo2);
				
				repositorio.Save(reacao);
			
				//Gera uma listagem de reações
				List reacoes = repositorio.getAllByName();
				
				// Passa a listagem para a página JSP
				request.setAttribute("reacoes", reacoes);
				
				// Chamar a página JSP
				RequestDispatcher listagem = request.getRequestDispatcher("reacoesListagem.jsp");
				listagem.forward(request, response);
		}
		catch(Exception ex){
			ex.printStackTrace();
		}		
	}
}
