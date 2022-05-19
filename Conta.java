import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Conta {//ok
    private int id;
    private double saldo;
    
    List<Cliente>clienteC=new ArrayList<>();//array de clientes
    List<Historico>historicos = new ArrayList<>();//array de historicos
    //construtores
    Conta(){

    }
    Conta(int id, double saldo){
        this.id=id;
        this.saldo=saldo;
    }
    //Getters e Setters
    public int getId(){
        return this.id;
    }
    public void setId(int id){
        this.id=id;
    }
    public double getSaldo(){
        return this.saldo;
    }
    public void setSaldo(double saldo){
        this.saldo=saldo;
    }
    //metodos Deposito Saque e Consulta
    //metodo depositar
    public void depositarDinheiro(double valor){
        if(valor<0){
            System.out.println("Nao e possivel realizar operacao.");
        }
        else{
            saldo+=valor;
            System.out.println("Operacao bem sucedida");
            Historico historico1 = new Historico();
            historico1.setOperacao("Deposito");
            historico1.setInfo("Sucesso");
            historicos.add(historico1);
        }
    }
    //metodo sacar
    public void sacarDinheiro(double valor){
        if(valor>saldo){
            System.out.println("Nao eh possivel realizar a operacao");
        }
        else{
            saldo-=valor;
            System.out.println("Saque realizado com sucesso");
            Historico historico2 = new Historico();
            historico2.setOperacao("Saque");
            historico2.setInfo("Sucesso");
            historicos.add(historico2);
        }
    }
    //consulta de extrato
    public void consultaExtrato(){
        System.out.println("Extrato");
        int i;
        for(i=0;i<historicos.size();i++){
            System.out.println(historicos.get(i).getOperacao());
            System.out.println(historicos.get(i).getInfo());
        }
        System.out.println("Saldo ativo em conta R$: "+getSaldo());
    }
}
