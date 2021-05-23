package smartpianoA8.persistence;

import smartpianoA8.presentation.views.customComponents.Tecla;

import java.util.HashMap;

public interface HashMapFile {
    void write(HashMap<Integer, Tecla> hmTeclas, String username);
    HashMap<Integer, Tecla> read(String username);
}
