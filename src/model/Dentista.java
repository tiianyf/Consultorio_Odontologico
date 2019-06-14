package model;

/**
 *
 * @author cfreitas
 */
public class Dentista extends Pessoa{
    
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
    public void setCSVInfo(String linhaCSV) {
        super.setCSVInfo(linhaCSV);
        String[] temp = linhaCSV.split(";");
        this.cro = temp[10];
    }
}
