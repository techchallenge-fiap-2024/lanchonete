package com.bytelanches.adapter.out.persistencia.jpa;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import com.bytelanches.aplicacao.dominio.cliente.CPF;

@Converter
public class CPFConverter implements AttributeConverter<CPF, String> {

    @Override
    public String convertToDatabaseColumn(CPF cpf) {
        if (cpf == null) {
            return null;
        }

        return cpf.toString();
    }

    @Override
    public CPF convertToEntityAttribute(String dbColumnValue) {
        if (dbColumnValue == null || dbColumnValue.isEmpty()) {
            return CPF.NULL;
        }

        return CPF.parse(dbColumnValue);
    }
}