package NovaHom;
import javax.swing.JOptionPane;

public class Televisor extends Reloj{
    
    public float programacion_Televisor(){
        float tv = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la hora de inicio del televisor:\nHora recomendada [HH:MM]"));
        return tv;
        tv = super.calcularHora();
    }


}
