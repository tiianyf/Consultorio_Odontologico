/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.TMFuncionarios;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Auxiliar;
import model.Faxineira;
import model.Funcionario;
import model.Secretaria;

/**
 *
 * @author ch
 */
public class ListaFuncionarios extends javax.swing.JDialog {

    private TMFuncionarios tmFuncionario;
    private Funcionario aux;

    /**
     * Creates new form ListaFuncionarios
     *
     * @param parent
     * @param modal
     */
    public ListaFuncionarios(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        this.tmFuncionario = new TMFuncionarios();
        this.tblFuncionarios.setModel(tmFuncionario);
        this.carregarArquivo("src/csv/lst_funcionarios.csv");
        this.aux = new Funcionario();
    }

    public TMFuncionarios getTmFuncionario() {
        return tmFuncionario;
    }

    public void setTmFuncionario(TMFuncionarios tmFuncionario) {
        this.tmFuncionario = tmFuncionario;
    }

    public Funcionario getAux() {
        return aux;
    }

    public void setAux(Funcionario aux) {
        this.aux = aux;
    }

    public final void carregarArquivo(String caminho) {

        FileReader arquivo;

        try {

            arquivo = new FileReader(caminho);
            Scanner ler = new Scanner(arquivo);
            ler.useDelimiter("\n");
            ler.next();

            while (ler.hasNext()) {
                String linhaCsv = ler.next();
                String[] info = linhaCsv.split(";");

                Funcionario f = this.confereCargo(info);

                f.setInfoCSV(linhaCsv);
                this.tmFuncionario.addLinha(f);
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(FrCadFuncionario.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "ERRO! Arquivo não foi carregado.");
        }
    }

    public Funcionario confereCargo(String[] info) {

        Funcionario f = null;

        switch (info[7]) {

            case "Secretária":
                f = new Secretaria();
                break;

            case "Auxiliar":
                f = new Auxiliar();
                break;

            case "Faxineira":
                f = new Faxineira();
                break;

            default:
                break;
        }
        return f;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblFuncionarios = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblTitulo.setFont(new java.awt.Font("DejaVu Sans", 1, 18)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("LISTA DE FUNCIONÁRIOS CADASTRADOS NO SISTEMA");

        tblFuncionarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblFuncionarios.setToolTipText("Clique duas vezes no paciente desejado para selecioná-lo!");
        tblFuncionarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tblFuncionariosMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tblFuncionarios);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 976, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tblFuncionariosMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblFuncionariosMouseReleased

        if (evt.getClickCount() == 2) {
            int linha = this.tblFuncionarios.getSelectedRow();
            this.aux = this.confereTipo(linha);
            dispose();
        }
    }//GEN-LAST:event_tblFuncionariosMouseReleased

    public Funcionario confereTipo(int linha) {

        Funcionario f = null;

        if (this.getTmFuncionario().getLstFuncionarios().get(linha) instanceof Secretaria) {

            f = (Secretaria) this.getTmFuncionario().getLstFuncionarios().get(linha);
            System.out.println("a instancia é secretária");

        } else if (this.getTmFuncionario().getLstFuncionarios().get(linha) instanceof Auxiliar) {

            f = (Auxiliar) this.getTmFuncionario().getLstFuncionarios().get(linha);
            System.out.println("a instancia é auxiliar");

        } else if (this.getTmFuncionario().getLstFuncionarios().get(linha) instanceof Faxineira) {

            f = (Faxineira) this.getTmFuncionario().getLstFuncionarios().get(linha);
            System.out.println("a instancia é faxineira");

        }

        return f;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTable tblFuncionarios;
    // End of variables declaration//GEN-END:variables
}
