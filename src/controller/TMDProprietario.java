package controller;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import model.DProprietario;

/**
 * Controlador (Table Model) da classe DProprietario. Está é uma tabela contendo
 * as informações do dentista proprietário, contendo 8 colunas:
 * (NOME;CPF;SEXO;CRO;IDADE;TELEFONE;EMAIL)
 *
 * @author cfreitas
 */
public class TMDProprietario extends AbstractTableModel {

    private ArrayList<DProprietario> lstDProprietario = new ArrayList<>();
    private ArrayList<String> lstColunas = new ArrayList<>();

    public TMDProprietario() {
        this.lstColunas.add("Nome");
        this.lstColunas.add("CPF");
        this.lstColunas.add("Sexo");
        this.lstColunas.add("CRO");
        this.lstColunas.add("Telefone");
        this.lstColunas.add("Idade");
        this.lstColunas.add("Email");
    }

    public ArrayList<DProprietario> getLstDProprietario() {
        return lstDProprietario;
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
        return this.lstDProprietario.size();
    }

    @Override
    public int getColumnCount() {
        return this.lstColunas.size();
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        if (coluna == this.lstColunas.indexOf("Nome")) {
            return this.lstDProprietario.get(linha).getNome();
        } else if (coluna == this.lstColunas.indexOf("CPF")) {
            return this.lstDProprietario.get(linha).getCpf();
        } else if (coluna == this.lstColunas.indexOf("Sexo")) {
            return this.lstDProprietario.get(linha).getSexo();
        } else if (coluna == this.lstColunas.indexOf("CRO")) {
            return this.lstDProprietario.get(linha).getCro();
        } else if (coluna == this.lstColunas.indexOf("Telefone")) {
            return this.lstDProprietario.get(linha).getTelefone();
        } else if (coluna == this.lstColunas.indexOf("Idade")) {
            return this.lstDProprietario.get(linha).getIdade();
        } else if (coluna == this.lstColunas.indexOf("Email")) {
            return this.lstDProprietario.get(linha).getEmail();
        }
        System.out.println("Objeto não encontrado!");
        return null;
    }

    public void addLinha(DProprietario d) {
        this.getLstDProprietario().add(d);
        this.fireTableDataChanged();;
    }

    public void removerLinha(int linha) {
        this.lstDProprietario.remove(linha);
        this.fireTableRowsDeleted(linha, linha);
        this.fireTableDataChanged();
    }

    public DProprietario getLinha(int indice) {
        return this.lstDProprietario.get(indice);
    }
}
