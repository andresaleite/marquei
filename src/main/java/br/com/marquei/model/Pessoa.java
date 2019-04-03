package br.com.marquei.model;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;


/**
 * @author andresaleite@gmailcom
 *
 */
@Entity
@Table(name="pessoa")
public class Pessoa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_pessoa")
	private Long id;
	
	@NotNull
	@Column(name="nome")
	private String nome;
	
	@Column(name="data_nascimento")
	private LocalDate dataNascimento;
	
	@NotNull
	@Column
	@Size(min = 5 , max = 50)
	private String email;
	
	@Column(name="cpf_cnpj")
	private Long cpfCnpj;
	
	@Column(name="nome_estabelecimento")
	private String nomeEstabelecimento;
	
	@Column(name="senha")
	private String senha;
	

	@Size(min = 3 , max = 200)
	@Column(name="descricao_p")
	private String descricaoPequena;
	
	@Size(min = 3 , max = 400)
	@Column(name="descricao_m")
	private String descricaoMedia;
	
	@Size(min = 3 , max = 1000)
	@Column(name="descricao_g")
	private StringBuffer descricaoGrande;
	
	@Enumerated(EnumType.STRING)
	@NotNull
	@Column(name="situacao_registro")
	private EnumSituacaoRegistro situacaoRegistro;
	
	@Column(name = "timestamp", updatable=false)
	@CreationTimestamp
	private Timestamp timestamp;
	
	@OneToMany(cascade = {CascadeType.ALL})
	@JoinColumn(name = "id_pessoa")
	private List<Endereco> enderecos;
	
	@OneToMany(cascade = {CascadeType.ALL})
	@JoinColumn(name = "id_pessoa")
	private List<Plano> planos;
	
	@OneToMany(cascade = {CascadeType.ALL})
	@JoinColumn(name = "id_pessoa")
	private List<Contrato> contratos;
	
	@Enumerated(EnumType.STRING)
	@NotNull
	@Column(name="tipo_pessoa")
	private EnumTipoPessoa tipoPessoa;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getCpfCnpj() {
		return cpfCnpj;
	}

	public void setCpfCnpj(Long cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}

	public EnumSituacaoRegistro getSituacaoRegistro() {
		return situacaoRegistro;
	}

	public void setSituacaoRegistro(EnumSituacaoRegistro situacaoRegistro) {
		this.situacaoRegistro = situacaoRegistro;
	}


	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

	public String getDescricaoPequena() {
		return descricaoPequena;
	}

	public void setDescricaoPequena(String descricaoPequena) {
		this.descricaoPequena = descricaoPequena;
	}

	public String getDescricaoMedia() {
		return descricaoMedia;
	}

	public void setDescricaoMedia(String descricaoMedia) {
		this.descricaoMedia = descricaoMedia;
	}

	public StringBuffer getDescricaoGrande() {
		return descricaoGrande;
	}

	public void setDescricaoGrande(StringBuffer descricaoGrande) {
		this.descricaoGrande = descricaoGrande;
	}

	public String getNomeEstabelecimento() {
		return nomeEstabelecimento;
	}

	public void setNomeEstabelecimento(String nomeEstabelecimento) {
		this.nomeEstabelecimento = nomeEstabelecimento;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpfCnpj == null) ? 0 : cpfCnpj.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((senha == null) ? 0 : senha.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		if (cpfCnpj == null) {
			if (other.cpfCnpj != null)
				return false;
		} else if (!cpfCnpj.equals(other.cpfCnpj))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (senha == null) {
			if (other.senha != null)
				return false;
		} else if (!senha.equals(other.senha))
			return false;
		return true;
	}

	public List<Plano> getPlanos() {
		return planos;
	}

	public void setPlanos(List<Plano> planos) {
		this.planos = planos;
	}

	public EnumTipoPessoa getTipoPessoa() {
		return tipoPessoa;
	}

	public void setTipoPessoa(EnumTipoPessoa tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}

	public List<Contrato> getContratos() {
		return contratos;
	}

	public void setContratos(List<Contrato> contratos) {
		this.contratos = contratos;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}


}
