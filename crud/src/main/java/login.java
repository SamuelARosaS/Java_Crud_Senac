import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JFrame;



public class login extends javax.swing.JFrame {
 private static class Conexao {
        private static final String URL = "jdbc:mysql://localhost:3306/java_crud";
        private static final String USER = "root";
        private static final String PASSWORD = "senac@2025";
        
        public static Connection getConnection() {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                return DriverManager.getConnection(URL, USER, PASSWORD);
            } catch (ClassNotFoundException | SQLException e) {
                throw new RuntimeException("Erro na conexão com o banco de dados", e);
            }
        }
        
        public static void closeConnection(Connection con) {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
 }
 
    public login() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        login = new javax.swing.JLabel();
        usuario = new javax.swing.JTextField();
        senha = new javax.swing.JTextField();
        label_usuario = new javax.swing.JLabel();
        label_senha = new javax.swing.JLabel();
        entrar = new javax.swing.JButton();
        cadastrar = new javax.swing.JButton();
        label_conf = new javax.swing.JLabel();
        registros = new javax.swing.JButton();
        alteracao = new javax.swing.JButton();
        deletar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        login.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        login.setText("LOGIN");
        getContentPane().add(login, new org.netbeans.lib.awtextra.AbsoluteConstraints(163, 43, -1, -1));

        usuario.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usuarioActionPerformed(evt);
            }
        });
        getContentPane().add(usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(163, 112, 70, -1));

        senha.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        senha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                senhaActionPerformed(evt);
            }
        });
        getContentPane().add(senha, new org.netbeans.lib.awtextra.AbsoluteConstraints(163, 156, 70, -1));

        label_usuario.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        label_usuario.setText("Usuario");
        getContentPane().add(label_usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(101, 118, -1, -1));

        label_senha.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        label_senha.setText("Senha");
        getContentPane().add(label_senha, new org.netbeans.lib.awtextra.AbsoluteConstraints(101, 162, -1, -1));

        entrar.setText("Entrar");
        entrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                entrarActionPerformed(evt);
            }
        });
        getContentPane().add(entrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(163, 194, -1, -1));

        cadastrar.setText("Cadastrar");
        cadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarActionPerformed(evt);
            }
        });
        getContentPane().add(cadastrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 230, -1, -1));

        label_conf.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        label_conf.setText("Configurações");
        getContentPane().add(label_conf, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 50, -1, -1));

        registros.setText("Registros");
        registros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrosActionPerformed(evt);
            }
        });
        getContentPane().add(registros, new org.netbeans.lib.awtextra.AbsoluteConstraints(303, 77, -1, -1));

        alteracao.setText("Alteração");
        alteracao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alteracaoActionPerformed(evt);
            }
        });
        getContentPane().add(alteracao, new org.netbeans.lib.awtextra.AbsoluteConstraints(303, 126, -1, -1));

        deletar.setText("Deletar");
        deletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletarActionPerformed(evt);
            }
        });
        getContentPane().add(deletar, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 180, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void usuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usuarioActionPerformed

    private void senhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_senhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_senhaActionPerformed

    private void entrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_entrarActionPerformed
    String user = usuario.getText();
        String password = senha.getText();
        
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            stmt = con.prepareStatement("SELECT * FROM conta WHERE login = ? AND senha = ?");
            stmt.setString(1, user);
            stmt.setString(2, password);
            
            rs = stmt.executeQuery();
            
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "Login bem-sucedido!");
            } else {
                JOptionPane.showMessageDialog(null, "Usuário ou senha incorretos!", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao acessar o banco de dados: " + ex.getMessage());
        } finally {
            Conexao.closeConnection(con);
            try {
                if (stmt != null) stmt.close();
                if (rs != null) rs.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_entrarActionPerformed

    private void cadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarActionPerformed
    String user = usuario.getText();
        String password = senha.getText();
        
        if (user.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        
        try {
            // Verificar se o usuário já existe
            stmt = con.prepareStatement("SELECT * FROM conta WHERE login = ?");
            stmt.setString(1, user);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "Usuário já existe!", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            // Inserir novo usuário
            stmt = con.prepareStatement("INSERT INTO conta (login, senha) VALUES (?, ?)");
            stmt.setString(1, user);
            stmt.setString(2, password);
            
            int rowsAffected = stmt.executeUpdate();
            
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!");
                usuario.setText("");
                senha.setText("");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar usuário: " + ex.getMessage());
        } finally {
            Conexao.closeConnection(con);
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_cadastrarActionPerformed

    private void alteracaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alteracaoActionPerformed
     String user = usuario.getText();
        String newPassword = senha.getText();
        
        if (user.isEmpty() || newPassword.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("UPDATE conta SET senha = ? WHERE login = ?");
            stmt.setString(1, newPassword);
            stmt.setString(2, user);
            
            int rowsAffected = stmt.executeUpdate();
            
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Senha alterada com sucesso!");
                usuario.setText("");
                senha.setText("");
            } else {
                JOptionPane.showMessageDialog(null, "Usuário não encontrado!", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar senha: " + ex.getMessage());
        } finally {
            Conexao.closeConnection(con);
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_alteracaoActionPerformed

    private void registrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrosActionPerformed
    Connection con = Conexao.getConnection();
    PreparedStatement stmt = null;
    ResultSet rs = null;
    
    try {
        stmt = con.prepareStatement("SELECT * FROM conta");
        rs = stmt.executeQuery();
        
        // Criar modelo de tabela
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Login");
        model.addColumn("Senha");
        
        // Preencher modelo com dados do ResultSet
        while (rs.next()) {
            model.addRow(new Object[]{
                rs.getString("login"),
                rs.getString("senha")
            });
        }
        
        // Criar e configurar JTable
        JTable table = new JTable(model);
        table.setFillsViewportHeight(true);
        
        // Configurar janela
        JFrame frame = new JFrame("Registros de Contas");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);
        
        // Adicionar tabela a um JScrollPane e à janela
        frame.add(new JScrollPane(table));
        frame.setVisible(true);
        
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Erro ao consultar registros: " + ex.getMessage());
    } finally {
        Conexao.closeConnection(con);
        try {
            if (stmt != null) stmt.close();
            if (rs != null) rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    }//GEN-LAST:event_registrosActionPerformed

    private void deletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletarActionPerformed
      String user = usuario.getText();
        
        if (user.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Informe o usuário a ser deletado!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        int confirm = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja deletar o usuário " + user + "?", 
                "Confirmar Exclusão", JOptionPane.YES_NO_OPTION);
        
        if (confirm != JOptionPane.YES_OPTION) {
            return;
        }
        
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("DELETE FROM conta WHERE login = ?");
            stmt.setString(1, user);
            
            int rowsAffected = stmt.executeUpdate();
            
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Usuário deletado com sucesso!");
                usuario.setText("");
                senha.setText("");
            } else {
                JOptionPane.showMessageDialog(null, "Usuário não encontrado!", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao deletar usuário: " + ex.getMessage());
        } finally {
            Conexao.closeConnection(con);
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_deletarActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton alteracao;
    private javax.swing.JButton cadastrar;
    private javax.swing.JButton deletar;
    private javax.swing.JButton entrar;
    private javax.swing.JLabel label_conf;
    private javax.swing.JLabel label_senha;
    private javax.swing.JLabel label_usuario;
    private javax.swing.JLabel login;
    private javax.swing.JButton registros;
    private javax.swing.JTextField senha;
    private javax.swing.JTextField usuario;
    // End of variables declaration//GEN-END:variables
}
