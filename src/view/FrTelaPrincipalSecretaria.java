package view;

public final class FrTelaPrincipalSecretaria extends javax.swing.JFrame {

    public FrTelaPrincipalSecretaria() {
        initComponents();
        this.habilitarBotoes();
    }

    public void habilitarBotoes() {
        this.btnPainelInternoDColaborador.setEnabled(false);
        this.btnPainelInternoProcedimento.setEnabled(false);
        this.btnPainelInternoFuncionario.setEnabled(false);
        this.menuCadDColaborador.setEnabled(false);
        this.menuCadFuncionarios.setEnabled(false);
        this.menuCadProprietario.setEnabled(false);
        this.menuCadFuncionarios.setEnabled(false);
        this.menuCadProcedimento.setEnabled(false);
        this.subMenuLstProcedimentos.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        telaInterna = new javax.swing.JInternalFrame();
        lblCaracteristica = new javax.swing.JLabel();
        btnTelaInternaSair = new javax.swing.JButton();
        painelInterno = new javax.swing.JPanel();
        lblTelaInternaAgenda = new javax.swing.JLabel();
        btnTelaInternaAgenda = new javax.swing.JButton();
        btnPainelInternoDColaborador = new javax.swing.JButton();
        btnPainelInternoProcedimento = new javax.swing.JButton();
        btnPainelInternoFuncionario = new javax.swing.JButton();
        btnPainelInternoPaciente = new javax.swing.JButton();
        lblPainelInternoCadastro = new javax.swing.JLabel();
        lblFundoPainelInterno = new javax.swing.JLabel();
        lblTelaDeFundo = new javax.swing.JLabel();
        menuPrincipal = new javax.swing.JMenuBar();
        menuCadastro = new javax.swing.JMenu();
        menuCadCliente = new javax.swing.JMenuItem();
        menuCadFuncionarios = new javax.swing.JMenuItem();
        menuCadProcedimento = new javax.swing.JMenuItem();
        menuCadDColaborador = new javax.swing.JMenuItem();
        menuCadProprietario = new javax.swing.JMenuItem();
        menuAgenda = new javax.swing.JMenu();
        menuAgendar = new javax.swing.JMenuItem();
        menuConsultar = new javax.swing.JMenu();
        menuLstPacientes = new javax.swing.JMenuItem();
        menuLstFuncionarios = new javax.swing.JMenuItem();
        subMenuLstProcedimentos = new javax.swing.JMenuItem();
        menuCaixa = new javax.swing.JMenu();
        menuBoasVindas = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        menuSair = new javax.swing.JMenu();
        menuSairSistema = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Consultório Odontológico");
        getContentPane().setLayout(null);

        telaInterna.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        telaInterna.setTitle("Bem Vindo");
        telaInterna.setVisible(true);
        telaInterna.getContentPane().setLayout(null);

        lblCaracteristica.setFont(new java.awt.Font("DejaVu Sans", 0, 18)); // NOI18N
        lblCaracteristica.setText("Sistema de Gerenciamento de:");
        telaInterna.getContentPane().add(lblCaracteristica);
        lblCaracteristica.setBounds(10, 10, 370, 40);

        btnTelaInternaSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/close.png"))); // NOI18N
        btnTelaInternaSair.setToolTipText("Fechar Bem-Vindo");
        btnTelaInternaSair.setContentAreaFilled(false);
        btnTelaInternaSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTelaInternaSairActionPerformed(evt);
            }
        });
        telaInterna.getContentPane().add(btnTelaInternaSair);
        btnTelaInternaSair.setBounds(820, 10, 30, 40);

        painelInterno.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        painelInterno.setLayout(null);

        lblTelaInternaAgenda.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        lblTelaInternaAgenda.setText("Agendamento:");
        painelInterno.add(lblTelaInternaAgenda);
        lblTelaInternaAgenda.setBounds(670, 10, 130, 20);

        btnTelaInternaAgenda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/agenda.png"))); // NOI18N
        btnTelaInternaAgenda.setToolTipText("Agenda");
        btnTelaInternaAgenda.setContentAreaFilled(false);
        btnTelaInternaAgenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTelaInternaAgendaActionPerformed(evt);
            }
        });
        painelInterno.add(btnTelaInternaAgenda);
        btnTelaInternaAgenda.setBounds(670, 80, 98, 100);

        btnPainelInternoDColaborador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/avatar.png"))); // NOI18N
        btnPainelInternoDColaborador.setToolTipText("Dentista Colaborador");
        btnPainelInternoDColaborador.setContentAreaFilled(false);
        btnPainelInternoDColaborador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPainelInternoDColaboradorActionPerformed(evt);
            }
        });
        painelInterno.add(btnPainelInternoDColaborador);
        btnPainelInternoDColaborador.setBounds(240, 80, 98, 100);

        btnPainelInternoProcedimento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/health-report2.png"))); // NOI18N
        btnPainelInternoProcedimento.setToolTipText("Procedimento");
        btnPainelInternoProcedimento.setContentAreaFilled(false);
        btnPainelInternoProcedimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPainelInternoProcedimentoActionPerformed(evt);
            }
        });
        painelInterno.add(btnPainelInternoProcedimento);
        btnPainelInternoProcedimento.setBounds(350, 80, 98, 100);

        btnPainelInternoFuncionario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/funcionario.png"))); // NOI18N
        btnPainelInternoFuncionario.setToolTipText("Funcionário");
        btnPainelInternoFuncionario.setContentAreaFilled(false);
        btnPainelInternoFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPainelInternoFuncionarioActionPerformed(evt);
            }
        });
        painelInterno.add(btnPainelInternoFuncionario);
        btnPainelInternoFuncionario.setBounds(130, 80, 100, 100);

        btnPainelInternoPaciente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/paciente.png"))); // NOI18N
        btnPainelInternoPaciente.setToolTipText("Paciente");
        btnPainelInternoPaciente.setContentAreaFilled(false);
        btnPainelInternoPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPainelInternoPacienteActionPerformed(evt);
            }
        });
        painelInterno.add(btnPainelInternoPaciente);
        btnPainelInternoPaciente.setBounds(20, 80, 98, 100);

        lblPainelInternoCadastro.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        lblPainelInternoCadastro.setText("Cadastro :");
        painelInterno.add(lblPainelInternoCadastro);
        lblPainelInternoCadastro.setBounds(20, 10, 100, 17);

        lblFundoPainelInterno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/fundoPainelInterno.jpg"))); // NOI18N
        lblFundoPainelInterno.setToolTipText("");
        painelInterno.add(lblFundoPainelInterno);
        lblFundoPainelInterno.setBounds(10, -5, 880, 280);

        lblTelaDeFundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/fundoTelaPrincipal.jpg"))); // NOI18N
        painelInterno.add(lblTelaDeFundo);
        lblTelaDeFundo.setBounds(0, 0, 880, 460);

        telaInterna.getContentPane().add(painelInterno);
        painelInterno.setBounds(-10, 60, 890, 280);

        getContentPane().add(telaInterna);
        telaInterna.setBounds(0, 70, 880, 390);

        menuCadastro.setText("Cadastro");

        menuCadCliente.setText("Paciente");
        menuCadCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCadClienteActionPerformed(evt);
            }
        });
        menuCadastro.add(menuCadCliente);

        menuCadFuncionarios.setText("Funcionários");
        menuCadFuncionarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCadFuncionariosActionPerformed(evt);
            }
        });
        menuCadastro.add(menuCadFuncionarios);

        menuCadProcedimento.setText("Procedimento");
        menuCadProcedimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCadProcedimentoActionPerformed(evt);
            }
        });
        menuCadastro.add(menuCadProcedimento);

        menuCadDColaborador.setText("Dentista Colaborador");
        menuCadDColaborador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCadDColaboradorActionPerformed(evt);
            }
        });
        menuCadastro.add(menuCadDColaborador);

        menuCadProprietario.setText("Proprietário");
        menuCadProprietario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCadProprietarioActionPerformed(evt);
            }
        });
        menuCadastro.add(menuCadProprietario);

        menuPrincipal.add(menuCadastro);

        menuAgenda.setText("Agenda");

        menuAgendar.setText("Marcar Horário");
        menuAgendar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAgendarActionPerformed(evt);
            }
        });
        menuAgenda.add(menuAgendar);

        menuPrincipal.add(menuAgenda);

        menuConsultar.setText("Consulta");

        menuLstPacientes.setText("Lista de Pacientes");
        menuLstPacientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuLstPacientesActionPerformed(evt);
            }
        });
        menuConsultar.add(menuLstPacientes);

        menuLstFuncionarios.setText("Lista de Funcionários");
        menuConsultar.add(menuLstFuncionarios);

        subMenuLstProcedimentos.setText("Lista de Procedimentos");
        menuConsultar.add(subMenuLstProcedimentos);

        menuPrincipal.add(menuConsultar);

        menuCaixa.setText("Caixa");
        menuPrincipal.add(menuCaixa);

        menuBoasVindas.setText("Ferramentas");

        jMenuItem1.setText("Tela Bem Vindo");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        menuBoasVindas.add(jMenuItem1);

        menuPrincipal.add(menuBoasVindas);

        menuSair.setText("Sair");

        menuSairSistema.setText("Sair do Sistema");
        menuSairSistema.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSairSistemaActionPerformed(evt);
            }
        });
        menuSair.add(menuSairSistema);

        menuPrincipal.add(menuSair);

        setJMenuBar(menuPrincipal);

        setSize(new java.awt.Dimension(885, 482));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void menuSairSistemaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSairSistemaActionPerformed
        System.exit(0);
    }//GEN-LAST:event_menuSairSistemaActionPerformed

    private void btnTelaInternaSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTelaInternaSairActionPerformed
        telaInterna.dispose();
    }//GEN-LAST:event_btnTelaInternaSairActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        FrTelaPrincipalSecretaria tela = new FrTelaPrincipalSecretaria();
        tela.setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void btnPainelInternoPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPainelInternoPacienteActionPerformed
        FrCadPaciente tela = new FrCadPaciente();
        tela.setVisible(true);
    }//GEN-LAST:event_btnPainelInternoPacienteActionPerformed

    private void menuCadClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCadClienteActionPerformed
        FrCadPaciente tela = new FrCadPaciente();
        tela.setVisible(true);
    }//GEN-LAST:event_menuCadClienteActionPerformed

    private void menuCadFuncionariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCadFuncionariosActionPerformed
        FrCadFuncionario tela = new FrCadFuncionario();
        tela.setVisible(true);
    }//GEN-LAST:event_menuCadFuncionariosActionPerformed

    private void btnPainelInternoFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPainelInternoFuncionarioActionPerformed
    }//GEN-LAST:event_btnPainelInternoFuncionarioActionPerformed

    private void btnPainelInternoProcedimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPainelInternoProcedimentoActionPerformed
    }//GEN-LAST:event_btnPainelInternoProcedimentoActionPerformed

    private void menuCadProcedimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCadProcedimentoActionPerformed
        FrCadProcedimento tela = new FrCadProcedimento();
        tela.setVisible(true);
    }//GEN-LAST:event_menuCadProcedimentoActionPerformed

    private void btnPainelInternoDColaboradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPainelInternoDColaboradorActionPerformed
    }//GEN-LAST:event_btnPainelInternoDColaboradorActionPerformed

    private void menuCadDColaboradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCadDColaboradorActionPerformed
        FrCadDentistaColaborador tela = new FrCadDentistaColaborador();
        tela.setVisible(true);
    }//GEN-LAST:event_menuCadDColaboradorActionPerformed

    private void menuCadProprietarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCadProprietarioActionPerformed
        FrCadDentista tela = new FrCadDentista();
        tela.setVisible(true);
    }//GEN-LAST:event_menuCadProprietarioActionPerformed

    private void menuAgendarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAgendarActionPerformed
        FrAgenda tela = new FrAgenda();
        tela.setVisible(true);
    }//GEN-LAST:event_menuAgendarActionPerformed

    private void menuLstPacientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuLstPacientesActionPerformed
        ListaPacientes tela = new ListaPacientes(this, true);
        tela.setVisible(true);
    }//GEN-LAST:event_menuLstPacientesActionPerformed

    private void btnTelaInternaAgendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTelaInternaAgendaActionPerformed
        FrAgenda tela = new FrAgenda();
        tela.setVisible(true);
    }//GEN-LAST:event_btnTelaInternaAgendaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPainelInternoDColaborador;
    private javax.swing.JButton btnPainelInternoFuncionario;
    private javax.swing.JButton btnPainelInternoPaciente;
    private javax.swing.JButton btnPainelInternoProcedimento;
    private javax.swing.JButton btnTelaInternaAgenda;
    private javax.swing.JButton btnTelaInternaSair;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JLabel lblCaracteristica;
    private javax.swing.JLabel lblFundoPainelInterno;
    private javax.swing.JLabel lblPainelInternoCadastro;
    private javax.swing.JLabel lblTelaDeFundo;
    private javax.swing.JLabel lblTelaInternaAgenda;
    private javax.swing.JMenu menuAgenda;
    private javax.swing.JMenuItem menuAgendar;
    private javax.swing.JMenu menuBoasVindas;
    private javax.swing.JMenuItem menuCadCliente;
    private javax.swing.JMenuItem menuCadDColaborador;
    private javax.swing.JMenuItem menuCadFuncionarios;
    private javax.swing.JMenuItem menuCadProcedimento;
    private javax.swing.JMenuItem menuCadProprietario;
    private javax.swing.JMenu menuCadastro;
    private javax.swing.JMenu menuCaixa;
    private javax.swing.JMenu menuConsultar;
    private javax.swing.JMenuItem menuLstFuncionarios;
    private javax.swing.JMenuItem menuLstPacientes;
    private javax.swing.JMenuBar menuPrincipal;
    private javax.swing.JMenu menuSair;
    private javax.swing.JMenuItem menuSairSistema;
    private javax.swing.JPanel painelInterno;
    private javax.swing.JMenuItem subMenuLstProcedimentos;
    private javax.swing.JInternalFrame telaInterna;
    // End of variables declaration//GEN-END:variables
}
