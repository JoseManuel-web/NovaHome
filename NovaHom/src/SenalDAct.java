import java.util.ArrayList;

public class SenalDAct{
    private ArrayList<String> sennal=new ArrayList<>();
    public void crearSennal(){}
    public void setSennal(String sennal){
        this.sennal.addLast(sennal);
    }
    public ArrayList<String> getSennal(){
        return sennal;
    }
    
}
