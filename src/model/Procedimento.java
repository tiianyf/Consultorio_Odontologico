/**
 * Principais procedimentos odontológicos.
 * Foi criada uma classe enum para que demais alterações não possam ocorrer,
 * pois são valores fixos.
 *
 * @author Cláudio Henrique <https://github.com/01ch01>
 * @since Jun 16, 2019 at 2:48:40 PM
 * @version 0.1
 */
package model;

public enum Procedimento {

    CLAREAMENTO("Clareamento dental", 400.00),
    TRATAMENTO("Tratamento ortodôntico", 500.00),
    IMPLANTE("Implante", 800.00),
    PROTESE("Próteses fixas", 631.00),
    ENXERTO("Enxerto gengival", 400.00),
    RASPAGEM("Periodontia", 250.00),
    ENDODONTIA("Endodontia", 432.00);

    private final String descricao;
    private final double valor;

<<<<<<< HEAD
     public Procedimento(String nome, Dentista dentista, Paciente paciente, double valor, int formaPgto) {
        this.nome = nome;
        this.dentista = dentista;
        this.paciente = paciente;
        this.preco = valor;
        this.formaPgto = formaPgto;

        this.nome = "";
        this.paciente = new Paciente();
        this.formaPgto = 0;
        this.nome = "";
        this.paciente = new Paciente();
        this.formaPgto = 0;
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
=======
    private Procedimento(String descricao, double valor) {
        this.descricao = descricao;
        this.valor = valor;
>>>>>>> 8c969d7dd847b40823fdd4ccb012d74fe0a18a5e
    }

    public double getValor() {
        return valor;
    }

    public String getDescricao() {
        return descricao;
    }

}
