package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

import conexao.ConnectionFactory;
import models.Funcionario;


public class FuncionarioDao {
    public static void create(Funcionario f) throws SQLException{
        //instancia
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement sql = null;
        
        try{
            sql = con.prepareStatement(
                    "insert into funcionario(nome, telefone, email, rg, cpf, salario) values (?,?,?,?,?,?);");
                    sql.setString(1, f.getNome());
                    sql.setString(2, f.getTelefone());
                    sql.setString(3, f.getEmail());
                    sql.setString(4, f.getRg());
                    sql.setString(5, f.getCpf());
                    sql.setFloat(6, f.getSalario());
                    
                    sql.executeUpdate();
                    JOptionPane.showConfirmDialog(null, "Cadastrado com sucesso!");
        }catch(SQLException ex){
            JOptionPane.showConfirmDialog(null, "Erro ao cadastrar!" + ex);
        }finally{
            ConnectionFactory.closeConnection(con, sql);
        }
    }
    
    public List<Funcionario> read() throws SQLException{
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement sql = null;
        ResultSet rs = null;
        
        List<Funcionario> funcionarios = new ArrayList<>();
        
        try{
            sql = con.prepareStatement("Select * from funcionario");
            rs = sql.executeQuery();
            
            while (rs.next()){
                Funcionario funcionario = new Funcionario();
                
                funcionario.setId(rs.getInt("id"));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setTelefone(rs.getString("telefone"));
                funcionario.setEmail(rs.getString("email"));
                funcionario.setRg(rs.getString("rg"));
                funcionario.setCpf(rs.getString("cpf"));
                funcionario.setSalario(rs.getFloat("salario"));
                
                funcionarios.add(funcionario);
                
            }
        }catch(SQLException ex){
                JOptionPane.showMessageDialog(null, "Erro ao Acessar o Banco de dados:" + ex);
        }finally{
                    ConnectionFactory.closeConnection(con, sql, rs);
             }
        return funcionarios;
        
        }
    
    public static void update(Funcionario f) throws SQLException{
        //instancia
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement sql = null;
        
        try{
            sql = con.prepareStatement(
                    "update funcionario set nome = ?, telefone = ?, email = ?, rg = ?, salario = ?)");
                    sql.setString(1, f.getNome());
                    sql.setString(2,f.getTelefone());
                    sql.setString(3, f.getEmail());
                    sql.setString(4, f.getRg());
                    sql.setString(5, f.getCpf());
                    sql.setFloat(6, f.getSalario());
                    
                    sql.executeUpdate();
                    
                    JOptionPane.showConfirmDialog(null, "Atualizado com sucesso!");
        }catch(SQLException ex){
            JOptionPane.showConfirmDialog(null, "Erro ao atualizar!" + ex);
        }finally{
            ConnectionFactory.closeConnection(con, sql);
        }
    }
    
    public void delete(Funcionario f) throws SQLException{
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement sql = null;
        
        try{
            sql = con.prepareStatement("delete from funcionario  where id = ?");
            sql.setInt(1, f.getId());
            
            sql.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Excluido com Sucesso!");
        }catch(SQLException ex){            
            JOptionPane.showMessageDialog(
      null,"Erro ao Excluir " + ex);
        }finally{
            ConnectionFactory.closeConnection(con, sql);
        }        
    }
    
    public List<Funcionario> readBusca(String busca) throws SQLException{
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement sql = null;
        ResultSet rs = null;
        
        List<Funcionario> funcionarios = new ArrayList<>();
        
        try{
           sql = con.prepareStatement(
                   "Select * from funcionario where nome like ?");
           sql.setString(1,"%" + busca + "%");
           
           rs = sql.executeQuery();
           
           while(rs.next()){
               
               Funcionario funcionario = new Funcionario();
               
                funcionario.setId(rs.getInt("id"));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setTelefone(rs.getString("telefone"));
                funcionario.setEmail(rs.getString("email"));
                funcionario.setRg(rs.getString("rg"));
                funcionario.setCpf(rs.getString("cpf"));
                funcionario.setSalario(rs.getFloat("salario"));
                
                funcionarios.add(funcionario);             
           }             
        }catch(SQLException ex){            
            JOptionPane.showMessageDialog(
      null,"Erro ao Acessar o Banco de dados: " + ex);
        }finally{
            ConnectionFactory.closeConnection(con, sql, rs);
        }        
        return funcionarios;
    }
}
