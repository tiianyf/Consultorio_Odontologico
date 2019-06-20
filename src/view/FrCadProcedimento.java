package view;

import controller.TMProcedimentos;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import model.Paciente;
import model.Procedimento;

public class FrCadProcedimento extends javax.swing.JFrame {

    private boolean alteracao;
    private TMProcedimentos tmProcedimentos;
    private Procedimento aux;
    private Paciente paciente;
    private List<Procedimento> lstProcedimentos;

    public FrCadProcedimento() {
        initComponents();

        this.lstProcedimentos = new ArrayList<>();
        this.paciente = new Paciente();
        this.tmProcedimentos = new TMProcedimentos();
        this.tblProcedimento.setModel(tmProcedimentos);
        this.alteracao = false;
        this.habilitarCampos(false);
    }

    public AbstractTableModel getTmProcedimentos() {
        return tmProcedimentos;
    }

    /**
     * Altera a visibilidade dos campos da GUI, de acordo com o parâmetro.
     *
     * @param flag caso true, ativa, caso contrário, desativa.
     */
    public void habilitarCampos(boolean flag) {

        this.boxTipos.setEnabled(flag);
        this.btnBuscaPaciente.setEnabled(flag);
        this.txtNome.setEnabled(flag);
        this.txtCpf.setEnabled(flag);
        this.edtTempo.setEnabled(flag);

        if (!flag) {
            this.limparTodosCampos();
        }

    }

    /**
     * Limpa todos os campos de texto da GUI.
     */
    public void limparTodosCampos() {

        this.txtNome.setText(null);
        this.txtCpf.setText(null);
        this.edtTempo.setText(null);
        this.txtId.setText(null);

    }

    /**
     * Verifica se algum campo da GUI não foi preenchido pelo usuário.
     *
     * @return true caso haja algum campo vazio
     */
    public boolean verificarCamposVazios() {

        return this.txtNome.getText().isEmpty()
                || this.txtCpf.getText().isEmpty()
                || this.edtTempo.getText().isEmpty();

    }

    /**
     * Copia o que está nos campos da GUI para o objeto.
     *
     * @param p o objeto que receberá os dados contidos nos campos da GUI.
     */
    public void copiarCamposParaObjeto(Procedimento p) {
        // pra mais tarde

    }

    public void copiarObjetoParaCampos(Procedimento p) {

        this.txtNome.setText(this.paciente.getNome());
        this.txtCpf.setText(this.paciente.getCpf());
        this.txtId.setText(this.confirmarId().getId());
        this.edtTempo.setText(Integer.toString(this.aux.getTempo()));

    }

    public Procedimento confirmarId() {

        do {

            this.aux.setId(aux.idAleatorio());

        } while (this.existe(this.aux));

        return this.aux;

    }

    /**
     *
     * @param p
     * @return
     */
    public boolean existe(Procedimento p) {
        for (Procedimento proc : this.lstProcedimentos) {
            if (proc.getId().equals(p.getId())) {
                return true;
            }
        }
        return false;
    }

