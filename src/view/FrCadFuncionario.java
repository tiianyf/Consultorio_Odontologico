package view;

import controller.TMFuncionarios;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Funcionario;

public class FrCadFuncionario extends javax.swing.JFrame {

    private final TMFuncionarios tmFuncionario;
    private boolean alteracao;

    public FrCadFuncionario() {
        initComponents();
        this.tmFuncionario = new TMFuncionarios();
        this.alteracao = false;
        this.habilitarCampos(false);
        this.carregarArquivo("src/csv/lst_funcionarios.csv");
        this.tmFuncionario.fireTableDataChanged();
    }

    public final void habilitarCampos(boolean flag) {
        this.edtNome.setEnabled(flag);
        this.edtCpf.setEnabled(flag);
        this.rdFem.setEnabled(flag);
        this.rdMasc.setEnabled(flag);
        this.edtIdade.setEnabled(flag);
        this.edtTelefone.setEnabled(flag);
        this.edtEmail.setEnabled(flag);
        this.boxCargos.setEnabled(flag);
        this.edtSalario.setEnabled(flag);

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
        this.edtSalario.setText(null);
    }

    public boolean verificarCamposVazios() {
        return this.edtNome.getText().isEmpty()
                || this.edtCpf.getText().isEmpty()
                || (this.rdFem.isSelected() || this.rdMasc.isSelected())
                || this.edtIdade.getText().isEmpty()
                || this.edtTelefone.getText().isEmpty()
                || this.edtEmail.getText().isEmpty()
                || this.edtSalario.getText().isEmpty();

    }

    public void copiarCamposParaObjeto(Funcionario f) {
        f.setNome(this.edtNome.getText());
        f.setCpf(this.edtCpf.getText());

        if (this.rdFem.isSelected()) {
            f.setSexo('F');
        } else if (this.rdMasc.isSelected()) {
            f.setSexo('M');
        }

        f.setIdade(Integer.parseInt(this.edtIdade.getText()));
        f.setTelefone(this.edtTelefone.getText());
        f.setEmail(this.edtEmail.getText());

        if (this.boxCargos.getSelectedItem().equals("Secretária")) {
            f.setCargo("Secretária");
        } else if (this.boxCargos.getSelectedItem().equals("Auxiliar")) {
            f.setCargo("Auxiliar");
        } else if (this.boxCargos.getSelectedItem().equals("Faxineira")) {
            f.setCargo("Faxineira");
        }
        
        f.setSalario(Double.parseDouble(this.edtSalario.getText()));
    }

    public void copiarObjetoParaCampos(Funcionario f) {
        this.edtNome.setText(f.getNome());
        this.edtCpf.setText(f.getCpf());

        if (f.getSexo() == 'F' || f.getSexo() == 'f') {
            this.rdFem.setSelected(true);
        } else if (f.getSexo() == 'M' || f.getSexo() == 'm') {
            this.rdMasc.setSelected(true);
        }

        this.edtIdade.setText(f.getIdade() + "");
        this.edtTelefone.setText(f.getTelefone());
        this.edtEmail.setText(f.getEmail());

        switch (f.getCargo()) {
            case "Secretária":
                this.boxCargos.setSelectedItem("Secretária");
                break;
            case "Auxiliar":
                this.boxCargos.setSelectedItem("Auxiliar");
                break;
            case "Faxineira":
                this.boxCargos.setSelectedItem("Faxineira");
                break;
        }
        this.edtSalario.setText(f.getSalario() + "");

    }

    public int buscar(String termo) {
        for (int i = 0; i < this.tmFuncionario.getRowCount(); i++) {
            if (termo.equals(this.tmFuncionario.getLstFuncionarios().get(i).getCpf())) {
                return i;
            }
        }
        JOptionPane.showMessageDialog(null, "Funcionário não cadastrado!");
        return -1;
    }

