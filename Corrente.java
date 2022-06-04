import java.util.Scanner;

public class Corrente extends Conta{
    private double crEspecial;

    Scanner texto = new Scanner(System.in);

    Corrente(){

    }
    Corrente(String titular, String cpf, int agencia, double saldo, double crEspecial){
        super(titular, cpf, agencia, saldo);
        this.crEspecial=crEspecial;
    }
    
    public double getCrEspecial(){
        return this.crEspecial;
    }

    public void setCrEspecial(double crEspecial){
        this.crEspecial=crEspecial;
    }
    @Override
    public String infoConta(){
        return "Titular: "+this.getTitular() + "CPF: "+this.getCpf()+"Agencia: "+this.getAgencia()+"Conta Corrente";
    }

}
