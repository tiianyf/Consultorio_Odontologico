package consultorioodontologico;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JFrame;
import model.DiasSemana;
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

//        JFrame login = new FrCadLogin();
//        login.setVisible(true);
        List<DiasSemana> lista = new ArrayList<>();
        lista.add(DiasSemana.TERCA);
        lista.add(DiasSemana.QUINTA);
        lista.add(DiasSemana.SEGUNDA);
        lista.add(DiasSemana.SEGUNDA);

//        System.out.println(lista);
        List<DiasSemana> novo = new ArrayList<>();

        String linha = lista.toString();
        linha = linha.replace("[", "");
        linha = linha.replace("]", "");

        String[] vetor = linha.split(", ");

        for (String i : vetor) {
            switch (i) {
                case "SEGUNDA":
                    novo.add(DiasSemana.SEGUNDA);
                    break;
                case "TERCA":
                    novo.add(DiasSemana.TERCA);
                    break;
                case "QUARTA":
                    novo.add(DiasSemana.QUARTA);
                    break;
                case "QUINTA":
                    novo.add(DiasSemana.QUINTA);
                    break;
                case "SEXTA":
                    novo.add(DiasSemana.TERCA);
                    break;
                default:
                    break;
            }
        }
        System.out.println(novo);

    }

}
