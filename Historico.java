public class Historico{
    private String data;
    private String operacao;
    private String detalhes;

    public String getDetalhes(){
        return this.detalhes;
    }
    public String getOperacao(){
        return this.operacao;
    }
    public String getData(){
        return this.data;
    }
    public void setOperacao(String operacao){
        this.operacao=operacao;
    }
    public void setData(String data){
        this.data=data;
    }
    public void setDetalhes(String detalhes){
        this.detalhes=detalhes;
    }
}