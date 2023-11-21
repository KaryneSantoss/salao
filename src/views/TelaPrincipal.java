/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 16127512022.2
 */
public class TelaPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form TelaPrincipal
     */
    public TelaPrincipal() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuArquivo = new javax.swing.JMenu();
        itemMenuCliente = new javax.swing.JMenuItem();
        itemMenuFuncionario = new javax.swing.JMenuItem();
        itemMenuServico = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        itemMenuFechar = new javax.swing.JMenuItem();
        menuSobre = new javax.swing.JMenu();
        itemMenuSobre = new javax.swing.JMenuItem();
        menuSair = new javax.swing.JMenu();
        itemMenuSair = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Salão de Beleza Senac");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/fundoPrincipal.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 600));

        menuArquivo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/book.png"))); // NOI18N
        menuArquivo.setText("Arquivo");

        itemMenuCliente.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        itemMenuCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/user_female.png"))); // NOI18N
        itemMenuCliente.setText("Clientes");
        itemMenuCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemMenuClienteActionPerformed(evt);
            }
        });
        menuArquivo.add(itemMenuCliente);

        itemMenuFuncionario.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        itemMenuFuncionario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/user.png"))); // NOI18N
        itemMenuFuncionario.setText("Funcionarios");
        itemMenuFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemMenuFuncionarioActionPerformed(evt);
            }
        });
        menuArquivo.add(itemMenuFuncionario);

        itemMenuServico.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        itemMenuServico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cut.png"))); // NOI18N
        itemMenuServico.setText("Serviços");
        itemMenuServico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemMenuServicoActionPerformed(evt);
            }
        });
        menuArquivo.add(itemMenuServico);
        menuArquivo.add(jSeparator1);

        itemMenuFechar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_W, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        itemMenuFechar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/house_go.png"))); // NOI18N
        itemMenuFechar.setText("Fechar");
        itemMenuFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemMenuFecharActionPerformed(evt);
            }
        });
        menuArquivo.add(itemMenuFechar);

        jMenuBar1.add(menuArquivo);

        menuSobre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/help.png"))); // NOI18N
        menuSobre.setText("Sobre");

        itemMenuSobre.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        itemMenuSobre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/help.png"))); // NOI18N
        itemMenuSobre.setText("Sobre");
        menuSobre.add(itemMenuSobre);

        jMenuBar1.add(menuSobre);

        menuSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/house_go.png"))); // NOI18N
        menuSair.setText("Sair");

        itemMenuSair.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_W, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        itemMenuSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/house_go.png"))); // NOI18N
        itemMenuSair.setText("Sair");
        itemMenuSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemMenuSairActionPerformed(evt);
            }
        });
        menuSair.add(itemMenuSair);

        jMenuBar1.add(menuSair);

        setJMenuBar(jMenuBar1);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void itemMenuFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemMenuFecharActionPerformed
        System.exit(0);
    }//GEN-LAST:event_itemMenuFecharActionPerformed

    private void itemMenuSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemMenuSairActionPerformed
        System.exit(0);
    }//GEN-LAST:event_itemMenuSairActionPerformed

    private void itemMenuClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemMenuClienteActionPerformed
        try {
            new TelaCliente().setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_itemMenuClienteActionPerformed

    private void itemMenuFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemMenuFuncionarioActionPerformed
        try {
            new TelaFuncionario().setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_itemMenuFuncionarioActionPerformed

    private void itemMenuServicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemMenuServicoActionPerformed
        try {
            new TelaServico().setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_itemMenuServicoActionPerformed

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
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem itemMenuCliente;
    private javax.swing.JMenuItem itemMenuFechar;
    private javax.swing.JMenuItem itemMenuFuncionario;
    private javax.swing.JMenuItem itemMenuSair;
    private javax.swing.JMenuItem itemMenuServico;
    private javax.swing.JMenuItem itemMenuSobre;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JMenu menuArquivo;
    private javax.swing.JMenu menuSair;
    private javax.swing.JMenu menuSobre;
    // End of variables declaration//GEN-END:variables
}
