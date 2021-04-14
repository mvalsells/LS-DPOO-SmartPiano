package smartpianoA8.persistence;

public interface Readable {

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

}
