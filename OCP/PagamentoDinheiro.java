package OCP;

public class PagamentoDinheiro implements FormaPagamento {
    @Override
    public void pagar(double valor) {
        System.out.printf("Pagamento de R$ %.2f realizado em Dinheiro!%n", valor);
    }
}
