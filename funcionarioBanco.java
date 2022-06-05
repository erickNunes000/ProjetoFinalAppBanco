//import java.util.ArrayList;
import java.util.List;
public interface funcionarioBanco {
    
     void emprestimo(double valor, Corrente cc);//emprestar
     void showCorrente(List<Corrente>cc);//ver contas corrente
     void showPoupanca(List<Poupanca>cp);//ver contas poupanca

}
  