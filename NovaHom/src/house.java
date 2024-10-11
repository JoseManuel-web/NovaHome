import javax.swing.JOptionPane;

public class house {
    public static void main(String[] args) {
        configuracion cng=new configuracion();//Organizar el main varios metodos 
        int opcion;
        Menu inicio= new Menu();
        String[] menI={"Ingrese una opción:","1) Listar dispositivos",
        "2) Agregar dispositivo","3) Buscar dispositivo","4) Salir"};
        int NmenI=menI.length;
        JOptionPane.showMessageDialog(null, "Bienvenid@ al gestor de una casa inteligente!",
        "Saludo",1);
        do { 
            opcion=inicio.mostrar(menI, NmenI-1,"Inicio");
            switch (opcion) {
                case 0:
                    return;
                case 1:
                    //Caso listar
                    cng.listar();
                    break;

                case 2:
                    cng.crear();
                    break;
                case 3:
                    //Buscar dispositivos para revisar o modificar
                    cng.buscarDispositivos();
                    break;
                case 4:
                    String[] nombreIngregrantes = {
                        "JOSE MANUEL CALDERON SANDOVAL\n",
                        "LUIS ALEJANDRO EMBA REYES\n",
                        "GUSTAVO LOPEZ LUNA\n",
                        "GUSTAVO FABIAL OLALDE\n"
                    };
                    JOptionPane.showMessageDialog(
                        null, 
                        nombreIngregrantes,
                        "Agradecimientos",
                        JOptionPane.INFORMATION_MESSAGE,
                        null
                        );
                    break;
                default:
                    throw new AssertionError();
            }
        } while (opcion !=4 );
    }
    /*Randoms que usando lCond[i].setCondSen==rand
     * if(true)
     * for(Dispositivos i:CondAct(lCond[1]))
     *      i.activar();
     * 
     */
}