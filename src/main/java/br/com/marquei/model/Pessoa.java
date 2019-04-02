package br.com.marquei.model;

import java.time.LocalDate;
import java.util.Calendar;
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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
	
	@Column(name="dt_nascimento")
	private LocalDate dataNascimento;
	
	@NotNull
	@Column
	@Size(min = 5 , max = 50)
	private String email;
	
	@Column(name="cpf_cnpj")
	private Long cpfCnpj;
	

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
	
	@Column
	@CreationTimestamp
	private Calendar timestamp;
	
	@OneToMany(cascade = {CascadeType.ALL})
	@JoinColumn(name = "id_pessoa")
	private List<Endereco> enderecos;
	
	
	@ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
	        name = "contrato_pessoa",
	        joinColumns = @JoinColumn(name = "id_pessoa"),
	        inverseJoinColumns = @JoinColumn(name = "id_contrato")
	    )
	    private List<Contrato> contratos;


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

	public Calendar getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Calendar timestamp) {
		this.timestamp = timestamp;
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

	public List<Contrato> getContratos() {
		return contratos;
	}

	public void setContratos(List<Contrato> contratos) {
		this.contratos = contratos;
	}




}
