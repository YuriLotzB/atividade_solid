package DIP;

public class NotificacaoEmail implements Notificavel {
    @Override
    public void enviarNotificacao(String destinatario, String mensagem) {
        System.out.println("Email Para: " + destinatario + " → " + mensagem);
    }
}
