package com.lmg.cursomc.domain.enums;

public enum TipoClienteEnum {
	
	PESSOAFISICA(1, "Pessoa física"),
	PESSOAJURIDICA(2, "Pessoa Jurídica");
	
	private int codigo;
	private String descricao;
	
	private TipoClienteEnum(int codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}
	
	public int getCodigo() {
		return codigo;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public static TipoClienteEnum toEnum(Integer codigo) {
		
		if (codigo == null) {
			return null;
		}
		for (TipoClienteEnum x : TipoClienteEnum.values()) {
			if (codigo.equals(x.getCodigo())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Id inválido "+ codigo);
		
	}

}
