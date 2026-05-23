package ISP;

public interface GerenciadorEntregas {
    void atribuirEntregador(String pedido, String entregador);
    void confirmarEntrega(String pedido);
}
