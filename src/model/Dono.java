/**
 * Interface cujo somente o dono do consultório pode implementar. Têm o poder de
 * cadastrar todo e qualquer tipo de funcionário
 *
 * @author Cláudio Henrique <https://github.com/01ch01>
 * @since Jun 16, 2019 at 8:14:04 PM
 * @version 0.1
 */
package model;

public interface Dono {

    void cadastrarFuncionario(Funcionario f);

}
