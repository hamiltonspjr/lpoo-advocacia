package br.edu.ifsul.cstsi.advocacia.Pessoa;

import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Scanner;

@Controller
public class PessoaController {
    private static final Scanner input = new Scanner(System.in);
    private static PessoaService pessoaService;
    public PessoaController(PessoaService pessoaService) {
        PessoaController.pessoaService = pessoaService;
    }

    public static void main(String[] args) {
        int opcao;
        do {
            System.out.print("\n\"---  Menu Pessoa ---\"");
            System.out.print(
                    """
    
                        1. Inserir nova pessoa
                        2. Atualizar uma pessoa
                        3. Excluir uma pessoa
                        4. Listar todos as pessoas
                        5. Buscar pessoa pelo código
                        6. Buscar pessoas pelo nome
                        7. Buscar pessoa pelo CPF
                        8. Buscar pessoa pelo RG
                        9. Buscar pessoa pelo CNPJ
                        Opção (Zero p/sair):\s""");
            opcao = input.nextInt();
            input.nextLine();
            switch (opcao) {
                case 1 -> inserir();
                case 2 -> atualizar();
                case 3 -> excluir();
                case 4 -> selectAllPessoas();
                case 5 -> selectPessoaById();
                case 6 -> selectPessoasByNome();
                case 7 -> selectPessoaByCpf();
                case 8 -> selectPessoaByRg();
                case 9 -> selectPessoaByCnpj();
                default -> {
                    if (opcao != 0) System.out.println("Opção inválida.");
                }
            }
        } while (opcao != 0);
    }

    private static void inserir() {
        Pessoa pessoa = new Pessoa();
        System.out.println("\nCadastro de uma nova pessoa");
        System.out.print("Digite o nome da pessoa: ");
        pessoa.setNome(input.nextLine());
        System.out.print("\nDigite o endereço da pessoa: ");
        pessoa.setEndereco(input.nextLine());
        System.out.print("\nDigite o bairro da pessoa: ");
        pessoa.setBairro(input.nextLine());
        System.out.print("\nDigite a cidade da pessoa: ");
        pessoa.setCidade(input.nextLine());
        System.out.print("\nDigite o cep da pessoa: ");
        pessoa.setCep(input.nextLine());
        System.out.print("\nDigite o uf da pessoa: ");
        pessoa.setUf(input.nextLine());
        System.out.print("\nDigite o telefone da pessoa: ");
        pessoa.setTelefone(input.nextLine());
        System.out.print("\nDigite o email da pessoa: ");
        pessoa.setEmail(input.nextLine());


            System.out.print("\nDigite o CPF da pessoa: ");
            pessoa.setCpf(input.nextLine());
            System.out.print("\nDigite o RG da pessoa: ");
            pessoa.setRg(input.nextLine());

            System.out.print("\nDigite o CNPJ da pessoa: ");
            pessoa.setCpnj(input.nextLine());

        System.out.println("pessoa cadastrada com sucesso:" + pessoaService.insert(pessoa));

    }
    private static void atualizar() {
        System.out.println("\n Alterar uma pessoa");
        Pessoa pessoa;
        int opcao = 0;
        do {
            System.out.print("\nDigite o código da pessoa (Zero p/sair): ");
            Integer codigo = input.nextInt();
            input.nextLine();
            if(codigo == 0) {
                opcao = 0;
            } else {
                pessoa = pessoaService.getPessoaById(codigo);
                if(pessoa == null) {
                    System.out.println("Código inválido");
                } else {
                    System.out.println("Nome: " + pessoa.getNome());
                    System.out.print("Alterar? (0-sim/1-não) ");
                    if(input.nextInt() == 0){
                        input.nextLine();
                        System.out.println("Digite o novo nome da pessoa: ");
                        pessoa.setNome(input.nextLine());
                    }
                    System.out.println("Endereço: " + pessoa.getEndereco());
                    System.out.print("Alterar? (0-sim/1-não) ");
                    if(input.nextInt() == 0){
                        input.nextLine();
                        System.out.println("Digite o novo endereço da pessoa: ");
                        pessoa.setEndereco(input.nextLine());
                    }
                    System.out.println("Bairro: " + pessoa.getBairro());
                    System.out.print("Alterar? (0-sim/1-não) ");
                    if(input.nextInt() == 0){
                        input.nextLine();
                        System.out.println("Digite o novo bairro da pessoa: ");
                        pessoa.setBairro(input.nextLine());
                    }
                    System.out.println("Cidade: " + pessoa.getCidade());
                    System.out.print("Alterar? (0-sim/1-não) ");
                    if(input.nextInt() == 0){
                        input.nextLine();
                        System.out.println("Digite a nova cidade da pessoa: ");
                        pessoa.setCidade(input.nextLine());
                    }
                    System.out.println("Cep: " + pessoa.getCep());
                    System.out.print("Alterar? (0-sim/1-não) ");
                    if(input.nextInt() == 0){
                        input.nextLine();
                        System.out.println("Digite o novo cep da pessoa: ");
                        pessoa.setCep(input.nextLine());
                    }
                    System.out.println("UF: " + pessoa.getUf());
                    System.out.print("Alterar? (0-sim/1-não) ");
                    if(input.nextInt() == 0){
                        input.nextLine();
                        System.out.println("Digite o novo UF da pessoa: ");
                        pessoa.setUf(input.nextLine());
                    }
                    System.out.println("Telefone: " + pessoa.getTelefone());
                    System.out.print("Alterar? (0-sim/1-não) ");
                    if(input.nextInt() == 0){
                        input.nextLine();
                        System.out.println("Digite o novo telefone da pessoa: ");
                        pessoa.setTelefone(input.nextLine());
                    }
                    System.out.println("Email: " + pessoa.getEmail());
                    System.out.print("Alterar? (0-sim/1-não) ");
                    if(input.nextInt() == 0){
                        input.nextLine();
                        System.out.println("Digite o novo email da pessoa: ");
                        pessoa.setEmail(input.nextLine());
                    }
                    System.out.println("CPF: " + pessoa.getCpf());
                    System.out.print("Alterar? (0-sim/1-não) ");
                    if(input.nextInt() == 0){
                        input.nextLine();
                        System.out.println("Digite o novo cpf da pessoa: ");
                        pessoa.setCpf(input.nextLine());
                    }
                    System.out.println("RG: " + pessoa.getRg());
                    System.out.print("Alterar? (0-sim/1-não) ");
                    if(input.nextInt() == 0){
                        input.nextLine();
                        System.out.println("Digite o novo RG da pessoa: ");
                        pessoa.setRg(input.nextLine());
                    }
                    System.out.println("CNPJ: " + pessoa.getCpnj());
                    System.out.print("Alterar? (0-sim/1-não) ");
                    if(input.nextInt() == 0){
                        input.nextLine();
                        System.out.println("Digite o novo CNPJ da pessoa: ");
                        pessoa.setCpnj(input.nextLine());
                    }
                    if(pessoaService.update(pessoa) != null) {
                        System.out.println("Pessoa atualizada com sucesso. " + pessoaService.getPessoaById(pessoa.getCodpessoa()));
                    } else {
                        System.out.println("Não foi possível atualizar esta pessoa.");
                    }
                    opcao = 1;
                }
            }
        } while (opcao != 0);
    }

