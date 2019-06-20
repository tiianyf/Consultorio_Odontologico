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

import java.util.Random;

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
    private int tempo;
    private Paciente paciente;
    private String id;

    private Procedimento(String descricao, double valor) {
        this.descricao = descricao;
        this.valor = valor;
        this.tempo = 0;
        this.paciente = new Paciente();
        this.id = "-1";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public int getTempo() {
        return tempo;
    }

    public void setTempo(int tempo) {
        this.tempo = tempo;
    }

    public double getValor() {
        return valor;
    }

    public String getDescricao() {
        return descricao;
    }

    /**
     * Retorna uma string entre 1000 e 9999
     *
     * @return
     */
    public String idAleatorio() {

        System.out.println("oi");
        Random r = new Random();
        int resultado = 1000 + r.nextInt(10000);
        String aux = Integer.toString(resultado);

        return aux;

    }
}
