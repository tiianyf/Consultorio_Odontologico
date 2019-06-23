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
import model.DiasSemana;

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
        this.carregarArquivo("src/csv/lst_dcolaboradores.csv");
        this.tmDColaborador.fireTableDataChanged();

    }

    public final void habilitarCampos(boolean flag) {
        this.edtNome.setEnabled(flag);
        this.edtCpf.setEnabled(flag);
        this.rdFem.setEnabled(flag);
        this.rdMasc.setEnabled(flag);
        this.edtIdade.setEnabled(flag);
        this.edtTelefone.setEnabled(flag);
        this.edtEmail.setEnabled(flag);
        this.edtCro.setEnabled(flag);
        this.boxSegunda.setEnabled(flag);
        this.boxTerca.setEnabled(flag);
        this.boxQuarta.setEnabled(flag);
        this.boxQuinta.setEnabled(flag);
        this.boxSexta.setEnabled(flag);
        this.edtUsuario.setEnabled(flag);
        this.edtSenha.setEnabled(flag);

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
        this.boxSegunda.setSelected(false);
        this.boxTerca.setSelected(false);
        this.boxQuarta.setSelected(false);
        this.boxQuinta.setSelected(false);
        this.boxSexta.setSelected(false);
        this.edtUsuario.setText(null);
        this.edtSenha.setText(null);
        

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

        if (this.boxSegunda.isSelected()) {
            d.getDias().add(DiasSemana.SEGUNDA);
        }
        if (this.boxTerca.isSelected()) {
            d.getDias().add(DiasSemana.TERCA);
        }
        if (this.boxQuarta.isSelected()) {
            d.getDias().add(DiasSemana.QUARTA);
        }
        if (this.boxQuinta.isSelected()) {
            d.getDias().add(DiasSemana.QUINTA);
        }
        if (this.boxSexta.isSelected()) {
            d.getDias().add(DiasSemana.SEXTA);
        }

        d.setUsuario(this.edtUsuario.getText());
        d.setSenha(this.edtSenha.getText());

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

        for (DiasSemana i : d.getDias()) {

            if (i.equals(DiasSemana.SEGUNDA)) {
                this.boxSegunda.setSelected(true);
            }
            if (i.equals(DiasSemana.TERCA)) {
                this.boxTerca.setSelected(true);
            }
            if (i.equals(DiasSemana.QUARTA)) {
                this.boxQuarta.setSelected(true);
            }
            if (i.equals(DiasSemana.QUINTA)) {
                this.boxQuinta.setSelected(true);
            }
            if (i.equals(DiasSemana.SEXTA)) {
                this.boxSexta.setSelected(true);
            }

        }

        this.edtUsuario.setText(d.getUsuario());
        this.edtSenha.setText(d.getSenha());

    }

    public int buscar(String termo) {
        for (int i = 0; i < this.tmDColaborador.getRowCount(); i++) {
            if (termo.equals(this.tmDColaborador.getLstDColaboradores().get(i).getCro())) {
                return i;
            }
        }
        JOptionPane.showMessageDialog(this, "Dentista Colaborador não cadastrado!");
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
        lblDias = new javax.swing.JLabel();
        boxSegunda = new javax.swing.JCheckBox();
        boxTerca = new javax.swing.JCheckBox();
        boxQuinta = new javax.swing.JCheckBox();
        boxQuarta = new javax.swing.JCheckBox();
        boxSexta = new javax.swing.JCheckBox();
        lblUsuario = new javax.swing.JLabel();
        edtUsuario = new javax.swing.JTextField();
        lblSenha = new javax.swing.JLabel();
        edtSenha = new javax.swing.JPasswordField();
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

        btnGrupoSexo.add(rdFem);
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

        btnGrupoSexo.add(rdMasc);
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

        lblDias.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        lblDias.setText("Dias ");

        boxSegunda.setText("Segunda");

        boxTerca.setText("Terça");

        boxQuinta.setText("Quinta");

        boxQuarta.setText("Quarta");
        boxQuarta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxQuartaActionPerformed(evt);
            }
        });

        boxSexta.setText("Sexta");

        lblUsuario.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        lblUsuario.setText("Usuário");

        edtUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                edtUsuarioKeyReleased(evt);
            }
        });

        lblSenha.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        lblSenha.setText("Senha");

        javax.swing.GroupLayout painel1Layout = new javax.swing.GroupLayout(painel1);
        painel1.setLayout(painel1Layout);
        painel1Layout.setHorizontalGroup(
            painel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painel1Layout.createSequentialGroup()
                        .addComponent(lblTelefone)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(edtTelefone)
                        .addGap(21, 21, 21)
                        .addComponent(lblIdade)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(edtIdade, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painel1Layout.createSequentialGroup()
                        .addGroup(painel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(painel1Layout.createSequentialGroup()
                                .addComponent(lblUsuario)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(edtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblSenha)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(edtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(painel1Layout.createSequentialGroup()
                                .addGroup(painel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblNome)
                                    .addComponent(lblDias)
                                    .addComponent(lblCpf)
                                    .addComponent(lblEmail)
                                    .addComponent(lblSexo))
                                .addGap(33, 33, 33)
                                .addGroup(painel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(painel1Layout.createSequentialGroup()
                                        .addComponent(rdFem)
                                        .addGap(18, 18, 18)
                                        .addComponent(rdMasc)
                                        .addGap(18, 18, 18)
                                        .addComponent(lblCro)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(edtCro))
                                    .addComponent(edtEmail)
                                    .addComponent(edtCpf)
                                    .addGroup(painel1Layout.createSequentialGroup()
                                        .addComponent(boxSegunda)
                                        .addGap(18, 18, 18)
                                        .addComponent(boxTerca)
                                        .addGap(18, 18, 18)
                                        .addComponent(boxQuarta)
                                        .addGap(18, 18, 18)
                                        .addComponent(boxQuinta)
                                        .addGap(18, 18, 18)
                                        .addComponent(boxSexta))
                                    .addComponent(edtNome, javax.swing.GroupLayout.DEFAULT_SIZE, 570, Short.MAX_VALUE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        painel1Layout.setVerticalGroup(
            painel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNome)
                    .addComponent(edtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(painel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCpf)
                    .addComponent(edtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(painel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSexo)
                    .addComponent(rdFem)
                    .addComponent(rdMasc)
                    .addComponent(lblCro)
                    .addComponent(edtCro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(painel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTelefone)
                    .addComponent(edtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(edtIdade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblIdade))
                .addGap(18, 18, 18)
                .addGroup(painel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEmail)
                    .addComponent(edtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(painel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDias)
                    .addComponent(boxSegunda)
                    .addComponent(boxTerca)
                    .addComponent(boxQuarta)
                    .addComponent(boxQuinta)
                    .addComponent(boxSexta))
                .addGap(18, 18, 18)
                .addGroup(painel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUsuario)
                    .addComponent(edtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSenha)
                    .addComponent(edtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(107, Short.MAX_VALUE))
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(painel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
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
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnNovo)
                        .addComponent(btnEditar)
                        .addComponent(btnCancelar)
                        .addComponent(brnExcluir))
                    .addComponent(btnSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(25, 25, 25))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(453, Short.MAX_VALUE)))
        );

        setSize(new java.awt.Dimension(704, 528));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void rdFemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdFemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdFemActionPerformed

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        this.alteracao = false;
        this.habilitarCampos(true);
        this.edtNome.requestFocus();
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed

        int confirm = JOptionPane.showConfirmDialog(this, "Deseja realmente editar?");

        if (confirm == JOptionPane.YES_OPTION) {

            ListaDColaboradores lista = new ListaDColaboradores(this, true);
            lista.setVisible(true);
            DColaborador d = lista.getDentistaSelecionado();

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

        int confirm = JOptionPane.showConfirmDialog(null, "Realmente desejar excluir?");

        if (confirm == JOptionPane.YES_OPTION) {

            ListaDColaboradores lista = new ListaDColaboradores(this, true);
            lista.setVisible(true);
            int i = lista.getIndiceSelecionado();

            this.tmDColaborador.getLstDColaboradores().remove(i);
            this.salvarNoArquivo("src/csv/lst_dcolaboradores.csv");
            JOptionPane.showMessageDialog(null, "Dentista Colaborador excluído!");
            this.tmDColaborador.fireTableDataChanged();
        }
    }//GEN-LAST:event_brnExcluirActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        int confirm = JOptionPane.showConfirmDialog(this, "Deseja realmente salvar?");

        if (confirm == JOptionPane.YES_OPTION) {
            if (this.verificarCamposVazios()) {
                this.salvar();
                if (alteracao) {
                    JOptionPane.showMessageDialog(this, "Cadastro alterado!");
                } else {
                    JOptionPane.showMessageDialog(this, "Cadastro salvo!");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Campo Vazio!");
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

    private void boxQuartaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxQuartaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boxQuartaActionPerformed

    private void edtUsuarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_edtUsuarioKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_edtUsuarioKeyReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox boxQuarta;
    private javax.swing.JCheckBox boxQuinta;
    private javax.swing.JCheckBox boxSegunda;
    private javax.swing.JCheckBox boxSexta;
    private javax.swing.JCheckBox boxTerca;
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
    private javax.swing.JPasswordField edtSenha;
    private javax.swing.JTextField edtTelefone;
    private javax.swing.JTextField edtUsuario;
    private javax.swing.JLabel lblCpf;
    private javax.swing.JLabel lblCro;
    private javax.swing.JLabel lblDias;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblIdade;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblSenha;
    private javax.swing.JLabel lblSexo;
    private javax.swing.JLabel lblTelefone;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JPanel painel1;
    private javax.swing.JRadioButton rdFem;
    private javax.swing.JRadioButton rdMasc;
    // End of variables declaration//GEN-END:variables
}
