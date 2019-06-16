package model;

/**
 *
 * @author cfreitas
 */
public class DColaborador extends Dentista {

    protected double taxa;

    public DColaborador() {

        super();
        this.taxa = 0.4;
    }

    public double getTaxa() {
        return taxa;
    }

    @Override
    public double getSalario() {
        return super.getSalario() * (1 - this.taxa);
    }

    @Override
    public String getCabecalhoCSV() {

        String info = super.getCabecalhoCSV();
        info += ";taxa";
        return info;

    }

    @Override
    public String getInfoCSV() {

        String info = super.getInfoCSV();
        info += ";" + this.taxa;
        return info;

    }

    @Override
    public void setInfoCSV(String linhaCSV) {

        super.setInfoCSV(linhaCSV);
        String[] info = linhaCSV.split(";");

        this.taxa = Double.parseDouble(info[10]);

    }

}
