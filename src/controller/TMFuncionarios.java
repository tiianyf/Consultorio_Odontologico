package controller;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import model.Funcionario;

/**
 * Controlador (Table Model) da classe Funcionário. Está é uma tabela contendo
 * todos os funcionários cadastrados no sistema, contendo 8 colunas:
 * (NOME;CPF;SEXO;IDADE;TELEFONE;EMAIL;CARGO;SALARIO)
 *
 * @author cfreitas
 */
public class TMFuncionarios extends AbstractTableModel {

    private final ArrayList<Funcionario> lstFuncionarios = new ArrayList<>();
    private final ArrayList<String> lstColunas = new ArrayList<>();

    public TMFuncionarios() {
        this.lstColunas.add("Nome");
        this.lstColunas.add("CPF");
        this.lstColunas.add("Sexo");
        this.lstColunas.add("Idade");
        this.lstColunas.add("Telefone");
        this.lstColunas.add("Email");
        this.lstColunas.add("Cargo");
        this.lstColunas.add("Salário");
    }

    public ArrayList<Funcionario> getLstFuncionarios() {
        return lstFuncionarios;
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
        return this.lstFuncionarios.size();
    }

    @Override
    public int getColumnCount() {
        return this.lstColunas.size();
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        
        if (coluna == this.lstColunas.indexOf("Nome")) {
        
            return this.lstFuncionarios.get(linha).getNome();
        
        } else if (coluna == this.lstColunas.indexOf("Idade")) {
            
            return this.lstFuncionarios.get(linha).getIdade();
        
        } else if (coluna == this.lstColunas.indexOf("Telefone")) {
            
            return this.lstFuncionarios.get(linha).getTelefone();
        
        } else if (coluna == this.lstColunas.indexOf("Email")) {
            
            return this.lstFuncionarios.get(linha).getEmail();
        
        } else if (coluna == this.lstColunas.indexOf("CPF")) {
            
            return this.lstFuncionarios.get(linha).getCpf();
        
        } else if (coluna == this.lstColunas.indexOf("Sexo")) {
            
            return this.lstFuncionarios.get(linha).getSexo();
        
        } else if (coluna == this.lstColunas.indexOf("Cargo")) {
            
            return this.lstFuncionarios.get(linha).getCargo();
        
        } else if (coluna == this.lstColunas.indexOf("Salário")) {
        
            return this.lstFuncionarios.get(linha).getSalario();
        
        }
    
        System.out.println("Objeto não encontrado!");
        return null;
    
    }

    public void addLinha(Funcionario f) {
        
        this.getLstFuncionarios().add(f);
        this.fireTableDataChanged();
    
    }

    public void removerLinha(int linha) {
    
        this.lstFuncionarios.remove(linha);
        this.fireTableRowsDeleted(linha, linha);
        this.fireTableDataChanged();
    
    }

    public Funcionario getLinha(int indice) {
        return this.getLstFuncionarios().get(indice);
    }

}
