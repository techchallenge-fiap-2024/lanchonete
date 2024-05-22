package lanchonete.aplicacao.porta.out.persistencia;

import java.util.Optional;

import lanchonete.aplicacao.dominio.cliente.CPF;
import lanchonete.aplicacao.dominio.cliente.Cliente;

public interface ClienteRepositorio {

	Optional<Cliente> get(CPF cpf);

	Optional<Integer> getId(CPF cpf);

	void salvar(Cliente cliente);

}
