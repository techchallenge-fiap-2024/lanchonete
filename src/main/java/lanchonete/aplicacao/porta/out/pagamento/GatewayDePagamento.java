package lanchonete.aplicacao.porta.out.pagamento;

import lanchonete.aplicacao.dominio.pagamento.SituacaoDoPagamento;
import lanchonete.aplicacao.dominio.pedido.Pedido;

public interface GatewayDePagamento {

    byte[] gerarQRCode(Pedido pedido);

    SituacaoDoPagamento consultar(Pedido pedido);
}
