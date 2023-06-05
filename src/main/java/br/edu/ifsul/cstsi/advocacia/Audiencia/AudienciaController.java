package br.edu.ifsul.cstsi.advocacia.Audiencia;

import br.edu.ifsul.cstsi.advocacia.Processo.Processo;
import br.edu.ifsul.cstsi.advocacia.Processo.ProcessoService;
import org.springframework.stereotype.Controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

@Controller

public class AudienciaController {
    private static final Scanner input = new Scanner(System.in);
    private static AudienciaService audienciaService;
    private static ProcessoService processoService;

    public AudienciaController(AudienciaService audienciaService, ProcessoService processoService) {
        AudienciaController.audienciaService = audienciaService;
        AudienciaController.processoService = processoService;
    }

    public static void main(String[] args) {
        int opcao;
        do {
            System.out.print("\n\"-------  Menu Audiência -------\"");
            System.out.print(
                    """
    
                        1. Inserir nova audiência
                        2. Atualizar uma audiência
                        3. Excluir uma audiência
                        4. Listar todas as audiências
                        5. Buscar audiência pelo código
                        6. Buscar pela data
                        Opção (Zero p/sair):\s""");
            opcao = input.nextInt();
            input.nextLine();
            switch (opcao) {
                case 1 -> inserir();
                case 2 -> atualizar();
                case 3 -> excluir();
                case 4 -> selectAllAudiencias();
                case 5 -> selectAudienciaById();
                case 6 -> selectAudienciaByDate();
                default -> {
                    if (opcao != 0) System.out.println("Opção inválida.");
                }
            }
        }while (opcao !=0);
    }
    private static void inserir() {
        Audiencia audiencia = new Audiencia();
        System.out.println("\nCadastrar nova audiência");
        System.out.println("Digite a data da audiência: dd/MM/yyyy ");
        LocalDate data = LocalDate.parse(input.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        audiencia.setData(data);
        System.out.println("Digite o paracer: ");
        audiencia.setParecer(input.nextLine());
        System.out.println("Processos cadastrados no sistema:" + processoService.getProcessos());
        System.out.println("\nDigite o código do processo relacionado a essa audiência: ");
        Processo processo = processoService.getProcessoById(input.nextInt());
        audiencia.setProcessoByCodprocesso(processo);
        System.out.println("Audiência salva com sucesso: " + audienciaService.insert(audiencia));
    }
    private static void atualizar() {
        System.out.println("\nAlterar uma audiência");
        Audiencia audiencia;
        int opcao = 0;
        do {
            System.out.print("\nDigite o código da audiência (Zero p/sair): ");
            Integer codigo  = input.nextInt();
            input.nextLine();
            if (codigo == 0) {
                opcao = 0;
            } else {
                audiencia = audienciaService.getAudienciaById(codigo);
                if(audiencia == null) {
                    System.out.println("Código inválido");
                } else {
                    System.out.println("Data: " + audiencia.getData());
                    System.out.print("Alterar? (0-sim/1-não) ");
                    if (input.nextInt() == 0) {
                        input.nextLine();
                        System.out.println("Digite a nova data da audiência: dd/MM/yyyy ");
                        LocalDate data = LocalDate.parse(input.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                        audiencia.setData(data);
                    }
                    System.out.println("Parecer: " + audiencia.getParecer());
                    System.out.print("Alterar? (0-sim/1-não) ");
                    if (input.nextInt() == 0) {
                        input.nextLine();
                        System.out.println("Digite o novo parecer audiência: ");
                        audiencia.setParecer(input.nextLine());
                    }
                    if (audienciaService.update(audiencia) != null) {
                        System.out.println("Audiência atualiza com sucesso.");
                    } else {
                        System.out.println("Não foi possível atualizar esta audiência.");
                    }
                    opcao = 1;
                }
            }
        } while (opcao != 0);
    }
    private static void excluir() {
        System.out.println("\nExcluir uma audiência");
        Audiencia audiencia;
        int opcao = 0;
        do {
            System.out.print("\nDigite o código da audiência (Zero p/sair): ");
            Integer codigo = input.nextInt();
            input.nextLine();
            if (codigo == 0) {
                opcao = 0;
            } else if(codigo > 0) {
                audiencia = audienciaService.getAudienciaById(codigo);
                if (audiencia == null) {
                    System.out.println("Código inválido.");
                } else {
                    System.out.println(audiencia);
                    System.out.print("Excluir esta audiência? (0-sim/1-não) ");
                    if(input.nextInt() == 0) {
                        input.nextLine();
                        System.out.print("Tem certeza disso? (0-sim/1-não) ");
                        audienciaService.delete(audiencia.getCodaudiencia());
                        System.out.println("Audiência excluída com sucesso: " + audiencia);
                    }
                }
            } else {
                System.out.println("Digite um código válido!!!");
            }
        } while (opcao != 0);
    }
    private static void selectAllAudiencias() {
        System.out.println("\nLista de audiências cadastradas no sistema:\n" + audienciaService.getAudiencias());
    }
    private static void selectAudienciaById() {
        System.out.println("\nDigite o código da audiência: ");
        Audiencia audiencia = audienciaService.getAudienciaById(input.nextInt());
        input.nextLine();
        if(audiencia != null) {
            System.out.println(audiencia);
        } else {
            System.out.println("Código não localizado.");
        }
    }
    private static void selectAudienciaByDate() {
        System.out.println("\nDigite a data da audiência: dd/MM/yyyy ");
        LocalDate data = LocalDate.parse(input.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        List <Audiencia> audiencias = audienciaService.getAudienciasByDate(data);
        input.nextLine();
        if(audiencias.isEmpty()) {
            System.out.println("Data não localizada.");
        } else {
            System.out.println(audiencias);
        }
    }
}
