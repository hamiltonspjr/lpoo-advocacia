package br.edu.ifsul.cstsi.advocacia.Advogado;

import org.springframework.stereotype.Controller;
import java.util.List;
import java.util.Scanner;
@Controller
public class AdvogadoController {
    private static final Scanner input = new Scanner(System.in);
    private static AdvogadoService advogadoService;

    public AdvogadoController(AdvogadoService advogadoService) {
        AdvogadoController.advogadoService = advogadoService;
    }

    public static void main(String[] args) {
        int opcao;
        do {
            System.out.print("\n\"Menu Advogado\"");
            System.out.print(
                    """
    
                        1. Inserir novo advogado
                        2. Atualizar um advogado
                        3. Excluir um advogado
                        4. Listar todos os advogados
                        5. Buscar advogado pelo código
                        6. Buscar advogado pelo nome
                        7. Buscar advogado pela Oab
                        Opção (Zero p/sair):\s""");
            opcao = input.nextInt();
            input.nextLine();
            switch (opcao) {
                case 1 -> inserir();
                case 2 -> atualizar();
                case 3 -> excluir();
                case 4 -> selectAdvogados();
                case 5 -> selectAdvogadoById();
                case 6 -> selectAdvogadoByNome();
                case 7 -> selectAdvogadoByOab();
                default -> {
                    if (opcao != 0) System.out.println("Opção inválida.");
                }
            }
        } while (opcao != 0);
    }

    private static void inserir() {
        Advogado advogado = new Advogado();
        System.out.println("\nCadastro de novo Advogado");
        System.out.println("Digite o número da oab do advogado:");
        advogado.setOab(input.nextLine());
        System.out.println("Digite o nome do advogado:");
        advogado.setNome(input.nextLine());
        System.out.println("Digite o endereço do advogado:");
        advogado.setEndereco(input.nextLine());
        System.out.println("Digite o bairro do advogado:");
        advogado.setBairro(input.nextLine());
        System.out.println("Digite o CEP do advogado:");
        advogado.setCep(input.nextLine());
        System.out.println("Digite o email do advogado:");
        advogado.setEmail(input.nextLine());
        System.out.println("Advogado salvo com sucesso." + advogadoService.insert(advogado));
    }
    private static void atualizar() {
        System.out.println("\n Alterar um advogado");
        Advogado advogado;
        int opcao = 0;
        do {
            System.out.print("\nDigite o código do advogado (Zero p/sair): ");
            Integer codigo = input.nextInt();
            input.nextLine();
            if(codigo == 0) {
                opcao = 0;
            } else {
                advogado = advogadoService.getAdvogadoById(codigo);
                if(advogado == null) {
                    System.out.println("Código inválido.");
                } else {
                    System.out.println("Oab: " + advogado.getOab());
                    System.out.println("Alterar? (0-sim/1-não) ");
                    if (input.nextInt() == 0) {
                        input.nextLine();
                        System.out.println("Digite a nova OAB do advogado: ");
                        advogado.setOab(input.nextLine());
                    }
                    System.out.println("Nome: " + advogado.getNome());
                    System.out.println("Alterar? (0-sim/1-não) ");
                    if (input.nextInt() == 0) {
                        input.nextLine();
                        System.out.println("Digite o novo nome do advogado: ");
                        advogado.setNome(input.nextLine());
                    }
                    System.out.println("Endereço: " + advogado.getEndereco());
                    System.out.println("Alterar? (0-sim/1-não) ");
                    if (input.nextInt() == 0) {
                        input.nextLine();
                        System.out.println("Digite novo email do advogado: ");
                        advogado.setEndereco(input.nextLine());
                    }
                    System.out.println("Bairro: " + advogado.getBairro());
                    System.out.println("Alterar? (0-sim/1-não) ");
                    if (input.nextInt() == 0) {
                        input.nextLine();
                        System.out.println("Digite o novo bairro do advogado: ");
                        advogado.setBairro(input.nextLine());
                    }
                    System.out.println("CEP: " + advogado.getCep());
                    System.out.println("Alterar? (0-sim/1-não) ");
                    if (input.nextInt() == 0) {
                        input.nextLine();
                        System.out.println("Digite o novo CEP do advogado: ");
                        advogado.setCep(input.nextLine());
                    }
                    System.out.println("Email: " + advogado.getEmail());
                    System.out.println("Alterar? (0-sim/1-não) ");
                    if (input.nextInt() == 0) {
                        input.nextLine();
                        System.out.println("Digite o novo email do advogado: ");
                        advogado.setEmail(input.nextLine());
                    }
                    if(advogadoService.update(advogado) != null) {
                        System.out.println("Advogado atualizado com sucesso.");
                    } else {
                        System.out.println("Não foi possível atualizar este advogado!");
                    }
                    opcao = 1;
                }
            }

        } while (opcao != 0);
    }

    private static void excluir() {
        System.out.println("\nExcluir um advogado");
        Advogado advogado;
        int opcao = 0;
        do {
            System.out.println("\nDigite o código do advogado (Zero /sair): ");
            Integer codigo = input.nextInt();
            input.nextLine();
            if(codigo == 0) {
                opcao = 0;
            } else if(codigo > 0) {
                advogado = advogadoService.getAdvogadoById(codigo);
                if(advogado == null) {
                    System.out.println("Código inválido.");
                } else {
                    System.out.println(advogado);
                    System.out.println("Excluir este advogado? 0-sim/1-não) ");
                    if (input.nextInt() == 0) {
                        input.nextLine();
                        System.out.println("Tem certeza disso? 0-sim/1-não)");
                        input.nextLine();
                        advogadoService.delete(advogado.getCodadvogado());
                        System.out.println("Produto excluído com sucesso: " + advogado);
                    }
                }
            } else {
                System.out.println("Digite um código válido!!!");
            }
        } while (opcao != 0);
    }
    private static void selectAdvogados() {
        System.out.println("\nLista de advogados cadastrados no banco de dados:\n" + advogadoService.getAdvogados());
    }
    private static void selectAdvogadoById() {
        System.out.print("\nDigite o código do advogado: ");
        Advogado advogado = advogadoService.getAdvogadoById(input.nextInt());
        input.nextLine();
        if (advogado != null) {
            System.out.println(advogado);
        } else {
            System.out.println("Código não localizado.");
        }
    }
    private static void selectAdvogadoByNome() {
        System.out.print("Digite o nome do advogado: ");
        String nome = input.next();
        System.out.println("Chave de pesquisa: " + nome);
        List<Advogado> advogados = advogadoService.getAdvogadoByNome(nome + "%");
        if (advogados.isEmpty()) {
            System.out.println("Não há registros correspondentes para: " + nome);
        } else {
            System.out.println(advogados);
        }
    }
    private static void selectAdvogadoByOab() {
        System.out.print("Digite o número da oab: ");
        Advogado advogado = advogadoService.getAdvogadoByAob(input.nextLine());
        input.nextLine();
        if (advogado != null) {
            System.out.println(advogado);
        } else {
            System.out.println("Oab não localizado.");
        }
    }
}
