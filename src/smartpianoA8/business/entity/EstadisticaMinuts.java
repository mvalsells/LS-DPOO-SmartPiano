package smartpianoA8.business.entity;

public class EstadisticaMinuts {
    private int minuts;
    private int segons;

    public EstadisticaMinuts(int minuts, int segons){
        this.minuts = minuts;
        this.segons = segons;
    }

    public int getMinutsDecimals(){
        return minuts + segons/60;
    }

    public int getMinuts(){
        return minuts;
    }

}
