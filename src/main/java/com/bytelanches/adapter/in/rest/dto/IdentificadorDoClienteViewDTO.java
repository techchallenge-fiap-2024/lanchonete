package com.bytelanches.adapter.in.rest.dto;

import jakarta.json.bind.annotation.JsonbCreator;

public record IdentificadorDoClienteViewDTO(String cpf, String nome) {

    @JsonbCreator
    public IdentificadorDoClienteViewDTO {}
    
}
