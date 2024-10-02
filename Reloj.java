
package NovaHom;
import java.util.Calendar;
import javax.swing.JOptionPane;

public class Reloj {
    private float horaAlarma;
    private float minutoAlarma;

    public Reloj (float horaAlarma, float minutoAlarma){
        this.horaAlarma = horaAlarma;
        this.minutoAlarma = minutoAlarma;
    }

    public void calcularHora(float horaAlarma, float minutoAlarma){
        
        Calendar horaActual = Calendar.getInstance();
        int hora = horaActual.get(Calendar.HOUR_OF_DAY);
        int minuto = horaActual.get(Calendar.MINUTE);
 
        this.horaAlarma = horaAlarma;
        this.minutoAlarma = minutoAlarma;

        String valorHora = JOptionPane.showInputDialog(null, "Ingrese un número decimal:");
        
        // Convertir la cadena a un número de punto flotante
        float valorFloat = Float.parseFloat(valorString);
        
        // Mostrar el valor ingresado
        JOptionPane.showMessageDialog(null, "El valor ingresado es: " + valorFloat);
        int diferenciaMinutos = (horaAlarma * 60 + minutoAlarma) - (hora * 60 + minuto);

        JOptionPane.showMessageDialog(null, "La activacion de ");
        System.out.println("La alarma se activará en aproximadamente " + diferenciaMinutos + " minutos.");
    }
}