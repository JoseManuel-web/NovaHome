import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Televisor extends Dispositivos{
    
    Televisor(List<String> habitacion, Map<String,ArrayList<String>> CondAct,String tipoApodo){
        super(habitacion, CondAct,tipoApodo);
    }
    public void activar(){
        System.out.println("Se apaga/prende el televisor");
    }

}
