/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.TMAgenda;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Agenda;
import model.DColaborador;
import model.Paciente;

/**
 *
 * @author cfreitas
 */
public final class FrAgenda extends javax.swing.JFrame {
    
    private final TMAgenda tmAgendamentos;
    private Paciente paciente = new Paciente();
    private DColaborador dentista;
    private int indiceSelecionado;
    private final Agenda a;

    /**
     * Creates new form FrAgenda
     */
    public FrAgenda() {
        initComponents();
        this.tmAgendamentos = new TMAgenda();
        this.paciente = new Paciente();
        this.dentista = new DColaborador();
        this.indiceSelecionado = -1;
        this.habilitarCampos(false);
        this.tblAgenda.setModel(tmAgendamentos);
        this.carregarArquivo("src/csv/lst_agendamentos.csv");
        this.tmAgendamentos.fireTableDataChanged();
        this.a = new Agenda();
        
        this.btnNovo.requestFocus();
        
    }
    
    
    public int getIndiceSelecionado() {
        return indiceSelecionado;
    }
    
    public void setIndiceSelecionado(int indiceSelecionado) {
        this.indiceSelecionado = indiceSelecionado;
    }
    
    public void habilitarCampos(boolean flag) {
        
        this.edtPaciente.setEnabled(flag);
        this.edtDentista.setEnabled(flag);
        this.edtData.setEnabled(flag);
        this.edtHorario.setEnabled(flag);
        this.btnBuscarPaciente.setEnabled(flag);
        this.btnBuscarDentista.setEnabled(flag);
        
        if (!flag) {
            this.limparTodosCampos();
        }
    }
    
    public void limparTodosCampos() {
        
        this.edtPaciente.setText(null);
        this.edtDentista.setText(null);
        this.edtData.setText(null);
        this.edtHorario.setText(null);
        
    }
    
    public void copiarCamposParaObjeto(Agenda a) {
        
        a.setPaciente(this.paciente);
        a.setDentista(this.dentista);
        a.setData(this.edtData.getText());
        a.setHorario(this.edtHorario.getText());
        
    }
    
    public void copiarObjetoParaCampos(Agenda a) {
        
        this.edtPaciente.setText(this.paciente.getNome());
        this.edtDentista.setText(this.dentista.getNome());
        this.edtData.setText(a.getData());
        this.edtHorario.setText(a.getHorario());
        
    }
    
