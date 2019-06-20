package model;

public class Paciente extends Pessoa {

    private String tipoSanguineo;
    private String alergia;
    private String doenca;
    private boolean fumante;
    private boolean diabetico;

    public Paciente() {

        super();
        this.tipoSanguineo = "";
        this.alergia = "";
        this.doenca = "";
        this.fumante = false;
        this.diabetico = false;
    }

    public String getDoenca() {
        return doenca;
    }

    public void setDoenca(String doenca) {
        this.doenca = doenca;
    }

    public boolean isDiabetico() {
        return diabetico;
    }

    public void setDiabetico(boolean diabetico) {
        this.diabetico = diabetico;
    }

    public String getTipoSanguineo() {
        return tipoSanguineo;
    }

    public void setTipoSanguineo(String tipoSanguineo) {
        this.tipoSanguineo = tipoSanguineo;
    }

    public String getAlergia() {
        return alergia;
    }

    public void setAlergia(String alergia) {
        this.alergia = alergia;
    }

    public boolean isFumante() {
        return fumante;
    }

    public void setFumante(boolean fumante) {
        this.fumante = fumante;
    }

    @Override
    public String getInfoCSV() {

        String info = super.getInfoCSV();

        info += ";" + this.tipoSanguineo + ";" + this.alergia + ";" + this.doenca + ";" + this.fumante
                + ";" + this.diabetico;

        return info;
    }

    @Override
    public void setInfoCSV(String linhaCSV) {

        super.setInfoCSV(linhaCSV);
        String info[] = linhaCSV.split(";");

        this.tipoSanguineo = info[6];
        this.alergia = info[7];
        this.doenca = info[8];

        String aux = Boolean.toString(this.fumante);
        aux = info[9];
        aux = Boolean.toString(this.diabetico);
        aux = info[10];
    }

    @Override
    public String getCabecalhoCSV() {

        String info = super.getCabecalhoCSV();
        info += ";TIPOSANGUINEO;ALERGIA;DOENCACRONICA;FUMANTE;DIABETES";
        return info;

    }
}
