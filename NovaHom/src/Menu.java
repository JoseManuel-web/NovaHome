import java.util.List;
import java.util.Objects;
import javax.swing.JOptionPane;

public class Menu {
    private int k;

    public int mostrar(/*List<*/String/*>*/ menu, int i,String title){
        do{
            /*String menuMos="";
            for (int j = 0; j < i-1; j++) {
                menuMos += menu.get(j)+" \n";
            }*/
            k= Integer.parseInt(JOptionPane.showInputDialog(null,menu/*Mos*/,title,1));
        }while(k<1 || k>i-1);
        return k;
    }
    
    public String selec(List<String>menu,String title){
        Object selection =JOptionPane.showInputDialog(null,"Elija una opción",
    title,JOptionPane.QUESTION_MESSAGE,null,menu.toArray(),null);
        //si se cierra la ventan o le da cancel el objecto selection es nulo por tanto verificar eso
        if(Objects.isNull(selection))
            return " ";
        return (String)selection;
    }

    public int selec(List<String>menu,String title,int i){
        Object selection = JOptionPane.showInputDialog(null,"Elija una opción",
    title,JOptionPane.QUESTION_MESSAGE,null,menu.toArray(),null);
        //si se cierra la ventan o le da cancel el objecto selection es nulo por tanto verificar eso
        if(Objects.isNull(selection))
            return 0;
        return (int)menu.indexOf(selection)+1;
    }
}