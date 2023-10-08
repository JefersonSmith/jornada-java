import DAO.PassageiroDAO;
import DAO.ViagemDAO;
import model.Passageiro;
import DAO.DestinoDAO;
import model.Destino;
import model.Viagem;
import utils.Colors;

import java.time.LocalDate;
import java.time.LocalDateTime;
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
        String cidade, pais = "";
        double preco = 0.0;

        ViagemDAO viagemDAO = new ViagemDAO();
        Viagem viagem = new Viagem();
        String ida, volta = "";
        int idPassageiro, idDestino = 0;


        do {
            System.out.println(Colors.BLUE.get());
            System.out.println("  JJJJ   OOO   RRRR   N   N  AAAAA  DDDD   AAAAA");
            System.out.println("     J  O   O  R   R  NN  N  A   A  D   D  A   A");
            System.out.println("     J  O   O  RRRR   N N N  AAAAA  D   D  AAAAA");
            System.out.println("J    J  O   O  R  R   N  NN  A   A  D   D  A   A");
            System.out.println(" JJJ     OOO   R   R  N   N  A   A  DDDD   A   A");
            System.out.println(Colors.RESET.get());
            System.out.println(Colors.BLUE_BRIGHT.get() + "======== A melhor agência de viagens do Brasil ========" + Colors.RESET.get());
            System.out.println(Colors.BLACK_BACKGROUND_BRIGHT.get() + "[1]" + Colors.RESET.get() + " - Cadastro de passageiros");
            System.out.println(Colors.BLACK_BACKGROUND_BRIGHT.get() + "[2]" + Colors.RESET.get() + " - Cadastro de destinos");
            System.out.println(Colors.BLACK_BACKGROUND_BRIGHT.get() + "[3]" + Colors.RESET.get() + " - Cadastro de viagens");
            System.out.println(Colors.RED_BACKGROUND_BRIGHT.get() + "[5]" + Colors.RESET.get() + " - " + Colors.RED.get() + "Sair" + Colors.RESET.get());
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    do {
                        System.out.println(Colors.BLUE_BRIGHT.get() + "======== MENU DE PASSAGEIRO ========" + Colors.RESET.get());
                        System.out.println(Colors.BLACK_BACKGROUND_BRIGHT.get() + "[1]" + Colors.RESET.get() + " - Cadastrar passageiro");
                        System.out.println(Colors.BLACK_BACKGROUND_BRIGHT.get() + "[2]" + Colors.RESET.get() + " - Editar passageiro");
                        System.out.println(Colors.BLACK_BACKGROUND_BRIGHT.get() + "[3]" + Colors.RESET.get() + " - Excluir passageiro");
                        System.out.println(Colors.BLACK_BACKGROUND_BRIGHT.get() + "[4]" + Colors.RESET.get() + " - Listar passageiros");
                        System.out.println(Colors.RED_BACKGROUND_BRIGHT.get() + "[5]" + Colors.RESET.get() + " - " + Colors.RED.get() + "Voltar ao menu principal" + Colors.RESET.get());


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
                        System.out.println(Colors.BLUE_BRIGHT.get() + "======== MENU DE DESTINOS ========" + Colors.RESET.get());
                        System.out.println(Colors.BLACK_BACKGROUND_BRIGHT.get() + "[1]" + Colors.RESET.get() + " - Cadastrar destino");
                        System.out.println(Colors.BLACK_BACKGROUND_BRIGHT.get() + "[2]" + Colors.RESET.get() + " - Editar destino");
                        System.out.println(Colors.BLACK_BACKGROUND_BRIGHT.get() + "[3]" + Colors.RESET.get() + " - Excluir destino");
                        System.out.println(Colors.BLACK_BACKGROUND_BRIGHT.get() + "[4]" + Colors.RESET.get() + " - Listar destinos");
                        System.out.println(Colors.RED_BACKGROUND_BRIGHT.get() + "[5]" + Colors.RESET.get() + " - " + Colors.RED.get() + "Voltar ao menu principal" + Colors.RESET.get());

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
                case 3: {
                    System.out.println(Colors.BLUE_BRIGHT.get() + "======== MENU DE VIAGENS ========" + Colors.RESET.get());
                    System.out.println(Colors.BLACK_BACKGROUND_BRIGHT.get() + "[1]" + Colors.RESET.get() + " - Cadastrar viagem");
                    System.out.println(Colors.BLACK_BACKGROUND_BRIGHT.get() + "[2]" + Colors.RESET.get() + " - Editar viagem");
                    System.out.println(Colors.BLACK_BACKGROUND_BRIGHT.get() + "[3]" + Colors.RESET.get() + " - Excluir viagem");
                    System.out.println(Colors.BLACK_BACKGROUND_BRIGHT.get() + "[4]" + Colors.RESET.get() + " - Listar viagens");
                    System.out.println(Colors.RED_BACKGROUND_BRIGHT.get() + "[5]" + Colors.RESET.get() + " - " + Colors.RED.get() + "Voltar ao menu principal" + Colors.RESET.get());

                    opcao1 = sc.nextInt();

                    switch (opcao1) {
                        case 1:
                            System.out.println("Digite o ID do passageiro: ");
                            idPassageiro = sc.nextInt();
                            System.out.println("Digite o ID do destino: ");
                            idDestino = sc.nextInt();
                            System.out.println("Digite a data de ida: ");
                            ida = sc.next();
                            System.out.println("Digite a data de volta: ");
                            volta = sc.next();

                            Passageiro p = passageiroDAO.buscarPassageiro(idPassageiro);
                            Destino d = destinoDAO.buscarDestino(idDestino);

                            viagem.setPassageiro(p);
                            viagem.setDestino(d);
                            viagem.setIda(ida);
                            viagem.setVolta(volta);

                            viagemDAO.cadastrarViagem(viagem);


                            break;

                        case 2:
                            System.out.println("Digite o ID da viagem que deseja editar: ");
                            int id = sc.nextInt();
                            System.out.println("Digite o ID do passageiro: ");
                            idPassageiro = sc.nextInt();
                            System.out.println("Digite o ID do destino: ");
                            idDestino = sc.nextInt();
                            System.out.println("Digite a data de ida: ");
                            ida = sc.next();
                            System.out.println("Digite a data de volta: ");
                            volta = sc.next();

                            break;

                        case 3:
                            System.out.println("Digite o ID da viagem que deseja excluir: ");
                            id = sc.nextInt();
                            break;

                        case 4:
                            System.out.println("Listando viagens...");
                            for (Viagem v : viagemDAO.listarViagens()) {
                                System.out.println("ID: " + v.getId());
                                System.out.println("Nome do passageiro: " + v.getPassageiro().getNome());
                                System.out.println("Destino: " + v.getDestino().getCidade());
                                System.out.println("Data de ida: " + v.getIda());
                                System.out.println("Data de volta: " + v.getVolta());
                                System.out.println("==================================");
                            }
                            break;

                        case 5:
                            System.out.println("Saindo...");
                            break;
                        default:
                            System.out.println("Opção inválida!");
                            break;
                    }
                }
            }
        }
        while (opcao != 5);
        System.out.println("Saindo...");
        sc.close();
    }
}


