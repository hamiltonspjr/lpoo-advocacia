package br.edu.ifsul.cstsi.advocacia.Assume;

import br.edu.ifsul.cstsi.advocacia.Advogado.Advogado;
import br.edu.ifsul.cstsi.advocacia.Advogado.AdvogadoService;
import br.edu.ifsul.cstsi.advocacia.Processo.Processo;
import br.edu.ifsul.cstsi.advocacia.Processo.ProcessoService;
import org.springframework.stereotype.Controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

@Controller

public class AssumeController {
    private static final Scanner input = new Scanner(System.in);
    private static AssumeService assumeService;
    private static ProcessoService processoService;
    private static AdvogadoService advogadoService;

    public AssumeController(AssumeService assumeService, ProcessoService processoService, AdvogadoService advogadoService) {
        AssumeController.assumeService = assumeService;
        AssumeController.processoService = processoService;
        AssumeController.advogadoService = advogadoService;
    }

    public static void main(String[] args) {
        int opcao;
        do {
            System.out.print("\n\"-------  Menu Assume -------\"");
            System.out.print(
                    """
                        
                        1. Inserir um assume
                        2. Atualizar Assume
                        3. Excluir um assume
                        4. Listar todos assume
                        5. Buscar assume por código
                        6. Buscar assume por data de início
                        7. Buscar assume por data de fim
                        Opção (Zero p/sair):\s""");
            opcao = input.nextInt();
            input.nextLine();
            switch (opcao) {
                case 1 -> inserir();
                case 2 -> atualizar();
                case 3 -> excluir();
                case 4 -> selectAllAssumes();
                case 5 -> selectAssumeById();
                case 6 -> selectAssumeByDateInicio();
                case 7 -> selectAssumeByDateFim();
                default -> {
                    if (opcao != 0) System.out.println("Opção inválida.");
                }
            }
        } while (opcao != 0);
    }
    private static void inserir() {
        Assume assume = new Assume();
        System.out.println("\nCadastro de novo assume");
        System.out.println("Digite a data de início: dd/MM/yyyy");
        LocalDate dataInicio = LocalDate.parse(input.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        assume.setDataInicio(dataInicio);
        System.out.println("Digite a data de fim: dd/MM/yyyy");
        LocalDate dataFim = LocalDate.parse(input.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        assume.setDataFinal(dataFim);
        System.out.println("\nProcessos cadastrados no sistema: " + processoService.getProcessos());
        System.out.println("Digite o código do processo: ");
        Processo processo = processoService.getProcessoById(input.nextInt());
        assume.setProcessoByCodprocesso(processo);
        System.out.println("\nAdvogados cadastrados no sistema: " + advogadoService.getAdvogados());
        System.out.println("Digite o código do advogado: ");
        Advogado advogado = advogadoService.getAdvogadoById(input.nextInt());
        assume.setAdvogadoByCodadvogado(advogado);
        System.out.println("Assume cadastrado com sucesso: " + assumeService.insert(assume));
    }
    private static void atualizar() {
        System.out.println("\n Atualizar um Assume");
        Assume assume;
        int opcao = 0;
        do {
            System.out.print("\nDigite o código do assume (Zero p/sair): ");
            Integer codigo = input.nextInt();
            input.nextLine();
            if(codigo == 0) {
                opcao = 0;
            } else {
                assume = assumeService.getAssumeById(codigo);
                if(assume == null) {
                    System.out.println("Código inválido.");
                } else {
                    System.out.println("Data de início: " + assume.getDataInicio());
                    System.out.print("Alterar? (0-sim/1-não) ");
                    if (input.nextInt() == 0) {
                        input.nextLine();
                        System.out.println("Digite a nova data de início: dd/MM/yyyy ");
                        LocalDate data = LocalDate.parse(input.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                        assume.setDataInicio(data);
                    }
                    System.out.println("Data de fim: " + assume.getDataFinal());
                    System.out.print("Alterar? (0-sim/1-não) ");
                    if (input.nextInt() == 0) {
                        input.nextLine();
                        System.out.println("Digite a nova data de fim: dd/MM/yyyy ");
                        LocalDate data = LocalDate.parse(input.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                        assume.setDataFinal(data);
                    }
                    System.out.println("Processo: " + assume.getProcessoByCodprocesso());
                    System.out.print("Alterar? (0-sim/1-não) ");
                    if (input.nextInt() == 0) {
                        input.nextLine();
                        System.out.println("\nProcessos cadastrados no sistema: " + processoService.getProcessos());
                        System.out.println("Digite o código do processo: ");
                        Processo processo = processoService.getProcessoById(input.nextInt());
                        assume.setProcessoByCodprocesso(processo);
                    }
                    System.out.println("Advogado: " + assume.getAdvogadoByCodadvogado());
                    System.out.print("Alterar? (0-sim/1-não) ");
                    if (input.nextInt() == 0) {
                        input.nextLine();
                        System.out.println("\nAdvogados cadastrados no sistema: " + advogadoService.getAdvogados());
                        System.out.println("Digite o código do advogado: ");
                        Advogado advogado = advogadoService.getAdvogadoById(input.nextInt());
                        assume.setAdvogadoByCodadvogado(advogado);
                    }
                    if(assumeService.update(assume) != null) {
                        System.out.println("Assume atualizado com sucesso.");
                    } else {
                        System.out.println("Não foi possível atualizar este produto.");
                    }
                }
            }
        } while (opcao != 0);
    }
    private static void excluir() {
        System.out.println("\nExcluir um Assume");
        Assume assume;
        int opcao = 0;
        do {
            System.out.print("\nDigite o código do assume (Zero p/sair): ");
            Integer codigo = input.nextInt();
            input.nextLine();
            if(codigo == 0) {
                opcao = 0;
            } else if (codigo > 0){
                assume = assumeService.getAssumeById(codigo);
                if(assume == null) {
                    System.out.println("Código inválido.");
                } else {
                    System.out.println(assume);
                    System.out.print("Excluir este assume? (0-sim/1-não) ");
                    if (input.nextInt() == 0) {
                        input.nextLine();
                        System.out.print("Tem certeza disso? (0-sim/1-não) ");
                        input.nextLine();
                        assumeService.delete(assume.getCodassume());
                        System.out.println("Assume excluído com sucesso:" + assume);
                    }
                }
            } else {
                System.out.println("Digite um código válido!!!");
            }
        } while (opcao != 0);
    }

    private static void selectAllAssumes() {
        System.out.println("\nLista de assumes cadastrados no banco:\n" + assumeService.getAllAssume());
    }

    private static void selectAssumeById() {
        System.out.println("\nDigite o código do assume: ");
        Assume assume = assumeService.getAssumeById(input.nextInt());
        input.nextLine();
        if(assume != null) {
            System.out.println(assume);
        } else {
            System.out.println("Código não localizado");
        }
    }

    private static void selectAssumeByDateInicio() {
        System.out.println("\nDigite a data de início: dd/MM/yyyy");
        LocalDate data = LocalDate.parse(input.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        List<Assume> assumes = assumeService.getAssumeByDataInicio(data);
        if (assumes.isEmpty()) {
            System.out.println("\nNão há registros para a data: " + data);
        } else {
            System.out.println(assumes);
        }
    }
    private static void selectAssumeByDateFim() {
        System.out.println("\nDigite a data de fim: dd/MM/yyyy");
        LocalDate dataFim = LocalDate.parse(input.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        List<Assume> assumes = assumeService.getAssumeByDataFinal(dataFim);
        if (assumes.isEmpty()) {
            System.out.println("\nNão há registros para a data: " + dataFim);
        } else {
            System.out.println(assumes);
        }
    }
}
