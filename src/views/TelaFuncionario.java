package views;

import dao.FuncionarioDao;
import java.awt.Toolkit;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.security.auth.callback.ConfirmationCallback;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import models.Funcionario;

public class TelaFuncionario extends javax.swing.JFrame {

    public TelaFuncionario() throws SQLException {
        initComponents();
        setIcon();
        txtNome.grabFocus();
        readJTable();
    }
    
     private void setIcon(){
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("../imagens/cut.png")));
    }
     
    public void limpar() throws SQLException{
        //limpar os campos
        txtId.setText("");
        txtNome.setText("");
        txtTelefone.setText("");
        txtEmail.setText("");
        txtRg.setText("");
        txtCpf.setText("");
        txtSalario.setText("");
        txtBuscar.setText("");
        
        
        //levando o foco do cursor para o primeiro campo
        txtNome.grabFocus();
        
        //desabilitar os botões editar e excluir
        btnExcluir.setEnabled(false);
        btnAtualizar.setEnabled(false);
        
        //habilitar os botões adicionar e busca
        btnAdicionar.setEnabled(true);
        btnBuscar.setEnabled(true);
        txtBuscar.setEnabled(true);
        
        //listar os dados da tebela
        readJTable();
          
    }
    
     public void readJTable() throws SQLException{
        DefaultTableModel modelo = (DefaultTableModel) tblFuncionario.getModel();
        tblFuncionario.setRowSorter(new TableRowSorter(modelo));
        modelo.setNumRows(0);//evita a duplicação de dados da view na tabela
        
        FuncionarioDao funcionarioDao = new FuncionarioDao();
        
        for (Funcionario funcionario: funcionarioDao.read()){
            modelo.addRow(new Object[]{
                funcionario.getId(),
                funcionario.getNome(),
                funcionario.getTelefone(),
                funcionario.getEmail(),
                funcionario.getRg(),
                funcionario.getCpf(),
                funcionario.getSalario()
            });
        }        
    }
     
    public void selecionarItem(){
    if (tblFuncionario.getSelectedRow() != -1){
            txtId.setText(tblFuncionario.getValueAt(tblFuncionario.getSelectedRow(), 0).toString());
            txtNome.setText(tblFuncionario.getValueAt(tblFuncionario.getSelectedRow(), 1).toString());
            txtTelefone.setText(tblFuncionario.getValueAt(tblFuncionario.getSelectedRow(), 2).toString());
            txtEmail.setText(tblFuncionario.getValueAt(tblFuncionario.getSelectedRow(), 3).toString());
            txtRg.setText(tblFuncionario.getValueAt(tblFuncionario.getSelectedRow(), 4).toString());
            txtCpf.setText(tblFuncionario.getValueAt(tblFuncionario.getSelectedRow(), 5).toString());
            txtSalario.setText(tblFuncionario.getValueAt(tblFuncionario.getSelectedRow(), 6).toString());
                        
            //habilitar os botoes
            btnExcluir.setEnabled(true);
            btnAtualizar.setEnabled(true);
            
            
            //desabilitar os botões
            btnAdicionar.setEnabled(false);
            btnBuscar.setEnabled(false);
            txtBuscar.setEnabled(false);
            
        }else{
            JOptionPane.showMessageDialog(null, "Selecione um serviço!");
        }
    }
    
    public void readJTableBusca(String busca) throws SQLException{
        DefaultTableModel modelo = (DefaultTableModel) tblFuncionario.getModel();
        tblFuncionario.setRowSorter(new TableRowSorter(modelo));
        modelo.setNumRows(0);//evita a duplicação de dados da view na tabela
        
        FuncionarioDao FuncionarioDao = new FuncionarioDao();
        
        for (Funcionario funcionario: FuncionarioDao.readBusca(busca)){
            modelo.addRow(new Object[]{
                funcionario.getNome(),
                funcionario.getTelefone(),
                funcionario.getEmail(),
                funcionario.getRg(),
                funcionario.getCpf(),
                funcionario.getSalario()
            });
        }        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtBuscar = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        txtNome = new javax.swing.JTextField();
        txtId = new javax.swing.JTextField();
        btnAdicionar = new javax.swing.JButton();
        txtSalario = new javax.swing.JTextField();
        btnExcluir = new javax.swing.JButton();
        btnAtualizar = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        txtEmail = new javax.swing.JTextField();
        btnFechar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblFuncionario = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtRg = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtTelefone = new javax.swing.JFormattedTextField();
        txtCep = new javax.swing.JFormattedTextField();
        txtCpf = new javax.swing.JFormattedTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("FUNCIONARIO");
        setResizable(false);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarActionPerformed(evt);
            }
        });
        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBuscarKeyPressed(evt);
            }
        });
        jPanel1.add(txtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 60, 310, -1));

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/zoom.png"))); // NOI18N
        btnBuscar.setText("PESQUISAR");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        btnBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnBuscarKeyPressed(evt);
            }
        });
        jPanel1.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 50, 120, 30));
        jPanel1.add(txtNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 112, 410, 30));
        jPanel1.add(txtId, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 110, 60, 30));

        btnAdicionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/add.png"))); // NOI18N
        btnAdicionar.setText("ADICIONAR");
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAdicionar, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 300, 130, 30));

        txtSalario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSalarioActionPerformed(evt);
            }
        });
        jPanel1.add(txtSalario, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 170, 130, 30));

        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/delete.png"))); // NOI18N
        btnExcluir.setText("EXCLUIR");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });
        jPanel1.add(btnExcluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 300, 130, 30));

        btnAtualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pencil.png"))); // NOI18N
        btnAtualizar.setText("ATUALIZAR");
        btnAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAtualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 300, 130, 30));

        btnLimpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/limpar.png"))); // NOI18N
        btnLimpar.setText("LIMPAR");
        jPanel1.add(btnLimpar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 302, 120, 30));
        jPanel1.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 230, 260, -1));

        btnFechar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/house_go.png"))); // NOI18N
        btnFechar.setText("FECHAR");
        btnFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharActionPerformed(evt);
            }
        });
        jPanel1.add(btnFechar, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 480, -1, -1));

        tblFuncionario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "id", "NOME", "TELEFONE", "EMAIL", "RG", "CPF", "SALARIO"
            }
        ));
        tblFuncionario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblFuncionarioMouseClicked(evt);
            }
        });
        tblFuncionario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblFuncionarioKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tblFuncionario);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 340, 690, 130));

        jLabel3.setText("NOME");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 90, -1, -1));

        jLabel4.setText("ID");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 90, -1, -1));

        try {
            txtRg.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-#")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtRg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRgActionPerformed(evt);
            }
        });
        jPanel1.add(txtRg, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 230, 120, -1));

        jLabel5.setText("SALARIO");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 150, -1, 20));

        jLabel6.setText("TELEFONE");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 150, -1, -1));

        jLabel7.setText("CEP");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 150, -1, -1));

        jLabel8.setText("EMAIL");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 210, -1, -1));

        jLabel9.setText("RG");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 210, -1, -1));

        jLabel10.setText("CPF");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 210, -1, -1));

        try {
            txtTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)#####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtTelefone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefoneActionPerformed(evt);
            }
        });
        jPanel1.add(txtTelefone, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 170, 160, 30));

        try {
            txtCep.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jPanel1.add(txtCep, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 170, 120, 30));

        try {
            txtCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCpf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCpfActionPerformed(evt);
            }
        });
        jPanel1.add(txtCpf, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 230, 140, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/transparencia.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 730, 490));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/fundoInterno.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 600));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarActionPerformed

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
        if(!txtNome.getText().isEmpty() && !txtTelefone.getText().isEmpty() && !txtEmail.getText().isEmpty() && !txtRg.getText().isEmpty() && !txtCpf.getText().isEmpty() && !txtSalario.getText().isEmpty()){
            
            //instancia os objetos servico e dao
            Funcionario funcionario = new Funcionario();
            FuncionarioDao dao = new FuncionarioDao();
            
            //seta os campos da tabela
            funcionario.setNome(txtNome.getText());
            funcionario.setTelefone(txtTelefone.getText());
            funcionario.setEmail(txtEmail.getText());
            funcionario.setRg(txtRg.getText());
            funcionario.setCpf(txtCpf.getText());
            funcionario.setSalario(Float.parseFloat(txtSalario.getText()));
            
            try {
                dao.create(funcionario);
            } catch (SQLException ex) {
                System.out.println("Erro ao acessar o banco de dados. "
                + "Entre em contato com o administrador do sistema" + ex);
            }
            
            try {
                limpar();
            } catch (SQLException ex) {
                System.out.println("Erro ao acessar o banco de dados. "
                + "Entre em contato com o administrador do sistema" + ex);
            }
        }else{
            JOptionPane.showMessageDialog(null, 
                    "Informe os dados do funcionario!");
            txtNome.grabFocus();
        }
    }//GEN-LAST:event_btnAdicionarActionPerformed

    private void txtRgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRgActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRgActionPerformed

    private void txtTelefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefoneActionPerformed

    private void txtCpfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCpfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCpfActionPerformed

    private void txtSalarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSalarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSalarioActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        try {
            readJTableBusca(txtBuscar.getText());
        } catch (SQLException ex) {
            System.out.println("Erro na Busca: " + ex);
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
        TelaFuncionario.this.dispose();
    }//GEN-LAST:event_btnFecharActionPerformed

    private void btnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarActionPerformed
       if (tblFuncionario.getSelectedRow() != -1){
            
            try {
                
                Funcionario funcionario = new Funcionario();
                FuncionarioDao dao = new FuncionarioDao();
                
                //seta (mudar) os campos do objeto servico
                funcionario.setNome(txtNome.getText());
                funcionario.setTelefone(txtTelefone.getText());
                funcionario.setEmail(txtEmail.getText());
                funcionario.setRg(txtRg.getText());
                funcionario.setCpf(txtCpf.getText());
                funcionario.setSalario(Float.parseFloat(txtSalario.getText()));
                
                try {
                    //atualizar o banco
                    dao.update(funcionario);
                } catch (SQLException ex) {
                    Logger.getLogger(TelaServico.class.getName()).log(Level.SEVERE, null, ex);
                }
                //limpar os campos
                limpar();
            } catch (SQLException ex) {
                Logger.getLogger(TelaFuncionario.class.getName()).log(Level.SEVERE, null, ex);
            }
            
           
        }else{
             JOptionPane.showMessageDialog(null, "Selecione um funcionário");
            
        }
    }//GEN-LAST:event_btnAtualizarActionPerformed

    private void btnBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnBuscarKeyPressed
        try {
            readJTableBusca(txtBuscar.getText());
        } catch (SQLException ex) {
            System.out.println("Erro na Busca: " + ex);
        }

    }//GEN-LAST:event_btnBuscarKeyPressed

    private void tblFuncionarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblFuncionarioMouseClicked
         selecionarItem();
    }//GEN-LAST:event_tblFuncionarioMouseClicked

    private void tblFuncionarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblFuncionarioKeyReleased
         selecionarItem();
    }//GEN-LAST:event_tblFuncionarioKeyReleased

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        if (tblFuncionario.getSelectedRow() != -1){
            int resp = JOptionPane.showConfirmDialog(null, "confiemar Exclusão?", "Exclusão do Campo", ConfirmationCallback.OK_CANCEL_OPTION);
             if(resp == 0){
             
                try {

                    Funcionario funcionario = new Funcionario();
                    FuncionarioDao dao = new FuncionarioDao();
                    funcionario.setId((int)tblFuncionario.getValueAt(tblFuncionario.getSelectedRow(),0));
                    
                    try {
                        dao.delete(funcionario);
                    } catch (SQLException ex) {
                        Logger.getLogger(TelaServico.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    limpar();
                } catch (SQLException ex) {
                    Logger.getLogger(TelaServico.class.getName()).log(Level.SEVERE, null, ex);
                }
             }
                
        }else{
            JOptionPane.showMessageDialog(null, "Selecione um funcionário");
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void txtBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyPressed
        try {
            readJTableBusca(txtBuscar.getText());
        } catch (SQLException ex) {
            System.out.println("Erro na Busca: " + ex);
        }
    }//GEN-LAST:event_txtBuscarKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new TelaFuncionario().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(TelaFuncionario.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnAtualizar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblFuncionario;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JFormattedTextField txtCep;
    private javax.swing.JFormattedTextField txtCpf;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNome;
    private javax.swing.JFormattedTextField txtRg;
    private javax.swing.JTextField txtSalario;
    private javax.swing.JFormattedTextField txtTelefone;
    // End of variables declaration//GEN-END:variables
}
