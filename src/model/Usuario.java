/**
 * Interface em que todos os que têm acesso ao sistema deverão implementar
 * (dentistas e secretária).
 *
 * @author Cláudio Henrique <https://github.com/01ch01>
 * @since Jun 16, 2019 at 3:23:48 PM
 * @version 0.1
 */
package model;

public interface Usuario {

    /**
     * A autenticação servirá para a tela de login e para poder ter acesso ao
     * relatório do dentista em questão.
     *
     * @param usuario
     * @param senha
     * @return true caso o login e a senha estejam corretos
     */
    boolean autenticar(String usuario, String senha);

    boolean alterarUsuario(String usuario, String senha);

    boolean alterarSenha(String usuario, String senha);

    boolean cadastrarProcedimento(String usuario, String senha);

    String acessarRelatorio();

}
