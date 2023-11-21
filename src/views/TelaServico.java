package views;

import dao.ServicoDao;
import java.awt.Toolkit;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.security.auth.callback.ConfirmationCallback;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import models.Servico;

public class TelaServico extends javax.swing.JFrame {

    public TelaServico() throws SQLException {
        initComponents();
        setIcon();
        txtDescricao.grabFocus();
        readJTable();
    }
    
    private void setIcon(){
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("../imagens/cut.png")));
    }
    
    public void limpar() throws SQLException{
        //limpar os campos
        txtId.setText("");
        txtDescricao.setText("");
        txtValor.setText("");
        txtBusca.setText("");
        
        //levando o foco do cursor para o primeiro campo
        txtDescricao.grabFocus();
        
        //desabilitar os botões editar e excluir
        btnExcluir.setEnabled(false);
        btnAtualizar.setEnabled(false);
        
        //habilitar os botões adicionar e busca
        btnAdicionar.setEnabled(true);
        btnBuscar.setEnabled(true);
        txtBusca.setEnabled(true);
        
        //listar os dados da tebela
        readJTable();
          
    }
    
    public void readJTable() throws SQLException{
        DefaultTableModel modelo = (DefaultTableModel) tblServico.getModel();
        tblServico.setRowSorter(new TableRowSorter(modelo));
        modelo.setNumRows(0);//evita a duplicação de dados da view na tabela
        
        ServicoDao servicoDao = new ServicoDao();
        
        for (Servico servico: servicoDao.read()){
            modelo.addRow(new Object[]{
                servico.getId(),
                servico.getDescricao(),
                servico.getValor()
            });
        }        
    }
    
    public void selecionarItem(){
    if (tblServico.getSelectedRow() != -1){
            txtId.setText(tblServico.getValueAt(tblServico.getSelectedRow(), 0).toString());
            txtDescricao.setText(tblServico.getValueAt(tblServico.getSelectedRow(), 1).toString());
            txtValor.setText(tblServico.getValueAt(tblServico.getSelectedRow(), 2).toString());
            
            //habilitar os botoes
            btnExcluir.setEnabled(true);
            btnAtualizar.setEnabled(true);
            
            
            //desabilitar os botões
            btnAdicionar.setEnabled(false);
            btnBuscar.setEnabled(false);
            txtBusca.setEnabled(false);
            
        }else{
            JOptionPane.showMessageDialog(null, "Selecione um serviço!");
        }}
    
    public void readJTableBusca(String busca) throws SQLException{
        DefaultTableModel modelo = (DefaultTableModel) tblServico.getModel();
        tblServico.setRowSorter(new TableRowSorter(modelo));
        modelo.setNumRows(0);//evita a duplicação de dados da view na tabela
        
        ServicoDao servicoDao = new ServicoDao();
        
        for (Servico servico: servicoDao.readBusca(busca)){
            modelo.addRow(new Object[]{
                servico.getId(),
                servico.getDescricao(),
                servico.getValor()
            });
        }        
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtBusca = new javax.swing.JTextField();
        txtId = new javax.swing.JTextField();
        txtDescricao = new javax.swing.JTextField();
        txtValor = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        btnFechar = new javax.swing.JButton();
        btnAdicionar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnAtualizar = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblServico = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("SERVIÇOS");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        jPanel1.add(txtBusca, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 60, 190, 30));

        txtId.setEnabled(false);
        txtId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdActionPerformed(evt);
            }
        });
        jPanel1.add(txtId, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 130, 50, 30));

        txtDescricao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDescricaoActionPerformed(evt);
            }
        });
        jPanel1.add(txtDescricao, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 130, 340, 30));

        txtValor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtValorActionPerformed(evt);
            }
        });
        jPanel1.add(txtValor, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 130, 210, 30));

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/zoom.png"))); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        jPanel1.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 60, 100, 30));

        btnFechar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/house_go.png"))); // NOI18N
        btnFechar.setText("Fechar");
        btnFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharActionPerformed(evt);
            }
        });
        jPanel1.add(btnFechar, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 180, 100, 30));

        btnAdicionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/add.png"))); // NOI18N
        btnAdicionar.setText("Adicionar");
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAdicionar, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 180, 110, 30));

        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/delete.png"))); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.setEnabled(false);
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });
        jPanel1.add(btnExcluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 180, 110, 30));

        btnAtualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pencil.png"))); // NOI18N
        btnAtualizar.setText("Atualizar");
        btnAtualizar.setEnabled(false);
        btnAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAtualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 180, 110, 30));

        btnLimpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/limpar.png"))); // NOI18N
        btnLimpar.setText("Limpar");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });
        jPanel1.add(btnLimpar, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 180, 100, 30));

        tblServico.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Descrição", "Valor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblServico.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblServicoMouseClicked(evt);
            }
        });
        tblServico.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblServicoKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tblServico);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 240, 620, 190));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("Valor");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 110, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Descrição");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 110, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("ID");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/transparencia.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 720, 420));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/fundoInterno.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 500));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 500));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
       TelaServico.this.dispose();
    }//GEN-LAST:event_btnFecharActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        try {
            limpar();
        } catch (SQLException ex) {
            Logger.getLogger(TelaServico.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnLimparActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        try {
            readJTableBusca(txtBusca.getText());
        } catch (SQLException ex) {
            System.out.println("Erro na Busca: " + ex);
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void txtBuscaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscaKeyPressed
       try {
            readJTableBusca(txtBusca.getText());
        } catch (SQLException ex) {
            System.out.println("Erro na Busca: " + ex);
        }
    }//GEN-LAST:event_txtBuscaKeyPressed

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
        
        if(!txtValor.getText().isEmpty() && !txtDescricao.getText().isEmpty()){
            
            //instancia os objetos servico e dao
            Servico servico = new Servico();
            ServicoDao dao = new ServicoDao();
            
            //seta os campos da tabela
            servico.setDescricao(txtDescricao.getText());
            servico.setValor(Float.parseFloat(txtValor.getText()));
            
            try {
                dao.create(servico);
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
                    "Informe a descrição e o valor do serviço!");
            txtDescricao.grabFocus();
        }
    }//GEN-LAST:event_btnAdicionarActionPerformed

    private void tblServicoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblServicoMouseClicked
        selecionarItem();
    }//GEN-LAST:event_tblServicoMouseClicked

    private void tblServicoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblServicoKeyReleased
        selecionarItem();
    }//GEN-LAST:event_tblServicoKeyReleased

    private void btnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarActionPerformed
        
        if (tblServico.getSelectedRow() != -1){
            
            try {
                
                Servico servico = new Servico();
                ServicoDao dao = new ServicoDao();
                
                //seta (mudar) os campos do objeto servico
                servico.setDescricao(txtDescricao.getText());
                servico.setValor(Float.parseFloat(txtValor.getText()));
                servico.setId((int)tblServico.getValueAt(tblServico.getSelectedRow(),0));
                
                try {
                    //atualizar o banco
                    dao.update(servico);
                } catch (SQLException ex) {
                    Logger.getLogger(TelaServico.class.getName()).log(Level.SEVERE, null, ex);
                }
                //limpar os campos
                limpar();
            } catch (SQLException ex) {
                Logger.getLogger(TelaServico.class.getName()).log(Level.SEVERE, null, ex);
            }
            
           
        }else{
             JOptionPane.showMessageDialog(null, "Selecione um servico");
            
        }
        
        
        
    }//GEN-LAST:event_btnAtualizarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        if (tblServico.getSelectedRow() != -1){
            int resp = JOptionPane.showConfirmDialog(null, "confiemar Exclusão?", "Exclusão do Campo", ConfirmationCallback.OK_CANCEL_OPTION);
             if(resp == 0){
             
                try {

                    Servico servico = new Servico();
                    ServicoDao dao = new ServicoDao();
                    servico.setId((int)tblServico.getValueAt(tblServico.getSelectedRow(),0));
                    
                    try {
                        dao.delete(servico);
                    } catch (SQLException ex) {
                        Logger.getLogger(TelaServico.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    limpar();
                } catch (SQLException ex) {
                    Logger.getLogger(TelaServico.class.getName()).log(Level.SEVERE, null, ex);
                }
             }
                
        }else{
            JOptionPane.showMessageDialog(null, "Selecione um servico");
        }
        
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void txtBuscaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscaActionPerformed

    private void txtIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdActionPerformed

    private void txtDescricaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescricaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDescricaoActionPerformed

    private void txtValorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtValorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtValorActionPerformed

   
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
            java.util.logging.Logger.getLogger(TelaServico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaServico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaServico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaServico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new TelaServico().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(TelaServico.class.getName()).log(Level.SEVERE, null, ex);
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblServico;
    private javax.swing.JTextField txtBusca;
    private javax.swing.JTextField txtDescricao;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtValor;
    // End of variables declaration//GEN-END:variables
}
