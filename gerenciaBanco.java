import java.util.Scanner;

class Cliente
{
  private String nome;
  private String sobrenome;
  private String cpf;
  private double saldo;

  // Método get com os dados do cliente.
  public Cliente(String nome, String sobrenome, String cpf)
  {
    this.nome = nome;
    this.sobrenome = sobrenome;
    this.cpf = cpf;
    this.saldo = 0.0;
  }

  // Metodo para consultar o saldo.
  public void consultar_saldo()
  {
    System.out.println("- Seu saldo: R$" + saldo);
  }
  
  // Método para depositar dinheiro na conta.
  public void depositar(double valor)
  {
    if (valor > 0)
    {
      saldo += valor;
      System.out.println("[+] Você depositou R$" + valor + " com sucesso!");
    }
    else
    {
      System.out.println("[X] Erro: Valor de deposito inválido.");
    }
    System.out.println("| Seu saldo: R$" + saldo);
  }

  // Método para sacar dinheiro da conta.
  public void sacar(double valor)
  {
    if (valor > 0 && valor <= saldo)
    {
      saldo -= valor;
      System.out.println("[-] Você sacou R$" + valor + " com sucesso!");
    }
    else
    {
      System.out.println("[X] Erro: Saldo insuficiente ou valor de saque inválido.");
      System.out.println("| Valor a sacar: R$" + valor);
    }
    System.out.println("| Seu saldo: R$" + saldo);
  }
}

public class gerenciaBanco
{
    public static void main(String[] args)
    {
      // Solicita os dados do usuário.
      Scanner input = new Scanner(System.in);
      System.out.println("Digite o seu nome: ");
      String nome = input.nextLine();
      System.out.println("Digite o seu sobrenome: ");
      String sobrenome = input.nextLine();
      System.out.println("Digite o seu CPF: ");
      String cpf = input.nextLine();
      
      // Instanciando um objeto da classe Cliente.
      Cliente cliente = new Cliente(nome, sobrenome, cpf);
      
      System.out.println("\n[>] Bem-vindo(a), " + nome + "!");
      Boolean continuar = true;
      while (continuar)
      {
        // Solicita o que o usuário deseja fazer.
        System.out.println("\n[>] Menu: O que deseja?");
        System.out.println("1 - Consultar saldo");
        System.out.println("2 - Fazer deposito");
        System.out.println("3 - Fazer saque");
        System.out.println("4 - Encerrar\n");
        int opcao = input.nextInt();
        
        // Checa a opção escolhida e executa a ação.
        switch (opcao)
        {
          case 1:
          {
            cliente.consultar_saldo();
            break;
          }
          case 2:
          {
            System.out.println("Digite o valor a depositar: ");
            double valor_deposito = input.nextDouble();
            cliente.depositar(valor_deposito);
            break;
          }
          case 3:
          {
            System.out.println("Digite o valor a sacar: ");
            double valor_saque = input.nextDouble();
            cliente.sacar(valor_saque);
            break;
          }
          case 4:
          {
            continuar = false;
            System.out.println("[>] Aplicação encerrada!");
            break;
          }
          default:
          {
            System.out.println("[X] Erro: Opção inválida.");
            break;
          }
        }
      }
  }
}