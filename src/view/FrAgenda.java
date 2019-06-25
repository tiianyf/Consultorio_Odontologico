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
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
        this.edtCpf.setEnabled(flag);
        this.edtDentista.setEnabled(flag);
        this.escolherData.setEnabled(flag);
        this.boxHorarios.setEnabled(flag);
        this.btnBuscarPaciente.setEnabled(flag);
        this.btnBuscarDentista.setEnabled(flag);
        this.escolherData.setEnabled(flag);
        this.boxProcedimentos.setEnabled(flag);
        this.boxHorarios.setEnabled(flag);

        if (!flag) {
            this.limparTodosCampos();
        }
    }

    public void limparTodosCampos() {

        this.edtPaciente.setText(null);
        this.edtCpf.setText(null);
        this.edtDentista.setText(null);
        this.escolherData.cleanup();

    }

    public void copiarCamposParaObjeto(Agenda a) {

        a.setPaciente(this.paciente);
        a.setDentista(this.dentista);

        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        a.setData(df.format(this.escolherData.getDate()));

        if (this.boxHorarios.getSelectedItem().equals("30 min")) {
            a.setHorario("30");

        } else if (this.boxHorarios.getSelectedItem().equals("1h")) {
            a.setHorario("60");

        } else if (this.boxHorarios.getSelectedItem().equals("1h30min")) {
            a.setHorario("90");

        } else if (this.boxHorarios.getSelectedItem().equals("2h")) {
            a.setHorario("120");
        }
        a.setId(this.edtId.getText());

    }

    public void copiarObjetoParaCampos(Agenda a) {

        this.edtPaciente.setText(this.paciente.getNome());
        this.edtCpf.setText(this.paciente.getCpf());
        this.edtDentista.setText(this.dentista.getNome());
        this.escolherData.setDate(Date.valueOf(a.getData()));

        switch (a.getHorario()) {
            case "30":
                this.boxHorarios.setSelectedItem("30 min");
                break;
            case "60":
                this.boxHorarios.setSelectedItem("1h");
                break;
            case "90":
                this.boxHorarios.setSelectedItem("1h30min");
                break;
            case "120":
                this.boxHorarios.setSelectedItem("2h");
                break;
            default:
                break;
        }
        
        this.edtId.setText(a.getId());

    }

    public void carregarArquivo(String caminho) {

        FileReader arquivo;
        try {
            arquivo = new FileReader(caminho);
            Scanner ler = new Scanner(arquivo);
            ler.useDelimiter("\n");
            ler.next();

            while (ler.hasNext()) {
                String linhaCsv = ler.next();
                Agenda ag = new Agenda();
                ag.setInfoCSV(linhaCsv);
                this.tmAgendamentos.addLinha(ag);
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

                for (Agenda ag : this.tmAgendamentos.getLstAgendamentos()) {
                    info += ag.getInfoCSV();
                }
                escrita.print(info);

            } catch (Exception e) {

                System.out.println("ERRO: " + e.getMessage());
            }
        } catch (IOException ex) {
            Logger.getLogger(FrAgenda.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void salvar() {

        Agenda aux = new Agenda();
        this.copiarCamposParaObjeto(aux);
        this.tmAgendamentos.addLinha(aux);

        this.salvarArquivo("src/csv/lst_agendamentos.csv");
        this.tmAgendamentos.fireTableDataChanged();
        this.habilitarCampos(false);

    }

    public void mostrarTabela() {

        for (Agenda ag : this.tmAgendamentos.getLstAgendamentos()) {
            this.tmAgendamentos.addLinha(ag);
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
        lblData = new javax.swing.JLabel();
        btnBuscarPaciente = new javax.swing.JButton();
        lblDentista = new javax.swing.JLabel();
        edtDentista = new javax.swing.JTextField();
        btnBuscarDentista = new javax.swing.JButton();
        escolherData = new com.toedter.calendar.JDateChooser();
        lblCpf = new javax.swing.JLabel();
        edtCpf = new javax.swing.JTextField();
        lblProcedimento = new javax.swing.JLabel();
        boxHorarios = new javax.swing.JComboBox<>();
        boxProcedimentos = new javax.swing.JComboBox<>();
        lblId = new javax.swing.JLabel();
        edtId = new javax.swing.JTextField();
        btnNovo = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
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
        lblHorario.setBounds(20, 140, 60, 20);

        edtPaciente.setEditable(false);
        painel1.add(edtPaciente);
        edtPaciente.setBounds(90, 20, 320, 19);

        lblData.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        lblData.setText("Data ");
        painel1.add(lblData);
        lblData.setBounds(20, 100, 38, 17);

        btnBuscarPaciente.setText("Buscar");
        btnBuscarPaciente.setContentAreaFilled(false);
        btnBuscarPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarPacienteActionPerformed(evt);
            }
        });
        painel1.add(btnBuscarPaciente);
        btnBuscarPaciente.setBounds(580, 20, 90, 20);

        lblDentista.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        lblDentista.setText("Dentista");
        painel1.add(lblDentista);
        lblDentista.setBounds(20, 60, 59, 17);

        edtDentista.setEditable(false);
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
        painel1.add(escolherData);
        escolherData.setBounds(90, 100, 150, 19);

        lblCpf.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        lblCpf.setText("CPF");
        painel1.add(lblCpf);
        lblCpf.setBounds(420, 20, 30, 17);

        edtCpf.setEditable(false);
        painel1.add(edtCpf);
        edtCpf.setBounds(460, 20, 110, 19);

        lblProcedimento.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        lblProcedimento.setText("Procedimento");
        painel1.add(lblProcedimento);
        lblProcedimento.setBounds(340, 100, 100, 20);

        boxHorarios.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        boxHorarios.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "30 min", "1h", "1h30min", "2h" }));
        boxHorarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxHorariosActionPerformed(evt);
            }
        });
        painel1.add(boxHorarios);
        boxHorarios.setBounds(90, 140, 85, 20);

        boxProcedimentos.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        boxProcedimentos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Clareamento dental", "Tratamento ortodôntico", "Implante", "Próteses fixas", "Enxerto gengival", "Periodontia", "Endodontia" }));
        boxProcedimentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxProcedimentosActionPerformed(evt);
            }
        });
        painel1.add(boxProcedimentos);
        boxProcedimentos.setBounds(460, 100, 210, 20);

        lblId.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        lblId.setText("ID");
        painel1.add(lblId);
        lblId.setBounds(220, 140, 15, 20);
        painel1.add(edtId);
        edtId.setBounds(250, 140, 90, 20);

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

        btnExcluir.setFont(new java.awt.Font("DejaVu Sans", 0, 12)); // NOI18N
        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/delete.png"))); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
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
                        .addComponent(btnExcluir)
                        .addGap(18, 18, 18)
                        .addComponent(btnSalvar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(painel1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnExcluir, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(btnSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(btnNovo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
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

        if (confirm == JOptionPane.YES_OPTION) {
            this.salvar();
        }
        this.btnCancelarActionPerformed(evt);
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed

        int confirm = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir?");

        if (confirm == JOptionPane.YES_OPTION) {
            ListaAgendamentos lista = new ListaAgendamentos(this, true);
            lista.setVisible(true);
            int i = lista.getIndiceSelecionado();

            this.tmAgendamentos.getLstAgendamentos().remove(i);
            this.salvarArquivo("src/csv/lst_agendamentos.csv");
            JOptionPane.showMessageDialog(this, "Agendamento excluído!");
            this.tmAgendamentos.fireTableDataChanged();

        } else {

            this.btnCancelarActionPerformed(evt);
        }

    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnBuscarPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarPacienteActionPerformed

        ListaPacientes lista = new ListaPacientes(this, true);
        lista.setVisible(true);
        this.paciente = lista.getPacienteSelecionado();
        this.a.setPaciente(this.paciente);

        this.edtPaciente.setText(this.paciente.getNome());
        this.edtCpf.setText(this.paciente.getCpf());
        this.btnBuscarDentista.requestFocus();
    }//GEN-LAST:event_btnBuscarPacienteActionPerformed

    private void btnBuscarDentistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarDentistaActionPerformed
        ListaDentistas lista = new ListaDentistas(this, true);
        lista.setVisible(true);
        this.dentista = lista.getDentistaSelecionado();
        this.a.setDentista(this.dentista);
        this.edtDentista.setText(this.dentista.getNome());
//        this.copiarObjetoParaCampos(a);
        this.escolherData.requestFocus();
    }//GEN-LAST:event_btnBuscarDentistaActionPerformed

    private void escolherDataMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_escolherDataMouseReleased
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
//        this.setText(df.format(this.escolherData.getDate()));
    }//GEN-LAST:event_escolherDataMouseReleased

    private void boxHorariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxHorariosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boxHorariosActionPerformed

    private void boxProcedimentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxProcedimentosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boxProcedimentosActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> boxHorarios;
    private javax.swing.JComboBox<String> boxProcedimentos;
    private javax.swing.JButton btnBuscarDentista;
    private javax.swing.JButton btnBuscarPaciente;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JTextField edtCpf;
    private javax.swing.JTextField edtDentista;
    private javax.swing.JTextField edtId;
    private javax.swing.JTextField edtPaciente;
    private com.toedter.calendar.JDateChooser escolherData;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCpf;
    private javax.swing.JLabel lblData;
    private javax.swing.JLabel lblDentista;
    private javax.swing.JLabel lblHorario;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblPaciente;
    private javax.swing.JLabel lblProcedimento;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel painel1;
    private javax.swing.JTable tblAgenda;
    // End of variables declaration//GEN-END:variables
}
