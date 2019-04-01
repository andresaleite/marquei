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
	
	@OneToMany
	@Column(name="id_contrato_principal")
	private List<Contrato> contratosPrincipais;
	
	@ManyToMany
	@Column(name="id_pessoa")
	private List<Pessoa> pessoa;
	
	@Enumerated(EnumType.STRING)
	@NotNull
	@Column(name="forma_pagamento")
	private EnumFormaPagamento formaPagamento;
	
	@NotNull
	@Column
	private BigDecimal valor;
	
	@Column(name="data_assinatura")
	private LocalDate dataAssinatura;

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
	@Column(name="tipo_relacao_contrato")
	private EnumTipoRelacaoContrato relacaoTipoContrato;
	
	@Column
	@CreationTimestamp
	private Calendar timestamp;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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


	public Calendar getTimestamp() {
		return timestamp;
	}


	public void setTimestamp(Calendar timestamp) {
		this.timestamp = timestamp;
	}

	public LocalDate getDataAssinatura() {
		return dataAssinatura;
	}

	public void setDataAssinatura(LocalDate dataAssinatura) {
		this.dataAssinatura = dataAssinatura;
	}

	public EnumTipoRelacaoContrato getRelacaoTipoContrato() {
		return relacaoTipoContrato;
	}

	public void setRelacaoTipoContrato(EnumTipoRelacaoContrato relacaoTipoContrato) {
		this.relacaoTipoContrato = relacaoTipoContrato;
	}

	public List<Contrato> getContratosPrincipais() {
		return contratosPrincipais;
	}

	public void setContratosPrincipais(List<Contrato> contratosPrincipais) {
		this.contratosPrincipais = contratosPrincipais;
	}

	public List<Pessoa> getPessoa() {
		return pessoa;
	}

	public void setPessoa(List<Pessoa> pessoa) {
		this.pessoa = pessoa;
	}
	

}
