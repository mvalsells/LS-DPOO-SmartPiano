package smartpianoA8.persistence;

import smartpianoA8.business.entity.User;

public interface FileDeletor {

    public void removeUserSongsWhenDeletedUser(String user);
    public void removeHMFileByUser(String user);

}
