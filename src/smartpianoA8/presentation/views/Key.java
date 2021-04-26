package smartpianoA8.presentation.views;

public interface Key {
    // change WD to suit your screen
    int WD = 23;
    int HT = (WD * 10) / 2;
    // change baseNote for starting octave
    // multiples of 16 only
    int baseNote = 48;

    int getNote ();
}
