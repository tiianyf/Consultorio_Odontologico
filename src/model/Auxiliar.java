package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cfreitas
 */
public class Auxiliar extends Funcionario {

    private List<Material> lstMateriais;

    public Auxiliar() {

        super();
        this.valorDia = 62.6355;
        this.lstMateriais = new ArrayList<>();
        this.cargo = "Auxiliar";

    }

    public List<Material> getLstMateriais() {
        return lstMateriais;
    }

    public void setLstMateriais(List<Material> lstMateriais) {
        this.lstMateriais = lstMateriais;
    }

    public double enviarRequisicao() {

        double valorTotal = 0.0;
        for (Material m : this.lstMateriais) {
            valorTotal += (m.getPreco() * m.getQtd());
        }
        return valorTotal;

    }

}
