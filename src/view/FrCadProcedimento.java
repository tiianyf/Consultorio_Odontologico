package view;

import controller.TMProcedimentos;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.DColaborador;
import model.Paciente;
import model.Procedimento;

public class FrCadProcedimento extends javax.swing.JFrame {

    private TMProcedimentos tmProcedimentos;
    private Procedimento aux;
    private Paciente paciente;
    private List<Procedimento> lstProcedimentos;
    private DColaborador usuarioLogado;

    public FrCadProcedimento() {
        initComponents();

        this.usuarioLogado = new DColaborador();
        this.lstProcedimentos = new ArrayList<>();
        this.paciente = new Paciente();
        this.tmProcedimentos = new TMProcedimentos();
        this.tblProcedimento.setModel(tmProcedimentos);
        this.habilitarCampos(false);

//        String usuario = this.usuarioLogado.getUsuario();
//        String caminho = "src/csv/lst_procedimentos_" + usuario + ".csv";
//        this.carregarArquivo(caminho);
        this.tmProcedimentos.fireTableDataChanged();
        this.btnNovo.requestFocus();
    }

    public DColaborador getUsuarioLogado() {
        return usuarioLogado;
    }

    public void setUsuarioLogado(DColaborador usuarioLogado) {
        this.usuarioLogado = usuarioLogado;
    }

    public List<Procedimento> getLstProcedimentos() {
        return lstProcedimentos;
    }

    public void setLstProcedimentos(List<Procedimento> lstProcedimentos) {
        this.lstProcedimentos = lstProcedimentos;
    }

    public void setTmProcedimentos(TMProcedimentos tmProcedimentos) {
        this.tmProcedimentos = tmProcedimentos;
    }

    public TMProcedimentos getTmProcedimentos() {
        return tmProcedimentos;
    }

