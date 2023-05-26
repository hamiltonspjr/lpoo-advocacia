package br.edu.ifsul.cstsi.advocacia.Tribunal;

import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Scanner;

@Controller
public class TribunalController {
    private static final Scanner input = new Scanner(System.in);
    private static TribunalService tribunalService;

    public TribunalController(TribunalService tribunalService) {
        TribunalController.tribunalService = tribunalService;
    }

    public static void main(String[] args) {
        int option;
        do {
            System.out.println("\n\"----- Menu Tribunal -----\"");
            System.out.println(
                    """
                            1. Inserir novo tribunal
                            2. Atualizar tribunal
                            3. Excluir tribunal
                            4. Listar todos tribunais
                            5. Buscar tribunal por código
                            6. Buscar tribual por denominação
                            Opção (zero para sair):\s""");
            option = input.nextInt();
            input.nextLine();
            switch (option) {
                case 1 -> inserir();
                case 2 -> atualizar();
                case 3 -> excluir();
                case 4 -> selectAllTribunais();
                case 5 -> selectTribunalById();
                case 6 -> selectTribunalByDenominacao();
                default -> {
                    if(option != 0) System.out.println("Opção inválida.");
                }
            }
        } while(option != 0);
    }

    private static void inserir() {
        Tribunal tribunal = new Tribunal();
        System.out.println("\n Cadastro de novo Tribunal");
        System.out.println("Digite a denominação: ");
        tribunal.setDenominacao(input.nextLine());
        System.out.println("\nDigite o endereço do tribunal: ");
        tribunal.setEndereco(input.nextLine());
        System.out.println("Tribunal cadastrado com sucesso:" + tribunalService.insert(tribunal));
    }
    private static void atualizar() {
        System.out.println("\n Alterar um tribunal");
        Tribunal tribunal;
        int option = 0;
        do {
            System.out.println("\n Digite o código do tribunal (zero p/sair): ");
            Integer codigo = input.nextInt();
            input.nextLine();
            if(codigo == 0) {
                option = 0;
            } else {
                tribunal = tribunalService.getTribunalById(codigo);
                if(tribunal == null) {
                    System.out.println("Código inválido, tribunal não existe.");
                } else {
                    System.out.println("Denominação: " + tribunal.getDenominacao());
                    System.out.println("Alterar? (0-sim/1-não)");
                    if(input.nextInt() == 0) {
                        input.nextLine();
                        System.out.println("Digite a nova denominação do tribunal: ");
                        tribunal.setDenominacao(input.nextLine());
                    }
                    System.out.println("Endereço: " + tribunal.getEndereco());
                    System.out.println("Alterar? (0-sim/1-não)");
                    if(input.nextInt() == 0) {
                        input.nextLine();
                        System.out.println("Digite o novo endereço do tribunal: ");
                        tribunal.setEndereco(input.nextLine());
                    }
                    if(tribunalService.update(tribunal) != null) {
                        System.out.println("Tribunal atualizado com sucesso.");
                    } else {
                        System.out.println("Não foi possível atualizar este tribunal.");
                    }
                    option = 1;
                }
            }
        } while (option != 0);
    }
    private static void excluir() {
        System.out.println("\n Excluir um tribunal");
        Tribunal tribunal;
        int opcao = 0;
        do {
            System.out.print("\nDigite o código do tribunal (Zero p/sair): ");
            Integer codigo = input.nextInt();
            input.nextLine();
            if (codigo == 0) {
                opcao = 0;
            } else if(codigo > 0){
                tribunal = tribunalService.getTribunalById(codigo);
                if (tribunal == null) {
                    System.out.println("Código inválido.");
                } else {
                    System.out.println(tribunal);
                    System.out.print("Excluir este tribunal? (0-sim/1-não) ");
                    if (input.nextInt() == 0) {
                        input.nextLine();
                        System.out.print("Tem certeza disso? (0-sim/1-não) ");
                        input.nextLine();
                        tribunalService.delete(tribunal.getCodtribunal());
                        System.out.println("Tribunal excluído com sucesso:" + tribunal);
                    }

                }
            } else {
                System.out.println("Digite um código válido!!!");
            }

        } while (opcao != 0);
    }
    private static void selectAllTribunais() {
        System.out.println("\nLista de tribunais cadastrados no banco:\n" + tribunalService.getTribunais());
    }
    private static void selectTribunalById() {
        System.out.print("\nDigite o código do tribunal: ");
        Tribunal tribunal = tribunalService.getTribunalById(input.nextInt());
        input.nextLine();
        if (tribunal != null) {
            System.out.println(tribunal);
        } else {
            System.out.println("Tribunal não localizado.");
        }
    }
    private static void selectTribunalByDenominacao(){
        System.out.print("Digite a denominacao do tribunal: ");
        String denominacao = input.next();
        System.out.println("Chave de pesquisa: " + denominacao);
        List<Tribunal> tribunais = tribunalService.getTribunalByDemoninacao(denominacao + "%");
        if (tribunais.isEmpty()) {
            System.out.println("Não há registros correspondentes para: " + denominacao);
        } else {
            System.out.println(tribunais);
        }

    }
    }

