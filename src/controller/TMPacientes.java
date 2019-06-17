package controller;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import model.Paciente;

/**
 * Controlador (Table Model) da classe Paciente. Esta é uma tabela contendo
 * todos os pacientes cadastrados no sistema, contendo 11 colunas:
 * (NOME;CPF;SEXO;IDADE;TIPOSANGUINEO;TELEFONE;EMAIL;FUMANTE;ALCOOLATRA;ALERGIA;
 * DOENÇA)
 *
 * @author cfreitas
 */
public class TMPacientes extends AbstractTableModel {

    private final ArrayList<Paciente> lstPacientes = new ArrayList<>();
    private final ArrayList<String> lstColunas = new ArrayList<>();

    public TMPacientes() {

        this.lstColunas.add("Nome");
        this.lstColunas.add("CPF");
        this.lstColunas.add("Sexo");
        this.lstColunas.add("Idade");
        this.lstColunas.add("Tipo Sanguíneo");
        this.lstColunas.add("Telefone");
        this.lstColunas.add("Email");
        this.lstColunas.add("Fumante");
        this.lstColunas.add("Diabético");
        this.lstColunas.add("Alergia");
        this.lstColunas.add("Doença");

    }

    public ArrayList<Paciente> getLstPacientes() {
        return lstPacientes;
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
        return this.lstPacientes.size();
    }

    @Override
    public int getColumnCount() {
        return this.lstColunas.size();
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        if (coluna == this.lstColunas.indexOf("Nome")) {
            return this.lstPacientes.get(linha).getNome();
        } else if (coluna == this.lstColunas.indexOf("Idade")) {
            return this.lstPacientes.get(linha).getIdade();
        } else if (coluna == this.lstColunas.indexOf("Telefone")) {
            return this.lstPacientes.get(linha).getTelefone();
        } else if (coluna == this.lstColunas.indexOf("Email")) {
            return this.lstPacientes.get(linha).getEmail();
        } else if (coluna == this.lstColunas.indexOf("CPF")) {
            return this.lstPacientes.get(linha).getCpf();
        } else if (coluna == this.lstColunas.indexOf("Sexo")) {
            return this.lstPacientes.get(linha).getSexo();
        } else if (coluna == this.lstColunas.indexOf("Tipo Sanguíneo")) {
            return this.lstPacientes.get(linha).getTipoSanguineo();
        } else if (coluna == this.lstColunas.indexOf("Alergia")) {
            return this.lstPacientes.get(linha).getAlergia();
        } else if (coluna == this.lstColunas.indexOf("Doença")) {
            return this.lstPacientes.get(linha).getDoenca();
        } else if (coluna == this.lstColunas.indexOf("Fumante")) {
            return this.lstPacientes.get(linha).isFumante();
        } else if (coluna == this.lstColunas.indexOf("Diabético")) {
            return this.lstPacientes.get(linha).isDiabetico();
        }
        System.out.println("Objeto não encontrado");
        return null;
    }

    public void addLinha(Paciente p) {
        this.getLstPacientes().add(p);
        this.fireTableDataChanged();
    }

    public void removerLinha(int linha) {
        this.lstPacientes.remove(linha);
        this.fireTableRowsDeleted(linha, linha);
        this.fireTableDataChanged();
    }

    public Paciente getLinha(int indice) {
        return this.getLstPacientes().get(indice);
    }
}
