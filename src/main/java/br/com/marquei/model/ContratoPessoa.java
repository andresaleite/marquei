package br.com.marquei.model;

import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;


/**
 * @author andresaleite@gmailcom
 *
 */
@Entity
@Table(name="contrato_pessoa")
public class ContratoPessoa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_contrato_pessoa")
	private Long id;
	
	@OneToMany
	@Column(name="id_pessoa")
	private List<Pessoa> pessoas;
	
	@OneToMany
	@Column(name="id_endereco")
	private List<Endereco> enderecos;
	
	@Enumerated(EnumType.STRING)
	@NotNull
	@Column(name="tipo_relacao_contrato")
	private EnumTipoRelacaoContrato tipoRelacaoContrato;
	
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

	public List<Pessoa> getPessoas() {
		return pessoas;
	}

	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}

	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

	public EnumTipoRelacaoContrato getTipoRelacaoContrato() {
		return tipoRelacaoContrato;
	}

	public void setTipoRelacaoContrato(EnumTipoRelacaoContrato tipoRelacaoContrato) {
		this.tipoRelacaoContrato = tipoRelacaoContrato;
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
