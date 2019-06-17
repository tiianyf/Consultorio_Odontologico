/**
 * Controlador (Table Model) da Classe Material. Esta é uma tabela de requisição
 * (pedido), onde estão
 * Uma tabela de 17 linhas (17 tipos de materiais) e 4 colunas (ID, Nome, Preço
 * e Quantidade).
 * Os atributos @lstNomes e @lstPrecos foram criados pois tanto um como o outro
 * são "tabelados" (fixos). Caso mais algum material precise ser adicionado à
 * tabela, basta adicionar o nome no atributo @lstNomes e o preço em @lstPrecos.
 * O ID é adicionado automaticamente, não sendo necessário alteração.
 *
 * @author Cláudio Henrique <https://github.com/01ch01>
 * @since Jun 15, 2019 at 4:19:23 PM
 * @version 0.1
 */
package controller;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Material;

public class TMMateriais extends AbstractTableModel {

    private final String[] lstNomes;
    private final double[] lstPrecos;
    private final List<Material> lstMateriais;
    private final List<String> lstColunas;

    public TMMateriais() {
        this.lstNomes = new String[]{
            "Alginato", "Cera em lâmina", "Gesso", "Guardanapo", "Luva",
            "Máscara", "Sulgador", "Cimento ionômero de vidro",
            "Cápsula de amálgama", "Resina", "Disco de lixa", "Tira de lixa",
            "Água destilada para autoclave", "Algodão", "Carbono",
            "Fio cirúrgico", "Agulha para anestesia"
        };

        this.lstPrecos = new double[]{
            20.70, 16.03, 14.55, 1.93, 18.99, 7.50, 4.81, 28.07, 169.00, 39.00,
            35.00, 14.55, 10.56, 17.99, 3.10, 39.00, 57.90
        };

        this.lstColunas = new ArrayList<>();
        this.lstMateriais = new ArrayList<>();

        this.lstColunas.add("ID");
        this.lstColunas.add("Nome");
        this.lstColunas.add("Preço");
        this.lstColunas.add("Qtd");
        this.lstColunas.add("Preço Total");

        for (int i = 0; i < this.lstNomes.length; i++) {
            //id;nome;preco;qtd;precoTotal
            Material m = new Material(i + 1, this.lstNomes[i], this.lstPrecos[i], 0, 0.0);
            this.lstMateriais.add(m);
        }
    }

    @Override
    public int getRowCount() {
        return this.lstMateriais.size();
    }

    @Override
    public int getColumnCount() {
        return this.lstColunas.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (columnIndex == this.lstColunas.indexOf("ID")) {
            return this.lstMateriais.get(rowIndex).getId();

        } else if (columnIndex == this.lstColunas.indexOf("Nome")) {
            return this.lstMateriais.get(rowIndex).getNome();

        } else if (columnIndex == this.lstColunas.indexOf("Preço")) {
            return this.lstMateriais.get(rowIndex).getPreco();

        } else if (columnIndex == this.lstColunas.indexOf("Qtd")) {
            return this.lstMateriais.get(rowIndex).getQtd();

        } else if (columnIndex == this.lstColunas.indexOf("Preço Total")) {
            return this.lstMateriais.get(rowIndex).getPrecoTotal();

        } else {
            System.out.println("Objeto não encontrado");
            return null;
        }

    }

}
