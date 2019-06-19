/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.TMDProprietario;
import controller.TMPacientes;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Paciente;

/**
 *
 * @author cfreitas
 */
public class FrAgenda extends javax.swing.JFrame {

    private final TMPacientes tmPaciente;

    /**
     * Creates new form FrAgenda
     */
    public FrAgenda() {
        initComponents();
        this.tmPaciente = new TMPacientes();
        this.tblAgenda.setModel(tmPaciente);
        this.carregarArquivo("src/csv/lst_pacientes.csv");
    }

    public void mostrarTabela() {
        for (Paciente p : this.tmPaciente.getLstPacientes()) {
            this.tmPaciente.addLinha(p);
        }
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
                Paciente p = new Paciente();
                p.setInfoCSV(linhaCsv);
                this.tmPaciente.addLinha(p);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FrAgenda.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "ERRO! Arquivo não foi carregado.");
        }
    }

    public int buscar(String termo) {
        for (int i = 0; i < this.tmPaciente.getRowCount(); i++) {
            if (termo.equals(this.tmPaciente.getLstPacientes().get(i).getCpf())) {
                return i;
            }
        }
        JOptionPane.showMessageDialog(null, "Funcionário não cadastrado!");
        return -1;
    }

    public void copiarObjetoParaCampos(Paciente p) {
        this.edtNome.setText(p.getNome());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDayChooser1 = new com.toedter.calendar.JDayChooser();
        lblTitulo = new javax.swing.JLabel();
        painel1 = new javax.swing.JPanel();
        lblPaciente = new javax.swing.JLabel();
        lblHorario = new javax.swing.JLabel();
        edtNome = new javax.swing.JTextField();
        edtHorario = new javax.swing.JTextField();
        lblDentista = new javax.swing.JLabel();
        lblCpf2 = new javax.swing.JLabel();
        jData = new com.toedter.calendar.JDateChooser();
        lblData1 = new javax.swing.JLabel();
        edtCpf1 = new javax.swing.JTextField();
        btnBuscarDentista = new javax.swing.JButton();
        btnBuscarPaciente = new javax.swing.JButton();
        btnNovo = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        brnExcluir = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAgenda = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Agendamento");

        lblTitulo.setFont(new java.awt.Font("DejaVu Sans", 1, 18)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("AGENDAMENTO");
        lblTitulo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        painel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        painel1.setLayout(null);

        lblPaciente.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        lblPaciente.setText("Paciente");
        painel1.add(lblPaciente);
        lblPaciente.setBounds(17, 24, 61, 17);

        lblHorario.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        lblHorario.setText("Horário");
        painel1.add(lblHorario);
        lblHorario.setBounds(300, 80, 70, 17);
        painel1.add(edtNome);
        edtNome.setBounds(90, 20, 480, 19);
        painel1.add(edtHorario);
        edtHorario.setBounds(370, 80, 200, 19);

        lblDentista.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        lblDentista.setText("Dentista");
        painel1.add(lblDentista);
        lblDentista.setBounds(17, 49, 59, 17);

        lblCpf2.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        lblCpf2.setText("Dentista");
        painel1.add(lblCpf2);
        lblCpf2.setBounds(17, 49, 59, 17);
        painel1.add(jData);
        jData.setBounds(90, 80, 180, 19);

        lblData1.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        lblData1.setText("Data ");
        painel1.add(lblData1);
        lblData1.setBounds(20, 80, 38, 17);
        painel1.add(edtCpf1);
        edtCpf1.setBounds(90, 50, 480, 19);

        btnBuscarDentista.setText("Buscar");
        btnBuscarDentista.setContentAreaFilled(false);
        btnBuscarDentista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarDentistaActionPerformed(evt);
            }
        });
        painel1.add(btnBuscarDentista);
        btnBuscarDentista.setBounds(580, 50, 90, 20);

        btnBuscarPaciente.setText("Buscar");
        btnBuscarPaciente.setContentAreaFilled(false);
        btnBuscarPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarPacienteActionPerformed(evt);
            }
        });
        painel1.add(btnBuscarPaciente);
        btnBuscarPaciente.setBounds(580, 20, 90, 20);

        btnNovo.setFont(new java.awt.Font("DejaVu Sans", 0, 12)); // NOI18N
        btnNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/user.png"))); // NOI18N
        btnNovo.setText("Novo");
        btnNovo.setAutoscrolls(true);
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("DejaVu Sans", 0, 12)); // NOI18N
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/cancel.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnSalvar.setFont(new java.awt.Font("DejaVu Sans", 0, 12)); // NOI18N
        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/btnSave.png"))); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        brnExcluir.setFont(new java.awt.Font("DejaVu Sans", 0, 12)); // NOI18N
        brnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/delete.png"))); // NOI18N
        brnExcluir.setText("Excluir");
        brnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                brnExcluirActionPerformed(evt);
            }
        });

        btnEditar.setFont(new java.awt.Font("DejaVu Sans", 0, 12)); // NOI18N
        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/btnEdit.png"))); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        tblAgenda.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tblAgenda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblAgenda);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCancelar)
                        .addGap(18, 18, 18)
                        .addComponent(brnExcluir)
                        .addGap(18, 18, 18)
                        .addComponent(btnSalvar))
                    .addComponent(painel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 689, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(painel1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNovo)
                    .addComponent(btnEditar)
                    .addComponent(btnCancelar)
                    .addComponent(brnExcluir)
                    .addComponent(btnSalvar))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(723, 442));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed

    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed

    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed

    }//GEN-LAST:event_btnSalvarActionPerformed

    private void brnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_brnExcluirActionPerformed

    }//GEN-LAST:event_brnExcluirActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed

    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnBuscarDentistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarDentistaActionPerformed

    }//GEN-LAST:event_btnBuscarDentistaActionPerformed

    private void btnBuscarPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarPacienteActionPerformed
        String temo = JOptionPane.showInputDialog("Insira o CPF do Paciente");
        Paciente p = new Paciente();
        p = this.tmPaciente.getLstPacientes().get(this.buscar(temo));
        this.copiarObjetoParaCampos(p);
    }//GEN-LAST:event_btnBuscarPacienteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton brnExcluir;
    private javax.swing.JButton btnBuscarDentista;
    private javax.swing.JButton btnBuscarPaciente;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JTextField edtCpf1;
    private javax.swing.JTextField edtHorario;
    private javax.swing.JTextField edtNome;
    private com.toedter.calendar.JDateChooser jData;
    private com.toedter.calendar.JDayChooser jDayChooser1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCpf2;
    private javax.swing.JLabel lblData1;
    private javax.swing.JLabel lblDentista;
    private javax.swing.JLabel lblHorario;
    private javax.swing.JLabel lblPaciente;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel painel1;
    private javax.swing.JTable tblAgenda;
    // End of variables declaration//GEN-END:variables
}
