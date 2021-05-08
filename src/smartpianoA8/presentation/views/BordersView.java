package smartpianoA8.presentation.views;

import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;

public class BordersView {

    /*Classe on inicialitzarem els borders*/
    /*IniciView*/
    /*Barra lateral botons*/
    private final LineBorder IniciViewButtonLineBorder = new LineBorder(new Color(249,171,15,1),0);
    private final EmptyBorder IniciViewButtonEmptyBorder = new EmptyBorder(0,5,0,0);
    private final CompoundBorder IniciViewButtonBorder = new CompoundBorder(IniciViewButtonEmptyBorder,IniciViewButtonLineBorder);


    /*Register and Login*/
        /*------------------------------------------PART INFERIOR------------------------------------------*/
            private final LineBorder OmplirSouthPrincipalBorder = new LineBorder(new Color(0,0,0,1),90);
        /*------------------------------------------PART CENTRAL------------------------------------------*/
            private final LineBorder OmplirEstBorder = new LineBorder(new Color(0,0,0,1),90);
            private final LineBorder OmplirOestBorder = new LineBorder(new Color(0,0,0,1),85);
            /*-------------Part Centre-Est-------------*/
            public static final LineBorder TextFieldBorder = new LineBorder(new Color(255,255,255),2);
            private final LineBorder ButtonTextBorder = new LineBorder(new Color(255,255,255,0),0);

            private final EmptyBorder EntreTextFieldBorder = new EmptyBorder(10,0,10, 0);
            private final EmptyBorder EntreButtonButtonBorder = new EmptyBorder(0,0,10,0);

            /*-------------Part Centre-Oest-------------*/
            private final EmptyBorder TopButtonBorder = new EmptyBorder(175,0,10,0);
            private final EmptyBorder EntreButtonBorder = new EmptyBorder(7,0,7, 0);
            private final LineBorder FacebookButtonBorder = new LineBorder(new Color(0,0,0,1),0);
            private final LineBorder GoogleButtonBorder = new LineBorder(new Color(0,0,0,1),0);
            private final LineBorder ButtonLineBorder = new LineBorder(new Color(255,255,255,1),0);

    /*RegisterView*/
        /*------------------------------------------PART INFERIOR------------------------------------------*/
            private final LineBorder RegisterButtonLineBorder = new LineBorder(new Color(249,171,15),10);
            private final EmptyBorder RegisterButtonEmptyBorder = new EmptyBorder(0,60,0,60);
            private final CompoundBorder RegisterButtonBorder = new CompoundBorder(RegisterButtonEmptyBorder,RegisterButtonLineBorder);
        /*------------------------------------------PART CENTRAL------------------------------------------*/
            /*-------------Part Centre-Nord-------------*/
            private final EmptyBorder RegisterTitularBorder = new EmptyBorder(50,0,0,0);
            /*-------------Part Centre-Est-------------*/
            private final EmptyBorder RegisterTopTextFieldBorder = new EmptyBorder(100,0,10,0);

    /*LoginView*/
        /*------------------------------------------PART INFERIOR------------------------------------------*/
            private final LineBorder LoginButtonLineBorderInferior = new LineBorder(new Color(249,171,15),10);
            private final EmptyBorder LoginButtonEmptyBorderInferior = new EmptyBorder(0,55,0,55);
            private final CompoundBorder LoginButtonBorder = new CompoundBorder(LoginButtonEmptyBorderInferior,LoginButtonLineBorderInferior);
        /*------------------------------------------PART CENTRAL------------------------------------------*/
            /*-------------Part Centre-Est-------------*/
            private final EmptyBorder LoginTopTextFieldBorder = new EmptyBorder(150,0,10,0);
            /*-------------Part Centre-Oest-------------*/

    //MainView
    public static final int NavBar_EspaiEntreBotons = 40;

    /*GETTERS*/

    /*IniciView*/
    public Border getIniciViewButtonBorder(){

        return this.IniciViewButtonBorder;

    }
    /*Register and Login*/
    public Border getOmplirSouthPrincipalBorder(){

        return this.OmplirSouthPrincipalBorder;

    }
    public Border getOmplirEstBorder(){

        return this.OmplirEstBorder;

    }
    public Border getOmplirOestBorder(){

        return this.OmplirOestBorder;

    }

    public Border getButtonTextBorder(){

        return this.ButtonTextBorder;

    }
    public Border getEntreTextFieldBorder(){

        return this.EntreTextFieldBorder;

    }
    public Border getTopButtonBorder(){

        return this.TopButtonBorder;

    }
    public Border getEntreButtonBorder(){

        return this.EntreButtonBorder;

    }
    public Border getFacebookButtonBorder(){

        return this.FacebookButtonBorder;

    }
    public Border getGoogleButtonBorder(){

        return this.GoogleButtonBorder;

    }
    public Border getEntreButtonButtonBorder(){

        return this.EntreButtonButtonBorder;

    }
    public Border getButtonLineBorder(){

        return this.ButtonLineBorder;

    }
    /*RegisterView*/
    public Border getRegisterButtonBorder(){

        return this.RegisterButtonBorder;

    }
    public Border getRegisterTitularBorder(){

        return this.RegisterTitularBorder;

    }
    public Border getRegisterTopTextFieldBorder(){

        return this.RegisterTopTextFieldBorder;

    }
    /*LoginView*/
    public Border getLoginButtonBorder(){

        return this.LoginButtonBorder;

    }
    public Border getLoginTopTextFieldBorder(){

        return this.LoginTopTextFieldBorder;

    }



}
