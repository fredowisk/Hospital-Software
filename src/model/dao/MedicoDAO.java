package model.dao;

import connection.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.bean.Medico;

/**
 *
 * @author fredaum
 */
public class MedicoDAO {
    
    public void create(Medico m){
        Connection con = Conexao.AbrirConexao();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("insert into medico(nome, telefone, cpf, sexo, sus) values (?,?,?,?,?)");
            stmt.setString(1, m.getNome());
            stmt.setString(2, m.getTelefone());
            stmt.setString(3, m.getCpf());
            stmt.setString(4, m.getSexo());
            stmt.setString(5, m.getSus());
            
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao salvar!");
        } finally {
            Conexao.fecharConexao(con, stmt);
        }
    }
    
    public List<Medico> read(){
        Connection con = Conexao.AbrirConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Medico> medicos = new ArrayList<>();
        try {
            stmt = con.prepareStatement("select * from medico");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Medico m = new Medico();
                m.setNome(rs.getString("nome"));
                m.setTelefone(rs.getString("telefone"));
                m.setCpf(rs.getString("cpf"));
                m.setSexo(rs.getString("sexo"));
                m.setSus(rs.getString("sus"));
                medicos.add(m);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar!");
        } finally {
            Conexao.fecharConexao(con, stmt, rs);
        }
        return medicos;
    }
    
    public List<Medico> readSelectedMedico(String nome){
        Connection con = Conexao.AbrirConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Medico> medicos = new ArrayList<>();
        try {
            stmt = con.prepareStatement("select * from medico where nome = ?");
            stmt.setString(1, nome);
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Medico m = new Medico();
                m.setNome(rs.getString("nome"));
                m.setTelefone(rs.getString("telefone"));
                m.setCpf(rs.getString("cpf"));
                m.setSexo(rs.getString("sexo"));
                m.setSus(rs.getString("sus"));
                medicos.add(m);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Medico não encontrado!");
        } finally {
            Conexao.fecharConexao(con, stmt, rs);
        }
        return medicos;
    }
    
    public List<Medico> readSelectedMedicoCpf(String cpf){
        Connection con = Conexao.AbrirConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Medico> medicos = new ArrayList<>();
        try {
            stmt = con.prepareStatement("select * from medico where cpf = ?");
            stmt.setString(1, cpf);
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Medico m = new Medico();
                m.setNome(rs.getString("nome"));
                m.setTelefone(rs.getString("telefone"));
                m.setCpf(rs.getString("cpf"));
                m.setSexo(rs.getString("sexo"));
                m.setSus(rs.getString("sus"));
                medicos.add(m);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Medico não encontrado!");
        } finally {
            Conexao.fecharConexao(con, stmt, rs);
        }
        return medicos;
    }
    
    public void update(Medico m){
        Connection con = Conexao.AbrirConexao();
        PreparedStatement stmt = null;
        
        try {
            
            stmt = con.prepareStatement("update medico set nome = ?, telefone = ?, cpf = ?, sexo = ?, sus = ? where cpf = ?");
            stmt.setString(1, m.getNome());
            stmt.setString(2, m.getTelefone());
            stmt.setString(3, m.getCpf());
            stmt.setString(4, m.getSexo());
            stmt.setString(5, m.getSus());
            stmt.setString(6, m.getCpf());
            
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar!");
        } finally {
            Conexao.fecharConexao(con, stmt);
        }
    }
    
    public void delete(Medico m){
        Connection con = Conexao.AbrirConexao();
        PreparedStatement stmt = null;
        
        try {
            
            stmt = con.prepareStatement("delete from medico where cpf = ?");
            stmt.setString(1, m.getCpf());
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao excluir!");
            
        } finally {
            Conexao.fecharConexao(con, stmt);
        }
    }
}
