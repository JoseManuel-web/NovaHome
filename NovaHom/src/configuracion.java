import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;

public class configuracion {
    private Menu menu=new Menu();
    private int opc;
    private String apodo;
    private ArrayList<Televisor> teles=new ArrayList<>(0);
    configuracion(){
    }
    public void crear(List<String> habitacion, Map<String,ArrayList<String>> CondAct, List<String>dispositivos){
        opc=menu.selec(dispositivos, "Dispositivo a crear",1);
        if(opc==0)
            return;
        apodo=(String)JOptionPane.showInputDialog(null, "Nombra el dispositivo","Nuevo dispositivo",1);
        switch (opc) {
            case 1:
                apodo+=" (Televisor)";
                teles.addLast(new Televisor(habitacion, CondAct, apodo));
                break;
            case 2:
                
                break;

            default:
                break;
        }
    }
}
