package consultorioodontologico;

import javax.swing.JFrame;
import model.Procedimento;
import view.*;

/**
 * Sistema para um consultório odontológico com cadastro de funcionários,
 * dentistas, procedimentos, controle de caixa e controle de marcação de
 * procedimento. Roteiro obrigatório da disciplina de Orientação a Objetos do 3º
 * Período.
 *
 * @author cfreitas <https://github.com/tiianyf> e Cláudio Henrique
 * <https://github.com/01ch01>
 */
public class ConsultorioOdontologico {

    public static void main(String[] args) {

        JFrame login = new FrCadLogin();
        login.setVisible(true);
//        Procedimento p = Procedimento.CLAREAMENTO;
//        System.out.println(p.getCabecalhoCSV());

    }
}
