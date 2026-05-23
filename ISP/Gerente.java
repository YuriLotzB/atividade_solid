package ISP;

public class Gerente implements GerenciadorPedidos, GerenciadorEntregas,
                                EnviadorNotificacoes, GeradorRelatorios {

    @Override
    public void criarPedido(String cliente, String item) {
        System.out.println("Pedido de '" + item + "' criado para " + cliente + ".");
    }

    @Override
    public void cancelarPedido(String cliente) {
        System.out.println("Pedido de " + cliente + " cancelado.");
    }

    @Override
    public void atribuirEntregador(String pedido, String entregador) {
        System.out.println("Entregador " + entregador + " atribuido ao pedido de " + pedido + ".");
    }

    @Override
    public void confirmarEntrega(String pedido) {
        System.out.println("Entrega do pedido de " + pedido + " confirmada!");
    }

    @Override
    public void notificarCliente(String cliente, String mensagem) {
        System.out.println("Notificando " + cliente + ": " + mensagem);
    }

    @Override
    public void gerarRelatorio() {
        System.out.println("Relatorio geral do sistema gerado com sucesso!");
    }
}
