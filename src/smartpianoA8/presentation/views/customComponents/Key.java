package smartpianoA8.presentation.views.customComponents;

/**
 * Esta interficie se encarga de definir los parámetros de las notas, ya sea para la dimensión como para la cantidad
 *
 *
 * @author Marc Valsells, Pau Santacreu, Christian Hasko, Albert Garangou y Albert Clarimón.
 * @version 1/05/2021.
 */
public interface Key {
    // change WD to suit your screen
    int WD = 23;
    int HT = (WD * 10) / 2;
    // change baseNote for starting octave
    // multiples of 16 only
    int baseNote = 48;

    /**
     * Método que indica la nota que se ha pulsado.
     * @return La nota que se ha pulsado.
     */
    int getNote ();//Cierre del método
}//Cierre de la clase
