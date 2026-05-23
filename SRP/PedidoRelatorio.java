package SRP;

public class PedidoRelatorio {
    public void exibir(Pedido pedido) {
        System.out.println("Cliente : " + pedido.getCliente());
        System.out.println("Item    : " + pedido.getItem());
        System.out.printf( "Valor   : R$ %.2f%n", pedido.getValor());
    }
}
