package domainModel;

import javax.persistence.*;

@Entity
@Table(name="principiosativos")
public class PrincipioAtivo {
	/* Campos no Banco de Dados
	 * idpricipiosativos
	 * nome
	*/
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idprincipiosativos")//Colocar o que esta no Banco de Dados
	private int id;
	
	@Column(name="nome")
	private String nome;

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
}
