package br.com.marquei.model;

public enum EnumStatusPlano {

	VIGENTE(1, "Vigente"),
	VENCIDO(2, "Vencido");
	
	private int id;
	private String descricao;
	
	private EnumStatusPlano(int id, String descricao) {
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
