package smartpianoA8.persistence;

import java.io.FileNotFoundException;

public interface JsonReadable {

    /**
     *
     * @return
     */
    public String getDbName();

    /**
     *
     * @return
     */
    public String getDbAddress();

    /**
     *
     * @return
     */
    public int getDbPort();

    /**
     *
     * @return
     */
    public String getDbUser();

    /**
     *
     * @return
     */
    public String getDbPassword();

    /**
     *
     * @return
     */
    public int gettimeScrapping();

    /**
     *
     * @throws FileNotFoundException
     */
    public void readJsonConfig() throws FileNotFoundException;

}
