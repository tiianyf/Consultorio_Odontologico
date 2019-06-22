package controller;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import model.Agenda;

/**
 * Controlador (Table Model) da classe Agenda. Está é uma tabela contendo todos
 * os agendamentos marcados no sistema, dispõe de 4 colunas:
 * (PACIENTE;DENTISTA;DATA;HORARIO).
 *
 * @author cfreitas
 */
public class TMAgenda extends AbstractTableModel {
    private final ArrayList<Agenda> lstAgendamentos = new ArrayList<>();
    private final ArrayList<String> lstColunas = new ArrayList<>();
    
    public TMAgenda() {
        this.lstColunas.add("Paciente");
//        this.lstColunas.add("Dentista");
        this.lstColunas.add("Data");
        this.lstColunas.add("Horario");
    }

    public ArrayList<Agenda> getLstAgendamentos() {
        return lstAgendamentos;
    }

    public ArrayList<String> getLstColunas() {
        return lstColunas;
    }
    
    public Agenda getRow(int index) {
        return this.getLstAgendamentos().get(index);
    }
    
    @Override
    public String getColumnName(int index) {
        return this.getLstColunas().get(index);
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
        if(coluna == this.lstColunas.indexOf("Paciente")){
            return this.lstAgendamentos.get(linha).getPaciente().getNome();
        }
        else if(coluna == this.lstColunas.indexOf("Data")){
            return this.lstAgendamentos.get(linha).getData();
        }
        else if(coluna == this.lstColunas.indexOf("Horario")){
            return this.lstAgendamentos.get(linha).getHorario();
        }
        else{
            System.out.println("Objeto não encontrado!");
            return null;
        }
    }
    
    public void addLinha(Agenda a){
        this.getLstAgendamentos().add(a);
        this.fireTableDataChanged();
    }
   
    public void removerLinha(int linha){
        this.lstAgendamentos.remove(linha);
        this.fireTableRowsDeleted(linha, linha);
        this.fireTableDataChanged();
    }
    
    public Agenda getLinha(int indice){
        return this.lstAgendamentos.get(indice);
    }
}
