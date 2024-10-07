import java.util.*;
public class Validar {
    private Scanner sc=new Scanner(System.in);
    private int i;

    //Metodos
    public int valiNum(String x){
        int y=0;
        i=0;
        do{
            if(i==2)
                x=sc.nextLine();
            try{
                y=(int)Integer.parseInt(x);
                i=1;
            }catch(NumberFormatException e){
                System.out.println("Debes escribir caracteres numericos");
                i=2;
            }
        }while(i==0 || i==2);
        return y;
    }
}