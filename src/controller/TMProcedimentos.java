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

        this.lstColunas.add("ID");
        this.lstColunas.add("Tipo");
        this.lstColunas.add("Valor");
        this.lstColunas.add("Paciente");
        this.lstColunas.add("CPF");
        this.lstColunas.add("Tempo");
    }

    public List<Procedimento> getLstProcedimentos() {
        return lstProcedimentos;
    }

    /**
     * Retorna um objeto(da Classe Procedimento) na linha index.
     *
     * @param index o índice da linha da tabela.
     * @return um objeto da Classe Procedimento.
     */
    public Procedimento getRow(int index) {
        return this.getLstProcedimentos().get(index);
    }

    @Override
    public int getRowCount() {
        return this.getLstProcedimentos().size();
    }

    @Override
    public int getColumnCount() {
        return this.lstColunas.size();
    }

    @Override
    public Object getValueAt(int linha, int coluna) {

        if (coluna == this.lstColunas.indexOf("ID")) {
            return this.getLstProcedimentos().get(linha).getId();

        } else if (coluna == this.lstColunas.indexOf("Tipo")) {
            return this.getLstProcedimentos().get(linha).getDescricao();

        } else if (coluna == this.lstColunas.indexOf("Valor")) {
            return this.getLstProcedimentos().get(linha).getValor();

        } else if (coluna == this.lstColunas.indexOf("Paciente")) {
            return this.getLstProcedimentos().get(linha).getPaciente().getNome();

        } else if (coluna == this.lstColunas.indexOf("CPF")) {
            return this.getLstProcedimentos().get(linha).getPaciente().getCpf();

        } else if (coluna == this.lstColunas.indexOf("Tempo")) {
            return this.getLstProcedimentos().get(linha).getTempo();

        } else {
            System.out.println("Objeto não encontrado");
            return null;
        }

    }

    @Override
    public String getColumnName(int index) {
        return this.lstColunas.get(index);
    }

    /**
     * Adiciona uma linha (Procedimento) à tabela e atualiza a mesma.
     *
     * @param p o procedimento que será adicionado.
     */
    public void addLinha(Procedimento p) {

        this.getLstProcedimentos().add(p);
        this.fireTableDataChanged();

    }

    /**
     * Remove uma linha (Procedimento) da tabela e atualiza a mesma.
     *
     * @param linha a linha que será removida.
     */
    public void removeLinha(int linha) {

        this.getLstProcedimentos().remove(linha);
        this.fireTableRowsDeleted(linha, linha);
        this.fireTableDataChanged();

    }

    public void atualizar(){
        this.fireTableDataChanged();
    }
    
}
