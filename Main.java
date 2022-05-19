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
        System.out.println("Digite 1 para Consultar Conta");
        System.out.println("Digite 2 para Criar uma Conta");
        System.out.println("<Outro> para sair");

        //escolher opcao
        escolha = texto.nextInt();

        //tratamento de opcoes
        switch(escolha){
            case 1:
            System.out.println("Que tipo de conta deseja criar 1-Corrente 2-Poupanca");
            int escolha2 = texto.nextInt();

            switch(escolha2){
                
            }

        }


    }






    }
}
