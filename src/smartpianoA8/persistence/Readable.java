package smartpianoA8.persistence;

public interface Readable {

    public String getDbName();
    public String getDbAddress();
    public int getDbPort();
    public String getDbUser();
    public String getDbPassword();
    public int gettimeScrapping();

}