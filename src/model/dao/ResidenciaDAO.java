package model.dao;

import model.bean.Residencia;
import connection.Conexao;
import java.sql.Connection;
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
public class ResidenciaDAO {
    
    public void create(Residencia r){
        Connection con = Conexao.AbrirConexao();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("insert into residencia(responsavel, residencia, cpf)values (?,?,?)");
            stmt.setString(1, r.getResponsavel());
            stmt.setString(2, r.getResidencia());
            stmt.setString(3, r.getPaciente().getCpf());
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!"); 
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar!");
        } finally {
            Conexao.fecharConexao(con, stmt);
        }
    }
    
    public List<Residencia> read(){
        Connection con = Conexao.AbrirConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Residencia> residencias = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("select r.residencia, r.responsavel, p.nome,p.cpf from residencia r inner join paciente p on r.cpf = p.cpf");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Residencia r = new Residencia();
                Paciente p = new Paciente();
                r.setResidencia(rs.getString("residencia"));
                r.setResponsavel(rs.getString("responsavel"));
                p.setNome(rs.getString("nome"));
                p.setCpf(rs.getString("cpf"));
                r.setPaciente(p);
                residencias.add(r);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar!");
        } finally {
            Conexao.fecharConexao(con, stmt, rs);
        }
        return residencias;
    }
    
    public List<Residencia> readSelectedResidencia(String cpf){
        Connection con = Conexao.AbrirConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Residencia> residencias = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("select r.residencia, r.responsavel, p.nome, p.cpf from residencia r inner join paciente p on r.cpf = p.cpf where p.cpf = ?");
            stmt.setString(1, cpf);
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Residencia r = new Residencia();
                Paciente p = new Paciente();
                p.setCpf(rs.getString("cpf"));
                r.setResidencia(rs.getString("residencia"));
                r.setResponsavel(rs.getString("responsavel"));
                r.setPaciente(p);
                residencias.add(r);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar!");
        } finally {
            Conexao.fecharConexao(con, stmt, rs);
        }
        return residencias;
    }
    
    public void update(Residencia r){
        Connection con = Conexao.AbrirConexao();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("update residencia set residencia = ?, responsavel = ? where cpf = ?");
            stmt.setString(1, r.getResidencia());
            stmt.setString(2, r.getResponsavel());
            stmt.setString(3, r.getPaciente().getCpf());
            
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar!");
        } finally {
            Conexao.fecharConexao(con, stmt);
        }
    }
    
    public void delete(Residencia r){
        Connection con = Conexao.AbrirConexao();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("delete from residencia where cpf = ?");
            stmt.setString(1, r.getPaciente().getCpf());
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao excluir!");
        } finally {
            Conexao.fecharConexao(con, stmt);
        }
    }
}
