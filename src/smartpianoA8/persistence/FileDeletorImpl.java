package smartpianoA8.persistence;

import org.apache.commons.io.FileUtils;
import smartpianoA8.business.entity.User;

import java.io.File;
import java.io.IOException;

public class FileDeletorImpl implements FileDeletor {

    public FileDeletorImpl() {}

    public void removeUserSongsWhenDeletedUser(User user) {
        try {
            FileUtils.deleteDirectory(new File("resources/midiFiles/"+user.getUsername()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
