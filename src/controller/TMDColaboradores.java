package controller;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import model.DColaborador;

/**
 * Controlador (Table Model) da classe DColaborador. Está é uma tabela contendo
 * todos os dentistas colaboradores cadastrados no sistema, contendo 8 colunas:
 * (NOME;CPF;SEXO;CRO;IDADE;TELEFONE;EMAIL)
 *
 * @author cfreitas
 */
public class TMDColaboradores extends AbstractTableModel {

    private final ArrayList<DColaborador> lstDColaboradores = new ArrayList<>();
    private final ArrayList<String> lstColunas = new ArrayList<>();

    public TMDColaboradores() {
        this.lstColunas.add("Nome");
        this.lstColunas.add("CPF");
        this.lstColunas.add("Sexo");
        this.lstColunas.add("CRO");
        this.lstColunas.add("Telefone");
        this.lstColunas.add("Idade");
        this.lstColunas.add("Email");
    }

    public ArrayList<DColaborador> getLstDColaboradores() {
        return lstDColaboradores;
    }

    public ArrayList<String> getLstColunas() {
        return lstColunas;
    }

    @Override
    public String getColumnName(int index) {
        return this.getLstColunas().get(index);
    }

    @Override
    public int getRowCount() {
        return this.lstDColaboradores.size();
    }

    @Override
    public int getColumnCount() {
        return this.lstColunas.size();
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        if (coluna == this.lstColunas.indexOf("Nome")) {
            return this.lstDColaboradores.get(linha).getNome();
        } else if (coluna == this.lstColunas.indexOf("CPF")) {
            return this.lstDColaboradores.get(linha).getCpf();
        } else if (coluna == this.lstColunas.indexOf("Sexo")) {
            return this.lstDColaboradores.get(linha).getSexo();
        } else if (coluna == this.lstColunas.indexOf("CRO")) {
            return this.lstDColaboradores.get(linha).getCro();
        } else if (coluna == this.lstColunas.indexOf("Telefone")) {
            return this.lstDColaboradores.get(linha).getTelefone();
        } else if (coluna == this.lstColunas.indexOf("Idade")) {
            return this.lstDColaboradores.get(linha).getIdade();
        } else if (coluna == this.lstColunas.indexOf("Email")) {
            return this.lstDColaboradores.get(linha).getEmail();
        }
        System.out.println("Objeto não encontrado!");
        return null;
    }

    public void addLinha(DColaborador d) {
        this.getLstDColaboradores().add(d);
        this.fireTableDataChanged();
    }

    public void removerLinha(int linha) {
        this.lstDColaboradores.remove(linha);
        this.fireTableRowsDeleted(linha, linha);
        this.fireTableDataChanged();
    }

    public DColaborador getLinha(int indice) {
        return this.lstDColaboradores.get(indice);
    }

}
