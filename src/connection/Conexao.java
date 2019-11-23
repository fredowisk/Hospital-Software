package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author fredaum
 */
public class Conexao {
    public static Connection AbrirConexao(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection
        ("jdbc:mysql://localhost:3306/Hospital","root","root");
        } catch (SQLException | ClassNotFoundException ex) {
            throw new RuntimeException("Erro na conexão", ex);
        }
    }
    public static void fecharConexao(Connection con){
        if(con != null){
            try{
            con.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar conexão!");
            }
        }
    }
    
    public static void fecharConexao(Connection con, PreparedStatement stmt){
        fecharConexao(con);
        if(stmt != null){
            try {
                stmt.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar conexão!");
            }
        }
    }
    
    public static void fecharConexao(Connection con, PreparedStatement stmt, 
            ResultSet rs){
        fecharConexao(con, stmt);
        if(rs != null){
            try {
                rs.close();
            } catch (SQLException e){
                JOptionPane.showMessageDialog(null, "Erro ao fechar conexão!");
            }
        }
    }
    
}
