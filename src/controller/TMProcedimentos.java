package controller;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Procedimento;
//import model.Procedimento;

public class TMProcedimentos extends AbstractTableModel {

    private final List<String> lstColunas;
    private final List<Procedimento> lstProcedimentos;

    public TMProcedimentos() {
        
        this.lstColunas = new ArrayList<>();
        this.lstProcedimentos = new ArrayList<>();
        
        this.lstColunas.add("Tipo");
        this.lstColunas.add("Valor");
        this.lstColunas.add("Paciente");
        this.lstColunas.add("CPF");
        this.lstColunas.add("Tempo");
    }

    @Override
    public int getRowCount() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getColumnCount() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
