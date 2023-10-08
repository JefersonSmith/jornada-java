package DAO;

import conexao.Conexao;
import model.Passageiro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PassageiroDAO {

    Connection conn = null;
    PreparedStatement pstm = null;

    public void cadastrarPassageiro(Passageiro passageiro) {

        String sql = "INSERT INTO passageiros (nome, idade, usuario, senha) VALUES (?, ?, ?, ?)";

        try {
            conn = Conexao.getConnection();
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, passageiro.getNome());
            pstm.setInt(2, passageiro.getIdade());
            pstm.setString(3, passageiro.getUsuario());
            pstm.setString(4, passageiro.getSenha());
            pstm.execute();
            System.out.println("Passageiro cadastrado com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar passageiro: " + e.getMessage());
        }
    }

    public void atualizarPassageiro(Passageiro passageiro) {

        String sql = "UPDATE passageiros SET nome = ?, idade = ?, usuario = ?, senha = ? WHERE id = ?";

        try {
            conn = conexao.Conexao.getConnection();
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, passageiro.getNome());
            pstm.setInt(2, passageiro.getIdade());
            pstm.setString(3, passageiro.getUsuario());
            pstm.setString(4, passageiro.getSenha());
            pstm.setInt(5, passageiro.getId());
            pstm.execute();
            System.out.println("Passageiro atualizado com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao atualizar passageiro: " + e.getMessage());
        }
    }

    public void excluirPassageiro(int id) {

        String sql = "DELETE FROM passageiros WHERE id = ?";

        try {
            conn = conexao.Conexao.getConnection();
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, id);
            pstm.execute();
            System.out.println("Passageiro excluído com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao excluir passageiro: " + e.getMessage());
        }
    }

    public List<Passageiro> listarPassageiros() {
        String sql = "SELECT * FROM passageiros";
        List<Passageiro> passageiros = new ArrayList<Passageiro>();
        ResultSet rs = null;
        PreparedStatement pstm = null;

        try {
            conn = conexao.Conexao.getConnection();
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();

            while (rs.next()) {
                Passageiro passageiro = new Passageiro();
                passageiro.setId(rs.getInt("id"));
                passageiro.setNome(rs.getString("nome"));
                passageiro.setIdade(rs.getInt("idade"));
                passageiro.setUsuario(rs.getString("usuario"));
                passageiro.setSenha(rs.getString("senha"));
                passageiros.add(passageiro);
            }

        } catch (Exception e) {
            System.out.println("Erro ao listar passageiros: " + e.getMessage());
            return null;
        }
        return passageiros;

    }

    public Passageiro buscarPassageiro(int id) {
        String sql = "SELECT * FROM passageiros WHERE id = ?";
        Passageiro passageiro = new Passageiro();
        ResultSet rs = null;
        PreparedStatement pstm = null;

        try {
            conn = conexao.Conexao.getConnection();
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();

            while (rs.next()) {
                passageiro.setId(rs.getInt("id"));
                passageiro.setNome(rs.getString("nome"));
                passageiro.setIdade(rs.getInt("idade"));
                passageiro.setUsuario(rs.getString("usuario"));
                passageiro.setSenha(rs.getString("senha"));
            }

        } catch (Exception e) {
            System.out.println("Erro ao buscar passageiro: " + e.getMessage());
            return null;
        }
        return passageiro;

    }

}
