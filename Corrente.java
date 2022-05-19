import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Corrente extends Conta{
    Scanner texto = new Scanner(System.in);
    List<Historico>historicos = new ArrayList<>();

    Corrente(int id, double saldo){
        super(id, saldo);
    }

    ///Metodos Depositar, Sacar e Consultar Extrato
    //depositar
    public void depositarDinheiro(double valor){
        if(valor<0){
            System.out.println("Nao e possivel realizar operacao.");
        }
        else{
            setSaldo(valor);
            System.out.println("Operacao bem sucedida");
            Historico historico1 = new Historico();
            historico1.setOperacao("Deposito");
            historico1.setInfo("Sucesso");
            historicos.add(historico1);
        }
    }
    //sacar
    public void sacarDinheiro(double valor){
        if(valor>getSaldo()){
            System.out.println("Nao eh possivel realizar a operacao");
        }
        else{
            setSaldo(valor);
            System.out.println("Saque realizado com sucesso");
            Historico historico2 = new Historico();
            historico2.setOperacao("Saque");
            historico2.setInfo("Sucesso");
            historicos.add(historico2);
        }
    }
    //consulta extrato
    public void consultaExtrato(){
        System.out.println("Extrato em Conta Corrente");
        int i;
        for(i=0;i<historicos.size();i++){
            System.out.println(historicos.get(i).getOperacao());
            System.out.println(historicos.get(i).getInfo());
        }
        System.out.println("Saldo ativo em conta R$: "+getSaldo());
    }

}







