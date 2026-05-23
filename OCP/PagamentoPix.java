package OCP;

public class PagamentoPix implements FormaPagamento {
    @Override
    public void pagar(double valor) {
        System.out.printf("[Pagamento] Pagamento de R$ %.2f realizado via PIX!%n", valor);
    }
}
