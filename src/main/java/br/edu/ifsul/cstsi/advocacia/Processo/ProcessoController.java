package br.edu.ifsul.cstsi.advocacia.Processo;

import br.edu.ifsul.cstsi.advocacia.Advogado.AdvogadoService;
import br.edu.ifsul.cstsi.advocacia.Assume.Assume;
import br.edu.ifsul.cstsi.advocacia.Assume.AssumeService;
import br.edu.ifsul.cstsi.advocacia.Custa.Custa;
import br.edu.ifsul.cstsi.advocacia.Pessoa.Pessoa;
import br.edu.ifsul.cstsi.advocacia.Pessoa.PessoaService;
import br.edu.ifsul.cstsi.advocacia.Vara.Vara;
import br.edu.ifsul.cstsi.advocacia.Vara.VaraService;
import org.springframework.stereotype.Controller;

import java.sql.Date;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Scanner;

@Controller

public class ProcessoController {
    private static final Scanner input = new Scanner(System.in);
    private static ProcessoService processoService;
    private static PessoaService pessoaService;
    private static VaraService varaService;
    private static AdvogadoService advogadoService;
    private static AssumeService assumeService;
    public ProcessoController(ProcessoService processoService, PessoaService pessoaService, VaraService varaService, AssumeService assumeService, AdvogadoService advogadoService) {
        ProcessoController.processoService = processoService;
        ProcessoController.varaService = varaService;
        ProcessoController.assumeService = assumeService;
        ProcessoController.advogadoService = advogadoService;
        ProcessoController.pessoaService = pessoaService;
    }

    public static void main(String[] args) {
        int opcao;
        do{
            System.out.print("\n\"-------  MENU PRODUTO -------\"");
            System.out.print(
                    """
    
                        1. Inserir novo processo
                        2. Atualizar um processo
                        3. Excluir um processo
                        4. Listar todos os processos
                        5. Buscar processo pelo código
                        6. Buscar processo pelo número
                        Opção (Zero p/sair):\s""");
            opcao = input.nextInt();
            input.nextLine();
            switch (opcao) {
                case 1 -> inserir();
                case 2 -> atualizar();
                case 3 -> excluir();
                case 4 -> selectProcessos();
                case 5 -> selectProcessoById();
                case 6 -> selectProcessoByNumero();
                default -> {
                    if (opcao != 0) System.out.println("Opção inválida.");
                }
            }
        } while (opcao != 0);
    }

