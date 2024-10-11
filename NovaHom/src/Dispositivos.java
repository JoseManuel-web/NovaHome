import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;

public class Dispositivos{
    //Variables
    private Menu menInitDis=new Menu();
    private List<String> menIn=new ArrayList<>();//Creado porque CondAct.getKey() devuelve un set<String>(no se que es eso) y los met. de menu reciben List BORRAR ANTES DE LA ENTREGA
    private String opc;
    private String habitacion;//Del dispositivo
    private List<String> sig=new ArrayList<>();//Condiciones de activación del dispositivo
    private String tipoApodo;//Identificadores del dispositivo {ApodoIdentificadorDelUsuario (TipoDClaseHija)}
    private boolean estado;
    private List<String> menC=Arrays.asList("Por hora","Señal de un sensor");
    private int opcCond;
    private String newCond;
    private Reloj reloj=new Reloj();
    private SenalDAct s=new SenalDAct();
    private String newHab;

    //Constructores
    Dispositivos(List<String> habitacion, Map<SenalDAct,ArrayList<Dispositivos>> CondAct,String tipoApodo,List<String> sensoresCon, ArrayList<String> lCond){
        this.tipoApodo=tipoApodo;
        InitDis(habitacion,CondAct,sensoresCon, lCond);
    }

    //Metodos principales
    public void InitDis(List<String> habitacion, Map<SenalDAct,ArrayList<Dispositivos>> CondAct,List<String> sensoresCon, ArrayList<String> lCond){
        initH(habitacion);
        initCon(CondAct,sensoresCon,lCond);
    }
    public void initCon(Map<SenalDAct,ArrayList<Dispositivos>> CondAct,List<String> sensoresCon,ArrayList<String> lCond) {
        //Permite al usuario seleccionar la condición de activación del dispositivo entre las existentes o crear una
        menIn.clear();
        menIn.addAll(lCond);menIn.add("Otro");
        opc=menInitDis.selec(menIn,"Seleccione una condicion");
        //No seleciono nada
        if(opc==" ")
            return;
        //Ya existe y no esta establecida para ese dispositivo
        if(opc!="Otro" && !sig.contains(opc)){
            sig.add(opc);
            SenalDAct s=new SenalDAct().separCond(opc);
            CondAct.get(s).add(this);
        }else//No existe
            opcCond=menInitDis.selec(menC,"Tipo de Condición",1);
            switch (opcCond) {
                case 0:
                    return;
                case 1:
                    newCond="Reloj "+reloj.condH();
                    break;
                case 2:
                    newCond=s.newSen(sensoresCon);
                    break;
                default:
                    break;
                }
            //Si la newCond no esta en CondAct o no esta en sig crea el elemento en el map CondAct
            if(!sig.contains(newCond)){
                sig.add(newCond);
                SenalDAct nSDA=new SenalDAct().separCond(newCond);
                if(!lCond.contains(newCond))
                    CondAct.put(nSDA,new ArrayList<Dispositivos>());
                CondAct.get(nSDA).add(this);
            }
            //si dio cancelar dentro del AddCond 
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
        if(opc=="Otro"){
            newHab=JOptionPane.showInputDialog(null, "Nombra la habitación","Nueva habitación",1);
            //Si la habitación escrita no existe la guarda en el list habitacion
            if(!habitacion.contains(newHab))
                habitacion.add(newHab);
            this.habitacion=newHab;//Regresa para registrar en el dispositivo
        }
        else
            //La habitación ya existia
            this.habitacion=opc;
    }
    //activa el dispositivo
    public void activar(boolean act){
        estado=act;
        /*Aviso de encendido */
    }

    //Metodos complementarios
    public String getTipoApodo(){
        return tipoApodo;
    }
    public void setApodo(String apodo){
        tipoApodo=apodo+" "+tipoApodo.split(" ")[1];
    }
    public List<String> setSig(){
        return sig;
    }
    public String getHabitacion(){
        return habitacion;
    }
    public String getTipo(){
        String tipo=tipoApodo.split(" ")[1];
        tipo=tipo.substring(1, tipo.indexOf(")"));
        return tipo;
    }
    public String toString() {
        return "Dispositivo: " + tipoApodo + "\nHabitación: " + habitacion + "\nEstado: " + (estado ? "Encendido" : "Apagado")+"\n";
    }
}
