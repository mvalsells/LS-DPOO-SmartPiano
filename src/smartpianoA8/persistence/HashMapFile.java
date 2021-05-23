package smartpianoA8.persistence;

import smartpianoA8.presentation.views.customComponents.Tecla;

import java.util.HashMap;
/**
 * Classe per la creació i disseny del HashMap incrustat en un fitxer per les tecles del piano (keymapping)
 * @version 1.0
 * @author Pau Santacreu, Albert Clarimont, Marc Valsells, Christian Hasko i Albert Garangou
 */
public interface HashMapFile {
    /**
     * Mètode per escriure al fitxer amb:
     * @param hmTeclas tecla a editar la tecla física del PC
     * @param username nom d'usuari a modificar
     */
    void write(HashMap<Integer, Tecla> hmTeclas, String username);
    HashMap<Integer, Tecla> read(String username);
}
