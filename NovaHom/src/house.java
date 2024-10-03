import java.util.Arrays;
import java.util.List;

import javax.swing.JOptionPane;

public class house {
    public static void main(String[] args) {
        int opcion;
        Menu inicio= new Menu();
        List<String> menI=Arrays.asList("Ingrese una opción:","1) Listar dispositivos","2) Agregar dispositivo","3) Buscar dispositivo","4) Salir");
        int NmenI=menI.size();
        JOptionPane.showMessageDialog(null, "Bienvenid@ al gestor de una casa inteligente!");
        do { 
            opcion=inicio.mostrar(menI, NmenI);
            switch (opcion) {
                case 1:
                    
                    break;

                case 2:
                    Dispositivos d=new Dispositivos();
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
