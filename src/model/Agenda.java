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
    private DProprietario dp;
    private DColaborador dc;
    private String data;
    private String horario;

    public Agenda() {
        this.paciente = new Paciente();
        this.dp = new DProprietario();
        this.dc = new DColaborador();
        this.data = "";
        this.horario = "";
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public DProprietario getDp() {
        return dp;
    }

    public void setDp(DProprietario dp) {
        this.dp = dp;
    }

    public DColaborador getDc() {
        return dc;
    }

    public void setDc(DColaborador dc) {
        this.dc = dc;
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
        String info = "PACIENTE;DATA;HORARIO";
        return info;
    }

    @Override
    public String getInfoCSV() {
        String info
                = "\n" + this.paciente.getNome() + ";" + this.data
                + ";" + this.horario;

        return info;
    }

    @Override
    public void setInfoCSV(String linhaCSV) {
        String[] info = linhaCSV.split(";");
        
        this.paciente.setNome(info[0]);
        this.data = info[1];
        this.horario = info[2];
    }

}
