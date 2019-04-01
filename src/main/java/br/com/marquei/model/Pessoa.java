package br.com.marquei.model;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
	
	@Enumerated(EnumType.STRING)
	@NotNull
	@Column(name="situacao_registro")
	private EnumSituacaoRegistro situacaoRegistro;
	
	@Column
	@CreationTimestamp
	private Calendar timestamp;

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


}
