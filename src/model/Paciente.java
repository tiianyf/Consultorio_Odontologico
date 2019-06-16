package model;
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
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
        this.procedimento = new Procedimento();
>>>>>>> ba2e02ebf0943bf2920728ff7b7b3d17f909d234
>>>>>>> dfbb2c7fcb907f4177644a069a52652a6e739b82

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

        this.tipoSanguineo = info[5];
        this.problemaCardiaco = info[6];
        this.alergia = info[7];
        this.doencaCronica = info[8];

        String aux = Boolean.toString(this.fumante);
        aux = info[9];
        aux = Boolean.toString(this.alcoolatra);
        aux = info[10];
        aux = Boolean.toString(this.historicoDiabetes);
        aux = info[11];
        aux = Boolean.toString(this.coagulacao);
        aux = info[12];

    }

    @Override
    public String getCabecalhoCSV() {

        String info = super.getCabecalhoCSV();
        info += ";TIPOSANGUINEO;PROBLEMACARDIACO;ALERGIA;DOENCACRONICA;FUMANTE;ALCOOLATRA;DIABETES;COAGULACAO";
        return info;

    }
}
