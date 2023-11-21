package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

import conexao.ConnectionFactory;
import models.Cliente;

public class ClienteDao {
    public static void create(Cliente c) throws SQLException{
        //instancia
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement sql = null;
        
        try{
            sql = con.prepareStatement(
                    "insert into cliente(nome, telefone, email, rg, cpf, endereco, cep) values (?,?,?,?,?,?,?);");
                    sql.setString(1, c.getNome());
                    sql.setString(2, c.getTelefone());
                    sql.setString(3, c.getEmail());
                    sql.setString(4, c.getRg());
                    sql.setString(5, c.getCpf());
                    sql.setString(6, c.getEndereco());
                    sql.setString(7, c.getCep());
                    
                    sql.executeUpdate();
                    JOptionPane.showConfirmDialog(null, "Cadastrado com sucesso!");
        }catch(SQLException ex){
            JOptionPane.showConfirmDialog(null, "Erro ao cadastrar!" + ex);
        }finally{
            ConnectionFactory.closeConnection(con, sql);
        }
    }
        public List<Cliente> read() throws SQLException{
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement sql = null;
        ResultSet rs = null;
        
        List<Cliente> clientes = new ArrayList<>();
        
        try{
            sql = con.prepareStatement("Select * from cliente");
            rs = sql.executeQuery();
            
            while (rs.next()){
                Cliente cliente = new Cliente();
                
                cliente.setId(rs.getInt("id"));
                cliente.setNome(rs.getString("nome"));
                cliente.setTelefone(rs.getString("telefone"));
                cliente.setEmail(rs.getString("email"));
                cliente.setRg(rs.getString("rg"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setEndereco(rs.getString("endereco"));
                cliente.setCep(rs.getString("cep"));
                
                clientes.add(cliente);
                
            }
        }catch(SQLException ex){
                JOptionPane.showMessageDialog(null, "Erro ao Acessar o Banco de dados:" + ex);
        }finally{
                    ConnectionFactory.closeConnection(con, sql, rs);
             }
        return clientes;
        
        }
        
public static void update(Cliente c) throws SQLException{
        //instancia
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement sql = null;
        
        try{
            sql = con.prepareStatement(
                    "update cliente set nome = ?, telefone = ?, email = ?, rg = ?, endereco = ?, cep = ?, cpf = ?)");
                    sql.setString(1, c.getNome());
                    sql.setString(2, c.getTelefone());
                    sql.setString(3, c.getEmail());
                    sql.setString(4, c.getRg());
                    sql.setString(5, c.getCpf());
                    sql.setString(6, c.getEndereco());
                    sql.setString(7, c.getCep());
                    
                    sql.executeUpdate();
                    
                    JOptionPane.showConfirmDialog(null, "Atualizado com sucesso!");
        }catch(SQLException ex){
            JOptionPane.showConfirmDialog(null, "Erro ao atualizar!" + ex);
        }finally{
            ConnectionFactory.closeConnection(con, sql);
        }
    }

    public void delete(Cliente s) throws SQLException{
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement sql = null;
        
        try{
            sql = con.prepareStatement("delete from cliente  where id = ?");
            sql.setInt(1, s.getId());
            
            sql.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Excluido com Sucesso!");
        }catch(SQLException ex){            
            JOptionPane.showMessageDialog(
      null,"Erro ao Excluir " + ex);
        }finally{
            ConnectionFactory.closeConnection(con, sql);
        }        
    }
    
      
     public List<Cliente> readBusca(String busca) throws SQLException{
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement sql = null;
        ResultSet rs = null;
        
        List<Cliente> clientes = new ArrayList<>();
        
        try{
           sql = con.prepareStatement(
                   "Select * from cliente where nome like ?");
           sql.setString(1,"%" + busca + "%");
           
           rs = sql.executeQuery();
           
           while(rs.next()){
               
               Cliente cliente = new Cliente();
               
                cliente.setId(rs.getInt("id"));
                cliente.setNome(rs.getString("nome"));
                cliente.setTelefone(rs.getString("telefone"));
                cliente.setEmail(rs.getString("email"));
                cliente.setRg(rs.getString("rg"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setEndereco(rs.getString("endereco"));
                cliente.setCep(rs.getString("cep"));
                
                clientes.add(cliente);             
           }             
        }catch(SQLException ex){            
            JOptionPane.showMessageDialog(
      null,"Erro ao Acessar o Banco de dados: " + ex);
        }finally{
            ConnectionFactory.closeConnection(con, sql, rs);
        }        
        return clientes;
    }
    }
