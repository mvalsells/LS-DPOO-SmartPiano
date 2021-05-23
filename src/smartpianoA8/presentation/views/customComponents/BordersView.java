package smartpianoA8.presentation.views.customComponents;

import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;

/**
 * Calsse de marges personalitzats pel projecte. Es recullen mèotdes per modificar el marge/border utilitat i adaptar-lo cada cop a un component que el necessiti
 * @version 1.0
 * @author Pau Santacreu, Albert Clarimont, Marc Valsells, Christian Hasko i Albert Garangou
 */
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

    /*JPRegisterView*/
        /*------------------------------------------PART INFERIOR------------------------------------------*/
            private final LineBorder RegisterButtonLineBorder = new LineBorder(new Color(249,171,15),10);
            private final EmptyBorder RegisterButtonEmptyBorder = new EmptyBorder(0,60,0,60);
            private final CompoundBorder RegisterButtonBorder = new CompoundBorder(RegisterButtonEmptyBorder,RegisterButtonLineBorder);
        /*------------------------------------------PART CENTRAL------------------------------------------*/
            /*-------------Part Centre-Nord-------------*/
            private final EmptyBorder RegisterTitularBorder = new EmptyBorder(50,0,0,0);
            /*-------------Part Centre-Est-------------*/
            private final EmptyBorder RegisterTopTextFieldBorder = new EmptyBorder(100,0,10,0);

    /*JPLoginView*/
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

    public static final int NavPlayer_Space = 30;

    /*GETTERS*/

    /*IniciView*/

    /**
     * Mètode per iniciar un border per botons
     * @return Border en questió a obtenir
     */
    public Border getIniciViewButtonBorder(){

        return this.IniciViewButtonBorder;

    }
    /*Register and Login*/

    /**
     * Mètode per obtenir un border per redistribuir l'espai de la pantalla del login i registre a la part sod i no utilitzar l'espai
     * Eleva els elements més amunt del límit inferior
     * @return Border en questió
     */
    public Border getOmplirSouthPrincipalBorder(){

        return this.OmplirSouthPrincipalBorder;

    }

    /**
     * Mètode per obtenir un border per redistribuir i omplir l'espai de la dreta (est) i deixar un marge per no utilitar-lo
     * @return  Border en questió
     */
    public Border getOmplirEstBorder(){

        return this.OmplirEstBorder;

    }

    /**
     * Mètode per obtenir un border per redistribuir i omplir l'espai de l'esquerra (oest) i deixar un marge per no utilitar-lo
     * @return  Border en questió
     */
    public Border getOmplirOestBorder(){

        return this.OmplirOestBorder;

    }

    /**
     * Mètode per obtenir el border dels botons amb només text a dins
     * @return el Border en questió
     */
    public Border getButtonTextBorder(){

        return this.ButtonTextBorder;

    }

    /**
     * Mètode per obtenir un border pels requadres on s'hi introdueix text
     * @return el Border en questió
     */
    public Border getEntreTextFieldBorder(){

        return this.EntreTextFieldBorder;

    }

    /**
     * Mètode per obtenir un border pel botó de canvi entre Login i Register
     * @return el Border en questió
     */
    public Border getTopButtonBorder(){

        return this.TopButtonBorder;

    }

    /**
     * Mèotde per obtenir un border pel botó d'entrar i accedir
     * @return el border en questió
     */
    public Border getEntreButtonBorder(){

        return this.EntreButtonBorder;

    }

    /**
     * Mètode per obtenir un border pel botó de register amb facebook
     * @return el border en questió
     */
    public Border getFacebookButtonBorder(){

        return this.FacebookButtonBorder;

    }

    /**
     * Mèotde per obtenir un border pel botó de register amb google
     * @return el border en questió
     */
    public Border getGoogleButtonBorder(){

        return this.GoogleButtonBorder;

    }

    /**
     * Mètode per obtenir un border per la zona interior (emplenada de color) del botó de login
     * @return el border en questió
     */
    public Border getEntreButtonButtonBorder(){

        return this.EntreButtonButtonBorder;

    }

    /**
     * Mètode per obtenir un border per la zona inferior de la vista de login i register
     * @deprecated es substitueix amb getOmplirSouthPrincipalBorder()
     * @return el border en questió
     */
    public Border getButtonLineBorder(){

        return this.ButtonLineBorder;

    }
    /*JPRegisterView*/

    /**
     * Mètode per obtenir el border del botó de registrar-se
     * @return el border en questió
     */
    public Border getRegisterButtonBorder(){

        return this.RegisterButtonBorder;

    }

    /**
     * Mètode per obtenir el border de la barra de títol/text de registrar-se
     * @return el border en questió
     */
    public Border getRegisterTitularBorder(){

        return this.RegisterTitularBorder;

    }

    /**
     * Mètode per obtenir el border del quadre de text més superior (amb espai per sobre) dels camps de text de registrar-se
     * @return el border en questió
     */
    public Border getRegisterTopTextFieldBorder(){

        return this.RegisterTopTextFieldBorder;

    }
    /*JPLoginView*/

    /**
     * Mèotde per obtenir el border pel botó de logguejar-se
     * @return el border en questió
     */
    public Border getLoginButtonBorder(){

        return this.LoginButtonBorder;

    }

    /**
     * Mètode per obtenir el border del quadre de text més superior (amb espai per sobre) dels camps de text de loguejar-se
     * @return el border en questió
     */
    public Border getLoginTopTextFieldBorder(){

        return this.LoginTopTextFieldBorder;

    }
}
