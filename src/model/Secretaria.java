package model;

import java.util.ArrayList;
import java.util.List;

/**
 * A secretária têm acesso ao sistema(login e senha). Suas funções são:
 * Cadastrar clientes, cadastrar procedimentos(e receber o pagamento dos
 * clientes, dada a forma de pagamento), pagar funcionários(inclusive o
 * proprietário).
 *
 * @author cfreitas
 */
public class Secretaria extends Funcionario implements Admin, Usuario {

    public void setSaldoTotal(double saldoTotal) {
        this.saldoTotal = saldoTotal;
    }

    private List<Procedimento> lstProcedimentos;
    private List<Paciente> lstPacientes;
    private List<DColaborador> lstDentistas;
    private double saldoTotal;
    private String usuario;
    private String senha;

    /**
     * Salário: R$1205,85/mês
     */
    public Secretaria() {

        super();
        this.valorDia = 60.2925;
        this.lstProcedimentos = new ArrayList<>();
        this.saldoTotal = 0.0;
        this.usuario = "cfreitas";
        this.senha = "tiiany";

    }

    public List<Procedimento> getLstProcedimentos() {
        return lstProcedimentos;
    }

    public void setLstProcedimentos(List<Procedimento> lstProcedimentos) {
        this.lstProcedimentos = lstProcedimentos;
    }

    public List<Paciente> getLstPacientes() {
        return lstPacientes;
    }

    public void setLstPacientes(List<Paciente> lstPacientes) {
        this.lstPacientes = lstPacientes;
    }

    public List<DColaborador> getLstDentistas() {
        return lstDentistas;
    }

    public void setLstDentistas(List<DColaborador> lstDentistas) {
        this.lstDentistas = lstDentistas;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    /**
     * Cadastrando pacientes em sua lista de pacientes.
     *
     * @param pac
     */
    public void cadastrarPaciente(Paciente pac) {
        this.getLstPacientes().add(pac);

    }

    /**
     * Cadastrando procedimentos realizados na lista.
     *
     * @param p
     */
    public void cadastrarProcedimento(Procedimento p) {
        this.getLstProcedimentos().add(p);
        this.setSaldoTotal(this.saldoTotal + p.getValor());

    }

    @Override
    public double getSaldoTotal() {
        return saldoTotal;
    }

    public void receberPaciente(double valor) {
        this.saldoTotal += valor;
    }

    public boolean pagar(Funcionario f) {
        if (f instanceof DColaborador) {
            if (f.getSalario() <= this.getSaldoTotal()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean autenticar(String usuario, String senha) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String acessarRelatorio() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean alterarUsuario(String usuario, String senha) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean alterarSenha(String usuario, String senha) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean cadastrarProcedimento(String usuario, String senha) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
