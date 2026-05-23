package LSP;

public class Hamburguer extends Produto {
    private boolean comBatataFrita;

    public Hamburguer(String nome, double preco, boolean comBatataFrita) {
        super(nome, preco);
        this.comBatataFrita = comBatataFrita;
    }

    @Override
    public String descrever() {
        String combo = comBatataFrita ? " + Batata Frita" : "";
        return "Hambúrguer: " + nome + combo + " / Preço: R$ " + String.format("%.2f", preco);
    }
}
