package NovaHom;
import javax.swing.JOptionPane;

public class house {
    public static void main(String[] args) {
        int opcion, user = 0;
        JOptionPane.showMessageDialog(null, "Bienvenid@ al gestor de una casa inteligente!");
        Dispositivo menu = new Dispositivo(user);
        do { 
            opcion = menu.capturarProgramar(user);
            switch (opcion) {
                case 1:
                    Televisor dispositivo = new Televisor();
                    dispositivo.programacion_Televisor();
                break;

                case 2:
                    
                break;

                case 4:
                    user = user.capturarUser();
                break;
                default:
                    throw new AssertionError();
            }
        } while (opcion !=4 );
    }
}
