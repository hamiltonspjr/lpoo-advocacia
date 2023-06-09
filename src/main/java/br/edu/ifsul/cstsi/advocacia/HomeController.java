package br.edu.ifsul.cstsi.advocacia;

import br.edu.ifsul.cstsi.advocacia.Advogado.AdvogadoController;
import br.edu.ifsul.cstsi.advocacia.Assume.AssumeController;
import br.edu.ifsul.cstsi.advocacia.Audiencia.AudienciaController;
import br.edu.ifsul.cstsi.advocacia.Custa.CustaController;
import br.edu.ifsul.cstsi.advocacia.Pessoa.PessoaController;
import br.edu.ifsul.cstsi.advocacia.Processo.ProcessoController;
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
                        3. Pessoa
                        4. Advogado
                        5. Processo
                        6. Custa
                        7. Audiência
                        8. Assume
                        Opção (Zero p/sair):\s""");
            opcao = input.nextInt();
            input.nextLine();
            switch (opcao) {
                case 1 -> TribunalController.main(null);
                case 2 -> VaraController.main(null);
                case 3 -> PessoaController.main(null);
                case 4 -> AdvogadoController.main(null);
                case 5 -> ProcessoController.main(null);
                case 6 -> CustaController.main(null);
                case 7 -> AudienciaController.main(null);
                case 8 -> AssumeController.main(null);
                default -> {
                    if (opcao != 0) System.out.println("Opção inválida.");
                }
            }
        } while(opcao != 0) ;
        System.out.println("\n\n!!!!!!!! Fim da aplicação !!!!!!!!");
        input.close(); //libera o recurso
    }

}//fim classe

