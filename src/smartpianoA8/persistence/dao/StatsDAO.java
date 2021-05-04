package smartpianoA8.persistence.dao;

import java.sql.Time;

public interface StatsDAO {

    void startupStats(String user);

    void updateNumReproduccions(Time hora, String user);
    void updateNumMinuts(Time hora, Time minutsAfegir, String user);
}
