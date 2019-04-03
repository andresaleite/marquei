package br.com.marquei.model;

public enum EnumStatusContrato {

	PENDENTE_ASSINATURA(1, "Pendente de Assinatura"),
	PENDENTE_PAGAMENTO(2, "Pendente de Pagamnto"),
	VIGENTE(3, "Vigente"),
	VENCIDO(4, "Vencido");
	
	private int id;
	private String descricao;
	
	private EnumStatusContrato(int id, String descricao) {
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
