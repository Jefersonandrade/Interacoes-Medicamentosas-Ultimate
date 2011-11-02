package domainModel;

import java.util.List;

import javax.persistence.*;


@Entity
@Table(name="medicamentos")
public class Medicamento {
	
	/*Campos do Banco de Dados
	 * idmedicamentos
	 * nomecomercial
	 * numregistro
	 * validade
	 * formafarmaceutica
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
	@JoinColumn(name="idfabricantes")
	private Fabricante fabricante;
	
	@OneToMany(fetch=FetchType.LAZY)
	@JoinColumn(name="principiosativos")
	private List<PrincipioAtivo> principiosativos;

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

	public Fabricante getFabricante() {
		return fabricante;
	}
	
	public void setFabricante(Fabricante fabricante){
		this.fabricante = fabricante;	
	}

	public List<PrincipioAtivo> getPrincipiosativos() {
		return principiosativos;
	}

	public void setPrincipiosativos(List<PrincipioAtivo> principiosativos) {
		this.principiosativos = principiosativos;
	}

}
