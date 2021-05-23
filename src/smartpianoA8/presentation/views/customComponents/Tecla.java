package smartpianoA8.presentation.views.customComponents;

/**
 * Esta clase se encarga de definir que constantes contendrá una tecla y posteriormente devolverlas.
 *
 *
 * @author Marc Valsells, Pau Santacreu, Christian Hasko, Albert Garangou y Albert Clarimón.
 * @version 1/05/2021.
 */

public class Tecla {

    public final static boolean defaultIsPlaying = false;
    public final static boolean trueIsPlaying = true;

    private int nota;
    private boolean isPlaying;

    /**
     * Constructor de la clase Tecla
     * @param nota Parámetro que indica que nota estamos usando
     */
    public Tecla(/*String code,*/int nota){

        //this.code = code;
        this.nota = nota;
        this.isPlaying = defaultIsPlaying;
    }//Cierre del constructor

    /**
     * Método que retorna la nota usada.
     * @return La nota usada.
     */
    public int getNota(){return this.nota; }//Cierre del método

    /**
     * Método que indica si la tecla está siendo usada
     * @param b Parámetro que indica si la tecla está siendo usada.
     */
    public void setIsPlaying(boolean b){this.isPlaying=b;};//Cierre del método

    /**
     * Método que indica si la tecla está siendo usada.
     * @return Si la tecla está siendo usada.
     */
    public boolean isPlaying(){return this.isPlaying;};//Cierre del método

    /**
     * Método que indica que nota esta usandose
     * @param nota Que nota esta usandose
     */
    public void setNota(int nota) {
        this.nota = nota;
    }//Cierre del método

    @Override
    public String toString() {
        return "Tecla{" +
                "nota=" + nota +
                ", isPlaying=" + isPlaying +
                '}';
    }
}//Cierre de la clase