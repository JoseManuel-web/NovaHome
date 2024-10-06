import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;

public class house {
    public static void main(String[] args) {
        List<String> habitacion=new ArrayList<>();
        habitacion.add("Recamara"/*Valore default totalmente alterables. NO inicializada con .asList ya que esta no se puede redimensionar*/);//Lista de habitaciones
        List<String> sensoresCon=Arrays.asList("Temperatura","Movimiento","Humedad"/*Agregar todos los que se quieran usar, hora no va aqui */);//Lista de sensores vinculables
        Map<String, ArrayList<String>> CondAct=new HashMap<>();//Cond:Elementos a activar con esa cond
        List<String> dispositivos=Arrays.asList("Televisor"/*Agregar el nombre de cada clase hija de disp..*/);//Lista de dispositivos creables
        configuracion cng=new configuracion();//Organizar el main varios metodos 
        int opcion;
        Menu inicio= new Menu();
        List<String> menI=Arrays.asList("Ingrese una opción:","1) Listar dispositivos","2) Agregar dispositivo","3) Buscar dispositivo","4) Salir");
        int NmenI=menI.size();
        JOptionPane.showMessageDialog(null, "Bienvenid@ al gestor de una casa inteligente!","Saludo",1);
        do { 
            opcion=inicio.mostrar(menI, NmenI,"Inicio");
            switch (opcion) {
                case 0:
                    return;
                case 1:
                    
                    break;

                case 2:
                    cng.crear(habitacion, CondAct, dispositivos,sensoresCon);
                    break;
                case 3:
                    
                    break;
                case 4:
                    
                    break;
                default:
                    throw new AssertionError();
            }
        } while (opcion !=4 );
    }
}
