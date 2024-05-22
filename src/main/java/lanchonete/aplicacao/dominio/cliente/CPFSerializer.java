package lanchonete.aplicacao.dominio.cliente;

import jakarta.json.bind.serializer.JsonbSerializer;
import jakarta.json.bind.serializer.SerializationContext;
import jakarta.json.stream.JsonGenerator;

public class CPFSerializer implements JsonbSerializer<CPF> {

    @Override
    public void serialize(CPF cpf, JsonGenerator generator, SerializationContext ctx) {
        if (cpf != null) {
            generator.write("cpf", cpf.toString());
        }
    }
}
