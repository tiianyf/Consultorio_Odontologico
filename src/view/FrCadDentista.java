package view;

import controller.TMDProprietario;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.DProprietario;

public class FrCadDentista extends javax.swing.JFrame {

    private final TMDProprietario tmDProprietario;
    private boolean alteracao;

    public FrCadDentista() {
        initComponents();
        this.tmDProprietario = new TMDProprietario();
        this.alteracao = false;
        this.habilitarCampos(false);
        this.tblDentistaProprietario.setModel(tmDProprietario);
        this.carregarArquivo("src/csv/lst_dproprietario.csv");
        this.tmDProprietario.fireTableDataChanged();
    }

    public void habilitarCampos(boolean flag) {
        this.edtNome.setEnabled(flag);
        this.edtCpf.setEnabled(flag);
        this.rdFem.setEnabled(flag);
        this.rdMasc.setEnabled(flag);
        this.edtIdade.setEnabled(flag);
        this.edtTelefone.setEnabled(flag);
        this.edtEmail.setEnabled(flag);
        this.edtCro.setEnabled(flag);

        if (!flag) {
            this.limparTodosCampos();
        }
    }

    public void limparTodosCampos() {
        this.edtNome.setText(null);
        this.edtCpf.setText(null);
        this.rdFem.setSelected(false);
        this.rdMasc.setSelected(false);
        this.edtIdade.setText(null);
        this.edtTelefone.setText(null);
        this.edtEmail.setText(null);
        this.edtCro.setText(null);

    }

    public boolean verificarCamposVazios() {
        return this.edtNome.getText().isEmpty()
                || this.edtCpf.getText().isEmpty()
                || (this.rdFem.isSelected() || this.rdMasc.isSelected())
                || this.edtIdade.getText().isEmpty()
                || this.edtTelefone.getText().isEmpty()
                || this.edtEmail.getText().isEmpty()
                || this.edtCro.getText().isEmpty();

    }

    public void copiarCamposParaObjeto(DProprietario d) {
        d.setNome(this.edtNome.getText());
        d.setCpf(this.edtCpf.getText());

        if (this.rdFem.isSelected()) {
            d.setSexo('F');
        } else if (this.rdMasc.isSelected()) {
            d.setSexo('M');
        }

        d.setIdade(Integer.parseInt(this.edtIdade.getText()));
        d.setTelefone(this.edtTelefone.getText());
        d.setEmail(this.edtEmail.getText());
        d.setCro(this.edtCro.getText());
    }

    public void copiarObjetoParaCampos(DProprietario d) {
        this.edtNome.setText(d.getNome());
        this.edtCpf.setText(d.getCpf());

        if (d.getSexo() == 'F' || d.getSexo() == 'f') {
            this.rdFem.setSelected(true);
        } else if (d.getSexo() == 'M' || d.getSexo() == 'm') {
            this.rdMasc.setSelected(true);
        }

        this.edtIdade.setText(d.getIdade() + "");
        this.edtTelefone.setText(d.getTelefone());
        this.edtEmail.setText(d.getEmail());
        this.edtCro.setText(d.getCro());
    }

    public int buscar(String termo) {
        for (int i = 0; i < this.tmDProprietario.getRowCount(); i++) {
            if (termo.equals(this.tmDProprietario.getLstDProprietario().get(i).getCro())) {
                return i;
            }
        }
        JOptionPane.showMessageDialog(null, "Proprietário não cadastrado!");
        return -1;
    }