    public final void carregarArquivo(String caminho) {

        FileReader arquivo;

        try {

            arquivo = new FileReader(caminho);
            Scanner ler = new Scanner(arquivo);
            ler.useDelimiter("\n");
            ler.next(); // pulando linha do cabeçalho

            while (ler.hasNext()) {

                String linhaCSV = ler.next();
                String[] linha = linhaCSV.split(";");

                Procedimento p = this.conferirTipo(linha);

                p.setInfoCSV(linhaCSV);
                this.tmProcedimentos.addLinha(p);

            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(FrCadProcedimento.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "ERRO! Arquivo não foi carregado.");
        }

    }

    /**
     * Foi-se necessário criar este método pois normalmente, ao ler e obter as
     * informações do arquivo em CSV, instanciamos um objeto auxiliar que lê o
     * arquivo linha a linha (objeto por objeto). Porém, Procedimento é uma
     * classe enum, e não pode ser instanciado sem uma contante (neste caso em
     * específico, um tipo de procedimento), e o nosso objeto auxiliar precisa
     * "mudar de tipo" cada vez que ele lê o arquivo. Então, para cada vez que
     * uma linha do arquivo for lida, o objeto auxiliar será instanciado
     * novamente com um novo tipo, de acordo com o tipo de procedimento salvo no
     * arquivo.
     *
     * @param linha a linha do arquivo que está sendo lida no momento,
     * tranformada em um vetor, em que cada posição representa um atributo da
     * classe Procedimento. O atributo "tipo" está guardado na segunda posição
     * do vetor (índice 1).
     * @return o objeto Procedimento instanciado com o tipo referente ao da
     * linha do arquivo em questão.
     */
    public Procedimento conferirTipo(String[] linha) {

        Procedimento p = null;

        if (linha[1].equals(Procedimento.CLAREAMENTO.getDescricao())) {

            p = Procedimento.CLAREAMENTO;

        } else if (linha[1].equals(Procedimento.ENDODONTIA.getDescricao())) {

            p = Procedimento.ENDODONTIA;

        } else if (linha[1].equals(Procedimento.ENXERTO.getDescricao())) {

            p = Procedimento.ENXERTO;

        } else if (linha[1].equals(Procedimento.IMPLANTE.getDescricao())) {

            p = Procedimento.IMPLANTE;

        } else if (linha[1].equals(Procedimento.PROTESE.getDescricao())) {

            p = Procedimento.PROTESE;

        } else if (linha[1].equals(Procedimento.RASPAGEM.getDescricao())) {

            p = Procedimento.RASPAGEM;

        } else if (linha[1].equals(Procedimento.TRATAMENTO.getDescricao())) {

            p = Procedimento.TRATAMENTO;

        }
        return p;
    }

    public void salvarArquivo(String caminho) {
        try {

            FileWriter arquivo = new FileWriter(caminho);

            try (PrintWriter escrita = new PrintWriter(arquivo)) {

                String info = this.aux.getCabecalhoCSV();

                for (Procedimento p : this.tmProcedimentos.getLstProcedimentos()) {
                    info += p.getInfoCSV();
                }

                escrita.print(info);

            } catch (Exception e) {
            }

        } catch (IOException ex) {

            Logger.getLogger(FrCadProcedimento.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "ERRO! Não foi possível salvar o arquivo.");

        }

    }

    /**
     * Altera a visibilidade dos campos da GUI, de acordo com o parâmetro.
     *
     * @param flag caso true, ativa, caso contrário, desativa.
     */
    private void habilitarCampos(boolean flag) {

        this.boxTipos.setEnabled(flag);
        this.btnBuscaPaciente.setEnabled(flag);
        this.txtNome.setEnabled(flag);
        this.txtCpf.setEnabled(flag);
        this.edtTempo.setEnabled(flag);

        if (!flag) {

            this.limparTodosCampos();

        } else {

            /* forçando a seleção do primeiro tipo de procedimento para que não
            ocorra erro se o usuário clicar primeiro no botão de Buscar Paciente,
            pois caso isso ocorra, o ID aleatório não é carregado */
            boxTipos.setSelectedItem(Procedimento.CLAREAMENTO.getDescricao());
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

        if (this.boxTipos.getSelectedItem().equals("Clareamento dental")) {
            p = Procedimento.CLAREAMENTO;

        } else if (this.boxTipos.getSelectedItem().equals("Tratamento ortodôntico")) {
            p = Procedimento.TRATAMENTO;

        } else if (this.boxTipos.getSelectedItem().equals("Implante")) {
            p = Procedimento.IMPLANTE;

        } else if (this.boxTipos.getSelectedItem().equals("Próteses fixas")) {
            p = Procedimento.IMPLANTE;

        } else if (this.boxTipos.getSelectedItem().equals("Enxerto gengival")) {
            p = Procedimento.ENXERTO;

        } else if (this.boxTipos.getSelectedItem().equals("Periodontia")) {
            p = Procedimento.RASPAGEM;

        } else if (this.boxTipos.getSelectedItem().equals("Endodontia")) {
            p = Procedimento.ENDODONTIA;
        }

        p.setId(this.txtId.getText());
        p.setPaciente(this.paciente);
        p.setTempo(Integer.parseInt((this.edtTempo.getText())));

    }

    /**
     * Copia os atributos do objeto para os campos da GUI.
     *
     * @param p o objeto cujos atributos serão copiados para os campos da GUI.
     */
    public void copiarObjetoParaCampos(Procedimento p) {

        this.txtNome.setText(this.paciente.getNome());
        this.txtCpf.setText(this.paciente.getCpf());
        this.txtId.setText(this.confirmarId().getId());
//        this.edtTempo.setText(Integer.toString(this.aux.getTempo()));

    }

    /**
     * Confirma se o ID do procedimento em questão não está sendo utilizado por
     * outro procedimento dentro da lista (já que o ID é aleatório). Basicamente
     * o método consiste em gerar um novo ID caso ele já tenha sido usado em
     * outro procedimento salvo na lista.
     *
     * @return o procedimento com ID único.
     */
    public Procedimento confirmarId() {

        do {

            String resultado = aux.idAleatorio();
            this.aux.setId(resultado);

        } while (this.existe(this.aux));

        return this.aux;

    }

    /**
     * Verifica se o procedimento em questão já existe dentro da lista.
     * Basicamente verifica se o ID do procedimeto é igual a um outro já
     * existente dentro da lista.
     *
     * @param p o procedimento cuja existência está sendo verificada.
     * @return true caso o ID do procedimento já exista, e false caso contrário.
     */
    public boolean existe(Procedimento p) {

        for (Procedimento proc : this.getLstProcedimentos()) {
            if (proc.getId().equals(p.getId())) {
                return true;
            }
        }
        return false;

    }

    /**
     * Procura o procedimento dentro da lista de procedimentos salvos.
     *
     * @param termo
     * @return o índice (dentro da lista) do procedimento buscado.
     */
    public int buscar(String termo) {

        for (int i = 0; i < this.getTmProcedimentos().getRowCount(); i++) {
            if (termo.equals(this.getTmProcedimentos().getLstProcedimentos().get(i).getId())) {
                return i;
            }
        }

        JOptionPane.showMessageDialog(null, "ID [" + termo + "] não encontrado.");
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
        btnCancelar = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Procedimento");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

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
        btnNovo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                btnNovoFocusGained(evt);
            }
        });
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(186, 186, 186)
                .addComponent(btnNovo)
                .addGap(18, 18, 18)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSalvar)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(painelDados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(btnNovo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSalvar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 13, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(722, 547));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * O tipo de procedimento será definido aqui.
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
        this.boxTipos.requestFocus();
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed

        if (this.verificarCamposVazios()) {
            JOptionPane.showMessageDialog(this, "Favor preencher todos os dados");

        } else {
            int confirmacao = JOptionPane.showConfirmDialog(this, "Deseja realmente salvar?");

            if (confirmacao == JOptionPane.YES_OPTION) {

                this.copiarCamposParaObjeto(this.aux);
                this.tmProcedimentos.addLinha(this.aux);

                this.habilitarCampos(false);
                String caminho = "src/csv/lst_procedimentos_" + this.usuarioLogado.getUsuario() + ".csv";
                this.salvarArquivo(caminho);
                this.tmProcedimentos.fireTableDataChanged();

            }

        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnBuscaPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscaPacienteActionPerformed

        ListaPacientes lista = new ListaPacientes(this, true);

        lista.setVisible(true);
        this.paciente = lista.getPacienteSelecionado();
        this.tmProcedimentos.fireTableDataChanged();

        this.copiarObjetoParaCampos(this.aux);
        this.edtTempo.requestFocus();

    }//GEN-LAST:event_btnBuscaPacienteActionPerformed

    private void btnNovoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_btnNovoFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNovoFocusGained

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
//        String usuario = this.usuarioLogado.getUsuario();
//        String caminho = "src/csv/lst_procedimentos_" + usuario + ".csv";
//        this.carregarArquivo(caminho);
//        System.out.println("Isso tá sendo ativado toda hora");
    }//GEN-LAST:event_formWindowActivated

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> boxTipos;
    private javax.swing.JButton btnBuscaPaciente;
    private javax.swing.JButton btnCancelar;
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
