package domainModel;

import javax.persistence.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Entity
@Table(name="usuarios")
public class Usuario {
	/*Campos do Banco de Dados
	 * idusuarios
	 * nome
	 * identidade
	 * cpf
	 * estadocivil
	 * profissao
	 * datanascimento
	 * sexo
	 * naturalidade
	 * estadonaturalidade
	 * endereco
	 * bairro
	 * complemento
	 * numero
	 * cidade
	 * estado
	 * cep
	 * telefone
	 * email
	 * usuario
	 * senha
	 * tipo
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * public Usuario() {
		sexo = "";
	}
	 * */
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idusuarios")
	private int id;
	
	@Column(name="nome")
	private String nome;
	
	@Column(name="identidade")
	private String identidade;
	
	@Column(name="cpf")
	private String cpf;
	
	@Column(name="estadocivil")
	private String estadocivil;
	
	@Column(name="profissao")
	private String profissao;
	
	@Temporal(TemporalType.DATE)
	@Column(name="datanascimento")
	private Date datanascimento;
	
	@Column(name="sexo")
	private String sexo;
	
	@Column(name="naturalidade")
	private String naturalidade;
	
	@Column(name="estadonaturalidade")
	private String estadonaturalidade;
	
	@Column(name="endereco")
	private String endereco;
	
	@Column(name="bairro")
	private String bairro;
	
	@Column(name="complemento")
	private String complemento;
	
	@Column(name="numero")
	private int numero;
	
	@Column(name="cidade")
	private String cidade;
	
	@Column(name="estado")
	private String estado;
	
	@Column(name="cep")
	private String cep;
	
	@Column(name="telefone")
	private String telefone;
	
	@Column(name="email")
	private String email;
	
	@Column(name="usuario")
	private String user;
	
	@Column(name="senha")
	private String senha;
	
	@Column(name="tipo")
	private String tipo;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getIdentidade() {
		return identidade;
	}

	public void setIdentidade(String identidade) {
		this.identidade = identidade;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEstadocivil() {
		return estadocivil;
	}

	public void setEstadocivil(String estadocivil) {
		this.estadocivil = estadocivil;
	}

	public String getProfissao() {
		return profissao;
	}

	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}

	public Date getDatanascimento() {
		return datanascimento;
	}

		public void setDatanascimento(String datanascimento) throws Exception{
			try{
				Pattern expressao = Pattern.compile("^(([0-2]\\d)|3[01])\\/(0[1-9]|1[0-2])\\/\\d{4}");
				Matcher martch = expressao.matcher(datanascimento);
				if(martch.matches()){
					SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
					java.util.Date dataUtil = df.parse(datanascimento);
					this.datanascimento = dataUtil;
				}
			}catch(Exception e){
				e.getMessage();
			}
		}

	public void setDatanascimento(Date datanascimento) {
		this.datanascimento = datanascimento;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getNaturalidade() {
		return naturalidade;
	}

	public void setNaturalidade(String naturalidade) {
		this.naturalidade = naturalidade;
	}

	public String getEstadonaturalidade() {
		return estadonaturalidade;
	}

	public void setEstadonaturalidade(String estadonaturalidade) {
		this.estadonaturalidade = estadonaturalidade;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
}
