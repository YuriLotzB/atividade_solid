package DIP;

// DIP: A classe principal depende desta abstração — nunca de implementações concretas.
public interface Notificavel {
    void enviarNotificacao(String destinatario, String mensagem);
}
