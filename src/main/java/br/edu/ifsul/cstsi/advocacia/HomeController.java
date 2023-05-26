package br.edu.ifsul.cstsi.lpoo_vendas_jpa_springboot_gradle;

import br.edu.ifsul.cstsi.lpoo_vendas_jpa_springboot_gradle.clientes.ClienteController;
import br.edu.ifsul.cstsi.lpoo_vendas_jpa_springboot_gradle.pedidos.PedidoController;
import br.edu.ifsul.cstsi.lpoo_vendas_jpa_springboot_gradle.pedidos.VendasController;
import br.edu.ifsul.cstsi.lpoo_vendas_jpa_springboot_gradle.produtos.ProdutoController;

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
                        Opção (Zero p/sair):\s""");
            opcao = input.nextInt();
            input.nextLine();
            switch (opcao) {
                case 1 -> VendasController.main(null);

                default -> {
                    if (opcao != 0) System.out.println("Opção inválida.");
                }
            }
        } while(opcao != 0) ;
        System.out.println("\n\n!!!!!!!! Fim da aplicação !!!!!!!!");
        input.close(); //libera o recurso
    }

}//fim classe

