package view;

import controller.TMDColaboradores;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.DColaborador;

/**
 *
 * @author cfreitas
 */
public class FrCadDentistaColaborador extends javax.swing.JFrame {

    private final TMDColaboradores tmDColaborador;
    private boolean alteracao;

    public FrCadDentistaColaborador() {
        initComponents();
        this.tmDColaborador = new TMDColaboradores();
        this.alteracao = false;
        this.habilitarCampos(false);
        this.tblDentistaColaborador.setModel(tmDColaborador);
        this.carregarArquivo("src/csv/lst_dcolaboradores.csv");
        this.tmDColaborador.fireTableDataChanged();

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

    public void copiarCamposParaObjeto(DColaborador d) {
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

    public void copiarObjetoParaCampos(DColaborador d) {
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
        for (int i = 0; i < this.tmDColaborador.getRowCount(); i++) {
            if (termo.equals(this.tmDColaborador.getLstDColaboradores().get(i).getCro())) {
                return i;
            }
        }
        JOptionPane.showMessageDialog(null, "Dentista Colaborador não cadastrado!");
        return -1;
    }

    public boolean existe(DColaborador dentistaC) {
        for (DColaborador d : this.tmDColaborador.getLstDColaboradores()) {
            if (d.getCro().equals(dentistaC.getCro())) {
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
                DColaborador d = new DColaborador();
                d.setInfoCSV(linhaCsv);
                this.tmDColaborador.addLinha(d);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FrCadDentistaColaborador.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "ERRO! Arquivo não foi carregado.");
        }
    }

    public void salvarNoArquivo(String caminho) {
        try {
            FileWriter arquivo = new FileWriter(caminho);
            try (PrintWriter escrita = new PrintWriter(arquivo)) {
                DColaborador aux = new DColaborador();
                String info = aux.getCabecalhoCSV();
                for (DColaborador d : this.tmDColaborador.getLstDColaboradores()) {
                    info += d.getInfoCSV();
                }
                escrita.print(info);
            } catch (Exception e) {
            }
        } catch (IOException ex) {
            Logger.getLogger(FrCadDentistaColaborador.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "ERRO! Não foi possível salvar o arquivo.");
        }

    }

    public void salvar() {
        DColaborador d = new DColaborador();
        this.copiarCamposParaObjeto(d);

        if (this.alteracao) {
            this.tmDColaborador.getLstDColaboradores().set(this.buscar(d.getCro()), d);
        } else {
            if (this.existe(d)) {
                JOptionPane.showMessageDialog(null, "CRO já existe!");
            } else {
                this.tmDColaborador.addLinha(d);
            }
        }
        this.salvarNoArquivo("src/csv/lst_dcolaboradores.csv");
        this.tmDColaborador.fireTableDataChanged();
        this.habilitarCampos(false);
    }

    public void mostrarTabela() {
        for (DColaborador d : this.tmDColaborador.getLstDColaboradores()) {
            this.tmDColaborador.addLinha(d);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGrupoSexo = new javax.swing.ButtonGroup();
        lblTitulo = new javax.swing.JLabel();
        painel1 = new javax.swing.JPanel();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDentistaColaborador = new javax.swing.JTable();
        btnNovo = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        brnExcluir = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Dentista Colaborador");

        lblTitulo.setFont(new java.awt.Font("DejaVu Sans", 1, 18)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("DENTISTA COLABORADOR");
        lblTitulo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        painel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblNome.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        lblNome.setText("Nome");

        lblCpf.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        lblCpf.setText("CPF");

        lblSexo.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        lblSexo.setText("Sexo");

        btnGrupoSexo.add(rdFem);
        rdFem.setFont(new java.awt.Font("DejaVu Sans", 1, 12)); // NOI18N
        rdFem.setText("Feminino");
        rdFem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdFemActionPerformed(evt);
            }
        });

        btnGrupoSexo.add(rdMasc);
        rdMasc.setFont(new java.awt.Font("DejaVu Sans", 1, 12)); // NOI18N
        rdMasc.setText("Masculino");

        lblIdade.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        lblIdade.setText("Idade");

        lblTelefone.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        lblTelefone.setText("Telefone");

        lblEmail.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        lblEmail.setText("Email");

        lblCro.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        lblCro.setText("CRO");

        javax.swing.GroupLayout painel1Layout = new javax.swing.GroupLayout(painel1);
        painel1.setLayout(painel1Layout);
        painel1Layout.setHorizontalGroup(
            painel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNome)
                    .addComponent(lblCpf)
                    .addComponent(lblSexo)
                    .addComponent(lblTelefone)
                    .addComponent(lblEmail))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(painel1Layout.createSequentialGroup()
                        .addGroup(painel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(edtTelefone, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(painel1Layout.createSequentialGroup()
                                .addComponent(rdFem)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rdMasc)))
                        .addGroup(painel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(painel1Layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(lblCro)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(edtCro))
                            .addGroup(painel1Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(lblIdade)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(edtIdade, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 184, Short.MAX_VALUE))))
                    .addComponent(edtCpf)
                    .addComponent(edtNome)
                    .addComponent(edtEmail))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        painel1Layout.setVerticalGroup(
            painel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNome)
                    .addComponent(edtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCpf)
                    .addComponent(edtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSexo)
                    .addComponent(rdFem)
                    .addComponent(rdMasc)
                    .addComponent(lblCro)
                    .addComponent(edtCro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTelefone)
                    .addComponent(edtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(edtIdade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblIdade))
                .addGap(18, 18, 18)
                .addGroup(painel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEmail)
                    .addComponent(edtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        tblDentistaColaborador.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tblDentistaColaborador.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblDentistaColaborador);

