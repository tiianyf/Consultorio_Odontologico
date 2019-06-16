/**
 * Título da classe.
 * Insira aqui uma pequena descrição sobre a mesma.
 *
 * @author Cláudio Henrique <https://github.com/01ch01>
 * @since Jun 15, 2019 at 8:01:45 PM
 * @version 0.1
 */
package controller;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Procedimento;

public class TMProcedimentos extends AbstractTableModel {

    private final String[] lstNomes;
    private final double[] lstPrecos;
    private final List<String> lstColunas;
    private final List<Procedimento> lstProcedimentos;

    public TMProcedimentos() {
        this.lstNomes = new String[]{
            "Clareamento dental", "Tratamento ortodôntico", "Implante",
            "Próteses fixas", "Enxerto gengival", "Raspagem", "Endodontia"
        };
        this.lstPrecos = new double[]{
            400.0, 500.00, 800.00, 631.00, 400.00, 250.00, 432.00
        };
        this.lstProcedimentos = new ArrayList<>();
        
        this.lstColunas = new ArrayList<>();
        this.lstColunas.add("Nome");
        this.lstColunas.add("Dentista(s)");
        this.lstColunas.add("Paciente");
        this.lstColunas.add("Preço");
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
