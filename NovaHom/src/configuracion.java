import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;

public class configuracion {
    private List<String> habitacion=new ArrayList<>();
    private List<String> sensoresCon=Arrays.asList("Temperatura","Movimiento","Humedad"/*Agregar todos los que se quieran usar, hora no va aqui */);//Lista de sensores vinculables
    private Map<String, ArrayList<Dispositivos>> CondAct=new HashMap<>();//Cond:Elementos a activar con esa cond
    private List<String> dispositivos=Arrays.asList("Televisor","Microondas","Luces"/*Agregar el nombre de cada clase hija de disp..*/);//Lista de dispositivos creables

    private Menu menu=new Menu();
    private int opc;
    private String apodo;
    //private StringBuilder sb = new StringBuilder();
    private ArrayList<Televisor> teles=new ArrayList<>(0);
    private ArrayList<Microondas> microondas = new ArrayList<>(0);
    private ArrayList<Luces> luces = new ArrayList<>(0);
    @SuppressWarnings("unchecked")
    private ArrayList<Dispositivos>[] dis= new ArrayList[3];
    private Menu cond= new Menu();
    private List<String> menC=Arrays.asList("Por hora","Señal de un sensor");
    private int opcCond;
    
    configuracion(){
        dis[0]=new ArrayList<>(teles);
        dis[1]=new ArrayList<>(microondas);
        dis[2]=new ArrayList<>(luces);
        habitacion.add("Recamara"/*Valore default totalmente alterables. NO inicializada con .asList ya que esta no se puede redimensionar*/);//Lista de habitaciones
    }

    public void crear(){
        opc=menu.selec(dispositivos, "Dispositivo a crear",1);
        if(opc==0)
        apodo=(String)JOptionPane.showInputDialog(null, "Nombra el dispositivo","Nuevo dispositivo",1);
        switch (opc) {
            case 1:
                apodo+=" (Televisor)";
                dis[0].addLast(new Televisor(habitacion, CondAct, apodo, sensoresCon));
            
            case 2:
                apodo += " (Microondas)";
                microondas.add(new Microondas(habitacion, CondAct, apodo, sensoresCon));
            
            case 3:
                apodo += " (Luces)";
                luces.add (new Luces(habitacion,CondAct,apodo, sensoresCon));
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

    public String AddCond(List<String> sig,String apodo,Dispositivos disp){
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
                CondAct.put(newCond,new ArrayList<Dispositivos>());
                CondAct.get(newCond).add(disp);
            }
            return newCond;
    }

    public void listar(){
        List<String> oplis=Arrays.asList("Habitacion","Tipo de dispositivo","Condición");
                    String opcL;
                    opcL=menu.selec(oplis, "Opciones para listar");
                    if(opcL=="Habitacion")
                        listarHT(menu.selec(habitacion,"Seleccione la habitación:"),1);
                    if(opcL=="Tipo de dispositivo")
                        listarHT(menu.selec(dispositivos,"Dispositivos encontrados:"),2);
                    if(opcL=="Condición"){
                        oplis.clear();oplis.addAll(CondAct.keySet());
                        listarCD(menu.selec(oplis,"Condiciones disponibles:"));
                    }
    }
    public void listarHT(String opc,int k){
        String sb ="\tDispositivos en la casa:\n";
        switch (k) {
            case 1:
            for(ArrayList<Dispositivos> i:dis){
                for(Dispositivos j: i){
                    if(j.getHabitacion()==opc)
                        sb+=j.toString();
                }
            }
                break;
                case 2:
                for(ArrayList<Dispositivos> i:dis){
                    for(Dispositivos j: i){
                        if(j.getTipo()==opc)
                        sb+=j.toString();
                    }
                }
                    break;
        }
        JOptionPane.showMessageDialog(null, sb);
    }

    public void listarCD(String opc){
        String sb ="\tDispositivos en la casa:\n";
        for(Dispositivos i: CondAct.get(opc))
            sb+=i.toString();
        JOptionPane.showMessageDialog(null, sb,"Listado por condición",0);
    }

    public void buscarDispositivos(String apodo){
        for(ArrayList<Dispositivos> i:dis){
            for(Dispositivos j: i){
                if(j.getTipoApodo().split(" ")[0]==apodo){
                    JOptionPane.showMessageDialog(null, j.toString(),"Resultado de la busqueda",1);
                    return;
                }
            }
        }
        JOptionPane.showMessageDialog(null, "No existe dispositivo con ese nombre","Resultado de la busqueda",1);
    }   
}
