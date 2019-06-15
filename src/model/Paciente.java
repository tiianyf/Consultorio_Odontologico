package model;

/**
 *
 * @author cfreitas
 */
public class Paciente extends Pessoa {

    private String tipoSanguineo;
    private String problemaCardiaco;
    private String alergia;
    private String doencaCronica;
    private double pagamento;
    private boolean fumante;
    private boolean alcoolatra;
    private boolean historicoDiabetes;
    private boolean coagulacao;
    private Dentista dentista;
    private Procedimento procedimento;

    public Paciente() {

        super();
        this.tipoSanguineo = "";
        this.problemaCardiaco = "";
        this.alergia = "";
        this.doencaCronica = "";
        this.pagamento = 0.0;
        this.fumante = false;
        this.alcoolatra = false;
        this.historicoDiabetes = false;
        this.coagulacao = false;
        this.dentista = new Dentista();
        this.procedimento = new Procedimento();

    }

    public String getProblemaCardiaco() {
        return problemaCardiaco;
    }

    public void setProblemaCardiaco(String problemaCardiaco) {
        this.problemaCardiaco = problemaCardiaco;
    }

    public boolean isAlcoolatra() {
        return alcoolatra;
    }

    public void setAlcoolatra(boolean alcoolatra) {
        this.alcoolatra = alcoolatra;
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

    public boolean isCoagulacao() {
        return coagulacao;
    }

    public void setCoagulacao(boolean coagulacao) {
        this.coagulacao = coagulacao;
    }

    public Procedimento getProcedimento() {
        return procedimento;
    }

    public void setProcedimento(Procedimento procedimento) {
        this.procedimento = procedimento;
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

        info += ";" + this.tipoSanguineo + ";" + this.problemaCardiaco + ";"
            + this.alergia + ";" + this.doencaCronica + ";" + this.fumante
            + ";" + this.alcoolatra + ";" + this.historicoDiabetes + ";"
            + this.coagulacao;

        return info;
    }

    @Override
    public void setInfoCSV(String linhaCSV) {

        super.setInfoCSV(linhaCSV);
        String info[] = linhaCSV.split(";");

        this.tipoSanguineo = info[6];
        this.problemaCardiaco = info[7];
        this.alergia = info[8];
        this.doencaCronica = info[9];

        String aux = Boolean.toString(this.fumante);
        aux = info[10];
        String aux2 = Boolean.toString(this.alcoolatra);
        aux2 = info[11];
        String aux3 = Boolean.toString(this.historicoDiabetes);
        aux3 = info[12];
        String aux4 = Boolean.toString(this.coagulacao);

    }

    @Override
    public String getCabecalhoCSV() {

        String info = super.getCabecalhoCSV();
        info += ";TIPOSANGUINEO;PROBLEMACARDIACO;ALERGIA;DOENCACRONICA;FUMANTE;ALCOOLATRA;DIABETES;COAGULACAO";
        return info;

    }
}
