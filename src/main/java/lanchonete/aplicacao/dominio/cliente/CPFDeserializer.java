package lanchonete.aplicacao.dominio.cliente;

import jakarta.json.JsonObject;
import jakarta.json.bind.serializer.DeserializationContext;
import jakarta.json.bind.serializer.JsonbDeserializer;
import jakarta.json.stream.JsonParser;

import java.lang.reflect.Type;

public class CPFDeserializer implements JsonbDeserializer<CPF> {

    @Override
    public CPF deserialize(JsonParser jsonParser, DeserializationContext deserializationContext, Type type) {
        String valor = jsonParser.getString();
        return CPF.parse(valor);
    }
}
