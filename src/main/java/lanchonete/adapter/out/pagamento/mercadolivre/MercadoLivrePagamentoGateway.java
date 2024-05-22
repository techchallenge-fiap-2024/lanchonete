package lanchonete.adapter.out.pagamento.mercadolivre;

import lanchonete.aplicacao.dominio.pagamento.SituacaoDoPagamento;
import lanchonete.aplicacao.dominio.pedido.Pedido;
import lanchonete.aplicacao.porta.out.pagamento.GatewayDePagamento;

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
