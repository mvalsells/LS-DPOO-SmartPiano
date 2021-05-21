package smartpianoA8.presentation.views.customComponents;

public class Tecla {

    public final static boolean defaultIsPlaying = false;
    public final static boolean trueIsPlaying = true;

    private int nota;
    private boolean isPlaying;


    public Tecla(/*String code,*/int nota){

        //this.code = code;
        this.nota = nota;
        this.isPlaying = defaultIsPlaying;
    }

    public int getNota(){return this.nota; }
    public void setIsPlaying(boolean b){this.isPlaying=b;};
    public boolean isPlaying(){return this.isPlaying;};

    public void setNota(int nota) {
        this.nota = nota;
    }
}