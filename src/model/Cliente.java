package model;

/**
 *
 * @author cfreitas
 */
public class Cliente extends Pessoa{
    
    private String tipoSanguineo;
    private String doenca;
    private String alergia;
    private boolean fumante;
    private Dentista dentista;
    private double pagamento;
    

    public Cliente() {
    
        super();
        this.tipoSanguineo = "";
        this.doenca = "";
        this.alergia = "";
        this.fumante = false;
        this.dentista = new Dentista();
        this.pagamento = 0.0;
        
    }

    public String getTipoSanguineo() {
        return tipoSanguineo;
    }

    public void setTipoSanguineo(String tipoSanguineo) {
        this.tipoSanguineo = tipoSanguineo;
    }

    public String getDoenca() {
        return doenca;
    }

    public void setDoenca(String doenca) {
        this.doenca = doenca;
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
        info += ";" + this.tipoSanguineo + ";" + this.doenca + ";" +
                this.alergia + ";" + this.fumante + ";";
        return info;
    }

    @Override
    public void setCSVInfo(String linhaCSV) {
        super.setCSVInfo(linhaCSV); 
        String temp[] = linhaCSV.split(";");
        this.tipoSanguineo = temp[6];
        this.doenca = temp[7];
        this.alergia = temp[8];
        String aux = Boolean.toString(fumante);
        aux = temp[9];
    }

    @Override
    public String getCabecalhoCSV() {
        String info  = super.getCabecalhoCSV();
        info += ";TIPOSANGUINEO;DOENCA;ALERGIA;FUMANTE";
        return info;
    }
}
