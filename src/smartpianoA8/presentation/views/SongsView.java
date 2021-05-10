package smartpianoA8.presentation.views;

import smartpianoA8.business.entity.Song;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.util.ArrayList;

public class SongsView extends JFrame {

    private final String[] columnas = {"Nombre", "Autor", "Duración", "Fecha Publicación", "Usuario", "Publica"};

    public SongsView(ArrayList<Song> songs) {

        setTitle("Tabla Canciones Descargadas");
        setResizable(false);
        setLocationRelativeTo(null);
        setSize(600,350);
        setMinimumSize(new Dimension(600,350));
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

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

    }
}
