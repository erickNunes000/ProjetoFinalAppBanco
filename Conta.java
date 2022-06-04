import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
abstract class Conta {
    private String titular;
    private String cpf;
    private int agencia;
    private double saldo;
   
    List<Historico>historico = new ArrayList<>();

    Conta(){

    }
    
    Conta(String titular, String cpf, int agencia, double saldo){
        this.titular=titular;
        this.saldo=saldo;
        this.cpf=cpf;
        this.agencia=agencia;
    }

    public String getTitular(){
        return this.titular;
    }
    public double getSaldo(){
        return this.saldo;
    }
    public String getCpf(){
        return this.cpf;
    }
    public int getAgencia(){
        return this.agencia;
    }
    public void setTitular(String titular){
        this.titular=titular;
    }
    public void setSaldo(double saldo){
        this.saldo=saldo;
    }
    public void setCpf(String cpf){
        this.cpf=cpf;
    }
    public void setAgencia(int agencia){
        this.agencia=agencia;
    }
    public void depositar(double valor){//operacao de deposito
        if(valor<0){
            System.out.println("Valor a depositar negativo");
        }
        else{
            this.saldo+=valor;
            System.out.println("Operacao bem sucedida");
            Historico h1 = new Historico();
            h1.setOperacao("Deposito");
            h1.setDetalhes("Valor R$ "+valor);
            h1.setData(Instant.now().toString());
            historico.add(h1);
        }        
    }//fim do metodo deposito

    public void sacar(double valor){//inicio do metodo sacar
        if(valor > this.saldo || valor<0){
            System.out.println("Nao e possivel realizar a operacao");
        }
        else{
            this.saldo-=valor;
            System.out.println("Operacao bem sucedida");
            Historico h2 = new Historico();
            h2.setOperacao("Saque");
            h2.setDetalhes("Valor R$: "+ valor);
            h2.setData(Instant.now().toString());
            historico.add(h2);
        }
    }//fim do metodo sacar
    public void extratoConta(){//inicio metodo extrato
        int i;
        for(i=0;i<historico.size();i++){
            System.out.println(historico.get(i).getOperacao());
            System.out.println(historico.get(i).getDetalhes());
            System.out.println(historico.get(i).getData());
        }
        System.out.println("Saldo atual em conta R$: "+getSaldo());
    }//fim do metodo extrato
    
   public String infoConta(){
       return "Titular: "+ this.getTitular()+"CPf "+this.getCpf()+"Agencia: "+this.getAgencia();
   }
}
