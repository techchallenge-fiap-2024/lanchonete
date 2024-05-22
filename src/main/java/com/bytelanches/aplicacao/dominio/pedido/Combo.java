package com.bytelanches.aplicacao.dominio.pedido;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.EnumMap;
import java.util.Map;

import com.bytelanches.aplicacao.dominio.cliente.Cliente;
import com.bytelanches.aplicacao.dominio.cliente.IdentificadorDoCliente;
import com.bytelanches.aplicacao.dominio.produto.TipoDeProduto;

public class Combo {
	private Integer id;
	private Integer clienteId;
	private String identificadorDoCliente;
	private Map<TipoDeProduto,ComboItem> itens;
	private SituacaoDoCombo situacao;
	private LocalDateTime dataCriacao;
	private LocalDateTime dataAlteracao;

	public Combo() {
		this.itens = new EnumMap<>(TipoDeProduto.class);
		this.situacao = SituacaoDoCombo.CRIADO;
		this.dataCriacao = LocalDateTime.now();
	}
	public Combo(Cliente cliente) {
		this.clienteId = cliente.getId();
		this.itens = new EnumMap<>(TipoDeProduto.class);
		this.situacao = SituacaoDoCombo.CRIADO;
		this.dataCriacao = LocalDateTime.now();
	}

	public Combo(IdentificadorDoCliente identificadorDoCliente) {
	}

	public Integer getId() {
		return id;
	}
	
	public Integer getClienteId() {
		return clienteId;
	}

	public void setClienteId(Integer clienteId) {
		this.clienteId = clienteId;
	}

	public Map<TipoDeProduto, ComboItem> getItens() {
		return itens;
	}
	public void addItem(TipoDeProduto tipo, ComboItem item) {
		getItens().put(tipo, item);
		alterado();
	}
	
	public Collection<ComboItem> listar() {
		return getItens().values();
	}

	public SituacaoDoCombo getSituacao() {
		return situacao;
	}
	public void setSituacao(SituacaoDoCombo situacao) {
		this.situacao = situacao;
		alterado();
	}
	
	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}
	
	public LocalDateTime getDataAlteracao() {
		return dataAlteracao;
	}
	public void alterado() {
		this.dataAlteracao = LocalDateTime.now();
	}

	public void setIdentificadorDoCliente(String identificador) {
		this.identificadorDoCliente = identificador;
	}
}
