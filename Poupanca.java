import java.util.Scanner;
public class Poupanca extends Conta{
    private int  idSocial;

    Scanner texto = new Scanner(System.in);

    Poupanca(){

    }
    Poupanca(String titular, String cpf, int agencia, double saldo, int idSocial){
        super(titular, cpf, agencia, saldo);
        this.idSocial=idSocial;
    }
    public int getIdSocial(){
        return this.idSocial;
    }
    public void setIdSocial(int idSocial){
        this.idSocial=idSocial;
    }
    @Override
    public String infoConta(){
        return "Titular: "+this.getTitular() + "CPF: "+this.getCpf()+"Agencia: "+this.getAgencia()+"Conta Poupanca";
    }
}
