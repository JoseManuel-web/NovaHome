import java.util.List;

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
    public String unionCond(SenalDAct a){
        return a.getSensor()+a.getcondSen();
    }
    //Manipular un String como SenalDAct
    public SenalDAct separCond(String union){
        SenalDAct d=new SenalDAct();
        String[] partUnion=union.split(" ");
        d.setSensor(partUnion[0]);
        d.setCondSen(Integer.parseInt(partUnion[1]));
        return d;
    }
    //Define la cond
    public String newSen(List<String> sensoresCon){
        Menu m=new Menu();
        //Crea la cond que va en el map CondAct de la forma "Sensor numCon"
        return m.selec(sensoresCon, "selecciona un sensor")+" "+Integer.parseInt(JOptionPane.showInputDialog(null, "Condición;"));
        
    }
    //activa el dispositivo
    public boolean activar(String senal,int act){
        if(separCond(senal).getcondSen()==act)
            return true;
        return false;
    }
}