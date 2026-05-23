package ISP;

public class Atendente implements GerenciadorPedidos, EnviadorNotificacoes {

    @Override
    public void criarPedido(String cliente, String item) {
        System.out.println("Pedido de '" + item + "' criado para " + cliente + "!");
    }

    @Override
    public void cancelarPedido(String cliente) {
        System.out.println("Pedido de " + cliente + " cancelado.");
    }

    @Override
    public void notificarCliente(String cliente, String mensagem) {
        System.out.println("Notificando " + cliente + ": " + mensagem);
    }
}
