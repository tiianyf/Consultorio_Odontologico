package model;

public class Paciente extends Pessoa {

    private String tipoSanguineo;
    private String alergia;
    private String doencaCronica;
    private double pagamento;
    private boolean fumante;
    private boolean historicoDiabetes;
    private Dentista dentista;

    public Paciente() {

        super();
        this.tipoSanguineo = "";
        this.alergia = "";
        this.doencaCronica = "";
        this.pagamento = 0.0;
        this.fumante = false;
        this.historicoDiabetes = false;
    }

    public String getDoencaCronica() {
        return doencaCronica;
    }

    public void setDoencaCronica(String doencaCronica) {
        this.doencaCronica = doencaCronica;
    }

    public boolean isHistoricoDiabetes() {
        return historicoDiabetes;
    }

    public void setHistoricoDiabetes(boolean historicoDiabetes) {
        this.historicoDiabetes = historicoDiabetes;
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

    public Dentista getDentista() {
        return dentista;
    }

    public void setDentista(Dentista dentista) {
        this.dentista = dentista;
    }

    public double getPagamento() {
        return pagamento;
    }

    public void setPagamento(double pagamento) {
        this.pagamento = pagamento;
    }

    @Override
    public String getInfoCSV() {

        String info = super.getInfoCSV();

        info += ";" + this.tipoSanguineo + ";" + this.alergia + ";" + this.doencaCronica + ";" + this.fumante
            + ";" + this.historicoDiabetes + "\n";

        return info;
    }

    @Override
    public void setInfoCSV(String linhaCSV) {

        super.setInfoCSV(linhaCSV);
        String info[] = linhaCSV.split(";");

        this.tipoSanguineo = info[6];
        this.alergia = info[7];
        this.doencaCronica = info[8];

        String aux = Boolean.toString(this.fumante);
        aux = info[9];
        String aux2 = Boolean.toString(this.historicoDiabetes);
        aux2 = info[10];
    }
    
    @Override
    public String getCabecalhoCSV() {

        String info = super.getCabecalhoCSV();
        info += ";TIPOSANGUINEO;ALERGIA;DOENCACRONICA;FUMANTE;DIABETES\n";
        return info;

    }
}
