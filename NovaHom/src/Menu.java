import java.util.List;
import java.util.Objects;
import javax.swing.JOptionPane;

public class Menu {
    private int k;

    public int mostrar(List<String> menu, int i){
        do{
            String menuMos="";
            for (int j = 0; j < i-1; j++) {
                menuMos += menu.get(j)+" \n";
            }
            System.out.println(menuMos);
            k= Integer.parseInt(JOptionPane.showInputDialog(null,menuMos));
        }while(k<1 || k>i-2);
        return k;
    }
    
    public void selec(List<String>menu){
        Object selection = JOptionPane.showInputDialog(null,"Elija una opción",
    "Seleccion",JOptionPane.QUESTION_MESSAGE,null,menu.toArray(),null);
        //si se cierra la ventan o le da cancel el objecto selection es nulo por tanto verificar eso
        if(Objects.isNull(selection))
        JOptionPane.showMessageDialog(null,"opcion invalida!");
        else{
            JOptionPane.showMessageDialog(null,"opcion elegida: "+selection);
        } 
    }
}
