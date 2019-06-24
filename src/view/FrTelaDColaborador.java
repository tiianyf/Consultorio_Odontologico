package view;

import model.DColaborador;

public final class FrTelaDColaborador extends javax.swing.JFrame {

    private DColaborador dentista; // dentista logado

    public FrTelaDColaborador() {
        initComponents();
        this.habilitarBotoes();

        this.dentista = new DColaborador();
    }

    public DColaborador getDentista() {
        return dentista;
    }

    public void setDentista(DColaborador dentista) {
        this.dentista = dentista;
    }

    public void habilitarBotoes() {
        this.btnPainelInternoDColaborador.setEnabled(false);
        this.btnPainelInternoFuncionario.setEnabled(false);
        this.btnTelaInternaAgenda.setEnabled(false);
        this.btnPainelInternoPaciente.setEnabled(false);
        this.subMenuCadCliente.setEnabled(false);
        this.subMenuCadDColaborador.setEnabled(false);
        this.subMenuCadFuncionarios.setEnabled(false);
        this.subMenuCadProprietario.setEnabled(false);
        this.subMenuLstFuncionarios.setEnabled(false);
        this.subMenuAgendar.setEnabled(false);
        this.subMenuLstAgendamentos.setEnabled(false);

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
        subMenuCadCliente = new javax.swing.JMenuItem();
        subMenuCadFuncionarios = new javax.swing.JMenuItem();
        subMenuCadProcedimento = new javax.swing.JMenuItem();
        subMenuCadDColaborador = new javax.swing.JMenuItem();
        subMenuCadProprietario = new javax.swing.JMenuItem();
        menuAgenda = new javax.swing.JMenu();
        subMenuAgendar = new javax.swing.JMenuItem();
        subMenuLstAgendamentos = new javax.swing.JMenuItem();
        menuConsultar = new javax.swing.JMenu();
        subMenuLstPacientes = new javax.swing.JMenuItem();
        subMenuLstFuncionarios = new javax.swing.JMenuItem();
        subMenuLstProcedimentos = new javax.swing.JMenuItem();
        menuCaixa = new javax.swing.JMenu();
        menuBoasVindas = new javax.swing.JMenu();
        subMenuBoasVindas = new javax.swing.JMenuItem();
        menuSair = new javax.swing.JMenu();
        subMenuSairSistema = new javax.swing.JMenuItem();

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

        subMenuCadCliente.setText("Paciente");
        subMenuCadCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subMenuCadClienteActionPerformed(evt);
            }
        });
        menuCadastro.add(subMenuCadCliente);

        subMenuCadFuncionarios.setText("Funcionários");
        subMenuCadFuncionarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subMenuCadFuncionariosActionPerformed(evt);
            }
        });
        menuCadastro.add(subMenuCadFuncionarios);

        subMenuCadProcedimento.setText("Procedimento");
        subMenuCadProcedimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subMenuCadProcedimentoActionPerformed(evt);
            }
        });
        menuCadastro.add(subMenuCadProcedimento);

        subMenuCadDColaborador.setText("Dentista Colaborador");
        subMenuCadDColaborador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subMenuCadDColaboradorActionPerformed(evt);
            }
        });
        menuCadastro.add(subMenuCadDColaborador);

        subMenuCadProprietario.setText("Proprietário");
        subMenuCadProprietario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subMenuCadProprietarioActionPerformed(evt);
            }
        });
        menuCadastro.add(subMenuCadProprietario);

        menuPrincipal.add(menuCadastro);

        menuAgenda.setText("Agenda");

        subMenuAgendar.setText("Marcar Horário");
        subMenuAgendar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subMenuAgendarActionPerformed(evt);
            }
        });
        menuAgenda.add(subMenuAgendar);

        subMenuLstAgendamentos.setText("Lista de Agendamentos");
        menuAgenda.add(subMenuLstAgendamentos);

        menuPrincipal.add(menuAgenda);

        menuConsultar.setText("Consulta");

        subMenuLstPacientes.setText("Lista de Pacientes");
        subMenuLstPacientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subMenuLstPacientesActionPerformed(evt);
            }
        });
        menuConsultar.add(subMenuLstPacientes);

        subMenuLstFuncionarios.setText("Lista de Funcionários");
        subMenuLstFuncionarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subMenuLstFuncionariosActionPerformed(evt);
            }
        });
        menuConsultar.add(subMenuLstFuncionarios);

        subMenuLstProcedimentos.setText("Lista de Procedimentos");
        subMenuLstProcedimentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subMenuLstProcedimentosActionPerformed(evt);
            }
        });
        menuConsultar.add(subMenuLstProcedimentos);

        menuPrincipal.add(menuConsultar);

        menuCaixa.setText("Caixa");
        menuPrincipal.add(menuCaixa);

        menuBoasVindas.setText("Ferramentas");

        subMenuBoasVindas.setText("Tela Bem Vindo");
        subMenuBoasVindas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subMenuBoasVindasActionPerformed(evt);
            }
        });
        menuBoasVindas.add(subMenuBoasVindas);

        menuPrincipal.add(menuBoasVindas);

        menuSair.setText("Sair");

        subMenuSairSistema.setText("Sair do Sistema");
        subMenuSairSistema.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subMenuSairSistemaActionPerformed(evt);
            }
        });
        menuSair.add(subMenuSairSistema);

        menuPrincipal.add(menuSair);

        setJMenuBar(menuPrincipal);

        setSize(new java.awt.Dimension(885, 482));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void subMenuSairSistemaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subMenuSairSistemaActionPerformed
        System.exit(0);
    }//GEN-LAST:event_subMenuSairSistemaActionPerformed

    private void btnTelaInternaSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTelaInternaSairActionPerformed
        telaInterna.dispose();
    }//GEN-LAST:event_btnTelaInternaSairActionPerformed

    private void subMenuBoasVindasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subMenuBoasVindasActionPerformed
        FrTelaDColaborador tela = new FrTelaDColaborador();
        tela.setVisible(true);
        dispose();
    }//GEN-LAST:event_subMenuBoasVindasActionPerformed

    private void btnPainelInternoPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPainelInternoPacienteActionPerformed
        FrCadPaciente tela = new FrCadPaciente();
        tela.setVisible(true);
    }//GEN-LAST:event_btnPainelInternoPacienteActionPerformed

    private void subMenuCadClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subMenuCadClienteActionPerformed
        FrCadPaciente tela = new FrCadPaciente();
        tela.setVisible(true);
    }//GEN-LAST:event_subMenuCadClienteActionPerformed

    private void subMenuCadFuncionariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subMenuCadFuncionariosActionPerformed
        FrCadFuncionario tela = new FrCadFuncionario();
        tela.setVisible(true);
    }//GEN-LAST:event_subMenuCadFuncionariosActionPerformed

    private void btnPainelInternoFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPainelInternoFuncionarioActionPerformed
        FrCadFuncionario tela = new FrCadFuncionario();
        tela.setVisible(true);
    }//GEN-LAST:event_btnPainelInternoFuncionarioActionPerformed

    private void btnPainelInternoProcedimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPainelInternoProcedimentoActionPerformed
        FrCadProcedimento tela = new FrCadProcedimento();
        tela.setUsuarioLogado(this.dentista);
        tela.setVisible(true);
    }//GEN-LAST:event_btnPainelInternoProcedimentoActionPerformed

    private void subMenuCadProcedimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subMenuCadProcedimentoActionPerformed
        FrCadProcedimento tela = new FrCadProcedimento();
        tela.setUsuarioLogado(this.dentista);
        tela.setVisible(true);
    }//GEN-LAST:event_subMenuCadProcedimentoActionPerformed

    private void btnPainelInternoDColaboradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPainelInternoDColaboradorActionPerformed
        FrCadDentistaColaborador tela = new FrCadDentistaColaborador();
        tela.setVisible(true);
    }//GEN-LAST:event_btnPainelInternoDColaboradorActionPerformed

    private void subMenuCadDColaboradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subMenuCadDColaboradorActionPerformed
        FrCadDentistaColaborador tela = new FrCadDentistaColaborador();
        tela.setVisible(true);
    }//GEN-LAST:event_subMenuCadDColaboradorActionPerformed

    private void subMenuCadProprietarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subMenuCadProprietarioActionPerformed
        FrCadDentista tela = new FrCadDentista();
        tela.setVisible(true);
    }//GEN-LAST:event_subMenuCadProprietarioActionPerformed

    private void subMenuAgendarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subMenuAgendarActionPerformed
        FrAgenda tela = new FrAgenda();
        tela.setVisible(true);
    }//GEN-LAST:event_subMenuAgendarActionPerformed

    private void subMenuLstPacientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subMenuLstPacientesActionPerformed
        ListaPacientes tela = new ListaPacientes(this, true);
        tela.setVisible(true);

    }//GEN-LAST:event_subMenuLstPacientesActionPerformed

    private void subMenuLstFuncionariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subMenuLstFuncionariosActionPerformed
        FrListaFuncionarios tela = new FrListaFuncionarios();
        tela.setVisible(true);
    }//GEN-LAST:event_subMenuLstFuncionariosActionPerformed

    private void btnTelaInternaAgendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTelaInternaAgendaActionPerformed

    }//GEN-LAST:event_btnTelaInternaAgendaActionPerformed

    private void subMenuLstProcedimentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subMenuLstProcedimentosActionPerformed
        ListaProcedimentos tela = new ListaProcedimentos(this, true);
        tela.setUsuarioLogado(this.dentista);
        System.out.println(tela.getUsuarioLogado().getUsuario());
        tela.setVisible(true);
    }//GEN-LAST:event_subMenuLstProcedimentosActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPainelInternoDColaborador;
    private javax.swing.JButton btnPainelInternoFuncionario;
    private javax.swing.JButton btnPainelInternoPaciente;
    private javax.swing.JButton btnPainelInternoProcedimento;
    private javax.swing.JButton btnTelaInternaAgenda;
    private javax.swing.JButton btnTelaInternaSair;
    private javax.swing.JLabel lblCaracteristica;
    private javax.swing.JLabel lblFundoPainelInterno;
    private javax.swing.JLabel lblPainelInternoCadastro;
    private javax.swing.JLabel lblTelaDeFundo;
    private javax.swing.JLabel lblTelaInternaAgenda;
    private javax.swing.JMenu menuAgenda;
    private javax.swing.JMenu menuBoasVindas;
    private javax.swing.JMenu menuCadastro;
    private javax.swing.JMenu menuCaixa;
    private javax.swing.JMenu menuConsultar;
    private javax.swing.JMenuBar menuPrincipal;
    private javax.swing.JMenu menuSair;
    private javax.swing.JPanel painelInterno;
    private javax.swing.JMenuItem subMenuAgendar;
    private javax.swing.JMenuItem subMenuBoasVindas;
    private javax.swing.JMenuItem subMenuCadCliente;
    private javax.swing.JMenuItem subMenuCadDColaborador;
    private javax.swing.JMenuItem subMenuCadFuncionarios;
    private javax.swing.JMenuItem subMenuCadProcedimento;
    private javax.swing.JMenuItem subMenuCadProprietario;
    private javax.swing.JMenuItem subMenuLstAgendamentos;
    private javax.swing.JMenuItem subMenuLstFuncionarios;
    private javax.swing.JMenuItem subMenuLstPacientes;
    private javax.swing.JMenuItem subMenuLstProcedimentos;
    private javax.swing.JMenuItem subMenuSairSistema;
    private javax.swing.JInternalFrame telaInterna;
    // End of variables declaration//GEN-END:variables
}
