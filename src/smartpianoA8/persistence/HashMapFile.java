package smartpianoA8.persistence;

import smartpianoA8.presentation.views.customComponents.Tecla;

import java.util.HashMap;
/**
 * Classe per la creació i disseny del HashMap incrustat en un fitxer per les tecles del piano (keymapping)
 * @version 1.0
 * @author Pau Santacreu, Albert Clarimont, Marc Valsells, Christian Hasko i Albert Garangou
 */
public interface HashMapFile {
    void write(HashMap<Integer, Tecla> hmTeclas, String username);
    HashMap<Integer, Tecla> read(String username);
}
