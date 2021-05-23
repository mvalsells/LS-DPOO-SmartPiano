package smartpianoA8.persistence;

import org.apache.commons.io.FileUtils;
import smartpianoA8.business.entity.User;

import java.io.File;
import java.io.IOException;

public class FileDeletorImpl implements FileDeletor {

    public FileDeletorImpl() {}

    @Override
    public void removeUserSongsWhenDeletedUser(String user) {
        try {
            FileUtils.deleteDirectory(new File("resources/midiFiles/"+user));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeHMFileByUser(String user) {
        File file = new File("resources/hmFiles/"+user+".txt");
        FileUtils.deleteQuietly(file);
    }

}
