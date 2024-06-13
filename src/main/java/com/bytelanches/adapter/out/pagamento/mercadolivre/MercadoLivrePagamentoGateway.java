package com.bytelanches.adapter.out.pagamento.mercadolivre;

import com.bytelanches.aplicacao.dominio.pagamento.SituacaoDoPagamento;
import com.bytelanches.aplicacao.dominio.pedido.Pedido;
import com.bytelanches.aplicacao.porta.out.pagamento.GatewayDePagamento;

public class MercadoLivrePagamentoGateway implements GatewayDePagamento {

    @Override
    public byte[] gerarQRCode(Pedido pedido) {
        return new byte[0];
    }

    @Override
    public SituacaoDoPagamento consultar(Pedido pedido) {
        return SituacaoDoPagamento.PAGO;
    }

}
