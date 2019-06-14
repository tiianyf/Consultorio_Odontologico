package model;

/**
 *
 * @author cfreitas
 */
abstract public class Funcionario extends Pessoa{
    
    protected double salario;
    protected String cargo;
    protected double regimeTrabalho;

    public Funcionario() {
    
        super();
        this.salario = 0.0;
        this.cargo = "";
        this.regimeTrabalho = 0.0;
    }

    @Override
    public String getCabecalhoCSV() {
        String info = super.getCabecalhoCSV();
        info += ";SALARIO;CARGO;REGIMETRABALHO";
        return info;
    }

    @Override
    public String getInfoCSV() {
        String info = super.getInfoCSV();
        info += ";" + this.salario + ";" + this.cargo + ";" + this.regimeTrabalho;
        return info;
    }

    @Override
    public void setCSVInfo(String linhaCSV) {
        super.setCSVInfo(linhaCSV);
        String[] temp = linhaCSV.split(";");
        String convert = Double.toString(this.salario);
        convert = temp[6];
        this.cargo = temp[7];
        convert = Double.toString(this.regimeTrabalho);
        convert = temp[8];
    }
    
    
    
    
    
    
    
    
}
