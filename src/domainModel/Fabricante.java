package domainModel;

import javax.persistence.*;

@Entity
@Table(name="fabricantes")
public class Fabricante {
	
	/*Campos no Banco de Dados
	 * idfabricantes
	 * nomeempresa
	 * cnpj
	 * endereco
	 * numero
	 * bairro
	 * complemento
	 * cep
	 * uf
	 * telefone
	 * responsaveltecnico
	 * crresponsavel
	 * */
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idfabricantes")
	private int id;
	
	@Column(name="nomeempresa")
	private String nomeempresa;
	
	@Column(name="cnpj")
	private String cnpj;
	
	@Column(name="endereco")
	private String endereco;
	
	@Column(name="numero")
	private int numero;
	
	@Column(name="bairro")
	private String bairro;
	
	@Column(name="complemento")
	private String complemento;
	
	@Column(name="cep")
	private String cep;
	
	@Column(name="uf")
	private String uf;
	
	@Column(name="telefone")
	private String telefone;
	
	@Column(name="responsaveltecnico")
	private String responsaveltecnico;
	
	@Column(name="crresponsavel")
	private String crresponsavel;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomeempresa() {
		return nomeempresa;
	}

	public void setNomeempresa(String nomeempresa) {
		this.nomeempresa = nomeempresa;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
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

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getResponsaveltecnico() {
		return responsaveltecnico;
	}

	public void setResponsaveltecnico(String responsaveltecnico) {
		this.responsaveltecnico = responsaveltecnico;
	}

	public String getCrresponsavel() {
		return crresponsavel;
	}

	public void setCrresponsavel(String crresponsavel) {
		this.crresponsavel = crresponsavel;
	}
}
