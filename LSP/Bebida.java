package LSP;

public class Bebida extends Produto {
    private String volume;

    public Bebida(String nome, double preco, String volume) {
        super(nome, preco);
        this.volume = volume;
    }

    @Override
    public String descrever() {
        return "Bebida: " + nome + " / Volume: " + volume + " / Preço: R$ " + String.format("%.2f", preco);
    }
}
