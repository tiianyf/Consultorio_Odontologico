package view;

import controller.TMPacientes;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Paciente;

public class FrCadPaciente extends javax.swing.JFrame {

    private final TMPacientes tmPaciente;
    private boolean alteracao;
    private int indiceSelecionado;

    public FrCadPaciente() {
        initComponents();
        
        this.indiceSelecionado = -1;
        this.tmPaciente = new TMPacientes();
        this.alteracao = false;
        this.habilitarCampos(false);
        this.carregarArquivo("src/csv/lst_pacientes.csv");
        this.tmPaciente.fireTableDataChanged();
    }

    /**
     * @return the indiceSelecionado
     */
    public int getIndiceSelecionado() {
        return indiceSelecionado;
    }

    /**
     * @param indiceSelecionado the indiceSelecionado to set
     */
    public void setIndiceSelecionado(int indiceSelecionado) {
        this.indiceSelecionado = indiceSelecionado;
    }

    public final void habilitarCampos(boolean flag) {
        this.edtNome.setEnabled(flag);
        this.edtCpf.setEnabled(flag);
        this.rdFem.setEnabled(flag);
        this.rdMasc.setEnabled(flag);
        this.edtIdade.setEnabled(flag);
        this.edtTipoSanguineo.setEnabled(flag);
        this.edtTelefone.setEnabled(flag);
        this.edtEmail.setEnabled(flag);
        this.rdFSim.setEnabled(flag);
        this.rdFNao.setEnabled(flag);
        this.rdDSim.setEnabled(flag);
        this.rdDNao.setEnabled(flag);
        this.edtAlergia.setEnabled(flag);
        this.edtDoenca.setEnabled(flag);

        if (!flag) {

            this.edtNome.setText(null);
            this.edtCpf.setText(null);
            this.rdFem.setSelected(flag);
            this.rdMasc.setSelected(flag);
            this.edtIdade.setText(null);
            this.edtTipoSanguineo.setText(null);
            this.edtTelefone.setText(null);
            this.edtEmail.setText(null);
            this.rdFSim.setSelected(flag);
            this.rdFNao.setSelected(flag);
            this.rdDSim.setSelected(flag);
            this.rdDNao.setSelected(flag);
            this.edtAlergia.setText(null);
            this.edtDoenca.setText(null);
        }
    }

    public boolean verificarCamposVazios() {
        return this.edtNome.getText().isEmpty()
                || this.edtCpf.getText().isEmpty()
                || (this.rdFem.isSelected() || this.rdMasc.isSelected())
                || this.edtIdade.getText().isEmpty()
                || this.edtTipoSanguineo.getText().isEmpty()
                || this.edtTelefone.getText().isEmpty()
                || (this.rdFSim.isSelected() || this.rdFNao.isSelected())
                || (this.rdDSim.isSelected() || this.rdDNao.isSelected())
                || this.edtAlergia.getText().isEmpty()
                || this.edtDoenca.getText().isEmpty();
    }

    public void copiarCamposParaClasse(Paciente p) {
        p.setNome(this.edtNome.getText());
        p.setCpf(this.edtCpf.getText());

        if (this.rdFem.isSelected()) {
            p.setSexo('F');
        } else if (this.rdMasc.isSelected()) {
            p.setSexo('M');
        }
        p.setIdade(Integer.parseInt(this.edtIdade.getText()));
        p.setTipoSanguineo(this.edtTipoSanguineo.getText());
        p.setTelefone(this.edtTelefone.getText());
        p.setEmail(this.edtEmail.getText());

        if (this.rdFSim.isSelected()) {
            p.setFumante(true);
        } else if (this.rdFNao.isSelected()) {
            p.setFumante(false);
        } else if (this.rdDSim.isSelected()) {
            p.setDiabetico(true);
        } else if (this.rdDNao.isSelected()) {
            p.setDiabetico(false);
        }
        p.setAlergia(this.edtAlergia.getText());
        p.setDoenca(this.edtDoenca.getText());
    }

