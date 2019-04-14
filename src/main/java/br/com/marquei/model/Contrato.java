package br.com.marquei.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDate;

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


/**
 * @author andresaleite@gmailcom
 *
 */
@Entity
@Table(name="contrato")
public class Contrato {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_contrato")
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_plano")
	private Plano idPlano;
	
	@ManyToOne
    @JoinColumn(name = "id_pessoa_cadastradora")
    private Pessoa pessoaCadastradora;
	
	//endereço do contrato
	@ManyToOne
	@JoinColumn( name = "id_endereco")
	private Endereco endereco;
	
	
	@Enumerated(EnumType.STRING)
	@NotNull
	@Column(name="forma_pagamento")
	private EnumFormaPagamento formaPagamento;
	
	@Column
	private BigDecimal valor;
	
	@Column(name="data_assinatura")
	private LocalDate dataAssinatura;
	
	@Column(name="data_fim")
	private LocalDate dataFim;
	
	@Enumerated(EnumType.STRING)
	@NotNull
	@Column(name="status")
	private EnumStatusContrato status;
	
	@Column(name = "timestamp", updatable=false)
	@CreationTimestamp
	private Timestamp timestamp;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public EnumFormaPagamento getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(EnumFormaPagamento formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public LocalDate getDataAssinatura() {
		return dataAssinatura;
	}

	public void setDataAssinatura(LocalDate dataAssinatura) {
		this.dataAssinatura = dataAssinatura;
	}

	public LocalDate getDataFim() {
		return dataFim;
	}

	public void setDataFim(LocalDate dataFim) {
		this.dataFim = dataFim;
	}

	public Plano getIdPlano() {
		return idPlano;
	}

	public void setIdPlano(Plano idPlano) {
		this.idPlano = idPlano;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Pessoa getPessoaCadastradora() {
		return pessoaCadastradora;
	}

	public void setPessoaCadastradora(Pessoa pessoaCadastradora) {
		this.pessoaCadastradora = pessoaCadastradora;
	}

	public EnumStatusContrato getStatus() {
		return status;
	}

	public void setStatus(EnumStatusContrato status) {
		this.status = status;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Contrato other = (Contrato) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	

}
