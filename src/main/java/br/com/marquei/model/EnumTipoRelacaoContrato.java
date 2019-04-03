package br.com.marquei.model;

public enum EnumTipoRelacaoContrato {

	CLIENTE(1, "Cliente"),
	FUNCIONARIO(2, "Pestador de serviço de um contrato"),
	PESSOA_FISICA_INDIVIDUAL(3, "Pessoa Física prestadora de serviço"),
	PESSOA_FISICA_PREPOSTO(4, "Pessoa Física com vários prestadores de serviço"),
	EMPRESARIO_PREPOSTO(5, "Empresa com um ou vários prestadores de serviço"),
	CADASTRADOR(6, "Cadastrador");
	
	private int id;
	private String descricao;
	
	private EnumTipoRelacaoContrato(int id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}
	
	public int getId() {
		return id;
	}
	public String getDescricao() {
		return descricao;
	}
	
	
	
	
	
}
