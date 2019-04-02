package br.com.marquei.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name="contrato")
public class Contrato {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_contrato")
	private Long id;
	
	@Column(name="id_plano")
	private Long idPlano;
	
	@Enumerated(EnumType.STRING)
	@NotNull
	@Column(name="forma_pagamento")
	private EnumFormaPagamento formaPagamento;
	
	@NotNull
	@Column
	private BigDecimal valor;
	
	@Column(name="data_assinatura")
	private LocalDate dataAssinatura;
	
	@Column(name="data_fim")
	private LocalDate dataFim;
	
	@Column
	@CreationTimestamp
	private Calendar timestamp;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdPlano() {
		return idPlano;
	}

	public void setIdPlano(Long idPlano) {
		this.idPlano = idPlano;
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

	public Calendar getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Calendar timestamp) {
		this.timestamp = timestamp;
	}


}
