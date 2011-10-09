package domainModel;

import javax.persistence.*;

@Entity
@Table(name="indicesconfiabilidades")
public class IndiceConfiabilidade {
	/*Campos no Banco de Dados
	 * idindicesconfiabilidades
	 * nome
	 * descricao
	 * */
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idindicesconfiabilidades")
	private int id;
	
	@Column(name="nome")
	private String nome;
	
	@Column(name="descricao")
	private String descricao;

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
	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
}