    public void copiarClasseParaCampos(Paciente p) {
        this.edtNome.setText(p.getNome());
        this.edtCpf.setText(p.getCpf());

        if (p.getSexo() == 'F' || p.getSexo() == 'f') {
            this.rdFem.setSelected(true);
        } else if (p.getSexo() == 'M' || p.getSexo() == 'm') {
            this.rdMasc.setSelected(true);
        }
        this.edtIdade.setText(p.getIdade() + "");
        this.edtTipoSanguineo.setText(p.getTipoSanguineo());
        this.edtTelefone.setText(p.getTelefone());
        this.edtEmail.setText(p.getEmail());

        if (p.isFumante()) {
            this.rdFSim.setSelected(true);
        } else if (!p.isFumante()) {
            this.rdFNao.setSelected(true);
        } else if (p.isDiabetico()) {
            this.rdDSim.setSelected(true);
        } else if (!p.isDiabetico()) {
            this.rdDNao.setSelected(true);
        }
        this.edtAlergia.setText(p.getAlergia());
        this.edtDoenca.setText(p.getDoenca());
    }

    public int buscar(String cpf) {
        for (int i = 0; i < this.tmPaciente.getRowCount(); i++) {
            if (cpf.equals(this.tmPaciente.getLstPacientes().get(i).getCpf())) {
                return i;
            }
        }
        JOptionPane.showMessageDialog(null, "Paciente não cadastrado!");
        return -1;
    }

    public boolean existe(Paciente paciente) {
        for (Paciente p : this.tmPaciente.getLstPacientes()) {
            if (p.getCpf().equals(paciente.getCpf())) {
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
                Paciente p = new Paciente();
                p.setInfoCSV(linhaCsv);
                this.tmPaciente.addLinha(p);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FrCadPaciente.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "ERRO! Arquivo não foi carregado.");
        }
    }

    public void salvarArquivo(String caminho) {

        try {
            FileWriter arquivo = new FileWriter(caminho);

            try (PrintWriter escrita = new PrintWriter(arquivo)) {
                Paciente aux = new Paciente();
                String info = aux.getCabecalhoCSV();
                for (Paciente p : this.tmPaciente.getLstPacientes()) {
                    info += p.getInfoCSV();

                }
                escrita.print(info);
            } catch (Exception e) {
            }

        } catch (IOException ex) {
            Logger.getLogger(FrCadPaciente.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "ERRO! Não foi possível salvar o arquivo.");
        }

    }

    public void salvar() {
        Paciente p = new Paciente();
        this.copiarCamposParaClasse(p);

        if (this.alteracao) {
            this.tmPaciente.getLstPacientes().set(this.buscar(p.getCpf()), p);
        } else {
            if (this.existe(p)) {
                JOptionPane.showMessageDialog(null, "CPF já existe!");
            } else {
                this.tmPaciente.addLinha(p);
            }
        }
        this.salvarArquivo("src/csv/lst_pacientes.csv");
        this.tmPaciente.fireTableDataChanged();
        this.habilitarCampos(false);
    }

