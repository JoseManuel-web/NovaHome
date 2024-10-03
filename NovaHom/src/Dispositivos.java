import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JOptionPane;

public class Dispositivos{
    //Variables
    private static List<String> habitacion=new ArrayList<>();
    private static Map<String, ArrayList<String>> CondAct=new HashMap<>();
    private static List<String> dispositivos=Arrays.asList("Reloj","Televisor");
    Menu cond= new Menu();
    List<String> menC=Arrays.asList("Ingrese la condición que desee programar:","1) Por hora","2) Señal de un sensor","3) Salir");
    int NmenC=menC.size();
    
    //Constructores
    Dispositivos(){
        Menu hab=new Menu();
        List<String> menC=habitacion; menC.add("Otro");
        String opc=hab.selec(menC);
        
    }


    public void AddCond() {
        int opc;
        do { 
            opc=cond.mostrar(menC, NmenC);
            switch (opc) {
                case 1:
                    
                    break;

                case 2:
                    
                    break;
                case 3:
                    
                    break;
                default:
                    throw new AssertionError();
            }
        } while (opc !=3 );
    }
}
