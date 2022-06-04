import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
public class Usuario {
    private String name;
    private String identidade;//numero de identificacao
    private String cargo;

    Scanner texto = new Scanner(System.in);

    List<Corrente>corrente = new ArrayList<>();
    List<Poupanca>poupanca = new ArrayList<>();

    Usuario(){

    }
    Usuario(String name, String identidade, String cargo){
        this.name=name;
        this.identidade=identidade;
        this.cargo=cargo;
    }
    public String getName(){
        return this.name;
    }
    public String getIdentidade(){
        return this.identidade;
    }
    public String getCargo(){
        return this.cargo;
    }
    public void setName(String name){
        this.name=name;
    }
    public void setIdentidade(String identidade){
        this.identidade=identidade;
    }
    public void setCargo(String cargo){
        this.cargo=cargo;
    }
    public void cadastroCorrente(){//cadastrar contas corrente
        String titular, cpf;
        int agencia;
        double saldo, crEspecial;
        System.out.println("*----------Conta Corrente------------*");
        System.out.println("Nome titular:");
        titular = texto.nextLine();
        System.out.println("CPF Titular:");
        cpf = texto.nextLine();
        System.out.println("Agencia:");
        agencia = texto.nextInt();
        System.out.println("Saldo inicial R$: ");
        saldo = texto.nextDouble();
        System.out.println("Credito especial R$: ");
        crEspecial = texto.nextDouble();    
        Corrente c = new Corrente();
        c.setTitular(titular);
        c.setCpf(cpf);
        c.setAgencia(agencia);
        c.setSaldo(saldo);
        c.setCrEspecial(crEspecial);
        corrente.add(c);
    }
    public void cadastroPoupanca(){
        String titular, cpf;
        int agencia, idSocial;
        double saldo;
        System.out.println("*----------Conta Corrente------------*");
        System.out.println("Nome titular:");   
        titular = texto.nextLine();
        System.out.println("CPF titular:");
        cpf = texto.nextLine();
        System.out.println("Agencia: ");
        agencia = texto.nextInt();
        System.out.println("Id Social: ");
        idSocial = texto.nextInt();
        System.out.println("saldo inicial R$:");
        saldo = texto.nextDouble();
        Poupanca p = new Poupanca();
        p.setTitular(titular);
        p.setCpf(cpf);
        p.setAgencia(agencia);
        p.setIdSocial(idSocial);
        p.setSaldo(saldo);
        poupanca.add(p);     
    }
    public void verContasCorrente(){//olhar contas cadastradas tipo Corrente
        int i;
        System.out.println("===CONTAS CORRENTE===");
        for(i=0;i<corrente.size();i++){
            System.out.println("infos"+corrente.get(i).infoConta());            
        }
    }
    public void verContasPoupanca(){//olhar contascadastradas do tipo Poupanca
        int i;
        System.out.println("*===CONTAS POUPANCA===");
        for(i=0;i<poupanca.size();i++){
            System.out.println("infos: "+poupanca.get(i).infoConta());
        }
    }
    
}
