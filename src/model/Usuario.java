/**
 * Título.
 * Insira aqui uma pequena descrição.
 *
 * @author Cláudio Henrique <https://github.com/01ch01>
 * @since Jun 16, 2019 at 3:23:48 PM
 * @version 0.1
 */
package model;

public interface Usuario {

    boolean autenticar(String usuario, String senha);

    String acessarRelatorio();
}
