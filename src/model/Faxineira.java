package model;

/**
 *
 * @author cfreitas
 */
public class Faxineira extends Funcionario{
    /*Recebe por dia trabalhado, não está inclusa no regime CLT*/
    protected String diasTrabalhados;
    public Faxineira() {
    
        super();
        this.diasTrabalhados = "";
        
    }
}
