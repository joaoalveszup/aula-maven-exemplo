package br.com.zup.estrelas.exemplo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.zup.estrelas.exemplo.factory.ConnectionFactory;
import br.com.zup.estrelas.exemplo.pojo.Avaliacao;

public class AvaliacaoDAO {

    private Connection conn;

    public AvaliacaoDAO() {
        this.conn = new ConnectionFactory().fabricaConexao();
    }
    
    
    public void insereAvaliacao (Avaliacao avaliacao) {
        
        String sql = "insert into avaliacao(nota, comentario) values (?, ?)";
        
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, avaliacao.getNota());
            stmt.setString(2, avaliacao.getComentario());
            
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        
        
        
    }
    
}
