package smartpianoA8.persistence.dao;

import java.sql.Time;

public interface StatsDAO {

    void startupStats(String user);

    void updateNumReproduccions(int hora, String user);
    void updateNumMinuts(int hora, Time tempsAfegir, String user);
}
