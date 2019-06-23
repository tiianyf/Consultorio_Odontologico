package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Dentista autônomo, não-proprietário. Recebe 60% do valor total de seus
 * procedimentos realizados, já que não paga subsídios como aluguel.
 *
 * @author cfreitas
 */
public class DColaborador extends Dentista {

    private double taxa;
    private List<DiasSemana> dias;

    public DColaborador() {

        super();
        this.taxa = 0.4;
        this.dias = new ArrayList<>();
    }

    public List<DiasSemana> getDias() {
        return dias;
    }

    public void setDias(List<DiasSemana> dias) {
        this.dias = dias;
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
        info += ";taxa;dias da semana";
        return info;

    }

    @Override
    public String getInfoCSV() {

        String info = super.getInfoCSV();
        info += ";" + this.taxa + ";" + this.dias.toString();
        return info;

    }

    @Override
    public void setInfoCSV(String linhaCSV) {

        super.setInfoCSV(linhaCSV);
        String[] info = linhaCSV.split(";");

        this.taxa = Double.parseDouble(info[9]);

        // manipulação complexa de Strings
        String aux = info[10];
        aux = aux.replace("[", "");
        aux = aux.replace("]", "");
        String[] vetor = aux.split(", ");

        for (String i : vetor) {
            switch (i) {
                case "SEGUNDA":
                    this.dias.add(DiasSemana.SEGUNDA);
                    break;
                case "TERCA":
                    this.dias.add(DiasSemana.TERCA);
                    break;
                case "QUARTA":
                    this.dias.add(DiasSemana.QUARTA);
                    break;
                case "QUINTA":
                    this.dias.add(DiasSemana.QUINTA);
                    break;
                case "SEXTA":
                    this.dias.add(DiasSemana.TERCA);
                    break;
                default:
                    break;
            }
        }

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
