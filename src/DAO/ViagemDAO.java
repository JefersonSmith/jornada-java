package DAO;

import conexao.Conexao;
import model.Viagem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class ViagemDAO {

    Connection conn = null;
    PreparedStatement pstm = null;

    public void cadastrarViagem(Viagem viagem) {

        String sql = "INSERT INTO viagens (id_passageiro, id_destino, dia) VALUES (?, ?, ?)";

        try {
            conn = Conexao.getConnection();
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, viagem.getPassageiro().getId());
            pstm.setInt(2, viagem.getDestino().getId());
            pstm.setInt(3, viagem.getDia());
            pstm.execute();
            System.out.println("Viagem cadastrada com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar viagem: " + e.getMessage());
        }
    }

    public void atualizarViagem(Viagem viagem) {

        String sql = "UPDATE viagens SET id_passageiro = ?, id_destino = ?, dia = ? WHERE id = ?";

        try {
            conn = conexao.Conexao.getConnection();
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, viagem.getPassageiro().getId());
            pstm.setInt(2, viagem.getDestino().getId());
            pstm.setInt(3, viagem.getDia());
            pstm.setInt(4, viagem.getId());
            pstm.execute();
            System.out.println("Viagem atualizada com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao atualizar viagem: " + e.getMessage());
        }
    }

    public void excluirViagem(int id) {

        String sql = "DELETE FROM viagens WHERE id = ?";

        try {
            conn = conexao.Conexao.getConnection();
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, id);
            pstm.execute();
            System.out.println("Viagem excluída com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao excluir viagem: " + e.getMessage());
        }
    }

    public List<Viagem> listarViagens() {

        List<Viagem> viagens = new ArrayList<Viagem>();

        ResultSet rset = null;

        String sql = "SELECT * FROM viagens";

        try {
            conn = conexao.Conexao.getConnection();
            pstm = conn.prepareStatement(sql);
            rset = pstm.executeQuery();

            while (rset.next()) {
                Viagem viagem = new Viagem();
                viagem.setId(rset.getInt("id"));
                viagem.getPassageiro().setId(rset.getInt("id_passageiro"));
                viagem.getDestino().setId(rset.getInt("id_destino"));
                viagem.setDia(rset.getInt("dia"));
                viagens.add(viagem);
            }

            System.out.println("Viagens listadas com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao listar viagens: " + e.getMessage());
            return null;
        }
        return viagens;
    }
}


