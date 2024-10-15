import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;

public class configuracion {
    private List<String> habitacion=new ArrayList<>();
    private List<String> sensoresCon=Arrays.asList("Temperatura","Movimiento","Humedad"/*Agregar todos los que se quieran usar, hora no va aqui */);//Lista de sensores vinculables
    private Map<SenalDAct, ArrayList<Dispositivos>> CondAct=new HashMap<>();//Cond:Elementos a activar con esa cond
    private List<String> dispositivos=Arrays.asList("Televisor","Microondas","Luces"/*Agregar el nombre de cada clase hija de disp..*/);//Lista de dispositivos creables
    private ArrayList<String> lCond=new ArrayList<>();
    private Menu menu=new Menu();
    private int opc;
    private String apodo;
    private ArrayList<Dispositivos> dis=new ArrayList<>();
    
    configuracion(){
        habitacion.add("Recamara"/*Valore default totalmente alterables. NO inicializada con .asList ya que esta no se puede redimensionar*/);//Lista de habitaciones
        for(SenalDAct i: CondAct.keySet())
        lCond.add(i.toString());
    }

    public void crear(){
        opc=menu.selec(dispositivos, "Dispositivo a crear",1);
        apodo=(String)JOptionPane.showInputDialog(null, "Nombra el dispositivo","Nuevo dispositivo",1);
        switch (opc) {
            case 1:
                apodo+=" (Televisor)";
                dis.addLast(new Dispositivos(habitacion, CondAct, apodo, sensoresCon,lCond));
                break;
            case 2:
                apodo += " (Microondas)";
                dis.add(new Dispositivos(habitacion, CondAct, apodo, sensoresCon, lCond));
                break;
            case 3:
                apodo += " (Luces)";
                dis.add (new Dispositivos(habitacion,CondAct,apodo, sensoresCon, lCond));
                break;
        }
        //System.out.println(habitacion);
        //System.out.println(CondAct);
        //System.out.println(lCond);
        //System.out.println(dis);
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
                        oplis.clear();oplis.addAll(lCond);
                        listarCD(menu.selec(oplis,"Condiciones disponibles:"));
                    }
    }
    public void listarHT(String opc,int k){
        String sb ="\tDispositivos en la casa:\n";
        switch (k) {
            case 1:
            for(Dispositivos i:dis){
                if(i.getHabitacion()==opc)
                    sb+=i.toString();
                }
                break;
                case 2:
                for(Dispositivos i:dis){
                    if(i.getTipo()==opc)
                        sb+=i.toString();
                    }
                    break;
        }
        JOptionPane.showMessageDialog(null, sb);
    }

    public void listarCD(String opc){
        String sb ="\tDispositivos en la casa:\n";
        SenalDAct oAct=new SenalDAct().separCond(opc);
        for(Dispositivos i: CondAct.get(oAct))
            sb+=i.toString();
        JOptionPane.showMessageDialog(null, sb,"Listado por condición",0);
    }

    public void buscarDispositivos(){
        String apodo = JOptionPane.showInputDialog(
        null, 
        "Ingrese el nombre del dispostivo a buscar",
        "Busqueda de dispositivos",
        JOptionPane.QUESTION_MESSAGE
        );
        for(Dispositivos i:dis){
            if(i.getTipoApodo().split(" ")[0]==apodo){
                String[] opD={"Modificar","Salir"};
                int editD=JOptionPane.showOptionDialog(null, i.toString(),"Resultado de la busqueda",JOptionPane.OK_CANCEL_OPTION,1,null,opD,opD[1]);
                if(editD==1)
                    modificarD(i);
                return;
                }
            }
        JOptionPane.showMessageDialog(null, "No existe dispositivo con ese nombre","Resultado de la busqueda",1);
    }   

    public void modificarD(Dispositivos i){
        String[] opD={"Borrar/Agregar condición","Nombre","Habitación"};
        String mod=menu.selec(opD,"Modificando "+i.getTipoApodo(),opD.length);
        switch(mod){
            case "Borrar/Agregar Condición":
                String[] bA={"Agregar","Borrar"};
                    int editD=JOptionPane.showOptionDialog(null, i.toString(),"Resultado de la busqueda",
                    JOptionPane.OK_CANCEL_OPTION,1,null,bA,bA[1]);
                    if(editD==0)
                        i.initCon(CondAct, sensoresCon, lCond);
                    if(editD==1){
                        if(i.setSig().isEmpty())
                            return;
                        SenalDAct condDelet=new SenalDAct().separCond(menu.selec(i.setSig(), "Condición a eliminar:"));
                        i.setSig().remove(condDelet.toString());
                        CondAct.get(condDelet).remove(i);
                    }
                break;
            case "Nombre":
                i.setApodo(JOptionPane.showInputDialog(null, "Nuevo nombre"));
            break;
            case "Habitación":
                i.initH(habitacion);
        }
    }
}
