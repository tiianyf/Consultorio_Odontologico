/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.TMDColaboradores;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.DColaborador;
import model.Paciente;

/**
 *
 * @author ch
 */
public class ListaDColaboradores extends javax.swing.JDialog {

    private int indiceSelecionado;
    private DColaborador dentistaSelecionado;
    private TMDColaboradores tmDentistas;
    
    /**
     * Creates new form ListaDColaboradores
     * @param parent
     * @param modal
     */
    public ListaDColaboradores(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        this.indiceSelecionado = -1;
        this.dentistaSelecionado = new DColaborador();
        this.tmDentistas = new TMDColaboradores();
        this.tblDentistas.setModel(tmDentistas);
        this.carregarArquivo("src/csv/lst_dcolaboradores.csv");
    }

    public TMDColaboradores getTmDentistas() {
        return tmDentistas;
    }

    public void setTmDentistas(TMDColaboradores tmDentistas) {
        this.tmDentistas = tmDentistas;
    }

    public int getIndiceSelecionado() {
        return indiceSelecionado;
    }

    public void setIndiceSelecionado(int indiceSelecionado) {
        this.indiceSelecionado = indiceSelecionado;
    }

    public DColaborador getDentistaSelecionado() {
        return dentistaSelecionado;
    }

    public void setDentistaSelecionado(DColaborador dentistaSelecionado) {
        this.dentistaSelecionado = dentistaSelecionado;
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
                DColaborador d = new DColaborador();
                d.setInfoCSV(linhaCsv);
                this.getTmDentistas().addLinha(d);

            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(FrCadPaciente.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "ERRO! Arquivo não foi carregado.");
        }
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDentistas = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblTitulo.setFont(new java.awt.Font("DejaVu Sans", 1, 18)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("LISTA DE DENTISTAS CADASTRADOS NO SISTEMA");

        tblDentistas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblDentistas.setToolTipText("Clique duas vezes no paciente desejado para selecioná-lo!");
        tblDentistas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tblDentistasMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tblDentistas);

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
    }// </editor-fold>//GEN-END:initComponents

    private void tblDentistasMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDentistasMouseReleased

        if (evt.getClickCount() == 2) {
            this.indiceSelecionado = this.tblDentistas.getSelectedRow();
            this.dentistaSelecionado = this.getTmDentistas().getLstDColaboradores().get(this.indiceSelecionado);
            dispose();
        }
    }//GEN-LAST:event_tblDentistasMouseReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTable tblDentistas;
    // End of variables declaration//GEN-END:variables
}