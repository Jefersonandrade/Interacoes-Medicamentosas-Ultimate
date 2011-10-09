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
	 * sobrenome
	 * email
	 * datanascimento
	 * cidade
	 * pais
	 * usuario
	 * senha
	 * tipo
	 * */
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idusuarios")
	private int id;
	
	@Column(name="nome")
	private String nome;
	
	@Column(name="sobrenome")
	private String sobrenome;
	
	@Column(name="email")
	private String email;
	
	@Temporal(TemporalType.DATE)
	@Column(name="datanascimento")
	private Date datanascimento;
	
	@Column(name="cidade")
	private String cidade;
	
	@Column(name="pais")
	private String pais;
	
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

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	public Date getDatanascimento() {
		return datanascimento;
	}

		public void setDatanascimento(String datanasc) throws Exception{
			try{
				Pattern expressao = Pattern.compile("^(([0-2]\\d)|3[01])\\/(0[1-9]|1[0-2])\\/\\d{4}");
				Matcher martch = expressao.matcher(datanasc);
				if(martch.matches()){
					SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
					java.util.Date dataUtil = df.parse(datanasc);
					this.datanascimento = dataUtil;
				}
			}catch(Exception e){
				e.getMessage();
			}
		}

	

	public void setDatanascimento(Date datanascimento) {
		this.datanascimento = datanascimento;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
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