    public void carregarArquivo(String caminho) {
        
        FileReader arquivo;
        try {
            arquivo = new FileReader(caminho);
            Scanner ler = new Scanner(arquivo);
            ler.useDelimiter("\n");
//            ler.next();
            
            while (ler.hasNext()) {
                String linhaCsv = ler.next();
                Agenda a = new Agenda();
                a.setInfoCSV(linhaCsv);
                this.tmAgendamentos.addLinha(a);
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FrAgenda.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void salvarArquivo(String caminho) {
        
        try {
            FileWriter arquivo = new FileWriter(caminho);
            
            try (PrintWriter escrita = new PrintWriter(arquivo)) {
                Agenda aux = new Agenda();
                String info = aux.getCabecalhoCSV();
                
                for (Agenda a : this.tmAgendamentos.getLstAgendamentos()) {
                    info += a.getInfoCSV();
                }
                escrita.print(info);
            } catch (Exception e) {
            }
        } catch (IOException ex) {
            Logger.getLogger(FrAgenda.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void salvar() {
        
        Agenda a = new Agenda();
        this.copiarCamposParaObjeto(a);
        this.tmAgendamentos.addLinha(a);
        
        this.salvarArquivo("src/csv/lst_agendamentos.csv");
        this.tmAgendamentos.fireTableDataChanged();
        this.habilitarCampos(false);
        
    }
    
    public void mostrarTabela() {
        
        for (Agenda a : this.tmAgendamentos.getLstAgendamentos()) {
            this.tmAgendamentos.addLinha(a);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        painel1 = new javax.swing.JPanel();
        lblPaciente = new javax.swing.JLabel();
        lblHorario = new javax.swing.JLabel();
        edtPaciente = new javax.swing.JTextField();
        edtHorario = new javax.swing.JTextField();
        lblData1 = new javax.swing.JLabel();
        btnBuscarPaciente = new javax.swing.JButton();
        edtData = new javax.swing.JTextField();
        lblDentista = new javax.swing.JLabel();
        edtDentista = new javax.swing.JTextField();
        btnBuscarDentista = new javax.swing.JButton();
        btnNovo = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        brnExcluir = new javax.swing.JButton();
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
        lblPaciente.setBounds(20, 20, 61, 17);

        lblHorario.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        lblHorario.setText("Horário");
        painel1.add(lblHorario);
        lblHorario.setBounds(270, 100, 70, 17);
        painel1.add(edtPaciente);
        edtPaciente.setBounds(90, 20, 480, 19);

        edtHorario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                edtHorarioKeyReleased(evt);
            }
        });
        painel1.add(edtHorario);
        edtHorario.setBounds(350, 100, 200, 19);

        lblData1.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        lblData1.setText("Data ");
        painel1.add(lblData1);
        lblData1.setBounds(20, 100, 38, 17);

        btnBuscarPaciente.setText("Buscar");
        btnBuscarPaciente.setContentAreaFilled(false);
        btnBuscarPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarPacienteActionPerformed(evt);
            }
        });
        painel1.add(btnBuscarPaciente);
        btnBuscarPaciente.setBounds(580, 20, 90, 20);

        edtData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtDataActionPerformed(evt);
            }
        });
        edtData.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                edtDataKeyReleased(evt);
            }
        });
        painel1.add(edtData);
        edtData.setBounds(90, 100, 130, 19);

        lblDentista.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        lblDentista.setText("Dentista");
        painel1.add(lblDentista);
        lblDentista.setBounds(20, 60, 59, 17);
        painel1.add(edtDentista);
        edtDentista.setBounds(90, 60, 480, 19);

        btnBuscarDentista.setText("Buscar");
        btnBuscarDentista.setContentAreaFilled(false);
        btnBuscarDentista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarDentistaActionPerformed(evt);
            }
        });
        painel1.add(btnBuscarDentista);
        btnBuscarDentista.setBounds(580, 60, 90, 20);

        btnNovo.setFont(new java.awt.Font("DejaVu Sans", 0, 12)); // NOI18N
        btnNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/new.png"))); // NOI18N
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
        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/save.png"))); // NOI18N
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(painel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 689, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancelar)
                        .addGap(18, 18, 18)
                        .addComponent(brnExcluir)
                        .addGap(18, 18, 18)
                        .addComponent(btnSalvar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(painel1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNovo)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(brnExcluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(22, 22, 22))
        );

        setSize(new java.awt.Dimension(723, 442));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed

        this.habilitarCampos(true);
        this.btnBuscarPaciente.requestFocus();
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.habilitarCampos(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
 
        int confirm = JOptionPane.showConfirmDialog(null, "Deseja realmente salvar?");
        
        if(confirm == JOptionPane.YES_OPTION){
            this.salvar();
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void brnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_brnExcluirActionPerformed

        int confirm = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir?");
        
        if(confirm == JOptionPane.YES_OPTION){
            ListaAgendamentos lista = new ListaAgendamentos(this,true);
            lista.setVisible(true);
            int i = lista.getIndiceSelecionado();
            
            this.tmAgendamentos.getLstAgendamentos().remove(i);
            this.salvarArquivo("src/csv/lst_agendamentos.csv");
            JOptionPane.showMessageDialog(this, "Agendamento excluído!");
            this.tmAgendamentos.fireTableDataChanged();
            
        }
        else{
            
            this.btnCancelarActionPerformed(evt);
    }
        
    }//GEN-LAST:event_brnExcluirActionPerformed

    private void btnBuscarPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarPacienteActionPerformed

        ListaPacientes lista = new ListaPacientes(this,true);
        lista.setVisible(true);
        this.paciente = lista.getPacienteSelecionado();
        
        this.copiarObjetoParaCampos(this.a);
        this.btnBuscarDentista.requestFocus();
    }//GEN-LAST:event_btnBuscarPacienteActionPerformed

    private void btnBuscarDentistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarDentistaActionPerformed
        ListaDColaboradores lista = new ListaDColaboradores(this,true);
        lista.setVisible(true);
        this.dentista = lista.getDentistaSelecionado();
        
        this.copiarObjetoParaCampos(a);
        this.edtData.requestFocus();
    }//GEN-LAST:event_btnBuscarDentistaActionPerformed

    private void edtDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtDataActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edtDataActionPerformed

    private void edtDataKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_edtDataKeyReleased
        if (evt.getKeyChar() == java.awt.event.KeyEvent.VK_ENTER) {
            this.edtHorario.requestFocus();
        }
    }//GEN-LAST:event_edtDataKeyReleased

    private void edtHorarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_edtHorarioKeyReleased
         if (evt.getKeyChar() == java.awt.event.KeyEvent.VK_ENTER) {
            this.btnSalvar.requestFocus();
        }
    }//GEN-LAST:event_edtHorarioKeyReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton brnExcluir;
    private javax.swing.JButton btnBuscarDentista;
    private javax.swing.JButton btnBuscarPaciente;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JTextField edtData;
    private javax.swing.JTextField edtDentista;
    private javax.swing.JTextField edtHorario;
    private javax.swing.JTextField edtPaciente;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblData1;
    private javax.swing.JLabel lblDentista;
    private javax.swing.JLabel lblHorario;
    private javax.swing.JLabel lblPaciente;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel painel1;
    private javax.swing.JTable tblAgenda;
    // End of variables declaration//GEN-END:variables
}
