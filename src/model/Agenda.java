/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author cfreitas
 */
public class Agenda implements DadosCSV {

    private Paciente paciente;
    private DColaborador dentista;
    private String data;
    private String horario;
    private String id;

    public Agenda() {
        this.paciente = new Paciente();
        this.dentista = new DColaborador();
        this.data = "";
        this.horario = "";
        this.id = "-1";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public DColaborador getDentista() {
        return dentista;
    }

    public void setDentista(DColaborador dentista) {
        this.dentista = dentista;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    @Override
    public String getCabecalhoCSV() {
        String info = "PACIENTE;CPF;DENTISTA;DATA;HORARIO";
        return info;
    }

    @Override
    public String getInfoCSV() {
        String info
                = "\n" + this.paciente.getNome() + ";" + this.paciente.getCpf()
                + ";" + this.dentista.getNome() + ";" + this.data + ";"
                + this.horario;

        return info;
    }

    @Override
    public void setInfoCSV(String linhaCSV) {
        String[] info = linhaCSV.split(";");

        this.paciente.setNome(info[0]);
        this.paciente.setCpf(info[1]);
        this.dentista.setNome(info[2]);
        this.data = info[3];
        this.horario = info[4];
        this.id = info[5];
    }

}
