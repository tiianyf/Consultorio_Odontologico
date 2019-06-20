package model;

/**
 *
 * @author cfreitas
 */
public class Funcionario extends Pessoa {

    protected double salario;
    protected String cargo;
    protected double valorDia;
    protected int diasTrabalhados;

    public Funcionario() {

        super();
        this.salario = 0.0;
        this.cargo = "";
        this.valorDia = 0; //60
        this.diasTrabalhados = 0; //20
    }

    public double getSalario() {
        return this.salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public double getValorDia() {
        return valorDia;
    }

    public void setValorDia(double valorDia) {
        this.valorDia = valorDia;
    }

    public int getDiasTrabalhados() {
        return diasTrabalhados;
    }

    public void setDiasTrabalhados(int diasTrabalhados) {
        this.diasTrabalhados = diasTrabalhados;
    }

    @Override
    public String getCabecalhoCSV() {
        String info = super.getCabecalhoCSV();
        info += ";SALARIO;CARGO";
        return info;
    }

    @Override
    public String getInfoCSV() {
        String info = super.getInfoCSV();
        info += ";" + this.salario + ";" + this.cargo;
        return info;
    }

    @Override
    public void setInfoCSV(String linhaCSV) {

        super.setInfoCSV(linhaCSV);
        String[] info = linhaCSV.split(";");

        this.salario = Double.parseDouble(info[6]);
        this.cargo = info[7];

    }

}
