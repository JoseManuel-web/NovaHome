import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;

public class configuracion {
    private Menu menu=new Menu();
    private int opc;
    private String apodo;
    private StringBuilder sb = new StringBuilder();
    private ArrayList<Televisor> teles=new ArrayList<>(0);
    private ArrayList<Microondas> microondas = new ArrayList<>(1);
    private ArrayList<Luces> luces = new ArrayList<>(2);

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
                break;
            
            case 2:
                apodo += " (Microondas)";
                microondas.add(new Microondas(habitacion, CondAct, apodo, sensoresCon));
                break;
            
            case 3:
                apodo += " (Luces)";
                luces.add (new Luces(habitacion,CondAct,apodo, sensoresCon));
                break;

            default:
                break;
        }
        System.out.println(habitacion);
        System.out.println(CondAct);
                
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


    public String listarDispositivos(){
        sb.append("Dispositivos\n");

        if(teles.isEmpty()){
            sb.append(("No hay televisores registrados\n"));
        } else{
            sb.append("Televisores:\n");
            for (Televisor t : teles){
                sb.append(" -"+t.getTipoApodo()+"\n");
            }
        }

        if (microondas.isEmpty()){
            sb.append("No hay microondas registrados\n");
        } else {
            sb.append("Microondas:\n");
            for (Microondas m: microondas){
                sb.append(" -"+ m.getTipoApodo()+ "\n");
            }
        }

        if(luces.isEmpty()){
            sb.append("No hay luces registrados\n");
        } else {
            sb.append("Luces:\n");
            for (Luces l : luces){
                sb.append(" -"+ l.getTipoApodo()+ "\n");
            }
        }

        return sb.toString();
    }

    public String buscarDispositivos(String apodo){
        for (Televisor t: teles){
            if (t.getTipoApodo().toLowerCase().contains(apodo.toLowerCase())) {
                sb.append("Televisor encontrado: "+t.getTipoApodo()+"\n");

            }
        }

        for (Microondas m: microondas){
            if (m.getTipoApodo().toLowerCase().contains(apodo.toLowerCase())) {
                sb.append("Microondas encontrado: "+m.getTipoApodo()+"\n");
            }
        }

        for (Luces l : luces){
            if (l.getTipoApodo().toLowerCase().contains(apodo.toLowerCase())) {
                sb.append("Luces encontrado: " + l.getTipoApodo() + "\n");
            }
        }

        if (sb.length() == 0){
            sb.append("No se encontro el dispositivo con el apodo: "+apodo);
        }
        
        return sb.toString();
    }
}