    public void mostrarTabela() {
        for (Paciente p : this.tmPaciente.getLstPacientes()) {
            this.tmPaciente.addLinha(p);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGrupoSexo = new javax.swing.ButtonGroup();
        bntGrupoFumante = new javax.swing.ButtonGroup();
        btnGrupoDiabetico = new javax.swing.ButtonGroup();
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
        lblTipoSanguineo = new javax.swing.JLabel();
        edtTipoSanguineo = new javax.swing.JTextField();
        lblTelefone = new javax.swing.JLabel();
        edtTelefone = new javax.swing.JTextField();
        lblEmail = new javax.swing.JLabel();
        edtEmail = new javax.swing.JTextField();
        painel2 = new javax.swing.JPanel();
        lblFumante = new javax.swing.JLabel();
        rdFSim = new javax.swing.JRadioButton();
        rdFNao = new javax.swing.JRadioButton();
        lblDiabetico = new javax.swing.JLabel();
        rdDSim = new javax.swing.JRadioButton();
        rdDNao = new javax.swing.JRadioButton();
        lblAlergia = new javax.swing.JLabel();
        edtAlergia = new javax.swing.JTextField();
        lblDoenca = new javax.swing.JLabel();
        edtDoenca = new javax.swing.JTextField();
        btnNovo = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        brnExcluir = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        lblTitulo = new javax.swing.JLabel();
        lblInfo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro Paciente");

        painel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        painel1.setLayout(null);

        lblNome.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        lblNome.setText("Nome");
        painel1.add(lblNome);
        lblNome.setBounds(17, 24, 42, 17);

        lblCpf.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        lblCpf.setText("CPF");
        painel1.add(lblCpf);
        lblCpf.setBounds(17, 49, 26, 17);

        edtNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtNomeActionPerformed(evt);
            }
        });
        edtNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                edtNomeKeyReleased(evt);
            }
        });
        painel1.add(edtNome);
        edtNome.setBounds(92, 23, 559, 19);

        edtCpf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                edtCpfKeyReleased(evt);
            }
        });
        painel1.add(edtCpf);
        edtCpf.setBounds(92, 48, 559, 19);

        lblSexo.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        lblSexo.setText("Sexo");
        painel1.add(lblSexo);
        lblSexo.setBounds(17, 82, 35, 17);

        btnGrupoSexo.add(rdFem);
        rdFem.setFont(new java.awt.Font("DejaVu Sans", 1, 12)); // NOI18N
        rdFem.setText("Feminino");
        rdFem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdFemActionPerformed(evt);
            }
        });
        painel1.add(rdFem);
        rdFem.setBounds(92, 79, 88, 23);

        btnGrupoSexo.add(rdMasc);
        rdMasc.setFont(new java.awt.Font("DejaVu Sans", 1, 12)); // NOI18N
        rdMasc.setText("Masculino");
        painel1.add(rdMasc);
        rdMasc.setBounds(180, 79, 93, 23);

        lblIdade.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        lblIdade.setText("Idade");
        painel1.add(lblIdade);
        lblIdade.setBounds(291, 82, 40, 17);

        edtIdade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtIdadeActionPerformed(evt);
            }
        });
        edtIdade.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                edtIdadeKeyReleased(evt);
            }
        });
        painel1.add(edtIdade);
        edtIdade.setBounds(343, 81, 43, 19);

        lblTipoSanguineo.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        lblTipoSanguineo.setText("Tipo Sanguíneo");
        painel1.add(lblTipoSanguineo);
        lblTipoSanguineo.setBounds(404, 80, 111, 17);

        edtTipoSanguineo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtTipoSanguineoActionPerformed(evt);
            }
        });
        edtTipoSanguineo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                edtTipoSanguineoKeyReleased(evt);
            }
        });
        painel1.add(edtTipoSanguineo);
        edtTipoSanguineo.setBounds(527, 79, 124, 19);

        lblTelefone.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        lblTelefone.setText("Telefone");
        painel1.add(lblTelefone);
        lblTelefone.setBounds(17, 113, 63, 17);

        edtTelefone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                edtTelefoneKeyReleased(evt);
            }
        });
        painel1.add(edtTelefone);
        edtTelefone.setBounds(92, 112, 181, 19);

        lblEmail.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        lblEmail.setText("Email");
        painel1.add(lblEmail);
        lblEmail.setBounds(17, 150, 40, 17);

        edtEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                edtEmailKeyReleased(evt);
            }
        });
        painel1.add(edtEmail);
        edtEmail.setBounds(92, 149, 559, 19);

        painel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblFumante.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        lblFumante.setText("Fumante");

        bntGrupoFumante.add(rdFSim);
        rdFSim.setFont(new java.awt.Font("DejaVu Sans", 1, 12)); // NOI18N
        rdFSim.setText("Sim");

        bntGrupoFumante.add(rdFNao);
        rdFNao.setFont(new java.awt.Font("DejaVu Sans", 1, 12)); // NOI18N
        rdFNao.setText("Não");

        lblDiabetico.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        lblDiabetico.setText("Diabético");

        btnGrupoDiabetico.add(rdDSim);
        rdDSim.setFont(new java.awt.Font("DejaVu Sans", 1, 12)); // NOI18N
        rdDSim.setText("Sim");

        btnGrupoDiabetico.add(rdDNao);
        rdDNao.setFont(new java.awt.Font("DejaVu Sans", 1, 12)); // NOI18N
        rdDNao.setText("Não");

        lblAlergia.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        lblAlergia.setText("Alergia");

        edtAlergia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                edtAlergiaKeyReleased(evt);
            }
        });

        lblDoenca.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        lblDoenca.setText("Doença");

        edtDoenca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                edtDoencaKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout painel2Layout = new javax.swing.GroupLayout(painel2);
        painel2.setLayout(painel2Layout);
        painel2Layout.setHorizontalGroup(
            painel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painel2Layout.createSequentialGroup()
                        .addComponent(lblAlergia)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(edtAlergia))
                    .addGroup(painel2Layout.createSequentialGroup()
                        .addComponent(lblFumante)
                        .addGap(18, 18, 18)
                        .addComponent(rdFSim)
                        .addGap(18, 18, 18)
                        .addComponent(rdFNao)
                        .addGap(89, 89, 89)
                        .addComponent(lblDiabetico)
                        .addGap(18, 18, 18)
                        .addComponent(rdDSim)
                        .addGap(20, 20, 20)
                        .addComponent(rdDNao)
                        .addGap(0, 152, Short.MAX_VALUE))
                    .addGroup(painel2Layout.createSequentialGroup()
                        .addComponent(lblDoenca)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(edtDoenca)))
                .addContainerGap())
        );
        painel2Layout.setVerticalGroup(
            painel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(painel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(rdDSim)
                        .addComponent(lblDiabetico))
                    .addComponent(rdDNao)
                    .addGroup(painel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblFumante)
                        .addComponent(rdFSim)
                        .addComponent(rdFNao)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(edtAlergia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAlergia))
                .addGap(18, 18, 18)
                .addGroup(painel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(edtDoenca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDoenca))
                .addContainerGap(36, Short.MAX_VALUE))
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

        lblTitulo.setFont(new java.awt.Font("DejaVu Sans", 1, 18)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("PACIENTE");
        lblTitulo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        lblInfo.setFont(new java.awt.Font("DejaVu Sans", 1, 15)); // NOI18N
        lblInfo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblInfo.setText("INFORMAÇÕES COMPLEMENTARES");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblInfo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(painel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(painel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addContainerGap()
                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(painel1, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(painel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNovo)
                    .addComponent(btnEditar)
                    .addComponent(btnCancelar)
                    .addComponent(brnExcluir)
                    .addComponent(btnSalvar))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(712, 572));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        this.habilitarCampos(true);
        this.alteracao = false;
        this.edtNome.requestFocus();
    }//GEN-LAST:event_btnNovoActionPerformed

    private void rdFemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdFemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdFemActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.habilitarCampos(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed

        int confirm = JOptionPane.showConfirmDialog(null, "Deseja realmente editar os dados?");

        if (confirm == JOptionPane.YES_OPTION) {

            ListaPacientes lista = new ListaPacientes(this, true);
            lista.setVisible(true);
            Paciente p = lista.getPacienteSelecionado();

            this.alteracao = true;
            this.copiarClasseParaCampos(p);
            this.habilitarCampos(true);

        } else if (confirm == JOptionPane.NO_OPTION) {

            this.btnCancelarActionPerformed(evt);
        }


    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        int confirm = JOptionPane.showConfirmDialog(null, "Deseja realmente salvar?");
        if (confirm == JOptionPane.YES_OPTION) {
            if (this.verificarCamposVazios()) {
                this.salvar();
            } else {
                JOptionPane.showMessageDialog(this, "Campo vazio!");
            }
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void brnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_brnExcluirActionPerformed

        int confirm = JOptionPane.showConfirmDialog(this, "Realmente deseja excluir?");

        if (confirm == JOptionPane.YES_OPTION) {

            ListaPacientes lista = new ListaPacientes(this, true);
            lista.setVisible(true);
            Paciente p = lista.getPacienteSelecionado();
            int i = lista.getIndiceSelecionado();
            
            this.tmPaciente.getLstPacientes().remove(i);
            this.salvarArquivo("src/csv/lst_pacientes.csv");
            JOptionPane.showMessageDialog(this, "Paciente excluído!");
            this.tmPaciente.fireTableDataChanged();
            
        } else {
            
            this.btnCancelarActionPerformed(evt);
            
        }
    }//GEN-LAST:event_brnExcluirActionPerformed

    private void edtCpfKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_edtCpfKeyReleased
        if (evt.getKeyChar() == java.awt.event.KeyEvent.VK_ENTER) {
            this.rdFem.requestFocus();
        }
    }//GEN-LAST:event_edtCpfKeyReleased

    private void edtNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edtNomeActionPerformed

    private void edtNomeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_edtNomeKeyReleased
        if (evt.getKeyChar() == java.awt.event.KeyEvent.VK_ENTER) {
            this.edtCpf.requestFocus();
        }
    }//GEN-LAST:event_edtNomeKeyReleased

    private void edtIdadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtIdadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edtIdadeActionPerformed

    private void edtIdadeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_edtIdadeKeyReleased
        if (evt.getKeyChar() == java.awt.event.KeyEvent.VK_ENTER) {
            this.edtTipoSanguineo.requestFocus();
        }
    }//GEN-LAST:event_edtIdadeKeyReleased

    private void edtTipoSanguineoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtTipoSanguineoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edtTipoSanguineoActionPerformed

    private void edtTipoSanguineoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_edtTipoSanguineoKeyReleased
        if (evt.getKeyChar() == java.awt.event.KeyEvent.VK_ENTER) {
            this.edtTelefone.requestFocus();
        }
    }//GEN-LAST:event_edtTipoSanguineoKeyReleased

    private void edtTelefoneKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_edtTelefoneKeyReleased
        if (evt.getKeyChar() == java.awt.event.KeyEvent.VK_ENTER) {
            this.edtEmail.requestFocus();
        }
    }//GEN-LAST:event_edtTelefoneKeyReleased

    private void edtEmailKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_edtEmailKeyReleased
        if (evt.getKeyChar() == java.awt.event.KeyEvent.VK_ENTER) {
            this.rdFSim.requestFocus();
        }
    }//GEN-LAST:event_edtEmailKeyReleased

    private void edtAlergiaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_edtAlergiaKeyReleased
        if (evt.getKeyChar() == java.awt.event.KeyEvent.VK_ENTER) {
            this.edtDoenca.requestFocus();
        }
    }//GEN-LAST:event_edtAlergiaKeyReleased

    private void edtDoencaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_edtDoencaKeyReleased
        if (evt.getKeyChar() == java.awt.event.KeyEvent.VK_ENTER) {
            this.btnSalvar.requestFocus();
        }
    }//GEN-LAST:event_edtDoencaKeyReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bntGrupoFumante;
    private javax.swing.JButton brnExcluir;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditar;
    private javax.swing.ButtonGroup btnGrupoDiabetico;
    private javax.swing.ButtonGroup btnGrupoSexo;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JTextField edtAlergia;
    private javax.swing.JTextField edtCpf;
    private javax.swing.JTextField edtDoenca;
    private javax.swing.JTextField edtEmail;
    private javax.swing.JTextField edtIdade;
    private javax.swing.JTextField edtNome;
    private javax.swing.JTextField edtTelefone;
    private javax.swing.JTextField edtTipoSanguineo;
    private javax.swing.JLabel lblAlergia;
    private javax.swing.JLabel lblCpf;
    private javax.swing.JLabel lblDiabetico;
    private javax.swing.JLabel lblDoenca;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblFumante;
    private javax.swing.JLabel lblIdade;
    private javax.swing.JLabel lblInfo;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblSexo;
    private javax.swing.JLabel lblTelefone;
    private javax.swing.JLabel lblTipoSanguineo;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel painel1;
    private javax.swing.JPanel painel2;
    private javax.swing.JRadioButton rdDNao;
    private javax.swing.JRadioButton rdDSim;
    private javax.swing.JRadioButton rdFNao;
    private javax.swing.JRadioButton rdFSim;
    private javax.swing.JRadioButton rdFem;
    private javax.swing.JRadioButton rdMasc;
    // End of variables declaration//GEN-END:variables
}