        btnNovo.setFont(new java.awt.Font("DejaVu Sans", 0, 12)); // NOI18N
        btnNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/user.png"))); // NOI18N
        btnNovo.setText("Novo");
        btnNovo.setAutoscrolls(true);
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
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
        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/btnSave.png"))); // NOI18N
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
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane1)
                            .addComponent(painel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(btnNovo)
                        .addGap(18, 18, 18)
                        .addComponent(btnEditar)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancelar)
                        .addGap(18, 18, 18)
                        .addComponent(brnExcluir)
                        .addGap(18, 18, 18)
                        .addComponent(btnSalvar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(painel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNovo)
                    .addComponent(btnEditar)
                    .addComponent(btnCancelar)
                    .addComponent(brnExcluir)
                    .addComponent(btnSalvar))
                .addGap(87, 87, 87))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(453, Short.MAX_VALUE)))
        );

        setSize(new java.awt.Dimension(704, 455));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void rdFemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdFemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdFemActionPerformed

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        this.habilitarCampos(true);
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        String info = JOptionPane.showInputDialog("Digite o CRO:");
        DColaborador d = new DColaborador();
        d = this.tmDColaborador.getLstDColaboradores().get(this.buscar(info));

        int confirm = JOptionPane.showConfirmDialog(null, "Deseja realmente editar?");

        if (confirm == JOptionPane.YES_OPTION) {
            this.alteracao = true;
            this.copiarObjetoParaCampos(d);
            this.habilitarCampos(true);
        } else if (confirm == JOptionPane.NO_OPTION) {
            this.btnCancelarActionPerformed(evt);
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.habilitarCampos(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void brnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_brnExcluirActionPerformed
        String info = JOptionPane.showInputDialog("Digite o CPF");
        DColaborador d = new DColaborador();
        d = this.tmDColaborador.getLstDColaboradores().get(this.buscar(info));

        int confirm = JOptionPane.showConfirmDialog(null, "Realmente desejar excluir?");

        if (confirm == JOptionPane.YES_OPTION) {
            this.tmDColaborador.getLstDColaboradores().remove(d);
            this.salvarNoArquivo("src/csv/lst_dcolaboradores.csv");
            JOptionPane.showMessageDialog(null, "Dentista Colaborador excluído!");
            this.tmDColaborador.fireTableDataChanged();
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton brnExcluir;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditar;
    private javax.swing.ButtonGroup btnGrupoSexo;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JTextField edtCpf;
    private javax.swing.JTextField edtCro;
    private javax.swing.JTextField edtEmail;
    private javax.swing.JTextField edtIdade;
    private javax.swing.JTextField edtNome;
    private javax.swing.JTextField edtTelefone;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCpf;
    private javax.swing.JLabel lblCro;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblIdade;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblSexo;
    private javax.swing.JLabel lblTelefone;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel painel1;
    private javax.swing.JRadioButton rdFem;
    private javax.swing.JRadioButton rdMasc;
    private javax.swing.JTable tblDentistaColaborador;
    // End of variables declaration//GEN-END:variables
}