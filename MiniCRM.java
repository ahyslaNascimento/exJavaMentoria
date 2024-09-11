import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class MiniCRM {
    private Queue<Cliente> clientes = new LinkedList<>();
    private Scanner scanner = new Scanner(System.in);

    public void menu() {
        while (true) {
            System.out.println("Bem-vindo ao Mini CRM!");
            System.out.println("Selecione uma opção:");
            System.out.println("1. Adicionar Cliente");
            System.out.println("2. Exibir Clientes");
            System.out.println("3. Editar Cliente");
            System.out.println("4. Excluir Cliente");
            System.out.println("5. Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
                case 1:
                    adicionarCliente();
                    break;
                case 2:
                    exibirClientes();
                    break;
                case 3:
                    editarCliente();
                    break;
                case 4:
                    excluirCliente();
                    break;
                case 5:
                    System.out.println("Saindo...");
                    return;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }
    }

    private void adicionarCliente() {
        System.out.print("Digite o nome do cliente: ");
        String nome = scanner.nextLine();
        System.out.print("Digite a idade do cliente: ");
        int idade = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("Digite o telefone do cliente: ");
        String telefone = scanner.nextLine();
        System.out.print("Digite o e-mail do cliente: ");
        String email = scanner.nextLine();

        Cliente cliente = new Cliente(nome, idade, telefone, email);
        clientes.add(cliente);
        System.out.println("Cliente adicionado com sucesso!");
    }

    private void exibirClientes() {
        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
            return;
        }
        System.out.println("Lista de Clientes:");
        for (Cliente cliente : clientes) {
            System.out.println(cliente);
        }
    }

    private void editarCliente() {
        System.out.print("Digite o nome do cliente a ser editado: ");
        String nome = scanner.nextLine();
        for (Cliente cliente : clientes) {
            if (cliente.getNome().equalsIgnoreCase(nome)) {
                System.out.println("Cliente encontrado: " + cliente);
                System.out.print("Digite o novo nome: ");
                cliente.setNome(scanner.nextLine());
                System.out.print("Digite a nova idade: ");
                cliente.setIdade(scanner.nextInt());
                scanner.nextLine(); // Consumir a nova linha
                System.out.print("Digite o novo telefone: ");
                cliente.setTelefone(scanner.nextLine());
                System.out.print("Digite o novo e-mail: ");
                cliente.setEmail(scanner.nextLine());
                System.out.println("Cliente atualizado com sucesso!");
                return;
            }
        }
        System.out.println("Cliente não encontrado.");
    }

    private void excluirCliente() {
        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente para excluir.");
            return;
        }
        Cliente cliente = clientes.poll();
        System.out.println("Cliente excluído: " + cliente);
    }

    public static void main(String[] args) {
        MiniCRM crm = new MiniCRM();
        crm.menu();
    }
}

class Cliente {
    private String nome;
    private int idade;
    private String telefone;
    private String email;

    public Cliente(String nome, int idade, String telefone, String email) {
        this.nome = nome;
        this.idade = idade;
        this.telefone = telefone;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", telefone='" + telefone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
