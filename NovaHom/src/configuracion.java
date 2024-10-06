import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;

public class configuracion {
    private Menu menu=new Menu();
    private int opc;
    private String apodo;
    private ArrayList<Televisor> teles=new ArrayList<>(0);
    private Menu cond= new Menu();
    private List<String> menC=Arrays.asList("Por hora","Señal de un sensor");
    private int opcCond;
    
    configuracion(){
    }
    public void crear(List<String> habitacion, Map<String,ArrayList<String>> CondAct, List<String>dispositivos,List<String> sensoresCon){
        opc=menu.selec(dispositivos, "Dispositivo a crear",1);
        if(opc==0)
            return;
        apodo=(String)JOptionPane.showInputDialog(null, "Nombra el dispositivo","Nuevo dispositivo",1);
        switch (opc) {
            case 1:
                apodo+=" (Televisor)";
                teles.addLast(new Televisor(habitacion, CondAct, apodo, sensoresCon));
                System.out.println(habitacion);
                System.out.println(CondAct);
                break;
            case 2:
                
                break;

            default:
                break;
        }
    }

    public String crearHab(List<String> habitacion){    
        String newHab;
        newHab=JOptionPane.showInputDialog(null, "Nombra la habitación","Nueva habitación",1);
        //Si la habitación escrina no existe la guarda en el list habitacion
        if(!habitacion.contains(newHab))
            habitacion.add(newHab);
        return newHab;//Regresa para registrar en el dispositivo
    }

    public String AddCond(Map<String,ArrayList<String>> CondAct,List<String> sensoresCon,List<String> sig,String apodo){
        String newCond="";
        Reloj reloj=new Reloj();
        SenalDAct s=new SenalDAct();
            opcCond=cond.selec(menC,"Tipo de Condición",1);
            switch (opcCond) {
                case 0:
                    newCond="\n";
                case 1:
                    newCond=reloj.condH();
                    break;
                case 2:
                    newCond=s.newSen(sensoresCon);
                    break;
                default:
                    break;
                }
            //Si la newCond no esta en CondAct o no esta en sig crea el elemento en el map CondAct
            if(!CondAct.keySet().contains(newCond) || !sig.contains(newCond)){
                CondAct.put(newCond,new ArrayList<String>());
                CondAct.get(newCond).add(apodo);
            }
            return newCond;
    }
}
