package domainModel;

import javax.persistence.*;

@Entity
@Table(name="medicamentos")
public class Medicamento {
	
	/*Campos do Banco de Dados
	 * idmedicamentos
	 * nomecomercial
	 * numregistro
	 * validade
	 * formapagamento
	 * idfabricantes
	 * */
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idmedicamentos")
	private int id;
	
	@Column(name="nomecomercial")
	private String nomecomercial;
	
	@Column(name="numregistro")
	private int numregistro;
	
	@Column(name="validade")
	private String validade;
	
	@Column(name="formafarmaceutica")
	private String formafarmaceutica;
	
	@ManyToOne(fetch=FetchType.LAZY, cascade={CascadeType.REFRESH})
	@JoinColumn(name="idfabricante")
	private Fabricante fabricante;
	
	@ManyToOne(fetch=FetchType.LAZY, cascade={CascadeType.REFRESH})
	@JoinColumn(name="id_principioativo")
	private PrincipioAtivo principioativo;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomecomercial() {
		return nomecomercial;
	}

	public void setNomecomercial(String nomecomercial) {
		this.nomecomercial = nomecomercial;
	}

	public int getNumregistro() {
		return numregistro;
	}

	public void setNumregistro(int numregistro) {
		this.numregistro = numregistro;
	}

	public String getValidade() {
		return validade;
	}

	public void setValidade(String validade) {
		this.validade = validade;
	}

	public String getFormafarmaceutica() {
		return formafarmaceutica;
	}

	public void setFormafarmaceutica(String formafarmaceutica) {
		this.formafarmaceutica = formafarmaceutica;
	}

	public PrincipioAtivo getPrincipioativo() {
		return principioativo;
	}

	public void setPrincipioativo(PrincipioAtivo principioativo) {
		this.principioativo = principioativo;
	}
	
	public Fabricante getFabricante() {
		return fabricante;
	}
	
	public void setFabricante(Fabricante fabricante){
		this.fabricante = fabricante;	
	}
}
