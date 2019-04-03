package br.com.marquei.model;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pessoa")
    @OnDelete(action = OnDeleteAction.CASCADE)
	private Pessoa pessoa;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_contrato")
    @OnDelete(action = OnDeleteAction.CASCADE)
	private Contrato contratos;
	
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

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public void setContratos(Contrato contratos) {
		this.contratos = contratos;
	}



}
