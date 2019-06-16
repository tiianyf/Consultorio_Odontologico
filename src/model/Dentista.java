package model;

/**
 *
 * @author cfreitas
 */
abstract public class Dentista extends Funcionario {

    private String cro;

    public Dentista() {

        super();
        this.cro = "";

    }

    public String getCro() {
        return cro;
    }

    public void setCro(String cro) {
        this.cro = cro;
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

        this.cro = temp[9];

    }

}
