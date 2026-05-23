package SRP;

public class PedidoRepository {
    public void salvar(Pedido pedido) {
        System.out.println("Pedido de " + pedido.getCliente() + " salvo com sucesso!");
    }
}
