import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
     Scanner texto = new Scanner(System.in);
     Conta conta1=null;
     List<Conta>listaConta = new ArrayList<Conta>();
     int escolha;

    do{
        //menu
        System.out.println("Bem vindo ao EVBank");
        System.out.println("Digite 1 para Criar Conta");
        System.out.println("Digite 2 para Consultar uma Conta");
        System.out.println("Digite 0 para sair");

        //escolher opcao
        escolha = texto.nextInt();

        //tratamento de opcoes
        switch(escolha){
            case 1://Usuario escolheu criar conta
            System.out.println("Que tipo de conta deseja criar 1-Corrente 2-Poupanca");
            int escolha2 = texto.nextInt();

            switch(escolha2){//criacao de contas
                case 1://tipo corrente
                    System.out.println("Criar Nova Conta Corrente:");
                    Cliente c1 = new Cliente();
                    c1.CadastroCorrente();
                    listaConta.add(c1);
                break;

                case 2://tipo poupanca
                    System.out.println("Criar Nova Conta Poupanca");
                    Cliente c2 = new Cliente();
                    c2.CadastroPoupanca();
                    listaConta.add(c2);
                break;
                default://padrao
                    System.out.println("Entrada Invalida");
                break;
            }
            case 2://opcoes de consulta de conta (Saque, Deposito e Extrato)
            System.out.println("Escolha:");
            System.out.println("1-Sacar");
            System.out.println("2-Deposito");
            System.out.println("3-Extrato");
            int escolha3 = texto.nextInt();

            switch(escolha3){
                case 1:
                    System.out.println("Informe quantia a sacar em R$");
                    double valor = texto.nextDouble();
                    Conta c3 = new Conta(1234,20000);
                    c3.sacarDinheiro(valor);
                    
                break;

                case 2:
                    System.out.println("Informe a quantia a depositar em R$");
                    double valor2 = texto.nextDouble();
                    Conta c4 = new Conta(125896, 10000);
                    c4.depositarDinheiro(valor2);
                break;

                case 3:
                    System.out.println("----EXTRATO----");
                    Conta c5 = new Conta(2569, 10);
                    c5.consultaExtrato();
                break;
                default:
                    System.out.println("Entrada Invalida");
                break;
            }
            //padrao
            default:
                System.out.println("opcao invalida");
            break;
        }
      }while(escolha!=0);
    }
}
