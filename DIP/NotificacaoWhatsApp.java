package DIP;

public class NotificacaoWhatsApp implements Notificavel {
    @Override
    public void enviarNotificacao(String destinatario, String mensagem) {
        System.out.println("WhatsApp Para: " + destinatario + " → " + mensagem);
    }
}
