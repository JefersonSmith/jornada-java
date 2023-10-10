package DAO;

import conexao.Conexao;
import model.Viagem;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.text.SimpleDateFormat;
import model.Destino;
import model.Passageiro;


public class ViagemDAO {

    Connection conn = null;
    PreparedStatement pstm = null;

    public void cadastrarViagem(Viagem viagem) {

        String sql = "INSERT INTO viagens (passageiro_id, destino_id, ida, volta) VALUES (?, ?, ?, ?)";

        try {

            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            conn = Conexao.getConnection();
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, viagem.getPassageiro().getId());
            pstm.setInt(2, viagem.getDestino().getId());
            pstm.setDate(3, new Date(formatter.parse(viagem.getIda()).getTime()));
            pstm.setDate(4, new Date(formatter.parse(viagem.getVolta()).getTime()));


            pstm.execute();
            System.out.println("Viagem cadastrada com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar viagem: " + e.getMessage());
        }
    }

    public void atualizarViagem(Viagem viagem) {

        String sql = "UPDATE viagens SET passageiro_id = ?, destino_id = ?, ida = ?, volta = ? WHERE id = ?";

        try {
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            conn = conexao.Conexao.getConnection();
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, viagem.getPassageiro().getId());
            pstm.setInt(2, viagem.getDestino().getId());
            pstm.setDate(3, new Date(formatter.parse(viagem.getIda()).getTime()));
            pstm.setDate(4, new Date(formatter.parse(viagem.getVolta()).getTime()));
            pstm.setInt(5, viagem.getId());
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

//        String sql = "SELECT * FROM viagens";
        String sql = "SELECT v.id, v.ida, v.volta, p.id as passageiro_id, " +
                "p.nome, p.idade, p.usuario, p.senha, d.id as destino_id, " +
                "d.cidade, d.pais, d.preco FROM viagens v " +
                "INNER JOIN passageiros p ON v.passageiro_id = p.id " +
                "INNER JOIN destinos d ON v.destino_id = d.id";

        try {
            conn = conexao.Conexao.getConnection();
            pstm = conn.prepareStatement(sql);
            rset = pstm.executeQuery();

            while (rset.next()) {
                Viagem viagem = new Viagem();
                Passageiro passageiro = new Passageiro();
                Destino destino = new Destino();

                viagem.setId(rset.getInt("id"));
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

                viagem.setIda(dateFormat.format(rset.getTimestamp("ida")));
                viagem.setVolta(dateFormat.format(rset.getTimestamp("volta")));

                passageiro.setId(rset.getInt("passageiro_id"));
                passageiro.setNome(rset.getString("nome"));
                passageiro.setIdade(rset.getInt("idade"));
                passageiro.setUsuario(rset.getString("usuario"));
                passageiro.setSenha(rset.getString("senha"));
                viagem.setPassageiro(passageiro);

                destino.setId(rset.getInt("destino_id"));
                destino.setCidade(rset.getString("cidade"));
                destino.setPais(rset.getString("pais"));
                destino.setPreco(rset.getDouble("preco"));
                viagem.setDestino(destino);


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



