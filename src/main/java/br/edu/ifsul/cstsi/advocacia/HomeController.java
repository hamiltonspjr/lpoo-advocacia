package br.edu.ifsul.cstsi.advocacia;

import br.edu.ifsul.cstsi.advocacia.Tribunal.TribunalController;
import br.edu.ifsul.cstsi.advocacia.Vara.VaraController;


import java.util.Scanner;

public class HomeController {

    private static final Scanner input = new Scanner(System.in);

    public static void main() {

        int opcao;
        do {
            System.out.print("\n-------  Home -------");
            System.out.print(
                    """
    
                        1. Tribunal
                        2. Vara
                        Opção (Zero p/sair):\s""");
            opcao = input.nextInt();
            input.nextLine();
            switch (opcao) {
                case 1 -> TribunalController.main(null);
                case 2 -> VaraController.main(null);
                default -> {
                    if (opcao != 0) System.out.println("Opção inválida.");
                }
            }
        } while(opcao != 0) ;
        System.out.println("\n\n!!!!!!!! Fim da aplicação !!!!!!!!");
        input.close(); //libera o recurso
    }

}//fim classe

