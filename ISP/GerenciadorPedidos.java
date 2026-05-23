package ISP;

public interface GerenciadorPedidos {
    void criarPedido(String cliente, String item);
    void cancelarPedido(String cliente);
}