    public boolean existe(DProprietario dentistaP) {
        for (DProprietario d : this.tmDProprietario.getLstDProprietario()) {
            if (d.getCro().equals(dentistaP.getCro())) {
                return true;
            }
        }
        return false;
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
                DProprietario d = new DProprietario();
                d.setInfoCSV(linhaCsv);
                this.tmDProprietario.addLinha(d);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FrCadDentista.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "ERRO! Arquivo não foi carregado.");
        }
    }

    public void salvarNoArquivo(String caminho) {
        try {
            FileWriter arquivo = new FileWriter(caminho);
            try (PrintWriter escrita = new PrintWriter(arquivo)) {
                DProprietario aux = new DProprietario();
                String info = aux.getCabecalhoCSV();
                for (DProprietario d : this.tmDProprietario.getLstDProprietario()) {
                    info += d.getInfoCSV();
                }
                escrita.print(info);
            } catch (Exception e) {
            }
        } catch (IOException ex) {
            Logger.getLogger(FrCadDentista.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "ERRO! Não foi possível salvar o arquivo.");
        }

    }

    public void salvar() {
        DProprietario d = new DProprietario();
        this.copiarCamposParaObjeto(d);

        if (this.alteracao) {
            this.tmDProprietario.getLstDProprietario().set(this.buscar(d.getCro()), d);
        } else {
            if (this.existe(d)) {
                JOptionPane.showMessageDialog(null, "CRO já existe!");
            } else {
                this.tmDProprietario.addLinha(d);
            }
        }
        this.salvarNoArquivo("src/csv/lst_dproprietario.csv");
        this.tmDProprietario.fireTableDataChanged();
        this.habilitarCampos(false);
    }

    public void mostrarTabela() {
        for (DProprietario d : this.tmDProprietario.getLstDProprietario()) {
            this.tmDProprietario.addLinha(d);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblNome = new javax.swing.JLabel();
        lblCpf = new javax.swing.JLabel();
        edtNome = new javax.swing.JTextField();
        edtCpf = new javax.swing.JTextField();
        lblSexo = new javax.swing.JLabel();
        rdFem = new javax.swing.JRadioButton();
        rdMasc = new javax.swing.JRadioButton();
        lblIdade = new javax.swing.JLabel();
        edtIdade = new javax.swing.JTextField();
        lblTelefone = new javax.swing.JLabel();
        edtTelefone = new javax.swing.JTextField();
        lblEmail = new javax.swing.JLabel();
        edtEmail = new javax.swing.JTextField();
        lblCro = new javax.swing.JLabel();
        edtCro = new javax.swing.JTextField();
        btnNovo = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        brnExcluir = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDentistaProprietario = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Proprietário");

        lblTitulo.setFont(new java.awt.Font("DejaVu Sans", 1, 18)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("DENTISTA");
        lblTitulo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblNome.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        lblNome.setText("Nome");

        lblCpf.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        lblCpf.setText("CPF");

        edtNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                edtNomeKeyReleased(evt);
            }
        });

        edtCpf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                edtCpfKeyReleased(evt);
            }
        });

        lblSexo.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        lblSexo.setText("Sexo");

        rdFem.setFont(new java.awt.Font("DejaVu Sans", 1, 12)); // NOI18N
        rdFem.setText("Feminino");
        rdFem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdFemActionPerformed(evt);
            }
        });
        rdFem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                rdFemKeyReleased(evt);
            }
        });

        rdMasc.setFont(new java.awt.Font("DejaVu Sans", 1, 12)); // NOI18N
        rdMasc.setText("Masculino");

        lblIdade.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        lblIdade.setText("Idade");

        edtIdade.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                edtIdadeKeyReleased(evt);
            }
        });

        lblTelefone.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        lblTelefone.setText("Telefone");

        edtTelefone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                edtTelefoneKeyReleased(evt);
            }
        });

        lblEmail.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        lblEmail.setText("Email");

        edtEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                edtEmailKeyReleased(evt);
            }
        });

        lblCro.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        lblCro.setText("CRO");

        edtCro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                edtCroKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNome)
                    .addComponent(lblCpf)
                    .addComponent(lblSexo)
                    .addComponent(lblTelefone)
                    .addComponent(lblEmail))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(edtTelefone, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(rdFem)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rdMasc)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(lblCro)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(edtCro))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(lblIdade)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(edtIdade, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addComponent(edtCpf, javax.swing.GroupLayout.DEFAULT_SIZE, 567, Short.MAX_VALUE)
                    .addComponent(edtNome)
                    .addComponent(edtEmail))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNome)
                    .addComponent(edtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCpf)
                    .addComponent(edtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSexo)
                    .addComponent(rdFem)
                    .addComponent(rdMasc)
                    .addComponent(lblCro)
                    .addComponent(edtCro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTelefone)
                    .addComponent(edtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblIdade)
                    .addComponent(edtIdade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEmail)
                    .addComponent(edtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        btnNovo.setFont(new java.awt.Font("DejaVu Sans", 0, 12)); // NOI18N
        btnNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/new.png"))); // NOI18N
        btnNovo.setText("Novo");
        btnNovo.setAutoscrolls(true);
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
        brnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                brnExcluirActionPerformed(evt);
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

        tblDentistaProprietario.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tblDentistaProprietario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblDentistaProprietario);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 661, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(btnNovo)
                .addGap(18, 18, 18)
                .addComponent(btnEditar)
                .addGap(18, 18, 18)
                .addComponent(btnCancelar)
                .addGap(18, 18, 18)
                .addComponent(brnExcluir)
                .addGap(18, 18, 18)
                .addComponent(btnSalvar)
                .addContainerGap(63, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNovo)
                    .addComponent(btnEditar)
                    .addComponent(btnCancelar)
                    .addComponent(brnExcluir)
                    .addComponent(btnSalvar))
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(707, 482));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void rdFemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdFemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdFemActionPerformed

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        this.habilitarCampos(true);
        this.edtNome.requestFocus();
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.habilitarCampos(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        String info = JOptionPane.showInputDialog("Digite o CRO:");
        DProprietario d = new DProprietario();
        d = this.tmDProprietario.getLstDProprietario().get(this.buscar(info));

        int confirm = JOptionPane.showConfirmDialog(null, "Deseja realmente editar?");

        if (confirm == JOptionPane.YES_OPTION) {
            this.alteracao = true;
            this.copiarObjetoParaCampos(d);
            this.habilitarCampos(true);
        } else if (confirm == JOptionPane.NO_OPTION) {
            this.btnCancelarActionPerformed(evt);
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void brnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_brnExcluirActionPerformed
        String info = JOptionPane.showInputDialog("Digite o CPF");
        DProprietario d = new DProprietario();
        d = this.tmDProprietario.getLstDProprietario().get(this.buscar(info));

        int confirm = JOptionPane.showConfirmDialog(null, "Realmente desejar excluir?");

        if (confirm == JOptionPane.YES_OPTION) {
            this.tmDProprietario.getLstDProprietario().remove(d);
            this.salvarNoArquivo("src/csv/lst_dproprietario.csv");
            JOptionPane.showMessageDialog(null, "Proprietário excluído!");
            this.tmDProprietario.fireTableDataChanged();
        }
    }//GEN-LAST:event_brnExcluirActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        int confirm = JOptionPane.showConfirmDialog(null, "Deseja realmente salvar?");

        if (confirm == JOptionPane.YES_OPTION) {
            if (this.verificarCamposVazios()) {
                this.salvar();
                if (alteracao) {
                    JOptionPane.showMessageDialog(null, "Cadastro alterado!");
                } else {
                    JOptionPane.showMessageDialog(null, "Cadastro salvo!");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Campo Vazio!");
            }
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void edtNomeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_edtNomeKeyReleased
        if (evt.getKeyChar() == java.awt.event.KeyEvent.VK_ENTER) {
            this.edtCpf.requestFocus();
        }
    }//GEN-LAST:event_edtNomeKeyReleased

    private void edtCpfKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_edtCpfKeyReleased
        if (evt.getKeyChar() == java.awt.event.KeyEvent.VK_ENTER) {
            this.rdFem.requestFocus();
        }
    }//GEN-LAST:event_edtCpfKeyReleased

    private void rdFemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_rdFemKeyReleased
        if (evt.getKeyChar() == java.awt.event.KeyEvent.VK_ENTER) {
            this.edtCro.requestFocus();
        }
    }//GEN-LAST:event_rdFemKeyReleased

    private void edtCroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_edtCroKeyReleased
        if (evt.getKeyChar() == java.awt.event.KeyEvent.VK_ENTER) {
            this.edtTelefone.requestFocus();
        }
    }//GEN-LAST:event_edtCroKeyReleased

    private void edtTelefoneKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_edtTelefoneKeyReleased
        if (evt.getKeyChar() == java.awt.event.KeyEvent.VK_ENTER) {
            this.edtIdade.requestFocus();
        }
    }//GEN-LAST:event_edtTelefoneKeyReleased

    private void edtIdadeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_edtIdadeKeyReleased
        if (evt.getKeyChar() == java.awt.event.KeyEvent.VK_ENTER) {
            this.edtEmail.requestFocus();
        }
    }//GEN-LAST:event_edtIdadeKeyReleased

    private void edtEmailKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_edtEmailKeyReleased
        if (evt.getKeyChar() == java.awt.event.KeyEvent.VK_ENTER) {
            this.btnSalvar.requestFocus();
        }
    }//GEN-LAST:event_edtEmailKeyReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton brnExcluir;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JTextField edtCpf;
    private javax.swing.JTextField edtCro;
    private javax.swing.JTextField edtEmail;
    private javax.swing.JTextField edtIdade;
    private javax.swing.JTextField edtNome;
    private javax.swing.JTextField edtTelefone;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCpf;
    private javax.swing.JLabel lblCro;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblIdade;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblSexo;
    private javax.swing.JLabel lblTelefone;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JRadioButton rdFem;
    private javax.swing.JRadioButton rdMasc;
    private javax.swing.JTable tblDentistaProprietario;
    // End of variables declaration//GEN-END:variables
}
