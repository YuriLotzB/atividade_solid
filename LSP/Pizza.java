package LSP;

public class Pizza extends Produto {
    private String tamanho;

    public Pizza(String nome, double preco, String tamanho) {
        super(nome, preco);
        this.tamanho = tamanho;
    }

    @Override
    public String descrever() {
        return "Pizza: " + nome + " / Tamanho: " + tamanho + " / Preço: R$ " + String.format("%.2f", preco);
    }
}
