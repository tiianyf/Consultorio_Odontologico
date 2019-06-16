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
<<<<<<< HEAD
=======
        this.coagulacao = false;
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
        this.procedimento = new Procedimento();
>>>>>>> ba2e02ebf0943bf2920728ff7b7b3d17f909d234
>>>>>>> dfbb2c7fcb907f4177644a069a52652a6e739b82
>>>>>>> 8c969d7dd847b40823fdd4ccb012d74fe0a18a5e

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

<<<<<<< HEAD
        this.tipoSanguineo = info[6];
        this.alergia = info[8];
        this.doencaCronica = info[9];
=======
        this.tipoSanguineo = info[5];
        this.problemaCardiaco = info[6];
        this.alergia = info[7];
        this.doencaCronica = info[8];
>>>>>>> 8c969d7dd847b40823fdd4ccb012d74fe0a18a5e

        String aux = Boolean.toString(this.fumante);
        aux = info[9];
        aux = Boolean.toString(this.alcoolatra);
        aux = info[10];
<<<<<<< HEAD
        String aux3 = Boolean.toString(this.historicoDiabetes);
        aux3 = info[11];
=======
        aux = Boolean.toString(this.historicoDiabetes);
        aux = info[11];
        aux = Boolean.toString(this.coagulacao);
        aux = info[12];

>>>>>>> 8c969d7dd847b40823fdd4ccb012d74fe0a18a5e
    }

    @Override
    public String getCabecalhoCSV() {

        String info = super.getCabecalhoCSV();
        info += ";TIPOSANGUINEO;ALERGIA;DOENCACRONICA;FUMANTE;DIABETES\n";
        return info;

    }
}
