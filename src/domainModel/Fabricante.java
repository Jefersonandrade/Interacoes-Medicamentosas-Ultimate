package domainModel;

import javax.persistence.*;

@Entity
@Table(name="fabricantes")
public class Fabricante {
	
	/*Campos no Banco de Dados
	 * idfabricantes
	 * nomefantasia
	 * razao social
	 * cnpj
	 * responsaveltecnico
	 * crresponsavel
	 * endereco
	 * bairro
	 * complemento
	 * numero
	 * cidade
	 * estado(uf)
	 * cep
	 * telefone
	 * ramal
	 * email
	 * site
	 * 
	 * */
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idfabricantes")
	private int id;
	
	@Column(name="nomefantasia")
	private String nomefantasia;
	
	@Column(name="razaosocial")
	private String razaosocial;
	
	@Column(name="cnpj")
	private String cnpj;
	
	@Column(name="responsaveltecnico")
	private String responsaveltecnico;
	
	@Column(name="crfresponsavel")
	private String crfresponsavel;
	
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
	
	@Column(name="uf")
	private String uf;
	
	@Column(name="cep")
	private String cep;
	
	@Column(name="telefone")
	private String telefone;
	
	@Column(name="ramal")
	private int ramal;
	
	@Column(name="email")
	private String email;
	
	@Column(name="site")
	private String site;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomefantasia() {
		return nomefantasia;
	}

	public void setNomefantasia(String nomefantasia) {
		this.nomefantasia = nomefantasia;
	}

	public String getRazaosocial() {
		return razaosocial;
	}

	public void setRazaosocial(String razaosocial) {
		this.razaosocial = razaosocial;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getResponsaveltecnico() {
		return responsaveltecnico;
	}

	public void setResponsaveltecnico(String responsaveltecnico) {
		this.responsaveltecnico = responsaveltecnico;
	}

	public String getCrfresponsavel() {
		return crfresponsavel;
	}

	public void setCrfresponsavel(String crfresponsavel) {
		this.crfresponsavel = crfresponsavel;
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

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
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

	public int getRamal() {
		return ramal;
	}

	public void setRamal(int ramal) {
		this.ramal = ramal;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}
	
	
}
