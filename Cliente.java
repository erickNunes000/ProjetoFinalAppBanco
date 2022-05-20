import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
public class Cliente{//OK
    //criando array de clientes
    Scanner texto = new Scanner(System.in);
    List<Cliente>clienteConta = new ArrayList<>();

    //Atributos da classe Cliente
    private String nome;
    private String cpf;
    private String endereco;

    //construtor vazio
    Cliente(){

    }
    //Construtor com parametros
    Cliente(String nome, String cpf, String endereco){
        this.nome=nome;
        this.cpf=cpf;
        this.endereco=endereco;
    }

    //getter e setters de Cliente
    public String getNome(){
        return this.nome;
    }
    public void setNome(String nome){
        this.nome=nome;
    }
    public String getCpf(){
        return this.cpf;
    }    
    public void setCpf(String cpf){
        this.cpf=cpf;
    }
    public String getEndereco(){
        return this.endereco;
    }
    public void setEndereco(String endereco){
        this.endereco=endereco;
    }

    //metodo toString
    public String toString(){
        return "Cliente: "+this.getNome()+"CPF: "+this.getCpf()+"Endereco: "+this.getEndereco();
    }
    //metodos para cadastrar CC e CP
    //Cadastrar Conta Pupanca
    public void CadastroPoupanca(){
        String nome,cpf,endereco;
        System.out.println("Nome: ");
        nome=texto.nextLine();
        System.out.println("Informe CPF: ");
        cpf=texto.nextLine();
        System.out.println("Endereco: ");
        endereco=texto.nextLine();

       Cliente clientPoupanca=new Cliente(nome, cpf, endereco);
       clientPoupanca.toString();

    }

    //Cadastrar Conta Corrente
    public void CadastroCorrente(){
        String nome,cpf,endereco;
        System.out.println("Nome: ");
        nome=texto.nextLine();
        System.out.println("Informe CPF: ");
        cpf=texto.nextLine();
        System.out.println("Endereco: ");
        endereco=texto.nextLine();

        Cliente clientCorrente = new Cliente(nome, cpf, endereco);
        clientCorrente.toString();
    }
}





