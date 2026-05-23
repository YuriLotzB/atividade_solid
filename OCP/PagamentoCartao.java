package OCP;

public class PagamentoCartao implements FormaPagamento {
    @Override
    public void pagar(double valor) {
        System.out.printf("Pagamento de R$ %.2f realizado via Cartão de Crédito!%n", valor);
    }
}
