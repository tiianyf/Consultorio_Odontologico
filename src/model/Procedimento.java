package model;

/**
 *
 * @author cfreitas
 */
public class Procedimento {
    
    protected String tipo;
    protected Dentista dentista;
    protected Cliente cliente;
    protected double valor;
    protected String formaPgto;

    public Procedimento() {
    
        this.tipo = "";
        this.dentista = new Dentista();
        this.cliente = new Cliente();
        this.valor = 0.0;
        this.formaPgto = "";
    }
}
