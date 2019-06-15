package model;

/**
 *
 * @author cfreitas
 */
abstract public class Funcionario extends Pessoa {

    protected double salario;
    protected String cargo;
    protected double valorDia;
    protected int diasTrabalhados;

    public Funcionario() {

        super();
        this.salario = 0.0;
        this.cargo = "";
        this.valorDia = 60.0;
        this.diasTrabalhados = 20;
    }

    public double getSalario() {
        return this.diasTrabalhados * this.valorDia;
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
        info += ";SALARIO;CARGO;REGIMETRABALHO";
        return info;
    }

    @Override
    public String getInfoCSV() {
        String info = super.getInfoCSV();
        info += ";" + this.getSalario() + ";" + this.getCargo() + ";" + this.getValorDia();
        return info;
    }

    @Override
    public void setInfoCSV(String linhaCSV) {
        super.setInfoCSV(linhaCSV);
        String[] temp = linhaCSV.split(";");
        String convert = Double.toString(this.getSalario());
        convert = temp[6];
        this.setCargo(temp[7]);
        convert = Double.toString(this.getValorDia());
        convert = temp[8];
    }

}
