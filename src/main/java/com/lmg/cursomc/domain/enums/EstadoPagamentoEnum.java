package com.lmg.cursomc.domain.enums;

public enum EstadoPagamentoEnum {

	PENDENTE(1, "Pendente"),
	QUITADO(2, "Quitado"), 
	CANCELADO(3, "Cancelado");

	private int codigo;
	private String descricao;

	private EstadoPagamentoEnum(int codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public static EstadoPagamentoEnum toEnum(Integer cod) {
		if (cod == null) {
			return null;
		}
		for (EstadoPagamentoEnum x : EstadoPagamentoEnum.values()) {
			if (cod.equals(x.codigo)) {
				return x;
			}
		}
		throw new IllegalArgumentException("Id inválido " + cod);
	}

}
