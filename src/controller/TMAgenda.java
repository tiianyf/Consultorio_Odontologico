/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Agenda;

/**
 *
 * @author cfreitas
 */
public class TMAgenda extends AbstractTableModel {

    private List<String> lstColunas;
    private List<Agenda> lstAgendamentos;

    public TMAgenda() {

        this.lstColunas = new ArrayList<>();
        this.lstAgendamentos = new ArrayList<>();

        this.lstColunas.add("Paciente");
        this.lstColunas.add("CPF");
        this.lstColunas.add("Dentista");
        this.lstColunas.add("Data");
        this.lstColunas.add("Horário");
        this.lstColunas.add("ID");

    }

    public List<String> getLstColunas() {
        return lstColunas;
    }

    public void setLstColunas(List<String> lstColunas) {
        this.lstColunas = lstColunas;
    }

    public void setLstAgendamentos(List<Agenda> lstAgendamentos) {
        this.lstAgendamentos = lstAgendamentos;
    }

    public List<Agenda> getLstAgendamentos() {
        return lstAgendamentos;
    }

    public Agenda getRow(int index) {
        return this.lstAgendamentos.get(index);
    }

    @Override
    public String getColumnName(int index) {
        return this.lstColunas.get(index);
    }

    @Override
    public int getRowCount() {
        return this.lstAgendamentos.size();
    }

    @Override
    public int getColumnCount() {
        return this.lstColunas.size();
    }

    @Override
    public Object getValueAt(int linha, int coluna) {

        if (coluna == this.lstColunas.indexOf("Paciente")) {
            return this.lstAgendamentos.get(linha).getPaciente().getNome();

        } else if (coluna == this.lstColunas.indexOf("CPF")) {
            return this.lstAgendamentos.get(linha).getPaciente().getCpf();
            
        } else if (coluna == this.lstColunas.indexOf("Dentista")) {
            return this.lstAgendamentos.get(linha).getDentista().getNome();

        } else if (coluna == this.lstColunas.indexOf("Data")) {
            return this.lstAgendamentos.get(linha).getData();

        } else if (coluna == this.lstColunas.indexOf("Horário")) {
            return this.lstAgendamentos.get(linha).getHorario();

        } else if (coluna == this.lstColunas.indexOf("ID")) {
            return this.lstAgendamentos.get(linha).getId();

        } else {
            System.out.println("Objeto não encontrado!");
            return null;
        }
    }

    public void addLinha(Agenda a) {

        this.lstAgendamentos.add(a);
        this.fireTableDataChanged();

    }

    public void removeLinha(int linha) {

        this.getLstAgendamentos().remove(linha);
        this.fireTableRowsDeleted(linha, linha);
        this.fireTableDataChanged();

    }

}