    public boolean existe(Funcionario funcionario) {
        for (Funcionario f : this.tmFuncionario.getLstFuncionarios()) {
            if (f.getCpf().equals(funcionario.getCpf())) {
                return true;
            }
        }
        return false;
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
                Funcionario f = new Funcionario();
                f.setInfoCSV(linhaCsv);
                this.tmFuncionario.addLinha(f);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FrCadFuncionario.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "ERRO! Arquivo não foi carregado.");
        }
    }

    public void salvarNoArquivo(String caminho) {
        try {
            FileWriter arquivo = new FileWriter(caminho);
            try (PrintWriter escrita = new PrintWriter(arquivo)) {
                Funcionario aux = new Funcionario();
                String info = aux.getCabecalhoCSV();
                for (Funcionario f : this.tmFuncionario.getLstFuncionarios()) {
                    info += f.getInfoCSV();
                }
                escrita.print(info);
            } catch (Exception e) {
            }
        } catch (IOException ex) {
            Logger.getLogger(FrCadFuncionario.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "ERRO! Não foi possível salvar o arquivo.");
        }

    }

    public void salvar() {
        Funcionario f = new Funcionario();
        this.copiarCamposParaObjeto(f);

        if (this.alteracao) {
            this.tmFuncionario.getLstFuncionarios().set(this.buscar(f.getCpf()), f);
        } else {
            if (this.existe(f)) {
                JOptionPane.showMessageDialog(null, "CPF já existe!");
            } else {
                this.tmFuncionario.addLinha(f);
            }
        }
        this.salvarNoArquivo("src/csv/lst_funcionarios.csv");
        this.tmFuncionario.fireTableDataChanged();
        this.habilitarCampos(false);
    }

    public void mostrarTabela() {
        for (Funcionario f : this.tmFuncionario.getLstFuncionarios()) {
            this.tmFuncionario.addLinha(f);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGrupoCargos = new javax.swing.ButtonGroup();
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
        lblCargo = new javax.swing.JLabel();
        lblSalario = new javax.swing.JLabel();
        edtSalario = new javax.swing.JTextField();
        boxCargos = new javax.swing.JComboBox<>();
        btnNovo = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        brnExcluir = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Funcionário");

        lblTitulo.setFont(new java.awt.Font("DejaVu Sans", 1, 18)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("FUNCIONÁRIO");
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

        lblCargo.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        lblCargo.setText("Cargo");

        lblSalario.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        lblSalario.setText("Salário");

        edtSalario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                edtSalarioKeyReleased(evt);
            }
        });

        boxCargos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Secretária", "Auxiliar", "Faxineira" }));
        boxCargos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxCargosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(lblNome))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblCpf))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblSexo))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblTelefone))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblEmail))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblCargo)))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(edtCpf)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(boxCargos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblSalario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(edtSalario, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(edtNome)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(edtTelefone, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(rdFem)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rdMasc)))
                        .addGap(18, 18, 18)
                        .addComponent(lblIdade)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(edtIdade, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 239, Short.MAX_VALUE))
                    .addComponent(edtEmail))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNome)
                    .addComponent(edtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCpf)
                    .addComponent(edtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSexo)
                    .addComponent(rdFem)
                    .addComponent(rdMasc))
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
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCargo)
                    .addComponent(lblSalario)
                    .addComponent(edtSalario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boxCargos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(133, Short.MAX_VALUE))
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(btnNovo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEditar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(brnExcluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSalvar))
                    .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 663, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNovo)
                    .addComponent(btnEditar)
                    .addComponent(btnCancelar)
                    .addComponent(brnExcluir)
                    .addComponent(btnSalvar))
                .addGap(14, 14, 14))
        );

        setSize(new java.awt.Dimension(673, 499));
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
        String info = JOptionPane.showInputDialog("Digite o CPF:");
        Funcionario f = new Funcionario();
        f = this.tmFuncionario.getLstFuncionarios().get(this.buscar(info));

        int confirm = JOptionPane.showConfirmDialog(null, "Deseja realmente editar?");

        if (confirm == JOptionPane.YES_OPTION) {
            this.alteracao = true;
            this.copiarObjetoParaCampos(f);
            this.habilitarCampos(true);
        } else if (confirm == JOptionPane.NO_OPTION) {
            this.btnCancelarActionPerformed(evt);
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void brnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_brnExcluirActionPerformed
        String info = JOptionPane.showInputDialog("Digite o CPF");
        Funcionario f = new Funcionario();
        f = this.tmFuncionario.getLstFuncionarios().get(this.buscar(info));

        int confirm = JOptionPane.showConfirmDialog(null, "Realmente desejar excluir?");

        if (confirm == JOptionPane.YES_OPTION) {
            this.tmFuncionario.getLstFuncionarios().remove(f);
            this.salvarNoArquivo("src/csv/lst_funcionarios");
            JOptionPane.showMessageDialog(null, "Funcionário excluído!");
            this.tmFuncionario.fireTableDataChanged();
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
        this.habilitarCampos(false);
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
            this.edtTelefone.requestFocus();
        }
    }//GEN-LAST:event_rdFemKeyReleased

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
            this.boxCargos.requestFocus();
        }
    }//GEN-LAST:event_edtEmailKeyReleased

    private void edtSalarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_edtSalarioKeyReleased
        if (evt.getKeyChar() == java.awt.event.KeyEvent.VK_ENTER) {
            this.btnSalvar.requestFocus();
        }
    }//GEN-LAST:event_edtSalarioKeyReleased

    private void boxCargosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxCargosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boxCargosActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> boxCargos;
    private javax.swing.JButton brnExcluir;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditar;
    private javax.swing.ButtonGroup btnGrupoCargos;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JTextField edtCpf;
    private javax.swing.JTextField edtEmail;
    private javax.swing.JTextField edtIdade;
    private javax.swing.JTextField edtNome;
    private javax.swing.JTextField edtSalario;
    private javax.swing.JTextField edtTelefone;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblCargo;
    private javax.swing.JLabel lblCpf;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblIdade;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblSalario;
    private javax.swing.JLabel lblSexo;
    private javax.swing.JLabel lblTelefone;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JRadioButton rdFem;
    private javax.swing.JRadioButton rdMasc;
    // End of variables declaration//GEN-END:variables
}
