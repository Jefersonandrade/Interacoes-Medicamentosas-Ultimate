package domainModel;
import javax.persistence.*;


@Entity
@Table(name="reacoes")
public class Reacao {
	/* Campos no Banco de Dados
	 * idreacoes
	 * conduta
	 * discussao
	 * sumario
	 * idindicesgravidades
	 * idindicesconfiabilidades
	 * idindicesriscos
	 * idprincipiosativos1
	 * idprincipiosativos2
	 */
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idreacoes")//Colocar o que esta no Banco de Dados
	private int id;
	
	@Column(name="conduta")
	private String conduta;
	
	@Column(name="discussao")
	private String discussao;
	
	@Column(name="sumario")
	private String sumario;
	
	@ManyToOne(fetch=FetchType.LAZY, cascade={CascadeType.REFRESH})
	@JoinColumn(name="idindicesgravidades")
	private IndiceGravidade idindicesgravidades;
	
	@ManyToOne(fetch=FetchType.LAZY, cascade={CascadeType.REFRESH})
	@JoinColumn(name="idindicesconfiabilidades")
	private IndiceConfiabilidade idindicesconfiabilidades;
	
	@ManyToOne(fetch=FetchType.LAZY, cascade={CascadeType.REFRESH})
	@JoinColumn(name="idprincipiosativos1")
	private PrincipioAtivo idprincipiosativos;
	
	@ManyToOne(fetch=FetchType.LAZY, cascade={CascadeType.REFRESH})
	@JoinColumn(name="idprincipiosativos2")
	private PrincipioAtivo idprincipiosativos2;
	
	@ManyToOne(fetch=FetchType.LAZY, cascade={CascadeType.REFRESH})
	@JoinColumn(name="idindicesriscos")
	private IndiceRisco idindicesriscos;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getConduta() {
		return conduta;
	}

	public void setConduta(String conduta) {
		this.conduta = conduta;
	}

	public String getDiscussao() {
		return discussao;
	}

	public void setDiscussao(String discussao) {
		this.discussao = discussao;
	}

	public String getSumario() {
		return sumario;
	}

	public void setSumario(String sumario) {
		this.sumario = sumario;
	}

	public IndiceGravidade getIdindicesgravidades() {
		return idindicesgravidades;
	}

	public void setIdindicesgravidades(IndiceGravidade idindicesgravidades) {
		this.idindicesgravidades = idindicesgravidades;
	}

	public IndiceConfiabilidade getIdindicesconfiabilidades() {
		return idindicesconfiabilidades;
	}

	public void setIdindicesconfiabilidades(
			IndiceConfiabilidade idindicesconfiabilidades) {
		this.idindicesconfiabilidades = idindicesconfiabilidades;
	}

	public PrincipioAtivo getIdprincipiosativos() {
		return idprincipiosativos;
	}

	public void setIdprincipiosativos(PrincipioAtivo idprincipiosativos) {
		this.idprincipiosativos = idprincipiosativos;
	}

	public PrincipioAtivo getIdprincipiosativos2() {
		return idprincipiosativos2;
	}

	public void setIdprincipiosativos2(PrincipioAtivo idprincipiosativos2) {
		this.idprincipiosativos2 = idprincipiosativos2;
	}

	public IndiceRisco getIdindicesriscos() {
		return idindicesriscos;
	}

	public void setIdindicesriscos(IndiceRisco idindicesriscos) {
		this.idindicesriscos = idindicesriscos;
	}
}
