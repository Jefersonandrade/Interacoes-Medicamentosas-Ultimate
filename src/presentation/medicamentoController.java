package presentation;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dataAccess.FabricanteRepository;
import dataAccess.MedicamentoRepository;
import dataAccess.PrincipioAtivoRepository;
import dataAccess.ReacaoRepository;
import domainModel.Fabricante;
import domainModel.Medicamento;
import domainModel.PrincipioAtivo;

@WebServlet("/Medicamentos")
public class medicamentoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//Declaração do Repositório
	MedicamentoRepository repositorio;
	
	//Declaração do Repositorio Principio Ativo
	PrincipioAtivoRepository parepositorio;
	
	//Declaração do Repositorio Fabricantes
	FabricanteRepository frepositorio;
    
	//Construtor do Servlet
    public medicamentoController() {
        super();
        
      //Inicialização do Repositório
        repositorio = new MedicamentoRepository();
        
     //Inicialização do Repositorio de Principio Ativo
        parepositorio = new PrincipioAtivoRepository();
     
     //Inicialização do Repositorio Fabricantes
        frepositorio = new FabricanteRepository();
}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Verificar se o Parâmetro edit foi passado
		String edit = request.getParameter("edit");
		
		request.setAttribute("fabricantes", frepositorio.getAllbyName());
		
		//Codigo que executa quando o parametro edit é passado
		if(edit!= null){
			if(!edit.equalsIgnoreCase("new")){
				//Converter 
				try{
					//carrega o Reacao do BD
					Medicamento medicamento = repositorio.Open(Integer.parseInt(edit));
					
					//Passa o Reacao para a página JSP
					request.setAttribute("medicamento", medicamento);
					
				}catch (Exception e){
					e.printStackTrace();
				}
				
			}
			
			//Puxando (Listando) dados de Fabricantes
			FabricanteRepository frepositorio = new FabricanteRepository();
			request.setAttribute("medicamentos", frepositorio.getAllbyName());
			
			//Puxando (Listando) dados de Principios Ativos
			PrincipioAtivoRepository prepositorio = new PrincipioAtivoRepository();
			request.setAttribute("medicamentos", prepositorio.getAllByName());
			
		
			//Chamar Página JSP
			RequestDispatcher editar = request.getRequestDispatcher("medicamentoEditar.jsp");
			editar.forward(request, response);
			return;
			
		}
		//Verifica se o parâmetro del foi passado
		String del = request.getParameter("del");
		if(del != null){
			try {
				//Carrega o Medicamento do BD 
				Medicamento medicamento = repositorio.Open(Integer.parseInt(del));
				
				//Apaga Medicamento carregado da base 
				repositorio.Delete(medicamento);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		//Gera uma listagem de TODOS os Medicamentos
		List medicamentos = repositorio.getAllbyName();
		
		//Passa a listagem para a pagina JSP
		request.setAttribute("medicamentos", medicamentos);
		
		//Chamar a página JSP
		RequestDispatcher listagem = request.getRequestDispatcher("medicamentosListagem.jsp");
		listagem.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			// Recebe os parâmetros do formulário
			String cod = request.getParameter("id");
			String nome = request.getParameter("nomecomercial");
			String registro = request.getParameter("numregistro");
			String validade = request.getParameter("validade");
			String formafarmaceutica = request.getParameter("formafarmaceutica");
			PrincipioAtivo principioativo = parepositorio.Open(Integer.parseInt(request.getParameter("idprincipiosativos").toString()));
			Fabricante fabricante = frepositorio.Open(Integer.parseInt(request.getParameter("idfabricantes").toString()));
			
			Medicamento medicamento;
			
			// Carrega o objeto do banco de dados
			if(cod != null && cod.length() != 0)
				medicamento = repositorio.Open(Integer.parseInt(cod));
			else
				medicamento = new Medicamento();
			
			medicamento.setNomecomercial(nome);
			medicamento.setNumregistro(Integer.parseInt(registro));
			medicamento.setValidade(validade);
			medicamento.setFormafarmaceutica(formafarmaceutica);
			medicamento.setPrincipioativo(principioativo);
			medicamento.setFabricante(fabricante);
			//Adicionar outros campos
			repositorio.Save(medicamento);
			
			// Gera uma listagem de Medicamentos
			List medicamentos = repositorio.getAllbyName();
			
			// Passa a listagem para a página JSP
			request.setAttribute("medicamentos", medicamentos);
			
			// Chamar a página JSP
			RequestDispatcher listagem = request.getRequestDispatcher("medicamentosListagem.jsp");
			listagem.forward(request, response);
		}
		catch(Exception ex){
			ex.printStackTrace();
		}		
	}
}
