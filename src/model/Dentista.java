package model;

/**
 *
 * @author cfreitas
 */
abstract public class Dentista extends Funcionario {

    private String cro;
    protected Procedimento procedimento;

    public Dentista() {

        super();
        this.cro = "";
        this.procedimento = new Procedimento();

    }

    @Override
    public String getCabecalhoCSV() {
        String info = super.getCabecalhoCSV();
        info += ";CRO";
        return info;
    }

    @Override
    public String getInfoCSV() {
        String info = super.getInfoCSV();
        info += ";" + this.cro;
        return info;
    }

    @Override
    public void setInfoCSV(String linhaCSV) {
        super.setInfoCSV(linhaCSV);
        String[] temp = linhaCSV.split(";");
        this.cro = temp[10];
    }

    @Override
    public double getSalario() {
        return super.getSalario(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
