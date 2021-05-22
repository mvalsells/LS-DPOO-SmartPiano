package smartpianoA8.presentation.views;

import smartpianoA8.business.entity.Song;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

/**
 *
 * Esta clase se encarga principalmente de mostrar el frame donde se encuentran los paneles asociados a la tabla de las canciones,
 * con toda la infomración de la canción.
 *
 * @author Marc Valsells, Pau Santacreu, Christian Hasko, Albert Garangou y Albert Clarimón.
 * @version 1/05/2021.
 */
public class JFSongsTable extends JFrame {

    private final String[] columnas = {"Nombre", "Autor", "Duración", "Fecha Publicación", "Usuario", "Publica"};

    /**
     * Contructor del JFSongsTable donde contiene todos los panels asociados a esta clase
     * @param songs  Parametro donde indica en el arraylist de canciones.
     */
    public JFSongsTable(ArrayList<Song> songs) {

        setTitle("Tabla Canciones Descargadas");
        setResizable(false);
        setLocationRelativeTo(null);
        setSize(600,350);
        setMinimumSize(new Dimension(600,350));
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setLocationRelativeTo(null);

        DefaultTableModel tableModel = new DefaultTableModel(columnas, 0);

        JTable tabla = new JTable(tableModel);

        JScrollPane jScrollPane = new JScrollPane(tabla);
        add(jScrollPane);

        for(int i = 0; i < songs.size(); i++) {
            Object[] song = {songs.get(i).getNom(), songs.get(i).getAutor(), songs.get(i).getDuracio(), songs.get(i).getDataEnregistrament(), songs.get(i).getNomUsuari(), "Public"};
            tableModel.addRow(song);
        }

        //add(tabla);

        setVisible(true);

    }//Cierre del método
}//Cierre de la clase
