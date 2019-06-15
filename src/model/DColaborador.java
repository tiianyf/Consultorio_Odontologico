package model;

/**
 *
 * @author cfreitas
 */
public class DColaborador extends Dentista {

    protected final double taxa;

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

}
