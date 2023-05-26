package br.edu.ifsul.cstsi.advocacia.Vara;

import br.edu.ifsul.cstsi.advocacia.Tribunal.Tribunal;
import br.edu.ifsul.cstsi.advocacia.Tribunal.TribunalService;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Scanner;


@Controller

public class VaraController {
    private static final Scanner input = new Scanner(System.in);
    private static VaraService varaService;
    private static TribunalService tribunalService;

    public VaraController(VaraService varaService, TribunalService tribunalService) {
        VaraController.varaService = varaService;
        VaraController.tribunalService = tribunalService;
    }

    public static void main(String[] args) {
        int opcao;
        do {
            System.out.print("\n\"-------  Menu Vara -------\"");
            System.out.print(
                    """
    
                        1. Inserir nova Vara
                        2. Atualizar uma Vara
                        3. Excluir uma Vara
                        4. Listar todas as varas
                        5. Buscar vara pelo código
                        6. Buscar vara pelo nome
                        Opção (Zero p/sair):\s""");
            opcao = input.nextInt();
            input.nextLine();
            switch (opcao) {
                case 1 -> inserir();
                case 2 -> atualizar();
                case 3 -> excluir();
                case 4 -> selectVaras();
                case 5 -> selectVaraById();
                case 6 -> selectVaraByNome();
                default -> {
                    if (opcao != 0) System.out.println("Opção inválida.");
                }
            }
        } while (opcao != 0);
    }

    public static void inserir() {
        Vara vara = new Vara();
        System.out.println("\nCadastro de uma nova vara");
        System.out.print("Digite o nome da vara: ");
        vara.setNome(input.nextLine());
        System.out.print("\nDigite a descrição da vara: ");
        vara.setDescricao(input.nextLine());
        System.out.println("\n Tribunais cadastrados: ");
        System.out.println(tribunalService.getTribunais());
        System.out.println("\nDigite o código do tribunal a qual essa vara pertence: ");
        Tribunal tribunal = tribunalService.getTribunalById(input.nextInt());
        vara.setTribunalByCodtribunal(tribunal);
        System.out.println("Vara salva com sucesso:" + varaService.insert(vara));
    }
    public static void atualizar() {
        System.out.println("\nAlterar uma vara:");
        Vara vara;
        int opcao = 0;
        do {
            System.out.print("\nDigite o código da vara (Zero p/sair): ");
            Integer codigo = input.nextInt();
            if(codigo == 0) {
                opcao = 0;
            } else {
                vara = varaService.getVaraById(codigo);
                if(vara == null) {
                    System.out.println("Código inválido.");
                } else {
                    System.out.println("Nome: " + vara.getNome());
                    System.out.print("Alterar? (0-sim/1-não) ");
                    if(input.nextInt() == 0){
                        input.nextLine();
                        System.out.println("Digite o novo nome da vara: ");
                        vara.setNome(input.nextLine());
                    }
                    System.out.println("Descrição: " + vara.getDescricao());
                    System.out.print("Alterar? (0-sim/1-não) ");
                    if(input.nextInt() == 0){
                        input.nextLine();
                        System.out.print("Digite a nova descrição: ");
                        vara.setDescricao(input.nextLine());
                    }
                    if(varaService.update(vara) != null) {
                        System.out.println("Vara atualizada com sucesso. " + varaService.getVaraById(vara.getCodvara()));
                    } else {
                        System.out.println("Não foi possível atualizar esta vara.");
                    }

                    opcao = 1;


                }
            }
        } while (opcao != 0);
    }

    public static void excluir() {
        System.out.println("\nExcluir uma vara");
        Vara vara;
        int opcao = 0;
        do {
            System.out.print("\nDigite o código da vara (Zero p/sair): ");
            Integer codigo = input.nextInt();
            input.nextLine();
            if(codigo == 0) {
                opcao = 0;
            } else if(codigo > 0) {
                vara = varaService.getVaraById(codigo);
                if(vara == null) {
                    System.out.println("Código inválido.");
                } else {
                    System.out.println(vara);
                    System.out.print("Excluir esta vara? (0-sim/1-não) ");
                    if(input.nextInt() == 0) {
                        input.nextLine();
                        System.out.print("Tem certeza disso? (0-sim/1-não) ");
                        input.nextLine();
                        varaService.delete(vara.getCodvara());
                        System.out.println("vara excluída com sucesso:" + vara);
                    }
                }
            } else {
                System.out.println("Digite um código válido!!!");
            }
        } while (opcao != 0);
    }

    private static void selectVaras() {
        System.out.println("\nLista de varas cadastradas no banco de dados:\n" + varaService.getVaras());
    }
    private static void selectVaraById() {
        System.out.print("\nDigite o código da vara: ");
        Vara vara = varaService.getVaraById(input.nextInt());
        input.nextLine();
        if(vara != null) {
            System.out.println(vara);
        } else {
            System.out.println("Vara não localizada.");
        }
    }
    private static void selectVaraByNome() {
        System.out.print("Digite o nome da vara: ");
        String nome = input.next();
        System.out.println("Chave de pesquisa: " + nome);
        List<Vara> varas = varaService.getVaraByNome(nome + "%");
        if(varas.isEmpty()) {
            System.out.println("Não há vara correspondente para: " + nome);
        } else {
            System.out.println(varas);
        }
    }
}
