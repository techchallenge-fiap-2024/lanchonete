package com.bytelanches.adapter.in.rest;

import com.bytelanches.adapter.in.rest.dto.ComboVIewDTO;
import com.bytelanches.adapter.in.rest.dto.IdentificadorDoClienteViewDTO;
import com.bytelanches.aplicacao.dominio.cliente.CPF;
import com.bytelanches.aplicacao.dominio.cliente.Cliente;
import com.bytelanches.aplicacao.dominio.cliente.IdentificadorDoCliente;
import com.bytelanches.aplicacao.porta.in.cliente.BuscarClienteUseCase;
import com.bytelanches.aplicacao.porta.in.pedido.CriarComboUseCase;
import com.bytelanches.aplicacao.service.ClienteService;
import com.bytelanches.aplicacao.service.ComboService;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.Optional;

@Path("/combo")
@Produces(MediaType.APPLICATION_JSON)
public class ProdutoController extends AbstractController {

    ProdutoController() {
    }
}
