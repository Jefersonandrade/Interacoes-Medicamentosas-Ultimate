package presentation;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dataAccess.FabricanteRepository;
import domainModel.Fabricante;

/**
 * Servlet implementation class principioativoController
 */
@WebServlet("/FabricanteController")
public class fabricanteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
     * @see HttpServlet#HttpServlet()
     */
	//Declaração do Repositório
	FabricanteRepository repositorio;
    
	//Construtor do Servlet
    public fabricanteController() {
        super();
        
      //Inicialização do Repositório
        repositorio = new FabricanteRepository();
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
					//carrega o Fabricante do BD
					Fabricante fabricante = repositorio.Open(Integer.parseInt(edit));
					
					//Passa o Fabricante para a página JSP
					request.setAttribute("fabricante", fabricante);
					
				}catch (Exception e){
					e.printStackTrace();
				}
				
			}
		
			//Chamar Página JSP
			RequestDispatcher editar = request.getRequestDispatcher("fabricanteEditar.jsp");
			editar.forward(request, response);
			return;
			
		}
		//Verifica se o parâmetro del foi passado
		String del = request.getParameter("del");
		if(del != null){
			try {
				//Carrega o Fabricante do BD 
				Fabricante fabricante = repositorio.Open(Integer.parseInt(del));
				
				//Apaga Fabricante carregado da base 
				repositorio.Delete(fabricante);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		//Gera uma listagem de TODOS os Fabricantes
		List fabricantes = repositorio.getAllbyName();
		
		//Passa a listagem para a pagina JSP
		request.setAttribute("fabricantes", fabricantes);
		
		//Chamar a página JSP
		RequestDispatcher listagem = request.getRequestDispatcher("fabricantesListagem.jsp");
		listagem.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			// Recebe os parâmetros do formulário
			String cod = request.getParameter("id");
			String nomeempresa = request.getParameter("nomeempresa");
			String cnpj = request.getParameter("cnpj");
			String endereco = request.getParameter("endereco");
			String numero = request.getParameter("numero");
			String bairro = request.getParameter("bairro");
			String complemento = request.getParameter("complemento");
			String cep = request.getParameter("cep");
			String uf = request.getParameter("uf");
			String telefone = request.getParameter("telefone");
			String responsaveltecnico = request.getParameter("responsaveltecnico");
			String crresponsavel = request.getParameter("crresponsavel");
			
			Fabricante fabricante;
			
			// Carrega o objeto do banco de dados
			if(cod != null && cod.length() != 0)
				fabricante = repositorio.Open(Integer.parseInt(cod));
			else
				fabricante = new Fabricante();
			
			fabricante.setNomeempresa(nomeempresa);
			fabricante.setCnpj(cnpj);
			fabricante.setEndereco(endereco);
			fabricante.setNumero(Integer.parseInt(numero));
			fabricante.setBairro(bairro);
			fabricante.setComplemento(complemento);
			fabricante.setCep(cep);
			fabricante.setUf(uf);
			fabricante.setTelefone(telefone);
			fabricante.setResponsaveltecnico(responsaveltecnico);
			fabricante.setCrresponsavel(crresponsavel);
			
			repositorio.Save(fabricante);
			
			// Gera uma listagem de TODOS os Fabricantes
			List fabricantes = repositorio.getAllbyName();
			
			// Passa a listagem para a página JSP
			request.setAttribute("fabricantes", fabricantes);
			
			// Chamar a página JSP
			RequestDispatcher listagem = request.getRequestDispatcher("fabricantesListagem.jsp");
			listagem.forward(request, response);
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
}
