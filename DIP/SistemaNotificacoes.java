package DIP;

// DIP: Esta classe de alto nível depende da abstração Notificavel,
//      não de nenhuma implementação concreta (Email, SMS, WhatsApp).
public class SistemaNotificacoes {
    private Notificavel canal;

    public SistemaNotificacoes(Notificavel canal) {
        this.canal = canal;
    }

    public void notificarPedidoConfirmado(String cliente) {
        canal.enviarNotificacao(cliente, "Seu pedido foi confirmado");
    }

    public void notificarPedidoSaiu(String cliente) {
        canal.enviarNotificacao(cliente, "Seu pedido saiu para entrega");
    }
}
