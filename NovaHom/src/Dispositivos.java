import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JOptionPane;

public class Dispositivos{
    //Variables
    private Menu cond= new Menu();
    private List<String> menC=Arrays.asList("Por hora","Señal de un sensor");
    //private int NmenC=menC.size();
    private int opcCond;
    private Menu menInitDis=new Menu();
    private List<String> menIn=new ArrayList<>();
    private String opc;
    protected String habitacion;//Del dispositivo
    protected SenalDAct sig=new SenalDAct();//Condiciones de activación del dispositivo
    protected String newHab,newCond;
    protected String tipoApodo;//Identificadores del dispositivo {TipoDClaseHija,ApodoIdentificadorDelUsuario}

    //Constructores
    Dispositivos(List<String> habitacion, Map<String,ArrayList<String>> CondAct,String tipoApodo){
        this.tipoApodo=tipoApodo;
        InitDis(habitacion,CondAct);
    }


    public void AddCond(Map<String,ArrayList<String>> CondAct) {
        //Permite al usuario seleccionar la condición de activación del dispositivo entre las existentes o crear una
        Reloj reloj=new Reloj();
        menIn.clear();
        menIn.addAll(CondAct.keySet());menIn.add("Otro");
        opc=menInitDis.selec(menIn,"Seleccione una condicion");
        //Ya existe y no esta establecida para ese dispositivo
        if(opc=="")
            return;
        if(opc!="Otro" && !sig.getSennal().contains(opc)){
            sig.setSennal(opc);
            CondAct.get(opc).add(tipoApodo);
            
        }else{
            opcCond=cond.selec(menC,"Tipo de Condición",1);
            switch (opcCond) {
                case 0:
                    return;
                case 1:
                    newCond=reloj.condH();
                    break;
                case 2:
                    newCond=(String)JOptionPane.showInputDialog(null, "Nombra la condición","Nueva condición",1);
                    break;
                case 3:
                    return;
                default:
                    break;
            }
            if(!menIn.contains(newCond) || !sig.getSennal().contains(newCond)){
                //null tipo
                sig.setSennal(newCond);    
                System.out.println(sig.getSennal().get(sig.getSennal().size()-1));
                if(CondAct.isEmpty())
                    CondAct.put(sig.getSennal().get(sig.getSennal().size()-1),new ArrayList<String>());
                
                CondAct.get(newCond).add(tipoApodo);
                System.out.println(CondAct);
                System.out.println(tipoApodo);
            }
        }
    }
    public void moverhab(List<String> habitacion){
        //Permite al usuario seleccionar la habitación en la que se encuentra el dispositivo
        menIn.addAll(habitacion); menIn.add("Otro");
        opc=menInitDis.selec(menIn,"Seleccione una habitación");
        if(opc=="")
            return;
        if(opc=="Otro"){
            newHab=(String)JOptionPane.showInputDialog(null, "Nombra la habitación","Nueva habitación",1);
            if(!menIn.contains(newHab))
                habitacion.add(newHab);
            this.habitacion=newHab;
        }else
            this.habitacion=opc;
    }
    public void InitDis(List<String> habitacion, Map<String,ArrayList<String>> CondAct){
        moverhab(habitacion);
        AddCond(CondAct);
    }
}