    private static void excluir() {
        System.out.println("\nExcluir uma pessoa");
        Pessoa pessoa;
        int opcao = 0;
        do {
            System.out.print("\nDigite o código da pessoa (Zero p/sair): ");
            Integer codigo = input.nextInt();
            input.nextLine();
            if (codigo == 0) {
                opcao = 0;
            } else if(codigo > 0) {
                pessoa = pessoaService.getPessoaById(codigo);
                if(pessoa == null) {
                    System.out.println("Código inválido.");
                } else {
                    System.out.println(pessoa);
                    System.out.print("Excluir esta pessoa? (0-sim/1-não) ");
                    if(input.nextInt() == 0) {
                        input.nextLine();
                        System.out.print("Tem certeza disso? (0-sim/1-não) ");
                        input.nextLine();
                        pessoaService.delete(pessoa.getCodpessoa());
                        System.out.println("Pessoa excluida com sucesso: " + pessoa);
                    }
                }
            } else {
                System.out.println("Digite um código válido!!!");
            }
        } while (opcao != 0);
    }
    private static void selectAllPessoas() {
        System.out.println("\nLista de pessoas cadastradas no banco:\n" + pessoaService.getPessoas());
    }
    private static void selectPessoaById() {
        System.out.print("\nDigite o código da pessoa: ");
        Pessoa pessoa = pessoaService.getPessoaById(input.nextInt());
        input.nextLine();
        if (pessoa != null) {
            System.out.println(pessoa);
        } else {
            System.out.println("Pessoa não encontrada.");
        }
    }
    private static void selectPessoasByNome() {
        System.out.print("Digite o nome da pessoa: ");
        String nome = input.next();
        System.out.println("Chave de pesquisa: " + nome);
        List<Pessoa> pessoas = pessoaService.getPessoasByNome(nome + "%");
        if (pessoas.isEmpty()) {
            System.out.println("Não há registros correspondentes para: " + nome);
        } else {
            System.out.println(pessoas);
        }
    }

    private static void selectPessoaByCpf() {
        System.out.print("\nDigite o CPF da pessoa: ");
        Pessoa pessoa = pessoaService.getPessoaByCpf(input.nextLine());
        input.nextLine();
        if (pessoa != null) {
            System.out.println(pessoa);
        } else {
            System.out.println("Pessoa não encontrada.");
        }
    }
    private static void selectPessoaByRg() {
        System.out.print("\nDigite o RG da pessoa: ");
        Pessoa pessoa = pessoaService.getPessoaByRg(input.nextLine());
        input.nextLine();
        if (pessoa != null) {
            System.out.println(pessoa);
        } else {
            System.out.println("Pessoa não encontrada.");
        }
    }
    private static void selectPessoaByCnpj() {
        System.out.print("\nDigite o CNPJ da pessoa: ");
        Pessoa pessoa = pessoaService.getPessoaByCnpj(input.nextLine());
        input.nextLine();
        if (pessoa != null) {
            System.out.println(pessoa);
        } else {
            System.out.println("Pessoa não encontrada.");
        }
    }
}

