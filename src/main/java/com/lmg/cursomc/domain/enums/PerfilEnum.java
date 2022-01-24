package com.lmg.cursomc.domain.enums;

public enum PerfilEnum {

	ADMIN(1, "ROLE_ADMIN"),
	CLIENTE(2, "ROLE_CLIENTE");

	private int codigo;
	private String descricao;

	private PerfilEnum(int codigo, String descricao) {
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

	public static PerfilEnum toEnum(Integer cod) {
		if (cod == null) {
			return null;
		}
		for (PerfilEnum x : PerfilEnum.values()) {
			if (cod.equals(x.codigo)) {
				return x;
			}
		}
		throw new IllegalArgumentException("Id inválido " + cod);
	}

}
