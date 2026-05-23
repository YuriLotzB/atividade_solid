import SRP.*;
import OCP.*;
import LSP.*;
import ISP.*;
import DIP.*;

import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        boolean rodando = true;
        while (rodando) {
            System.out.println("1: Criar pedido");
            System.out.println("2: Formas de pagamento");
            System.out.println("3: Cardapio de produtos");
            System.out.println("4: Papeis do sistema");
            System.out.println("5: Notificações");
            System.out.println("0: Sair");

            String opcao = sc.nextLine().trim();
            System.out.println();

            switch (opcao) {
                case "1" -> opcao1();
                case "2" -> opcao2();
                case "3" -> opcao3();
                case "4" -> opcao4();
                case "5" -> opcao5();
                case "0" -> { System.out.println("Encerrando o sistema."); rodando = false; }
                default  -> System.out.println("Opçao invalida.");
            }
        }
    }

    static void opcao1() {
        System.out.print("Nome do cliente: ");
        String cliente = sc.nextLine().trim();

        System.out.print("Item do pedido : ");
        String item = sc.nextLine().trim();

        double valor = 0;
        while (true) {
            System.out.print("Valor: ");
            try {
                valor = Double.parseDouble(sc.nextLine().trim().replace(",", "."));
                break;
            } catch (NumberFormatException e) {
                System.out.println("Valor invalido.");
            }
        }

        Pedido pedido           = new Pedido(cliente, item, valor);
        PedidoRepository repo   = new PedidoRepository();
        PedidoRelatorio relat   = new PedidoRelatorio();

        repo.salvar(pedido);
        relat.exibir(pedido);
    }

    static void opcao2() {
        double valor = 0;
        while (true) {
            System.out.print("Valor do pedido: ");
            try {
                valor = Double.parseDouble(sc.nextLine().trim().replace(",", "."));
                break;
            } catch (NumberFormatException e) {
                System.out.println("Valor invalido.");
            }
        }

        System.out.println("Forma de pagamento:");
        System.out.println("1: Cartao de Credito");
        System.out.println("2: PIX");
        System.out.println("3: Dinheiro");

        FormaPagamento pagamento = switch (sc.nextLine().trim()) {
            case "1" -> new PagamentoCartao();
            case "2" -> new PagamentoPix();
            case "3" -> new PagamentoDinheiro();
            default  -> { System.out.println("Você inseriou uma opçao invalida. O sistema agora usara Dinheiro."); yield new PagamentoPix(); }
        };

        pagamento.pagar(valor);
    }

    static void opcao3() {
        System.out.println("Tipo de produto:");
        System.out.println("1: Pizza");
        System.out.println("2: Hambúrguer");
        System.out.println("3: Bebida");
        String tipo = sc.nextLine().trim();

        System.out.print("Nome do produto: ");
        String nome = sc.nextLine().trim();

        double preco = 0;
        while (true) {
            System.out.print("Preço: ");
            try {
                preco = Double.parseDouble(sc.nextLine().trim().replace(",", "."));
                break;
            } catch (NumberFormatException e) {
                System.out.println("Valor invalido.");
            }
        }

        Produto produto = switch (tipo) {
            case "1" -> {
                System.out.print("Tamanho (P/M/G): ");
                String tamanho = sc.nextLine().trim();
                yield new Pizza(nome, preco, tamanho);
            }
            case "2" -> {
                System.out.print("Vem com batata frita? (s/n): ");
                boolean combo = sc.nextLine().trim().equalsIgnoreCase("s");
                yield new Hamburguer(nome, preco, combo);
            }
            case "3" -> {
                System.out.print("Volume: ");
                String vol = sc.nextLine().trim();
                yield new Bebida(nome, preco, vol);
            }
            default -> {
                System.out.println("Tipo invalido, criando produto generico.");
                yield new Produto(nome, preco);
            }
        };

        System.out.println("  " + produto.descrever());
    }

    static void opcao4() {
        System.out.println("Papel no sistema:");
        System.out.println("1: Atendente");
        System.out.println("2: Gerente");
        System.out.print("Opçao: ");
        String papel = sc.nextLine().trim();

        System.out.print("Nome do cliente: ");
        String cliente = sc.nextLine().trim();

        System.out.print("Item do pedido: ");
        String item = sc.nextLine().trim();

        if (papel.equals("1")) {
            Atendente atendente = new Atendente();
            atendente.criarPedido(cliente, item);
            atendente.notificarCliente(cliente, "Pedido recebido com sucesso");
            System.out.println("Atendente nao tem acesso a relatorios nem entregas.");
        } else {
            Gerente gerente = new Gerente();
            gerente.criarPedido(cliente, item);
            gerente.notificarCliente(cliente, "Pedido recebido com sucesso");
            gerente.atribuirEntregador(cliente, "Carlos");
            gerente.confirmarEntrega(cliente);
            gerente.gerarRelatorio();
        }
    }

    static void opcao5() {
        System.out.print("Nome do cliente: ");
        String cliente = sc.nextLine().trim();

        System.out.println("Canal de notificaçao:");
        System.out.println("1: Email");
        System.out.println("2: SMS");
        System.out.println("3: WhatsApp");
        System.out.print("Opçao: ");

        Notificavel canal = switch (sc.nextLine().trim()) {
            case "1" -> new NotificacaoEmail();
            case "2" -> new NotificacaoSMS();
            case "3" -> new NotificacaoWhatsApp();
            default  -> { System.out.println("Você inseriou uma opçao invalida. O sistema agora usara Email."); yield new NotificacaoEmail(); }
        };

        SistemaNotificacoes sistema = new SistemaNotificacoes(canal);
        sistema.notificarPedidoConfirmado(cliente);
        sistema.notificarPedidoSaiu(cliente);
    }
}
