package br.com.marquei.model;

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
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;


/**
 * @author andresaleite@gmailcom
 *
 */
@Entity
@Table(name="plano")
public class Plano {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_plano")
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_pessoa")
	private Pessoa pessoa;
	
	@Column(name="data_inicio")
	private LocalDate dataInicio;
	
	@Column(name="data_fim")
	private LocalDate dataFim;
	
	@Enumerated(EnumType.STRING)
	@NotNull
	@Column(name="status")
	private EnumStatusPlano status;

	@Size(min = 3 , max = 200)
	@Column(name="titulo")
	private String titulo;
	
	@Size(min = 3 , max = 400)
	@Column(name="descricao")
	private String descricao;
	
	@Size(min = 3 , max = 1000)
	@Column(name="termos_contrato")
	private StringBuffer termosContrato;
	
	@Column(name = "timestamp", updatable=false)
	@CreationTimestamp
	private Timestamp timestamp;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public LocalDate getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}

	public LocalDate getDataFim() {
		return dataFim;
	}

	public void setDataFim(LocalDate dataFim) {
		this.dataFim = dataFim;
	}

	public EnumStatusPlano getStatus() {
		return status;
	}

	public void setStatus(EnumStatusPlano status) {
		this.status = status;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public StringBuffer getTermosContrato() {
		return termosContrato;
	}

	public void setTermosContrato(StringBuffer termosContrato) {
		this.termosContrato = termosContrato;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

}
