import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Dispositivos{
    //Variables
    private configuracion cng= new configuracion();
    private Menu menInitDis=new Menu();
    private List<String> menIn=new ArrayList<>();//Creado porque CondAct.getKey() devuelve un set<String>(no se que es eso) y los met. de menu reciben List BORRAR ANTES DE LA ENTREGA
    private String opc;
    private String habitacion;//Del dispositivo
    private List<String> sig=new ArrayList<>();//Condiciones de activación del dispositivo
    private String newCond;
    private String tipoApodo;//Identificadores del dispositivo {ApodoIdentificadorDelUsuario (TipoDClaseHija)}
    private boolean estado;
    private String tipo;

    //Constructores
    Dispositivos(List<String> habitacion, Map<String,ArrayList<Dispositivos>> CondAct,String tipoApodo,List<String> sensoresCon){
        this.tipoApodo=tipoApodo;
        InitDis(habitacion,CondAct,sensoresCon);
    }

    //Metodos
    public void initCon(Map<String,ArrayList<Dispositivos>> CondAct,List<String> sensoresCon) {
        //Permite al usuario seleccionar la condición de activación del dispositivo entre las existentes o crear una
        menIn.clear();
        menIn.addAll(CondAct.keySet());menIn.add("Otro");
        opc=menInitDis.selec(menIn,"Seleccione una condicion");
        //No seleciono nada
        if(opc==" ")
            return;
        //Ya existe y no esta establecida para ese dispositivo
            if(opc!="Otro" && !sig.contains(opc)){
            sig.add(opc);
            CondAct.get(opc).add(this);
        }else//No existe
            newCond=cng.AddCond(sig,tipoApodo,this);
            //si dio cancelar dentro del AddCond 
            if(newCond=="\n")
                return;
            sig.add(newCond);
    }
    public void initH(List<String> habitacion){
        //Permite al usuario seleccionar la habitación en la que se encuentra el dispositivo
        menIn.clear();
        menIn.addAll(habitacion); menIn.add("Otro");
        opc=menInitDis.selec(menIn,"Seleccione una habitación");
        //Dio cancelar
        if(opc==" ")
            return;
        //Crea una habitación nueva
        if(opc=="Otro")
            this.habitacion=cng.crearHab(habitacion);
        else
            //La habitación ya existia
            this.habitacion=opc;
    }
    public void InitDis(List<String> habitacion, Map<String,ArrayList<Dispositivos>> CondAct,List<String> sensoresCon){
        initH(habitacion);
        initCon(CondAct,sensoresCon);
    }
    
    public String getTipoApodo(){
        return tipoApodo;
    }
    public String getHabitacion(){
        return habitacion;
    }
    public String getTipo(){
        return tipo;
    }
    public String toString() {
        return "Dispositivo: " + tipoApodo + "\nHabitación: " + habitacion + "\nEstado: " + (estado ? "Encendido" : "Apagado")+"\n";
    }
}
