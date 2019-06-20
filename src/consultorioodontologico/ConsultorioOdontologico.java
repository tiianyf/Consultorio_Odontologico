package consultorioodontologico;

import javax.swing.JFrame;
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
        FrCadLogin login = new FrCadLogin();
        login.setVisible(true);
//        JFrame view = new FrCadProcedimento();
//        view.setVisible(true);
//        JFrame view = new FrCadPaciente();
//        view.setVisible(true);
//        FrListaPacientes view = new FrListaPacientes();
//        view.setVisible(true);

    }

}
