import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Microondas extends Dispositivos {
    
    public Microondas(List<String> habitacion, Map<String, ArrayList<String>> CondAct, String tipoApodo, List<String> sensoresCon) {
        super(habitacion, CondAct, tipoApodo, sensoresCon);
    }

    public void activar(){
        System.err.println("Se apaga/prende el microondas");
    }
}
