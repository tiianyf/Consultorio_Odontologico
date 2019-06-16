/**
 * Título da classe.
 * Insira aqui uma pequena descrição sobre a mesma.
 *
 * @author Cláudio Henrique <https://github.com/01ch01>
 * @since Jun 15, 2019 at 2:00:32 PM
 * @version 0.1
 */
package model;

public class Material {

    private int id;
    private String nome;
    private double preco;
    private int qtd;
    private double precoTotal;

    public Material() {
        this.nome = "";
        this.preco = 0.0;
        this.id = -1;

    }

    public Material(int id, String nome, double preco, int qtd, double precoTotal) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.qtd = qtd;
        this.precoTotal = precoTotal;
    }

    public double getPrecoTotal() {
        return this.preco * this.qtd;
    }

    public void setPrecoTotal(double precoTotal) {
        this.precoTotal = precoTotal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

}
