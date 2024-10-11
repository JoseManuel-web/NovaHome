import javax.swing.JOptionPane;

public class Reloj {
    private int hora;

    public String condH(){
        String horaAperturaStr = JOptionPane.showInputDialog("Introduce la hora de apertura (formato 24h, ej. 08:00):");
        String[] partes = horaAperturaStr.split(":");
        hora=Integer.parseInt(partes[0])*1000+ Integer.parseInt(partes[1]);
        return "Hora "+partes;
    }
    public boolean activar(String senal,int act){
        if(senal!="Hora")
            return false;
        if(hora==act)
            return true;
        return false;
    }
}
/*
 * Debe permitir seleccionar una hora de activacion  HH:MM->int HHMM y devolver de la forma "Hora HHMM"
 */