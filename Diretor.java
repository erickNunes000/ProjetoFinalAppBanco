import java.util.List;
public class Diretor extends Usuario implements funcionarioBanco{
    Diretor(){

    }
    Diretor(String name, String identidade, String cargo){
        super(name, identidade, cargo);
    }

    @Override
      public  void emprestimo(double valor, Corrente cc){
        cc.depositar(valor);
        cc.setSolicitouEmprestino(true);
    }
    @Override
    public void showCorrente(List<Corrente>cc){
        int i;
        System.out.println("===CONTAS CORRENTE===");
        for(i=0;i<cc.size();i++){
            System.out.println("infos "+cc.get(i).infoConta());
        }
    }
    @Override
    public void showPoupanca(List<Poupanca>cp){
        int i;
        System.out.println("===CONTAS POUPANCA===");
        for(i=0;i<cp.size();i++){
            System.out.println("infos "+cp.get(i).infoConta());
        }
    }
  
}
