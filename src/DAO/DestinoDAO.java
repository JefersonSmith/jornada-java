package DAO;

import conexao.Conexao;
import model.Destino;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DestinoDAO {

    Connection conn = null;
    PreparedStatement pstm = null;

    public void cadastrarDestino(Destino destino) {

        String sql = "INSERT INTO destinos (dia, cidade, pais, preco) VALUES (?, ?, ?, ?)";

        try {
            conn = Conexao.getConnection();
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, destino.getDia());
            pstm.setString(2, destino.getCidade());
            pstm.setString(3, destino.getPais());
            pstm.setDouble(4, destino.getPreco());
            pstm.execute();
            System.out.println("Destino cadastrado com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar destino: " + e.getMessage());
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }

            } catch (Exception e) {
                System.out.println("Erro ao fechar conexão: " + e.getMessage());
            }
        }
    }

    public void atualizarDestino(Destino destino) {

        String sql = "UPDATE destinos SET dia = ?, cidade = ?, pais = ?, preco = ? WHERE id = ?";

        try {
            conn = Conexao.getConnection();
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, destino.getDia());
            pstm.setString(2, destino.getCidade());
            pstm.setString(3, destino.getPais());
            pstm.setDouble(4, destino.getPreco());
            pstm.setInt(5, destino.getId());
            pstm.execute();
            System.out.println("Destino atualizado com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao atualizar destino: " + e.getMessage());
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }

            } catch (Exception e) {
                System.out.println("Erro ao fechar conexão: " + e.getMessage());
            }
        }
    }

    public List<Destino> listarDestinos() {
        String sql = "SELECT * FROM destinos";
        List<Destino> destinos = new ArrayList<Destino>();
        ResultSet rs = null;
        PreparedStatement pstm = null;

        try {
            conn = Conexao.getConnection();
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();

            while (rs.next()) {
                Destino destino = new Destino();
                destino.setId(rs.getInt("id"));
                destino.setDia(rs.getString("dia"));
                destino.setCidade(rs.getString("cidade"));
                destino.setPais(rs.getString("pais"));
                destino.setPreco(rs.getDouble("preco"));
                destinos.add(destino);
            }

        } catch (Exception e) {
            System.out.println("Erro ao listar destinos: " + e.getMessage());
            return null;
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }

            } catch (Exception e) {
                System.out.println("Erro ao fechar conexão: " + e.getMessage());
            }
        }
        return destinos;

    }

}