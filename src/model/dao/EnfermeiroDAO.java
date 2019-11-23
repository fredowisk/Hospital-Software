package model.dao;

import connection.Conexao;
import model.bean.Enfermeiro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author fredaum
 */
public class EnfermeiroDAO {
    
    public void create(Enfermeiro e){
        Connection con = Conexao.AbrirConexao();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("insert into enfermeiro(nome, telefone, cpf, sexo, sus) values (?,?,?,?,?)");
            stmt.setString(1, e.getNome());
            stmt.setString(2, e.getTelefone());
            stmt.setString(3, e.getCpf());
            stmt.setString(4, e.getSexo());
            stmt.setString(5, e.getSus());
            
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao salvar!");
        } finally {
            Conexao.fecharConexao(con, stmt);
        }
    }
    
    public List<Enfermeiro> read(){
        Connection con = Conexao.AbrirConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Enfermeiro> enfermeiros = new ArrayList<>();
        try {
            stmt = con.prepareStatement("select * from enfermeiro");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Enfermeiro e = new Enfermeiro();
                e.setNome(rs.getString("nome"));
                e.setTelefone(rs.getString("telefone"));
                e.setCpf(rs.getString("cpf"));
                e.setSexo(rs.getString("sexo"));
                e.setSus(rs.getString("sus"));
                enfermeiros.add(e);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar!");
        } finally {
            Conexao.fecharConexao(con, stmt, rs);
        }
        return enfermeiros;
    }
    
    public List<Enfermeiro> readSelectedEnfermeiro(String nome){
        Connection con = Conexao.AbrirConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Enfermeiro> enfermeiros = new ArrayList<>();
        try {
            stmt = con.prepareStatement("select * from enfermeiro where nome = ?");
            stmt.setString(1, nome);
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Enfermeiro e = new Enfermeiro();
                e.setNome(rs.getString("nome"));
                e.setTelefone(rs.getString("telefone"));
                e.setCpf(rs.getString("cpf"));
                e.setSexo(rs.getString("sexo"));
                e.setSus(rs.getString("sus"));
                enfermeiros.add(e);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Enfermeiro não encontrado!");
        } finally {
            Conexao.fecharConexao(con, stmt, rs);
        }
        return enfermeiros;
    }
    
    public List<Enfermeiro> readSelectedEnfermeiroCpf(String cpf){
        Connection con = Conexao.AbrirConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Enfermeiro> enfermeiros = new ArrayList<>();
        try {
            stmt = con.prepareStatement("select * from enfermeiro where cpf = ?");
            stmt.setString(1, cpf);
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Enfermeiro e = new Enfermeiro();
                e.setNome(rs.getString("nome"));
                e.setTelefone(rs.getString("telefone"));
                e.setCpf(rs.getString("cpf"));
                e.setSexo(rs.getString("sexo"));
                e.setSus(rs.getString("sus"));
                enfermeiros.add(e);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Enfermeiro não encontrado!");
        } finally {
            Conexao.fecharConexao(con, stmt, rs);
        }
        return enfermeiros;
    }
    
    public void update(Enfermeiro e){
        Connection con = Conexao.AbrirConexao();
        PreparedStatement stmt = null;
         
        try {
            
            stmt = con.prepareStatement("update enfermeiro set nome = ?, telefone = ?, cpf = ?, sexo = ?, sus = ? where cpf = ?");
            stmt.setString(1, e.getNome());
            stmt.setString(2, e.getTelefone());
            stmt.setString(3, e.getCpf());
            stmt.setString(4, e.getSexo());
            stmt.setString(5, e.getSus());
            stmt.setString(6, e.getCpf());
            
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar!");
        } finally {
            Conexao.fecharConexao(con, stmt);
        }
    }
    
    public void delete(Enfermeiro e){
        Connection con = Conexao.AbrirConexao();
        PreparedStatement stmt = null;
        
        try {
            
            stmt = con.prepareStatement("delete from enfermeiro where cpf = ?");
            stmt.setString(1, e.getCpf());
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao excluir!");
        } finally {
            Conexao.fecharConexao(con, stmt);
        }
    }
}
