package views;

import dao.ClienteDao;
import java.awt.Toolkit;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.security.auth.callback.ConfirmationCallback;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import models.Cliente;

public class TelaCliente extends javax.swing.JFrame {

    public TelaCliente() throws SQLException {
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
        txtEndereco.setText("");
        txtCep.setText("");
        txtBusca.setText("");
        
        //levando o foco do cursor para o primeiro campo
        txtNome.grabFocus();
        
        //desabilitar os botões editar e excluir
        btnExcluir.setEnabled(false);
        btnAtualizar.setEnabled(false);
        
        //habilitar os botões adicionar e busca
        btnAdicionar.setEnabled(true);
        btnBusca.setEnabled(true);
        txtBusca.setEnabled(true);
        
        //listar os dados da tebela
        readJTable();
          
    }
    
    public void readJTable() throws SQLException{
        DefaultTableModel modelo = (DefaultTableModel) tblCliente.getModel();
        tblCliente.setRowSorter(new TableRowSorter(modelo));
        modelo.setNumRows(0);//evita a duplicação de dados da view na tabela
        
        ClienteDao clienteDao = new ClienteDao();
        
        for (Cliente cliente: clienteDao.read()){
            modelo.addRow(new Object[]{
            cliente.getId(),       
            cliente.getNome(),
            cliente.getTelefone(),
            cliente.getCep(),
            cliente.getCpf(),
            cliente.getEndereco(),
            cliente.getEmail(),
            cliente.getRg()
            });
        }
    }
        
    public void selecionarItem(){
    if (tblCliente.getSelectedRow() != -1){
            txtId.setText(tblCliente.getValueAt(tblCliente.getSelectedRow(), 0).toString());
            txtNome.setText(tblCliente.getValueAt(tblCliente.getSelectedRow(), 1).toString());
            txtTelefone.setText(tblCliente.getValueAt(tblCliente.getSelectedRow(), 2).toString());
            txtCep.setText(tblCliente.getValueAt(tblCliente.getSelectedRow(), 3).toString());
            txtCpf.setText(tblCliente.getValueAt(tblCliente.getSelectedRow(), 4).toString());
            txtEndereco.setText(tblCliente.getValueAt(tblCliente.getSelectedRow(), 5).toString());
            txtEmail.setText(tblCliente.getValueAt(tblCliente.getSelectedRow(), 6).toString());
            txtRg.setText(tblCliente.getValueAt(tblCliente.getSelectedRow(), 7).toString());
            
            //habilitar os botoes
            btnExcluir.setEnabled(true);
            btnAtualizar.setEnabled(true);
            
            
            //desabilitar os botões
            btnAdicionar.setEnabled(false);
            btnBusca.setEnabled(false);
            txtBusca.setEnabled(false);
            
        }else{
            JOptionPane.showMessageDialog(null, "Selecione um cliente!");
        }
    }
    
