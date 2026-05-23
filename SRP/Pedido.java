package SRP;

public class Pedido {
    private String cliente;
    private String item;
    private double valor;

    public Pedido(String cliente, String item, double valor) {
        this.cliente = cliente;
        this.item = item;
        this.valor = valor;
    }

    public String getCliente() { return cliente; }
    public String getItem()    { return item; }
    public double getValor()   { return valor; }
}
