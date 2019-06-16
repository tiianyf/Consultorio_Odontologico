package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cfreitas
 */
public class Secretaria extends Funcionario {

    /*Cadastra clientes, agenda procedimentos, recebe mensalidade, faz controle
    do caixa*/
    
    private List<Procedimento> lstProcedimentos;
    private List<Paciente> lstPacientes;
    private List<DColaborador> lstDentistas;
    
    /**
     *
     */
    public Secretaria() {

        super();
        this.valorDia = 60.2925;
        this.lstProcedimentos = new ArrayList<>();

    }

    /**
     *
     * @param pac
     */
    public void cadastrarPaciente(Paciente pac) {

    }

    /**
     *
     * @param proc
     */
    public void cadastrarProcedimento(Procedimento p) {
        this.lstProcedimentos.add(p);
        

    }
}
