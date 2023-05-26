package br.edu.ifsul.cstsi.advocacia.Vara;

import org.springframework.stereotype.Controller;

import java.util.Scanner;

@Controller

public class VaraController {
    private static final Scanner input = new Scanner(System.in);
    private static VaraService varaService;

    public VaraController(VaraService varaService) {
        VaraController.varaService = varaService;
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
                        Opção (Zero p/sair):\s""");
            opcao = input.nextInt();
            input.nextLine();
        } while (opcao != 0);
    }

    public static void inserir() {
        Vara vara = new Vara();
        System.out.println("\nCadastro de uma nova vara");
        System.out.print("Digite a descrição da vara: ");
    }
}
