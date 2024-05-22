package com.bytelanches.adapter.in.rest.dto;

import jakarta.json.bind.annotation.JsonbCreator;
import com.bytelanches.aplicacao.dominio.pedido.Combo;

public record ComboVIewDTO(Integer id) {

    @JsonbCreator
    public ComboVIewDTO {}
    
	public static ComboVIewDTO fromDominio(Combo combo) {
		return new ComboVIewDTO(combo.getId());
	}
	
}
