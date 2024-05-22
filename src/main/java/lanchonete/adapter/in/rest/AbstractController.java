package lanchonete.adapter.in.rest;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import jakarta.json.bind.JsonbBuilder;
import jakarta.json.bind.JsonbConfig;
import jakarta.json.bind.config.PropertyVisibilityStrategy;
import jakarta.ws.rs.ClientErrorException;
import jakarta.ws.rs.core.Response;
import lanchonete.adapter.in.rest.comum.ErroRest;

public class AbstractController {
	private static final PropertyVisibilityStrategy VISIBILITY_STRATEGY = new PropertyVisibilityStrategy() {
	    @Override
	    public boolean isVisible(Field field) {
	        return true;
	    }

	    @Override
	    public boolean isVisible(Method method) {
	        return false;
	    }
	};
	private static final JsonbConfig JSONB_CONFIG = new JsonbConfig().withPropertyVisibilityStrategy(VISIBILITY_STRATEGY);
	
	
	protected ClientErrorException badRequest(String mensagem) {
		return new ClientErrorException(mensagem(Response.Status.BAD_REQUEST, mensagem));
	}

	protected Response notExist() {
		return Response.noContent().build();
	}
	
	protected Response mensagem(Response.Status status, String mensagem) {
		ErroRest erroEntity = new ErroRest(status.getStatusCode(), mensagem);
    	return Response.status(status).entity(erroEntity).build();
	}

	protected <T> T lerJson(String json, Class<T> klass) {
		try {
            return JsonbBuilder.create(JSONB_CONFIG)
					.fromJson(json, klass);
		} catch (Exception e) {
			throw badRequest("Erro ao ler json");
		}

	}
	
}
