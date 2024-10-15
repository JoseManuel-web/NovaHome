import java.util.List;
import java.util.Objects;

import javax.swing.JOptionPane;

public class SenalDAct{
    private String sensor;
    private int condSen;
    public void setSensor(String sensor){
        this.sensor=sensor;
    }
    public void setCondSen(int condSen){
        this.condSen=condSen;
    }
    public String getSensor(){
        return sensor;
    }
    public int getcondSen(){
        return condSen;
    }
    //Manipular SenalDAct como String
    public String toString(){
        return sensor+" "+condSen;
    }
    //Manipular un String como SenalDAct
    public SenalDAct separCond(String union){
        SenalDAct d=new SenalDAct();
        String[] partUnion=union.split(" ");
        sensor=partUnion[0];
        condSen=Integer.parseInt(partUnion[1]);
        return d;
    }
    //Define la cond
    public String newSen(List<String> sensoresCon){
        Menu m=new Menu();
        //Crea la cond que va en el map CondAct de la forma "Sensor numCon"
        sensor=m.selec(sensoresCon, "selecciona un sensor");
        condSen=Integer.parseInt(JOptionPane.showInputDialog(null, "Condición"));
        return toString();
        
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof SenalDAct)) return false;
        SenalDAct other = (SenalDAct) obj;
        return Objects.equals(sensor, other.sensor) &&
               condSen == other.condSen;
    }

    @Override
    public int hashCode() {
        return Objects.hash(sensor, condSen);
    }
}