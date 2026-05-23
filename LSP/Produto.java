package LSP;

public class Produto {
    protected String nome;
    protected double preco;

    public Produto(String nome, double preco) {
        this.nome  = nome;
        this.preco = preco;
    }

    public String descrever() {
        return "Produto: " + nome + " / Preço: R$ " + String.format("%.2f", preco);
    }
}
