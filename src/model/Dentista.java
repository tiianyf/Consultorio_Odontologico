package model;

/**
 * Classe abstrata de dentistas, para poder diferenciar o proprietário dos
 * demais dentistas, que pagarão uma taxa sob seu 'salário'. Têm acesso ao
 * relatórios contendo os procedimentos por meio de login no sistema.
 *
 * @author cfreitas
 */
abstract public class Dentista extends Funcionario implements Usuario {

    protected String cro;
    protected String usuario;
    protected String senha;

    public Dentista() {

        super();
        this.cro = "";

    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCro() {
        return cro;
    }

    public void setCro(String cro) {
        this.cro = cro;
    }

    @Override
    public String getCabecalhoCSV() {

        String info = super.getCabecalhoCSV();
        info += ";CRO";
        return info;

    }

    @Override
    public String getInfoCSV() {

        String info = super.getInfoCSV();
        info += ";" + this.cro;
        return info;

    }

    @Override
    public void setInfoCSV(String linhaCSV) {

        super.setInfoCSV(linhaCSV);
        String[] temp = linhaCSV.split(";");

        this.cro = temp[8];

    }

}
