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
        List<String> dispositivos=Arrays.asList("Televisor","Microondas","Luces"/*Agregar el nombre de cada clase hija de disp..*/);//Lista de dispositivos creables

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
                    //Caso listar
                    JOptionPane.showMessageDialog(null, cng.listarDispositivos(), "Listar de Dispositivos", JOptionPane.INFORMATION_MESSAGE);
                    break;

                case 2:
                    cng.crear(habitacion, CondAct, dispositivos,sensoresCon);
                    break;
                case 3:
                    //Buscar dispositivos
                    String nombreDisp = JOptionPane.showInputDialog(
                        null, 
                        "Ingrese el apodo del dispostivo a buscar",
                        "Busqueda de dispositivos",
                        JOptionPane.QUESTION_MESSAGE
                        );
                    JOptionPane.showMessageDialog(
                        null, 
                        cng.buscarDispositivos(nombreDisp), 
                        "Resultado de la busqueda",
                        JOptionPane.INFORMATION_MESSAGE
                        );
                    break;
                case 4:
                    Object[] nombreIngregrantes = {
                        "JOSE MANUEL CALDERON SANDOVAL",
                        "LUIS ALEJANDRO EMBA REYES",
                        "GUSTAVO LOPEZ LUNA",
                        "GUSTAVO FABIAL OLALDE"
                    };
                    JOptionPane.showMessageDialog(
                        null, 
                        nombreIngregrantes,
                        "Agradecimientos",
                        JOptionPane.INFORMATION_MESSAGE,
                        null
                        );
                    break;
                default:
                    throw new AssertionError();
            }
        } while (opcion !=4 );
    }
}