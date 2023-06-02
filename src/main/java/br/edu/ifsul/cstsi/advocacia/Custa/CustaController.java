package br.edu.ifsul.cstsi.advocacia.Custa;

import br.edu.ifsul.cstsi.advocacia.Processo.Processo;
import br.edu.ifsul.cstsi.advocacia.Processo.ProcessoService;
import org.springframework.stereotype.Controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

@Controller

public class CustaController {
    private static final Scanner input = new Scanner(System.in);
    private static CustaService custaService;
    private static ProcessoService processoService;

    public CustaController(CustaService custaService, ProcessoService processoService) {
        CustaController.custaService = custaService;
        CustaController.processoService = processoService;
    }

    public static void main(String[] args) {
        int opcao;
        {
            do {
                System.out.print("\n\"Menu Custa\"");
                System.out.print(
                        """
                                        
                                1. Inserir novo custo
                                2. Atualizar um custo
                                3. Excluir um custo
                                4. Lista todos os custos
                                5. Buscar custo pelo código
                                6. Buscar custo pela data
                                7. Buscar custo pelo código do processo
                                Opção (Zero p/sair):\s""");
                opcao = input.nextInt();
                input.nextLine();
                switch (opcao) {
                    case 1 -> inserir();
                    case 2 -> atualizar();
                    case 3 -> excluir();
                    case 4 -> selectAllCusto();
                    case 5 -> selectCustoById();
                    case 6 -> selectCustoByData();
                    case 7 -> selectCustoByProcesso();
                    default -> {
                        if (opcao != 0) System.out.println("Opção inválida.");
                    }
                }
            } while (opcao != 0);
        }
    }

    private static void inserir() {
        Custa custa = new Custa();
        System.out.println("\n Cadastrar custo: ");
        System.out.println("\n Digite a data do custo: ");
        LocalDate data = LocalDate.parse(input.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        custa.setData(data);
        System.out.println("\n Digite a descrição do custo: ");
        custa.setDescricao(input.nextLine());
        System.out.println("\n Digite o valo do custo: ");
        custa.setValor(input.nextBigDecimal());
        System.out.println("\n Processos cadastrados no sistema: " + processoService.getProcessos());
        System.out.println("\n Digite o código do processo desse custo: ");
        Processo processo = processoService.getProcessoById(input.nextInt());
        custa.setProcessoByCodprocesso(processo);
        System.out.println("Custo cadastrado com sucesso:" + custaService.insert(custa));
    }

    private static void atualizar() {
        System.out.println("\nAtualizar um custo:");
        Custa custa;
        int opcao = 0;
        do {
            System.out.print("\nDigite o código do custo (Zero p/sair): ");
            Integer codigo = input.nextInt();
            input.nextLine();
            if (codigo == 0) {
                opcao = 0;
            } else {
                custa = custaService.getCustaById(codigo);
                if (custa == null) {
                    System.out.println("Código inválido.");
                } else {
                    System.out.println("Data: " + custa.getData());
                    System.out.print("Alterar? (0-sim/1-não) ");
                    if (input.nextInt() == 0) {
                        input.nextLine();
                        System.out.println("Digite a nova data do custo: ");
                        LocalDate data = LocalDate.parse(input.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                        custa.setData(data);
                    }
                    System.out.println("Descrição: " + custa.getDescricao());
                    System.out.print("Alterar? (0-sim/1-não) ");
                    if (input.nextInt() == 0) {
                        input.nextLine();
                        System.out.println("Digite a nova descrição do custo: ");
                        custa.setDescricao(input.nextLine());
                    }
                    System.out.println("Valor: " + custa.getValor());
                    System.out.print("Alterar? (0-sim/1-não) ");
                    if (input.nextInt() == 0) {
                        input.nextLine();
                        System.out.println("Digite o novo valor do custo: ");
                        custa.setValor(input.nextBigDecimal());
                    }
                    if (custaService.update(custa) != null) {
                        System.out.println("\n Custo atualizado com sucesso. " + custaService.getCustaById(custa.getCodcusta()));
                    } else {
                        System.out.println("Não foi possível atualizar o custo.");
                    }
                    opcao = 1;
                }
            }
        } while (opcao != 0);

    }
    private static void excluir() {
        System.out.println("\n Excluir um custo");
        Custa custa;
        int opcao = 0;
        do {
            System.out.print("\nDigite o código do custo (Zero p/sair): ");
            Integer codigo = input.nextInt();
            if (codigo == 0) {
                opcao = 0;
            } else if (codigo > 0){
                custa = custaService.getCustaById(codigo);
                if(custa == null) {
                    System.out.println("Código inválido.");
                } else {
                    System.out.println(custa);
                    System.out.print("Excluir este custo? (0-sim/1-não) ");
                    if (input.nextInt() == 0) {
                        input.nextLine();
                        System.out.print("Tem certeza disso? (0-sim/1-não) ");
                        input.nextLine();
                        custaService.delete(custa.getCodcusta());
                        System.out.println("Custo excluído com sucesso:" + custa);
                    }
                }
            } else {
                System.out.println("Digite um código válido!!!");
            }
        } while (opcao != 0);
    }

    private static void selectAllCusto() {
        System.out.println("\nLista de custos cadastrados no banco de dados:\n " + custaService.getCustos());
    }
    private static void selectCustoById() {
        System.out.println("\nDigite o código do custo: ");
        Custa custa = custaService.getCustaById(input.nextInt());
        input.nextLine();
        if(custa != null) {
            System.out.println(custa);
        } else {
            System.out.println("Código não localizado.");
        }
    }
    private static void selectCustoByData() {
        System.out.println("\nDigite a data do custo: ");
        LocalDate data = LocalDate.parse(input.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        List<Custa> custos = custaService.getCustaByData(data);
        if(custos.isEmpty()) {
            System.out.println("Não há registros correspondentes para: " + data);
        } else {
            System.out.println(custos);
        }
    }
    private static void selectCustoByProcesso() {
        System.out.println("\nDigite o código do processo: ");
        Integer codigo = input.nextInt();
        Processo processo = processoService.getProcessoById(codigo);
        List<Custa> custos = custaService.getCustaByProcesso(processo);
        if(custos.isEmpty()) {
            System.out.println("Não há registros correspondentes para: " + codigo);
        } else {
            System.out.println(custos);
        }
    }
}