    private static void inserir() {
        Processo processo = new Processo();
        System.out.println("\nCadastrar novo processo:");
        System.out.println("Digite o número do processo: ");
        processo.setNumero(input.nextLine());
        System.out.println("\nDigite a data de abertura do processo: 'dd/MM/yyyy' ");
        LocalDate dataAbertura = LocalDate.parse(input.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        processo.setAbertura(dataAbertura);
        System.out.println("\nDigite a data de conclusao do processo: 'dd/MM/yyyy' ");
        LocalDate dataConclusao = LocalDate.parse(input.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        processo.setConclusao(dataConclusao);
        System.out.println("\nDigite a descrição do processo: ");
        processo.setDescricao(input.nextLine());
        System.out.println("\nDigite a situação do processo: ");
        processo.setSituacao(input.nextLine());
        System.out.println("\nPessoas cadastradas no sistema: ");
        System.out.println(pessoaService.getPessoas());
        System.out.println("\nDigite o código da pessoa que está processando: ");
        Pessoa pessoaCliente = pessoaService.getPessoaById(input.nextInt());
        processo.setPessoaByCodpessoa(pessoaCliente);
        System.out.println("\nDigite o código da pessoa que está sendo processada: ");
        Pessoa pessoaProcessada = pessoaService.getPessoaById(input.nextInt());
        processo.setReuByCodpessoa(pessoaProcessada);
        System.out.println("\nVaras cadastradas no sistema: ");
        System.out.println(varaService.getVaras());
        System.out.println("\nDigite o código da vara que irá cuidar do processo: ");
        Vara vara = varaService.getVaraById(input.nextInt());
        processo.setVaraByCodvara(vara);
        processoService.insert(processo);
        Assume assumeProcesso = new Assume();
        assumeProcesso.setDataInicio(dataAbertura);
        assumeProcesso.setDataFinal(dataConclusao);
        System.out.println("\nAdvogados cadastrados no sistema: ");
        System.out.println(advogadoService.getAdvogados());
        System.out.println("\nDigite o código do advogado que assumiu o processo: ");
        assumeProcesso.setAdvogadoByCodadvogado(advogadoService.getAdvogadoById(input.nextInt()));
        Processo processoCadastrado = processoService.getProcessoByNumero(processo.getNumero());
        assumeProcesso.setProcessoByCodprocesso(processoCadastrado);
        assumeService.insert(assumeProcesso);
        Custa custo = new Custa();
        System.out.println("\nCadastrando o custo do projeto:");
        input.nextLine();
        custo.setData(dataAbertura);
        System.out.println("\nDigite a descrição do custo: ");
        custo.setDescricao(input.nextLine());
        System.out.println("\nDigite o valor do custo: ");
        custo.setValor(input.nextBigDecimal());
        custo.setProcessoByCodprocesso(processoCadastrado);
        System.out.println("Processo cadastrado no sistema");
    }
    private static void atualizar() {
        System.out.println("Atualizar um Processo");
        Processo processo;
        int opcao = 0;
        do {
            System.out.print("\nDigite o código do processo (Zero p/sair): ");
            Integer codigo = input.nextInt();
            input.nextLine();
            if (codigo == 0) {
                opcao = 0;
            } else {
                processo = processoService.getProcessoById(codigo);
                if(processo == null) {
                    System.out.println("Código inválido.");
                } else {
                    System.out.println("Número: " + processo.getNumero());
                    System.out.print("Alterar? (0-sim/1-não) ");
                    if(input.nextInt() == 0){
                        input.nextLine();
                        System.out.println("Digite o novo número do processo: ");
                        processo.setNumero(input.nextLine());
                    }
                    System.out.println("Abertura: " + processo.getAbertura());
                    System.out.print("Alterar? (0-sim/1-não) ");
                    if(input.nextInt() == 0){
                        input.nextLine();
                        System.out.println("Digite nova data de abertura do processo: ");
                        LocalDate dataAbertura = LocalDate.parse(input.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                        processo.setAbertura(dataAbertura);
                    }
                    System.out.println("Conclusão: " + processo.getConclusao());
                    System.out.print("Alterar? (0-sim/1-não) ");
                    if(input.nextInt() == 0){
                        input.nextLine();
                        System.out.println("Digite nova data de conclusao do processo: ");
                        LocalDate dataConclusao = LocalDate.parse(input.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                        processo.setConclusao(dataConclusao);
                    }
                    System.out.println("Descrição: " + processo.getDescricao());
                    System.out.print("Alterar? (0-sim/1-não) ");
                    if(input.nextInt() == 0){
                        input.nextLine();
                        System.out.println("Digite nova descrição do processo: ");
                        processo.setDescricao(input.nextLine());
                    }
                    System.out.println("Situação: " + processo.getSituacao());
                    System.out.print("Alterar? (0-sim/1-não) ");
                    if(input.nextInt() == 0){
                        input.nextLine();
                        System.out.println("Digite nova situação do processo: ");
                        processo.setSituacao(input.nextLine());
                    }
                    if(processoService.update(processo) != null) {
                        System.out.println("Processo atualizado com sucesso. " + processoService.getProcessoById(processo.getCodprocesso()));
                    } else {
                        System.out.println("Não foi possível atualizar este cliente. Por favor, contate o administrador.");
                    }
                    opcao = 1;
                }
            }
        } while (opcao != 0);
    }
    private static void excluir() {
        System.out.println("Excluir um processo");
        Processo processo;
        int opcao = 0;
        do {
            System.out.print("\nDigite o código do processo (Zero p/sair): ");
            Integer codigo = input.nextInt();
            input.nextLine();
            if(codigo == 0) {
                opcao = 0;
            } else if (codigo > 0) {
                processo = processoService.getProcessoById(codigo);
                if(processo == null) {
                    System.out.println("Código inválido.");
                } else {
                    System.out.println(processo);
                    System.out.println("Excluir este processo? (0-sim/1-não)");
                    if(input.nextInt() == 0) {
                        input.nextLine();
                        System.out.print("Tem certeza disso? (0-sim/1-não) ");
                        input.nextLine();
                        processoService.delete(processo.getCodprocesso());
                        System.out.println("Processo excluido com sucesso: " + processo);
                    }
                }
            } else {
                System.out.println("Digite um código válido!!!");
            }
        } while (opcao != 0);
    }
    private static void selectProcessos() {
        System.out.println("\nLista de processos cadastrados:\n" + processoService.getProcessos());
    }
    private static void selectProcessoById() {
        System.out.println("\nDigite o código do processo: ");
        Processo processo = processoService.getProcessoById(input.nextInt());
        input.nextLine();
        if(processo != null) {
            System.out.println(processo);
        } else {
            System.out.println("Código não localizado.");
        }
    }
    private static void selectProcessoByNumero() {
        System.out.println("\nDigite o numero do processo: ");
        Processo processo = processoService.getProcessoByNumero(input.nextLine());
        input.nextLine();
        if(processo != null) {
            System.out.println(processo);
        } else {
            System.out.println("Código não localizado.");
        }
    }
}
