package DIP;

public class NotificacaoSMS implements Notificavel {
    @Override
    public void enviarNotificacao(String destinatario, String mensagem) {
        System.out.println("SMS Para: " + destinatario + " → " + mensagem);
    }
}