    public int buscar(String termo) {
        boolean flag = false;
        for (int i = 0; i < this.tmProcedimentos.getRowCount(); i++) {
            if (termo.equals(this.tmProcedimentos.getLstProcedimentos().get(i).getId())) {
                flag = true;
                return i;
            }
        }
        if (!flag) {
            JOptionPane.showMessageDialog(null, "ID [" + termo + "] não encontrado.");
        }
        return -1;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        painelDados = new javax.swing.JPanel();
        lblTipo = new javax.swing.JLabel();
        lblPaciente = new javax.swing.JLabel();
        lblTempo = new javax.swing.JLabel();
        edtTempo = new javax.swing.JTextField();
        lblValor = new javax.swing.JLabel();
        boxTipos = new javax.swing.JComboBox<>();
        btnBuscaPaciente = new javax.swing.JButton();
        txtNome = new javax.swing.JTextField();
        lblCpf = new javax.swing.JLabel();
        txtCpf = new javax.swing.JTextField();
        lblId = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProcedimento = new javax.swing.JTable();
        btnNovo = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        brnExcluir = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Procedimento");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        lblTitulo.setFont(new java.awt.Font("DejaVu Sans", 1, 18)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("PROCEDIMENTO");
        lblTitulo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        painelDados.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblTipo.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        lblTipo.setText("Tipo");

        lblPaciente.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        lblPaciente.setText("Paciente");

        lblTempo.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        lblTempo.setText("Tempo Estimado (em min):");

        edtTempo.setToolTipText("Em minutos.");

        lblValor.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        lblValor.setText("Valor:");

        boxTipos.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        boxTipos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Clareamento dental", "Tratamento ortodôntico", "Implante", "Próteses fixas", "Enxerto gengival", "Periodontia", "Endodontia" }));
        boxTipos.setToolTipText("Veja os procedimentos disponíveis");
        boxTipos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxTiposActionPerformed(evt);
            }
        });

        btnBuscaPaciente.setText("Buscar...");
        btnBuscaPaciente.setToolTipText("Abre a lista de pacientes");
        btnBuscaPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscaPacienteActionPerformed(evt);
            }
        });

        txtNome.setEditable(false);
        txtNome.setToolTipText("Dados do paciente não podem ser alterados!");

        lblCpf.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        lblCpf.setText("CPF");

        txtCpf.setEditable(false);
        txtCpf.setToolTipText("Dados do paciente não podem ser alterados!");

        lblId.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        lblId.setText("ID:");

        txtId.setEditable(false);
        txtId.setToolTipText("ID do procedimento é aleatório e inalterável!");

        javax.swing.GroupLayout painelDadosLayout = new javax.swing.GroupLayout(painelDados);
        painelDados.setLayout(painelDadosLayout);
        painelDadosLayout.setHorizontalGroup(
            painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelDadosLayout.createSequentialGroup()
                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelDadosLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTipo)
                            .addComponent(lblPaciente))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(painelDadosLayout.createSequentialGroup()
                                .addComponent(boxTipos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblValor)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(painelDadosLayout.createSequentialGroup()
                                .addComponent(btnBuscaPaciente)
                                .addGap(18, 18, 18)
                                .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblCpf)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtCpf, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE))))
                    .addGroup(painelDadosLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblTempo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(edtTempo, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblId)
                        .addGap(18, 18, 18)
                        .addComponent(txtId, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)))
                .addContainerGap())
        );
        painelDadosLayout.setVerticalGroup(
            painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelDadosLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTipo)
                    .addComponent(boxTipos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblValor))
                .addGap(18, 18, 18)
                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBuscaPaciente)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCpf)
                    .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPaciente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTempo)
                    .addComponent(edtTempo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblId)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        tblProcedimento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblProcedimento);

        btnNovo.setFont(new java.awt.Font("DejaVu Sans", 0, 12)); // NOI18N
        btnNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/new.png"))); // NOI18N
        btnNovo.setText("Novo");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        btnEditar.setFont(new java.awt.Font("DejaVu Sans", 0, 12)); // NOI18N
        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/edit.png"))); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
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

        brnExcluir.setFont(new java.awt.Font("DejaVu Sans", 0, 12)); // NOI18N
        brnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/delete.png"))); // NOI18N
        brnExcluir.setText("Excluir");

        btnSalvar.setFont(new java.awt.Font("DejaVu Sans", 0, 12)); // NOI18N
        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/save2.png"))); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 631, Short.MAX_VALUE)
                        .addGap(51, 51, 51))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(painelDados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
            .addGroup(layout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addComponent(btnNovo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEditar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancelar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(brnExcluir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSalvar)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(painelDados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNovo)
                    .addComponent(btnEditar)
                    .addComponent(btnCancelar)
                    .addComponent(brnExcluir)
                    .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 6, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(722, 547));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * O tipo de procedimento (do atributo dessa classe) será definido aqui.
     */
    private void boxTiposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxTiposActionPerformed

        if (this.boxTipos.getSelectedItem().equals(Procedimento.CLAREAMENTO.getDescricao())) {
            this.lblValor.setText("Valor: R$" + Procedimento.CLAREAMENTO.getValor());
            this.aux = Procedimento.CLAREAMENTO;

        } else if (this.boxTipos.getSelectedItem().equals(Procedimento.ENDODONTIA.getDescricao())) {
            this.lblValor.setText("Valor: R$" + Procedimento.ENDODONTIA.getValor());
            this.aux = Procedimento.ENDODONTIA;

        } else if (this.boxTipos.getSelectedItem().equals(Procedimento.ENXERTO.getDescricao())) {
            this.lblValor.setText("Valor: R$" + Procedimento.ENXERTO.getValor());
            this.aux = Procedimento.ENXERTO;

        } else if (this.boxTipos.getSelectedItem().equals(Procedimento.IMPLANTE.getDescricao())) {
            this.lblValor.setText("Valor: R$" + Procedimento.IMPLANTE.getValor());
            this.aux = Procedimento.IMPLANTE;

        } else if (this.boxTipos.getSelectedItem().equals(Procedimento.PROTESE.getDescricao())) {
            this.lblValor.setText("Valor: R$" + Procedimento.PROTESE.getValor());
            this.aux = Procedimento.PROTESE;

        } else if (this.boxTipos.getSelectedItem().equals(Procedimento.RASPAGEM.getDescricao())) {
            this.lblValor.setText("Valor: R$" + Procedimento.RASPAGEM.getValor());
            this.aux = Procedimento.RASPAGEM;

        } else if (this.boxTipos.getSelectedItem().equals(Procedimento.TRATAMENTO.getDescricao())) {
            this.lblValor.setText("Valor: R$" + Procedimento.TRATAMENTO.getValor());
            this.aux = Procedimento.TRATAMENTO;

        }

    }//GEN-LAST:event_boxTiposActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.habilitarCampos(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        this.habilitarCampos(true);
        this.alteracao = false;
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        if (this.verificarCamposVazios()) {
            JOptionPane.showMessageDialog(null, "Favor preencher todos os dados");

        } else {
            int confirmacao = JOptionPane.showConfirmDialog(null, "Deseja realmente salvar?");
            if (confirmacao == 0) { // 0 é sim, 1 é não
                this.copiarCamposParaObjeto(this.aux);

            }

        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnBuscaPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscaPacienteActionPerformed

        ListaPacientes lista = new ListaPacientes(this, true);
        lista.setVisible(true);
        this.paciente = lista.getPacienteSelecionado();
        this.copiarObjetoParaCampos(this.aux); // parâmetro indiferente

    }//GEN-LAST:event_btnBuscaPacienteActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        this.alteracao = true;
    }//GEN-LAST:event_btnEditarActionPerformed

    public void buscaPaciente(Paciente p) {
        this.paciente = p;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> boxTipos;
    private javax.swing.JButton brnExcluir;
    private javax.swing.JButton btnBuscaPaciente;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JTextField edtTempo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCpf;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblPaciente;
    private javax.swing.JLabel lblTempo;
    private javax.swing.JLabel lblTipo;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblValor;
    private javax.swing.JPanel painelDados;
    private javax.swing.JTable tblProcedimento;
    private javax.swing.JTextField txtCpf;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables

}
