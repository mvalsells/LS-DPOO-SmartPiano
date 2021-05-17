package smartpianoA8.presentation.views.customComponents;

public class Teclas {

    public final static boolean defaultIsPlaying = false;
    public final static boolean trueIsPlaying = true;

    //
    private int nota;
    private boolean isPlaying;


    public Teclas(/*String code,*/int nota){

        //this.code = code;
        this.nota = nota;
        this.isPlaying = defaultIsPlaying;
    }

    public int getNota(){return this.nota; }
    public void setIsPlaying(boolean b){this.isPlaying=b;};
    public boolean isPlaying(){return this.isPlaying;};

}
