/**
 * Título da classe.
 * Insira aqui uma pequena descrição sobre a mesma.
 *
 * @author Cláudio Henrique <https://github.com/01ch01>
 * @since Jun 16, 2019 at 1:49:21 AM
 * @version 0.1
 */
package model;

public class Caixa {

    private double saldoTotal;
    private double aReceber;
    private Pagamento formaPgto;

    public Caixa() {
        this.saldoTotal = 0.0;
        this.aReceber = 0.0;
        this.formaPgto = Pagamento.AVISTA;
    }

    public Pagamento getFormaPgto() {
        return formaPgto;
    }

    public void setFormaPgto(Pagamento formaPgto) {
        this.formaPgto = formaPgto;
    }

    public double getSaldoTotal() {
        return saldoTotal;
    }

    public void setSaldoTotal(double saldoTotal) {
        this.saldoTotal = saldoTotal;
    }

    public double getaReceber() {
        return aReceber;
    }

    public void setaReceber(double aReceber) {
        this.aReceber = aReceber;
    }

    
}
