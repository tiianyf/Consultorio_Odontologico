package model;

/**
 *
 * @author cfreitas
 */
public class Procedimento {

    private String nome;
    private Dentista dentista;
    private Paciente paciente;
    private double preco;

    /*
    Formas de pagamento:
    1 - dinheiro
    2 - à vista no cartão
    3 - 2x no cartão
     */
    private int formaPgto;

     public Procedimento(String nome, Dentista dentista, Paciente paciente, double valor, int formaPgto) {
        this.nome = nome;
        this.dentista = dentista;
        this.paciente = paciente;
        this.preco = valor;
        this.formaPgto = formaPgto;

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Dentista getDentista() {
        return dentista;
    }

    public void setDentista(Dentista dentista) {
        this.dentista = dentista;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getFormaPgto() {
        return formaPgto;
    }

    public void setFormaPgto(int formaPgto) {
        this.formaPgto = formaPgto;
    }
}
