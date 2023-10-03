import DAO.PassageiroDAO;
import model.Passageiro;
import DAO.DestinoDAO;
import model.Destino;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        PassageiroDAO passageiroDAO = new PassageiroDAO();
        Passageiro passageiro = new Passageiro();

        Scanner sc = new Scanner(System.in);
        int opcao = 0;
        int opcao1 = 0;
        String nome, usuario, senha = "";
        int idade = 0;

        DestinoDAO destinoDAO = new DestinoDAO();
        Destino destino = new Destino();
        String dia, cidade, pais = "";
        double preco = 0.0;


        do {
            System.out.println("======== JORNADA ========");
            System.out.println("[1] - Cadastro de passageiros");
            System.out.println("[2] - Cadastro de destinos");
            System.out.println("[5] - Sair");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    do {
                        System.out.println("======== MENU DE PASSAGEIRO ========");
                        System.out.println("[1] - Cadastrar passageiro");
                        System.out.println("[2] - Editar passageiro");
                        System.out.println("[3] - Excluir passageiro");
                        System.out.println("[4] - Listar passageiros");
                        System.out.println("[5] - Voltar ao menu principal");

                        opcao1 = sc.nextInt();

                        switch (opcao1) {
                            case 1:
                                System.out.println("Digite o nome do passageiro: ");
                                nome = sc.next();
                                System.out.println("Digite a idade do passageiro: ");
                                idade = sc.nextInt();
                                System.out.println("Digite o usuário(login)): ");
                                usuario = sc.next();
                                System.out.println("Digite a senha: ");
                                senha = sc.next();

                                passageiro.setNome(nome);
                                passageiro.setIdade(idade);
                                passageiro.setUsuario(usuario);
                                passageiro.setSenha(senha);
                                passageiroDAO.cadastrarPassageiro(passageiro);
                                break;

                            case 2:
                                System.out.println("Digite o ID do passageiro que deseja editar: ");
                                int id = sc.nextInt();
                                System.out.println("Digite o nome do passageiro: ");
                                nome = sc.next();
                                System.out.println("Digite a idade do passageiro: ");
                                idade = sc.nextInt();
                                System.out.println("Digite o usuário(login)): ");
                                usuario = sc.next();
                                System.out.println("Digite a senha: ");
                                senha = sc.next();

                                passageiro.setId(id);
                                passageiro.setNome(nome);
                                passageiro.setIdade(idade);
                                passageiro.setUsuario(usuario);
                                passageiro.setSenha(senha);
                                passageiroDAO.atualizarPassageiro(passageiro);
                                break;

                            case 3:
                                System.out.println("Digite o ID do passageiro que deseja excluir: ");
                                id = sc.nextInt();
                                passageiroDAO.excluirPassageiro(id);
                                break;

                            case 4:
                                System.out.println("Listando passageiros...");
                                for (Passageiro p : passageiroDAO.listarPassageiros()) {
                                    System.out.println("ID: " + p.getId());
                                    System.out.println("Nome: " + p.getNome());
                                    System.out.println("Idade: " + p.getIdade());
                                    System.out.println("Usuário: " + p.getUsuario());
                                    System.out.println("Senha: " + p.getSenha());
                                    System.out.println("==================================");
                                }

                                break;
                            case 5:
                                System.out.println("Voltando ao menu anterior...");
                                break;
                        }

                    } while (opcao1 != 5);
                    break;

                case 2: {
                    do {
                        System.out.println("======== MENU DE DESTINOS ========");
                        System.out.println("[1] - Cadastrar destino");
                        System.out.println("[2] - Editar destino");
                        System.out.println("[3] - Excluir destino");
                        System.out.println("[4] - Listar destinos");
                        System.out.println("[5] - Voltar ao menu principal");

                        opcao1 = sc.nextInt();

                        switch (opcao1) {
                            case 1:
                                System.out.println("Digite a cidade do destino: ");
                                cidade = sc.next();
                                System.out.println("Digite o país do destino: ");
                                pais = sc.next();
                                System.out.println("Digite o preço do destino: ");
                                preco = sc.nextDouble();

                                destino.setCidade(cidade);
                                destino.setPais(pais);
                                destino.setPreco(preco);
                                destinoDAO.cadastrarDestino(destino);
                                break;

                            case 2:
                                System.out.println("Digite o ID do destino que deseja editar: ");
                                int id = sc.nextInt();
                                System.out.println("Digite a cidade do destino: ");
                                cidade = sc.next();
                                System.out.println("Digite o país do destino: ");
                                pais = sc.next();
                                System.out.println("Digite o preço do destino: ");
                                preco = sc.nextDouble();

                                destino.setId(id);
                                destino.setCidade(cidade);
                                destino.setPais(pais);
                                destino.setPreco(preco);
                                destinoDAO.atualizarDestino(destino);
                                break;

                            case 3:
                                System.out.println("Digite o ID do destino que deseja excluir: ");
                                id = sc.nextInt();
                                destinoDAO.excluirDestino(id);
                                break;

                            case 4:
                                System.out.println("Listando destinos...");
                                for (Destino d : destinoDAO.listarDestinos()) {
                                    System.out.println("ID: " + d.getId());
                                    System.out.println("Cidade: " + d.getCidade());
                                    System.out.println("País: " + d.getPais());
                                    System.out.println("Preço: " + d.getPreco());
                                }

                            case 5:
                                System.out.println("Saindo...");
                                break;
                            default:
                                System.out.println("Opção inválida!");
                                break;
                        }
                    } while (opcao1 != 5);
                    break;

                }
            }
        }
        while (opcao != 5);
        sc.close();
    }
}


