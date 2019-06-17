package model;

/**
 * Dentista autônomo, não-proprietário. Recebe 60% do valor total de seus
 * procedimentos realizados, já que não paga subsídios como aluguel.
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

    @Override
    public boolean autenticar(String usuario, String senha) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String acessarRelatorio() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean alterarUsuario(String usuario, String senha) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean alterarSenha(String usuario, String senha) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean cadastrarProcedimento(String usuario, String senha) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
