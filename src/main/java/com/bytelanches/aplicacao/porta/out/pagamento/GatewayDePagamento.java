package com.bytelanches.aplicacao.porta.out.pagamento;

import com.bytelanches.aplicacao.dominio.pedido.Pedido;
import com.bytelanches.aplicacao.dominio.pagamento.SituacaoDoPagamento;

public interface GatewayDePagamento {

    byte[] gerarQRCode(Pedido pedido);

    SituacaoDoPagamento consultar(Pedido pedido);
}