            public void readJTableBusca(String busca) throws SQLException{
        DefaultTableModel modelo = (DefaultTableModel) tblCliente.getModel();
        tblCliente.setRowSorter(new TableRowSorter(modelo));
        modelo.setNumRows(0);//evita a duplicação de dados da view na tabela
        
        ClienteDao clienteDao = new ClienteDao();
        
        for (Cliente cliente: clienteDao.readBusca(busca)){
            modelo.addRow(new Object[]{
            cliente.getId(),       
            cliente.getNome(),
            cliente.getCep(),
            cliente.getCpf(),
            cliente.getTelefone(),
            cliente.getEndereco(),
            cliente.getEmail(),
            cliente.getRg()
            });
        }        
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCliente = new javax.swing.JTable();
        btnBusca = new javax.swing.JToggleButton();
        btnAdicionar = new javax.swing.JToggleButton();
        btnExcluir = new javax.swing.JToggleButton();
        btnAtualizar = new javax.swing.JToggleButton();
        btnLimpar = new javax.swing.JToggleButton();
        txtBusca = new javax.swing.JTextField();
        txtNome = new javax.swing.JTextField();
        txtId = new javax.swing.JTextField();
        txtEndereco = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        btnFechar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtTelefone = new javax.swing.JFormattedTextField();
        txtCep = new javax.swing.JFormattedTextField();
        txtRg = new javax.swing.JFormattedTextField();
        txtCpf = new javax.swing.JFormattedTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("CLIENTES");

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "NOME", "TELEFONE", "EMAIL", "CEP", "ENDERECO", "RG", "CPF"
            }
        ));
        tblCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblClienteMouseClicked(evt);
            }
        });
        tblCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblClienteKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tblCliente);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 300, 610, 140));

        btnBusca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/zoom.png"))); // NOI18N
        btnBusca.setText("PESQUISAR");
        btnBusca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscaActionPerformed(evt);
            }
        });
        btnBusca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnBuscaKeyPressed(evt);
            }
        });
        jPanel1.add(btnBusca, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 40, 140, 30));

        btnAdicionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/add.png"))); // NOI18N
        btnAdicionar.setText("ADICIONAR");
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAdicionar, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 260, 140, 30));

        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/delete.png"))); // NOI18N
        btnExcluir.setText("EXCLUIR");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });
        jPanel1.add(btnExcluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 260, 130, 30));

        btnAtualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pencil.png"))); // NOI18N
        btnAtualizar.setText("ATUALIZAR");
        btnAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAtualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 260, 120, 30));

        btnLimpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/limpar.png"))); // NOI18N
        btnLimpar.setText("LIMPAR");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });
        jPanel1.add(btnLimpar, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 260, 120, 30));

        txtBusca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscaActionPerformed(evt);
            }
        });
        txtBusca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBuscaKeyPressed(evt);
            }
        });
        jPanel1.add(txtBusca, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 40, 270, -1));

        txtNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeActionPerformed(evt);
            }
        });
        jPanel1.add(txtNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 100, 410, -1));

        txtId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdActionPerformed(evt);
            }
        });
        jPanel1.add(txtId, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, 40, -1));
        jPanel1.add(txtEndereco, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 150, 280, -1));
        jPanel1.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 200, 310, -1));

        btnFechar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/house_go.png"))); // NOI18N
        btnFechar.setText("FECHAR");
        btnFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharActionPerformed(evt);
            }
        });
        jPanel1.add(btnFechar, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 440, 110, -1));

        jLabel3.setText("ID");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 80, -1, -1));

        jLabel4.setText("NOME");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 80, -1, -1));

        jLabel5.setText("TELEFONE");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 130, -1, -1));

        jLabel6.setText("ENDEREÇO");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 130, -1, -1));

        jLabel7.setText("CEP");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 130, -1, -1));

        jLabel8.setText("EMAIL");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 180, -1, -1));

        jLabel9.setText("RG");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 180, -1, -1));

        try {
            txtTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)#####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jPanel1.add(txtTelefone, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 150, 160, -1));

        try {
            txtCep.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jPanel1.add(txtCep, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 150, 100, -1));

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
        jPanel1.add(txtRg, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 200, 100, -1));

        try {
            txtCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jPanel1.add(txtCpf, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 200, 130, -1));

        jLabel10.setText("CPF");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 180, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/transparencia.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 720, 450));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/fundoInterno.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 500));

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
            .addGap(0, 500, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscaActionPerformed
        try {
            readJTableBusca(txtBusca.getText());
        } catch (SQLException ex) {
            System.out.println("Erro na Busca: " + ex);
        }
    }//GEN-LAST:event_btnBuscaActionPerformed

    private void txtBuscaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscaActionPerformed

    private void txtNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeActionPerformed

    private void txtIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdActionPerformed

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
        TelaCliente.this.dispose();
    }//GEN-LAST:event_btnFecharActionPerformed

    private void txtBuscaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscaKeyPressed
        try {
            readJTableBusca(txtBusca.getText());
        } catch (SQLException ex) {
            System.out.println("Erro na Busca: " + ex);
        }
    }//GEN-LAST:event_txtBuscaKeyPressed

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
        if(!txtNome.getText().isEmpty() && !txtCep.getText().isEmpty() && !txtCpf.getText().isEmpty() && !txtTelefone.getText().isEmpty() && !txtEndereco.getText().isEmpty() && !txtEmail.getText().isEmpty() && !txtRg.getText().isEmpty()){
            
            //instancia os objetos servico e dao
            Cliente cliente = new Cliente();
            ClienteDao dao = new ClienteDao();
            
            //seta os campos da tabela
            cliente.setNome(txtNome.getText());
            cliente.setCep(txtCep.getText());
            cliente.setCpf(txtCpf.getText());
            cliente.setTelefone(txtTelefone.getText());
            cliente.setEndereco(txtEndereco.getText());
            cliente.setEmail(txtEmail.getText());
            cliente.setRg(txtRg.getText());
            
            try {
                 dao.create(cliente);
           
                limpar();
            } catch (SQLException ex) {
                System.out.println("Erro ao acessar o banco de dados. "
                + "Entre em contato com o administrador do sistema" + ex);
            }
        }else{
            JOptionPane.showMessageDialog(null, 
                    "Informe os dados do cliente!");
            txtNome.grabFocus();
        }
    }//GEN-LAST:event_btnAdicionarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        if (tblCliente.getSelectedRow() != -1){
            int resp = JOptionPane.showConfirmDialog(null, "confiemar Exclusão?", "Exclusão do Campo", ConfirmationCallback.OK_CANCEL_OPTION);
             if(resp == 0){
             
                try {

                    Cliente cliente = new Cliente();
                    ClienteDao dao = new ClienteDao();
                    cliente.setId((int)tblCliente.getValueAt(tblCliente.getSelectedRow(),0));
                    
                    dao.delete(cliente);
                    limpar();
                } catch (SQLException ex) {
                    Logger.getLogger(TelaCliente.class.getName()).log(Level.SEVERE, null, ex);
                }
             }
                
        }else{
            JOptionPane.showMessageDialog(null, "Selecione um cliente");
        }
            
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarActionPerformed
       if (tblCliente.getSelectedRow() != -1){
            
            try {
                
                Cliente cliente = new Cliente();
               ClienteDao dao = new ClienteDao();
                
                //seta (mudar) os campos do objeto servico
                cliente.setNome(txtNome.getText());
                    cliente.setCep(txtCep.getText());
                    cliente.setCpf(txtCpf.getText());
                    cliente.setTelefone(txtTelefone.getText());
                    cliente.setEndereco(txtEndereco.getText());
                    cliente.setEmail(txtEmail.getText());
                    cliente.setRg(txtRg.getText());
                     cliente.setId((int)tblCliente.getValueAt(tblCliente.getSelectedRow(),0));
                     
                try {
                    //atualizar o banco
                    dao.update(cliente);
                } catch (SQLException ex) {
                    Logger.getLogger(TelaCliente.class.getName()).log(Level.SEVERE, null, ex);
                }
                //limpar os campos
                limpar();
            } catch (SQLException ex) {
                Logger.getLogger(TelaCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
            
           
        }else{
             JOptionPane.showMessageDialog(null, "Selecione um cliente");
                   
       }
    }//GEN-LAST:event_btnAtualizarActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        try {
            limpar();
        } catch (SQLException ex) {
            Logger.getLogger(TelaCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnLimparActionPerformed

    private void txtRgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRgActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRgActionPerformed

    private void btnBuscaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnBuscaKeyPressed
        try {
            readJTableBusca(txtBusca.getText());
        } catch (SQLException ex) {
            System.out.println("Erro na Busca: " + ex);
        }
    }//GEN-LAST:event_btnBuscaKeyPressed

    private void tblClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblClienteMouseClicked
       selecionarItem();
    }//GEN-LAST:event_tblClienteMouseClicked

    private void tblClienteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblClienteKeyReleased
        selecionarItem();
    }//GEN-LAST:event_tblClienteKeyReleased


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
            java.util.logging.Logger.getLogger(TelaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new TelaCliente().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(TelaCliente.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnAdicionar;
    private javax.swing.JToggleButton btnAtualizar;
    private javax.swing.JToggleButton btnBusca;
    private javax.swing.JToggleButton btnExcluir;
    private javax.swing.JButton btnFechar;
    private javax.swing.JToggleButton btnLimpar;
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
    private javax.swing.JTable tblCliente;
    private javax.swing.JTextField txtBusca;
    private javax.swing.JFormattedTextField txtCep;
    private javax.swing.JFormattedTextField txtCpf;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtEndereco;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNome;
    private javax.swing.JFormattedTextField txtRg;
    private javax.swing.JFormattedTextField txtTelefone;
    // End of variables declaration//GEN-END:variables
}
