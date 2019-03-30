package br.com.marquei.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


/**
 * @author elizabeth
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
	
	@Column(name="dt_nascimento")
	private LocalDate dataNascimento;
	
	@NotNull
	@Size(min = 5 , max = 50)
	private String email;
	
	@Column(name="cpf_cnpj")
	private Long cpfCnpj;
	
	@Size(min = 8 , max = 200)
	private String endereco;
	
	@Size(min = 3 , max = 50)
	@Column(name="nome_estabelecimento")
	private String nomeEstabelecimento;
	
	@Size(min = 3 , max = 200)
	@Column(name="descricao_p")
	private String descricaoPequena;
	
	@Size(min = 3 , max = 400)
	@Column(name="descricao_m")
	private String descricaoMedia;
	
	@Size(min = 3 , max = 1000)
	@Column(name="descricao_g")
	private StringBuffer descricaoGrande;
	
	@Column(name="id_controle_situacao_pessoa")
	private int id_controle_situacao_pessoa;
	
	@Column(name="id_controle_uf")
	private int idControleUf;
	
	private Long cep;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar timestamp;
	
	@NotNull
	@Column(name="ativo")
	private boolean ativo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getNomeEstabelecimento() {
		return nomeEstabelecimento;
	}

	public void setNomeEstabelecimento(String nomeEstabelecimento) {
		this.nomeEstabelecimento = nomeEstabelecimento;
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

	public int getIdControleUf() {
		return idControleUf;
	}

	public void setIdControleUf(int idControleUf) {
		this.idControleUf = idControleUf;
	}

	public Long getCep() {
		return cep;
	}

	public void setCep(Long cep) {
		this.cep = cep;
	}


	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getId_controle_situacao_pessoa() {
		return id_controle_situacao_pessoa;
	}

	public void setId_controle_situacao_pessoa(int id_controle_situacao_pessoa) {
		this.id_controle_situacao_pessoa = id_controle_situacao_pessoa;
	}

	public Calendar getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Calendar timestamp) {
		this.timestamp = timestamp;
	}




}
