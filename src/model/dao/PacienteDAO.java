package model.dao;

import connection.Conexao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.bean.Paciente;

/**
 *
 * @author fredaum
 */
public class PacienteDAO {
    
    public void create(Paciente p){
        Connection con = Conexao.AbrirConexao();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("insert into paciente(nome, dataNascimento, telefone, cpf, sus, sexo, atendido) values (?,?,?,?,?,?,?)");
            stmt.setString(1, p.getNome());
            stmt.setDate(2, (Date) p.getDataNascimento());
            stmt.setString(3, p.getTelefone());
            stmt.setString(4, p.getCpf());
            stmt.setString(5, p.getSus());
            stmt.setString(6, p.getSexo());
            stmt.setString(7, "N");
            
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao salvar!");
        }
    }
    
    public List<Paciente> read(){
        Connection con = Conexao.AbrirConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Paciente> pacientes = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("select * from paciente");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Paciente p = new Paciente();
                p.setNome(rs.getString("nome"));
                p.setDataNascimento(rs.getDate("dataNascimento"));
                p.setTelefone(rs.getString("telefone"));
                p.setCpf(rs.getString("cpf"));
                p.setSus(rs.getString("sus"));
                p.setSexo(rs.getString("sexo"));
                p.setAtendido(rs.getString("atendido"));
                
                pacientes.add(p);
            } 
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar!");
        } finally {
            Conexao.fecharConexao(con, stmt, rs);
        }
        return pacientes;
    }
    
    public List<Paciente> readNaoAtendidos(){
        Connection con = Conexao.AbrirConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Paciente> pacientes = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("select * from paciente where atendido = ?");
            stmt.setString(1, "N");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Paciente p = new Paciente();
                p.setNome(rs.getString("nome"));
                p.setDataNascimento(rs.getDate("dataNascimento"));
                p.setTelefone(rs.getString("telefone"));
                p.setCpf(rs.getString("cpf"));
                p.setSus(rs.getString("sus"));
                p.setSexo(rs.getString("sexo"));
                
                pacientes.add(p);
            } 
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar!");
        } finally {
            Conexao.fecharConexao(con, stmt, rs);
        }
        return pacientes;
    }
    
    public List<Paciente> readSelectedPaciente(String nome){
        Connection con = Conexao.AbrirConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Paciente> pacientes = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("select * from paciente where nome = ?");
            stmt.setString(1, nome);
            
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Paciente p = new Paciente();
                p.setNome(rs.getString("nome"));
                p.setDataNascimento(rs.getDate("dataNascimento"));
                p.setTelefone(rs.getString("telefone"));
                p.setCpf(rs.getString("cpf"));
                p.setSus(rs.getString("sus"));
                p.setSexo(rs.getString("sexo"));
                p.setAtendido(rs.getString("atendido"));
                
                pacientes.add(p);
            } 
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar!");
        } finally {
            Conexao.fecharConexao(con, stmt, rs);
        }
        return pacientes;
    }
    
    public List<Paciente> readSelectedPacienteCpf(String cpf){
        Connection con = Conexao.AbrirConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Paciente> pacientes = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("select * from paciente where cpf = ?");
            stmt.setString(1, cpf);
            
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Paciente p = new Paciente();
                p.setNome(rs.getString("nome"));
                p.setDataNascimento(rs.getDate("dataNascimento"));
                p.setTelefone(rs.getString("telefone"));
                p.setCpf(rs.getString("cpf"));
                p.setSus(rs.getString("sus"));
                p.setSexo(rs.getString("sexo"));
                p.setAtendido(rs.getString("atendido"));
                
                pacientes.add(p);
            } 
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar!");
        } finally {
            Conexao.fecharConexao(con, stmt, rs);
        }
        return pacientes;
    }
    
    public void update(Paciente p) {
        Connection con = Conexao.AbrirConexao();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("update paciente set nome = ?, telefone = ?, cpf = ?, sus = ?, sexo = ? where cpf = ?");
            stmt.setString(1, p.getNome());
            stmt.setString(2, p.getTelefone());
            stmt.setString(3, p.getCpf());
            stmt.setString(4, p.getSus());
            stmt.setString(5, p.getSexo());
            stmt.setString(6, p.getCpf());
            
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao atualizar!");
        } finally {
            Conexao.fecharConexao(con, stmt);
        }
    }
    
    public void updateAtendido(Paciente p){
        Connection con = Conexao.AbrirConexao();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("update paciente set atendido = ? where cpf = ?");
            stmt.setString(1, p.getAtendido());
            stmt.setString(2, p.getCpf());
            
            stmt.executeUpdate();
            if(p.getAtendido().equals("S"))
            JOptionPane.showMessageDialog(null, "Paciente atendido!");
            else
                JOptionPane.showMessageDialog(null, "Paciente na fila!");
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro nas informações!");
        } finally {
            Conexao.fecharConexao(con, stmt);
        }
    }
    
    public void delete(Paciente p){
        Connection con = Conexao.AbrirConexao();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("delete from paciente where cpf = ?");
            stmt.setString(1, p.getCpf());
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao excluir!");
        } finally {
            Conexao.fecharConexao(con, stmt);
        }
    }
}
